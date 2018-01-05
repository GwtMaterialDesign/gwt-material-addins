package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.*;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.object.LogarithmicAxisFailedData;
import gwt.material.design.incubator.client.chart.amcharts.events.object.ValueAxisChangedData;
import gwt.material.design.incubator.client.chart.amcharts.events.object.ValueAxisZoomedData;
import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.AxisChangedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.AxisZoomedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.LogarithmicAxisFailedEvent;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmAxisBase;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Date;

public class ValueAxis extends AxisBase {

    private AmValueAxis axis = new AmValueAxis();

    @Override
    public void load() {
        super.load();

        addListener(AmChartEvents.AXIS_CHANGED, object -> AxisChangedEvent.fire(this, (ValueAxisChangedData) object));
        addListener(AmChartEvents.AXIS_ZOOMED, object -> AxisZoomedEvent.fire(this, (ValueAxisZoomedData) object));
        addListener(AmChartEvents.LOGARITHMIC_AXIS_FAILED, object -> LogarithmicAxisFailedEvent.fire(this, (LogarithmicAxisFailedData) object));
    }

    @Override
    public void unload() {
        super.unload();

        // TODO Unload Events
    }

    public AmValueAxis getSynchronizeWith() {
        return axis.synchronizeWith;
    }

    /**
     * One value axis can be synchronized with another value axis. You can use both reference to your axis or id of the
     * axis here. You should set synchronizationMultiplyer in order for this to work.
     */

    public void setSynchronizeWith(AmValueAxis synchronizeWith) {
        axis.synchronizeWith = synchronizeWith;
    }

    public boolean isAutoWrap() {
        return axis.autoWrap;
    }

    /**
     * If this is set to true and the label does not fit, it will be wrapped. Works only on horizontal value axes. Default
     * to false
     */

    public void setAutoWrap(boolean autoWrap) {
        axis.autoWrap = autoWrap;
    }

    public int getAxisFrequency() {
        return axis.axisFrequency;
    }

    /**
     * Works with Radar chart only. If you have a big number of axes, this property will help you to show every x axis only.
     * Default to 1
     */

    public void setAxisFrequency(int axisFrequency) {
        axis.axisFrequency = axisFrequency;
    }

    public int getAxisTitleOffset() {
        return axis.axisTitleOffset;
    }

    /**
     * Radar chart only. Specifies distance from axis to the axis title (category). Default to 10
     */

    public void setAxisTitleOffset(int axisTitleOffset) {
        axis.axisTitleOffset = axisTitleOffset;
    }

    public Object getBalloonTextFunction() {
        return axis.balloonTextFunction;
    }

    /**
     * You can use this function to format balloon text of the axis. This function is called and balloon text or date
     * (if axis is date-based) is passed as an argument. It should return string which will be displayed in the balloon.
     */

    public void setBalloonTextFunction(Object balloonTextFunction) {
        axis.balloonTextFunction = balloonTextFunction;
    }

    public int getBaseCoord() {
        return axis.baseCoord;
    }

    /**
     * Read-only. Coordinate of the base value.
     */

    public void setBaseCoord(int baseCoord) {
        axis.baseCoord = baseCoord;
    }

    public int getBaseValue() {
        return axis.baseValue;
    }

    /**
     * Specifies base value of the axis. Default to 0
     */

    public void setBaseValue(int baseValue) {
        axis.baseValue = baseValue;
    }

    public String getDuration() {
        return axis.duration;
    }

    /**
     * If your values represents time units, and you want value axis labels to be formatted as duration, you have to set
     * the duration unit. Possible values are: "ss", "mm", "hh" and "DD".
     */

    public void setDuration(String duration) {
        axis.duration = duration;
    }

    public Object getDurationUnits() {
        return axis.durationUnits;
    }

    /**
     * If duration property is set, you can specify what string should be displayed next to day, hour, minute and second.
     */

    public void setDurationUnits(Object durationUnits) {
        axis.durationUnits = durationUnits;
    }

    public String getGridType() {
        return axis.gridType;
    }

    /**
     * Radar chart only. Possible values are: "polygons" and "circles". Set "circles" for polar charts. Default to
     * {@link GridType#POLYGONS}
     */

    public void setGridType(GridType gridType) {
        axis.gridType = gridType.getName();
    }

    public String getId() {
        return axis.id;
    }

    /**
     * Unique id of value axis. It is not required to set it, unless you need to tell the graph which exact value axis
     * it should use.
     */

    public void setId(String id) {
        axis.id = id;
    }

    public boolean isIncludeAllValues() {
        return axis.includeAllValues;
    }

    /**
     * If you set it to true, minimum and maximum of value axis will not change while zooming/scrolling. Default to false
     */

    public void setIncludeAllValues(boolean includeAllValues) {
        axis.includeAllValues = includeAllValues;
    }

    public boolean isIncludeGuidesInMinMax() {
        return axis.includeGuidesInMinMax;
    }

    /**
     * Specifies whether guide values should be included when calculating min and max of the axis. Default to false
     */

    public void setIncludeGuidesInMinMax(boolean includeGuidesInMinMax) {
        axis.includeGuidesInMinMax = includeGuidesInMinMax;
    }

    public boolean isIncludeHidden() {
        return axis.includeHidden;
    }

    /**
     * If true, the axis will include hidden graphs when calculating min and max values. Default to false
     */

    public void setIncludeHidden(boolean includeHidden) {
        axis.includeHidden = includeHidden;
    }

    public boolean isIntegersOnly() {
        return axis.integersOnly;
    }

    /**
     * Specifies whether values on axis can only be integers or both integers and doubles. Default to false
     */

    public void setIntegersOnly(boolean integersOnly) {
        axis.integersOnly = integersOnly;
    }

    public Functions.Func getLabelFunction() {
        return axis.labelFunction;
    }

    /**
     * You can use this function to format Value axis labels. This function is called and these parameters are passed:
     * labelFunction(value, valueText, valueAxis);
     * Where value is numeric value, valueText is formatted string and valueAxis is a reference to valueAxis object.
     * <p>
     * If axis type is "date", labelFucntion will pass different arguments:
     * labelFunction(valueText, date, valueAxis)
     * <p>
     * Your function should return axis. string.
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        axis.labelFunction = labelFunction;
    }

    public boolean isLogarithmic() {
        return axis.logarithmic;
    }

    /**
     * Specifies if this value axis' scale should be logarithmic. Default to false
     */

    public void setLogarithmic(boolean logarithmic) {
        axis.logarithmic = logarithmic;
    }

    public int getMax() {
        return axis.max;
    }

    /**
     * Read-only. Maximum value of the axis.
     */

    public void setMax(int max) {
        axis.max = max;
    }

    public int getMaximum() {
        return axis.maximum;
    }

    /**
     * If you don't want max value to be calculated by the chart, set it using this property. This value might still
     * be adjusted so that it would be possible to draw grid at rounded intervals.
     */

    public void setMaximum(int maximum) {
        axis.maximum = maximum;
    }

    public Date getMaximumDate() {
        return axis.maximumDate;
    }

    /**
     * If your value axis is date-based, you can specify maximum date of the axis. Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */

    public void setMaximumDate(Date maximumDate) {
        axis.maximumDate = maximumDate;
    }

    public int getMin() {
        return axis.min;
    }

    /**
     * Read-only. Minimum value of the axis.
     */

    public void setMin(int min) {
        axis.min = min;
    }

    public int getMinimum() {
        return axis.minimum;
    }

    /**
     * If you don't want min value to be calculated by the chart, set it using this property. This value might still be
     * adjusted so that it would be possible to draw grid at rounded intervals.
     */

    public void setMinimum(int minimum) {
        axis.minimum = minimum;
    }

    public Date getMinimumDate() {
        return axis.minimumDate;
    }

    /**
     * If your value axis is date-based, you can specify minimum date of the axis. Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */

    public void setMinimumDate(Date minimumDate) {
        axis.minimumDate = minimumDate;
    }

    public int getMinMaxMultiplier() {
        return axis.minMaxMultiplier;
    }

    /**
     * If set value axis scale (min and max numbers) will be multiplied by it. I.e. if set to 1.2 the scope of values
     * will increase by 20%. Default to 1
     */

    public void setMinMaxMultiplier(int minMaxMultiplier) {
        axis.minMaxMultiplier = minMaxMultiplier;
    }

    public String getMinPeriod() {
        return axis.minPeriod;
    }

    /**
     * Specifies the shortest period of your data. This will work only if you set the `type` of your value axis to `"date"`.
     * <p>
     * Possible period values: fff - milliseconds, ss - seconds, mm - minutes, hh - hours, DD - days, MM - months, YYYY - years.
     * <p>
     * It's also possible to supply a number for increments, i.e. "15mm" which will instruct the chart that your data is
     * supplied in 15 minute increments.
     */

    public void setMinPeriod(Period minPeriod) {
        axis.minPeriod = minPeriod.getValue();
    }

    public String getPointPosition() {
        return axis.pointPosition;
    }

    /**
     * Works with radar charts only. If you set it to “middle”, labels and data points will be placed in the middle
     * between axes.
     */

    public void setPointPosition(String pointPosition) {
        axis.pointPosition = pointPosition;
    }

    public int getPrecision() {
        return axis.precision;
    }

    /**
     * Precision (number of decimals) of values.
     */

    public void setPrecision(int precision) {
        axis.precision = precision;
    }

    public boolean isRadarCategoriesEnabled() {
        return axis.radarCategoriesEnabled;
    }

    /**
     * Radar chart only. Specifies if categories (axes' titles) should be displayed near axes). Default to true
     */

    public void setRadarCategoriesEnabled(boolean radarCategoriesEnabled) {
        axis.radarCategoriesEnabled = radarCategoriesEnabled;
    }

    public boolean isRecalculateToPercents() {
        return axis.recalculateToPercents;
    }

    /**
     * Specifies if graphs's values should be recalculated to percents. Default to false
     */

    public void setRecalculateToPercents(boolean recalculateToPercents) {
        axis.recalculateToPercents = recalculateToPercents;
    }

    public boolean isReversed() {
        return axis.reversed;
    }

    /**
     * Specifies if value axis should be reversed (smaller values on top). Default to false
     */

    public void setReversed(boolean reversed) {
        axis.reversed = reversed;
    }

    public String getStackType() {
        return axis.stackType;
    }

    /**
     * Stacking mode of the axis. Possible values are: "none", "regular", "100%", "3d".
     * Note, only graphs of one type will be stacked. Default to {@link StackType#NONE}
     */

    public void setStackType(StackType stackType) {
        axis.stackType = stackType.getName();
    }

    public int getStep() {
        return axis.step;
    }

    /**
     * Read-only. Value difference between two grid lines.
     */

    public void setStep(int step) {
        axis.step = step;
    }

    public boolean isStrictMinMax() {
        return axis.strictMinMax;
    }

    /**
     * If you set minimum and maximum for your axis, chart adjusts them so that grid would start and end on the
     * beginning and end of plot area and grid would be at equal intervals. If you set strictMinMax to true, the chart
     * will not adjust minimum and maximum of value axis. Default to false
     */

    public void setStrictMinMax(boolean strictMinMax) {
        axis.strictMinMax = strictMinMax;
    }

    public int getSynchronizationMultiplier() {
        return axis.synchronizationMultiplier;
    }

    /**
     * In case you synchronize one value axis with another, you need to set the synchronization multiplier. Use
     * synchronizeWithAxis method to set with which axis it should be synced.
     */

    public void setSynchronizationMultiplier(int synchronizationMultiplier) {
        axis.synchronizationMultiplier = synchronizationMultiplier;
    }

    public String getTotalText() {
        return axis.totalText;
    }

    /**
     * If this value axis is stacked and has columns, setting valueAxis.totalText = "[[total]]" will make it to display
     * total value above the most-top column.
     */

    public void setTotalText(String totalText) {
        axis.totalText = totalText;
    }

    public String getTotalTextColor() {
        return axis.totalTextColor;
    }

    /**
     * Color of total text.
     */

    public void setTotalTextColor(String totalTextColor) {
        axis.totalTextColor = totalTextColor;
    }

    public int getTotalTextOffset() {
        return axis.totalTextOffset;
    }

    /**
     * Distance from data point to total text. Default to 0
     */

    public void setTotalTextOffset(int totalTextOffset) {
        axis.totalTextOffset = totalTextOffset;
    }

    public int getTreatZeroAs() {
        return axis.treatZeroAs;
    }

    /**
     * This allows you to have logarithmic value axis and have zero values in the data. You must set it to >0 value in
     * order to work. Default to 0
     */

    public void setTreatZeroAs(int treatZeroAs) {
        axis.treatZeroAs = treatZeroAs;
    }

    public String getType() {
        return axis.type;
    }

    /**
     * Type of value axis. If your values in data provider are dates and you want this axis to show dates instead of
     * numbers, set it to "date".
     */

    public void setType(ValueAxisType type) {
        axis.type = type.getName();
    }

    public String getUnit() {
        return axis.unit;
    }

    /**
     * Unit which will be added to the value label.
     */

    public void setUnit(String unit) {
        axis.unit = unit;
    }

    public String getUnitPosition() {
        return axis.unitPosition;
    }

    /**
     * Position of the unit. Possible values are "left" and "right". Default {@link UnitPosition#RIGHT}
     */

    public void setUnitPosition(UnitPosition unitPosition) {
        axis.unitPosition = unitPosition.getName();
    }

    public boolean isUsePrefixes() {
        return axis.usePrefixes;
    }

    /**
     * If true, prefixes will be used for big and small numbers. You can set arrays of prefixes directly to the chart
     * object via prefixesOfSmallNumbers and prefixesOfBigNumbers. Default to false
     */

    public void setUsePrefixes(boolean usePrefixes) {
        axis.usePrefixes = usePrefixes;
    }

    public boolean isUseScientificNotation() {
        return axis.useScientificNotation;
    }

    /**
     * If true, values will always be formatted using scientific notation (5e+8, 5e-8...) Otherwise only values bigger
     * then 1e+21 and smaller then 1e-7 will be displayed in scientific notation. Default to false
     */

    public void setUseScientificNotation(boolean useScientificNotation) {
        axis.useScientificNotation = useScientificNotation;
    }

    public double getZeroGridAlpha() {
        return axis.zeroGridAlpha;
    }

    /**
     * Opacity of a zero grid line. By default it is equal to 2 x gridAlpha.
     */

    public void setZeroGridAlpha(double zeroGridAlpha) {
        axis.zeroGridAlpha = zeroGridAlpha;
    }

    /**
     * One value axis can be synchronized with another value axis. You should set synchronizationMultiplyer in order
     * for this to work.
     */

    public void synchronizeWithAxis(AmValueAxis axis) {
        this.axis.synchronizeWithAxis(axis);
    }

    /**
     * Adds event listener to the object.
     */

    public void addListener(String type, Functions.Func1<Object> handler) {
        axis.addListener(type, handler);
    }

    /**
     * Returns value of the coordinate.
     */

    public void coordinateToValue(int x, int y) {
        axis.coordinateToValue(x, y);
    }

    /**
     * Returns coordinate of the value in pixels.
     */

    public int[] getCoordinate(int value) {
        return axis.getCoordinate(value);
    }

    /**
     * Removes event listener from the object
     */

    public void removeListener(Object object, String type, Functions.Func1<Object> handler) {
        axis.removeListener(object, type, handler);
    }

    /**
     * Zooms out the value axis to full scale.
     */

    public void zoomOut() {
        axis.zoomOut();
    }

    /**
     * Zooms-in the axis to the provided values.
     */

    public void zoomToValues(int startValue, int endValue) {
        axis.zoomToValues(startValue, endValue);
    }

    @Override
    protected AmAxisBase getAxis() {
        return axis;
    }
}
