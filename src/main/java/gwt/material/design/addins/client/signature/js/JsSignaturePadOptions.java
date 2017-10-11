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
package gwt.material.design.addins.client.signature.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsSignaturePadOptions {

    private JsSignaturePadOptions() {}

    @JsOverlay
    public static final JsSignaturePadOptions create() {
        JsSignaturePadOptions options = new JsSignaturePadOptions();
        options.dotSize = 1;
        options.minWidth = 0.5;
        options.maxWidth = 2.5;
        options.throttle = 16;
        options.penColor = "black";
        options.velocityFilterWeight = 0.7;
        return options;
    }

    @JsProperty
    public double dotSize;

    @JsProperty
    public double minWidth;

    @JsProperty
    public double maxWidth;

    @JsProperty
    public int throttle;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public String penColor;

    @JsProperty
    public double velocityFilterWeight;

    @JsProperty
    public Functions.Func onBegin;

    @JsProperty
    public Functions.Func onEnd;
}
