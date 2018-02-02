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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.fileuploader.base.HasFileUpload;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.base.UploadResponse;
import gwt.material.design.addins.client.fileuploader.constants.FileMethod;
import gwt.material.design.addins.client.fileuploader.constants.FileUploaderEvents;
import gwt.material.design.addins.client.fileuploader.events.*;
import gwt.material.design.addins.client.fileuploader.js.Dropzone;
import gwt.material.design.addins.client.fileuploader.js.File;
import gwt.material.design.addins.client.fileuploader.js.JsFileUploaderOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.events.*;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.Date;

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
public class MaterialFileUploader extends MaterialWidget implements JsLoader, HasFileUpload<UploadFile> {

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
    private String globalResponse = "";
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
     * dnd feature for the file upload
     *
     * @param e
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

        uploader.on(FileUploaderEvents.ADDED_FILE, file -> {
            AddedFileEvent.fire(this, convertUploadFile(file));
            totalFiles++;

            if (isPreview()) {
                $(uploadPreview).css("visibility", "visible");
                $(uploadedFiles).html("Uploaded files " + totalFiles);
                getUploadPreview().getUploadHeader().getProgress().setPercent(0);
            }
        });

        uploader.on(FileUploaderEvents.REMOVED_FILE, file -> {
            RemovedFileEvent.fire(this, convertUploadFile(file));
            totalFiles -= 1;
            $(uploadedFiles).html("Uploaded files " + totalFiles);
        });

        uploader.on("error", (file, response) -> {
            String code = "200";
            if (file.xhr != null) {
                code = file.xhr.status;
            }

            if (response.indexOf("401") >= 0) {
                response = "Unauthorized. Your session may have expired. Log in and try again.";
                globalResponse = response;
                UnauthorizedEvent.fire(this, convertUploadFile(file), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
            }

            if (response.indexOf("404") >= 0) {
                response = "There is a problem uploading your file.";
                globalResponse = response;
            }

            if (response.indexOf("500") >= 0) {
                response = "There is a problem uploading your file.";
                globalResponse = response;
            }

            $(file.previewElement).find("#error-message").html(response);
            ErrorEvent.fire(this, convertUploadFile(file), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
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

        uploader.on(FileUploaderEvents.SENDING, file -> {
            SendingEvent.fire(this, convertUploadFile(file), new UploadResponse(file.xhr.status, file.xhr.statusText));
        });

        uploader.on(FileUploaderEvents.SUCCESS, (file, response) -> {
            globalResponse = response;
            SuccessEvent.fire(this, convertUploadFile(file), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
        });

        uploader.on(FileUploaderEvents.COMPLETE, file -> {
            CompleteEvent.fire(this, convertUploadFile(file), new UploadResponse(file.xhr.status, file.xhr.statusText, globalResponse));
        });

        uploader.on(FileUploaderEvents.CANCELED, file -> {
            CanceledEvent.fire(this, convertUploadFile(file));
        });

        uploader.on(FileUploaderEvents.MAX_FILES_REACHED, file -> {
            MaxFilesReachedEvent.fire(this, convertUploadFile(file));
        });

        uploader.on(FileUploaderEvents.MAX_FILES_EXCEEDED, file -> {
            MaterialToast.fireToast("You have reached the maximum files to be uploaded.");
            MaxFilesExceededEvent.fire(this, convertUploadFile(file));
        });
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
        Date lastModifiedDate = new Date();
        // Avoid parsing error on last modified date
        if (file.lastModifiedDate != null && !file.lastModifiedDate.isEmpty()) {
            lastModifiedDate = new Date(file.lastModifiedDate);
        }
        return new UploadFile(file.name, lastModifiedDate, Double.parseDouble(file.size), file.type);
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

    @Override
    public HandlerRegistration addAddedFileHandler(final AddedFileEvent.AddedFileHandler<UploadFile> handler) {
        return addHandler(new AddedFileEvent.AddedFileHandler<UploadFile>() {
            @Override
            public void onAddedFile(AddedFileEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onAddedFile(event);
                }
            }
        }, AddedFileEvent.getType());
    }

    @Override
    public HandlerRegistration addRemovedFileHandler(final RemovedFileEvent.RemovedFileHandler<UploadFile> handler) {
        return addHandler(new RemovedFileEvent.RemovedFileHandler<UploadFile>() {
            @Override
            public void onRemovedFile(RemovedFileEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onRemovedFile(event);
                }
            }
        }, RemovedFileEvent.getType());
    }

    @Override
    public HandlerRegistration addErrorHandler(final ErrorEvent.ErrorHandler<UploadFile> handler) {
        return addHandler(new ErrorEvent.ErrorHandler<UploadFile>() {
            @Override
            public void onError(ErrorEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onError(event);
                }
            }
        }, ErrorEvent.getType());
    }

    @Override
    public HandlerRegistration addUnauthorizedHandler(final UnauthorizedEvent.UnauthorizedHandler<UploadFile> handler) {
        return addHandler(new UnauthorizedEvent.UnauthorizedHandler<UploadFile>() {
            @Override
            public void onUnauthorized(UnauthorizedEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onUnauthorized(event);
                }
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
        return addHandler(new SendingEvent.SendingHandler<UploadFile>() {
            @Override
            public void onSending(SendingEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onSending(event);
                }
            }
        }, SendingEvent.getType());
    }

    @Override
    public HandlerRegistration addSuccessHandler(final SuccessEvent.SuccessHandler<UploadFile> handler) {
        return addHandler(new SuccessEvent.SuccessHandler<UploadFile>() {
            @Override
            public void onSuccess(SuccessEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onSuccess(event);
                }
            }
        }, SuccessEvent.getType());
    }

    @Override
    public HandlerRegistration addCompleteHandler(final CompleteEvent.CompleteHandler<UploadFile> handler) {
        return addHandler(new CompleteEvent.CompleteHandler<UploadFile>() {
            @Override
            public void onComplete(CompleteEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onComplete(event);
                }
            }
        }, CompleteEvent.getType());
    }

    @Override
    public HandlerRegistration addCancelHandler(final CanceledEvent.CanceledHandler<UploadFile> handler) {
        return addHandler(new CanceledEvent.CanceledHandler<UploadFile>() {
            @Override
            public void onCanceled(CanceledEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onCanceled(event);
                }
            }
        }, CanceledEvent.getType());
    }

    @Override
    public HandlerRegistration addMaxFilesReachHandler(final MaxFilesReachedEvent.MaxFilesReachedHandler<UploadFile> handler) {
        return addHandler(new MaxFilesReachedEvent.MaxFilesReachedHandler<UploadFile>() {
            @Override
            public void onMaxFilesReached(MaxFilesReachedEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onMaxFilesReached(event);
                }
            }
        }, MaxFilesReachedEvent.getType());
    }

    @Override
    public HandlerRegistration addMaxFilesExceededHandler(final MaxFilesExceededEvent.MaxFilesExceededHandler<UploadFile> handler) {
        return addHandler(new MaxFilesExceededEvent.MaxFilesExceededHandler<UploadFile>() {
            @Override
            public void onMaxFilesExceeded(MaxFilesExceededEvent<UploadFile> event) {
                if (isEnabled()) {
                    handler.onMaxFilesExceeded(event);
                }
            }
        }, MaxFilesExceededEvent.getType());
    }
}