package gwt.material.design.addins.client.camera;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop util for camera component
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsCamera extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCamera $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCamera $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsCamera $(String selector);

    @JsMethod
    public native JsCamera play();
}
