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
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.data.DataSource;
import gwt.material.design.incubator.client.infinitescroll.data.LoadCallback;
import gwt.material.design.incubator.client.infinitescroll.data.LoadConfig;
import gwt.material.design.incubator.client.infinitescroll.data.LoadResult;
import gwt.material.design.incubator.client.infinitescroll.events.*;

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

    private ScrollLoader loader = new ScrollLoader(this);
    private DataSource<T> dataSource;
    private LoadConfig<T> loadConfig;
    private int _offset = 0;
    private int _limit = 0;
    private int _absoluteTotal;
    private boolean _completed;

    public InfiniteScrollPanel() {
        super();
    }

    public InfiniteScrollPanel(DataSource<T> dataSource, LoadConfig<T> loadConfig) {
        super();

        this.dataSource = dataSource;
        this.loadConfig = loadConfig;
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    public void load() {
        _offset = loadConfig.getOffset();
        _limit = loadConfig.getLimit();

        load(_offset, _limit);

        $(getElement()).scroll((e, param1) -> {
            if (!loader.isAttached()) {
                if (getElement().getScrollTop() == (getElement().getScrollHeight()) - getElement().getOffsetHeight()) {
                    load(_offset, _limit);
                }
            }
            return false;
        });

        addLoadHandler(event -> loading(false));
        addCompleteHandler(event -> loading(false));
    }

    protected void load(int offset, int limit) {
        if (!_completed) {
            loading(true);
            dataSource.load(new LoadConfig<>(offset, limit), new LoadCallback<T>() {
                @Override
                public void onSuccess(LoadResult<T> loadResult) {
                    LoadEvent.fire(InfiniteScrollPanel.this, loadResult.getData());

                    _offset = _offset + limit;
                    _absoluteTotal = loadResult.getTotalLength();

                    if (_offset >= _absoluteTotal) {
                        CompleteEvent.fire(InfiniteScrollPanel.this);
                        _completed = true;
                    }
                }

                @Override
                public void onFailure(Throwable caught) {
                    ErrorEvent.fire(InfiniteScrollPanel.this, caught.getMessage());
                }
            });
        }
    }

    public void loading(boolean show) {
        if (show) {
            loader.show();
        } else {
            loader.hide();
        }
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

    @Override
    public HandlerRegistration addLoadingHandler(LoadingEvent.LoadingHandler handler) {
        return addHandler(handler, LoadingEvent.getType());
    }

    @Override
    public HandlerRegistration addLoadHandler(LoadEvent.LoadHandler<T> handler) {
        return addHandler(handler, LoadEvent.getType());
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
