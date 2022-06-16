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
package gwt.material.design.addins.client.pinch.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for pinch zoom component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsPinchOptions {

    @JsProperty
    public Integer tapZoomFactor;

    @JsProperty
    public boolean lockDragAxis;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onZoomStart;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onZoomEnd;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onDoubleTap;

    //TODO: Populate all options & events
}
