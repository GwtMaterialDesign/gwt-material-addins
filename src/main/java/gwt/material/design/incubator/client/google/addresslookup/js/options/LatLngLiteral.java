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
 * Object literals are accepted in place of LatLng objects, as a convenience, in many places. These are converted to
 * LatLng objects when the Maps API encounters them.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LatLngLiteral {

    @JsProperty
    private Double lat;

    @JsProperty
    private Double lng;

    @JsOverlay
    public final Double getLatitude() {
        return lat;
    }

    /**
     * Latitude in degrees. Values will be clamped to the range [-90, 90]. This means that if the value specified is
     * less than -90, it will be set to -90. And if the value is greater than 90, it will be set to 90.
     */
    @JsOverlay
    public final void setLatitude(Double lat) {
        this.lat = lat;
    }

    @JsOverlay
    public final Double getLongitude() {
        return lng;
    }

    /**
     * Longitude in degrees. Values outside the range [-180, 180] will be wrapped so that they fall within the range.
     * For example, a value of -190 will be converted to 170. A value of 190 will be converted to -170. This reflects
     * the fact that longitudes wrap around the globe.
     */
    @JsOverlay
    public final void setLongitude(Double lng) {
        this.lng = lng;
    }
}
