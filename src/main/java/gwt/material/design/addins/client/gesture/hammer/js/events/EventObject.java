package gwt.material.design.addins.client.gesture.hammer.js.events;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class EventObject {

    @JsProperty
    public String type;

    @JsProperty
    public Gesture gesture;
}
