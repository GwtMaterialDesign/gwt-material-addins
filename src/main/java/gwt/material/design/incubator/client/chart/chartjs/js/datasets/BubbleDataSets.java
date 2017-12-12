package gwt.material.design.incubator.client.chart.chartjs.js.datasets;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class BubbleDataSets extends ChartDataSets {

    @JsProperty
    public String label;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public String borderColor;

    @JsProperty
    public int[] borderWidth;

    @JsProperty
    public Object[] data;

    @JsProperty
    public String hoverBackgroundColor;

    @JsProperty
    public String hoverBorderColor;

    @JsProperty
    public int hoverBorderWidth;

    @JsProperty
    public int hoverRadius;

    @JsProperty
    public int hitRadius;

    @JsProperty
    public String pointStyle;

    @JsProperty
    private int radius;
}
