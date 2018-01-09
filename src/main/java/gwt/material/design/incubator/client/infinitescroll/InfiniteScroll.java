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

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.events.EnterEvent;
import gwt.material.design.incubator.client.infinitescroll.events.HasInfiniteScrollbarHandlers;
import gwt.material.design.incubator.client.infinitescroll.js.Controller;
import gwt.material.design.incubator.client.infinitescroll.js.Scene;
import gwt.material.design.incubator.client.infinitescroll.js.SceneOptions;

//@formatter:off

/**
 * // TODO Brief description about the library
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 * <h3>XML Namespace Declaration</h3>
 *
 * @author kevzlou7979
 */
public class InfiniteScroll extends MaterialWidget implements JsLoader, HasInfiniteScrollbarHandlers {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectDebugJs(InfiniteScrollDebugClientBundle.INSTANCE.scrollMagicDebugJs());
            MaterialDesignBase.injectDebugJs(InfiniteScrollDebugClientBundle.INSTANCE.addIndicatorsPluginDebugJs());
        } else {
            MaterialDesignBase.injectJs(InfiniteScrollClientBundle.INSTANCE.scrollMagicJs());
            MaterialDesignBase.injectJs(InfiniteScrollClientBundle.INSTANCE.addIndicatorsPluginJs());
        }
    }

    private Scene scene;

    public InfiniteScroll() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        load();
    }

    @Override
    public void load() {

        Controller controller = new Controller();
        SceneOptions options = new SceneOptions();
        options.triggerElement = ".target";
        options.triggerHook = "onEnter";

        scene = new Scene(options).addTo(controller);
        scene.on("enter", e -> {
            EnterEvent.fire(this);
            return true;
        });
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void addEnterHandler(EnterEvent.EnterHandler handler) {
        addHandler(handler, EnterEvent.getType());
    }

    public Scene getScene() {
        return scene;
    }
}
