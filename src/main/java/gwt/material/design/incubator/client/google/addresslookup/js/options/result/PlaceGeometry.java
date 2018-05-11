package gwt.material.design.incubator.client.google.addresslookup.js.options.result;

import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLng;
import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLngBounds;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines information about the geometry of a Place.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlaceGeometry {

    @JsProperty
    private LatLng location;

    @JsProperty
    private LatLngBounds viewport;

    /**
     * The Place's position.
     */
    @JsOverlay
    public final LatLng getLocation() {
        return location;
    }

    /**
     * The preferred viewport when displaying this Place on a map. This property will be null if the preferred viewport
     * for the Place is not known.
     */
    @JsOverlay
    public final LatLngBounds getViewport() {
        return viewport;
    }
}
