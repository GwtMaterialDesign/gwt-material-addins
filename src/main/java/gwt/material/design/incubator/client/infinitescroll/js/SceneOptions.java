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
package gwt.material.design.incubator.client.infinitescroll.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for the Scene. The options can be updated at any time.
 * Instead of setting the options for each scene individually you can also set them globally in the controller as the
 * controllers globalSceneOptions option. The object accepts the same properties as the ones below. When a scene is
 * added to the controller the options defined using the Scene constructor will be overwritten by those set in
 * globalSceneOptions.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://scrollmagic.io/docs/ScrollMagic.Scene.html#constructor">Official Documentation</a>
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class SceneOptions {

    /**
     * The duration of the scene. If 0 tweens will auto-play when reaching the scene start point, pins will be pinned
     * indefinetly starting at the start position. A function retuning the duration value is also supported.
     * Please see Scene.duration() for details. Default to 0
     */
    @JsProperty
    public int duration;
    /**
     * Offset Value for the Trigger Position. If no triggerElement is defined this will be the scroll distance from the
     * start of the page, after which the scene will start. Default to 0
     */
    @JsProperty
    public int offset;
    /**
     * Selector or DOM object that defines the start of the scene. If undefined the scene will start right at the start
     * of the page (unless an offset is set). Default tp null
     */
    @JsProperty
    public Object triggerElement;
    /**
     * Can be a number between 0 and 1 defining the position of the trigger Hook in relation to the viewport.
     * Can also be defined using a string:
     * <p>
     * "onEnter" => 1 <br/>
     * "onCenter" => 0.5 <br/>
     * "onLeave" => 0 <br/>
     */
    @JsProperty
    public Object triggerHook;
    /**
     * Should the scene reverse, when scrolling up?. Default to true
     */
    @JsProperty
    public boolean reverse;
    /**
     * Loglevel for debugging. Note that logging is disabled in the minified version of ScrollMagic.
     * <p>
     * 0 => silent <br/>
     * 1 => errors <br/>
     * 2 => errors, warnings <br/>
     * 3 => errors, warnings, debuginfo <br/>
     */
    @JsProperty
    public int loglevel;

    private SceneOptions() {}

    @JsOverlay
    public static final SceneOptions create() {
        SceneOptions options = new SceneOptions();
        options.triggerHook = "onEnter";
        return options;
    }
}
