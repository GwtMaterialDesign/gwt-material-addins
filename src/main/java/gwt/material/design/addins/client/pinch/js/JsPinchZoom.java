package gwt.material.design.addins.client.pinch.js;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "PinchZoom", namespace = JsPackage.GLOBAL)
public class JsPinchZoom {

    @JsConstructor
    public JsPinchZoom(Object element, JsPinchOptions options) {

    }

    /**
     * Enables all gesture capturing (is enabled by default)
     */
    @JsMethod
    public native void enable();

    /**
     * Disables all gesture capturing
     */
    @JsMethod
    public native void disable();
}
