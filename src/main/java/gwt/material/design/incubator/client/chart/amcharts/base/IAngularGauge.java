package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeArrow;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeAxis;

public interface IAngularGauge {

    /**
     * Uses the whole space of the canvas to draw the gauge. Default to true
     */
    void setAdjustSize(boolean adjustSize);

    /**
     * Array of arrows.
     */
    void setArrows(GaugeArrow... arrows);

    /**
     * Array of axes.
     */
    void setAxes(GaugeAxis axes);

    /**
     * In case you use gauge to create a clock, set this to true. Default to false
     */
    void setClockWiseOnly(boolean clockWiseOnly);

    /**
     * Gauge face opacity. Default to 0
     */
    void setFaceAlpha(double faceAlpha);

    /**
     * Gauge face opacity. Default to 0
     */
    void setFaceBorderAlpha(double faceBorderAlpha);

    /**
     * Gauge face border color. Default to #555555
     */
    void setFaceBorderColor(String faceBorderColor);

    /**
     * Gauge face border width. Default to 1
     */
    void setFaceBorderWidth(int faceBorderWidth);

    /**
     * Gauge face color, requires faceAlpha > 0. Default to #FAFAFA
     */
    void setFaceColor(String faceColor);

    /**
     * Gauge face image-pattern.
     * Example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}
     */
    void setFacePattern(Object facePattern);

    /**
     * Gauge's horizontal position in pixel, origin is the center. Centered by default.
     */
    void setGaugeX(int gaugeX);

    /**
     * Gauge's vertical position in pixel, origin is the center. Centered by default.
     */
    void setGaugeY(int gaugeY);

    /**
     * Bottom spacing between chart and container. Default to 10
     */
    void setMarginBottom(int marginBottom);

    /**
     * Left-hand spacing between chart and container. Default to 10
     */
    void setMarginLeft(int marginLeft);

    /**
     * Right-hand spacing between chart and container. Default to 10
     */
    void setMarginRight(int marginRight);

    /**
     * Top spacing between chart and container. Default to 10
     */
    void setMarginTop(int marginTop);

    /**
     * Minimum radius of a gauge. Default to 10
     */
    void setMinRadius(int minRadius);

    /**
     * Duration of arrow animation. Default to 1
     */
    void setStartDuration(int startDuration);

    /**
     * Transition effect of the arrows, possible effects: easeOutSine, easeInSine, elastic, bounce. Default to "easeInSine"
     */
    void setStartEffect(AnimationEffect startEffect);

    /**
     * Adds arrow to the chart.
     */
    void addArrow(GaugeArrow gaugeArrow);

    /**
     * Adds arrow to the chart.
     */
    void addAxis(GaugeAxis gaugeAxis);

    /**
     * Removes arrow from the chart.
     */
    void removeArrow(GaugeArrow gaugeArrow);

    /**
     * Removes axis from the chart.
     */
    void removeAxis(GaugeAxis gaugeAxis);
}
