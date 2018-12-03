package gwt.material.design.incubator.client.daterange.js;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LocaleString {

    @JsConstructor
    public LocaleString(String value) {
        this.value = value;
    }

    @JsProperty
    public String value;
}
