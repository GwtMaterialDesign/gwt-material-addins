package gwt.material.design.addins.client.cropper.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Dimensions for Image Cropper
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCropperDimension {

    @JsProperty
    public int width;

    @JsProperty
    public int height;

    @JsProperty
    public String type;
}
