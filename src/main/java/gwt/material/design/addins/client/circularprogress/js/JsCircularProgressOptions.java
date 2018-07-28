/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.circularprogress.js;

import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for circular progress component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCircularProgressOptions {

    private JsCircularProgressOptions() {}

    @JsOverlay
    public static final JsCircularProgressOptions create() {
        JsCircularProgressOptions options = new JsCircularProgressOptions();
        options.value = 0.0;
        options.size = 100;
        options.thickness = 8;
        options.startAngle = Math.PI;
        options.fill = ColorHelper.setupComputedBackgroundColor(Color.BLUE);
        options.emptyFill = ColorHelper.setupComputedBackgroundColor(Color.GREY_LIGHTEN_2);
        options.reverse = false;
        return options;
    }

    @JsProperty
    public double value;

    @JsProperty
    public int size;

    @JsProperty
    public double startAngle;

    @JsProperty
    public boolean reverse;

    @JsProperty
    public double thickness;

    @JsProperty
    public String lineCap;

    @JsProperty
    public String fill;

    @JsProperty
    public String emptyFill;

    @JsProperty
    public Object animation;
}
