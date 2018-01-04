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
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Create a scrollbar for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} and
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ChartScrollbar">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmChartScrollbar {

    @JsProperty
    public String accessibleLabel;

    @JsProperty
    public boolean autoGridCount;

    @JsProperty
    public double backgroundAlpha;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public AmCategoryAxis categoryAxis;

    @JsProperty
    public String color;

    @JsProperty
    public String dragCursorDown;

    @JsProperty
    public String dragCursorHover;

    @JsProperty
    public String dragIcon;

    @JsProperty
    public int dragIconHeight;

    @JsProperty
    public int dragIconWidth;

    @JsProperty
    public boolean enabled;

    @JsProperty
    public String graph;

    @JsProperty
    public double graphFillAlpha;

    @JsProperty
    public String graphFillColor;

    @JsProperty
    public double graphLineAlpha;

    @JsProperty
    public String graphLineColor;

    @JsProperty
    public String graphType;

    @JsProperty
    public double gridAlpha;

    @JsProperty
    public String gridColor;

    @JsProperty
    public int gridCount;

    @JsProperty
    public boolean hideResizeGrips;

    @JsProperty
    public String hResizeCursor;

    @JsProperty
    public String hResizeCursorDown;

    @JsProperty
    public String hResizeCursorHover;

    @JsProperty
    public boolean ignoreCustomColors;

    @JsProperty
    public int maximum;

    @JsProperty
    public int minimum;

    @JsProperty
    public int offset;

    @JsProperty
    public boolean oppositeAxis;

    @JsProperty
    public boolean resizeEnabled;

    @JsProperty
    public int scrollbarHeight;

    @JsProperty
    public int scrollDuration;

    @JsProperty
    public double selectedBackgroundAlpha;

    @JsProperty
    public String selectedBackgroundColor;

    @JsProperty
    public int selectedGraphFillAlpha;

    @JsProperty
    public String selectedGraphFillColor;

    @JsProperty
    public double selectedGraphLineAlpha;

    @JsProperty
    public String selectedGraphLineColor;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public boolean updateOnReleaseOnly;

    @JsProperty
    public String vResizeCursor;

    @JsProperty
    public String vResizeCursorDown;

    @JsProperty
    public String vResizeCursorHover;
}
