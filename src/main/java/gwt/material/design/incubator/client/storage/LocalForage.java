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
package gwt.material.design.incubator.client.storage;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.jquery.client.api.Promise;
import jsinterop.annotations.*;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "localforage")
public class LocalForage {

    @JsProperty
    public Driver LOCALSTORAGE;

    @JsProperty
    public Driver WEBSQL;

    @JsProperty
    public Driver INDEXEDDB;

    /**
     * Data Api
     **/

    @JsMethod
    public static native Promise getItem(String key);

    @JsMethod
    public static native Promise setItem(String key, Object value);

    @JsMethod
    public static native Promise clear();

    @JsMethod
    public static native Promise length();

    @JsMethod
    public static native Promise removeItem(String key);

    @JsMethod
    public static native Promise key(int index);

    @JsMethod
    public static native Promise keys();

    @JsMethod
    public static native Promise iterate(IterateCallback callback);

    /**
     * Settings Api
     */
    @JsMethod
    public native static void setDriver(Driver driver);

    @JsMethod
    public native static void setDriver(Driver[] drivers);

    @JsMethod
    public native static void config(LocalForageOptions options);

    /**
     * Driver Api
     */

    @JsMethod
    public static native void defineDriver(Object object);

    @JsMethod
    public static native void Driver();

    @JsMethod
    public static native Promise ready();

    @JsMethod
    public static native boolean supports(Driver driver);

    /**
     * Create Instance
     */
    @JsMethod
    public static native LocalForage createInstance(LocalForageOptions options);

    @JsMethod
    public static native void dropInstance();

    @JsMethod
    public static native void dropInstance(LocalForageOptions options);

    @JsOverlay
    public static final void injectResource() {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(LocalStorageClientDebugBundle.INSTANCE.localForageDebugJs());
        } else {
            MaterialDesignBase.injectJs(LocalStorageClientBundle.INSTANCE.localForage());
        }
    }

    @FunctionalInterface
    @JsFunction
    public interface IterateCallback {
        void call(Object value, String key, Integer iterationNumber);
    }
}
