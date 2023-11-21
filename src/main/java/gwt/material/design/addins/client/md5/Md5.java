/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2021 GwtMaterialDesign
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
package gwt.material.design.addins.client.md5;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "md5")
public class Md5 {

    public Md5(String message) {
    }

    public Md5() {
    }

    @JsMethod(namespace = "md5")
    public static native String hex(String message);

    @JsMethod(namespace = "md5")
    public static native byte[] array(String message);

    @JsMethod(namespace = "md5")
    public static native byte[] digest(String message);

    @JsMethod(namespace = "md5")
    public static native Object arrayBuffer(String message);

    @JsMethod(namespace = "md5")
    public static native Object buffer(String message);

    @JsMethod(namespace = "md5")
    public static native String base64(String message);

    @JsMethod(namespace = "md5")
    public static native void destroy();
}
