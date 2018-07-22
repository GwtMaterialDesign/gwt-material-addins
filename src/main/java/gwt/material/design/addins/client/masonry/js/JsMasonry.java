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
package gwt.material.design.addins.client.masonry.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for masonry component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true)
public class JsMasonry extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsMasonry $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsMasonry $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsMasonry $(String selector);

    @JsMethod
    public native JsMasonry imagesLoaded(Functions.Func function);

    @JsMethod
    public native JsMasonry masonry();

    @JsMethod
    public native JsMasonry masonry(JsMasonryOptions options);

    @JsMethod
    public native JsMasonry masonry(String action);

    @JsMethod
    public native JsMasonry masonry(String action, Element element);

    @JsMethod
    public native JsMasonry masonry(String action, String selector);
}
