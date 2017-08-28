package gwt.material.design.addins.client.image.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCropperOptions {

    @JsProperty
    public JsViewPort boundary;

    @JsProperty
    public JsViewPort viewport;

    @JsProperty
    public boolean enableOrientation;

    @JsProperty
    public boolean enableZoom;

    @JsProperty
    public boolean enforceBoundary;

    @JsProperty
    public boolean mouseWheelZoom;

    @JsProperty
    public boolean showZoomer;
}
