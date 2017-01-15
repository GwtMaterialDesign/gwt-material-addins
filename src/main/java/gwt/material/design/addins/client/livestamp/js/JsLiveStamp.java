package gwt.material.design.addins.client.livestamp.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.masonry.js.JsMasonry;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true)
public class JsLiveStamp extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsLiveStamp $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsLiveStamp $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsLiveStamp $(String selector);

    @JsMethod
    public native JsMasonry livestamp(Object currentMillis);
}
