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
package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * JSInterop util for {@link gwt.material.design.incubator.client.chart.amcharts.options.Legend}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmLegend">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmLegend {

    @JsProperty
    public String accessibleLabel;

    @JsProperty
    public String align;

    @JsProperty
    public boolean autoMargins;

    @JsProperty
    public double backgroundAlpha;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public int borderAlpha;

    @JsProperty
    public String borderColor;

    @JsProperty
    public int bottom;

    @JsProperty
    public String color;

    @JsProperty
    public boolean combineLegend;

    @JsProperty
    public Object[] data;

    @JsProperty
    public String divId;

    @JsProperty
    public boolean enabled;

    @JsProperty
    public boolean equalWidths;

    @JsProperty
    public int fontSize;

    @JsProperty
    public boolean forceWidth;

    @JsProperty
    public int gradientRotation;

    @JsProperty
    public int horizontalGap;

    @JsProperty
    public String labelText;

    @JsProperty
    public int labelWidth;

    @JsProperty
    public int left;

    @JsProperty
    public Object[] listeners;

    @JsProperty
    public int marginBottom;

    @JsProperty
    public int marginLeft;

    @JsProperty
    public int marginRight;

    @JsProperty
    public int marginTop;

    @JsProperty
    public int markerBorderAlpha;

    @JsProperty
    public String markerBorderColor;

    @JsProperty
    public int markerBorderThickness;

    @JsProperty
    public String markerDisabledColor;

    @JsProperty
    public int markerLabelGap;

    @JsProperty
    public int markerSize;

    @JsProperty
    public String markerType;

    @JsProperty
    public int maxColumns;

    @JsProperty
    public String periodValueText;

    @JsProperty
    public String position;

    @JsProperty
    public boolean reversedOrder;

    @JsProperty
    public int right;

    @JsProperty
    public String rollOverColor;

    @JsProperty
    public double rollOverGraphAlpha;

    @JsProperty
    public boolean showEntries;

    @JsProperty
    public int spacing;

    @JsProperty
    public boolean switchable;

    @JsProperty
    public String switchColor;

    @JsProperty
    public String switchType;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public boolean textClickEnabled;

    @JsProperty
    public int top;

    @JsProperty
    public boolean useGraphSettings;

    @JsProperty
    public boolean useMarkerColorForLabels;

    @JsProperty
    public boolean useMarkerColorForValues;

    @JsProperty
    public String valueAlign;

    @JsProperty
    public Functions.Func valueFunction;

    @JsProperty
    public String valueText;

    @JsProperty
    public int valueWidth;

    @JsProperty
    public int verticalGap;

    @JsProperty
    public int width;

    @JsMethod
    public native void addListener(String type, Functions.Func1<Object> handler);

    @JsMethod
    public native void removeListener(AmLegend legend, String type, Functions.Func1<Object> handler);
}
