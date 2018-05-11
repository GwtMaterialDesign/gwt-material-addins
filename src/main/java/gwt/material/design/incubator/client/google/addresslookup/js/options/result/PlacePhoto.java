package gwt.material.design.incubator.client.google.addresslookup.js.options.result;

import jsinterop.annotations.*;

/**
 * Represents a photo element of a Place.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlacePhoto {

    /**
     * Returns the image URL corresponding to the specified options. You must include a PhotoOptions object with at
     * least one of maxWidth or maxHeight specified.
     */
    @JsMethod
    public native void getUrl(PhotoOptions options);

    @JsProperty
    private double height;

    @JsProperty
    private String[] html_attributions;

    @JsProperty
    private int width;

    /**
     * The height of the photo in pixels.
     */
    @JsOverlay
    public final double getHeight() {
        return height;
    }

    @JsOverlay
    public final void setHeight(double height) {
        this.height = height;
    }

    /**
     * Attribution text to be displayed for this photo.
     */
    @JsOverlay
    public final String[] getHtmlAttributions() {
        return html_attributions;
    }

    @JsOverlay
    public final void setHtmlAttributions(String[] htmlAttributions) {
        this.html_attributions = htmlAttributions;
    }

    /**
     * The width of the photo in pixels.
     */
    @JsOverlay
    public final int getWidth() {
        return width;
    }

    @JsOverlay
    public final void setWidth(int width) {
        this.width = width;
    }
}
