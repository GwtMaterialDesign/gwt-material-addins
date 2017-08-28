package gwt.material.design.addins.client.image.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import gwt.material.design.jquery.client.api.Promise;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class JsCropper extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCropper $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCropper $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCropper $(String selector);

    @JsMethod
    public native JsCropper croppie();

    @JsMethod
    public native JsCropper croppie(Object options);

    @JsMethod
    public native Promise croppie(String method, Object... args);
}
