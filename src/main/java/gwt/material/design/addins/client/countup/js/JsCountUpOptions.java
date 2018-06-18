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
package gwt.material.design.addins.client.countup.js;

import gwt.material.design.jquery.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for CountUp component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCountUpOptions {

    private JsCountUpOptions() {}

    @JsOverlay
    public static final JsCountUpOptions create() {
        JsCountUpOptions options = new JsCountUpOptions();
        options.separator = ",";
        options.decimal = ".";
        options.prefix = "";
        options.suffix = "";
        options.startValue = 0;
        options.endValue = 0;
        options.decimals = 0;
        options.duration = 2;
        return options;
    }

    @JsProperty
    public double startValue;

    @JsProperty
    public double endValue;

    @JsProperty
    public double decimals;

    @JsProperty
    public double duration;

    @JsProperty
    public Functions.Func callback;

    @JsProperty
    public String separator;

    @JsProperty
    public String decimal;

    @JsProperty
    public String prefix;

    @JsProperty
    public String suffix;
}
