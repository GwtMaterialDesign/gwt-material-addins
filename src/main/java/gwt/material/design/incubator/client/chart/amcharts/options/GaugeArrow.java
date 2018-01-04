package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeArrow;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGaugeAxis;
import jsinterop.annotations.JsMethod;

public class GaugeArrow extends ChartOptions {

    private AmGaugeArrow gaugeArrow = new AmGaugeArrow();

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    public double getAlpha() {
        return gaugeArrow.alpha;
    }

    /**
     * Opacity of an arrow. Default to 1
     */

    public void setAlpha(double alpha) {
        gaugeArrow.alpha = alpha;
    }

    public AmGaugeAxis getAxis() {
        return gaugeArrow.axis;
    }

    /**
     * Axis of the arrow. You can use reference to the axis or id of the axis. If you don't set any axis, the first
     * axis of a chart will be used.
     */

    public void setAxis(AmGaugeAxis axis) {
        gaugeArrow.axis = axis;
    }

    public int getBorderAlpha() {
        return gaugeArrow.borderAlpha;
    }

    /**
     * Opacity of arrow border. Default to 1
     */

    public void setBorderAlpha(int borderAlpha) {
        gaugeArrow.borderAlpha = borderAlpha;
    }

    public boolean isClockWiseOnly() {
        return gaugeArrow.clockWiseOnly;
    }

    /**
     * In case you need the arrow to rotate only clock-wise, set this property to true. Default to false
     */

    public void setClockWiseOnly(boolean clockWiseOnly) {
        gaugeArrow.clockWiseOnly = clockWiseOnly;
    }

    public String getColor() {
        return gaugeArrow.color;
    }

    /**
     * Color of an arrow. Default to #000000
     */

    public void setColor(String color) {
        gaugeArrow.color = color;
    }

    public String getId() {
        return gaugeArrow.id;
    }

    /**
     * Unique id of an arrow.
     */

    public void setId(String id) {
        gaugeArrow.id = id;
    }

    public Object getInnerRadius() {
        return gaugeArrow.innerRadius;
    }

    /**
     * Inner radius of an arrow. Default to 0
     */

    public void setInnerRadius(Object innerRadius) {
        gaugeArrow.innerRadius = innerRadius;
    }

    public int getNailAlpha() {
        return gaugeArrow.nailAlpha;
    }

    /**
     * Opacity of a nail, holding the arrow. Default to 1
     */

    public void setNailAlpha(int nailAlpha) {
        gaugeArrow.nailAlpha = nailAlpha;
    }

    public int getNailBorderAlpha() {
        return gaugeArrow.nailBorderAlpha;
    }

    /**
     * Opacity of nail border. Default to 0
     */

    public void setNailBorderAlpha(int nailBorderAlpha) {
        gaugeArrow.nailBorderAlpha = nailBorderAlpha;
    }

    public int getNailBorderThickness() {
        return gaugeArrow.nailBorderThickness;
    }

    /**
     * Thickness of nail border. Default to 1
     */

    public void setNailBorderThickness(int nailBorderThickness) {
        gaugeArrow.nailBorderThickness = nailBorderThickness;
    }

    public int getNailRadius() {
        return gaugeArrow.nailRadius;
    }

    /**
     * Radius of a nail, holding the arrow. Default to 8
     */

    public void setNailRadius(int nailRadius) {
        gaugeArrow.nailRadius = nailRadius;
    }

    public Object getRadius() {
        return gaugeArrow.radius;
    }

    /**
     * Radius of an arrow. Default to 90%
     */

    public void setRadius(Object radius) {
        gaugeArrow.radius = radius;
    }

    public int getStartWidth() {
        return gaugeArrow.startWidth;
    }

    /**
     * Default to 8
     */

    public void setStartWidth(int startWidth) {
        gaugeArrow.startWidth = startWidth;
    }

    public int getValue() {
        return gaugeArrow.value;
    }

    /**
     * Value to which the arrow should point at.
     */
    @JsMethod
    public native void setValue(int value);

    public AmGaugeArrow getGaugeArrow() {
        return gaugeArrow;
    }
}
