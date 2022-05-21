package gwt.material.design.addins.client.fileuploader.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ResizeInfo {

    @JsProperty
    public int srcX;

    @JsProperty
    public int srcY;

    @JsProperty
    public int trgX;

    @JsProperty
    public int trgY;

    @JsProperty
    public int srcWidth;

    @JsProperty
    public int srcHeight;

    @JsProperty
    public int trgWidth;

    @JsProperty
    public int trgHeight;
}
