package gwt.material.design.incubator.client.chart.chartjs.js.datasets;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PolarDataSets extends ChartDataSets {

    @JsProperty
    public String label;

    @JsProperty
    public String[] backgroundColor;

    @JsProperty
    public String[] borderColor;

    @JsProperty
    public int[] borderWidth;

    @JsProperty
    public String[] hoverBackgroundColor;

    @JsProperty
    public String[] hoverBorderColor;

    @JsProperty
    public int[] hoverBorderWidth;
}
