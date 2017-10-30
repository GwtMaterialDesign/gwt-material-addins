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
package gwt.material.design.addins.client.richeditor.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for rich editor component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsRichEditorOptions {

    @JsOverlay
    public final static JsRichEditorOptions create() {
        JsRichEditorOptions options = new JsRichEditorOptions();
        options.airMode = false;
        options.disableDragAndDrop = false;
        options.followingToolbar = false;
        options.minHeight = 200;
        options.defaultBackColor = "#777";
        options.defaultTextColor = "#fff";
        return options;
    }

    @JsProperty
    public Object[][] toolbar;

    @JsProperty
    public boolean airMode;

    @JsProperty
    public boolean disableDragAndDrop;

    @JsProperty
    public boolean followingToolbar;

    @JsProperty
    public String placeholder;

    @JsProperty
    public String height;

    @JsProperty
    public double minHeight;

    @JsProperty
    public String defaultBackColor;

    @JsProperty
    public String defaultTextColor;
}
