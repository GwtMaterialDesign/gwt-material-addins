package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmChartGenerator {

    @JsMethod(namespace = "AmCharts")
    public static native void ready(Functions.Func callback);

    @JsMethod(namespace = "AmCharts")
    public static native void makeChart(String elementId, Object value);
}
