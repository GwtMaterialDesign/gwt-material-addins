package gwt.material.design.incubator.client.google.addresslookup.js.options;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines the component restrictions that can be used with the autocomplete service.
 *
 * @author kevzlou7979@gmail.com
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ComponentRestrictions {

    @JsProperty
    private String[] country;

    @JsOverlay
    public final String[] getCountry() {
        return country;
    }

    /**
     * Restricts predictions to the specified country (ISO 3166-1 Alpha-2 country code, case insensitive).
     * E.g., us, br, au. You can provide a single one, or an array of up to 5 country code strings.
     */
    @JsOverlay
    public final void setCountry(String... country) {
        this.country = country;
    }
}
