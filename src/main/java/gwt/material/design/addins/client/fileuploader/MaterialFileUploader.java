package gwt.material.design.addins.client.fileuploader;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dnd.events.DragEndEvent;
import gwt.material.design.addins.client.dnd.events.DragStartEvent;
import gwt.material.design.addins.client.fileuploader.base.HasFileUpload;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.base.UploadResponse;
import gwt.material.design.addins.client.fileuploader.constants.FileMethod;
import gwt.material.design.addins.client.fileuploader.events.AddedFileEvent;
import gwt.material.design.addins.client.fileuploader.events.CanceledEvent;
import gwt.material.design.addins.client.fileuploader.events.CompleteEvent;
import gwt.material.design.addins.client.fileuploader.events.DragEnterEvent;
import gwt.material.design.addins.client.fileuploader.events.DragLeaveEvent;
import gwt.material.design.addins.client.fileuploader.events.DragOverEvent;
import gwt.material.design.addins.client.fileuploader.events.DropEvent;
import gwt.material.design.addins.client.fileuploader.events.ErrorEvent;
import gwt.material.design.addins.client.fileuploader.events.MaxFilesExceededEvent;
import gwt.material.design.addins.client.fileuploader.events.MaxFilesReachedEvent;
import gwt.material.design.addins.client.fileuploader.events.RemovedFileEvent;
import gwt.material.design.addins.client.fileuploader.events.SendingEvent;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import gwt.material.design.addins.client.fileuploader.events.TotalUploadProgressEvent;
import gwt.material.design.addins.client.fileuploader.events.UnauthorizedEvent;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Display;
import java.util.Date;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

// @formatter:off

/**
 * Custom file uploader with Dnd support with the help of dropzone.js. It has
 * multiple feature just like the GWT File Uploader core widget. <h3>XML
 * Namespace Declaration</h3>
 * <p>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * <ma:fileuploader.MaterialFileUploader url="/file/upload"/>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a
 * href="http://gwtmaterialdesign.github.io/gwt-material-demo/#fileuploader">File
 * Uploader</a>
 */
// @formatter:on
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

    private String url; // Has to be specified on elements other than form (or
    // when the form doesn't have an action attribute).
    private int maxFileSize = 20; // 20MB by default for max file size
    private boolean autoQueue = true;
    private FileMethod method = FileMethod.POST; // Defaults to "post" and can
    // be changed to "put" if
    // necessary.
    private int maxFiles = 100; // If the number of files you upload exceeds,
    // the event maxfilesexceeded will be called. By
    // default it's 100 files.
    private String acceptedFiles = ""; // The default implementation of accept
    // checks the file's mime type or
    // extension against this list. This is
    // a comma separated list of mime types
    // or file extensions. Eg.:
    // image/*,application/pdf,.psd
    private String clickable = "";
    private MaterialUploadPreview uploadPreview = new MaterialUploadPreview();
    private boolean preview = true;
    private boolean initialize = false;
    private boolean withCredentials = false;

    public MaterialFileUploader() {
        super(Document.get().createDivElement(), "fileuploader");
        setId("zdrop");
        add(uploadPreview);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if (!isInitialize()) {
            initDropzone();
            setInitialize(true);
        }
    }

    @Override
    public void add(Widget child) {
        super.add(child);
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
        initDropzone(getElement(), uploadPreview.getUploadCollection().getItem().getElement(), previews, uploadPreview.getElement(), uploadPreview.getUploadHeader().getUploadedFiles().getElement(),
                getUrl(), getMaxFileSize(), getMaxFiles(), getMethod().getCssName(), isAutoQueue(), getAcceptedFiles(), getClickable(), preview, isWithCredentials());
    }

    /**
     * Intialize the dropzone component with element and form url to provide a
     * dnd feature for the file upload
     *
     * @param e
     * @param url
     */
    private native void initDropzone(Element e, Element template, String previews, Element uploadPreview, Element uploadedFiles, String url, int maxFileSize, int maxFiles, String method,
            boolean autoQueue, String acceptedFiles, String clickable, boolean preview, boolean withCredentials) /*-{
        var that = this;
        $wnd.jQuery(document).ready(function () {
            var previewNode = $wnd.jQuery(template);
            var previewContainer = $wnd.jQuery("#" + previews).html();
            var globalResponse = "";
            previewNode.id = "";
            var previewTemplate = previewNode.parent().html();

            var totalFiles = 0;
            var zdrop = new $wnd.Dropzone(e, {
                url: url,
                maxFilesize: maxFileSize,
                method: method,
                maxFiles: maxFiles,
                previewTemplate: previewTemplate,
                acceptedFiles: acceptedFiles,
                autoQueue: autoQueue,
                previewsContainer: "#" + previews,
                clickable: "#" + clickable,
                withCredentials: withCredentials
            });

            zdrop.on('drop', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDropEvent()();
                if (preview) {
                    $wnd.jQuery(e).removeClass("active");
                }
            });

            zdrop.on('dragstart', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDragStartEvent()();
            });

            zdrop.on('dragend', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDragEndEvent()();
            });

            zdrop.on('dragenter', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDragEnterEvent()();
                if (preview) {
                    $wnd.jQuery(e).addClass("active");
                }
            });

            zdrop.on('dragover', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDragOverEvent()();
            });

            zdrop.on('dragleave', function () {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireDragLeaveEvent()();
                if (preview) {
                    $wnd.jQuery(e).removeClass("active");
                }
            });

            zdrop.on("addedfile", function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireAddedFileEvent(*)(file.name, file.lastModifiedDate, file.size, file.type);
                totalFiles += 1;
                $wnd.jQuery(uploadPreview).css('visibility', 'visible');
                $wnd.jQuery(uploadedFiles).html('Uploaded files ' + totalFiles);
            });

            zdrop.on("removedfile", function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireRemovedFileEvent(*)(file.name, file.lastModifiedDate, file.size, file.type);
                totalFiles -= 1;
                $wnd.jQuery(uploadedFiles).html('Uploaded files ' + totalFiles);
            });


            zdrop.on("totaluploadprogress", function (progress) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireTotalUploadProgressEvent(*)(progress);
                var progr = document.querySelector(".progress .determinate");
                if (progr === undefined || progr === null)
                    return;
                progr.style.width = progress + "%";
            });

            zdrop.on('sending', function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireSendingEvent(*)(file.name, file.lastModifiedDate, file.size, file.type, file.xhr.status, file.xhr.statusText);
            });

            zdrop.on('error', function (file, response) {
                var code = '200';
                if (file.xhr !== undefined) {
                    code = file.xhr.status;
                }
                if (response.indexOf("401") >= 0) {
                    response = "Unautharized. Probably Your's session expired. Log in and try again.";
                    globalResponse = response;
                    that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireUnauthorizedEvent(*)(file.name, file.lastModifiedDate, file.size, file.type, file.xhr.status, file.xhr.statusText, response);
                }
                if (response.indexOf("404") >= 0) {
                    response = "There's a problem uploading your file.";
                    globalResponse = response;
                }
                if (response.indexOf("500") >= 0) {
                    response = "There's a problem uploading your file.";
                    globalResponse = response;
                }
                file.previewElement.querySelector("#error-message").innerHTML = response;
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireErrorEvent(*)(file.name, file.lastModifiedDate, file.size, file.type, file.xhr.status, file.xhr.statusText, response);
            });

            zdrop.on('success', function (file, response) {
                globalResponse = response;
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireSuccessEvent(*)(file.name, file.lastModifiedDate, file.size, file.type, file.xhr.status, file.xhr.statusText, response);
            });

            zdrop.on('complete', function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireCompleteEvent(*)(file.name, file.lastModifiedDate, file.size, file.type, file.xhr.status, file.xhr.statusText, globalResponse);
            });

            zdrop.on('canceled', function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireCancelEvent(*)(file.name, file.lastModifiedDate, file.size, file.type);
            });

            zdrop.on('maxfilesreached', function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireMaxFilesReachEvent(*)(file.name, file.lastModifiedDate, file.size, file.type);
            });

            zdrop.on('maxfilesexceeded', function (file) {
                that.@gwt.material.design.addins.client.fileuploader.MaterialFileUploader::fireMaxFilesExceededEvent(*)(file.name, file.lastModifiedDate, file.size, file.type);
                Materialize.toast('You have reached the maximum files to be uploaded.', 4000);
            });
        });
    }-*/;

    /**
     * Get the form url
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the form url e.g /file/post
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the maximum file size value of the uploader
     *
     * @return
     */
    public int getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * Set the maximum file size of the uploader
     *
     * @param maxFileSize
     */
    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    /**
     * Check whether it's auto queue or not
     *
     * @return
     */
    public boolean isAutoQueue() {
        return autoQueue;
    }

    /**
     * Set the auto queue boolean value
     *
     * @param autoQueue
     */
    public void setAutoQueue(boolean autoQueue) {
        this.autoQueue = autoQueue;
    }

    /**
     * Get the method param of file uploader
     *
     * @return
     */
    public FileMethod getMethod() {
        return method;
    }

    /**
     * Set the method param of file upload (POST or PUT)
     *
     * @param method
     */
    public void setMethod(FileMethod method) {
        this.method = method;
    }

    /**
     * Get the max number of files.
     *
     * @return
     */
    public int getMaxFiles() {
        return maxFiles;
    }

    /**
     * Check whether it's withCredentials or not
     *
     * @return
     */
    public boolean isWithCredentials() {
        return withCredentials;
    }

    /**
     * Set the withCredentials boolean value
     *
     * @param withCredentials
     */
    public void setWithCredentials(boolean withCredentials) {
        this.withCredentials = withCredentials;
    }

    /**
     * Set the max number of files, by default it's 100 but if you want to
     * accept only one file just set the max file to 1
     *
     * @param maxFiles
     */
    public void setMaxFiles(int maxFiles) {
        this.maxFiles = maxFiles;
    }

    /**
     * Get the accepted file string
     *
     * @return
     */
    public String getAcceptedFiles() {
        return acceptedFiles;
    }

    /**
     * Set the default implementation of accept checks the file's mime type or
     * extension against this list. This is a comma separated list of mime types
     * or file extensions. Eg.: image/*,application/pdf,.psd
     *
     * @param acceptedFiles
     */
    public void setAcceptedFiles(String acceptedFiles) {
        this.acceptedFiles = acceptedFiles;
    }


    @Override
    public HandlerRegistration addDropHandler(final DropEvent.DropHandler handler) {
        return addHandler(new DropEvent.DropHandler() {
            @Override
            public void onDrop(DropEvent event) {
                if (isEnabled()) {
                    handler.onDrop(event);
                }
            }
        }, DropEvent.TYPE);
    }

    @Override
    public void fireDropEvent() {
        DropEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragStartHandler(final DragStartEvent.DragStartHandler handler) {
        return addHandler(new DragStartEvent.DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                if (isEnabled()) {
                    handler.onDragStart(event);
                }
            }
        }, DragStartEvent.TYPE);
    }

    @Override
    public void fireDragStartEvent() {
        DragStartEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragEndHandler(final DragEndEvent.DragEndHandler handler) {
        return addHandler(new DragEndEvent.DragEndHandler() {
            @Override
            public void onDragEnd(DragEndEvent event) {
                if (isEnabled()) {
                    handler.onDragEnd(event);
                }
            }
        }, DragEndEvent.TYPE);
    }

    @Override
    public void fireDragEndEvent() {
        DragEndEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragEnterHandler(final DragEnterEvent.DragEnterHandler handler) {
        return addHandler(new DragEnterEvent.DragEnterHandler() {
            @Override
            public void onDragEnter(DragEnterEvent event) {
                if (isEnabled()) {
                    handler.onDragEnter(event);
                }
            }
        }, DragEnterEvent.TYPE);
    }

    @Override
    public void fireDragEnterEvent() {
        DragEnterEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragOverHandler(final DragOverEvent.DragOverHandler handler) {
        return addHandler(new DragOverEvent.DragOverHandler() {
            @Override
            public void onDragOver(DragOverEvent event) {
                if (isEnabled()) {
                    handler.onDragOver(event);
                }
            }
        }, DragOverEvent.TYPE);
    }

    @Override
    public void fireDragOverEvent() {
        DragOverEvent.fire(this);
    }

    @Override
    public HandlerRegistration addDragLeaveHandler(final DragLeaveEvent.DragLeaveHandler handler) {
        return addHandler(new DragLeaveEvent.DragLeaveHandler() {
            @Override
            public void onDragLeave(DragLeaveEvent event) {
                if (isEnabled()) {
                    handler.onDragLeave(event);
                }
            }
        }, DragLeaveEvent.TYPE);
    }

    @Override
    public void fireDragLeaveEvent() {
        DragLeaveEvent.fire(this);
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
    public void fireAddedFileEvent(String fileName, String lastModified, String size, String type) {
        AddedFileEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
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
    public void fireRemovedFileEvent(String fileName, String lastModified, String size, String type) {
        RemovedFileEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
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
    public void fireUnauthorizedEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage, String responseBody) {
        UnauthorizedEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type), new UploadResponse(responseCode, responseMessage, responseBody));
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
    public void fireErrorEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage, String responseBody) {
        ErrorEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type), new UploadResponse(responseCode, responseMessage, responseBody));
    }

    @Override
    public HandlerRegistration addTotalUploadProgressHandler(final TotalUploadProgressEvent.TotalUploadProgressHandler handler) {
        return addHandler(new TotalUploadProgressEvent.TotalUploadProgressHandler() {
            @Override
            public void onTotalUploadProgress(TotalUploadProgressEvent event) {
                if (isEnabled()) {
                    handler.onTotalUploadProgress(event);
                }
            }
        }, TotalUploadProgressEvent.TYPE);
    }

    @Override
    public void fireTotalUploadProgressEvent(double progress) {
        TotalUploadProgressEvent.fire(this, progress);
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
    public void fireSendingEvent(String fileName, String lastModified, String size, String type) {
        SendingEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
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
    public void fireSuccessEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage, String responseBody) {
        SuccessEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type), new UploadResponse(responseCode, responseMessage, responseBody));
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
    public void fireCompleteEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage, String responseBody) {
        CompleteEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type), new UploadResponse(responseCode, responseMessage, responseBody));
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
    public void fireCancelEvent(String fileName, String lastModified, String size, String type) {
        CanceledEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
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
    public void fireMaxFilesReachEvent(String fileName, String lastModified, String size, String type) {
        MaxFilesReachedEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
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

    @Override
    public void fireMaxFilesExceededEvent(String fileName, String lastModified, String size, String type) {
        MaxFilesReachedEvent.fire(this, new UploadFile(fileName, new Date(lastModified), Double.parseDouble(size), type));
    }

    public boolean isPreview() {
        return preview;
    }

    public void setPreview(boolean preview) {
        this.preview = preview;
    }

    /**
     * Check wether the component has been initialized
     *
     * @return
     */
    public boolean isInitialize() {
        return initialize;
    }

    /**
     * Set the initialization of the component
     *
     * @param initialize
     */
    public void setInitialize(boolean initialize) {
        this.initialize = initialize;
    }
}