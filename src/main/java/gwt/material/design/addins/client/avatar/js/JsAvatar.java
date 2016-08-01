package gwt.material.design.addins.client.avatar.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Avatar component
 */
@JsType(isNative = true, name = JsPackage.GLOBAL)
public class JsAvatar extends JQueryElement {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native void jdenticon();

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native String md5(String value);

}
