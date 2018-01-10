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
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.infinitescroll.base.AbstractMagicScoll;
import gwt.material.design.incubator.client.infinitescroll.base.ScrollLoader;
import gwt.material.design.jquery.client.api.Functions;

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
public class InfiniteScrollPanel extends AbstractMagicScoll {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(InfiniteScrollDebugClientBundle.INSTANCE.infiniteScrollDebugCss());
        } else {
            MaterialDesignBase.injectCss(InfiniteScrollClientBundle.INSTANCE.infiniteScrollCss());
        }
    }

    private Functions.Func callback;
    private ScrollLoader loader = new ScrollLoader();

    @Override
    public void load() {

        setTriggerElement("." + IncubatorCssName.INFINITE_SCROLL_LOADER);

        add(loader);

        addSceneEnterHandler(event -> {
            if (loader != null) {
                if (!loader.isActive()) {
                    loader.setActive(true);
                    if (callback != null) {
                        callback.call();
                    } else {
                        GWT.log("No callback has been set.");
                    }
                }
            } else {
                GWT.log("Loader is not set.", new IllegalStateException());
            }
        });

        super.load();
    }

    public Functions.Func getCallback() {
        return callback;
    }

    public void setCallback(Functions.Func callback) {
        this.callback = callback;
    }

    public void update() {
        loader.setActive(false);
        getScene().update(true);
    }
}
