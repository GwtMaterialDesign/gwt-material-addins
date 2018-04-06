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

import gwt.material.design.jquery.client.api.Event;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for input load component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsInputMaskOptions {

    @JsProperty
    public boolean reverse;

    @JsProperty
    public boolean clearIfNotMatch;

    @JsProperty
    public boolean selectOnFocus;

    @JsProperty
    public Functions.Func1<Object> onComplete;

    @JsProperty
    public Functions.Func1<Object> onKeyPress;

    @JsProperty
    public Functions.Func1<Object> onChange;

    @JsProperty
    public Func4<Object, Event, Functions.Func, String[]> onInvalid;

    @FunctionalInterface
    @JsFunction
    public interface Func4<A, B, C, D> {
        void call(A param1, B param2, C param3, D param4);
    }
}
