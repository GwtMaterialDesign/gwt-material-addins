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

//@formatter:off

/**
 * Creates an axis for {@link gwt.material.design.incubator.client.chart.amcharts.AngularGauge} charts, multiple can be
 * assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeAxis">Official Documentation</a>
 */
//@formatter:on
public class GaugeAxis extends ChartOptions implements HasGaugeAxisHandlers {

    private AmGaugeAxis gaugeAxis;

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
        return getAmGaugeAxis().axisAlpha;
    }

    /**
     * Axis opacity. Default to 1
     */

    public void setAxisAlpha(double axisAlpha) {
        getAmGaugeAxis().axisAlpha = axisAlpha;
    }


    public String getAxisColor() {
        return getAmGaugeAxis().axisColor;
    }

    /**
     * Axis color. Default to #000000
     */

    public void setAxisColor(String axisColor) {
        getAmGaugeAxis().axisColor = axisColor;
    }


    public int getAxisThickness() {
        return getAmGaugeAxis().axisThickness;
    }

    /**
     * Thickness of the axis outline. Default to 1
     */

    public void setAxisThickness(int axisThickness) {
        getAmGaugeAxis().axisThickness = axisThickness;
    }


    public double getBandAlpha() {
        return getAmGaugeAxis().bandAlpha;
    }

    /**
     * Opacity of band fills. Default to 1
     */

    public void setBandAlpha(double bandAlpha) {
        getAmGaugeAxis().bandAlpha = bandAlpha;
    }


    public int[] getBandGradientRatio() {
        return getAmGaugeAxis().bandGradientRatio;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make bands to be filled with color gradients. Negative value means the color will
     * be darker than the original, and positive number means the color will be lighter.
     */

    public void setBandGradientRatio(int[] bandGradientRatio) {
        getAmGaugeAxis().bandGradientRatio = bandGradientRatio;
    }


    public double getBandOutlineAlpha() {
        return getAmGaugeAxis().bandOutlineAlpha;
    }

    /**
     * Opacity of band outlines. Default to 0
     */

    public void setBandOutlineAlpha(double bandOutlineAlpha) {
        getAmGaugeAxis().bandOutlineAlpha = bandOutlineAlpha;
    }


    public String getBandOutlineColor() {
        return getAmGaugeAxis().bandOutlineColor;
    }

    /**
     * Color of band outlines. Default to #000000
     */

    public void setBandOutlineColor(String bandOutlineColor) {
        getAmGaugeAxis().bandOutlineColor = bandOutlineColor;
    }


    public int getBandOutlineThickness() {
        return getAmGaugeAxis().bandOutlineThickness;
    }

    /**
     * Thickness of band outlines. Default to 0
     */

    public void setBandOutlineThickness(int bandOutlineThickness) {
        getAmGaugeAxis().bandOutlineThickness = bandOutlineThickness;
    }


    public AmGaugeBand[] getBands() {
        return getAmGaugeAxis().bands;
    }

    /**
     * Array of bands - AmGaugeBand objects. Bands are used to draw color fills between specified values.
     */

    public void setBands(GaugeBand[] bands) {
        for (int i = 0; i < bands.length; i++) {
            getAmGaugeAxis().bands[i] = bands[i].getAmGaugeBand();
        }
    }


    public String getBottomText() {
        return getAmGaugeAxis().bottomText;
    }

    /**
     * Sets bottom text.
     */
    public void setBottomText(String text) {
        getAmGaugeAxis().setBottomText(text);
    }

    public boolean isBottomTextBold() {
        return getAmGaugeAxis().bottomTextBold;
    }

    /**
     * Specifies if text should be bold.
     */

    public void setBottomTextBold(boolean bottomTextBold) {
        getAmGaugeAxis().bottomTextBold = bottomTextBold;
    }

    public String getBottomTextColor() {
        return getAmGaugeAxis().bottomTextColor;
    }

    /**
     * Bottom text color.
     */

    public void setBottomTextColor(String bottomTextColor) {
        getAmGaugeAxis().bottomTextColor = bottomTextColor;
    }

    public int getBottomTextFontSize() {
        return getAmGaugeAxis().bottomTextFontSize;
    }

    /**
     * Font size of bottom text.
     */

    public void setBottomTextFontSize(int bottomTextFontSize) {
        getAmGaugeAxis().bottomTextFontSize = bottomTextFontSize;
    }

    public int getBottomTextYOffset() {
        return getAmGaugeAxis().bottomTextYOffset;
    }

    /**
     * Y offset of bottom text. Default to 0
     */

    public void setBottomTextYOffset(int bottomTextYOffset) {
        getAmGaugeAxis().bottomTextYOffset = bottomTextYOffset;
    }

    public Object getCenterX() {
        return getAmGaugeAxis().centerX;
    }

    /**
     * X position of the axis, relative to the center of the gauge. Default to 0%
     */

    public void setCenterX(Object centerX) {
        getAmGaugeAxis().centerX = centerX;
    }

    public Object getCenterY() {
        return getAmGaugeAxis().centerY;
    }

    /**
     * Y position of the axis, relative to the center of the gauge. Default to 0%
     */

    public void setCenterY(Object centerY) {
        getAmGaugeAxis().centerY = centerY;
    }

    public String getColor() {
        return getAmGaugeAxis().color;
    }

    /**
     * Specifies labels color of the axis.
     */

    public void setColor(String color) {
        getAmGaugeAxis().color = color;
    }

    public int getEndAngle() {
        return getAmGaugeAxis().endAngle;
    }

    /**
     * Axis end angle. Valid values are from - 180 to 180. Default to 120
     */

    public void setEndAngle(int endAngle) {
        getAmGaugeAxis().endAngle = endAngle;
    }

    public int getEndValue() {
        return getAmGaugeAxis().endValue;
    }

    /**
     * Axis end (max) value
     */

    public void setEndValue(int endValue) {
        getAmGaugeAxis().endValue = endValue;
    }

    public int getFontSize() {
        return getAmGaugeAxis().fontSize;
    }

    /**
     * Font size for axis labels.
     */

    public void setFontSize(int fontSize) {
        getAmGaugeAxis().fontSize = fontSize;
    }

    public int getGridCount() {
        return getAmGaugeAxis().gridCount;
    }

    /**
     * Number of grid lines. Note, AmGaugeAxis doesn't adjust gridCount, so you should check your values and choose a
     * proper gridCount which would result grids at round numbers. Default to 20
     */

    public void setGridCount(int gridCount) {
        getAmGaugeAxis().gridCount = gridCount;
    }

    public boolean isGridInside() {
        return getAmGaugeAxis().gridInside;
    }

    /**
     * Specifies if grid should be drawn inside or outside the axis. Default to true
     */

    public void setGridInside(boolean gridInside) {
        getAmGaugeAxis().gridInside = gridInside;
    }

    public int getId() {
        return getAmGaugeAxis().id;
    }

    /**
     * Unique id of an axis.
     */

    public void setId(int id) {
        getAmGaugeAxis().id = id;
    }

    public boolean isInside() {
        return getAmGaugeAxis().inside;
    }

    /**
     * Specifies if labels should be placed inside or outside the axis. Default to true
     */

    public void setInside(boolean inside) {
        getAmGaugeAxis().inside = inside;
    }

    /**
     * Adds event listener to the object.
     */
    public void addListener(String type, Functions.Func1<Object> handler) {
        getAmGaugeAxis().addListener(type, handler);
    }

    /**
     * Removes event listener from chart object.
     */
    public void removeListener(AmChart chart, String type, Functions.Func1<Object> handler) {
        getAmGaugeAxis().removeListener(chart, type, handler);
    }

    /**
     * Returns angle of the value.
     */
    public int getValue2angle(int value) {
        return getAmGaugeAxis().value2angle(value);
    }

    public int getLabelFrequency() {
        return getAmGaugeAxis().labelFrequency;
    }

    /**
     * Frequency of labels. Default to 1
     */

    public void setLabelFrequency(int labelFrequency) {
        getAmGaugeAxis().labelFrequency = labelFrequency;
    }

    public Functions.Func getLabelFunction() {
        return getAmGaugeAxis().labelFunction;
    }

    /**
     * You can use this function to format axis labels. This function is called and value is passed as a attribute:
     * labelFunction(value);
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        getAmGaugeAxis().labelFunction = labelFunction;
    }

    public int getLabelOffset() {
        return getAmGaugeAxis().labelOffset;
    }

    /**
     * Distance from axis to the labels. Default to 15
     */

    public void setLabelOffset(int labelOffset) {
        getAmGaugeAxis().labelOffset = labelOffset;
    }

    public boolean isLabelsEnabled() {
        return getAmGaugeAxis().labelsEnabled;
    }

    /**
     * Specifies if labels on the axis should be shown. Default to true
     */

    public void setLabelsEnabled(boolean labelsEnabled) {
        getAmGaugeAxis().labelsEnabled = labelsEnabled;
    }

    public Object[] getListeners() {
        return getAmGaugeAxis().listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickBand", "method":handleClick}];
     */

    public void setListeners(Object[] listeners) {
        getAmGaugeAxis().listeners = listeners;
    }

    public int getMinorTickInterval() {
        return getAmGaugeAxis().minorTickInterval;
    }

    /**
     * Interval, at which minor ticks should be placed.
     */

    public void setMinorTickInterval(int minorTickInterval) {
        getAmGaugeAxis().minorTickInterval = minorTickInterval;
    }

    public int getMinorTickLength() {
        return getAmGaugeAxis().minorTickLength;
    }

    /**
     * Length of a minor tick. Default to 5
     */

    public void setMinorTickLength(int minorTickLength) {
        getAmGaugeAxis().minorTickLength = minorTickLength;
    }

    public Object getRadius() {
        return getAmGaugeAxis().radius;
    }

    /**
     * Axis radius. Default to 95%
     */

    public void setRadius(Object radius) {
        getAmGaugeAxis().radius = radius;
    }

    public boolean isShowFirstLabel() {
        return getAmGaugeAxis().showFirstLabel;
    }

    /**
     * Specifies if the first label should be shown. Default to true
     */

    public void setShowFirstLabel(boolean showFirstLabel) {
        getAmGaugeAxis().showFirstLabel = showFirstLabel;
    }

    public boolean isShowLastLabel() {
        return getAmGaugeAxis().showLastLabel;
    }

    /**
     * Specifies if the last label should be shown. Default to true
     */

    public void setShowLastLabel(boolean showLastLabel) {
        getAmGaugeAxis().showLastLabel = showLastLabel;
    }

    public int getStartAngle() {
        return getAmGaugeAxis().startAngle;
    }

    /**
     * Axis start angle. Valid values are from - 180 to 180. Default to -120
     */

    public void setStartAngle(int startAngle) {
        getAmGaugeAxis().startAngle = startAngle;
    }

    public int getStartValue() {
        return getAmGaugeAxis().startValue;
    }

    /**
     * Axis start (min) value. Default to 0
     */

    public void setStartValue(int startValue) {
        getAmGaugeAxis().startValue = startValue;
    }

    public double getTickAlpha() {
        return getAmGaugeAxis().tickAlpha;
    }

    /**
     * Opacity of axis ticks. Default to 1
     */

    public void setTickAlpha(double tickAlpha) {
        getAmGaugeAxis().tickAlpha = tickAlpha;
    }

    public String getTickColor() {
        return getAmGaugeAxis().tickColor;
    }

    /**
     * Color of axis ticks. Default to #555555
     */

    public void setTickColor(String tickColor) {
        getAmGaugeAxis().tickColor = tickColor;
    }

    public int getTickLength() {
        return getAmGaugeAxis().tickLength;
    }

    /**
     * Length of a major tick. Default to 10
     */

    public void setTickLength(int tickLength) {
        getAmGaugeAxis().tickLength = tickLength;
    }

    public int getTickThickness() {
        return getAmGaugeAxis().tickThickness;
    }

    /**
     * Tick thickness. Default to 1
     *
     * @param tickThickness
     */

    public void setTickThickness(int tickThickness) {
        getAmGaugeAxis().tickThickness = tickThickness;
    }

    public String getTopText() {
        return getAmGaugeAxis().topText;
    }

    /**
     * Sets top text.
     */
    public void setTopText(String text) {
        getAmGaugeAxis().setTopText(text);
    }

    public boolean isTopTextBold() {
        return getAmGaugeAxis().topTextBold;
    }

    /**
     * Specifies if text should be bold. Default to true
     */

    public void setTopTextBold(boolean topTextBold) {
        getAmGaugeAxis().topTextBold = topTextBold;
    }


    public String getTopTextColor() {
        return getAmGaugeAxis().topTextColor;
    }

    /**
     * Color of top text.
     */

    public void setTopTextColor(String topTextColor) {
        getAmGaugeAxis().topTextColor = topTextColor;
    }


    public int getTopTextFontSize() {
        return getAmGaugeAxis().topTextFontSize;
    }

    /**
     * Font size of top text.
     */

    public void setTopTextFontSize(int topTextFontSize) {
        getAmGaugeAxis().topTextFontSize = topTextFontSize;
    }


    public int getTopTextYOffset() {
        return getAmGaugeAxis().topTextYOffset;
    }

    /**
     * Y offset of top text. Default to 0
     */

    public void setTopTextYOffset(int topTextYOffset) {
        getAmGaugeAxis().topTextYOffset = topTextYOffset;
    }


    public String getUnit() {
        return getAmGaugeAxis().unit;
    }

    /**
     * A string which can be placed next to axis labels.
     */

    public void setUnit(String unit) {
        getAmGaugeAxis().unit = unit;
    }


    public String getUnitPosition() {
        return getAmGaugeAxis().unitPosition;
    }

    /**
     * Position of the unit. Default to "right"
     */

    public void setUnitPosition(Position unitPosition) {
        getAmGaugeAxis().unitPosition = unitPosition.getName();
    }


    public boolean isUsePrefixes() {
        return getAmGaugeAxis().usePrefixes;
    }

    /**
     * Specifies if small and big numbers should use prefixes to make them more readable. Default to false
     */

    public void setUsePrefixes(boolean usePrefixes) {
        getAmGaugeAxis().usePrefixes = usePrefixes;
    }


    public int getValueInterval() {
        return getAmGaugeAxis().valueInterval;
    }

    /**
     * Interval, at which ticks with values should be placed.
     */

    public void setValueInterval(int valueInterval) {
        getAmGaugeAxis().valueInterval = valueInterval;
    }

    public AmGaugeAxis getAmGaugeAxis() {
        if (gaugeAxis == null) {
            gaugeAxis = new AmGaugeAxis();
        }
        return gaugeAxis;
    }

    @Override
    public HandlerRegistration addClickBandHandler(ClickBandEvent.ClickBandHandler handler) {
        return addHandler(ClickBandEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOutBandHandler(RollOutBandEvent.RollOutBandHandler handler) {
        return addHandler(RollOutBandEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverBandHandler(RollOverBandEvent.RollOverBandHandler handler) {
        return addHandler(RollOverBandEvent.getType(), handler);
    }
}
