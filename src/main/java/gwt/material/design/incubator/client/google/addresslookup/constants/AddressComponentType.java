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
 * The types[] array in the result indicates the address type. Examples of address types include a street address, a
 * country, or a political entity. There is also a types[] array in the address_components[], indicating the type of
 * each part of the address. Examples include street number or country. (Below is a full list of types.) Addresses may
 * have multiple types. The types may be considered 'tags'. For example, many cities are tagged with the political and
 * the locality type.
 *
 * @author kevzlou7979
 */
public enum AddressComponentType implements CssType {

    NONE(""),
    /**
     * indicates a precise street address.
     */
    STREET_ADDRESS("street_address"),
    /**
     * indicates a named route (such as "US 101").
     */
    ROUTE("route"),
    /**
     * indicates a major intersection, usually of two major roads.
     */
    INTERSECTION("intersection"),
    /**
     * indicates a political entity. Usually, this type indicates a polygon of some civil administration.
     */
    POLITICAL("political"),
    /**
     * indicates the national political entity, and is typically the highest order type returned by the Geocoder.
     */
    COUNTRY("country"),
    /**
     * indicates a first-order civil entity below the country level. Within the United States, these administrative
     * levels are states. Not all nations exhibit these administrative levels. In most cases, administrative_area_level_1
     * short names will closely match ISO 3166-2 subdivisions and other widely circulated lists; however this is not
     * guaranteed as our geocoding results are based on a variety of signals and location data.
     */
    ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),
    /**
     * indicates a second-order civil entity below the country level. Within the United States, these administrative
     * levels are counties. Not all nations exhibit these administrative levels.
     */
    ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),
    /**
     * indicates a third-order civil entity below the country level. This type indicates a minor civil division. Not
     * all nations exhibit these administrative levels.
     */
    ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),
    /**
     * indicates a fourth-order civil entity below the country level. This type indicates a minor civil division. Not
     * all nations exhibit these administrative levels.
     */
    ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),
    /**
     * indicates a fifth-order civil entity below the country level. This type indicates a minor civil division. Not
     * all nations exhibit these administrative levels.
     */
    ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),
    /**
     * indicates a commonly-used alternative name for the entity.
     */
    COLLOQUIAL_AREA("colloquial_area"),
    /**
     * indicates an incorporated city or town political entity.
     */
    LOCALITY("locality"),
    /**
     * indicates a specific type of Japanese locality, to facilitate distinction between multiple locality components
     * within a Japanese address.
     */
    WARD("ward"),
    /**
     * indicates a first-order civil entity below a locality. For some locations may receive one of the additional types:
     * sublocality_level_1 to sublocality_level_5. Each sublocality level is a civil entity. Larger numbers indicate a
     * smaller geographic area.
     */
    SUBLOCALITY("sublocality"),
    /**
     * indicates a named neighborhood
     */
    NEIGHBORHOOD("neighborhood"),
    /**
     * indicates a named location, usually a building or collection of buildings with a common name
     */
    PREMISE("premise"),
    /**
     * indicates a first-order entity below a named location, usually a singular building within a collection of buildings
     * with a common name
     */
    SUBPREMISE("subpremise"),
    /**
     * indicates a postal code as used to address postal mail within the country.
     */
    POSTAL_CODE("postal_code"),
    /**
     * indicates a prominent natural feature.
     */
    NATURAL_FEATURE("natural_feature"),
    /**
     * indicates an airport.
     */
    AIRPORT("airport"),
    /**
     * indicates a named park.
     */
    PARK("park"),
    /**
     * indicates a named point of interest. Typically, these "POI"s are prominent local entities that don't easily fit
     * in another category, such as "Empire State Building" or "Statue of Liberty."
     */
    POINT_OF_INTEREST("point_of_interest"),
    /**
     * indicates the floor of a building address.
     */
    FLOOR("floor"),
    /**
     * typically indicates a place that has not yet been categorized.
     */
    ESTABLISHMENT("establishment"),
    /**
     * indicates a parking lot or parking structure.
     */
    PARKING("parking"),
    /**
     * indicates a specific postal box.
     */
    POST_BOX("post_box"),
    /**
     * indicates a grouping of geographic areas, such as locality and sublocality, used for mailing addresses in some
     * countries.
     */
    POSTAL_TOWN("postal_town"),
    /**
     * indicates the room of a building address.
     */
    ROOM("room"),
    /**
     * indicates the precise street number.
     */
    STREET_NUMBER("street_number"),
    /**
     * indicate the location of a bus
     */
    BUS_STATION("bus_station"),
    /**
     * indicate the location of a bus train.
     */
    TRAIN_STATION("train_station"),
    /**
     * indicate the location of a public transit stop
     */
    TRANSIT_STATION("transit_station");

    private final String name;

    AddressComponentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCssName() {
        return getName();
    }

    public static AddressComponentType asEnum(final String name) {
        return EnumHelper.fromStyleName(name, AddressComponentType.class, NONE);
    }
}