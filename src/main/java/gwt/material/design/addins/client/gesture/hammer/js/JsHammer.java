package gwt.material.design.addins.client.gesture.hammer.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.gesture.hammer.js.events.EventObject;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class JsHammer extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsHammer $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsHammer $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsHammer $(String selector);

    @JsMethod
    public native JsHammer hammer();

    @JsMethod
    public native JsHammer hammer(JsHammerOptions options);

    @JsMethod
    public native JsHammer bind(String events, Functions.Func1<EventObject> e);
}
