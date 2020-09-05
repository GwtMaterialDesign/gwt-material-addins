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


import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.List;

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
    public String dictUploadCanceled;

    @JsProperty
    public String dictCancelUploadConfirmation;

    @JsProperty
    public String dictRemoveFile;

    @JsProperty
    public String dictRemoveFileConfirmation;

    @JsProperty
    public String dictMaxFilesExceeded;

    @JsProperty
    public String dictFileSizeUnits;

    @JsProperty
    public int timeout;

    @JsProperty
    public int parallelUploads;

    @JsProperty
    public boolean uploadMultiple;

    @JsProperty
    public boolean chunking;

    @JsProperty
    public boolean forceChunking;

    @JsProperty
    public long chunkSize;

    @JsProperty
    public boolean parallelChunkUploads;

    @JsProperty
    public boolean retryChunks;

    @JsProperty
    public int retryChunksLimit;

    @JsProperty
    public String paramName;

    @JsProperty
    public boolean createImageThumbnails;

    @JsProperty
    public int maxThumbnailFilesize;

    @JsProperty
    public int thumbnailWidth;

    @JsProperty
    public int thumbnailHeight;

    @JsProperty
    public String thumbnailMethod;

    @JsProperty
    public int resizeWidth;

    @JsProperty
    public int resizeHeight;

    @JsProperty
    public String resizeMimeType;

    @JsProperty
    public double resizeQuality;

    @JsProperty
    public String resizeMethod;

    @JsProperty
    public int filesizeBase;

    @JsProperty
    public Object headers;

    @JsProperty
    public boolean ignoreHiddenFiles;

    @JsProperty
    public boolean addRemoveLinks;

    @JsProperty
    public Object hiddenInputContainer;

    @JsProperty
    public Object capture;

    @JsProperty
    public Functions.Func1<File> renameFile;

    @JsProperty
    public boolean forceFallback;
}
