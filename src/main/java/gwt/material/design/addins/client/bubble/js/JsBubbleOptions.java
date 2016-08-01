package gwt.material.design.addins.client.bubble.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for bubble component
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsBubbleOptions {

    @JsProperty
    public String position;

    @JsProperty
    public String color;

}
