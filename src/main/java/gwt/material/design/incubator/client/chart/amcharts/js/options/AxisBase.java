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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.Position;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import jsinterop.annotations.*;

//@formatter:off

/**
 * Base class for {@link ValueAxis} and {@link CategoryAxis}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AxisBase">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AxisBase {

    @JsProperty
    private boolean autoGridCount;

    @JsProperty
    private int autoRotateAngle;

    @JsProperty
    private int autoRotateCount;

    @JsProperty
    private double axisAlpha;

    @JsProperty
    private String axisColor;

    @JsProperty
    private int axisThickness;

    @JsProperty
    private int axisX;

    @JsProperty
    private int axisY;

    @JsProperty
    private AmBalloon balloon;

    @JsProperty
    private boolean boldLabels;

    @JsProperty
    private boolean boldPeriodBeginning;

    @JsProperty
    private boolean centerLabelOnFullPeriod;

    @JsProperty
    private boolean centerLabels;

    @JsProperty
    private boolean centerRotatedLabels;

    @JsProperty
    private String color;

    @JsProperty
    private int dashLength;

    @JsProperty
    private Object[] dateFormats;

    @JsProperty
    private double fillAlpha;

    @JsProperty
    private String fillColor;

    @JsProperty
    private int firstDayOfWeek;

    @JsProperty
    private int fontSize;

    @JsProperty
    private double gridAlpha;

    @JsProperty
    private String gridColor;

    @JsProperty
    private int gridCount;

    @JsProperty
    private int gridThickness;

    @JsProperty
    private Guide[] guides;

    @JsProperty
    private boolean ignoreAxisWidth;

    @JsProperty
    private boolean inside;

    @JsProperty
    private int labelFrequency;

    @JsProperty
    private int labelOffset;

    @JsProperty
    private int labelRotation;

    @JsProperty
    private boolean labelsEnabled;

    @JsProperty
    private Object[] listeners;

    @JsProperty
    private boolean markPeriodChange;

    @JsProperty
    private int minHorizontalGap;

    @JsProperty
    private double minorGridAlpha;

    @JsProperty
    private boolean minorGridEnabled;

    @JsProperty
    private int minorTickLength;

    @JsProperty
    private int minVerticalGap;

    @JsProperty
    private int offset;

    @JsProperty
    private String position;

    @JsProperty
    private boolean showFirstLabel;

    @JsProperty
    private boolean showLastLabel;

    @JsProperty
    private int tickLength;

    @JsProperty
    private String title;

    @JsProperty
    private boolean titleBold;

    @JsProperty
    private String titleColor;

    @JsProperty
    private int titleFontSize;

    @JsProperty
    private int titleRotation;

    /**
     * Specifies whether number of gridCount is specified automatically, acoarding to the axis size. Default to true
     */
    @JsOverlay
    public final void setAutoGridCount(boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
    }

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount. Works on horizontal axis only. It is
     * not recommended to use it with charts with zoom/scroll features, as chart adjusts margin only based on initial
     * render.
     */
    @JsOverlay
    public final void setAutoRotateAngle(int autoRotateAngle) {
        this.autoRotateAngle = autoRotateAngle;
    }

    /**
     * If the number of category axis items will exceed the autoRotateCount, the labels will be rotated by
     * autoRotateAngle degree. Works on horizontal axis only. Not recommended with scrollable/zoomable charts.
     */
    @JsOverlay
    public final void setAutoRotateCount(int autoRotateCount) {
        this.autoRotateCount = autoRotateCount;
    }

    /**
     * Axis opacity. Value range is 0 - 1. Default to 1
     */
    @JsOverlay
    public final void setAxisAlpha(double axisAlpha) {
        this.axisAlpha = axisAlpha;
    }

    /**
     * Axis color. Default to #000000
     */
    @JsOverlay
    public final void setAxisColor(String axisColor) {
        this.axisColor = axisColor;
    }

    /**
     * Thickness of the axis. Default to 1
     */
    @JsOverlay
    public final void setAxisThickness(int axisThickness) {
        this.axisThickness = axisThickness;
    }

    /**
     * Read-only. Returns x coordinate of the axis.
     */
    @JsOverlay
    public final void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    /**
     * Read-only. Returns y coordinate of the axis.
     */
    @JsOverlay
    public final void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    /**
     * Allows customizing axes balloons individually.
     */
    @JsOverlay
    public final void setBalloon(AmBalloon balloon) {
        this.balloon = balloon;
    }

    /**
     * Specifies if axis labels should be bold or not. Default to false
     */
    @JsOverlay
    public final void setBoldLabels(boolean boldLabels) {
        this.boldLabels = boldLabels;
    }

    /**
     * When parse dates is on for the category axis, the chart will try to highlight the beginning of the periods,
     * like month, in bold. Set this to false to disable the functionality. Default to true
     */
    @JsOverlay
    public final void setBoldPeriodBeginning(boolean boldPeriodBeginning) {
        this.boldPeriodBeginning = boldPeriodBeginning;
    }

    /**
     * This setting works only when parseDates is set to true and equalSpacing is set to false. In case you set it to false,
     * labels will never be centered between grid lines. Default to true
     */
    @JsOverlay
    public final void setCenterLabelOnFullPeriod(boolean centerLabelOnFullPeriod) {
        this.centerLabelOnFullPeriod = centerLabelOnFullPeriod;
    }

    /**
     * Force-centers labels of date-based axis (in case it's category axis, equalSpacing must be false). Default to false
     */
    @JsOverlay
    public final void setCenterLabels(boolean centerLabels) {
        this.centerLabels = centerLabels;
    }

    /**
     * In case you have rotated labels on horizontal axis, you can force-center them using this property. Default to false
     */
    @JsOverlay
    public final void setCenterRotatedLabels(boolean centerRotatedLabels) {
        this.centerRotatedLabels = centerRotatedLabels;
    }

    /**
     * Color of axis value labels. Will use chart's color if not set.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Length of a dash. 0 means line is not dashed. Default to 0
     */
    @JsOverlay
    public final void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    /**
     * Date formats of different periods. Possible period values: fff - milliseconds, ss - seconds, mm - minutes,
     * hh - hours, DD - days, MM - months, WW - weeks, YYYY - years. Check this page for date formatting strings.
     */
    @JsOverlay
    public final void setDateFormats(Object[] dateFormats) {
        this.dateFormats = dateFormats;
    }

    /**
     * Fill opacity. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater
     * than 0 to see the fills. Default to 0
     */
    @JsOverlay
    public final void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    /**
     * Fill color. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater than
     * 0 to see the fills. Default to #FFFFFF
     */
    @JsOverlay
    public final void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    /**
     * Sets first day of the week. 0 is Sunday, 1 is Monday, etc. Default to 1
     */
    @JsOverlay
    public final void setFirstDayOfWeek(int firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */
    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * Opacity of grid lines. Default to 0.15
     */
    @JsOverlay
    public final void setGridAlpha(double gridAlpha) {
        this.gridAlpha = gridAlpha;
    }

    /**
     * Color of grid lines. Default to #000000
     */
    @JsOverlay
    public final void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }

    /**
     * Number of grid lines. In case this is value axis, or your categoryAxis parses dates, the number is approximate.
     * The default value is 5. If you set autoGridCount to true, this property is ignored. Default to 5
     */
    @JsOverlay
    public final void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    /**
     * Thickness of grid lines. Default to 1
     */
    @JsOverlay
    public final void setGridThickness(int gridThickness) {
        this.gridThickness = gridThickness;
    }

    /**
     * The array of guides belonging to this axis.
     */
    @JsOverlay
    public final void setGuides(Guide[] guides) {
        this.guides = guides;
    }

    /**
     * If autoMargins of a chart is set to true, but you want this axis not to be measured when calculating margin,
     * set ignoreAxisWidth to true. Default to false
     */
    @JsOverlay
    public final void setIgnoreAxisWidth(boolean ignoreAxisWidth) {
        this.ignoreAxisWidth = ignoreAxisWidth;
    }

    /**
     * Specifies whether values should be placed inside or outside plot area. Default to false
     */
    @JsOverlay
    public final void setInside(boolean inside) {
        this.inside = inside;
    }

    /**
     * Frequency at which labels should be placed. Doesn't work for CategoryAxis if parseDates is set to true. Default
     * to 1
     */
    @JsOverlay
    public final void setLabelFrequency(int labelFrequency) {
        this.labelFrequency = labelFrequency;
    }

    /**
     * You can use it to adjust position of axes labels. Works both with CategoryAxis and ValueAxis. Default to 0
     */
    @JsOverlay
    public final void setLabelOffset(int labelOffset) {
        this.labelOffset = labelOffset;
    }

    /**
     * Rotation angle of a label. Only horizontal axis' values can be rotated. If you set this for vertical axis, the
     * setting will be ignored. Possible values from -90 to 90. Default to 0
     */
    @JsOverlay
    public final void setLabelRotation(int labelRotation) {
        this.labelRotation = labelRotation;
    }

    /**
     * Specifies whether axis displays category axis' labels and value axis' values. Default to true
     */
    @JsOverlay
    public final void setLabelsEnabled(boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickItem",
     * "method":handleEvent}];
     */
    @JsOverlay
    public final void setListeners(Object[] listeners) {
        this.listeners = listeners;
    }

    /**
     * If you set it to false, the start of longer periods won't use a different date format and won't be bold. Default
     * to true
     */
    @JsOverlay
    public final void setMarkPeriodChange(boolean markPeriodChange) {
        this.markPeriodChange = markPeriodChange;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell width
     * required for one span between grid lines. Default to 75
     */
    @JsOverlay
    public final void setMinHorizontalGap(int minHorizontalGap) {
        this.minHorizontalGap = minHorizontalGap;
    }

    /**
     * Opacity of minor grid. In order minor to be visible, you should set minorGridEnabled to true. Default to 0.07
     */
    @JsOverlay
    public final void setMinorGridAlpha(double minorGridAlpha) {
        this.minorGridAlpha = minorGridAlpha;
    }

    /**
     * Specifies if minor grid should be displayed. Default to false
     * <p>
     * NOTE: If equalSpacing is set to true, this setting will be ignored.
     */
    @JsOverlay
    public final void setMinorGridEnabled(boolean minorGridEnabled) {
        this.minorGridEnabled = minorGridEnabled;
    }

    /**
     * Length of minor grid tick. Default to 0
     */
    @JsOverlay
    public final void setMinorTickLength(int minorTickLength) {
        this.minorTickLength = minorTickLength;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell height
     * required for one span between grid lines. Default to 35
     */
    @JsOverlay
    public final void setMinVerticalGap(int minVerticalGap) {
        this.minVerticalGap = minVerticalGap;
    }

    /**
     * The distance of the axis to the plot area, in pixels. Negative values can also be used. Default to 0
     */
    @JsOverlay
    public final void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Possible values are: "top", "bottom", "left", "right". If axis is vertical, default position is "left".
     * If axis is horizontal, default position is "bottom".
     */
    @JsOverlay
    public final void setPosition(Position position) {
        this.position = position.getName();
    }

    /**
     * Whether to show first axis label or not. This works properly only on ValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * first label. Default to true
     */
    @JsOverlay
    public final void setShowFirstLabel(boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
    }

    /**
     * Whether to show last axis label or not. This works properly only on ValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * last label. Default to true
     */
    @JsOverlay
    public final void setShowLastLabel(boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
    }

    /**
     * Length of the tick marks. Default to 5
     */
    @JsOverlay
    public final void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    /**
     * Title of the axis.
     */
    @JsOverlay
    public final void setTitle(String title) {
        this.title = title;
    }

    /**
     * Specifies if title should be bold or not. Default to true
     */
    @JsOverlay
    public final void setTitleBold(boolean titleBold) {
        this.titleBold = titleBold;
    }

    /**
     * Color of axis title. Will use text color of chart if not set any.
     */
    @JsOverlay
    public final void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    /**
     * Font size of axis title. Will use font size of chart plus two pixels if not set any.
     */
    @JsOverlay
    public final void setTitleFontSize(int titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    /**
     * Rotation of axis title. Useful if you want to make vertical axis title to be shown from top to down.
     */
    @JsOverlay
    public final void setTitleRotation(int titleRotation) {
        this.titleRotation = titleRotation;
    }

    /**
     * Adds guide to the axis.
     */
    @JsMethod
    public native void addGuide(Guide guide);

    /**
     * Removes guide from the axis.
     */
    @JsMethod
    public native void removeGuide(Guide guide);

    // TODO Events
}
