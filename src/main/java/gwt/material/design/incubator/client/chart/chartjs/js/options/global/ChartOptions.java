package gwt.material.design.incubator.client.chart.chartjs.js.options.global;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ChartOptions {

    @JsProperty
    public AnimationOptions animation;

    @JsProperty
    public LayoutOptions layout;

    @JsProperty
    public LegendOptions legend;

    @JsProperty
    public TitleOptions title;

    @JsProperty
    public TooltipOptions tooltip;

    @JsProperty
    public ElementOptions elements;
}
