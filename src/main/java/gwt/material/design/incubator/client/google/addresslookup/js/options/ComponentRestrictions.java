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
