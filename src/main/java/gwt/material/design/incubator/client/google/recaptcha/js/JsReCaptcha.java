package gwt.material.design.incubator.client.google.recaptcha.js;

import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsReCaptcha extends JQueryElement {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsReCaptcha initReCaptcha(String element, String siteKey, Functions.Func callback, String theme, String type);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native void reset();
}