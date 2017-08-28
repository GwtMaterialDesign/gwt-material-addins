package gwt.material.design.addins.client.image.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsViewPort {

    @JsProperty
    public int width;

    @JsProperty
    public int height;

    @JsProperty
    public String type;
}
