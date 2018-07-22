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

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for ScrollMagic.Controller
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = "ScrollMagic")
public class Controller extends JQueryElement {

    @JsMethod
    public native Controller addScene(Scene scene);

    @JsMethod
    public native void destroy(boolean resetScenes);

    @JsMethod
    public native Controller removeScene(Scene scene);

    @JsMethod
    public native Controller scrollTo(Object scrollTarget, Object additionalParameter);

    @JsMethod
    public native Controller update(boolean immediately);

    @JsMethod
    public native Controller updateScene(Scene scene, boolean immediately);

    @JsMethod
    public native Controller enabled(boolean enabled);

    @JsMethod
    public native boolean enabled();

    @JsMethod
    public native Controller loglevel(int loglevel);

    @JsMethod
    public native int loglevel();

    @JsMethod
    public native Controller scrollPos(int scrollPos);

    @JsMethod
    public native int scrollPos();
}