package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.events.HasTrendLineHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineClickEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineRollOutEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineRollOverEvent;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmTrendLine;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Image;

import java.util.Date;

//@formatter:off

/**
 * Creates a trendline for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} and
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} charts which indicates the trend of your data
 * or covers some different purposes. Multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/TrendLine">Official Documentation</a>
 */
//@formatter:on
public class TrendLine extends ChartOptions implements HasTrendLineHandlers {

    private AmTrendLine trendLine;

    public String getBalloonText() {
        return getAmTrendLine().balloonText;
    }

    /**
     * When set, enables displaying a roll-over balloon.
     */

    public void setBalloonText(String balloonText) {
        getAmTrendLine().balloonText = balloonText;
    }

    public int getDashLength() {
        return getAmTrendLine().dashLength;
    }

    /**
     * Dash length. Default to 0
     */

    public void setDashLength(int dashLength) {
        getAmTrendLine().dashLength = dashLength;
    }

    public String getFinalCategory() {
        return getAmTrendLine().finalCategory;
    }

    /**
     * String, equal to category value to which trend line should be drawn. It should be used if chart doesn't parse dates.
     */

    public void setFinalCategory(String finalCategory) {
        getAmTrendLine().finalCategory = finalCategory;
    }

    public Date getFinalDate() {
        return getAmTrendLine().finalDate;
    }

    /**
     * Date to which trend line should be drawn. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */

    public void setFinalDate(Date finalDate) {
        getAmTrendLine().finalDate = finalDate;
    }

    public Image getFinalImage() {
        return getAmTrendLine().finalImage;
    }

    /**
     * Allows to add an image to the end of a trend line.
     */

    public void setFinalImage(Image finalImage) {
        getAmTrendLine().finalImage = finalImage;
    }

    public int getFinalValue() {
        return getAmTrendLine().finalValue;
    }

    /**
     * Value at which trend line should end.
     */

    public void setFinalValue(int finalValue) {
        getAmTrendLine().finalValue = finalValue;
    }

    public int getFinalXValue() {
        return getAmTrendLine().finalXValue;
    }

    /**
     * Used by XY chart only. X value at which trend line should end.
     */

    public void setFinalXValue(int finalXValue) {
        getAmTrendLine().finalXValue = finalXValue;
    }

    public String getId() {
        return getAmTrendLine().id;
    }

    /**
     * Unique id of a Trend line. You don't need to set it, unless you want to.
     */

    public void setId(String id) {
        getAmTrendLine().id = id;
    }

    public String getInitialCategory() {
        return getAmTrendLine().initialCategory;
    }

    /**
     * String, equal to category value from which trend line should start. It should be used if chart doesn't parse dates.
     */

    public void setInitialCategory(String initialCategory) {
        getAmTrendLine().initialCategory = initialCategory;
    }

    public Date getInitialDate() {
        return getAmTrendLine().initialDate;
    }

    /**
     * Date from which trend line should start. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */

    public void setInitialDate(Date initialDate) {
        getAmTrendLine().initialDate = initialDate;
    }

    public Image getInitialImage() {
        return getAmTrendLine().initialImage;
    }

    /**
     * Allows to add an image to the beginning of a trend line.
     */

    public void setInitialImage(Image initialImage) {
        getAmTrendLine().initialImage = initialImage;
    }

    public int getInitialValue() {
        return getAmTrendLine().initialValue;
    }

    /**
     * Value from which trend line should start.
     */

    public void setInitialValue(int initialValue) {
        getAmTrendLine().initialValue = initialValue;
    }

    public int getInitialXValue() {
        return getAmTrendLine().initialXValue;
    }

    /**
     * Used by XY chart only. X value from which trend line should start.
     */

    public void setInitialXValue(int initialXValue) {
        getAmTrendLine().initialXValue = initialXValue;
    }

    public boolean isProtected() {
        return getAmTrendLine().isProtected;
    }

    /**
     * Used by Stock chart. If this property is set to true, this trend line won't be removed when clicked on eraser tool.
     * Default to false
     */

    public void setProtected(boolean aProtected) {
        getAmTrendLine().isProtected = isProtected();
    }

    public double getLineAlpha() {
        return getAmTrendLine().lineAlpha;
    }

    /**
     * Line opacity. Default to 1
     */

    public void setLineAlpha(double lineAlpha) {
        getAmTrendLine().lineAlpha = lineAlpha;
    }

    public String getLineColor() {
        return getAmTrendLine().lineColor;
    }

    /**
     * Line color. Default to #00CC00
     */

    public void setLineColor(String lineColor) {
        getAmTrendLine().lineColor = lineColor;
    }

    public int getLineThickness() {
        return getAmTrendLine().lineThickness;
    }

    /**
     * Line thickness. Default to 1
     */

    public void setLineThickness(int lineThickness) {
        getAmTrendLine().lineThickness = lineThickness;
    }

    public AmValueAxis getValueAxis() {
        return getAmTrendLine().valueAxis;
    }

    /**
     * Value axis of the trend line. Will use first value axis of the chart if not set any. You can use a reference to
     * the value axis object or id of value axis.
     */

    public void setValueAxis(AmValueAxis valueAxis) {
        getAmTrendLine().valueAxis = valueAxis;
    }

    public AmValueAxis getValueAxisX() {
        return getAmTrendLine().valueAxisX;
    }

    /**
     * Used by XY chart only. X axis of trend line. Will use first X axis of the chart if not set any. You can use a
     * reference to the value axis object or id of value axis.
     */

    public void setValueAxisX(AmValueAxis valueAxisX) {
        getAmTrendLine().valueAxisX = valueAxisX;
    }

    public AmTrendLine getAmTrendLine() {
        if (trendLine == null) {
            trendLine = new AmTrendLine();
        }
        return trendLine;
    }

    @Override
    public void addTrendLineClickHandler(TrendLineClickEvent.TrendLineClickHandler handler) {
        addHandler(TrendLineClickEvent.getType(), handler);
    }

    @Override
    public void addTrendLineRollOutHandler(TrendLineRollOutEvent.TrendLineRollOutHandler handler) {
        addHandler(TrendLineRollOutEvent.getType(), handler);
    }

    @Override
    public void addTrendLineRollOverHandler(TrendLineRollOverEvent.TrendLineRollOverHandler handler) {
        addHandler(TrendLineRollOverEvent.getType(), handler);
    }
}
