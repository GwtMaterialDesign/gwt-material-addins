package gwt.material.design.addins.client.inputmask.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class InputMaskError {

    @JsProperty(name = "e")
    public String error;

    @JsProperty(name = "p")
    public String position;

    @JsProperty(name = "v")
    public String value;
}
