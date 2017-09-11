package gwt.material.design.addins.client.gesture.velocity.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsTransitionOptions {

    @JsProperty
    public int duration;

    @JsProperty
    public boolean queue;

    @JsProperty
    public String easing;

    @JsProperty
    public Functions.Func complete;
}
