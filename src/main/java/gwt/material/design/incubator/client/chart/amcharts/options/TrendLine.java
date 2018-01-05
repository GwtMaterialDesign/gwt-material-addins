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

public class TrendLine extends ChartOptions implements HasTrendLineHandlers {

    private AmTrendLine trendLine = new AmTrendLine();

    @Override
    public void load() {
        //trendLine.li
    }

    public String getBalloonText() {
        return trendLine.balloonText;
    }

    /**
     * When set, enables displaying a roll-over balloon.
     */

    public void setBalloonText(String balloonText) {
        trendLine.balloonText = balloonText;
    }

    public int getDashLength() {
        return trendLine.dashLength;
    }

    /**
     * Dash length. Default to 0
     */

    public void setDashLength(int dashLength) {
        trendLine.dashLength = dashLength;
    }

    public String getFinalCategory() {
        return trendLine.finalCategory;
    }

    /**
     * String, equal to category value to which trend line should be drawn. It should be used if chart doesn't parse dates.
     */

    public void setFinalCategory(String finalCategory) {
        trendLine.finalCategory = finalCategory;
    }

    public Date getFinalDate() {
        return trendLine.finalDate;
    }

    /**
     * Date to which trend line should be drawn. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */

    public void setFinalDate(Date finalDate) {
        trendLine.finalDate = finalDate;
    }

    public Image getFinalImage() {
        return trendLine.finalImage;
    }

    /**
     * Allows to add an image to the end of a trend line.
     */

    public void setFinalImage(Image finalImage) {
        trendLine.finalImage = finalImage;
    }

    public int getFinalValue() {
        return trendLine.finalValue;
    }

    /**
     * Value at which trend line should end.
     */

    public void setFinalValue(int finalValue) {
        trendLine.finalValue = finalValue;
    }

    public int getFinalXValue() {
        return trendLine.finalXValue;
    }

    /**
     * Used by XY chart only. X value at which trend line should end.
     */

    public void setFinalXValue(int finalXValue) {
        trendLine.finalXValue = finalXValue;
    }

    public String getId() {
        return trendLine.id;
    }

    /**
     * Unique id of a Trend line. You don't need to set it, unless you want to.
     */

    public void setId(String id) {
        trendLine.id = id;
    }

    public String getInitialCategory() {
        return trendLine.initialCategory;
    }

    /**
     * String, equal to category value from which trend line should start. It should be used if chart doesn't parse dates.
     */

    public void setInitialCategory(String initialCategory) {
        trendLine.initialCategory = initialCategory;
    }

    public Date getInitialDate() {
        return trendLine.initialDate;
    }

    /**
     * Date from which trend line should start. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */

    public void setInitialDate(Date initialDate) {
        trendLine.initialDate = initialDate;
    }

    public Image getInitialImage() {
        return trendLine.initialImage;
    }

    /**
     * Allows to add an image to the beginning of a trend line.
     */

    public void setInitialImage(Image initialImage) {
        trendLine.initialImage = initialImage;
    }

    public int getInitialValue() {
        return trendLine.initialValue;
    }

    /**
     * Value from which trend line should start.
     */

    public void setInitialValue(int initialValue) {
        trendLine.initialValue = initialValue;
    }

    public int getInitialXValue() {
        return trendLine.initialXValue;
    }

    /**
     * Used by XY chart only. X value from which trend line should start.
     */

    public void setInitialXValue(int initialXValue) {
        trendLine.initialXValue = initialXValue;
    }

    public boolean isProtected() {
        return trendLine.isProtected;
    }

    /**
     * Used by Stock chart. If this property is set to true, this trend line won't be removed when clicked on eraser tool.
     * Default to false
     */

    public void setProtected(boolean aProtected) {
        trendLine.isProtected = isProtected();
    }

    public double getLineAlpha() {
        return trendLine.lineAlpha;
    }

    /**
     * Line opacity. Default to 1
     */

    public void setLineAlpha(double lineAlpha) {
        trendLine.lineAlpha = lineAlpha;
    }

    public String getLineColor() {
        return trendLine.lineColor;
    }

    /**
     * Line color. Default to #00CC00
     */

    public void setLineColor(String lineColor) {
        trendLine.lineColor = lineColor;
    }

    public int getLineThickness() {
        return trendLine.lineThickness;
    }

    /**
     * Line thickness. Default to 1
     */

    public void setLineThickness(int lineThickness) {
        trendLine.lineThickness = lineThickness;
    }

    public AmValueAxis getValueAxis() {
        return trendLine.valueAxis;
    }

    /**
     * Value axis of the trend line. Will use first value axis of the chart if not set any. You can use a reference to
     * the value axis object or id of value axis.
     */

    public void setValueAxis(AmValueAxis valueAxis) {
        trendLine.valueAxis = valueAxis;
    }

    public AmValueAxis getValueAxisX() {
        return trendLine.valueAxisX;
    }

    /**
     * Used by XY chart only. X axis of trend line. Will use first X axis of the chart if not set any. You can use a
     * reference to the value axis object or id of value axis.
     */

    public void setValueAxisX(AmValueAxis valueAxisX) {
        trendLine.valueAxisX = valueAxisX;
    }

    public AmTrendLine getTrendLine() {
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
