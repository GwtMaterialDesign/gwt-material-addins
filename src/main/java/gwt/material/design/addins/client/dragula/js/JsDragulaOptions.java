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
package gwt.material.design.addins.client.dragula.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for dragula component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDragulaOptions {

    private JsDragulaOptions() {}

    public static final JsDragulaOptions create() {
        JsDragulaOptions options = new JsDragulaOptions();
        options.direction = "vertical";
        options.copy = false;
        options.copySortSource = false;
        options.revertOnSpill = false;
        options.removeOnSpill = false;
        options.ignoreInputTextSelection = true;
        return options;
    }

    @JsProperty
    public String direction;

    @JsProperty
    public boolean copy;

    @JsProperty
    public boolean copySortSource;

    @JsProperty
    public boolean revertOnSpill;

    @JsProperty
    public boolean removeOnSpill;

    @JsProperty
    public boolean ignoreInputTextSelection;
}
