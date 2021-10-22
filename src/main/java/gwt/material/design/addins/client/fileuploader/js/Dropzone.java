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
package gwt.material.design.addins.client.fileuploader.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.*;

import java.util.List;

/**
 * Dropzone JSInterop object and utils
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Dropzone extends JQueryElement {

    public Dropzone(Element e, JsFileUploaderOptions options) {
    }

    @JsMethod
    public  native void on(String events, Functions.Func1<Object> callback);

    @JsMethod
    public native void on(String events, ProgressCallback callback);

    @FunctionalInterface
    @JsFunction
    public interface ProgressCallback {
        void call(Double uploadProgress, Integer totalBytes, Integer totalBytesSent);
    }

    @JsProperty
    public JQueryElement hiddenFileInput;

    @JsMethod
    public native void on(String events, Functions.Func2<Object, Object> callback);

    @JsMethod
    public native void emit(String method, Object file);

    @JsMethod
    public native void addFile(Object file);

    @JsMethod
    public native void removeEventListeners();

    @JsMethod
    public native void setupEventListeners();

    @JsMethod
    public native void removeAllFiles();

    @JsMethod
    public native void enqueueFile(File file);

    @JsMethod
    public native void destroy();

    @JsMethod
    public native void removeFile(File file);

    @JsMethod
    public native void removeAllFiles(boolean cancelUpload);

    @JsMethod
    public native void processQueue();

    @JsMethod
    public native List<File> getAcceptedFiles();

    @JsMethod
    public native List<File> getRejectedFiles();

    @JsMethod
    public native List<File> getQueuedFiles();

    @JsMethod
    public native List<File> getUploadingFiles();

    @JsMethod
    public native void disable();

    @JsMethod
    public native void enable();
}
