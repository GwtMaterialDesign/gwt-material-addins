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
public class PasswordStrengthOptions {

    @JsProperty
    private int limit;

    @JsProperty
    private boolean showSuggestions;

    @JsProperty
    private PasswordStrengthLabel label;

    @JsProperty
    private PasswordStrengthProgress progress;

    @JsOverlay
    public final int getLimit() {
        return limit;
    }

    @JsOverlay
    public final void setLimit(int limit) {
        this.limit = limit;
    }

    @JsOverlay
    public final boolean isShowSuggestions() {
        return showSuggestions;
    }

    @JsOverlay
    public final void setShowSuggestions(boolean showSuggestions) {
        this.showSuggestions = showSuggestions;
    }

    @JsOverlay
    public final PasswordStrengthLabel getLabel() {
        return label;
    }

    @JsOverlay
    public final void setLabel(PasswordStrengthLabel label) {
        this.label = label;
    }

    @JsOverlay
    public final PasswordStrengthProgress getProgress() {
        return progress;
    }

    @JsOverlay
    public final void setProgress(PasswordStrengthProgress progress) {
        this.progress = progress;
    }
}
