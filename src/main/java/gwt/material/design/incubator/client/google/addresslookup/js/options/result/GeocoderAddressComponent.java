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
