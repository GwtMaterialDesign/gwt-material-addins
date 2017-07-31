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
package gwt.material.design.addins.client.richeditor.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Rich Editor component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true)
public class JsRichEditor extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsRichEditor $(String selector);

    @JsMethod
    public native JQueryElement materialnote(JsRichEditorOptions options);

    @JsMethod
    public native JQueryElement materialnote(String action, String value);

    @JsMethod
    public native JQueryElement materialnote(String action);

    @JsMethod
    public native JQueryElement destroy();

    @JsMethod
    public native String code();

    @JsMethod
    public native void code(String html);
}
