package gwt.material.design.incubator.client.viewer.js;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Viewer", namespace = JsPackage.GLOBAL)
public class JsImageViewer {

    @JsConstructor
    public JsImageViewer(Object element, ViewerOptions options) {

    }

    @JsMethod
    public native void destroy();

    @JsMethod
    public native void update();
}
