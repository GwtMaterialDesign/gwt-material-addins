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
    public CompleteCallback onComplete;

    @JsProperty
    public KeyPressCallback onKeyPress;

    @JsProperty
    public ChangeCallback onChange;

    @JsProperty
    public InvalidCallback onInvalid;

    @FunctionalInterface
    @JsFunction
    public interface InvalidCallback {
        void call(Object val, Event event, Functions.Func function, InputMaskError[] error, JsInputMaskOptions options);
    }

    @FunctionalInterface
    @JsFunction
    public interface CompleteCallback {
        void call(Object param1);
    }

    @FunctionalInterface
    @JsFunction
    public interface KeyPressCallback {
        void call(Object param1);
    }

    @FunctionalInterface
    @JsFunction
    public interface ChangeCallback {
        void call(Object param1);
    }
}
