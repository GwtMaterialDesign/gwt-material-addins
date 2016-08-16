package gwt.material.design.addins.client.richeditor.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Rich Editor component
 * @author kevzlou7979
 */
@JsType(isNative = true)
public class JsRichEditor extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(String selector);

    @JsMethod
    public native JQueryElement materialnote(JsRichEditorOptions options);

    @JsMethod
    public native JQueryElement materialnote(String action, String value);

    @JsMethod
    public native JQueryElement materialnote(String action);

    @JsMethod
    public native String code();

    @JsMethod
    public native void code(String html);
}
