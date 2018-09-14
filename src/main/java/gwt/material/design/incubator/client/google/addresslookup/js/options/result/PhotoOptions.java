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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Defines photo-requesting options.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PhotoOptions {

    @JsProperty
    private int maxHeight;

    @JsProperty
    private int maxWidth;

    @JsOverlay
    public final int getMaxHeight() {
        return maxHeight;
    }

    /**
     * The maximum height in pixels of the returned image.
     */
    @JsOverlay
    public final void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @JsOverlay
    public final int getMaxWidth() {
        return maxWidth;
    }

    /**
     * The maximum width in pixels of the returned image.
     */
    @JsOverlay
    public final void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }
}
