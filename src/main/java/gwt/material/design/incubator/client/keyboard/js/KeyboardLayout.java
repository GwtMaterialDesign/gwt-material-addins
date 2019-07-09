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
package gwt.material.design.incubator.client.keyboard.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KeyboardLayout {

    @JsProperty(name = "default")
    private String[] defaultLayout;

    @JsProperty(name = "shift")
    private String[] shiftLayout;

    @JsProperty(name =  "alt")
    private String[] altLayout;

    @JsProperty(name = "smileys")
    private String[] smileysLayout;

    @JsOverlay
    public final String[] getDefaultLayout() {
        return defaultLayout;
    }

    @JsOverlay
    public final void setDefaultLayout(String[] defaultLayout) {
        this.defaultLayout = defaultLayout;
    }

    @JsOverlay
    public final void setShiftLayout(String[] shiftLayout) {
        this.shiftLayout = shiftLayout;
    }

    @JsOverlay
    public final void setAltLayout(String[] altLayout) {
        this.altLayout = altLayout;
    }

    @JsOverlay
    public final void setSmileysLayout(String[] smileysLayout) {
        this.smileysLayout = smileysLayout;
    }
}
