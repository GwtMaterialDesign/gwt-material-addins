package gwt.material.design.incubator.client.google.addresslookup.js.options;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GeoLatLng {

    @JsProperty
    public double lat;

    @JsProperty
    public double lng;

    @JsOverlay
    public final double getLat() {
        return lat;
    }

    @JsOverlay
    public final void setLat(double lat) {
        this.lat = lat;
    }

    @JsOverlay
    public final double getLng() {
        return lng;
    }

    @JsOverlay
    public final void setLng(double lng) {
        this.lng = lng;
    }
}
