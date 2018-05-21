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
package gwt.material.design.incubator.client.google.addresslookup;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.incubator.client.google.addresslookup.constants.AddressComponentType;
import gwt.material.design.incubator.client.google.addresslookup.constants.AddressType;
import gwt.material.design.incubator.client.google.addresslookup.events.AddressLookupEvents;
import gwt.material.design.incubator.client.google.addresslookup.events.HasAddressLookupHandlers;
import gwt.material.design.incubator.client.google.addresslookup.events.PlaceChangedEvent;
import gwt.material.design.incubator.client.google.addresslookup.js.JsAddressLookup;
import gwt.material.design.incubator.client.google.addresslookup.js.options.AddressLookupOptions;
import gwt.material.design.incubator.client.google.addresslookup.js.options.ComponentRestrictions;
import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLngBounds;
import gwt.material.design.incubator.client.google.addresslookup.js.options.PlaceResult;
import gwt.material.design.incubator.client.google.addresslookup.js.options.result.GeocoderAddressComponent;

/**
 * A service to provide Place predictions based on a user's text input. It attaches to an input element of type text,
 * and listens for text entry in that field. The list of predictions is presented as a drop-down list, and is updated
 * as text is entered.
 *
 * @author kevzlou7979
 * @see <a href="https://developers.google.com/maps/documentation/javascript/reference/3/#Autocomplete">AddressLookup</a>
 */
public class AddressLookup extends MaterialTextBox implements HasAddressLookupHandlers {

    private String apiKey;
    private JsAddressLookup addressLookup;
    private AddressLookupOptions options;
    private boolean isApiLoaded;

    public AddressLookup() {
        setPlaceholder("");
    }

    /**
     * Creates a new instance of AddressLookup that attaches to the specified input text field with the given options.
     */
    public AddressLookup(AddressLookupOptions options) {
        this();

        setOptions(options);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    protected void load() {
        if (!isApiLoaded) {
            ScriptInjector.fromUrl("https://maps.googleapis.com/maps/api/js?key=" + apiKey + "&libraries=places")
                    .setWindow(ScriptInjector.TOP_WINDOW)
                    .setCallback(new Callback<Void, Exception>() {
                        @Override
                        public void onFailure(Exception e) {
                            GWT.log(e.getMessage(), e);
                        }

                        @Override
                        public void onSuccess(Void aVoid) {
                            addressLookup = new JsAddressLookup(valueBoxBase.getElement(), options);
                            addressLookup.addListener(AddressLookupEvents.PLACE_CHANGED, () -> PlaceChangedEvent.fire(AddressLookup.this));
                        }
                    }).inject();
            isApiLoaded = true;
        }
    }

    /**
     * Sets the GCP Place Api Key
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the GCP Place API Key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Gets the option for look up widget
     */
    public AddressLookupOptions getOptions() {
        return options;
    }

    /**
     * Sets the option for look up widget
     */
    public void setOptions(AddressLookupOptions options) {
        this.options = options;
    }

    /**
     * Returns the bounds to which predictions are biased.
     */
    public LatLngBounds getBounds() {
        return addressLookup.getBounds();
    }

    /**
     * Returns the details of the Place selected by user if the details were successfully retrieved. Otherwise returns
     * a stub Place object, with the name property set to the current value of the input field.
     */
    public PlaceResult getPlace() {
        return addressLookup.getPlace();
    }

    /**
     * Sets the preferred area within which to return Place results. Results are biased towards, but not restricted to,
     * this area.
     */
    public void setBounds(LatLngBounds bounds) {
        addressLookup.setBounds(bounds);
    }

    /**
     * Sets the component restrictions. Component restrictions are used to restrict predictions to only those within
     * the parent component. E.g., the country.
     */
    public void setComponentRestrictions(ComponentRestrictions restrictions) {
        addressLookup.setComponentRestrictions(restrictions);
    }

    /**
     * Sets the types of predictions to be returned. For a list of supported types, see the
     * <a href="https://developers.google.com/places/supported_types#table3">developer's guide</a>. If no
     * type is specified, all types will be returned. The setTypes method accepts a single element array.
     */
    public void setTypes(AddressType... types) {
        addressLookup.setTypes(types);
    }

    /**
     * Will identify the {@link GeocoderAddressComponent} and will return it's value based on {@link AddressComponentType}
     */
    public GeocoderAddressComponent getAddressComponent(AddressComponentType addressComponentType) {
        for (GeocoderAddressComponent component : getPlace().getAddressComponents()) {
            for (String type : component.getTypes()) {
                if (addressComponentType.getName().equals(type)) {
                    return component;
                }
            }
        }
        return null;
    }

    /**
     * Will check if the Google Place API has been loaded
     */
    public boolean isApiLoaded() {
        return isApiLoaded;
    }

    @Override
    public HandlerRegistration addPlaceChangedHandler(PlaceChangedEvent.PlaceChangedHandler handler) {
        return addHandler(handler, PlaceChangedEvent.getType());
    }
}