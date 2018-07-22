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
package gwt.material.design.incubator.client.google.addresslookup.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.incubator.client.google.addresslookup.constants.AddressType;
import gwt.material.design.incubator.client.google.addresslookup.js.options.AddressLookupOptions;
import gwt.material.design.incubator.client.google.addresslookup.js.options.ComponentRestrictions;
import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLngBounds;
import gwt.material.design.incubator.client.google.addresslookup.js.options.PlaceResult;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsType;

/**
 * JsInterop util for {@link gwt.material.design.incubator.client.google.addresslookup.AddressLookup}
 *
 * @author kevzlou7979
 * @see <a href="https://developers.google.com/maps/documentation/javascript/reference/3/#Autocomplete">AddressLookup</a>
 */
@JsType(isNative = true, namespace = "google.maps.places", name = "Autocomplete")
public class JsAddressLookup extends MvcObject {

    public JsAddressLookup(Element inputElement, AddressLookupOptions options) {
    }

    @JsMethod
    public native void addListener(String name, Functions.Func function);

    @JsMethod
    public native LatLngBounds getBounds();

    @JsMethod
    public native PlaceResult getPlace();

    @JsMethod
    public native void setBounds(LatLngBounds bounds);

    @JsMethod
    public native void setComponentRestrictions(ComponentRestrictions restrictions);

    @JsMethod
    public native void setOptions(AddressLookupOptions options);

    @JsMethod
    public native void setTypes(String... types);

    @JsOverlay
    public final void setTypes(AddressType... types) {
        String[] stringTypes = new String[]{};
        for (int i = 0; i < types.length; i++) {
            stringTypes[i] = types[i].getName();
        }
        setTypes(stringTypes);
    }
}
