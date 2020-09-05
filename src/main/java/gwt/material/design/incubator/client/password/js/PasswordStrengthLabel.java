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
public class PasswordStrengthLabel {

    @JsProperty
    private String strength;

    @JsProperty
    private String weak;

    @JsProperty
    private String fair;

    @JsProperty
    private String good;

    @JsProperty
    private String strong;

    @JsOverlay
    public final String getStrength() {
        return strength;
    }

    @JsOverlay
    public final void setStrength(String strength) {
        this.strength = strength;
    }

    @JsOverlay
    public final String getWeak() {
        return weak;
    }

    @JsOverlay
    public final void setWeak(String weak) {
        this.weak = weak;
    }

    @JsOverlay
    public final String getFair() {
        return fair;
    }

    @JsOverlay
    public final void setFair(String fair) {
        this.fair = fair;
    }

    @JsOverlay
    public final String getGood() {
        return good;
    }

    @JsOverlay
    public final void setGood(String good) {
        this.good = good;
    }

    @JsOverlay
    public final String getStrong() {
        return strong;
    }

    @JsOverlay
    public final void setStrong(String strong) {
        this.strong = strong;
    }
}
