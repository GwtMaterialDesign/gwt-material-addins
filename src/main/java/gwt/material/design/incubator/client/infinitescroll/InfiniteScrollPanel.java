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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.infinitescroll.base.AbstractMagicScoll;
import gwt.material.design.incubator.client.infinitescroll.base.ScrollLoader;
import gwt.material.design.incubator.client.infinitescroll.data.DataSource;
import gwt.material.design.incubator.client.infinitescroll.data.LoadCallback;
import gwt.material.design.incubator.client.infinitescroll.data.LoadConfig;
import gwt.material.design.incubator.client.infinitescroll.data.LoadResult;
import gwt.material.design.incubator.client.infinitescroll.events.HasInfiniteScrollEvent;
import gwt.material.design.incubator.client.infinitescroll.events.LoadEvent;

//@formatter:off

/**
 * //TODO Brief description about the library
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 *
 * @author kevzlou7979
 */
public class InfiniteScrollPanel<T> extends AbstractMagicScoll implements HasInfiniteScrollEvent<T> {

    static {
        IncubatorWidget.showWarning(InfiniteScrollPanel.class);
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(InfiniteScrollDebugClientBundle.INSTANCE.infiniteScrollDebugCss());
        } else {
            MaterialDesignBase.injectCss(InfiniteScrollClientBundle.INSTANCE.infiniteScrollCss());
        }
    }

    private int viewIndex;
    private ScrollLoader loader = new ScrollLoader();
    private DataSource<T> dataSource;
    private LoadConfig<T> loadConfig;

    public InfiniteScrollPanel() {
        super();
    }

    public InfiniteScrollPanel(DataSource<T> dataSource, LoadConfig<T> loadConfig) {
        super();

        this.dataSource = dataSource;
        this.loadConfig = loadConfig;
    }

    @Override
    public void load() {

        setTriggerElement("." + IncubatorCssName.INFINITE_SCROLL_LOADER);

        add(loader);

        addSceneEnterHandler(event -> {
            if (loader != null) {
                if (!loader.isActive()) {
                    loader.setActive(true);

                    load(viewIndex, loadConfig.getLimit());
                }
            } else {
                GWT.log("Loader is not set.", new IllegalStateException());
            }
        });

        super.load();
    }

    protected void load(int offset, int limit) {
        dataSource.load(new LoadConfig<>(offset, limit), new LoadCallback<T>() {
            @Override
            public void onSuccess(LoadResult<T> loadResult) {
                LoadEvent.fire(InfiniteScrollPanel.this, loadResult.getData());
                update();
                viewIndex = viewIndex + loadConfig.getLimit();
            }

            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("ERROR");
            }
        });
    }

    public void update() {
        loader.setActive(false);
        getScene().update(true);
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
    public HandlerRegistration addLoadHandler(LoadEvent.LoadHandler<T> handler) {
        return addHandler(handler, LoadEvent.getType());
    }
}
