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
package gwt.material.design.incubator.client.google.recaptcha3.constants;


import gwt.material.design.incubator.client.google.recaptcha.ReCaptcha;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ReCaptcha3Option {

    private ReCaptcha3Option() {}

    @JsOverlay
    public final static ReCaptcha3Option create() {
        ReCaptcha3Option option = new ReCaptcha3Option();
        option.setAction(ReCaptcha3Actions.LOGIN);
        return option;
    }

    @JsProperty
    private String action;

    @JsOverlay
    public final String getAction() {
        return action;
    }

    @JsOverlay
    public final void setAction(String action) {
        this.action = action;
    }
}
