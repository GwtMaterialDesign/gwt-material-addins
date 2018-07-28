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

import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLng;
import gwt.material.design.incubator.client.google.addresslookup.js.options.LatLngBounds;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines information about the geometry of a Place.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlaceGeometry {

    @JsProperty
    private LatLng location;

    @JsProperty
    private LatLngBounds viewport;

    /**
     * The Place's position.
     */
    @JsOverlay
    public final LatLng getLocation() {
        return location;
    }

    /**
     * The preferred viewport when displaying this Place on a map. This property will be null if the preferred viewport
     * for the Place is not known.
     */
    @JsOverlay
    public final LatLngBounds getViewport() {
        return viewport;
    }
}
