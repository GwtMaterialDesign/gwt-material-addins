package gwt.material.design.incubator.client.chart.chartjs.js.options.global;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The chart legend displays data about the datasets that area appearing on the chart.
 *
 * @author kevzlou7979@gmail.com
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LegendOptions {

    @JsProperty
    public boolean display;

    @JsProperty
    public String position;

    @JsProperty
    public boolean fullWidth;

    @JsProperty
    public Functions.Func onClick;

    @JsProperty
    public Functions.Func onHover;

    @JsProperty
    public boolean reverse;

    @JsProperty
    public LabelOptions labels;
}
