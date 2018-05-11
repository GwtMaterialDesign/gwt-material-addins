package gwt.material.design.incubator.client.google.addresslookup.js.options;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Object literals are accepted in place of LatLng objects, as a convenience, in many places. These are converted to
 * LatLng objects when the Maps API encounters them.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LatLngLiteral {

    @JsProperty
    private Double lat;

    @JsProperty
    private Double lng;

    @JsOverlay
    public final Double getLatitude() {
        return lat;
    }

    /**
     * Latitude in degrees. Values will be clamped to the range [-90, 90]. This means that if the value specified is
     * less than -90, it will be set to -90. And if the value is greater than 90, it will be set to 90.
     */
    @JsOverlay
    public final void setLatitude(Double lat) {
        this.lat = lat;
    }

    @JsOverlay
    public final Double getLongitude() {
        return lng;
    }

    /**
     * Longitude in degrees. Values outside the range [-180, 180] will be wrapped so that they fall within the range.
     * For example, a value of -190 will be converted to 170. A value of 190 will be converted to -170. This reflects
     * the fact that longitudes wrap around the globe.
     */
    @JsOverlay
    public final void setLongitude(Double lng) {
        this.lng = lng;
    }
}
