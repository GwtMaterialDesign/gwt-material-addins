/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.infinitescroll;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.AbstractAddinsWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.client.data.DataSource;
import gwt.material.design.client.data.loader.LoadCallback;
import gwt.material.design.client.data.loader.LoadConfig;
import gwt.material.design.client.data.loader.LoadResult;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.events.*;
import gwt.material.design.incubator.client.infinitescroll.recycle.RecycleManager;
import gwt.material.design.incubator.client.infinitescroll.recycle.RecyclePosition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static gwt.material.design.client.js.JsMaterialElement.$;

//@formatter:off

/**
 * Infinite scrolling, sometimes called endless scrolling, is a technique that allowing users to scroll through a
 * massive chunk of content with no finishing-line in sight. This technique simply keeps refreshing a page when you
 * scroll down it.
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 *
 * @author kevzlou7979
 */
public class InfiniteScrollPanel<T> extends AbstractAddinsWidget implements HasInfiniteScrollHandlers<T> {

    static {
        IncubatorWidget.showWarning(InfiniteScrollPanel.class);
    }

    private static final String INFINITE_SCROLL_PANEL = "infinite-scroll-panel";
    private InfiniteScrollLoader loader;
    private DataSource<T> dataSource;
    private InfiniteScrollLoadConfig loadConfig;
    private Renderer<T> renderer;
    private RecycleManager recycleManager;
    private int offset = 0;
    private int limit = 0;
    private int bufferTop = 20;
    private int bufferBottom = 20;
    private boolean completed;
    private int itemCount = 1;

    public InfiniteScrollPanel() {
        super();

        setStyleName(INFINITE_SCROLL_PANEL);
    }

    public InfiniteScrollPanel(DataSource<T> dataSource, InfiniteScrollLoadConfig loadConfig) {
        this();

        this.dataSource = dataSource;
        this.loadConfig = loadConfig;
    }

    @Override
    protected void internalLoad() {
        // Will setup the scroll events to determine if scrolls top / bottom.
        $(getElement()).scroll((e, param1) -> {
            if (!isLoading()) {
                if (getElement().getScrollTop() <= bufferTop) {
                    onScrollTop();
                }

                if (getElement().getScrollTop() >= ((getElement().getScrollHeight()) - getElement().getOffsetHeight()) - bufferBottom) {
                    onScrollBottom();
                }
            }
            return false;
        });

        // Will register all initial event handlers
        registerHandler(addLoadingHandler(event -> loading(true)));
        registerHandler(addLoadedHandler(event -> {
            loading(false);
            render(event.getResult().getData());
        }));
        registerHandler(addCompleteHandler(event -> {
            loading(false);
            completed = true;
        }));

        load();
    }

    /**
     * Will load the initial data and initialize the buffer top and bottom
     * of the scroll panel providing a target threshold on scrolling both top / bottom positions.
     */
    protected void load() {
        if (loader == null) {
            setInfiniteScrollLoader(new InfiniteScrollLoader());
        }

        offset = loadConfig.getOffset();
        limit = loadConfig.getLimit();
        load(offset, limit);
    }

    /**
     * Will load the provided offset and limit with the datasource provided via
     * {@link this#setDataSource(DataSource)}
     */
    protected void load(int offset, int limit) {
        if (!completed) {
            LoadingEvent.fire(this, offset, offset + (limit - 1));
            dataSource.load(new LoadConfig<>(offset, limit), new LoadCallback<T>() {
                @Override
                public void onSuccess(LoadResult<T> loadResult) {
                    LoadedEvent.fire(InfiniteScrollPanel.this, loadResult);
                    InfiniteScrollPanel.this.offset = InfiniteScrollPanel.this.offset + limit;

                    if (InfiniteScrollPanel.this.offset >= loadResult.getTotalLength()) {
                        CompleteEvent.fire(InfiniteScrollPanel.this, loadResult.getTotalLength());
                    }
                }

                @Override
                public void onFailure(Throwable caught) {
                    ErrorEvent.fire(InfiniteScrollPanel.this, caught.getMessage());
                }
            });
        }
    }

    /**
     * Will render the provided data result with the provided {@link Renderer}.
     * This method will also check if recycling is enabled (You can turn on recycling by setting {@link this#setRecycleManager(RecycleManager)}.
     */
    private void render(List<T> models) {
        List<Widget> widgets = new ArrayList<>();
        for (T model : models) {
            Widget widget = renderer.render(model);
            widget.getElement().setId("item-" + itemCount);
            add(widget);
            widgets.add(widget);
            itemCount++;
        }

        // Check if recycling is enabled
        if (isEnableRecycling()) {
            recycleManager.recycleWidgets(widgets);
        }

        // Will force the scroll panel to have a scroll if it isn't visible
        if (!hasScrollBar()) {
            int height = $(widgets.get(0).getElement()).outerHeight();
            getElement().getStyle().setHeight(height, Style.Unit.PX);
        }

        // Fire an event
        WidgetRenderedEvent.fire(this, widgets);
    }

    /**
     * Will be called once the scroll bar reached at the bottom of the scroll panel.
     * This will load the current {@link this#offset} and {@link this#limit} and will
     * check if recycling is enabled.
     */
    protected void onScrollBottom() {
        if (isEnableRecycling() && recycleManager.hasRecycledWidgets()) {
            recycleManager.recycle(RecyclePosition.BOTTOM);
        } else {
            load(offset, limit);
        }
    }

    /**
     * Will be called once the scroll bar reached at the top of the scroll panel.
     * This will load the current {@link this#offset} and {@link this#limit} and will
     * check if recycling is enabled.
     */
    protected void onScrollTop() {
        if (isEnableRecycling()) {
            recycleManager.recycle(RecyclePosition.TOP);
        }
    }

    /**
     * Will clear the scroll panel children and reset it's initial properties.
     * If Recycling is enabled will unload it via {@link RecycleManager#unload()}
     */
    public void unload() {
        clear();
        offset = 0;
        limit = 0;
        itemCount = 1;
        completed = false;
        if (isEnableRecycling()) {
            recycleManager.unload();
        }
    }

    /**
     * Will reload the entire ScrollPanel setup
     */
    public void reload() {
        unload();
        load();
    }

    /**
     * Will display or hide the loading indicator upon reaching the target threshold.
     */
    public void loading(boolean show) {
        if (show) {
            loader.show();
        } else {
            loader.hide();
        }
    }

    /**
     * Determine if there's currently data that still loading.
     */
    public boolean isLoading() {
        return loader.isLoading();
    }

    /**
     * Determine if scroll bar is present in the scroll panel
     */
    public boolean hasScrollBar() {
        return $(getElement()).get(0).getScrollHeight() > $(getElement()).outerHeight();
    }

    /**
     * Get the load configuration
     */
    public InfiniteScrollLoadConfig getLoadConfig() {
        return loadConfig;
    }

    /**
     * Set the load configuration
     */
    public void setLoadConfig(InfiniteScrollLoadConfig loadConfig) {
        this.loadConfig = loadConfig;
    }

    /**
     * Get the datasource
     */
    public DataSource<T> getDataSource() {
        return dataSource;
    }

    /**
     * Set the datasource
     */
    public void setDataSource(DataSource<T> dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Get the widget renderer
     */
    public Renderer<T> getRenderer() {
        return renderer;
    }

    /**
     * Set the widget renderer
     */
    public void setRenderer(Renderer<T> renderer) {
        this.renderer = renderer;
    }

    /**
     * Get the loader widget
     */
    public InfiniteScrollLoader getLoader() {
        return loader;
    }

    public void setInfiniteScrollLoader(InfiniteScrollLoader loader) {
        this.loader = loader;
        this.loader.setParent(this);
    }

    /**
     * Get the recycling manager
     */
    public RecycleManager getRecycleManager() {
        return recycleManager;
    }

    /**
     * If set then recycling mechanism will be enabled, Else will provide a default
     * infinite scrolling logic.
     */
    public void setRecycleManager(RecycleManager recycleManager) {
        this.recycleManager = recycleManager;
        this.recycleManager.setParent(this);
    }

    /**
     * Check if recyling is enabled
     */
    public boolean isEnableRecycling() {
        return recycleManager != null;
    }

    /**
     * Get the buffer top
     */
    public int getBufferTop() {
        return bufferTop;
    }

    /**
     * Set the buffer top
     */
    public void setBufferTop(int bufferTop) {
        this.bufferTop = bufferTop;
    }

    /**
     * Get the buffer bottom
     */
    public int getBufferBottom() {
        return bufferBottom;
    }

    /**
     * Set the buffer bottom
     */
    public void setBufferBottom(int bufferBottom) {
        this.bufferBottom = bufferBottom;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        return addHandler(handler, LoadingEvent.getType());
    }

    @Override
    public HandlerRegistration addDataRenderedHandler(WidgetRenderedEvent.WidgetsRenderedHandler<T> handler) {
        return addHandler(handler, WidgetRenderedEvent.getType());
    }

    @Override
    public HandlerRegistration addLoadedHandler(LoadedEvent.LoadHandler<T> handler) {
        return addHandler(handler, LoadedEvent.getType());
    }

    @Override
    public HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        return addHandler(handler, CompleteEvent.getType());
    }

    @Override
    public HandlerRegistration addErrorHandler(ErrorEvent.ErrorHandler handler) {
        return addHandler(handler, ErrorEvent.getType());
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(InfiniteScrollClientBundle.INSTANCE.infiniteScrollCss(), InfiniteScrollDebugClientBundle.INSTANCE.infiniteScrollDebugCss()));
    }
}
