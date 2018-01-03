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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.*;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

import java.util.Date;

//@formatter:off

/**
 * Extension for ValueAxis to create an axis for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart},
 * {@link gwt.material.design.incubator.client.chart.chartjs.RadarChart}, {@link gwt.material.design.incubator.client.chart.amcharts.XyChart}
 * charts, multiple can be assigned. Gets automatically populated, one for AmSerialChart and two for AmXYChart charts,
 * if none has been specified.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ValueAxis">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ValueAxis extends AxisBase {

    @JsProperty
    private boolean autoWrap;

    @JsProperty
    private int axisFrequency;

    @JsProperty
    private int axisTitleOffset;

    @JsProperty
    private Object balloonTextFunction;

    @JsProperty
    private int baseCoord;

    @JsProperty
    private int baseValue;

    @JsProperty
    private String duration;

    @JsProperty
    private Object durationUnits;

    @JsProperty
    private String gridType;

    @JsProperty
    private String id;

    @JsProperty
    private boolean includeAllValues;

    @JsProperty
    private boolean includeGuidesInMinMax;

    @JsProperty
    private boolean includeHidden;

    @JsProperty
    private boolean integersOnly;

    @JsProperty
    private Functions.Func labelFunction;

    @JsProperty
    private boolean logarithmic;

    @JsProperty
    private int max;

    @JsProperty
    private int maximum;

    @JsProperty
    private Date maximumDate;

    @JsProperty
    private int min;

    @JsProperty
    private int minimum;

    @JsProperty
    private Date minimumDate;

    @JsProperty
    private int minMaxMultiplier;

    @JsProperty
    private String minPeriod;

    @JsProperty
    private String pointPosition;

    @JsProperty
    private int precision;

    @JsProperty
    private boolean radarCategoriesEnabled;

    @JsProperty
    private boolean recalculateToPercents;

    @JsProperty
    private boolean reversed;

    @JsProperty
    private String stackType;

    @JsProperty
    private int step;

    @JsProperty
    private boolean strictMinMax;

    @JsProperty
    private int synchronizationMultiplier;

    @JsProperty
    private ValueAxis synchronizeWith;

    @JsProperty
    private String totalText;

    @JsProperty
    private String totalTextColor;

    @JsProperty
    private int totalTextOffset;

    @JsProperty
    private int treatZeroAs;

    @JsProperty
    private String type;

    @JsProperty
    private String unit;

    @JsProperty
    private String unitPosition;

    @JsProperty
    private boolean usePrefixes;

    @JsProperty
    private boolean useScientificNotation;

    @JsProperty
    private double zeroGridAlpha;

    /**
     * If this is set to true and the label does not fit, it will be wrapped. Works only on horizontal value axes. Default
     * to false
     */
    @JsOverlay
    public final void setAutoWrap(boolean autoWrap) {
        this.autoWrap = autoWrap;
    }

    /**
     * Works with Radar chart only. If you have a big number of axes, this property will help you to show every x axis only.
     * Default to 1
     */
    @JsOverlay
    public final void setAxisFrequency(int axisFrequency) {
        this.axisFrequency = axisFrequency;
    }

    /**
     * Radar chart only. Specifies distance from axis to the axis title (category). Default to 10
     */
    @JsOverlay
    public final void setAxisTitleOffset(int axisTitleOffset) {
        this.axisTitleOffset = axisTitleOffset;
    }

    /**
     * You can use this function to format balloon text of the axis. This function is called and balloon text or date
     * (if axis is date-based) is passed as an argument. It should return string which will be displayed in the balloon.
     */
    @JsOverlay
    public final void setBalloonTextFunction(Object balloonTextFunction) {
        this.balloonTextFunction = balloonTextFunction;
    }

    /**
     * Read-only. Coordinate of the base value.
     */
    @JsOverlay
    public final void setBaseCoord(int baseCoord) {
        this.baseCoord = baseCoord;
    }

    /**
     * Specifies base value of the axis. Default to 0
     */
    @JsOverlay
    public final void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    /**
     * If your values represents time units, and you want value axis labels to be formatted as duration, you have to set
     * the duration unit. Possible values are: "ss", "mm", "hh" and "DD".
     */
    @JsOverlay
    public final void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * If duration property is set, you can specify what string should be displayed next to day, hour, minute and second.
     */
    @JsOverlay
    public final void setDurationUnits(Object durationUnits) {
        this.durationUnits = durationUnits;
    }

    /**
     * Radar chart only. Possible values are: "polygons" and "circles". Set "circles" for polar charts. Default to
     * {@link GridType#POLYGONS}
     */
    @JsOverlay
    public final void setGridType(GridType gridType) {
        this.gridType = gridType.getName();
    }

    /**
     * Unique id of value axis. It is not required to set it, unless you need to tell the graph which exact value axis
     * it should use.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * If you set it to true, minimum and maximum of value axis will not change while zooming/scrolling. Default to false
     */
    @JsOverlay
    public final void setIncludeAllValues(boolean includeAllValues) {
        this.includeAllValues = includeAllValues;
    }

    /**
     * Specifies whether guide values should be included when calculating min and max of the axis. Default to false
     */
    @JsOverlay
    public final void setIncludeGuidesInMinMax(boolean includeGuidesInMinMax) {
        this.includeGuidesInMinMax = includeGuidesInMinMax;
    }

    /**
     * If true, the axis will include hidden graphs when calculating min and max values. Default to false
     */
    @JsOverlay
    public final void setIncludeHidden(boolean includeHidden) {
        this.includeHidden = includeHidden;
    }

    /**
     * Specifies whether values on axis can only be integers or both integers and doubles. Default to false
     */
    @JsOverlay
    public final void setIntegersOnly(boolean integersOnly) {
        this.integersOnly = integersOnly;
    }

    /**
     * You can use this function to format Value axis labels. This function is called and these parameters are passed:
     * labelFunction(value, valueText, valueAxis);
     * Where value is numeric value, valueText is formatted string and valueAxis is a reference to valueAxis object.
     * <p>
     * If axis type is "date", labelFucntion will pass different arguments:
     * labelFunction(valueText, date, valueAxis)
     * <p>
     * Your function should return string.
     */
    @JsOverlay
    public final void setLabelFunction(Functions.Func labelFunction) {
        this.labelFunction = labelFunction;
    }

    /**
     * Specifies if this value axis' scale should be logarithmic. Default to false
     */
    @JsOverlay
    public final void setLogarithmic(boolean logarithmic) {
        this.logarithmic = logarithmic;
    }

    /**
     * Read-only. Maximum value of the axis.
     */
    @JsOverlay
    public final void setMax(int max) {
        this.max = max;
    }

    /**
     * If you don't want max value to be calculated by the chart, set it using this property. This value might still
     * be adjusted so that it would be possible to draw grid at rounded intervals.
     */
    @JsOverlay
    public final void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    /**
     * If your value axis is date-based, you can specify maximum date of the axis. Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */
    @JsOverlay
    public final void setMaximumDate(Date maximumDate) {
        this.maximumDate = maximumDate;
    }

    /**
     * Read-only. Minimum value of the axis.
     */
    @JsOverlay
    public final void setMin(int min) {
        this.min = min;
    }

    /**
     * If you don't want min value to be calculated by the chart, set it using this property. This value might still be
     * adjusted so that it would be possible to draw grid at rounded intervals.
     */
    @JsOverlay
    public final void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    /**
     * If your value axis is date-based, you can specify minimum date of the axis. Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */
    @JsOverlay
    public final void setMinimumDate(Date minimumDate) {
        this.minimumDate = minimumDate;
    }

    /**
     * If set value axis scale (min and max numbers) will be multiplied by it. I.e. if set to 1.2 the scope of values
     * will increase by 20%. Default to 1
     */
    @JsOverlay
    public final void setMinMaxMultiplier(int minMaxMultiplier) {
        this.minMaxMultiplier = minMaxMultiplier;
    }

    /**
     * Specifies the shortest period of your data. This will work only if you set the `type` of your value axis to `"date"`.
     * <p>
     * Possible period values: fff - milliseconds, ss - seconds, mm - minutes, hh - hours, DD - days, MM - months, YYYY - years.
     * <p>
     * It's also possible to supply a number for increments, i.e. "15mm" which will instruct the chart that your data is
     * supplied in 15 minute increments.
     */
    @JsOverlay
    public final void setMinPeriod(Period minPeriod) {
        this.minPeriod = minPeriod.getValue();
    }

    /**
     * Works with radar charts only. If you set it to “middle”, labels and data points will be placed in the middle
     * between axes.
     */
    @JsOverlay
    public final void setPointPosition(String pointPosition) {
        this.pointPosition = pointPosition;
    }

    /**
     * Precision (number of decimals) of values.
     */
    @JsOverlay
    public final void setPrecision(int precision) {
        this.precision = precision;
    }

    /**
     * Radar chart only. Specifies if categories (axes' titles) should be displayed near axes). Default to true
     */
    @JsOverlay
    public final void setRadarCategoriesEnabled(boolean radarCategoriesEnabled) {
        this.radarCategoriesEnabled = radarCategoriesEnabled;
    }

    /**
     * Specifies if graphs's values should be recalculated to percents. Default to false
     */
    @JsOverlay
    public final void setRecalculateToPercents(boolean recalculateToPercents) {
        this.recalculateToPercents = recalculateToPercents;
    }

    /**
     * Specifies if value axis should be reversed (smaller values on top). Default to false
     */
    @JsOverlay
    public final void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    /**
     * Stacking mode of the axis. Possible values are: "none", "regular", "100%", "3d".
     * Note, only graphs of one type will be stacked. Default to {@link StackType.NONE}
     */
    @JsOverlay
    public final void setStackType(StackType stackType) {
        this.stackType = stackType.getName();
    }

    /**
     * Read-only. Value difference between two grid lines.
     */
    @JsOverlay
    public final void setStep(int step) {
        this.step = step;
    }

    /**
     * If you set minimum and maximum for your axis, chart adjusts them so that grid would start and end on the
     * beginning and end of plot area and grid would be at equal intervals. If you set strictMinMax to true, the chart
     * will not adjust minimum and maximum of value axis. Default to false
     */
    @JsOverlay
    public final void setStrictMinMax(boolean strictMinMax) {
        this.strictMinMax = strictMinMax;
    }

    /**
     * In case you synchronize one value axis with another, you need to set the synchronization multiplier. Use
     * synchronizeWithAxis method to set with which axis it should be synced.
     */
    @JsOverlay
    public final void setSynchronizationMultiplier(int synchronizationMultiplier) {
        this.synchronizationMultiplier = synchronizationMultiplier;
    }

    /**
     * One value axis can be synchronized with another value axis. You can use both reference to your axis or id of the
     * axis here. You should set synchronizationMultiplyer in order for this to work.
     */
    @JsOverlay
    public final void setSynchronizeWith(ValueAxis synchronizeWith) {
        this.synchronizeWith = synchronizeWith;
    }

    /**
     * If this value axis is stacked and has columns, setting valueAxis.totalText = "[[total]]" will make it to display
     * total value above the most-top column.
     */
    @JsOverlay
    public final void setTotalText(String totalText) {
        this.totalText = totalText;
    }

    /**
     * Color of total text.
     */
    @JsOverlay
    public final void setTotalTextColor(String totalTextColor) {
        this.totalTextColor = totalTextColor;
    }

    /**
     * Distance from data point to total text. Default to 0
     */
    @JsOverlay
    public final void setTotalTextOffset(int totalTextOffset) {
        this.totalTextOffset = totalTextOffset;
    }

    /**
     * This allows you to have logarithmic value axis and have zero values in the data. You must set it to >0 value in
     * order to work. Default to 0
     */
    @JsOverlay
    public final void setTreatZeroAs(int treatZeroAs) {
        this.treatZeroAs = treatZeroAs;
    }

    /**
     * Type of value axis. If your values in data provider are dates and you want this axis to show dates instead of
     * numbers, set it to "date".
     */
    @JsOverlay
    public final void setType(ValueAxisType type) {
        this.type = type.getName();
    }

    /**
     * Unit which will be added to the value label.
     */
    @JsOverlay
    public final void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Position of the unit. Possible values are "left" and "right". Default {@link UnitPosition#RIGHT}
     */
    @JsOverlay
    public final void setUnitPosition(UnitPosition unitPosition) {
        this.unitPosition = unitPosition.getName();
    }

    /**
     * If true, prefixes will be used for big and small numbers. You can set arrays of prefixes directly to the chart
     * object via prefixesOfSmallNumbers and prefixesOfBigNumbers. Default to false
     */
    @JsOverlay
    public final void setUsePrefixes(boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
    }

    /**
     * If true, values will always be formatted using scientific notation (5e+8, 5e-8...) Otherwise only values bigger
     * then 1e+21 and smaller then 1e-7 will be displayed in scientific notation. Default to false
     */
    @JsOverlay
    public final void setUseScientificNotation(boolean useScientificNotation) {
        this.useScientificNotation = useScientificNotation;
    }

    /**
     * Opacity of a zero grid line. By default it is equal to 2 x gridAlpha.
     */
    @JsOverlay
    public final void setZeroGridAlpha(double zeroGridAlpha) {
        this.zeroGridAlpha = zeroGridAlpha;
    }

    /**
     * Adds event listener to the object.
     */
    @JsMethod
    public native void addListener(String type, Functions.Func handler);

    /**
     * Returns value of the coordinate.
     */
    @JsMethod
    public native void coordinateToValue(int x, int y);

    /**
     * Returns coordinate of the value in pixels.
     */
    @JsMethod
    public native int[] getCoordinate(int value);

    /**
     * Removes event listener from the object
     */
    @JsMethod
    public native void removeListener(Object object, String type, Functions.Func handler);

    /**
     * One value axis can be synchronized with another value axis. You should set synchronizationMultiplyer in order
     * for this to work.
     */
    @JsMethod
    public native void synchronizeWithAxis(ValueAxis axis);

    /**
     * Zooms out the value axis to full scale.
     */
    @JsMethod
    public native void zoomOut();

    /**
     * Zooms-in the axis to the provided values.
     */
    @JsMethod
    public native void zoomToValues(int startValue, int endValue);

    @JsOverlay
    public final boolean isAutoWrap() {
        return autoWrap;
    }

    @JsOverlay
    public final int getAxisFrequency() {
        return axisFrequency;
    }

    @JsOverlay
    public final int getAxisTitleOffset() {
        return axisTitleOffset;
    }

    @JsOverlay
    public final Object getBalloonTextFunction() {
        return balloonTextFunction;
    }

    @JsOverlay
    public final int getBaseCoord() {
        return baseCoord;
    }

    @JsOverlay
    public final int getBaseValue() {
        return baseValue;
    }

    @JsOverlay
    public final String getDuration() {
        return duration;
    }

    @JsOverlay
    public final Object getDurationUnits() {
        return durationUnits;
    }

    @JsOverlay
    public final String getGridType() {
        return gridType;
    }

    @JsOverlay
    public final String getId() {
        return id;
    }

    @JsOverlay
    public final boolean isIncludeAllValues() {
        return includeAllValues;
    }

    @JsOverlay
    public final boolean isIncludeGuidesInMinMax() {
        return includeGuidesInMinMax;
    }

    @JsOverlay
    public final boolean isIncludeHidden() {
        return includeHidden;
    }

    @JsOverlay
    public final boolean isIntegersOnly() {
        return integersOnly;
    }

    @JsOverlay
    public final Functions.Func getLabelFunction() {
        return labelFunction;
    }

    @JsOverlay
    public final boolean isLogarithmic() {
        return logarithmic;
    }

    @JsOverlay
    public final int getMax() {
        return max;
    }

    @JsOverlay
    public final int getMaximum() {
        return maximum;
    }

    @JsOverlay
    public final Date getMaximumDate() {
        return maximumDate;
    }

    @JsOverlay
    public final int getMin() {
        return min;
    }

    @JsOverlay
    public final int getMinimum() {
        return minimum;
    }

    @JsOverlay
    public final Date getMinimumDate() {
        return minimumDate;
    }

    @JsOverlay
    public final int getMinMaxMultiplier() {
        return minMaxMultiplier;
    }

    @JsOverlay
    public final String getMinPeriod() {
        return minPeriod;
    }

    @JsOverlay
    public final String getPointPosition() {
        return pointPosition;
    }

    @JsOverlay
    public final int getPrecision() {
        return precision;
    }

    @JsOverlay
    public final boolean isRadarCategoriesEnabled() {
        return radarCategoriesEnabled;
    }

    @JsOverlay
    public final boolean isRecalculateToPercents() {
        return recalculateToPercents;
    }

    @JsOverlay
    public final boolean isReversed() {
        return reversed;
    }

    @JsOverlay
    public final String getStackType() {
        return stackType;
    }

    @JsOverlay
    public final int getStep() {
        return step;
    }

    @JsOverlay
    public final boolean isStrictMinMax() {
        return strictMinMax;
    }

    @JsOverlay
    public final int getSynchronizationMultiplier() {
        return synchronizationMultiplier;
    }

    @JsOverlay
    public final ValueAxis getSynchronizeWith() {
        return synchronizeWith;
    }

    @JsOverlay
    public final String getTotalText() {
        return totalText;
    }

    @JsOverlay
    public final String getTotalTextColor() {
        return totalTextColor;
    }

    @JsOverlay
    public final int getTotalTextOffset() {
        return totalTextOffset;
    }

    @JsOverlay
    public final int getTreatZeroAs() {
        return treatZeroAs;
    }

    @JsOverlay
    public final String getType() {
        return type;
    }

    @JsOverlay
    public final String getUnit() {
        return unit;
    }

    @JsOverlay
    public final String getUnitPosition() {
        return unitPosition;
    }

    @JsOverlay
    public final boolean isUsePrefixes() {
        return usePrefixes;
    }

    @JsOverlay
    public final boolean isUseScientificNotation() {
        return useScientificNotation;
    }

    @JsOverlay
    public final double getZeroGridAlpha() {
        return zeroGridAlpha;
    }

    //TODO Events
}
