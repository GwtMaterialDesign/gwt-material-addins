/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.google.addresslookup.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The MVCObject constructor is guaranteed to be an empty function, and so you may inherit from MVCObject by simply
 * writing MvcObject = new MvcObject();. Unless otherwise noted, this is not true of other
 * classes in the API, and inheriting from other classes in the API is not supported.
 *
 * @author kevzlou7979
 * @see <a href="https://developers.google.com/maps/documentation/javascript/reference/3/#MVCObject">MVC Object</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "MVCObject")
public class MvcObject {

    /**
     * Adds the given listener function to the given event name. Returns an identifier for this listener that can be
     * used with google.maps.event.removeListener.
     */
    @JsMethod
    public native void addListener(String name, Functions.Func function);

    /**
     * Binds a View to a Model.
     */
    @JsMethod
    public native void bindTo(String key, MvcObject target, String targetKey, boolean notify);

    /**
     * Gets a value.
     */
    @JsMethod
    public native Object get(String key);

    /**
     * Notify all observers of a change on this property. This notifies both objects that are bound to the object's
     * property as well as the object that it is bound to.
     */
    @JsMethod
    public native void notify(String key);

    /**
     * Sets a value.
     */
    @JsMethod
    public native void set(String key, Object value);

    /**
     * Sets a collection of key-value pairs.
     */
    @JsMethod
    public native void setValues(Object values);

    /**
     * Removes a binding. Unbinding will set the unbound property to the current value. The object will not be notified,
     * as the value has not changed.
     */
    @JsMethod
    public native void unbind(String key);

    /**
     * Removes all bindings.
     */
    @JsMethod
    public native void unbindAll();
}
