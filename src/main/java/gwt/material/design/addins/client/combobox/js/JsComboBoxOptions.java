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

import gwt.material.design.addins.client.combobox.js.options.Data;
import gwt.material.design.addins.client.combobox.js.options.Params;
import gwt.material.design.addins.client.combobox.js.options.Template;
import gwt.material.design.jquery.client.api.Functions;
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

    private JsComboBoxOptions() {
    }

    @JsOverlay
    public static final JsComboBoxOptions create() {
        JsComboBoxOptions options = new JsComboBoxOptions();
        options.dropdownParent = $("body");
        options.closeOnSelect = true;
        return options;
    }

    @JsProperty
    public boolean allowClear;

    @JsProperty
    public boolean closeOnSelect;

    @JsProperty
    public Object containerCss;

    @JsProperty
    public String containerCssClass;

    @JsProperty
    public Object[] data;

    @JsProperty
    public Object dataAdapter;

    @JsProperty
    public boolean debug;

    @JsProperty
    public Object dir;

    @JsProperty
    public boolean disabled;

    @JsProperty
    public Object dropdownAdapter;

    @JsProperty
    public boolean dropdownAutoWidth;

    @JsProperty
    public Object dropdownCss;

    @JsProperty
    public String dropdownCssClass;

    @JsProperty
    public JQueryElement dropdownParent;

    @JsProperty
    public Functions.Func escapeMarkup;

    @JsProperty
    public LanguageOptions language;

    @JsProperty
    public Functions.FuncRet2<Params, Data> matcher;

    @JsProperty
    public int maximumInputLength;

    @JsProperty
    public int maximumSelectionLength;

    @JsProperty
    public int minimumInputLength;

    @JsProperty
    public String minimumResultsForSearch;

    @JsProperty
    public boolean multiple;

    @JsProperty
    public String placeholder;

    @JsProperty
    public Object resultsAdapter;

    @JsProperty
    public Object selectionAdapter;

    @JsProperty
    public boolean selectOnClose;

    @JsProperty
    public Functions.Func sorter;

    @JsProperty
    public boolean tags;

    @JsProperty
    public Functions.FuncRet1<Template> templateResult;

    @JsProperty
    public Functions.FuncRet1<Template> templateSelection;

    @JsProperty
    public String theme;

    @JsProperty
    public Functions.Func tokenizer;

    @JsProperty
    public Object[] tokenSeparators;

    @JsProperty
    public String width;

    @JsProperty
    public boolean scrollAfterSelect;
}
