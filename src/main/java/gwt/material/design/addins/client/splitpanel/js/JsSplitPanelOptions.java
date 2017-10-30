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
package gwt.material.design.addins.client.splitpanel.js;

import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.constants.Axis;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for split panel component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsSplitPanelOptions {


    private JsSplitPanelOptions() {}

    @JsOverlay
    final static public JsSplitPanelOptions create() {
        JsSplitPanelOptions options = new JsSplitPanelOptions();
        options.thickness = "8px";
        options.barPosition = 0.5;
        options.dock = Dock.LEFT.getCssName();
        options.orientation = Axis.HORIZONTAL.getCssName();
        return options;
    }

    @JsProperty
    public double barPosition;

    @JsProperty
    public String thickness;

    @JsProperty
    public double rightMax;

    @JsProperty
    public double rightMin;

    @JsProperty
    public double leftMax;

    @JsProperty
    public double leftMin;

    @JsProperty
    public double topMax;

    @JsProperty
    public double topMin;

    @JsProperty
    public double bottomMin;

    @JsProperty
    public double bottomMax;

    @JsProperty
    public String dock;

    @JsProperty
    public String orientation;
}
