package gwt.material.design.addins.client.carousel.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsResponsiveOptions {


    @JsProperty
    public int breakpoint;

    @JsProperty
    public JsCarouselOptions settings;
}
