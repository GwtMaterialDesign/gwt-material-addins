package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class SerialDataItem {

    @JsProperty
    public Object axes;

    @JsProperty
    public String category;

    @JsProperty
    public Object dataContext;

    @JsProperty
    public int time;

    @JsProperty
    public int x;
}
