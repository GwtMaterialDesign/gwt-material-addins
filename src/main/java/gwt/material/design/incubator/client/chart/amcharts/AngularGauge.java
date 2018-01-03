package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmAngularGauge;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeArrow;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeAxis;

public class AngularGauge extends AbstractChart {

    protected AmAngularGauge angularGauge;

    public AngularGauge() {
        super(ChartType.GAUGE);
    }

    /**
     * Uses the whole space of the canvas to draw the gauge. Default to true
     */
    public void setAdjustSize(boolean adjustSize) {
        getChart().adjustSize = adjustSize;
    }

    /**
     * Array of arrows.
     */
    public void setArrows(GaugeArrow... arrows) {
        getChart().arrows = arrows;
    }

    /**
     * Array of axes.
     */
    public void setAxes(GaugeAxis axes) {
        getChart().axes = axes;
    }

    /**
     * In case you use gauge to create a clock, set this to true. Default to false
     */
    public void setClockWiseOnly(boolean clockWiseOnly) {
        getChart().clockWiseOnly = clockWiseOnly;
    }

    /**
     * Gauge face opacity. Default to 0
     */
    public void setFaceAlpha(double faceAlpha) {
        getChart().faceAlpha = faceAlpha;
    }

    /**
     * Gauge face opacity. Default to 0
     */
    public void setFaceBorderAlpha(double faceBorderAlpha) {
        getChart().faceBorderAlpha = faceBorderAlpha;
    }

    /**
     * Gauge face border color. Default to #555555
     */
    public void setFaceBorderColor(String faceBorderColor) {
        getChart().faceBorderColor = faceBorderColor;
    }

    /**
     * Gauge face border width. Default to 1
     */
    public void setFaceBorderWidth(int faceBorderWidth) {
        getChart().faceBorderWidth = faceBorderWidth;
    }

    /**
     * Gauge face color, requires faceAlpha > 0. Default to #FAFAFA
     */
    public void setFaceColor(String faceColor) {
        getChart().faceColor = faceColor;
    }

    /**
     * Gauge face image-pattern.
     * Example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}
     */
    public void setFacePattern(Object facePattern) {
        getChart().facePattern = facePattern;
    }

    /**
     * Gauge's horizontal position in pixel, origin is the center. Centered by default.
     */
    public void setGaugeX(int gaugeX) {
        getChart().gaugeX = gaugeX;
    }

    /**
     * Gauge's vertical position in pixel, origin is the center. Centered by default.
     */
    public void setGaugeY(int gaugeY) {
        getChart().gaugeY = gaugeY;
    }

    /**
     * Bottom spacing between chart and container. Default to 10
     */
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    /**
     * Left-hand spacing between chart and container. Default to 10
     */
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    /**
     * Right-hand spacing between chart and container. Default to 10
     */
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    /**
     * Top spacing between chart and container. Default to 10
     */
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    /**
     * Minimum radius of a gauge. Default to 10
     */
    public void setMinRadius(int minRadius) {
        getChart().minRadius = minRadius;
    }

    /**
     * Duration of arrow animation. Default to 1
     */
    public void setStartDuration(int startDuration) {
        getChart().startDuration = startDuration;
    }

    /**
     * Transition effect of the arrows, possible effects: easeOutSine, easeInSine, elastic, bounce. Default to "easeInSine"
     */
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    /**
     * Adds arrow to the chart.
     */
    public void addArrow(GaugeArrow gaugeArrow) {
        getChart().addArrow(gaugeArrow);
    }

    /**
     * Adds arrow to the chart.
     */
    public void addAxis(GaugeAxis gaugeAxis) {
        getChart().addAxis(gaugeAxis);
    }

    /**
     * Removes arrow from the chart.
     */
    public void removeArrow(GaugeArrow gaugeArrow) {
        getChart().removeArrow(gaugeArrow);
    }

    /**
     * Removes axis from the chart.
     */
    public void removeAxis(GaugeAxis gaugeAxis) {
        getChart().removeAxis(gaugeAxis);
    }

    @Override
    public AmAngularGauge getChart() {
        if (angularGauge == null) {
            angularGauge = new AmAngularGauge();
        }
        return angularGauge;
    }
}
