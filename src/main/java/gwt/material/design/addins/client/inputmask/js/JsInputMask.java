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
package gwt.material.design.addins.client.inputmask.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for input load component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true)
public class JsInputMask extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsInputMask $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsInputMask $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsInputMask $(String selector);

    @JsMethod
    public native JQueryElement mask(String mask);

    @JsMethod
    public native String masked(String masked);

    @JsMethod
    public native JQueryElement mask(String mask, JsInputMaskOptions options);

    @JsMethod
    public native String cleanVal();

    @JsMethod
    public native JQueryElement unmask();
}
