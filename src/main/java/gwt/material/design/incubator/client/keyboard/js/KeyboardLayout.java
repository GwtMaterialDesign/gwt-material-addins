package gwt.material.design.incubator.client.keyboard.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KeyboardLayout {

    @JsProperty(name = "default")
    public String[] defaultLayout;

    @JsProperty(name = "shift")
    public String[] shiftLayout;

    @JsOverlay
    public final String[] getDefaultLayout() {
        return defaultLayout;
    }
}
