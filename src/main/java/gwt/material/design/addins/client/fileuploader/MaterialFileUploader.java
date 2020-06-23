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
package gwt.material.design.addins.client.fileuploader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.dark.AddinsDarkThemeReloader;
import gwt.material.design.addins.client.fileuploader.base.HasFileUploadHandlers;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.base.UploadResponse;
import gwt.material.design.addins.client.fileuploader.constants.FileMethod;
import gwt.material.design.addins.client.fileuploader.constants.FileUploaderEvents;
import gwt.material.design.addins.client.fileuploader.events.*;
import gwt.material.design.addins.client.fileuploader.js.Dropzone;
import gwt.material.design.addins.client.fileuploader.js.File;
import gwt.material.design.addins.client.fileuploader.js.JsFileUploaderOptions;
import gwt.material.design.addins.client.fileuploader.js.Response;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.events.*;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Custom file uploader with Dnd support with the help of dropzone.js. It has multiple
 * feature just like the GWT File Uploader core widget.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <ma:fileuploader.MaterialFileUploader url="/file/upload"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#fileuploader">File Uploader</a>
 * @see <a href="https://github.com/enyo/dropzone">Dropzone 4.3.0</a>
 */
//@formatter:on
public class MaterialFileUploader extends MaterialWidget implements JsLoader, HasFileUploadHandlers<UploadFile> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialFileUploaderDebugClientBundle.INSTANCE.dropzoneJsDebug());
            MaterialDesignBase.injectCss(MaterialFileUploaderDebugClientBundle.INSTANCE.dropzoneCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialFileUploaderClientBundle.INSTANCE.dropzoneJs());
            MaterialDesignBase.injectCss(MaterialFileUploaderClientBundle.INSTANCE.dropzoneCss());
        }
    }

    private boolean preview = true;
    private boolean enabled = true;

    private int totalFiles = 0;
    private Object globalResponse;
    private Dropzone uploader;
    private MaterialUploadPreview uploadPreview = new MaterialUploadPreview();
    private JsFileUploaderOptions options = new JsFileUploaderOptions();

    public MaterialFileUploader() {
        super(Document.get().createDivElement(), AddinsCssName.FILEUPLOADER);

        setId(AddinsCssName.ZDROP);
        add(uploadPreview);
    }

    public MaterialFileUploader(String url, FileMethod method) {
        this();
        setUrl(url);
        setMethod(method);
    }

    public MaterialFileUploader(String url, FileMethod method, int maxFileSize, String acceptedFiles) {
        this(url, method);
        setMaxFiles(maxFileSize);
        setAcceptedFiles(acceptedFiles);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (getWidgetCount() > 1) {
            uploadPreview.getUploadCollection().setId(DOM.createUniqueId());
            if (options.clickable == null) {
                String clickable = DOM.createUniqueId();
                options.clickable = "#" + clickable;
                if (getWidget(1) instanceof MaterialUploadLabel) {
                    MaterialUploadLabel label = (MaterialUploadLabel) getWidget(1);
                    label.getIcon().setId(clickable);
                } else {
                    getWidget(1).getElement().setId(clickable);
                }
            }

            if (!isPreview()) {
                uploadPreview.setDisplay(Display.NONE);
            }
            load();
        } else {
            GWT.log("You don't have any child widget to use as a upload label");
        }

        setEnabled(enabled);
        AddinsDarkThemeReloader.get().reload(MaterialFileUploaderDarkTheme.class);
    }

    @Override
    public void load() {
        MaterialUploadCollection uploadCollection = uploadPreview.getUploadCollection();
        if (uploadCollection != null) {
            initDropzone(getElement(),
                uploadCollection.getItem().getElement(),
                uploadCollection.getId(),
                uploadCollection.getElement(),
                uploadPreview.getUploadHeader().getUploadedFiles().getElement());
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        unload();
    }

    @Override
    public void unload() {
        if (uploader != null) {
            uploader.destroy();
        }
    }

    @Override
    public void reload() {
        unload();
        load();
    }


    /**
     * Intialize the dropzone component with element and form url to provide a
     * dnd feature for the file upload.
     */
    protected void initDropzone(Element e, Element template, String previews, Element uploadPreview, Element uploadedFiles) {
        JQueryElement previewNode = $(template);
        previewNode.asElement().setId("");
        String previewTemplate = previewNode.parent().html();
        options.previewTemplate = previewTemplate;
        options.previewsContainer = "#" + previews;
        uploader = new Dropzone(e, options);

        uploader.on(FileUploaderEvents.DROP, event -> {
            fireDropEvent();
            if (preview) {
                $(e).removeClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on(FileUploaderEvents.DRAG_START, event -> {
            DragStartEvent.fire(this);
            return true;
        });

        uploader.on(FileUploaderEvents.DRAG_END, event -> {
            DragEndEvent.fire(this);
            return true;
        });

        uploader.on(FileUploaderEvents.DRAG_ENTER, event -> {
            DragEnterEvent.fire(this, null);
            if (preview) {
                $(e).addClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on(FileUploaderEvents.DRAG_OVER, event -> {
            DragOverEvent.fire(this);
            return true;
        });

        uploader.on(FileUploaderEvents.DRAG_LEAVE, event -> {
            DragLeaveEvent.fire(this, null);
            if (preview) {
                $(e).removeClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on(FileUploaderEvents.ADDED_FILE, object -> {
            File file = (File) object;
            AddedFileEvent.fire(this, convertUploadFile(file));
            totalFiles++;

            if (isPreview()) {
                $(uploadedFiles).html("Uploaded files " + totalFiles);
                getUploadPreview().getUploadHeader().getProgress().setPercent(0);
                getUploadPreview().setVisibility(Style.Visibility.VISIBLE);
            }
        });

        uploader.on(FileUploaderEvents.REMOVED_FILE, object -> {
            File file = (File) object;
            RemovedFileEvent.fire(this, convertUploadFile(file));
            totalFiles -= 1;
            $(uploadedFiles).html("Uploaded files " + totalFiles);

            if (totalFiles == 0 && isPreview()) {
                getUploadPreview().setVisibility(Style.Visibility.HIDDEN);
            }
        });

        uploader.on(FileUploaderEvents.ERROR, (file, response) -> {
            int code = 200;
            String statusText = "";

            if (file.xhr != null) {
                code = file.xhr.status;
                statusText = file.xhr.statusText;
            }

            String body = "";

            if (response instanceof String) {
                body = (String) response;
            } else {
                statusText = getResponseMessage(response);
            }

            if (code == 401) {
                statusText = statusText.isEmpty() ? "Unauthorized. Your session may have expired. Log in and try again." : statusText;
                globalResponse = response;
                UnauthorizedEvent.fire(this, convertUploadFile(file), new UploadResponse(code, statusText, body));
            }

            if (code == 404) {
                statusText = statusText.isEmpty() ? "There is a problem uploading your file." : statusText;
                globalResponse = response;
            }

            if (code == 500) {
                statusText = statusText.isEmpty() ? "There is a problem uploading your file." : statusText;
                globalResponse = response;
            }


            ErrorEvent.fire(this, convertUploadFile(file), new UploadResponse(code, statusText, body));
        });

        uploader.on(FileUploaderEvents.TOTAL_UPLOAD_PROGRESS, (progress, file, response) -> {
            TotalUploadProgressEvent.fire(this, progress);
            if (isPreview()) {
                getUploadPreview().getUploadHeader().getProgress().setPercent(progress);
            }
        });

        uploader.on(FileUploaderEvents.UPLOAD_PROGRESS, (progress, file, response) -> {
            CurrentUploadProgressEvent.fire(this, progress);
            if ($this != null) {
                $this.find(".progress .determinate").css("width", progress + "%");
            }
        });

        uploader.on(FileUploaderEvents.SENDING, object -> {
            File file = (File) object;
            SendingEvent.fire(this, convertUploadFile(file),
                new UploadResponse(file.xhr.status, file.xhr.statusText));
        });

        uploader.on(FileUploaderEvents.SUCCESS, (file, response) -> {
            globalResponse = response;
            String message = getResponseMessage(response);
            SuccessEvent.fire(this, convertUploadFile(file),
                new UploadResponse(file.xhr.status, file.xhr.statusText, message));
        });

        uploader.on(FileUploaderEvents.COMPLETE, object -> {
            File file = (File) object;
            String message = getResponseMessage(globalResponse);
            CompleteEvent.fire(this, convertUploadFile(file),
                new UploadResponse(file.xhr.status, file.xhr.statusText, message));
        });

        uploader.on(FileUploaderEvents.CANCELED, object -> {
            File file = (File) object;
            CanceledEvent.fire(this, convertUploadFile(file));
        });

        uploader.on(FileUploaderEvents.MAX_FILES_REACHED, object -> {
            File file = (File) object;
            MaxFilesReachedEvent.fire(this, convertUploadFile(file));
        });

        uploader.on(FileUploaderEvents.MAX_FILES_EXCEEDED, object -> {
            File file = (File) object;
            MaterialToast.fireToast("You have reached the maximum files to be uploaded.");
            MaxFilesExceededEvent.fire(this, convertUploadFile(file));
        });

        //TODO: Find why the following events had exceptions
        /*uploader.on(FileUploaderEvents.THUMBNAIL, (file, object) -> {
         ThumbnailEvent.fire(this, convertUploadFile(file), object != null ? (String) object : "");
            MaterialToast.fireToast("Thumbnail");
        });

        uploader.on(FileUploaderEvents.PROCESSING, object -> {
            File file = (File) object;
            ProcessingEvent.fire(this, convertUploadFile(file));
        });*/

        // All of these receive a list of files as first parameter and are only called if the uploadMultiple option is true
        uploader.on(FileUploaderEvents.PROCESSING_MULTIPLE, object -> {
            File[] files = (File[]) object;
            ProcessingMultipleEvent.fire(this, convertUploadFiles(files));
        });

        uploader.on(FileUploaderEvents.SENDING_MULTIPLE, object -> {
            File[] files = (File[]) object;
            SendingMultipleEvent.fire(this, convertUploadFiles(files), generateUploadResponse(files));
        });

        uploader.on(FileUploaderEvents.SUCCESS_MULTIPLE, object -> {
            File[] files = (File[]) object;
            SuccessMultipleEvent.fire(this, convertUploadFiles(files), generateUploadResponse(files));
        });

        uploader.on(FileUploaderEvents.COMPLETE_MULTIPLE, object -> {
            File[] files = (File[]) object;
            CompleteMultipleEvent.fire(this, convertUploadFiles(files), generateUploadResponse(files));
        });

        uploader.on(FileUploaderEvents.CANCELED_MULTIPLE, object -> {
            File[] files = (File[]) object;
            CanceledMultipleEvent.fire(this, convertUploadFiles(files));
        });

        uploader.on(FileUploaderEvents.RESET, object -> {
            ResetEvent.fire(this);
        });

        uploader.on(FileUploaderEvents.QUEUE_COMPLETE, object -> {
            QueueCompleteEvent.fire(this);
        });
    }

    private String getResponseMessage(Object response) {
        String message = null;
        if (response != null) {
            if (response instanceof String) {
                message = (String) response;
            } else {
                message = ((Response) response).message;
            }
        }
        return message;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            if (uploader != null) uploader.setupEventListeners();
            removeStyleName(CssName.DISABLED);
        } else {
            if (uploader != null) uploader.removeEventListeners();
            addStyleName(CssName.DISABLED);
        }

        getEnabledMixin().updateWaves(enabled, this);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().hasClassName(CssName.DISABLED);
    }

    /**
     * Converts a Native File Object to Upload File object
     */
    protected UploadFile convertUploadFile(File file) {
        if (file != null) {
            Date lastModifiedDate = new Date();
            // Avoid parsing error on last modified date
            if (file.lastModifiedDate != null && !file.lastModifiedDate.isEmpty()) {
                lastModifiedDate = new Date(file.lastModifiedDate);
            }
            return new UploadFile(file.name, lastModifiedDate, Double.parseDouble(file.size), file.type);
        }
        return null;
    }

    protected List<UploadFile> convertUploadFiles(File[] files) {
        List<UploadFile> uploadFiles = new ArrayList<>();
        for (File file : files) {
            UploadFile uploadFile = convertUploadFile(file);
            if (uploadFile != null) {
                uploadFiles.add(uploadFile);
            }
        }
        return uploadFiles;
    }

    protected List<UploadResponse> generateUploadResponse(File[] files) {
        List<UploadResponse> responses = new ArrayList<>();
        for (File file : files) {
            responses.add(new UploadResponse(file.xhr.status, file.xhr.statusText));
        }
        return responses;
    }

    /**
     * Manually start upload queued files when option autoProcessQueue is disabled
     */
    public void processQueue() {
        uploader.processQueue();
    }

    /**
     * Manually enqueue file when option autoQueue is disabled
     */
    public void enqueueFile(File file) {
        uploader.enqueueFile(file);
    }

    /**
     * If you want to remove an added file from the dropzone, you can call .removeFile(file). This method also triggers
     * the removedfile event.
     */
    public void removeFile(File file) {
        uploader.removeFile(file);
    }

    /**
     * If you want to remove all files, simply use .removeAllFiles(). Files that are in the process of being uploaded won’t be removed.
     */
    public void removeAllFiles() {
        uploader.removeAllFiles();
    }

    /**
     * If you want files that are currently uploading to be canceled, call .removeAllFiles(true) which will cancel the uploads.
     */
    public void removeAllFiles(boolean cancelUpload) {
        uploader.removeAllFiles(cancelUpload);
    }

    /**
     * Get all rejected files
     */
    public List<File> getRejectedFiles() {
        return uploader.getRejectedFiles();
    }

    /**
     * Get all queued files
     */
    public List<File> getQueuedFiles() {
        return uploader.getQueuedFiles();
    }

    /**
     * Get all uploading files
     */
    public List<File> getUploadingFiles() {
        return uploader.getUploadingFiles();
    }

    /**
     * If you do not need a dropzone anymore, just call .disable() on the object.
     * This will remove all event listeners on the element, and clear all file arrays.
     */
    public void disable() {
        uploader.disable();
    }

    /**
     * To reenable dropzone.
     */
    public void enable() {
        uploader.enable();
    }

    /**
     * Get the form url.
     */
    public String getUrl() {
        return options.url;
    }

    /**
     * Set the form url e.g /file/post.
     */
    public void setUrl(String url) {
        options.url = url;
    }

    /**
     * Get the maximum file size value of the uploader.
     */
    public int getMaxFileSize() {
        return options.maxFilesize;
    }

    /**
     * Set the maximum file size of the uploader, default 20(MB).
     */
    public void setMaxFileSize(int maxFileSize) {
        options.maxFilesize = maxFileSize;
    }

    /**
     * Check whether it's auto process queue or not.
     */
    public boolean isAutoProcessQueue() {
        return options.autoProcessQueue;
    }

    /**
     * Set the auto process queue boolean value.
     */
    public void setAutoProcessQueue(boolean autoProcessQueue) {
        options.autoProcessQueue = autoProcessQueue;
    }

    /**
     * Check whether it's auto queue or not.
     */
    public boolean isAutoQueue() {
        return options.autoQueue;
    }

    /**
     * Set the auto queue boolean value.
     */
    public void setAutoQueue(boolean autoQueue) {
        options.autoQueue = autoQueue;
    }

    /**
     * Get the method param of file uploader.
     */
    public FileMethod getMethod() {
        return FileMethod.fromStyleName(options.method);
    }

    /**
     * Set the method param of file upload (POST or PUT), default POST.
     */
    public void setMethod(FileMethod method) {
        options.method = method.getCssName();
    }

    /**
     * Get the max number of files.
     */
    public int getMaxFiles() {
        return options.maxFiles;
    }

    /**
     * Set the max number of files.
     * Default 100 but if you want to accept only one file just set the max file to 1.
     * If the number of files you upload exceeds, the event maxfilesexceeded will be called.
     */
    public void setMaxFiles(int maxFiles) {
        options.maxFiles = maxFiles;
    }

    /**
     * Check whether it's withCredentials or not.
     */
    public boolean isWithCredentials() {
        return options.withCredentials;
    }

    /**
     * Set the withCredentials boolean value.
     */
    public void setWithCredentials(boolean withCredentials) {
        options.withCredentials = withCredentials;
    }

    /**
     * Get the accepted file string.
     */
    public String getAcceptedFiles() {
        return options.acceptedFiles;
    }

    /**
     * Set the default implementation of accept checks the file's mime type or extension against this list.
     * This is a comma separated list of mime types or file extensions. Eg.: image/*,application/pdf,.psd.
     */
    public void setAcceptedFiles(String acceptedFiles) {
        options.acceptedFiles = acceptedFiles;
    }

    public void fireDropEvent() {
        DropEvent.fire(this, null);
    }

    public String getClickable() {
        return options.clickable.length() == 0 ? options.clickable : options.clickable.substring(1);
    }

    public void setClickable(String clickable) {
        options.clickable = "#" + clickable;
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }

    public void reset() {
        uploader.removeAllFiles();
    }

    public MaterialUploadPreview getUploadPreview() {
        return uploadPreview;
    }

    public String getDictDefaultMessage() {
        return options.dictDefaultMessage;
    }

    /**
     * Defaults to "Drop files here to upload"
     */
    public void setDictDefaultMessage(String dictDefaultMessage) {
        options.dictDefaultMessage = dictDefaultMessage;
    }

    public String getDictFallbackMessage() {
        return options.dictFallbackMessage;
    }

    /**
     * Defaults to "Your browser does not support drag'n'drop file uploads."\
     */
    public void setDictFallbackMessage(String dictFallbackMessage) {
        options.dictFallbackMessage = dictFallbackMessage;
    }

    public String getDictFallbackText() {
        return options.dictFallbackText;
    }

    /**
     * Defaults to "Please use the fallback form below to upload your files like in the olden days."
     */
    public void setDictFallbackText(String dictFallbackText) {
        options.dictFallbackText = dictFallbackText;
    }

    public String getDictFileTooBig() {
        return options.dictFileTooBig;
    }

    /**
     * Defaults to "File is too big ({{filesize}}MiB). Max filesize: {{maxFilesize}}MiB."
     */
    public void setDictFileTooBig(String dictFileTooBig) {
        options.dictFileTooBig = dictFileTooBig;
    }

    public String getDictInvalidFileType() {
        return options.dictInvalidFileType;
    }

    /**
     * Defaults to "You can't upload files of this type."
     */
    public void setDictInvalidFileType(String dictInvalidFileType) {
        options.dictInvalidFileType = dictInvalidFileType;
    }

    public String getDictResponseError() {
        return options.dictResponseError;
    }

    /**
     * Defaults to "Server responded with {{statusCode}} code."
     */
    public void setDictResponseError(String dictResponseError) {
        options.dictResponseError = dictResponseError;
    }

    public String getDictCancelUpload() {
        return options.dictCancelUpload;
    }

    /**
     * Defaults to "Cancel upload"
     */
    public void setDictCancelUpload(String dictCancelUpload) {
        options.dictCancelUpload = dictCancelUpload;
    }

    public String getDictCancelUploadConfirmation() {
        return options.dictCancelUploadConfirmation;
    }

    /**
     * Defaults to "Are you sure you want to cancel this upload?"
     */
    public void setDictCancelUploadConfirmation(String dictCancelUploadConfirmation) {
        options.dictCancelUploadConfirmation = dictCancelUploadConfirmation;
    }

    public String getDictRemoveFile() {
        return options.dictRemoveFile;
    }

    /**
     * Defaults to "Remove file"
     */
    public void setDictRemoveFile(String dictRemoveFile) {
        options.dictRemoveFile = dictRemoveFile;
    }

    public String getDictMaxFilesExceeded() {
        return options.dictMaxFilesExceeded;
    }

    /**
     * Defaults to "You can not upload any more files."
     */
    public void setDictMaxFilesExceeded(String dictMaxFilesExceeded) {
        options.dictMaxFilesExceeded = dictMaxFilesExceeded;
    }

    public String getDictFileSizeUnits() {
        return options.dictFileSizeUnits;
    }

    /**
     * Allows you to translate the different units. Starting with tb for terabytes and going down to b for bytes.
     */
    public void setDictFileSizeUnits(String dictFileSizeUnits) {
        options.dictFileSizeUnits = dictFileSizeUnits;
    }

    public String getDictRemoveFileConfirmation() {
        return options.dictRemoveFileConfirmation;
    }

    /**
     * If this is not null, then the user will be prompted before removing a file.
     */
    public void setDictRemoveFileConfirmation(String dictRemoveFileConfirmation) {
        options.dictRemoveFileConfirmation = dictRemoveFileConfirmation;
    }

    public String getDictUploadCanceled() {
        return options.dictUploadCanceled;
    }

    /**
     * The text that is displayed if an upload was manually canceled
     */
    public void setDictUploadCanceled(String dictUploadCanceled) {
        options.dictUploadCanceled = dictUploadCanceled;
    }

    public int getTimeout() {
        return options.timeout;
    }

    /**
     * The timeout for the XHR requests in milliseconds (since v4.4.0).
     * Defaults to 3000 ms or 30 seconds
     */
    public void setTimeout(int timeout) {
        options.timeout = timeout;
    }

    public int getParallelUploads() {
        return options.parallelUploads;
    }

    /**
     * How many file uploads to process in parallel (See the Enqueuing file uploads documentation section for more info)
     * Defaults to 2
     */
    public void setParallelUploads(int parallelUploads) {
        options.parallelUploads = parallelUploads;
    }


    public boolean isUploadMultiple() {
        return options.uploadMultiple;
    }

    /**
     * Whether to send multiple files in one request. If this it set to true, then the fallback file input element will
     * have the multiple attribute as well. This option will also trigger additional events (like processingmultiple). See the events documentation section for more information.
     * Defaults to false
     */
    public void setUploadMultiple(boolean uploadMultiple) {
        options.uploadMultiple = uploadMultiple;
    }

    public boolean isChunking() {
        return options.chunking;
    }

    /**
     * Whether you want files to be uploaded in chunks to your server. This can't be used in combination with uploadMultiple.
     * See <a href="https://www.dropzonejs.com/#config-chunksUploaded">chunksUploaded</a> for the callback to finalise an upload.
     * <p>
     * Defaults to false
     */
    public void setChunking(boolean chunking) {
        options.chunking = chunking;
    }

    public boolean isForceChunking() {
        return options.forceChunking;
    }

    /**
     * If chunking is enabled, this defines whether every file should be chunked, even if the file size is below chunkSize.
     * This means, that the additional chunk form data will be submitted and the chunksUploaded callback will be invoked.
     * <p>
     * Defaults to false
     */
    public void setForceChunking(boolean forceChunking) {
        options.forceChunking = forceChunking;
    }

    public long getChunkSize() {
        return options.chunkSize;
    }

    /**
     * If chunking is true, then this defines the chunk size in bytes.
     * Defaults to 2000000
     */
    public void setChunkSize(long chunkSize) {
        options.chunkSize = chunkSize;
    }

    public boolean isParallelChunkUploads() {
        return options.parallelChunkUploads;
    }

    /**
     * If true, the individual chunks of a file are being uploaded simultaneously.
     */
    public void setParallelChunkUploads(boolean parallelChunkUploads) {
        options.parallelChunkUploads = parallelChunkUploads;
    }

    public boolean isRetryChunks() {
        return options.retryChunks;
    }

    /**
     * Whether a chunk should be retried if it fails.
     * Defaults to false
     */
    public void setRetryChunks(boolean retryChunks) {
        options.retryChunks = retryChunks;
    }

    public int getRetryChunksLimit() {
        return options.retryChunksLimit;
    }

    /**
     * If retryChunks is true, how many times should it be retried.
     * Defaults to 3
     */
    public void setRetryChunksLimit(int retryChunksLimit) {
        options.retryChunksLimit = retryChunksLimit;
    }

    public String getParamName() {
        return options.paramName;
    }

    /**
     * The name of the file param that gets transferred. NOTE: If you have the option uploadMultiple set to true, then
     * Dropzone will append [] to the name.
     * Defaults to "file"
     */
    public void setParamName(String paramName) {
        options.paramName = paramName;
    }

    public boolean isCreateImageThumbnails() {
        return options.createImageThumbnails;
    }

    /**
     * Whether thumbnails for images should be generated
     * Defaults to true
     */
    public void setCreateImageThumbnails(boolean createImageThumbnails) {
        options.createImageThumbnails = createImageThumbnails;
    }

    public int getMaxThumbnailFilesize() {
        return options.maxThumbnailFilesize;
    }

    /**
     * In MB. When the filename exceeds this limit, the thumbnail will not be generated.
     * Defaults to 10 MB
     */
    public void setMaxThumbnailFilesize(int maxThumbnailFilesize) {
        options.maxThumbnailFilesize = maxThumbnailFilesize;
    }

    public int getThumbnailWidth() {
        return options.thumbnailWidth;
    }

    /**
     * If null, the ratio of the image will be used to calculate it.
     * Defaults to 120
     */
    public void setThumbnailWidth(int thumbnailWidth) {
        options.thumbnailWidth = thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return options.thumbnailHeight;
    }

    /**
     * The same as thumbnailWidth. If both are null, images will not be resized.
     * Defaults to 120
     */
    public void setThumbnailHeight(int thumbnailHeight) {
        options.thumbnailHeight = thumbnailHeight;
    }

    public String getThumbnailMethod() {
        return options.thumbnailMethod;
    }

    /**
     * How the images should be scaled down in case both, thumbnailWidth and thumbnailHeight are provided. Can be either
     * contain or crop.
     * Defaults to "crop"
     */
    public void setThumbnailMethod(String thumbnailMethod) {
        options.thumbnailMethod = thumbnailMethod;
    }

    public int getResizeWidth() {
        return options.resizeWidth;
    }

    /**
     * If set, images will be resized to these dimensions before being uploaded. If only one, resizeWidth or resizeHeight
     * is provided, the original aspect ratio of the file will be preserved.
     * The options.transformFile function uses these options, so if the transformFile function is overridden, these options
     * don't do anything.
     * Defaults to null
     */
    public void setResizeWidth(int resizeWidth) {
        options.resizeWidth = resizeWidth;
    }

    public int getResizeHeight() {
        return options.resizeHeight;
    }

    /**
     * See resizeWidth.
     * Defaults to null
     */
    public void setResizeHeight(int resizeHeight) {
        options.resizeHeight = resizeHeight;
    }

    public String getResizeMimeType() {
        return options.resizeMimeType;
    }

    /**
     * The mime type of the resized image (before it gets uploaded to the server). If null the original mime type will be used.
     * To force jpeg, for example, use image/jpeg. See resizeWidth for more information.
     * Defaults to null
     */
    public void setResizeMimeType(String resizeMimeType) {
        options.resizeMimeType = resizeMimeType;
    }

    public double getResizeQuality() {
        return options.resizeQuality;
    }

    /**
     * The quality of the resized images. See resizeWidth.
     * Defaults to 0.8
     */
    public void setResizeQuality(double resizeQuality) {
        options.resizeQuality = resizeQuality;
    }

    public String getResizeMethod() {
        return options.resizeMethod;
    }

    /**
     * How the images should be scaled down in case both, resizeWidth and resizeHeight are provided. Can be either contain or crop.
     * Defaults to "contain"
     */
    public void setResizeMethod(String resizeMethod) {
        options.resizeMethod = resizeMethod;
    }

    public int getFilsizeBase() {
        return options.filesizeBase;
    }

    /**
     * The base that is used to calculate the filesize. You can change this to 1024 if you would rather display kibibytes,
     * mebibytes, etc... 1024 is technically incorrect, because 1024 bytes are 1 kibibyte not 1 kilobyte. You can change
     * this to 1024 if you don't care about validity.
     * Defaults to 1000
     */
    public void setFilesizeBase(int filsizeBase) {
        options.filesizeBase = filsizeBase;
    }

    public Object getHeaders() {
        return options.headers;
    }

    /**
     * An optional object to send additional headers to the server. Eg: { "My-Awesome-Header": "header value" }
     * Defaults to null
     */
    public void setHeaders(Object headers) {
        options.headers = headers;
    }

    public boolean isIgnoreHiddenFiles() {
        return options.ignoreHiddenFiles;
    }

    /**
     * Whether hidden files in directories should be ignored.
     * Defaults to true
     */
    public void setIgnoreHiddenFiles(boolean ignoreHiddenFiles) {
        options.ignoreHiddenFiles = ignoreHiddenFiles;
    }

    public boolean isAddRemoveLinks() {
        return options.addRemoveLinks;
    }

    /**
     * If true, this will add a link to every file preview to remove or cancel (if already uploading) the file.
     * The dictCancelUpload, dictCancelUploadConfirmation and dictRemoveFile options are used for the wording.
     * Defaults to false
     */
    public void setAddRemoveLinks(boolean addRemoveLinks) {
        options.addRemoveLinks = addRemoveLinks;
    }

    public Object getHiddenInputContainer() {
        return options.hiddenInputContainer;
    }

    /**
     * This is the element the hidden input field (which is used when clicking on the dropzone to trigger file selection)
     * will be appended to. This might be important in case you use frameworks to switch the content of your page.
     * <p>
     * Can be a selector string, or an element directly.
     * Defaults to "body"
     */
    public void setHiddenInputContainer(Object hiddenInputContainer) {
        options.hiddenInputContainer = hiddenInputContainer;
    }

    public Object getCapture() {
        return options.capture;
    }

    /**
     * If null, no capture type will be specified If camera, mobile devices will skip the file selection and choose camera
     * If microphone, mobile devices will skip the file selection and choose the microphone If camcorder, mobile devices
     * will skip the file selection and choose the camera in video mode On apple devices multiple must be set to false.
     * AcceptedFiles may need to be set to an appropriate mime type (e.g. "image/*", "audio/*", or "video/*").
     * <p>
     * Defaults to null
     */
    public void setCapture(Object capture) {
        options.capture = capture;
    }

    public Functions.Func1<File> getRenameFile() {
        return options.renameFile;
    }

    /**
     * A function that is invoked before the file is uploaded to the server and renames the file. This function gets
     * the File as argument and can use the file.name. The actual name of the file that gets used during the upload
     * can be accessed through file.upload.filename.
     * Defaults to null
     */
    public void setRenameFile(Functions.Func1<File> renameFile) {
        options.renameFile = renameFile;
    }

    public boolean isForceFallback() {
        return options.forceFallback;
    }

    /**
     * If true the fallback will be forced. This is very useful to test your server implementations first and make sure
     * that everything works as expected without dropzone if you experience problems, and to test how your fallbacks will look.
     * Defaults to false
     */
    public void setForceFallback(boolean forceFallback) {
        options.forceFallback = forceFallback;
    }

    @Override
    public HandlerRegistration addAddedFileHandler(final AddedFileEvent.AddedFileHandler<UploadFile> handler) {
        return addHandler((AddedFileEvent.AddedFileHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onAddedFile(event);
            }
        }, AddedFileEvent.getType());
    }

    @Override
    public HandlerRegistration addRemovedFileHandler(final RemovedFileEvent.RemovedFileHandler<UploadFile> handler) {
        return addHandler((RemovedFileEvent.RemovedFileHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onRemovedFile(event);
            }
        }, RemovedFileEvent.getType());
    }

    @Override
    public HandlerRegistration addErrorHandler(final ErrorEvent.ErrorHandler<UploadFile> handler) {
        return addHandler((ErrorEvent.ErrorHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onError(event);
            }
        }, ErrorEvent.getType());
    }

    @Override
    public HandlerRegistration addUnauthorizedHandler(final UnauthorizedEvent.UnauthorizedHandler<UploadFile> handler) {
        return addHandler((UnauthorizedEvent.UnauthorizedHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onUnauthorized(event);
            }
        }, UnauthorizedEvent.getType());
    }

    @Override
    public HandlerRegistration addTotalUploadProgressHandler(final TotalUploadProgressEvent.TotalUploadProgressHandler handler) {
        return addHandler(event -> {
            if (isEnabled()) {
                handler.onTotalUploadProgress(event);
            }
        }, TotalUploadProgressEvent.TYPE);
    }

    @Override
    public HandlerRegistration addCurrentUploadProgressHandler(CurrentUploadProgressEvent.CurrentUploadProgressHandler handler) {
        return addHandler(event -> {
            if (isEnabled()) {
                handler.onCurrentUploadProgress(event);
            }
        }, CurrentUploadProgressEvent.TYPE);
    }

    @Override
    public HandlerRegistration addSendingHandler(final SendingEvent.SendingHandler<UploadFile> handler) {
        return addHandler((SendingEvent.SendingHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onSending(event);
            }
        }, SendingEvent.getType());
    }

    @Override
    public HandlerRegistration addSuccessHandler(final SuccessEvent.SuccessHandler<UploadFile> handler) {
        return addHandler((SuccessEvent.SuccessHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onSuccess(event);
            }
        }, SuccessEvent.getType());
    }

    @Override
    public HandlerRegistration addCompleteHandler(final CompleteEvent.CompleteHandler<UploadFile> handler) {
        return addHandler((CompleteEvent.CompleteHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onComplete(event);
            }
        }, CompleteEvent.getType());
    }

    @Override
    public HandlerRegistration addCanceledHandler(final CanceledEvent.CanceledHandler<UploadFile> handler) {
        return addHandler((CanceledEvent.CanceledHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onCanceled(event);
            }
        }, CanceledEvent.getType());
    }

    @Override
    public HandlerRegistration addMaxFilesReachHandler(final MaxFilesReachedEvent.MaxFilesReachedHandler<UploadFile> handler) {
        return addHandler((MaxFilesReachedEvent.MaxFilesReachedHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onMaxFilesReached(event);
            }
        }, MaxFilesReachedEvent.getType());
    }

    @Override
    public HandlerRegistration addMaxFilesExceededHandler(final MaxFilesExceededEvent.MaxFilesExceededHandler<UploadFile> handler) {
        return addHandler((MaxFilesExceededEvent.MaxFilesExceededHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onMaxFilesExceeded(event);
            }
        }, MaxFilesExceededEvent.getType());
    }

    @Override
    public HandlerRegistration addThumbnailHandler(ThumbnailEvent.ThumbnailHandler<UploadFile> handler) {
        return addHandler((ThumbnailEvent.ThumbnailHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onThumbnail(event);
            }
        }, ThumbnailEvent.getType());
    }

    @Override
    public HandlerRegistration addProcessingHandler(ProcessingEvent.ProcessingHandler<UploadFile> handler) {
        return addHandler((ProcessingEvent.ProcessingHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onProcessing(event);
            }
        }, ProcessingEvent.getType());
    }

    @Override
    public HandlerRegistration addProcessingMultipleHandler(ProcessingMultipleEvent.ProcessingMultipleHandler<List<UploadFile>> handler) {
        return addHandler((ProcessingMultipleEvent.ProcessingMultipleHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onProcessingMultiple(event);
            }
        }, ProcessingMultipleEvent.getType());
    }

    @Override
    public HandlerRegistration addSendingMultipleHandler(SendingMultipleEvent.SendingMultipleHandler<List<UploadFile>> handler) {
        return addHandler((SendingMultipleEvent.SendingMultipleHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onSendingMultiple(event);
            }
        }, SendingMultipleEvent.getType());
    }

    @Override
    public HandlerRegistration addSuccessMultipleHandler(SuccessMultipleEvent.SuccessMulttipleHandler<List<UploadFile>> handler) {
        return addHandler((SuccessMultipleEvent.SuccessMulttipleHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onSuccessMulttiple(event);
            }
        }, SuccessMultipleEvent.getType());
    }

    @Override
    public HandlerRegistration addCompleteMultipleHandler(CompleteMultipleEvent.CompleteMulttipleHandler<List<UploadFile>> handler) {
        return addHandler((CompleteMultipleEvent.CompleteMulttipleHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onCompleteMulttiple(event);
            }
        }, CompleteMultipleEvent.getType());
    }

    @Override
    public HandlerRegistration addCanceledMultipleHandler(CanceledMultipleEvent.CanceledMulttipleHandler<List<UploadFile>> handler) {
        return addHandler((CanceledMultipleEvent.CanceledMulttipleHandler<UploadFile>) event -> {
            if (isEnabled()) {
                handler.onCanceledMulttiple(event);
            }
        }, CanceledMultipleEvent.getType());
    }

    @Override
    public HandlerRegistration addResetHandler(ResetEvent.ResetHandler handler) {
        return addHandler(event -> {
            if (isEnabled()) {
                handler.onReset(event);
            }
        }, ResetEvent.getType());
    }

    @Override
    public HandlerRegistration addQueueCompleteHandler(QueueCompleteEvent.QueueCompleteHandler handler) {
        return addHandler(event -> {
            if (isEnabled()) {
                handler.onQueueComplete(event);
            }
        }, QueueCompleteEvent.getType());
    }
}
