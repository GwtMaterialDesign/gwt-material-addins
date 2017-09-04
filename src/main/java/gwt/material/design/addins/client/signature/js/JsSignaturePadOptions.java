package gwt.material.design.addins.client.signature.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsSignaturePadOptions {

    @JsProperty
    public float dotSize;

    @JsProperty
    public float minWidth;

    @JsProperty
    public float maxWidth;

    @JsProperty
    public int throttle;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public String penColor;

    @JsProperty
    public float velocityFilterWeight;

    @JsProperty
    public Functions.Func onBegin;

    @JsProperty
    public Functions.Func onEnd;
}
