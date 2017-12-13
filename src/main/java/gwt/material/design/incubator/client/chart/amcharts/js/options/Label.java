package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Creates a label on the chart which can be placed anywhere, multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Label {

    @JsProperty
    public String align;

    @JsProperty
    public int alpha;

    @JsProperty
    public boolean bold;

    @JsProperty
    public String color;

    @JsProperty
    public String id;

    @JsProperty
    public int rotation;

    @JsProperty
    public int size;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public String text;

    @JsProperty
    public String url;

    @JsProperty
    public String x;

    @JsProperty
    public String y;
}
