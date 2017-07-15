/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.fileuploader.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Dropzone JSInterop object and utils
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Dropzone extends JQueryElement {

    public Dropzone(Element e, JsFileUploaderOptions options) {
    }

    public native Dropzone on(String events, Functions.Func1<File> callback);

    public native Dropzone on(String events, Functions.Func3<Double, File, String> callback);

    public native Dropzone on(String events, Functions.Func2<File, String> callback);

    public native void removeEventListeners();

    public native void setupEventListeners();

    public native void removeAllFiles();

    public native void processQueue();

    public native void enqueueFile(File file);
}
