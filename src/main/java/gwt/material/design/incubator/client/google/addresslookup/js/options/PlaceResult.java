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

import gwt.material.design.incubator.client.google.addresslookup.js.options.result.*;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines information about a Place.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlaceResult {

    @JsProperty
    private GeocoderAddressComponent[] address_components;

    @JsProperty
    private PlaceAspectRating[] aspects;

    @JsProperty
    private String formatted_address;

    @JsProperty
    private String formatted_phone_number;

    @JsProperty
    private PlaceGeometry geometry;

    @JsProperty
    private String[] html_attributions;

    @JsProperty
    private String icon;

    @JsProperty
    private String international_phone_number;

    @JsProperty
    private String name;

    @JsProperty
    private boolean permanently_closed;

    @JsProperty
    private PlacePhoto photos;

    @JsProperty
    private String place_id;

    @JsProperty
    private int price_level;

    @JsProperty
    private double rating;

    @JsProperty
    private PlaceReview[] reviews;

    @JsProperty
    private String[] types;

    @JsProperty
    private String url;

    @JsProperty
    private int utc_offset;

    @JsProperty
    private String vicinity;

    @JsProperty
    private String website;

    @JsOverlay
    public final GeocoderAddressComponent[] getAddressComponents() {
        return address_components;
    }

    /**
     * The collection of address components for this Place's location.
     */
    @JsOverlay
    public final void setAddressComponents(GeocoderAddressComponent[] addressComponents) {
        this.address_components = address_components;
    }

    @JsOverlay
    public final PlaceAspectRating[] getAspects() {
        return aspects;
    }

    /**
     * The rated aspects of this Place, based on Google and Zagat user reviews. The ratings are on a scale of 0 to 30.
     */
    @JsOverlay
    public final void setAspects(PlaceAspectRating[] aspects) {
        this.aspects = aspects;
    }

    @JsOverlay
    public final String getFormattedAddress() {
        return formatted_address;
    }

    /**
     * The Place's full address.
     */
    @JsOverlay
    public final void setFormattedAddress(String formattedAddress) {
        this.formatted_address = formattedAddress;
    }

    @JsOverlay
    public final String getFormattedPhoneNumber() {
        return formatted_phone_number;
    }

    /**
     * The Place's phone number, formatted according to the <a href="http://en.wikipedia.org/wiki/Local_conventions_for_writing_telephone_numbers">
     * number's regional convention.</a>
     */
    @JsOverlay
    public final void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formatted_phone_number = formattedPhoneNumber;
    }

    @JsOverlay
    public final PlaceGeometry getGeometry() {
        return geometry;
    }

    /**
     * The Place's geometry-related information.
     */
    @JsOverlay
    public final void setGeometry(PlaceGeometry geometry) {
        this.geometry = geometry;
    }

    @JsOverlay
    public final String[] getHtmlAttributions() {
        return html_attributions;
    }

    /**
     * Attribution text to be displayed for this Place result.
     */
    @JsOverlay
    public final void setHtmlAttributions(String[] htmlAttributions) {
        this.html_attributions = htmlAttributions;
    }

    @JsOverlay
    public final String getIcon() {
        return icon;
    }

    /**
     * URL to an image resource that can be used to represent this Place's category.
     */
    @JsOverlay
    public final void setIcon(String icon) {
        this.icon = icon;
    }

    @JsOverlay
    public final String getInternationalPhoneNumber() {
        return international_phone_number;
    }

    /**
     * The Place's phone number in international format. International format includes the country code, and is
     * prefixed with the plus (+) sign.
     */
    @JsOverlay
    public final void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.international_phone_number = internationalPhoneNumber;
    }

    @JsOverlay
    public final String getName() {
        return name;
    }

    /**
     * The Place's name. Note: In the case of user entered Places, this is the raw text, as typed by the user. Please
     * exercise caution when using this data, as malicious users may try to use it as a vector for code injection
     * attacks (See http://en.wikipedia.org/wiki/Code_injection).
     */
    @JsOverlay
    public final void setName(String name) {
        this.name = name;
    }

    @JsOverlay
    public final boolean isPermanentlyClosed() {
        return permanently_closed;
    }

    /**
     * A flag indicating whether the Place is permanently closed. If the place is not permanently closed, the flag is
     * not present in search or details responses.
     */
    @JsOverlay
    public final void setPermanentlyClosed(boolean permanentlyClosed) {
        this.permanently_closed = permanentlyClosed;
    }

    @JsOverlay
    public final PlacePhoto getPhotos() {
        return photos;
    }

    /**
     * Photos of this Place. The collection will contain up to ten PlacePhoto objects.
     */
    @JsOverlay
    public final void setPhotos(PlacePhoto photos) {
        this.photos = photos;
    }

    @JsOverlay
    public final String getPlaceId() {
        return place_id;
    }

    /**
     * A unique identifier for a place.
     */
    @JsOverlay
    public final void setPlaceId(String placeId) {
        this.place_id = placeId;
    }

    @JsOverlay
    public final int getPriceLevel() {
        return price_level;
    }

    /**
     * The price level of the Place, on a scale of 0 to 4. Price levels are interpreted as follows:
     * <ol>
     * <li>Free</li>
     * <li>Inexpensive</li>
     * <li>Moderate</li>
     * <li>Expensive</li>
     * <li>Very Expensive</li>
     * </ol>
     */
    @JsOverlay
    public final void setPriceLevel(int priceLevel) {
        this.price_level = priceLevel;
    }

    @JsOverlay
    public final double getRating() {
        return rating;
    }

    /**
     * A rating, between 1.0 to 5.0, based on user reviews of this Place.
     */
    @JsOverlay
    public final void setRating(double rating) {
        this.rating = rating;
    }

    @JsOverlay
    public final PlaceReview[] getReviews() {
        return reviews;
    }

    /**
     * A list of reviews of this Place.
     */
    @JsOverlay
    public final void setReviews(PlaceReview[] reviews) {
        this.reviews = reviews;
    }

    @JsOverlay
    public final String[] getTypes() {
        return types;
    }

    /**
     * An array of types for this Place (e.g., ["political", "locality"] or ["restaurant", "establishment"]).
     */
    @JsOverlay
    public final void setTypes(String[] types) {
        this.types = types;
    }

    @JsOverlay
    public final String getUrl() {
        return url;
    }

    /**
     * URL of the official Google page for this place. This is the Google-owned page that contains the best available
     * information about the place.
     */
    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    @JsOverlay
    public final int getUtcOffset() {
        return utc_offset;
    }

    /**
     * The offset from UTC of the Place's current timezone, in minutes. For example, Sydney, Australia in daylight
     * savings is 11 hours ahead of UTC, so the utc_offset will be 660. For timezones behind UTC, the offset is negative.
     * For example, utc_offest is -60 for Cape Verde.
     */
    @JsOverlay
    public final void setUtcOffset(int utcOffset) {
        this.utc_offset = utcOffset;
    }

    @JsOverlay
    public final String getVicinity() {
        return vicinity;
    }

    /**
     * A fragment of the Place's address for disambiguation (usually street name and locality).
     */
    @JsOverlay
    public final void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    @JsOverlay
    public final String getWebsite() {
        return website;
    }

    /**
     * The authoritative website for this Place, such as a business' homepage.
     */
    @JsOverlay
    public final void setWebsite(String website) {
        this.website = website;
    }
}
