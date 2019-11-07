package gwt.material.design.incubator.client.password.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PasswordStrengthOptions {

    @JsProperty
    private int limit;

    @JsProperty
    private boolean showSuggestions;

    @JsProperty
    private PasswordStrengthLabel label;

    @JsProperty
    private PasswordStrengthProgress progress;

    @JsOverlay
    public final int getLimit() {
        return limit;
    }

    @JsOverlay
    public final void setLimit(int limit) {
        this.limit = limit;
    }

    @JsOverlay
    public final boolean isShowSuggestions() {
        return showSuggestions;
    }

    @JsOverlay
    public final void setShowSuggestions(boolean showSuggestions) {
        this.showSuggestions = showSuggestions;
    }

    @JsOverlay
    public final PasswordStrengthLabel getLabel() {
        return label;
    }

    @JsOverlay
    public final void setLabel(PasswordStrengthLabel label) {
        this.label = label;
    }

    @JsOverlay
    public final PasswordStrengthProgress getProgress() {
        return progress;
    }

    @JsOverlay
    public final void setProgress(PasswordStrengthProgress progress) {
        this.progress = progress;
    }
}
