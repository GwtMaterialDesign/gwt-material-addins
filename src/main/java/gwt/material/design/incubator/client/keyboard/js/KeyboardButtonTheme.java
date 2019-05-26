package gwt.material.design.incubator.client.keyboard.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KeyboardButtonTheme {

    @JsProperty(name = "class")
    public String className;

    @JsProperty
    public String buttons;
}
