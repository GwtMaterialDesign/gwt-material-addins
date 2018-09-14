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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * A LatLng is a point in geographical coordinates: latitude and longitude.
 * <p>
 * <ul>
 * <li>Latitude ranges between -90 and 90 degrees, inclusive. Values above or below this range will be clamped to the
 * range [-90, 90]. This means that if the value specified is less than -90, it will be set to -90. And if the value
 * is greater than 90, it will be set to 90.</li>
 * <p>
 * <li>Longitude ranges between -180 and 180 degrees, inclusive. Values above or below this range will be wrapped so
 * that they fall within the range. For example, a value of -190 will be converted to 170. A value of 190 will be
 * converted to -170. This reflects the fact that longitudes wrap around the globe.</li>
 * </ul>
 * <p>
 * Although the default map projection associates longitude with the x-coordinate of the map, and latitude with the
 * y-coordinate, the latitude coordinate is always written first, followed by the longitude.
 * Notice that you cannot modify the coordinates of a LatLng. If you want to compute another point, you have to create
 * a new one.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LatLng {

    public LatLng(double lattitude, double longitude) {
    }

    /**
     * Comparison function.
     */
    @JsMethod
    public native Boolean equals(LatLng other);

    /**
     * Returns the latitude in degrees.
     */
    @JsMethod
    public native Double lat();

    /**
     * Returns the longitude in degrees.
     */
    @JsMethod
    public native Double lng();

    /**
     * Converts to JSON representation. This function is intended to be used via JSON.stringify.
     */
    @JsMethod
    public native LatLngLiteral toJSON();

    /**
     * Converts to string representation.
     */
    @JsMethod
    public native String toString();

    /**
     * Returns a string of the form "lat,lng" for this LatLng. We round the lat/lng values to 6 decimal places by
     * default.
     */
    @JsMethod
    public native String toUrlValue(int precision);
}
