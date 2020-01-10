/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.avatar.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for combobox component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AvatarSaturationOptions {

    @JsProperty
    private Double color;

    @JsProperty
    private Double grayscale;

    @JsOverlay
    public final Double getColor() {
        return color;
    }

    /**
     * Specifies the saturation of the originally colored shapes of an icon. The saturation is expressed as a number
     * in the range [0.0, 1.0]. Was previously called just saturation.
     * Default : 		0.5
     */
    @JsOverlay
    public final void setColor(Double color) {
        this.color = color;
    }

    @JsOverlay
    public final Double getGrayscale() {
        return grayscale;
    }

    /**
     * Specifies the saturation of the originally grayscale shapes of an icon. The saturation is expressed as a number
     * in the range [0.0, 1.0].
     * Default : 	0.0
     */
    @JsOverlay
    public final void setGrayscale(Double grayscale) {
        this.grayscale = grayscale;
    }
}
