package gwt.material.design.incubator.client.password.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PasswordStrengthProgressColor {

    @JsProperty
    private String weak;

    @JsProperty
    private String fair;

    @JsProperty
    private String good;

    @JsProperty
    private String strong;

    @JsOverlay
    public final String getWeak() {
        return weak;
    }

    @JsOverlay
    public final void setWeak(String weak) {
        this.weak = weak;
    }

    @JsOverlay
    public final String getFair() {
        return fair;
    }

    @JsOverlay
    public final void setFair(String fair) {
        this.fair = fair;
    }

    @JsOverlay
    public final String getGood() {
        return good;
    }

    @JsOverlay
    public final void setGood(String good) {
        this.good = good;
    }

    @JsOverlay
    public final String getStrong() {
        return strong;
    }

    @JsOverlay
    public final void setStrong(String strong) {
        this.strong = strong;
    }
}
