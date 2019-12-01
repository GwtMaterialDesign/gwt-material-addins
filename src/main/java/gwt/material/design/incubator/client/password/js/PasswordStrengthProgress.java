/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.incubator.client.password.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class PasswordStrengthProgress {

    @JsProperty
    private String width;

    @JsProperty
    private String height;

    @JsProperty
    private PasswordStrengthProgressColor color;

    @JsOverlay
    public final String getWidth() {
        return width;
    }

    @JsOverlay
    public final void setWidth(String width) {
        this.width = width;
    }

    @JsOverlay
    public final String getHeight() {
        return height;
    }

    @JsOverlay
    public final void setHeight(String height) {
        this.height = height;
    }

    @JsOverlay
    public final PasswordStrengthProgressColor getColor() {
        return color;
    }

    @JsOverlay
    public final void setColor(PasswordStrengthProgressColor color) {
        this.color = color;
    }
}
