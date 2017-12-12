package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.Graph;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmCoordinateChart extends AmChart {

    @JsMethod
    public native void addGraph(Graph graph);
}
