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
import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

//@formatter:off

/**
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeAxis {

    @JsProperty
    private double axisAlpha;

    @JsProperty
    private String axisColor;

    @JsProperty
    private int axisThickness;

    @JsProperty
    private double bandAlpha;

    @JsProperty
    private int[] bandGradientRatio;

    @JsProperty
    private double bandOutlineAlpha;

    @JsProperty
    private String bandOutlineColor;

    @JsProperty
    private int bandOutlineThickness;

    @JsProperty
    private GaugeBand[] bands;

    @JsProperty
    private String bottomText;

    @JsProperty
    private boolean bottomTextBold;

    @JsProperty
    private String bottomTextColor;

    @JsProperty
    private int bottomTextFontSize;

    @JsProperty
    private int bottomTextYOffset;

    @JsProperty
    private Object centerX;

    @JsProperty
    private Object centerY;

    @JsProperty
    private String color;

    @JsProperty
    private int endAngle;

    @JsProperty
    private int endValue;

    @JsProperty
    private int fontSize;

    @JsProperty
    private int gridCount;

    @JsProperty
    private boolean gridInside;

    @JsProperty
    private int id;

    @JsProperty
    private boolean inside;

    @JsProperty
    private int labelFrequency;

    @JsProperty
    private Functions.Func labelFunction;

    @JsProperty
    private int labelOffset;

    @JsProperty
    private boolean labelsEnabled;

    @JsProperty
    private Object[] listeners;

    @JsProperty
    private int minorTickInterval;

    @JsProperty
    private int minorTickLength;

    @JsProperty
    private Object radius;

    @JsProperty
    private boolean showFirstLabel;

    @JsProperty
    private boolean showLastLabel;

    @JsProperty
    private int startAngle;

    @JsProperty
    private int startValue;

    @JsProperty
    private double tickAlpha;

    @JsProperty
    private String tickColor;

    @JsProperty
    private int tickLength;

    @JsProperty
    private int tickThickness;

    @JsProperty
    private String topText;

    @JsProperty
    private boolean topTextBold;

    @JsProperty
    private String topTextColor;

    @JsProperty
    private int topTextFontSize;

    @JsProperty
    private int topTextYOffset;

    @JsProperty
    private String unit;

    @JsProperty
    private String unitPosition;

    @JsProperty
    private boolean usePrefixes;

    @JsProperty
    private int valueInterval;

    @JsOverlay
    public final double getAxisAlpha() {
        return axisAlpha;
    }

    /**
     * Axis opacity. Default to 1
     */
    @JsOverlay
    public final void setAxisAlpha(double axisAlpha) {
        this.axisAlpha = axisAlpha;
    }

    @JsOverlay
    public final String getAxisColor() {
        return axisColor;
    }

    /**
     * Axis color. Default to #000000
     */
    @JsOverlay
    public final void setAxisColor(String axisColor) {
        this.axisColor = axisColor;
    }

    @JsOverlay
    public final int getAxisThickness() {
        return axisThickness;
    }

    /**
     * Thickness of the axis outline. Default to 1
     */
    @JsOverlay
    public final void setAxisThickness(int axisThickness) {
        this.axisThickness = axisThickness;
    }

    @JsOverlay
    public final double getBandAlpha() {
        return bandAlpha;
    }

    /**
     * Opacity of band fills. Default to 1
     */
    @JsOverlay
    public final void setBandAlpha(double bandAlpha) {
        this.bandAlpha = bandAlpha;
    }

    @JsOverlay
    public final int[] getBandGradientRatio() {
        return bandGradientRatio;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make bands to be filled with color gradients. Negative value means the color will
     * be darker than the original, and positive number means the color will be lighter.
     */
    @JsOverlay
    public final void setBandGradientRatio(int[] bandGradientRatio) {
        this.bandGradientRatio = bandGradientRatio;
    }

    @JsOverlay
    public final double getBandOutlineAlpha() {
        return bandOutlineAlpha;
    }

    /**
     * Opacity of band outlines. Default to 0
     */
    @JsOverlay
    public final void setBandOutlineAlpha(double bandOutlineAlpha) {
        this.bandOutlineAlpha = bandOutlineAlpha;
    }

    @JsOverlay
    public final String getBandOutlineColor() {
        return bandOutlineColor;
    }

    /**
     * Color of band outlines. Default to #000000
     */
    @JsOverlay
    public final void setBandOutlineColor(String bandOutlineColor) {
        this.bandOutlineColor = bandOutlineColor;
    }

    @JsOverlay
    public final int getBandOutlineThickness() {
        return bandOutlineThickness;
    }

    /**
     * Thickness of band outlines. Default to 0
     */
    @JsOverlay
    public final void setBandOutlineThickness(int bandOutlineThickness) {
        this.bandOutlineThickness = bandOutlineThickness;
    }

    @JsOverlay
    public final GaugeBand[] getBands() {
        return bands;
    }

    /**
     * Array of bands - GaugeBand objects. Bands are used to draw color fills between specified values.
     */
    @JsOverlay
    public final void setBands(GaugeBand[] bands) {
        this.bands = bands;
    }

    @JsOverlay
    public final String getBottomText() {
        return bottomText;
    }

    @JsOverlay
    public final boolean isBottomTextBold() {
        return bottomTextBold;
    }

    /**
     * Specifies if text should be bold.
     */
    @JsOverlay
    public final void setBottomTextBold(boolean bottomTextBold) {
        this.bottomTextBold = bottomTextBold;
    }

    @JsOverlay
    public final String getBottomTextColor() {
        return bottomTextColor;
    }

    /**
     * Bottom text color.
     */
    @JsOverlay
    public final void setBottomTextColor(String bottomTextColor) {
        this.bottomTextColor = bottomTextColor;
    }

    @JsOverlay
    public final int getBottomTextFontSize() {
        return bottomTextFontSize;
    }

    /**
     * Font size of bottom text.
     */
    @JsOverlay
    public final void setBottomTextFontSize(int bottomTextFontSize) {
        this.bottomTextFontSize = bottomTextFontSize;
    }

    @JsOverlay
    public final int getBottomTextYOffset() {
        return bottomTextYOffset;
    }

    /**
     * Y offset of bottom text. Default to 0
     */
    @JsOverlay
    public final void setBottomTextYOffset(int bottomTextYOffset) {
        this.bottomTextYOffset = bottomTextYOffset;
    }

    @JsOverlay
    public final Object getCenterX() {
        return centerX;
    }

    /**
     * X position of the axis, relative to the center of the gauge. Default to 0%
     */
    @JsOverlay
    public final void setCenterX(Object centerX) {
        this.centerX = centerX;
    }

    @JsOverlay
    public final Object getCenterY() {
        return centerY;
    }

    /**
     * Y position of the axis, relative to the center of the gauge. Default to 0%
     */
    @JsOverlay
    public final void setCenterY(Object centerY) {
        this.centerY = centerY;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    /**
     * Specifies labels color of the axis.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final int getEndAngle() {
        return endAngle;
    }

    /**
     * Axis end angle. Valid values are from - 180 to 180. Default to 120
     */
    @JsOverlay
    public final void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    @JsOverlay
    public final int getEndValue() {
        return endValue;
    }

    /**
     * Axis end (max) value
     */
    @JsOverlay
    public final void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    @JsOverlay
    public final int getFontSize() {
        return fontSize;
    }

    /**
     * Font size for axis labels.
     */
    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final int getGridCount() {
        return gridCount;
    }

    /**
     * Number of grid lines. Note, GaugeAxis doesn't adjust gridCount, so you should check your values and choose a
     * proper gridCount which would result grids at round numbers. Default to 20
     */
    @JsOverlay
    public final void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    @JsOverlay
    public final boolean isGridInside() {
        return gridInside;
    }

    /**
     * Specifies if grid should be drawn inside or outside the axis. Default to true
     */
    @JsOverlay
    public final void setGridInside(boolean gridInside) {
        this.gridInside = gridInside;
    }

    @JsOverlay
    public final int getId() {
        return id;
    }

    /**
     * Unique id of an axis.
     */
    @JsOverlay
    public final void setId(int id) {
        this.id = id;
    }

    @JsOverlay
    public final boolean isInside() {
        return inside;
    }

    /**
     * Specifies if labels should be placed inside or outside the axis. Default to true
     */
    @JsOverlay
    public final void setInside(boolean inside) {
        this.inside = inside;
    }

    @JsMethod
    public native void addListener(String type, Functions.Func handler);

    @JsMethod
    public native void removeListener(AmChart chart, String type, Functions.Func handler);

    @JsMethod
    public native void setBottomText(String text);

    @JsMethod
    public native void setTopText(String text);

    @JsMethod
    public native int value2angle(int value);

    @JsOverlay
    public final int getLabelFrequency() {
        return labelFrequency;
    }

    /**
     * Frequency of labels. Default to 1
     */
    @JsOverlay
    public final void setLabelFrequency(int labelFrequency) {
        this.labelFrequency = labelFrequency;
    }

    @JsOverlay
    public final Functions.Func getLabelFunction() {
        return labelFunction;
    }

    /**
     * You can use this function to format axis labels. This function is called and value is passed as a attribute:
     * labelFunction(value);
     */
    @JsOverlay
    public final void setLabelFunction(Functions.Func labelFunction) {
        this.labelFunction = labelFunction;
    }

    @JsOverlay
    public final int getLabelOffset() {
        return labelOffset;
    }

    /**
     * Distance from axis to the labels. Default to 15
     */
    @JsOverlay
    public final void setLabelOffset(int labelOffset) {
        this.labelOffset = labelOffset;
    }

    @JsOverlay
    public final boolean isLabelsEnabled() {
        return labelsEnabled;
    }

    /**
     * Specifies if labels on the axis should be shown. Default to true
     */
    @JsOverlay
    public final void setLabelsEnabled(boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
    }

    @JsOverlay
    public final Object[] getListeners() {
        return listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickBand", "method":handleClick}];
     */
    @JsOverlay
    public final void setListeners(Object[] listeners) {
        this.listeners = listeners;
    }

    @JsOverlay
    public final int getMinorTickInterval() {
        return minorTickInterval;
    }

    /**
     * Interval, at which minor ticks should be placed.
     */
    @JsOverlay
    public final void setMinorTickInterval(int minorTickInterval) {
        this.minorTickInterval = minorTickInterval;
    }

    @JsOverlay
    public final int getMinorTickLength() {
        return minorTickLength;
    }

    /**
     * Length of a minor tick. Default to 5
     */
    @JsOverlay
    public final void setMinorTickLength(int minorTickLength) {
        this.minorTickLength = minorTickLength;
    }

    @JsOverlay
    public final Object getRadius() {
        return radius;
    }

    /**
     * Axis radius. Default to 95%
     */
    @JsOverlay
    public final void setRadius(Object radius) {
        this.radius = radius;
    }

    @JsOverlay
    public final boolean isShowFirstLabel() {
        return showFirstLabel;
    }

    /**
     * Specifies if the first label should be shown. Default to true
     */
    @JsOverlay
    public final void setShowFirstLabel(boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
    }

    @JsOverlay
    public final boolean isShowLastLabel() {
        return showLastLabel;
    }

    /**
     * Specifies if the last label should be shown. Default to true
     */
    @JsOverlay
    public final void setShowLastLabel(boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
    }

    @JsOverlay
    public final int getStartAngle() {
        return startAngle;
    }

    /**
     * Axis start angle. Valid values are from - 180 to 180. Default to -120
     */
    @JsOverlay
    public final void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    @JsOverlay
    public final int getStartValue() {
        return startValue;
    }

    /**
     * Axis start (min) value. Default to 0
     */
    @JsOverlay
    public final void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    @JsOverlay
    public final double getTickAlpha() {
        return tickAlpha;
    }

    /**
     * Opacity of axis ticks. Default to 1
     */
    @JsOverlay
    public final void setTickAlpha(double tickAlpha) {
        this.tickAlpha = tickAlpha;
    }

    @JsOverlay
    public final String getTickColor() {
        return tickColor;
    }

    /**
     * Color of axis ticks. Default to #555555
     */
    @JsOverlay
    public final void setTickColor(String tickColor) {
        this.tickColor = tickColor;
    }

    @JsOverlay
    public final int getTickLength() {
        return tickLength;
    }

    /**
     * Length of a major tick. Default to 10
     */
    @JsOverlay
    public final void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    @JsOverlay
    public final int getTickThickness() {
        return tickThickness;
    }

    /**
     * Tick thickness. Default to 1
     *
     * @param tickThickness
     */
    @JsOverlay
    public final void setTickThickness(int tickThickness) {
        this.tickThickness = tickThickness;
    }

    @JsOverlay
    public final String getTopText() {
        return topText;
    }

    @JsOverlay
    public final boolean isTopTextBold() {
        return topTextBold;
    }

    /**
     * Specifies if text should be bold. Default to true
     */
    @JsOverlay
    public final void setTopTextBold(boolean topTextBold) {
        this.topTextBold = topTextBold;
    }

    @JsOverlay
    public final String getTopTextColor() {
        return topTextColor;
    }

    /**
     * Color of top text.
     */
    @JsOverlay
    public final void setTopTextColor(String topTextColor) {
        this.topTextColor = topTextColor;
    }

    @JsOverlay
    public final int getTopTextFontSize() {
        return topTextFontSize;
    }

    /**
     * Font size of top text.
     */
    @JsOverlay
    public final void setTopTextFontSize(int topTextFontSize) {
        this.topTextFontSize = topTextFontSize;
    }

    @JsOverlay
    public final int getTopTextYOffset() {
        return topTextYOffset;
    }

    /**
     * Y offset of top text. Default to 0
     */
    @JsOverlay
    public final void setTopTextYOffset(int topTextYOffset) {
        this.topTextYOffset = topTextYOffset;
    }

    @JsOverlay
    public final String getUnit() {
        return unit;
    }

    /**
     * A string which can be placed next to axis labels.
     */
    @JsOverlay
    public final void setUnit(String unit) {
        this.unit = unit;
    }

    @JsOverlay
    public final String getUnitPosition() {
        return unitPosition;
    }

    /**
     * Position of the unit. Default to "right"
     */
    @JsOverlay
    public final void setUnitPosition(Position unitPosition) {
        this.unitPosition = unitPosition.getName();
    }

    @JsOverlay
    public final boolean isUsePrefixes() {
        return usePrefixes;
    }

    /**
     * Specifies if small and big numbers should use prefixes to make them more readable. Default to false
     */
    @JsOverlay
    public final void setUsePrefixes(boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
    }

    @JsOverlay
    public final int getValueInterval() {
        return valueInterval;
    }

    /**
     * Interval, at which ticks with values should be placed.
     */
    @JsOverlay
    public final void setValueInterval(int valueInterval) {
        this.valueInterval = valueInterval;
    }

    // TODO Events
}
