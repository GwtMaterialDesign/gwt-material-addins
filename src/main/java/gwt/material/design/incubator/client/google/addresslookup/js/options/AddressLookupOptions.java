/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.google.addresslookup.js.options;

import gwt.material.design.incubator.client.google.addresslookup.constants.AddressType;
import gwt.material.design.incubator.client.google.addresslookup.js.JsAddressLookup;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The options that can be set on an {@link JsAddressLookup} object.
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AddressLookupOptions {

    private AddressLookupOptions() {}

    @JsOverlay
    public static final AddressLookupOptions create() {
        AddressLookupOptions options = new AddressLookupOptions();
        options.setTypes(AddressType.GEOCODE);
        return options;
    }

    @JsProperty
    private LatLngBounds bounds;

    @JsProperty
    private ComponentRestrictions componentRestrictions;

    @JsProperty
    private boolean placeIdOnly;

    @JsProperty
    private boolean strictBounds;

    @JsProperty
    private String[] types;


    @JsOverlay
    public final LatLngBounds getBounds() {
        return bounds;
    }

    /**
     * The area in which to search for places.
     */
    @JsOverlay
    public final void setBounds(LatLngBounds bounds) {
        this.bounds = bounds;
    }

    @JsOverlay
    public final ComponentRestrictions getComponentRestrictions() {
        return componentRestrictions;
    }

    /**
     * The component restrictions. Component restrictions are used to restrict predictions to only those within the
     * parent component. E.g., the country.
     */
    @JsOverlay
    public final void setComponentRestrictions(ComponentRestrictions componentRestrictions) {
        this.componentRestrictions = componentRestrictions;
    }

    @JsOverlay
    public final boolean isPlaceIdOnly() {
        return placeIdOnly;
    }

    /**
     * Whether to retrieve only Place IDs. The PlaceResult made available when the place_changed event is fired will
     * only have the place_id, types and name fields, with the place_id, types and description returned by the
     * AddressLookup service. Disabled by default.
     */
    @JsOverlay
    public final void setPlaceIdOnly(boolean placeIdOnly) {
        this.placeIdOnly = placeIdOnly;
    }

    @JsOverlay
    public final boolean isStrictBounds() {
        return strictBounds;
    }

    /**
     * A boolean value, indicating that the AddressLookup widget should only return those places that are inside the
     * bounds of the AddressLookup widget at the time the query is sent. Setting strictBounds to false (which is the
     * default) will make the results biased towards, but not restricted to, places contained within the bounds.
     */
    @JsOverlay
    public final void setStrictBounds(boolean strictBounds) {
        this.strictBounds = strictBounds;
    }

    @JsOverlay
    public final String[] getTypes() {
        return types;
    }

    @JsOverlay
    private final void setTypes(String... types) {
        this.types = types;
    }

    /**
     * The types of predictions to be returned. For a list of supported types, see the developer's guide. If nothing is
     * specified, all types are returned. In general only a single type is allowed. The exception is that you can safely
     * mix the 'geocode' and 'establishment' types, but note that this will have the same effect as specifying no types.
     */
    @JsOverlay
    public final void setTypes(AddressType... types) {
        String[] stringTypes = new String[]{};
        for (int i = 0; i < types.length; i++) {
            stringTypes[i] = types[i].getName();
        }
        setTypes(stringTypes);
    }
}
