/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollClientBundle;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollDebugClientBundle;
import gwt.material.design.incubator.client.infinitescroll.events.*;
import gwt.material.design.incubator.client.infinitescroll.js.Controller;
import gwt.material.design.incubator.client.infinitescroll.js.Scene;
import gwt.material.design.incubator.client.infinitescroll.js.SceneOptions;

public abstract class AbstractMagicScoll extends MaterialWidget implements JsLoader, HasSceneHandlers {

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
    private Controller controller = new Controller();
    private SceneOptions options = SceneOptions.create();

    public AbstractMagicScoll() {
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
        scene = new Scene(options).addTo(controller);
        loadEvents(scene);
    }

    protected void loadEvents(Scene scene) {
        scene.on(SceneEvents.ADD, e -> {
            AddEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.CHANGE, e -> {
            AddEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.DESTROY, e -> {
            AddEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.END, e -> {
            AddEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.ENTER, e -> {
            EnterEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.LEAVE, e -> {
            LeaveEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.PROGRESS, e -> {
            ProgressEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.REMOVE, e -> {
            RemoveEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.SHIFT, e -> {
            ShiftEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.START, e -> {
            StartEvent.fire(this);
            return true;
        });

        scene.on(SceneEvents.UPDATE, e -> {
            UpdateEvent.fire(this);
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
        scene.destroy(true);
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    /**
     * The duration of the scene. If 0 tweens will auto-play when reaching the scene start point, pins will be pinned
     * indefinetly starting at the start position. A function retuning the duration value is also supported.
     * Please see Scene.duration() for details. Default to 0
     */
    public void setDuration(int duration) {
        options.duration = duration;
    }

    public int getOffset() {
        return options.offset;
    }

    /**
     * Offset Value for the Trigger Position. If no triggerElement is defined this will be the scroll distance from the
     * start of the page, after which the scene will start. Default to 0
     */
    public void setOffset(int offset) {
        options.offset = offset;
    }

    public Object getTriggerElement() {
        return options.triggerElement;
    }

    /**
     * Selector or DOM object that defines the start of the scene. If undefined the scene will start right at the start
     * of the page (unless an offset is set). Default tp null
     */
    public void setTriggerElement(Object triggerElement) {
        options.triggerElement = triggerElement;
    }

    public Object getTriggerHook() {
        return options.triggerHook;
    }

    /**
     * Can be a number between 0 and 1 defining the position of the trigger Hook in relation to the viewport.
     * Can also be defined using a string:
     * <p>
     * "onEnter" => 1 <br/>
     * "onCenter" => 0.5 <br/>
     * "onLeave" => 0 <br/>
     */
    public void setTriggerHook(Object triggerHook) {
        options.triggerHook = triggerHook;
    }

    public boolean isReverse() {
        return options.reverse;
    }

    /**
     * Should the scene reverse, when scrolling up?. Default to true
     */
    public void setReverse(boolean reverse) {
        options.reverse = reverse;
    }

    public int getLogLevel() {
        return options.loglevel;
    }

    /**
     * Loglevel for debugging. Note that logging is disabled in the minified version of ScrollMagic.
     * <p>
     * 0 => silent <br/>
     * 1 => errors <br/>
     * 2 => errors, warnings <br/>
     * 3 => errors, warnings, debuginfo <br/>
     */
    public void setLogLevel(int logLevel) {
        options.loglevel = logLevel;
    }

    public Scene getScene() {
        return scene;
    }

    @Override
    public HandlerRegistration addSceneAddHandler(AddEvent.AddHandler handler) {
        return addHandler(handler, AddEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneChangeHandler(ChangeEvent.ChangeHandler handler) {
        return addHandler(handler, ChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneDestroyHandler(DestroyEvent.DestroyHandler handler) {
        return addHandler(handler, DestroyEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneEndHandler(EndEvent.EndHandler handler) {
        return addHandler(handler, EndEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneEnterHandler(EnterEvent.EnterHandler handler) {
        return addHandler(handler, EnterEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneLeaveHandler(LeaveEvent.LeaveHandler handler) {
        return addHandler(handler, LeaveEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneProgressHandler(ProgressEvent.ProgressHandler handler) {
        return addHandler(handler, ProgressEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneRemoveHandler(RemoveEvent.RemoveHandler handler) {
        return addHandler(handler, RemoveEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneShiftHandler(ShiftEvent.ShiftHandler handler) {
        return addHandler(handler, ShiftEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneStartHandler(StartEvent.StartHandler handler) {
        return addHandler(handler, StartEvent.getType());
    }

    @Override
    public HandlerRegistration addSceneUpdateHandler(UpdateEvent.UpdateHandler handler) {
        return addHandler(handler, UpdateEvent.getType());
    }
}
