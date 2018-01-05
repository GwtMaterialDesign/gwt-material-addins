package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGuide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;

import java.util.Date;

//@formatter:off

/**
 * Creates a horizontal/vertical guideline-/area for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart},
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} and
 * {@link gwt.material.design.incubator.client.chart.chartjs.RadarChart} charts, automatically
 * adapts it's settings from the axes if none has been specified.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/Guide">Official Documentation</a>
 */
//@formatter:on
public class Guide extends ChartOptions {

    private AmGuide guide;

    public final boolean isAbove() {
        return getAmGuide().above;
    }

    /**
     * If you set it to true, the guide will be displayed above the graphs. Default to false
     */

    public final void setAbove(boolean above) {
        getAmGuide().above = above;
    }


    public final int getAngle() {
        return getAmGuide().angle;
    }

    /**
     * Radar chart only. Specifies angle at which guide should start. Affects only fills, not lines.
     */

    public final void setAngle(int angle) {
        getAmGuide().angle = angle;
    }


    public final String getBalloonColor() {
        return getAmGuide().balloonColor;
    }

    /**
     * Baloon fill color.
     */

    public final void setBalloonColor(String balloonColor) {
        getAmGuide().balloonColor = balloonColor;
    }


    public final String getBalloonText() {
        return getAmGuide().balloonText;
    }

    /**
     * The text which will be displayed if the user rolls-over the guide.
     */

    public final void setBalloonText(String balloonText) {
        getAmGuide().balloonText = balloonText;
    }


    public final boolean isBoldLabel() {
        return getAmGuide().boldLabel;
    }

    /**
     * Specifies if label should be bold or not. Default to false
     */

    public final void setBoldLabel(boolean boldLabel) {
        getAmGuide().boldLabel = boldLabel;
    }


    public final String getCategory() {
        return getAmGuide().category;
    }

    /**
     * Category of the guide (in case the guide is for category axis).
     */

    public final void setCategory(String category) {
        getAmGuide().category = category;
    }


    public final String getColor() {
        return getAmGuide().color;
    }

    /**
     * Color of a guide label.
     */

    public final void setColor(String color) {
        getAmGuide().color = color;
    }


    public final int getDashLength() {
        return getAmGuide().dashLength;
    }

    /**
     * Dash length.
     */

    public final void setDashLength(int dashLength) {
        getAmGuide().dashLength = dashLength;
    }


    public final Date getDate() {
        return getAmGuide().date;
    }

    /**
     * Date of the guide (in case the guide is for category axis and parseDates is set to true).
     */

    public final void setDate(Date date) {
        getAmGuide().date = date;
    }


    public final boolean isExpand() {
        return getAmGuide().expand;
    }

    /**
     * Works if a guide is added to CategoryAxis and this axis is non-date-based. If you set it to true, the guide will
     * start (or be placed, if it's not a fill) on the beginning of the category cell and will end at the end of toCategory cell.
     * Default to false
     */

    public final void setExpand(boolean expand) {
        getAmGuide().expand = expand;
    }


    public final double getFillAlpha() {
        return getAmGuide().fillAlpha;
    }

    /**
     * Fill opacity. Value range is 0 - 1.
     */

    public final void setFillAlpha(double fillAlpha) {
        getAmGuide().fillAlpha = fillAlpha;
    }


    public final String getFillColor() {
        return getAmGuide().fillColor;
    }

    /**
     * Fill color.
     */

    public final void setFillColor(String fillColor) {
        getAmGuide().fillColor = fillColor;
    }


    public final int getFontSize() {
        return getAmGuide().fontSize;
    }

    /**
     * Font size of guide label.
     */

    public final void setFontSize(int fontSize) {
        getAmGuide().fontSize = fontSize;
    }


    public final String getId() {
        return getAmGuide().id;
    }

    /**
     * Unique id of a AmGuide. You don't need to set it, unless you want to.
     */

    public final void setId(String id) {
        getAmGuide().id = id;
    }


    public final boolean isInside() {
        return getAmGuide().inside;
    }

    /**
     * Specifies whether label should be placed inside or outside plot area.
     */

    public final void setInside(boolean inside) {
        getAmGuide().inside = inside;
    }


    public final String getLabel() {
        return getAmGuide().label;
    }

    /**
     * The label which will be displayed near the guide.
     */

    public final void setLabel(String label) {
        getAmGuide().label = label;
    }


    public final int getLabelRotation() {
        return getAmGuide().labelRotation;
    }

    /**
     * Rotation angle of a guide label.
     */

    public final void setLabelRotation(int labelRotation) {
        getAmGuide().labelRotation = labelRotation;
    }


    public final double getLineAlpha() {
        return getAmGuide().lineAlpha;
    }

    /**
     * Line opacity.
     */

    public final void setLineAlpha(double lineAlpha) {
        getAmGuide().lineAlpha = lineAlpha;
    }


    public final String getLineColor() {
        return getAmGuide().lineColor;
    }

    /**
     * Line color.
     */

    public final void setLineColor(String lineColor) {
        getAmGuide().lineColor = lineColor;
    }


    public final int getLineThickness() {
        return getAmGuide().lineThickness;
    }

    /**
     * Line thickness.
     */

    public final void setLineThickness(int lineThickness) {
        getAmGuide().lineThickness = lineThickness;
    }


    public final String getPosition() {
        return getAmGuide().position;
    }

    /**
     * Position of guide label. Possible values are "left" or "right" for horizontal axis and "top" or "bottom" for vertical axis.
     */

    public final void setPosition(String position) {
        getAmGuide().position = position;
    }


    public final int getTickLength() {
        return getAmGuide().tickLength;
    }

    /**
     * Tick length.
     */

    public final void setTickLength(int tickLength) {
        getAmGuide().tickLength = tickLength;
    }


    public final int getToAngle() {
        return getAmGuide().toAngle;
    }

    /**
     * Radar chart only. Specifies angle at which guide should end. Affects only fills, not lines.
     */

    public final void setToAngle(int toAngle) {
        getAmGuide().toAngle = toAngle;
    }


    public final String getToCategory() {
        return getAmGuide().toCategory;
    }

    /**
     * "To" category of the guide (in case the guide is for category axis).
     */

    public final void setToCategory(String toCategory) {
        getAmGuide().toCategory = toCategory;
    }


    public final Date getToDate() {
        return getAmGuide().toDate;
    }

    /**
     * "To" date of the guide (in case the guide is for category axis and parseDates is set to true) If you have both
     * date and toDate, the space between these two dates can be filled with color.
     */

    public final void setToDate(Date toDate) {
        getAmGuide().toDate = toDate;
    }


    public final int getToValue() {
        return getAmGuide().toValue;
    }

    /**
     * "To" value of the guide (in case the guide is for value axis).
     */

    public final void setToValue(int toValue) {
        getAmGuide().toValue = toValue;
    }


    public final int getValue() {
        return getAmGuide().value;
    }

    /**
     * Value of the guide (in case the guide is for value axis).
     */

    public final void setValue(int value) {
        getAmGuide().value = value;
    }


    public final AmValueAxis getValueAxis() {
        return getAmGuide().valueAxis;
    }

    /**
     * Value axis of a guide. As you can add guides directly to the chart, you might need to specify which which value
     * axis should be used.
     */

    public final void setValueAxis(AmValueAxis valueAxis) {
        getAmGuide().valueAxis = valueAxis;
    }

    public AmGuide getAmGuide() {
        if (guide == null) {
            guide = new AmGuide();
        }
        return guide;
    }
}
