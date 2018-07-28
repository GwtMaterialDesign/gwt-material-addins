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
package gwt.material.design.incubator.client.google.addresslookup.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * The types of predictions to be returned. For a list of supported types, see the developer's guide. If nothing is
 * specified, all types are returned. In general only a single type is allowed. The exception is that you can safely
 * mix the 'geocode' and 'establishment' types, but note that this will have the same effect as specifying no types.
 *
 * Used by {@link gwt.material.design.incubator.client.google.addresslookup.AddressLookup#setTypes(AddressType...)} and
 * {@link gwt.material.design.incubator.client.google.addresslookup.js.options.AddressLookupOptions#setTypes(AddressType...)}
 *
 * @author kevzlou7979
 * @see <a href="https://developers.google.com/places/supported_types#table3">GeocoderAddress Type</a>
 */
public enum AddressType implements CssType {

    /**
     * instructs the Place Autocomplete service to return only geocoding results, rather than business results.
     * Generally, you use this request to disambiguate results where the location specified may be indeterminate.
     */
    GEOCODE("geocode"),
    /**
     * instructs the Place Autocomplete service to return only geocoding results with a precise address. Generally,
     * you use this request when you know the user will be looking for a fully specified address.
     */
    ADDRESS("address"),
    /**
     * instructs the Place Autocomplete service to return only business results.
     */
    ESTABLISHMENT("establishment"),
    /**
     * type collection instructs the Places service to return any result matching the following types:
     * <ul>
     * <li>locality</li>
     * <li>sublocality</li>
     * <li>postal_code</li>
     * <li>country</li>
     * <li>administrative_area_level_1</li>
     * <li>administrative_area_level_2</li>
     * </ul>
     */
    REGIONS("locality"),
    /**
     * type collection instructs the Places service to return results that match locality or administrative_area_level_3.
     */
    CITIES("cities");

    private final String name;

    AddressType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCssName() {
        return getName();
    }

    public static AddressType asEnum(final String name) {
        return EnumHelper.fromStyleName(name, AddressType.class, GEOCODE);
    }
}
