package gwt.material.design.addins.client.fileuploader.js;

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


import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for file uploader component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsFileUploaderOptions {

    public String url;

    @JsProperty
    public int maxFilesize;

    @JsProperty
    public String method;

    @JsProperty
    public int maxFiles;

    @JsProperty
    public String previewTemplate;

    @JsProperty
    public String acceptedFiles;

    @JsProperty
    public boolean autoProcessQueue;

    @JsProperty
    public boolean autoQueue;

    @JsProperty
    public String previewsContainer;

    @JsProperty
    public String clickable;

    @JsProperty
    public boolean withCredentials;

    @JsProperty
    public String dictDefaultMessage;

    @JsProperty
    public String dictFallbackMessage;

    @JsProperty
    public String dictFallbackText;

    @JsProperty
    public String dictFileTooBig;

    @JsProperty
    public String dictInvalidFileType;
    @JsProperty
    public String dictResponseError;

    @JsProperty
    public String dictCancelUpload;

    @JsProperty
    public String dictCancelUploadConfirmation;

    @JsProperty
    public String dictRemoveFile;

    @JsProperty
    public String dictMaxFilesExceeded;
}