package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.plugins.DataLoader;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmChart {

    @JsProperty
    public String type;

    @JsProperty
    public String theme;

    @JsProperty
    public Object dataProvider;

    @JsProperty
    public DataLoader dataLoader;

    @JsProperty
    public String fontFamily;

    @JsMethod
    public native void write(String elementId);
}
