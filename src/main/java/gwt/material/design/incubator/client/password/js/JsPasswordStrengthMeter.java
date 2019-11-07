package gwt.material.design.incubator.client.password.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class JsPasswordStrengthMeter {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsPasswordStrengthMeter $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsPasswordStrengthMeter $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsPasswordStrengthMeter $(String selector);

    @JsMethod
    public native void pwdstrength(PasswordStrengthOptions options);
}
