package gwt.material.design.incubator.client.google.addresslookup.js.options.result;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines information about an aspect of the place that users have reviewed.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlaceAspectRating {

    @JsProperty
    private int rating;

    @JsProperty
    private String type;

    /**
     * The rating of this aspect. For individual reviews this is an integer from 0 to 3. For aggregated ratings of a
     * place this is an integer from 0 to 30.
     */
    @JsOverlay
    public final int getRating() {
        return rating;
    }

    /**
     * The aspect type, e.g. "food", "decor", "service", "overall".
     */
    @JsOverlay
    public final String getType() {
        return type;
    }
}
