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

import jsinterop.annotations.*;

/**
 * Represents a photo element of a Place.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PlacePhoto {

    /**
     * Returns the image URL corresponding to the specified options. You must include a PhotoOptions object with at
     * least one of maxWidth or maxHeight specified.
     */
    @JsMethod
    public native void getUrl(PhotoOptions options);

    @JsProperty
    private double height;

    @JsProperty
    private String[] html_attributions;

    @JsProperty
    private int width;

    /**
     * The height of the photo in pixels.
     */
    @JsOverlay
    public final double getHeight() {
        return height;
    }

    @JsOverlay
    public final void setHeight(double height) {
        this.height = height;
    }

    /**
     * Attribution text to be displayed for this photo.
     */
    @JsOverlay
    public final String[] getHtmlAttributions() {
        return html_attributions;
    }

    @JsOverlay
    public final void setHtmlAttributions(String[] htmlAttributions) {
        this.html_attributions = htmlAttributions;
    }

    /**
     * The width of the photo in pixels.
     */
    @JsOverlay
    public final int getWidth() {
        return width;
    }

    @JsOverlay
    public final void setWidth(int width) {
        this.width = width;
    }
}
