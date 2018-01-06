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

/**
 * Extension for AmValueAxis to create an axis for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart},
 * {@link gwt.material.design.incubator.client.chart.chartjs.RadarChart}, {@link gwt.material.design.incubator.client.chart.amcharts.XyChart}
 * charts, multiple can be assigned. Gets automatically populated, one for AmSerialChart and two for AmXYChart charts,
 * if none has been specified.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ValueAxis">Official Documentation</a>
 */
//@formatter:on
public class ValueAxis extends AxisBase {

    private AmValueAxis axis;
    private Functions.Func1<Object> axisChangedEvent, axisZoomedEvent, logarithmicAxisFailedEvent;

    @Override
    public void load() {
        super.load();

        axisChangedEvent = object -> AxisChangedEvent.fire(this, (ValueAxisChangedData) object);
        axisZoomedEvent = object -> AxisZoomedEvent.fire(this, (ValueAxisZoomedData) object);
        logarithmicAxisFailedEvent = object -> LogarithmicAxisFailedEvent.fire(this, (LogarithmicAxisFailedData) object);

        addListener(AmChartEvents.AXIS_CHANGED, axisChangedEvent);
        addListener(AmChartEvents.AXIS_ZOOMED, axisZoomedEvent);
        addListener(AmChartEvents.LOGARITHMIC_AXIS_FAILED, logarithmicAxisFailedEvent);
    }

    @Override
    public void unload() {
        super.unload();

        removeListener(getAmValueAxis(), AmChartEvents.AXIS_CHANGED, axisChangedEvent);
        removeListener(getAmValueAxis(), AmChartEvents.AXIS_ZOOMED, axisZoomedEvent);
        removeListener(getAmValueAxis(), AmChartEvents.LOGARITHMIC_AXIS_FAILED, logarithmicAxisFailedEvent);
    }

    public AmValueAxis getSynchronizeWith() {
        return getAmValueAxis().synchronizeWith;
    }

    /**
     * One value axis can be synchronized with another value getAmValueAxis(). You can use both reference to your axis or id of the
     * axis here. You should set synchronizationMultiplyer in order for this to work.
     */

    public void setSynchronizeWith(AmValueAxis synchronizeWith) {
        getAmValueAxis().synchronizeWith = synchronizeWith;
    }

    public boolean isAutoWrap() {
        return getAmValueAxis().autoWrap;
    }

    /**
     * If this is set to true and the label does not fit, it will be wrapped. Works only on horizontal value axes. Default
     * to false
     */

    public void setAutoWrap(boolean autoWrap) {
        getAmValueAxis().autoWrap = autoWrap;
    }

    public int getAxisFrequency() {
        return getAmValueAxis().axisFrequency;
    }

    /**
     * Works with Radar chart only. If you have a big number of axes, this property will help you to show every x axis only.
     * Default to 1
     */

    public void setAxisFrequency(int axisFrequency) {
        getAmValueAxis().axisFrequency = axisFrequency;
    }

    public int getAxisTitleOffset() {
        return getAmValueAxis().axisTitleOffset;
    }

    /**
     * Radar chart only. Specifies distance from axis to the axis title (category). Default to 10
     */

    public void setAxisTitleOffset(int axisTitleOffset) {
        getAmValueAxis().axisTitleOffset = axisTitleOffset;
    }

    public Object getBalloonTextFunction() {
        return getAmValueAxis().balloonTextFunction;
    }

    /**
     * You can use this function to format balloon text of the getAmValueAxis(). This function is called and balloon text or date
     * (if axis is date-based) is passed as an argument. It should return string which will be displayed in the balloon.
     */

    public void setBalloonTextFunction(Object balloonTextFunction) {
        getAmValueAxis().balloonTextFunction = balloonTextFunction;
    }

    public int getBaseCoord() {
        return getAmValueAxis().baseCoord;
    }

    /**
     * Read-only. Coordinate of the base value.
     */

    public void setBaseCoord(int baseCoord) {
        getAmValueAxis().baseCoord = baseCoord;
    }

    public int getBaseValue() {
        return getAmValueAxis().baseValue;
    }

    /**
     * Specifies base value of the getAmValueAxis(). Default to 0
     */

    public void setBaseValue(int baseValue) {
        getAmValueAxis().baseValue = baseValue;
    }

    public String getDuration() {
        return getAmValueAxis().duration;
    }

    /**
     * If your values represents time units, and you want value axis labels to be formatted as duration, you have to set
     * the duration unit. Possible values are: "ss", "mm", "hh" and "DD".
     */

    public void setDuration(String duration) {
        getAmValueAxis().duration = duration;
    }

    public Object getDurationUnits() {
        return getAmValueAxis().durationUnits;
    }

    /**
     * If duration property is set, you can specify what string should be displayed next to day, hour, minute and second.
     */

    public void setDurationUnits(Object durationUnits) {
        getAmValueAxis().durationUnits = durationUnits;
    }

    public String getGridType() {
        return getAmValueAxis().gridType;
    }

    /**
     * Radar chart only. Possible values are: "polygons" and "circles". Set "circles" for polar charts. Default to
     * {@link GridType#POLYGONS}
     */

    public void setGridType(GridType gridType) {
        getAmValueAxis().gridType = gridType.getName();
    }

    public String getId() {
        return getAmValueAxis().id;
    }

    /**
     * Unique id of value getAmValueAxis(). It is not required to set it, unless you need to tell the graph which exact value axis
     * it should use.
     */

    public void setId(String id) {
        getAmValueAxis().id = id;
    }

    public boolean isIncludeAllValues() {
        return getAmValueAxis().includeAllValues;
    }

    /**
     * If you set it to true, minimum and maximum of value axis will not change while zooming/scrolling. Default to false
     */

    public void setIncludeAllValues(boolean includeAllValues) {
        getAmValueAxis().includeAllValues = includeAllValues;
    }

    public boolean isIncludeGuidesInMinMax() {
        return getAmValueAxis().includeGuidesInMinMax;
    }

    /**
     * Specifies whether guide values should be included when calculating min and max of the getAmValueAxis(). Default to false
     */

    public void setIncludeGuidesInMinMax(boolean includeGuidesInMinMax) {
        getAmValueAxis().includeGuidesInMinMax = includeGuidesInMinMax;
    }

    public boolean isIncludeHidden() {
        return getAmValueAxis().includeHidden;
    }

    /**
     * If true, the axis will include hidden graphs when calculating min and max values. Default to false
     */

    public void setIncludeHidden(boolean includeHidden) {
        getAmValueAxis().includeHidden = includeHidden;
    }

    public boolean isIntegersOnly() {
        return getAmValueAxis().integersOnly;
    }

    /**
     * Specifies whether values on axis can only be integers or both integers and doubles. Default to false
     */

    public void setIntegersOnly(boolean integersOnly) {
        getAmValueAxis().integersOnly = integersOnly;
    }

    public Functions.Func getLabelFunction() {
        return getAmValueAxis().labelFunction;
    }

    /**
     * You can use this function to format Value axis labels. This function is called and these parameters are passed:
     * labelFunction(value, valueText, valueAxis);
     * Where value is numeric value, valueText is formatted string and valueAxis is a reference to valueAxis object.
     * <p>
     * If axis type is "date", labelFucntion will pass different arguments:
     * labelFunction(valueText, date, valueAxis)
     * <p>
     * Your function should return getAmValueAxis(). string.
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        getAmValueAxis().labelFunction = labelFunction;
    }

    public boolean isLogarithmic() {
        return getAmValueAxis().logarithmic;
    }

    /**
     * Specifies if this value axis' scale should be logarithmic. Default to false
     */

    public void setLogarithmic(boolean logarithmic) {
        getAmValueAxis().logarithmic = logarithmic;
    }

    public int getMax() {
        return getAmValueAxis().max;
    }

    /**
     * Read-only. Maximum value of the getAmValueAxis().
     */

    public void setMax(int max) {
        getAmValueAxis().max = max;
    }

    public int getMaximum() {
        return getAmValueAxis().maximum;
    }

    /**
     * If you don't want max value to be calculated by the chart, set it using this property. This value might still
     * be adjusted so that it would be possible to draw grid at rounded intervals.
     */

    public void setMaximum(int maximum) {
        getAmValueAxis().maximum = maximum;
    }

    public Date getMaximumDate() {
        return getAmValueAxis().maximumDate;
    }

    /**
     * If your value axis is date-based, you can specify maximum date of the getAmValueAxis(). Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */

    public void setMaximumDate(Date maximumDate) {
        getAmValueAxis().maximumDate = maximumDate;
    }

    public int getMin() {
        return getAmValueAxis().min;
    }

    /**
     * Read-only. Minimum value of the getAmValueAxis().
     */

    public void setMin(int min) {
        getAmValueAxis().min = min;
    }

    public int getMinimum() {
        return getAmValueAxis().minimum;
    }

    /**
     * If you don't want min value to be calculated by the chart, set it using this property. This value might still be
     * adjusted so that it would be possible to draw grid at rounded intervals.
     */

    public void setMinimum(int minimum) {
        getAmValueAxis().minimum = minimum;
    }

    public Date getMinimumDate() {
        return getAmValueAxis().minimumDate;
    }

    /**
     * If your value axis is date-based, you can specify minimum date of the getAmValueAxis(). Can be set as date object, timestamp
     * number or string if dataDateFormat is set.
     */

    public void setMinimumDate(Date minimumDate) {
        getAmValueAxis().minimumDate = minimumDate;
    }

    public int getMinMaxMultiplier() {
        return getAmValueAxis().minMaxMultiplier;
    }

    /**
     * If set value axis scale (min and max numbers) will be multiplied by it. I.e. if set to 1.2 the scope of values
     * will increase by 20%. Default to 1
     */

    public void setMinMaxMultiplier(int minMaxMultiplier) {
        getAmValueAxis().minMaxMultiplier = minMaxMultiplier;
    }

    public String getMinPeriod() {
        return getAmValueAxis().minPeriod;
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
        getAmValueAxis().minPeriod = minPeriod.getValue();
    }

    public String getPointPosition() {
        return getAmValueAxis().pointPosition;
    }

    /**
     * Works with radar charts only. If you set it to “middle”, labels and data points will be placed in the middle
     * between axes.
     */

    public void setPointPosition(String pointPosition) {
        getAmValueAxis().pointPosition = pointPosition;
    }

    public int getPrecision() {
        return getAmValueAxis().precision;
    }

    /**
     * Precision (number of decimals) of values.
     */

    public void setPrecision(int precision) {
        getAmValueAxis().precision = precision;
    }

    public boolean isRadarCategoriesEnabled() {
        return getAmValueAxis().radarCategoriesEnabled;
    }

    /**
     * Radar chart only. Specifies if categories (axes' titles) should be displayed near axes). Default to true
     */

    public void setRadarCategoriesEnabled(boolean radarCategoriesEnabled) {
        getAmValueAxis().radarCategoriesEnabled = radarCategoriesEnabled;
    }

    public boolean isRecalculateToPercents() {
        return getAmValueAxis().recalculateToPercents;
    }

    /**
     * Specifies if graphs's values should be recalculated to percents. Default to false
     */

    public void setRecalculateToPercents(boolean recalculateToPercents) {
        getAmValueAxis().recalculateToPercents = recalculateToPercents;
    }

    public boolean isReversed() {
        return getAmValueAxis().reversed;
    }

    /**
     * Specifies if value axis should be reversed (smaller values on top). Default to false
     */

    public void setReversed(boolean reversed) {
        getAmValueAxis().reversed = reversed;
    }

    public String getStackType() {
        return getAmValueAxis().stackType;
    }

    /**
     * Stacking mode of the getAmValueAxis(). Possible values are: "none", "regular", "100%", "3d".
     * Note, only graphs of one type will be stacked. Default to {@link StackType#NONE}
     */

    public void setStackType(StackType stackType) {
        getAmValueAxis().stackType = stackType.getName();
    }

    public int getStep() {
        return getAmValueAxis().step;
    }

    /**
     * Read-only. Value difference between two grid lines.
     */

    public void setStep(int step) {
        getAmValueAxis().step = step;
    }

    public boolean isStrictMinMax() {
        return getAmValueAxis().strictMinMax;
    }

    /**
     * If you set minimum and maximum for your axis, chart adjusts them so that grid would start and end on the
     * beginning and end of plot area and grid would be at equal intervals. If you set strictMinMax to true, the chart
     * will not adjust minimum and maximum of value getAmValueAxis(). Default to false
     */

    public void setStrictMinMax(boolean strictMinMax) {
        getAmValueAxis().strictMinMax = strictMinMax;
    }

    public int getSynchronizationMultiplier() {
        return getAmValueAxis().synchronizationMultiplier;
    }

    /**
     * In case you synchronize one value axis with another, you need to set the synchronization multiplier. Use
     * synchronizeWithAxis method to set with which axis it should be synced.
     */

    public void setSynchronizationMultiplier(int synchronizationMultiplier) {
        getAmValueAxis().synchronizationMultiplier = synchronizationMultiplier;
    }

    public String getTotalText() {
        return getAmValueAxis().totalText;
    }

    /**
     * If this value axis is stacked and has columns, setting valuegetAmValueAxis().totalText = "[[total]]" will make it to display
     * total value above the most-top column.
     */

    public void setTotalText(String totalText) {
        getAmValueAxis().totalText = totalText;
    }

    public String getTotalTextColor() {
        return getAmValueAxis().totalTextColor;
    }

    /**
     * Color of total text.
     */

    public void setTotalTextColor(String totalTextColor) {
        getAmValueAxis().totalTextColor = totalTextColor;
    }

    public int getTotalTextOffset() {
        return getAmValueAxis().totalTextOffset;
    }

    /**
     * Distance from data point to total text. Default to 0
     */

    public void setTotalTextOffset(int totalTextOffset) {
        getAmValueAxis().totalTextOffset = totalTextOffset;
    }

    public int getTreatZeroAs() {
        return getAmValueAxis().treatZeroAs;
    }

    /**
     * This allows you to have logarithmic value axis and have zero values in the data. You must set it to >0 value in
     * order to work. Default to 0
     */

    public void setTreatZeroAs(int treatZeroAs) {
        getAmValueAxis().treatZeroAs = treatZeroAs;
    }

    public String getType() {
        return getAmValueAxis().type;
    }

    /**
     * Type of value getAmValueAxis(). If your values in data provider are dates and you want this axis to show dates instead of
     * numbers, set it to "date".
     */

    public void setType(ValueAxisType type) {
        getAmValueAxis().type = type.getName();
    }

    public String getUnit() {
        return getAmValueAxis().unit;
    }

    /**
     * Unit which will be added to the value label.
     */

    public void setUnit(String unit) {
        getAmValueAxis().unit = unit;
    }

    public String getUnitPosition() {
        return getAmValueAxis().unitPosition;
    }

    /**
     * Position of the unit. Possible values are "left" and "right". Default {@link UnitPosition#RIGHT}
     */

    public void setUnitPosition(UnitPosition unitPosition) {
        getAmValueAxis().unitPosition = unitPosition.getName();
    }

    public boolean isUsePrefixes() {
        return getAmValueAxis().usePrefixes;
    }

    /**
     * If true, prefixes will be used for big and small numbers. You can set arrays of prefixes directly to the chart
     * object via prefixesOfSmallNumbers and prefixesOfBigNumbers. Default to false
     */

    public void setUsePrefixes(boolean usePrefixes) {
        getAmValueAxis().usePrefixes = usePrefixes;
    }

    public boolean isUseScientificNotation() {
        return getAmValueAxis().useScientificNotation;
    }

    /**
     * If true, values will always be formatted using scientific notation (5e+8, 5e-8...) Otherwise only values bigger
     * then 1e+21 and smaller then 1e-7 will be displayed in scientific notation. Default to false
     */

    public void setUseScientificNotation(boolean useScientificNotation) {
        getAmValueAxis().useScientificNotation = useScientificNotation;
    }

    public double getZeroGridAlpha() {
        return getAmValueAxis().zeroGridAlpha;
    }

    /**
     * Opacity of a zero grid line. By default it is equal to 2 x gridAlpha.
     */

    public void setZeroGridAlpha(double zeroGridAlpha) {
        getAmValueAxis().zeroGridAlpha = zeroGridAlpha;
    }

    /**
     * One value axis can be synchronized with another value getAmValueAxis(). You should set synchronizationMultiplyer in order
     * for this to work.
     */

    public void synchronizeWithAxis(AmValueAxis axis) {
        this.getAmValueAxis().synchronizeWithAxis(axis);
    }

    /**
     * Adds event listener to the object.
     */

    public void addListener(String type, Functions.Func1<Object> handler) {
        getAmValueAxis().addListener(type, handler);
    }

    /**
     * Returns value of the coordinate.
     */

    public void coordinateToValue(int x, int y) {
        getAmValueAxis().coordinateToValue(x, y);
    }

    /**
     * Returns coordinate of the value in pixels.
     */

    public int[] getCoordinate(int value) {
        return getAmValueAxis().getCoordinate(value);
    }

    /**
     * Removes event listener from the object
     */

    public void removeListener(Object object, String type, Functions.Func1<Object> handler) {
        getAmValueAxis().removeListener(object, type, handler);
    }

    /**
     * Zooms out the value axis to full scale.
     */

    public void zoomOut() {
        getAmValueAxis().zoomOut();
    }

    /**
     * Zooms-in the axis to the provided values.
     */

    public void zoomToValues(int startValue, int endValue) {
        getAmValueAxis().zoomToValues(startValue, endValue);
    }

    @Override
    protected AmAxisBase getAmAxis() {
        return getAmValueAxis();
    }

    protected AmValueAxis getAmValueAxis() {
        if (axis == null) {
            axis = new AmValueAxis();
        }
        return axis;
    }
}
