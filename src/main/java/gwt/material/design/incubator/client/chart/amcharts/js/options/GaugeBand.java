package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeBand {

    @JsProperty
    public double alpha;

    @JsProperty
    public String balloonText;

    @JsProperty
    public String color;

    @JsProperty
    public int endValue;

    @JsProperty
    public int[] gradientRatio;

    @JsProperty
    public String id;

    @JsProperty
    public Object innerRadius;

    @JsProperty
    public Object radius;

    @JsProperty
    public int startValue;

    @JsProperty
    public String url;

    @JsMethod
    public native void setEndValue(int value);

    @JsMethod
    public native void setStartValue(int value);

    // TODO Events
}
