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
 * A LatLngBounds instance represents a rectangle in geographical coordinates, including one that crosses the 180
 * degrees longitudinal meridian.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LatLngBounds {

    /**
     * Constructs a rectangle from the points at its south-west and north-east corners.
     */
    public LatLngBounds(LatLng southWest, LatLng northEast) {
    }

    /**
     * Returns true if the given lat/lng is in this bounds.
     */
    @JsMethod
    public native boolean contains(LatLng latLng);

    /**
     * Returns true if this bounds approximately equals the given bounds.
     */
    @JsMethod
    public native boolean equals(LatLngBounds other);

    /**
     * Extends this bounds to contain the given point.
     */
    @JsMethod
    public native LatLngBounds extend(LatLng point);

    /**
     * Computes the center of this LatLngBounds
     */
    @JsMethod
    public native LatLng getCenter();

    /**
     * Returns the north-east corner of this bounds.
     */
    @JsMethod
    public native LatLng getNorthEast();

    /**
     * Returns the south-west corner of this bounds.
     */
    @JsMethod
    public native LatLng getSouthWest();

    /**
     * Returns true if this bounds shares any points with the other bounds.
     */
    @JsMethod
    public native boolean intersects(LatLngBounds bounds);

    /**
     * Returns if the bounds are empty.
     */
    @JsMethod
    public native boolean isEmpty();

    /**
     * Converts to JSON representation. This function is intended to be used via JSON.stringify.
     */
    @JsMethod
    public native LatLngBoundsLiteral toJSON();

    /**
     * Converts the given map bounds to a lat/lng span.
     * @return
     */
    @JsMethod
    public native LatLng toSpan();

    /**
     * Converts to string.
     */
    @JsMethod
    public native String toString();

    /**
     * Returns a string of the form "lat_lo,lng_lo,lat_hi,lng_hi" for this bounds, where "lo" corresponds to the
     * southwest corner of the bounding box, while "hi" corresponds to the northeast corner of that box.
     */
    @JsMethod
    public native String toUrlValue(int number);

    /**
     * Extends this bounds to contain the union of this and the given bounds.
     */
    @JsMethod
    public native LatLngBounds union(LatLngBounds bounds);
}
