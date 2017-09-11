package gwt.material.design.addins.client.gesture.velocity.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class JsVelocity extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsVelocity $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsVelocity $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsVelocity $(String selector);

    @JsMethod
    public native JsVelocity velocity(JsVelocityOptions velocityOptions, JsTransitionOptions transitionOptions);
}
