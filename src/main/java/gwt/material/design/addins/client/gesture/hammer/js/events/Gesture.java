package gwt.material.design.addins.client.gesture.hammer.js.events;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Gesture {

    @JsProperty
    public int deltaX;

    @JsProperty
    public int deltaY;

    @JsProperty
    public int deltaTime;

    @JsProperty
    public int distance;

    @JsProperty
    public int angle;

    @JsProperty
    public double velocityX;

    @JsProperty
    public double velocityY;

    @JsProperty
    public double velocity;

    @JsProperty
    public int direction;
}
