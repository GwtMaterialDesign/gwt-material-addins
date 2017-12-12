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
package gwt.material.design.incubator.client.chart.chartjs.js.datasets;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The line chart allows a number of properties to be specified for each dataset. These are used to set display
 * properties for a specific dataset. For example, the colour of a line is generally set this way.
 * All point* properties can be specified as an array. If these are set to an array value, the first
 * value applies to the first point, the second value to the second point, and so on.
 *
 * @author kevzlou7979@gmail.com
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LineChartDataSets extends ChartDataSets {

    /**
     * The ID of the x axis to plot this dataset on. If not specified, this defaults to the ID of the first found x axis
     */
    @JsProperty
    public String xAxisID;

    /**
     * The ID of the y axis to plot this dataset on. If not specified, this defaults to the ID of the first found y axis.
     */
    @JsProperty
    public String yAxisID;

    /**
     * The fill color under the line.
     */
    @JsProperty
    public String backgroundColor;

    /**
     * The color of the line.
     */
    @JsProperty
    public String borderColor;

    /**
     * The width of the line in pixels.
     */
    @JsProperty
    public int borderWidth;

    /**
     * Length and spacing of dashes.
     */
    @JsProperty
    public int[] borderDash;

    /**
     * Offset for line dashes.
     */
    @JsProperty
    public int borderDashOffset;

    /**
     * Cap style of the line.
     */
    @JsProperty
    public String borderCapStyle;

    /**
     * Line joint style.
     */
    @JsProperty
    public String borderJoinStyle;

    /**
     * Algorithm used to interpolate a smooth curve from the discrete data points.
     */
    @JsProperty
    public String cubicInterpolationMode;

    /**
     * How to fill the area under the line.
     */
    @JsProperty
    public Object fill;

    /**
     * Bezier curve tension of the line. Set to 0 to draw straightlines. This option is ignored if monotone cubic
     * interpolation is used.
     */
    @JsProperty
    public int lineTension;

    /**
     * The fill color for points.
     */
    @JsProperty
    public String pointBackgroundColor;

    /**
     * The border color for points.
     */
    @JsProperty
    public String pointBorderColor;

    /**
     * The width of the point border in pixels.
     */
    @JsProperty
    public int pointBorderWidth;

    /**
     * The radius of the point shape. If set to 0, the point is not rendered.
     */
    @JsProperty
    public int pointRadius;

    /**
     * Style of the point.
     */
    @JsProperty
    public String pointStyle;

    /**
     * The pixel size of the non-displayed point that reacts to mouse events.
     */
    @JsProperty
    public int pointHitRadius;

    /**
     * Point background color when hovered.
     */
    @JsProperty
    public String pointHoverBackgroundColor;

    /**
     * Point border color when hovered.
     */
    @JsProperty
    public String pointHoverBorderColor;

    /**
     * Border width of point when hovered.
     */
    @JsProperty
    public int pointHoverBorderWidth;

    /**
     * The radius of the point when hovered.
     */
    @JsProperty
    public int pointHoverRadius;

    /**
     * If false, the line is not drawn for this dataset.
     */
    @JsProperty
    public boolean showLine;

    /**
     * If true, lines will be drawn between points with no or null data. If false, points with NaN data will create a
     * break in the line
     */
    @JsProperty
    public boolean spanGaps;

    /**
     * If the line is shown as a stepped line.
     */
    @JsProperty
    public Object steppedLine;
}
