package gwt.material.design.addins.client.dnd.js;

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


import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * @author Mark Kevin
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDropOptions {

    /**
     * A JQuery based node selector for the accepted items.
     */
    @JsProperty
    public String accept;

    /**
     * The overlap amount, default 0.75
     */
    @JsProperty
    public double overlap;

    @JsOverlay
    public static JsDropOptions create() {
        return new JsDropOptions();
    }

    @JsOverlay
    public static JsDropOptions create(String accept) {
        return create(accept, 0.75);
    }

    @JsOverlay
    public static JsDropOptions create(double overlap) {
        return create(null, overlap);
    }

    @JsOverlay
    public static JsDropOptions create(String accept, double overlap) {
        JsDropOptions options = new JsDropOptions();
        options.accept = accept;
        options.overlap = overlap;
        return options;
    }
}
