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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.data.*;
import gwt.material.design.incubator.client.infinitescroll.events.*;
import gwt.material.design.incubator.client.infinitescroll.recycle.RecycleManager;
import gwt.material.design.incubator.client.infinitescroll.recycle.RecyclePosition;

import java.util.ArrayList;
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
public class InfiniteScrollPanel<T> extends MaterialPanel implements HasInfiniteScrollHandlers<T> {

    static {
        IncubatorWidget.showWarning(InfiniteScrollPanel.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(InfiniteScrollDebugClientBundle.INSTANCE.infiniteScrollDebugCss());
        } else {
            MaterialDesignBase.injectCss(InfiniteScrollClientBundle.INSTANCE.infiniteScrollCss());
        }
    }

    private InfiniteScrollLoader loader;
    private DataSource<T> dataSource;
    private LoadConfig<T> loadConfig;
    private Renderer<T> renderer;
    private RecycleManager recycleManager;
    private int offset = 0;
    private int limit = 0;
    private boolean completed;

    public InfiniteScrollPanel() {
        super();
    }

    public InfiniteScrollPanel(DataSource<T> dataSource, LoadConfig<T> loadConfig) {
        this();

        this.dataSource = dataSource;
        this.loadConfig = loadConfig;
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        $(getElement()).scroll((e, param1) -> {
            if (!isLoading()) {
                if (getElement().getScrollTop() <= 0) {
                    onScrollTop();
                }

                if (getElement().getScrollTop() == (getElement().getScrollHeight()) - getElement().getOffsetHeight()) {
                    onScrollBottom();
                }
            }
            return false;
        });

        registerHandler(addLoadedHandler(event -> {
            loading(false);
            MaterialToast.fireToast("TEST");
            List<Widget> widgets = new ArrayList<>();
            for (T model : event.getResult().getData()) {
                Widget widget = renderer.render(model);
                add(widget);
                widgets.add(widget);
            }

            if (isEnableRecycling()) {
                recycleManager.addWidgets(widgets);
            }
        }));

        registerHandler(addCompleteHandler(event -> {
            loading(false);
            completed = true;
        }));

        load();
    }

    protected void load() {
        loader = new InfiniteScrollLoader(this);
        offset = loadConfig.getOffset();
        limit = loadConfig.getLimit();

        load(offset, limit);
    }

    protected void onScrollBottom() {
        if (isEnableRecycling() && recycleManager.hasRecycledWidgets()) {
            recycleManager.recycle(RecyclePosition.BOTTOM);
        } else {
            load(offset, limit);
        }
    }

    protected void onScrollTop() {
        if (isEnableRecycling()) {
            recycleManager.recycle(RecyclePosition.TOP);
        }
    }

    protected void load(int offset, int limit) {
        if (!completed) {
            loading(true);
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

    public void unload() {
        clear();
        offset = 0;
        limit = 0;
        completed = false;
        if (isEnableRecycling()) {
            recycleManager.unload();
        }
    }

    public void reload() {
        unload();
        load();
    }

    public void loading(boolean show) {
        if (show) {
            loader.show();
        } else {
            loader.hide();
        }
    }

    public boolean isLoading() {
        return loader.isAttached();
    }

    public LoadConfig<T> getLoadConfig() {
        return loadConfig;
    }

    public void setLoadConfig(LoadConfig<T> loadConfig) {
        this.loadConfig = loadConfig;
    }

    public DataSource<T> getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource<T> dataSource) {
        this.dataSource = dataSource;
    }

    public Renderer<T> getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer<T> renderer) {
        this.renderer = renderer;
    }

    public void setRecycleManager(RecycleManager recycleManager) {
        this.recycleManager = recycleManager;
        this.recycleManager.setParent(this);
    }

    public InfiniteScrollLoader getLoader() {
        return loader;
    }

    public RecycleManager getRecycleManager() {
        return recycleManager;
    }

    public boolean isEnableRecycling() {
        return recycleManager != null;
    }

    @Override
    public HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        return addHandler(handler, LoadingEvent.getType());
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
}
