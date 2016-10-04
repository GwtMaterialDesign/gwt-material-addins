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
package gwt.material.design.addins.client.fileuploader;

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
import gwt.material.design.addins.client.fileuploader.events.*;
import gwt.material.design.addins.client.fileuploader.js.Dropzone;
import gwt.material.design.addins.client.fileuploader.js.File;
import gwt.material.design.addins.client.fileuploader.js.JsFileUploaderOptions;
import gwt.material.design.client.MaterialDesignBase;
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
 */
//@formatter:on
public class MaterialFileUploader extends MaterialWidget implements HasFileUpload<UploadFile> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialFileUploaderDebugClientBundle.INSTANCE.dropzoneJsDebug());
            MaterialDesignBase.injectCss(MaterialFileUploaderDebugClientBundle.INSTANCE.dropzoneCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialFileUploaderClientBundle.INSTANCE.dropzoneJs());
            MaterialDesignBase.injectCss(MaterialFileUploaderClientBundle.INSTANCE.dropzoneCss());
        }
    }

    // Has to be specified on elements other than form (or when the form doesn't have an action attribute).
    private String url;

    // 20MB by default for max file size
    private int maxFileSize = 20;

    // Defaults to "post" and can be changed to "put" if necessary.
    private FileMethod method = FileMethod.POST;

    // If the number of files you upload exceeds, the event maxfilesexceeded will be called. By default it's 100 files.
    private int maxFiles = 100;

    // The default implementation of accept checks the file's mime type or extension against this list. This is a
    // comma separated list of mime types or file extensions. Eg.: image/*,application/pdf,.psd
    private String acceptedFiles = "";

    private String clickable = "";
    private boolean autoQueue = true;
    private boolean preview = true;
    private boolean initialize = false;
    private boolean withCredentials = false;
    private int totalFiles = 0;
    private String globalResponse = "";

    private Dropzone uploader;

    private MaterialUploadPreview uploadPreview = new MaterialUploadPreview();

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

        if (!isInitialize()) {
            initDropzone();
            setInitialize(true);
        }
    }

    public void initDropzone() {
        String previews = DOM.createUniqueId();
        uploadPreview.getUploadCollection().setId(previews);
        if (clickable.isEmpty()) {
            String clickable = DOM.createUniqueId();
            if (getWidget(1) instanceof MaterialUploadLabel) {
                MaterialUploadLabel label = (MaterialUploadLabel) getWidget(1);
                label.getIcon().setId(clickable);
            } else {
                getWidget(1).getElement().setId(clickable);
            }
            setClickable(clickable);
        }

        if (!isPreview()) {
            uploadPreview.setDisplay(Display.NONE);
        }

        initDropzone(getElement(),
                uploadPreview.getUploadCollection().getItem().getElement(),
                previews,
                uploadPreview.getElement(),
                uploadPreview.getUploadHeader().getUploadedFiles().getElement(),
                getUrl(),
                getMaxFileSize(),
                getMaxFiles(),
                getMethod().getCssName(),
                isAutoQueue(),
                getAcceptedFiles(),
                getClickable(),
                preview,
                isWithCredentials());
    }

    /**
     * Intialize the dropzone component with element and form url to provide a
     * dnd feature for the file upload
     *
     * @param e
     * @param url
     */
    protected void initDropzone(Element e, Element template, String previews, Element uploadPreview, Element uploadedFiles, String url, int maxFileSize, int maxFiles, String method, boolean autoQueue, String acceptedFiles, String clickable, boolean preview, boolean withCredentials) {
        JQueryElement previewNode = $(template);
        previewNode.asElement().setId("");
        String previewTemplate = previewNode.parent().html();

        JsFileUploaderOptions options = new JsFileUploaderOptions();
        options.url = url;
        options.maxFilesize = maxFileSize;
        options.method = method;
        options.maxFiles = maxFiles;
        options.previewTemplate = previewTemplate;
        options.acceptedFiles = acceptedFiles;
        options.autoQueue = autoQueue;
        options.previewsContainer = "#" + previews;
        options.clickable = "#" + clickable;
        options.withCredentials = withCredentials;
        uploader = new Dropzone(e, options);

        uploader.on("drop", event -> {
            fireDropEvent();
            if (preview) {
                $(e).removeClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on("dragstart", event -> {
            DragStartEvent.fire(this);
            return true;
        });

        uploader.on("dragend", event -> {
            DragEndEvent.fire(this);
            return true;
        });

        uploader.on("dragenter", event -> {
            DragEnterEvent.fire(this, null);
            if (preview) {
                $(e).addClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on("dragover", event -> {
            DragOverEvent.fire(this);
            return true;
        });

        uploader.on("dragleave", event -> {
            DragLeaveEvent.fire(this, null);
            if (preview) {
                $(e).removeClass(CssName.ACTIVE);
            }
            return true;
        });

        uploader.on("removedfile", file -> {
            RemovedFileEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type));
            totalFiles -= 1;
            $(uploadedFiles).html("Uploaded files " + totalFiles);
        });

        uploader.on("error", (file, response) -> {
            String code = "200";
            if (file.xhr != null) {
                code = file.xhr.status;
            }

            if (response.indexOf("401") >= 0) {
                response = "Unautharized. Probably Your's session expired. Log in and try again.";
                globalResponse = response;
                UnauthorizedEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
            }

            if (response.indexOf("404") >= 0) {
                response = "There's a problem uploading your file.";
                globalResponse = response;
            }

            if (response.indexOf("500") >= 0) {
                response = "There's a problem uploading your file.";
                globalResponse = response;
            }

            $(file.previewElement).find("#error-message").html(response);
            ErrorEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
        });

        uploader.on("totaluploadprogress", (progress, file, response) -> {
            TotalUploadProgressEvent.fire(this, progress);
            if ($this != null) {
                $this.find(".progress .determinate").css("width", progress + "%");
            }
        });

        uploader.on("sending", file -> {
            SendingEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type), new UploadResponse(file.xhr.status, file.xhr.statusText));
        });

        uploader.on("success", (file, response) -> {
            globalResponse = response;
            SuccessEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type), new UploadResponse(file.xhr.status, file.xhr.statusText, response));
        });

        uploader.on("complete", file -> {
            CompleteEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type), new UploadResponse(file.xhr.status, file.xhr.statusText, globalResponse));
        });

        uploader.on("complete", file -> {
            CanceledEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type));
        });

        uploader.on("maxfilesreached", file -> {
            MaxFilesReachedEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type));
        });

        uploader.on("maxfilesexceeded", file -> {
            MaterialToast.fireToast("You have reached the maximum files to be uploaded.");
            MaxFilesReachedEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type));
        });
    }

    /**
     * Get the form url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the form url e.g /file/post.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the maximum file size value of the uploader.
     */
    public int getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Set the maximum file size of the uploader.
     */
    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    /**
     * Check whether it's auto queue or not.
     */
    public boolean isAutoQueue() {
        return autoQueue;
    }

    /**
     * Set the auto queue boolean value.
     */
    public void setAutoQueue(boolean autoQueue) {
        this.autoQueue = autoQueue;
    }

    /**
     * Get the method param of file uploader.
     */
    public FileMethod getMethod() {
        return method;
    }

    /**
     * Set the method param of file upload (POST or PUT).
     */
    public void setMethod(FileMethod method) {
        this.method = method;
    }

    /**
     * Get the max number of files.
     */
    public int getMaxFiles() {
        return maxFiles;
    }

    /**
     * Check whether it's withCredentials or not.
     */
    public boolean isWithCredentials() {
        return withCredentials;
    }

    /**
     * Set the withCredentials boolean value.
     */
    public void setWithCredentials(boolean withCredentials) {
        this.withCredentials = withCredentials;
    }

    /**
     * Set the max number of files, by default it's 100 but if you want to accept only one file just
     * set the max file to 1.
     */
    public void setMaxFiles(int maxFiles) {
        this.maxFiles = maxFiles;
    }

    /**
     * Get the accepted file string.
     */
    public String getAcceptedFiles() {
        return acceptedFiles;
    }

    /**
     * Set the default implementation of accept checks the file's mime type or extension against this list.
     * This is a comma separated list of mime types or file extensions. Eg.: image/*,application/pdf,.psd.
     */
    public void setAcceptedFiles(String acceptedFiles) {
        this.acceptedFiles = acceptedFiles;
    }

    public void fireDropEvent() {
        DropEvent.fire(this, null);
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

    public void fireAddedFileEvent(File file) {
        AddedFileEvent.fire(this, new UploadFile(file.name, new Date(file.lastModifiedDate), Double.parseDouble(file.size), file.type));
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

    public String getClickable() {
        return clickable;
    }

    public void setClickable(String clickable) {
        this.clickable = clickable;
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }

    /**
     * Check whether the component has been initialized.
     */
    public boolean isInitialize() {
        return initialize;
    }

    /**
     * Set the initialization of the component.
     */
    public void setInitialize(boolean initialize) {
        this.initialize = initialize;
    }

    public void reset() {
        uploader.removeAllFiles();
    }
}