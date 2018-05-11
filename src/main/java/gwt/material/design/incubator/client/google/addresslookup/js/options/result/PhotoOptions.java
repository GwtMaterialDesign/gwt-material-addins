package gwt.material.design.incubator.client.google.addresslookup.js.options.result;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines photo-requesting options.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PhotoOptions {

    @JsProperty
    private int maxHeight;

    @JsProperty
    private int maxWidth;

    @JsOverlay
    public final int getMaxHeight() {
        return maxHeight;
    }

    /**
     * The maximum height in pixels of the returned image.
     */
    @JsOverlay
    public final void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @JsOverlay
    public final int getMaxWidth() {
        return maxWidth;
    }

    /**
     * The maximum width in pixels of the returned image.
     */
    @JsOverlay
    public final void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }
}
