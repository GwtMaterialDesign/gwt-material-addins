package gwt.material.design.incubator.client.chart.amcharts.options;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Position;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasGaugeAxisHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.ClickBandEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.RollOutBandEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.gauge.RollOverBandEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.object.GaugeAxisData;
import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeBand;
import gwt.material.design.jquery.client.api.Functions;

public class GaugeAxis extends ChartOptions implements HasGaugeAxisHandlers {

    private AmGaugeAxis gaugeAxis = new AmGaugeAxis();

    @Override
    public void load() {
        addListener(AmChartEvents.CLICK_BAND, object -> ClickBandEvent.fire(this, (GaugeAxisData) object));
        addListener(AmChartEvents.ROLL_OUT_BAND, object -> RollOutBandEvent.fire(this, (GaugeAxisData) object));
        addListener(AmChartEvents.ROLL_OVER_BAND, object -> RollOverBandEvent.fire(this, (GaugeAxisData) object));
    }

    @Override
    public void unload() {
        // unload event
    }

    public double getAxisAlpha() {
        return gaugeAxis.axisAlpha;
    }

    /**
     * Axis opacity. Default to 1
     */

    public void setAxisAlpha(double axisAlpha) {
        gaugeAxis.axisAlpha = axisAlpha;
    }


    public String getAxisColor() {
        return gaugeAxis.axisColor;
    }

    /**
     * Axis color. Default to #000000
     */

    public void setAxisColor(String axisColor) {
        gaugeAxis.axisColor = axisColor;
    }


    public int getAxisThickness() {
        return gaugeAxis.axisThickness;
    }

    /**
     * Thickness of the axis outline. Default to 1
     */

    public void setAxisThickness(int axisThickness) {
        gaugeAxis.axisThickness = axisThickness;
    }


    public double getBandAlpha() {
        return gaugeAxis.bandAlpha;
    }

    /**
     * Opacity of band fills. Default to 1
     */

    public void setBandAlpha(double bandAlpha) {
        gaugeAxis.bandAlpha = bandAlpha;
    }


    public int[] getBandGradientRatio() {
        return gaugeAxis.bandGradientRatio;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make bands to be filled with color gradients. Negative value means the color will
     * be darker than the original, and positive number means the color will be lighter.
     */

    public void setBandGradientRatio(int[] bandGradientRatio) {
        gaugeAxis.bandGradientRatio = bandGradientRatio;
    }


    public double getBandOutlineAlpha() {
        return gaugeAxis.bandOutlineAlpha;
    }

    /**
     * Opacity of band outlines. Default to 0
     */

    public void setBandOutlineAlpha(double bandOutlineAlpha) {
        gaugeAxis.bandOutlineAlpha = bandOutlineAlpha;
    }


    public String getBandOutlineColor() {
        return gaugeAxis.bandOutlineColor;
    }

    /**
     * Color of band outlines. Default to #000000
     */

    public void setBandOutlineColor(String bandOutlineColor) {
        gaugeAxis.bandOutlineColor = bandOutlineColor;
    }


    public int getBandOutlineThickness() {
        return gaugeAxis.bandOutlineThickness;
    }

    /**
     * Thickness of band outlines. Default to 0
     */

    public void setBandOutlineThickness(int bandOutlineThickness) {
        gaugeAxis.bandOutlineThickness = bandOutlineThickness;
    }


    public AmGaugeBand[] getBands() {
        return gaugeAxis.bands;
    }

    /**
     * Array of bands - AmGaugeBand objects. Bands are used to draw color fills between specified values.
     */

    public void setBands(AmGaugeBand[] bands) {
        gaugeAxis.bands = bands;
    }


    public String getBottomText() {
        return gaugeAxis.bottomText;
    }

    /**
     * Sets bottom text.
     */
    public void setBottomText(String text) {
        gaugeAxis.setBottomText(text);
    }

    public boolean isBottomTextBold() {
        return gaugeAxis.bottomTextBold;
    }

    /**
     * Specifies if text should be bold.
     */

    public void setBottomTextBold(boolean bottomTextBold) {
        gaugeAxis.bottomTextBold = bottomTextBold;
    }

    public String getBottomTextColor() {
        return gaugeAxis.bottomTextColor;
    }

    /**
     * Bottom text color.
     */

    public void setBottomTextColor(String bottomTextColor) {
        gaugeAxis.bottomTextColor = bottomTextColor;
    }

    public int getBottomTextFontSize() {
        return gaugeAxis.bottomTextFontSize;
    }

    /**
     * Font size of bottom text.
     */

    public void setBottomTextFontSize(int bottomTextFontSize) {
        gaugeAxis.bottomTextFontSize = bottomTextFontSize;
    }

    public int getBottomTextYOffset() {
        return gaugeAxis.bottomTextYOffset;
    }

    /**
     * Y offset of bottom text. Default to 0
     */

    public void setBottomTextYOffset(int bottomTextYOffset) {
        gaugeAxis.bottomTextYOffset = bottomTextYOffset;
    }

    public Object getCenterX() {
        return gaugeAxis.centerX;
    }

    /**
     * X position of the axis, relative to the center of the gauge. Default to 0%
     */

    public void setCenterX(Object centerX) {
        gaugeAxis.centerX = centerX;
    }

    public Object getCenterY() {
        return gaugeAxis.centerY;
    }

    /**
     * Y position of the axis, relative to the center of the gauge. Default to 0%
     */

    public void setCenterY(Object centerY) {
        gaugeAxis.centerY = centerY;
    }

    public String getColor() {
        return gaugeAxis.color;
    }

    /**
     * Specifies labels color of the axis.
     */

    public void setColor(String color) {
        gaugeAxis.color = color;
    }

    public int getEndAngle() {
        return gaugeAxis.endAngle;
    }

    /**
     * Axis end angle. Valid values are from - 180 to 180. Default to 120
     */

    public void setEndAngle(int endAngle) {
        gaugeAxis.endAngle = endAngle;
    }

    public int getEndValue() {
        return gaugeAxis.endValue;
    }

    /**
     * Axis end (max) value
     */

    public void setEndValue(int endValue) {
        gaugeAxis.endValue = endValue;
    }

    public int getFontSize() {
        return gaugeAxis.fontSize;
    }

    /**
     * Font size for axis labels.
     */

    public void setFontSize(int fontSize) {
        gaugeAxis.fontSize = fontSize;
    }

    public int getGridCount() {
        return gaugeAxis.gridCount;
    }

    /**
     * Number of grid lines. Note, AmGaugeAxis doesn't adjust gridCount, so you should check your values and choose a
     * proper gridCount which would result grids at round numbers. Default to 20
     */

    public void setGridCount(int gridCount) {
        gaugeAxis.gridCount = gridCount;
    }

    public boolean isGridInside() {
        return gaugeAxis.gridInside;
    }

    /**
     * Specifies if grid should be drawn inside or outside the axis. Default to true
     */

    public void setGridInside(boolean gridInside) {
        gaugeAxis.gridInside = gridInside;
    }

    public int getId() {
        return gaugeAxis.id;
    }

    /**
     * Unique id of an axis.
     */

    public void setId(int id) {
        gaugeAxis.id = id;
    }

    public boolean isInside() {
        return gaugeAxis.inside;
    }

    /**
     * Specifies if labels should be placed inside or outside the axis. Default to true
     */

    public void setInside(boolean inside) {
        gaugeAxis.inside = inside;
    }

    /**
     * Adds event listener to the object.
     */
    public void addListener(String type, Functions.Func1<Object> handler) {
        gaugeAxis.addListener(type, handler);
    }

    /**
     * Removes event listener from chart object.
     */
    public void removeListener(AmChart chart, String type, Functions.Func1<Object> handler) {
        gaugeAxis.removeListener(chart, type, handler);
    }

    /**
     * Returns angle of the value.
     */
    public int getValue2angle(int value) {
        return gaugeAxis.value2angle(value);
    }

    public int getLabelFrequency() {
        return gaugeAxis.labelFrequency;
    }

    /**
     * Frequency of labels. Default to 1
     */

    public void setLabelFrequency(int labelFrequency) {
        gaugeAxis.labelFrequency = labelFrequency;
    }

    public Functions.Func getLabelFunction() {
        return gaugeAxis.labelFunction;
    }

    /**
     * You can use this function to format axis labels. This function is called and value is passed as a attribute:
     * labelFunction(value);
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        gaugeAxis.labelFunction = labelFunction;
    }

    public int getLabelOffset() {
        return gaugeAxis.labelOffset;
    }

    /**
     * Distance from axis to the labels. Default to 15
     */

    public void setLabelOffset(int labelOffset) {
        gaugeAxis.labelOffset = labelOffset;
    }

    public boolean isLabelsEnabled() {
        return gaugeAxis.labelsEnabled;
    }

    /**
     * Specifies if labels on the axis should be shown. Default to true
     */

    public void setLabelsEnabled(boolean labelsEnabled) {
        gaugeAxis.labelsEnabled = labelsEnabled;
    }

    public Object[] getListeners() {
        return gaugeAxis.listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickBand", "method":handleClick}];
     */

    public void setListeners(Object[] listeners) {
        gaugeAxis.listeners = listeners;
    }

    public int getMinorTickInterval() {
        return gaugeAxis.minorTickInterval;
    }

    /**
     * Interval, at which minor ticks should be placed.
     */

    public void setMinorTickInterval(int minorTickInterval) {
        gaugeAxis.minorTickInterval = minorTickInterval;
    }

    public int getMinorTickLength() {
        return gaugeAxis.minorTickLength;
    }

    /**
     * Length of a minor tick. Default to 5
     */

    public void setMinorTickLength(int minorTickLength) {
        gaugeAxis.minorTickLength = minorTickLength;
    }

    public Object getRadius() {
        return gaugeAxis.radius;
    }

    /**
     * Axis radius. Default to 95%
     */

    public void setRadius(Object radius) {
        gaugeAxis.radius = radius;
    }

    public boolean isShowFirstLabel() {
        return gaugeAxis.showFirstLabel;
    }

    /**
     * Specifies if the first label should be shown. Default to true
     */

    public void setShowFirstLabel(boolean showFirstLabel) {
        gaugeAxis.showFirstLabel = showFirstLabel;
    }

    public boolean isShowLastLabel() {
        return gaugeAxis.showLastLabel;
    }

    /**
     * Specifies if the last label should be shown. Default to true
     */

    public void setShowLastLabel(boolean showLastLabel) {
        gaugeAxis.showLastLabel = showLastLabel;
    }

    public int getStartAngle() {
        return gaugeAxis.startAngle;
    }

    /**
     * Axis start angle. Valid values are from - 180 to 180. Default to -120
     */

    public void setStartAngle(int startAngle) {
        gaugeAxis.startAngle = startAngle;
    }

    public int getStartValue() {
        return gaugeAxis.startValue;
    }

    /**
     * Axis start (min) value. Default to 0
     */

    public void setStartValue(int startValue) {
        gaugeAxis.startValue = startValue;
    }

    public double getTickAlpha() {
        return gaugeAxis.tickAlpha;
    }

    /**
     * Opacity of axis ticks. Default to 1
     */

    public void setTickAlpha(double tickAlpha) {
        gaugeAxis.tickAlpha = tickAlpha;
    }

    public String getTickColor() {
        return gaugeAxis.tickColor;
    }

    /**
     * Color of axis ticks. Default to #555555
     */

    public void setTickColor(String tickColor) {
        gaugeAxis.tickColor = tickColor;
    }

    public int getTickLength() {
        return gaugeAxis.tickLength;
    }

    /**
     * Length of a major tick. Default to 10
     */

    public void setTickLength(int tickLength) {
        gaugeAxis.tickLength = tickLength;
    }

    public int getTickThickness() {
        return gaugeAxis.tickThickness;
    }

    /**
     * Tick thickness. Default to 1
     *
     * @param tickThickness
     */

    public void setTickThickness(int tickThickness) {
        gaugeAxis.tickThickness = tickThickness;
    }

    public String getTopText() {
        return gaugeAxis.topText;
    }

    /**
     * Sets top text.
     */
    public void setTopText(String text) {
        gaugeAxis.setTopText(text);
    }

    public boolean isTopTextBold() {
        return gaugeAxis.topTextBold;
    }

    /**
     * Specifies if text should be bold. Default to true
     */

    public void setTopTextBold(boolean topTextBold) {
        gaugeAxis.topTextBold = topTextBold;
    }


    public String getTopTextColor() {
        return gaugeAxis.topTextColor;
    }

    /**
     * Color of top text.
     */

    public void setTopTextColor(String topTextColor) {
        gaugeAxis.topTextColor = topTextColor;
    }


    public int getTopTextFontSize() {
        return gaugeAxis.topTextFontSize;
    }

    /**
     * Font size of top text.
     */

    public void setTopTextFontSize(int topTextFontSize) {
        gaugeAxis.topTextFontSize = topTextFontSize;
    }


    public int getTopTextYOffset() {
        return gaugeAxis.topTextYOffset;
    }

    /**
     * Y offset of top text. Default to 0
     */

    public void setTopTextYOffset(int topTextYOffset) {
        gaugeAxis.topTextYOffset = topTextYOffset;
    }


    public String getUnit() {
        return gaugeAxis.unit;
    }

    /**
     * A string which can be placed next to axis labels.
     */

    public void setUnit(String unit) {
        gaugeAxis.unit = unit;
    }


    public String getUnitPosition() {
        return gaugeAxis.unitPosition;
    }

    /**
     * Position of the unit. Default to "right"
     */

    public void setUnitPosition(Position unitPosition) {
        gaugeAxis.unitPosition = unitPosition.getName();
    }


    public boolean isUsePrefixes() {
        return gaugeAxis.usePrefixes;
    }

    /**
     * Specifies if small and big numbers should use prefixes to make them more readable. Default to false
     */

    public void setUsePrefixes(boolean usePrefixes) {
        gaugeAxis.usePrefixes = usePrefixes;
    }


    public int getValueInterval() {
        return gaugeAxis.valueInterval;
    }

    /**
     * Interval, at which ticks with values should be placed.
     */

    public void setValueInterval(int valueInterval) {
        gaugeAxis.valueInterval = valueInterval;
    }

    public AmGaugeAxis getGaugeAxis() {
        return gaugeAxis;
    }

    @Override
    public HandlerRegistration addClickBandHandler(ClickBandEvent.ClickBandHandler handler) {
        return addHandler(ClickBandEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOutBandHandler(RollOutBandEvent.ClickLabelHandler handler) {
        return addHandler(RollOutBandEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverBandHandler(RollOverBandEvent.ClickLabelHandler handler) {
        return addHandler(RollOverBandEvent.getType(), handler);
    }
}
