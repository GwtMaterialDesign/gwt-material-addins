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
package gwt.material.design.incubator.client.google.recaptcha3.js;

import gwt.material.design.incubator.client.google.recaptcha3.constants.ReCaptcha3Option;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.Promise;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsReCaptcha3 {

    @JsMethod(namespace = "grecaptcha")
    public static native void ready(Functions.Func callback);

    @JsMethod(namespace = "grecaptcha")
    public static native Promise execute(String key, ReCaptcha3Option option);
}
