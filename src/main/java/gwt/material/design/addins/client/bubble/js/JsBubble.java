package gwt.material.design.addins.client.bubble.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Bubble component
 */
@JsType(isNative = true, name = JsPackage.GLOBAL)
public class JsBubble extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsBubble $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsBubble $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsBubble $(String selector);

    @JsMethod
    public native JQueryElement bubble(JsBubbleOptions options);

}
