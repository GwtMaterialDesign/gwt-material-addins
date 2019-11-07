package gwt.material.design.incubator.client.password.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PasswordStrengthProgress {

    @JsProperty
    private String width;

    @JsProperty
    private String height;

    @JsProperty
    private PasswordStrengthProgressColor color;

    @JsOverlay
    public final String getWidth() {
        return width;
    }

    @JsOverlay
    public final void setWidth(String width) {
        this.width = width;
    }

    @JsOverlay
    public final String getHeight() {
        return height;
    }

    @JsOverlay
    public final void setHeight(String height) {
        this.height = height;
    }

    @JsOverlay
    public final PasswordStrengthProgressColor getColor() {
        return color;
    }

    @JsOverlay
    public final void setColor(PasswordStrengthProgressColor color) {
        this.color = color;
    }
}
