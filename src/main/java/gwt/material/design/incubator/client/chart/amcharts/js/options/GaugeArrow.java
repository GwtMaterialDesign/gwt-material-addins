package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 *
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeArrow {

    @JsProperty
    public double alpha;

    @JsProperty
    public GaugeAxis axis;

    @JsProperty
    public int borderAlpha;

    @JsProperty
    public boolean clockWiseOnly;

    @JsProperty
    public String color;

    @JsProperty
    public String id;

    @JsProperty
    public Object innerRadius;

    @JsProperty
    public int nailAlpha;

    @JsProperty
    public int nailBorderAlpha;

    @JsProperty
    public int nailBorderThickness;

    @JsProperty
    public int nailRadius;

    @JsProperty
    public Object radius;

    @JsProperty
    public int startWidth;

    @JsProperty
    public int value;

    @JsMethod
    public native void setValue(int value);
}
