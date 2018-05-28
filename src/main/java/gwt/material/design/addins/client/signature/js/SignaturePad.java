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
package gwt.material.design.addins.client.signature.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Signature Pad component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class SignaturePad {

    public SignaturePad(Element element) {
    }

    public SignaturePad(Element element, JsSignaturePadOptions options) {
    }

    @JsProperty
    public double dotSize;

    @JsProperty
    public double minWidth;

    @JsProperty
    public double maxWidth;

    @JsProperty
    public int throttle;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public String penColor;

    @JsProperty
    public double velocityFilterWeight;

    @JsMethod
    public native String toDataURL();

    @JsMethod
    public native String toDataURL(String type);

    @JsMethod
    public native void fromDataURL(String data);

    @JsMethod
    public native void clear();

    @JsMethod
    public native boolean isEmpty();

    @JsMethod
    public native void off();

    @JsMethod
    public native void on();
}
