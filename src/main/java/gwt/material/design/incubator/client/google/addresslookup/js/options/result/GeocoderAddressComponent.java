package gwt.material.design.incubator.client.google.addresslookup.js.options.result;

import gwt.material.design.client.ui.MaterialToast;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A single address component within a GeocoderResult. A full address may consist of multiple address components.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GeocoderAddressComponent {

    @JsProperty
    private String long_name;

    @JsProperty
    private String short_name;

    @JsProperty
    private String[] types;

    /**
     * The full text of the address component
     */
    @JsOverlay
    public final String getLongName() {
        if (long_name == null) {
            MaterialToast.fireToast("PUTA");
        }
        return long_name;
    }

    /**
     * The abbreviated, short text of the given address component
     */
    @JsOverlay
    public final String getShortName() {
        if (short_name == null) {
            MaterialToast.fireToast("PUTA");
        }
        return short_name;
    }

    /**
     * An array of strings denoting the type of this address component. A list of valid types can be found
     * <a href="https://developers.google.com/maps/documentation/geocoding/#Types">here</a>
     */
    @JsOverlay
    public final String[] getTypes() {
        return types;
    }
}
