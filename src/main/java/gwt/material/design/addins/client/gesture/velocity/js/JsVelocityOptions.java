package gwt.material.design.addins.client.gesture.velocity.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsVelocityOptions {

    @JsProperty
    public double translateX;

    @JsProperty
    public double translateY;

    @JsProperty
    public int width;

    @JsProperty
    public int height;

    @JsProperty
    public int padding;

    @JsProperty
    public int margin;
}
