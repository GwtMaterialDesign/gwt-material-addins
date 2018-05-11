package gwt.material.design.incubator.client.google.addresslookup.js.options;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Object literals are accepted in place of LatLngBounds objects throughout the API. These are automatically converted
 * to LatLngBounds objects. All south, west, north and east must be set, otherwise an exception is thrown.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LatLngBoundsLiteral {

    @JsProperty
    public Double east;

    @JsProperty
    public Double north;

    @JsProperty
    public Double south;

    /**
     * West longitude in degrees. Values outside the range [-180, 180] will be wrapped to the range [-180, 180).
     * For example, a value of -190 will be converted to 170. A value of 190 will be converted to -170. This reflects
     * the fact that longitudes wrap around the globe.
     */
    @JsProperty
    public Double west;

    @JsOverlay
    public final Double getEast() {
        return east;
    }

    @JsOverlay
    public final void setEast(Double east) {
        this.east = east;
    }

    @JsOverlay
    public final Double getNorth() {
        return north;
    }

    /**
     * North latitude in degrees. Values will be clamped to the range [-90, 90]. This means that if the value specified
     * is less than -90, it will be set to -90. And if the value is greater than 90, it will be set to 90.
     */
    @JsOverlay
    public final void setNorth(Double north) {
        this.north = north;
    }

    @JsOverlay
    public final Double getSouth() {
        return south;
    }

    /**
     * South latitude in degrees. Values will be clamped to the range [-90, 90]. This means that if the value specified
     * is less than -90, it will be set to -90. And if the value is greater than 90, it will be set to 90.
     */
    @JsOverlay
    public final void setSouth(Double south) {
        this.south = south;
    }

    @JsOverlay
    public final Double getWest() {
        return west;
    }

    /**
     * East longitude in degrees. Values outside the range [-180, 180] will be wrapped to the range [-180, 180).
     * For example, a value of -190 will be converted to 170. A value of 190 will be converted to -170. This reflects
     * the fact that longitudes wrap around the globe.
     */
    @JsOverlay
    public final void setWest(Double west) {
        this.west = west;
    }
}
