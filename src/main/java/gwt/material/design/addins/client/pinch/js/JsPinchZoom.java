package gwt.material.design.addins.client.pinch.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

@JsType(isNative = true, name = "PinchZoom", namespace = JsPackage.GLOBAL)
public class JsPinchZoom {

    @JsConstructor
    public JsPinchZoom(Object element) {

    }

    @JsProperty
    public Integer tapZoomFactor;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onZoomStart;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onZoomEnd;

    @JsProperty
    public Functions.Func2<JsPinchZoom, Object> onDoubleTap;

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
