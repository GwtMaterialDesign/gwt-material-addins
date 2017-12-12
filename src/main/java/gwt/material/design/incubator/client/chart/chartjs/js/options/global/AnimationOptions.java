package gwt.material.design.incubator.client.chart.chartjs.js.options.global;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AnimationOptions {

    @JsProperty
    int duration;

    @JsProperty
    String easing;

    @JsProperty
    Functions.Func onProgress;

    @JsProperty
    Functions.Func onComplete;
}
