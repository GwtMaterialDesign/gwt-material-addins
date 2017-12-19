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

import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import gwt.material.design.incubator.client.chart.amcharts.js.options.TrendLine;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Extension for {@link AmCoordinateChart} and base class of {@link AmSerialChart} and {@link AmXYChart}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRectangularChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmRectangularChart extends AmCoordinateChart {

    /**
     * The angle of the 3D part of plot area. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    @JsProperty
    public int angle;

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to 10
     */
    @JsProperty
    public int autoMarginOffset;

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to true
     */
    @JsProperty
    public boolean autoMargins;

    /**
     * Cursor of a chart.
     */
    @JsProperty
    public ChartCursor chartCursor;

    /**
     * Chart's scrollbar.
     */
    @JsProperty
    public ChartScrollbar chartScrollbar;

    /**
     * The depth of the 3D part of plot area. This creates a 3D effect (if the "angle" is > 0). Default to 0
     */
    @JsProperty
    public int depth3D;

    /**
     * Number of pixels between the container's bottom border and plot area. This space can be used for bottom axis'
     * values. If autoMargin is true and bottom side has axis, this property is ignored. Default to 20
     */
    @JsProperty
    public int marginLeft;

    /**
     * Number of pixels between the container's left border and plot area. This space can be used for left axis' values.
     * If autoMargin is true and left side has axis, this property is ignored. Default to 20
     */
    @JsProperty
    public int marginBottom;

    /**
     * Number of pixels between the container's right border and plot area. This space can be used for Right axis'
     * values. If autoMargin is true and right side has axis, this property is ignored. Default to 20
     */
    @JsProperty
    public int marginRight;

    /**
     * Flag which should be set to false if you need margins to be recalculated on next chart.validateNow() call.
     * Default to false
     */
    @JsProperty
    public boolean marginsUpdated;

    /**
     * Number of pixels between the container's top border and plot area. This space can be used for top axis' values.
     * If autoMargin is true and top side has axis, this property is ignored. Default to 20
     */
    @JsProperty
    public int marginTop;

    /**
     * Maximum zoom factor value axes. Default to 20
     */
    @JsProperty
    public int maxZoomFactor;

    /**
     * If bottom side has a value axis and autoMargins is set to true (default), the margin of this side will be not
     * less than set on minMarginBottom property.
     */
    @JsProperty
    public int minMarginBottom;

    /**
     * If left side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginLeft property.
     */
    @JsProperty
    public int minMarginLeft;

    /**
     * If right side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginRight property.
     */
    @JsProperty
    public int minMarginRight;

    /**
     * If top side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginTop property.
     */
    @JsProperty
    public int minMarginTop;

    /**
     * The opacity of plot area's border. Value range is 0 - 1. Default to 0
     */
    @JsProperty
    public double plotAreaBorderAlpha;

    /**
     * The color of the plot area's border. Note, the it is invisible by default, as plotAreaBorderAlpha default value
     * is 0. Set it to a value higher than 0 to make it visible. Default to #000000
     */
    @JsProperty
    public String plotAreaBorderColor;

    /**
     * Opacity of plot area. Plural form is used to keep the same property names as our Flex charts'. Flex charts can
     * accept array of numbers to generate gradients. Although you can set array here, only first value of this array
     * will be used. Default to 0
     */
    @JsProperty
    public double plotAreaFillAlphas;

    /**
     * You can set both one color if you need a solid color or array of colors to generate gradients, for example:
     * ["#000000", "#0000CC"]. Default to #FFFFFF
     */
    @JsProperty
    public String plotAreaFillColors;

    /**
     * If you are using gradients to fill the plot area, you can use this property to set gradient angle. The only
     * allowed values are horizontal and vertical: 0, 90, 180, 270. Default to 0
     */
    @JsProperty
    public int plotAreaGradientAngle;

    /**
     * Array of trend lines added to a chart. You can add trend lines to a chart using this array or access already
     * existing trend lines
     */
    @JsProperty
    public TrendLine[] trendLines;

    /**
     * Opacity of zoom-out button background. Default to 0
     */
    @JsProperty
    public double zoomOutButtonAlpha;

    /**
     * Zoom-out button background color. Default to #e5e5e5
     */
    @JsProperty
    public String zoomOutButtonColor;

    /**
     * Name of zoom-out button image. In the images folder there is another lens image, called lensWhite.png.
     * You might want to have white lens when background is dark. Or you can simply use your own image. Note,
     * you don't have to set image extension. If svgIcons is set to true (default) .svg will be added to the
     * file name if SVG is supported by the browser, otherwise – .png. Default to "lens"
     */
    @JsProperty
    public String zoomOutButtonImage;

    /**
     * Size of zoom-out button image. Default to 17
     */
    @JsProperty
    public int zoomOutButtonImageSize;

    /**
     * Padding around the text and image. Default to 8
     */
    @JsProperty
    public int zoomOutButtonPadding;

    /**
     * Opacity of zoom-out button background when mouse is over it. Default to 1
     */
    @JsProperty
    public double zoomOutButtonRollOverAlpha;

    /**
     * In case you set it to some number, the chart will set focus on zoom-out button when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read zoomOutText. If user clicks Enter when a focus is
     * set, the chart will zoom-out. Note, not all browsers and readers support this.
     */
    @JsProperty
    public int zoomOutButtonTabIndex;

    /**
     * Text in the zoom-out button. Default to "Show All"
     */
    @JsProperty
    public String zoomOutText;

    /**
     * Adds a {@link ChartCursor} object to a chart
     */
    @JsMethod
    public native void addChartCursor(ChartCursor chartCursor);

    /**
     * Adds a {@link ChartScrollbar} to a chart
     */
    @JsMethod
    public native void addChartScrollbar(ChartScrollbar chartScrollBar);

    /**
     * Adds a {@link TrendLine} to a chart. You should call chart.validateNow() after this method is called in order the trend
     * line to be visible.
     */
    @JsMethod
    public native void addTrendLine(TrendLine trendLine);

    /**
     * Removes cursor from the chart
     */
    @JsMethod
    public native void removeChartCursor();

    /**
     * Removes scrollbar from the chart
     */
    @JsMethod
    public native void removeChartScrollbar();

    /**
     * Removes a trend line from a chart. You should call chart.validateNow() in order the changes to be visible.
     */
    @JsMethod
    public native void removeTrendLine(TrendLine trendLine);

    /**
     * Zooms-out value axes.
     */
    @JsMethod
    public native void zoomOutValueAxes();
}