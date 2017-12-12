package gwt.material.design.incubator.client.chart.chartjs.js.options.global;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LabelOptions {

    @JsProperty
    public int boxWidth;

    @JsProperty
    public int fontSize;

    @JsProperty
    public String fontStyle;

    @JsProperty
    public String fontColor;

    @JsProperty
    public String fontFamily;

    @JsProperty
    public int padding;

    @JsProperty
    public Functions.Func generateLabels;

    @JsProperty
    public Functions.Func filter;

    @JsProperty
    public boolean usePointStyle;
}
