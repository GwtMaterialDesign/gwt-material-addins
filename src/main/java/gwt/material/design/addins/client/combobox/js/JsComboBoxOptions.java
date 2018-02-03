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
package gwt.material.design.addins.client.combobox.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import static gwt.material.design.addins.client.combobox.js.JsComboBox.$;

/**
 * Options for combobox component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsComboBoxOptions {

    private JsComboBoxOptions() {}

    @JsOverlay
    public static final JsComboBoxOptions create() {
        JsComboBoxOptions options = new JsComboBoxOptions();
        options.dropdownParent = $("body");
        options.closeOnSelect = true;
        return options;
    }

    @JsProperty
    public String placeholder;

    @JsProperty
    public JQueryElement dropdownParent;

    @JsProperty
    public boolean allowClear;

    @JsProperty
    public int maximumSelectionLength;

    @JsProperty
    public String minimumResultsForSearch;

    @JsProperty
    public boolean closeOnSelect;

    @JsProperty
    public boolean tags;

    @JsProperty
    public LanguageOptions language;
}