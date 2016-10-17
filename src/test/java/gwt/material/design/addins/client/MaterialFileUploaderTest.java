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
package gwt.material.design.addins.client;

import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.MaterialUploadCollection;
import gwt.material.design.addins.client.fileuploader.MaterialUploadHeader;
import gwt.material.design.addins.client.fileuploader.MaterialUploadPreview;
import gwt.material.design.addins.client.fileuploader.constants.FileMethod;
import gwt.material.design.addins.client.fileuploader.events.*;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.events.*;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.html.Span;

/**
 * Test case for file uploader component
 *
 * @author kevzlou7979
 */
public class MaterialFileUploaderTest extends MaterialAddinsTest {

    public void init() {
        MaterialFileUploader fileUploader = new MaterialFileUploader();
        checkWidget(fileUploader);
        checkStructure(fileUploader);
        checkFileUploaderEvents(fileUploader);
        checkProperties(fileUploader);
    }

    protected <T extends MaterialFileUploader> void checkProperties(T fileUploader) {
        fileUploader.setAcceptedFiles("jpg");
        assertEquals(fileUploader.getAcceptedFiles(), "jpg");
        fileUploader.setUrl("someurl");
        assertEquals(fileUploader.getUrl(), "someurl");
        fileUploader.setMaxFiles(2);
        assertEquals(fileUploader.getMaxFiles(), 2);
        fileUploader.setMaxFileSize(100);
        assertEquals(fileUploader.getMaxFileSize(), 100);
        fileUploader.setClickable("button");
        assertEquals(fileUploader.getClickable(), "button");
        fileUploader.setMethod(FileMethod.POST);
        assertEquals(fileUploader.getMethod(), FileMethod.POST);
        fileUploader.setMethod(FileMethod.PUT);
        assertEquals(fileUploader.getMethod(), FileMethod.PUT);
        fileUploader.setAutoQueue(true);
        assertTrue(fileUploader.isAutoQueue());
        fileUploader.setAutoQueue(false);
        assertFalse(fileUploader.isAutoQueue());
        fileUploader.setPreview(true);
        assertTrue(fileUploader.isPreview());
        fileUploader.setPreview(false);
        assertFalse(fileUploader.isPreview());
        fileUploader.setWithCredentials(true);
        assertTrue(fileUploader.isWithCredentials());
        fileUploader.setWithCredentials(false);
        assertFalse(fileUploader.isWithCredentials());
    }

    protected <T extends MaterialFileUploader> void checkFileUploaderEvents(T fileUploader) {
        fileUploader.setEnabled(true);
        // Drag Move
        final boolean[] isDragMoveFired = {false};
        fileUploader.addDragMoveHandler(dragMoveEvent -> {
            isDragMoveFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragMoveEvent.DragMoveHandler>() {
            @Override
            public Type<DragMoveEvent.DragMoveHandler> getAssociatedType() {
                return DragMoveEvent.getType();
            }

            @Override
            protected void dispatch(DragMoveEvent.DragMoveHandler eventHandler) {
                eventHandler.onDragMove(null);
            }
        });
        assertTrue(isDragMoveFired[0]);
        // Drag Over
        final boolean[] isDragOverFired = {false};
        fileUploader.addDragOverHandler(dragOverEvent -> {
            isDragOverFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragOverEvent.DragOverHandler>() {
            @Override
            public Type<DragOverEvent.DragOverHandler> getAssociatedType() {
                return DragOverEvent.getType();
            }

            @Override
            protected void dispatch(DragOverEvent.DragOverHandler eventHandler) {
                eventHandler.onDragOver(null);
            }
        });
        assertTrue(isDragOverFired[0]);
        // Drag Start
        final boolean[] isDragStartFired = {false};
        fileUploader.addDragStartHandler(dragStartEvent -> {
            isDragStartFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragStartEvent.DragStartHandler>() {
            @Override
            public Type<DragStartEvent.DragStartHandler> getAssociatedType() {
                return DragStartEvent.getType();
            }

            @Override
            protected void dispatch(DragStartEvent.DragStartHandler eventHandler) {
                eventHandler.onDragStart(null);
            }
        });
        assertTrue(isDragStartFired[0]);
        // Drag End
        final boolean[] isDragEndFired = {false};
        fileUploader.addDragEndHandler(dragEndEvent -> {
            isDragEndFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragEndEvent.DragEndHandler>() {
            @Override
            public Type<DragEndEvent.DragEndHandler> getAssociatedType() {
                return DragEndEvent.getType();
            }

            @Override
            protected void dispatch(DragEndEvent.DragEndHandler eventHandler) {
                eventHandler.onDragEnd(null);
            }
        });
        assertTrue(isDragEndFired[0]);
        // Drag Enter
        final boolean[] isDragEnterFired = {false};
        fileUploader.addDragEnterHandler(dragEnterEvent -> {
            isDragEnterFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragEnterEvent.DragEnterHandler>() {
            @Override
            public Type<DragEnterEvent.DragEnterHandler> getAssociatedType() {
                return DragEnterEvent.getType();
            }

            @Override
            protected void dispatch(DragEnterEvent.DragEnterHandler eventHandler) {
                eventHandler.onDragEnter(null);
            }
        });
        assertTrue(isDragEnterFired[0]);
        // Drag Leave
        final boolean[] isDragLeaveFired = {false};
        fileUploader.addDragLeaveHandler(dragLeaveEvent -> {
            isDragLeaveFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<DragLeaveEvent.DragLeaveHandler>() {
            @Override
            public Type<DragLeaveEvent.DragLeaveHandler> getAssociatedType() {
                return DragLeaveEvent.getType();
            }

            @Override
            protected void dispatch(DragLeaveEvent.DragLeaveHandler eventHandler) {
                eventHandler.onDragLeave(null);
            }
        });
        assertTrue(isDragLeaveFired[0]);
        // AddedFile Event
        final boolean[] isAddedFileFired = {false};
        fileUploader.addAddedFileHandler(event -> {
            isAddedFileFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<AddedFileEvent.AddedFileHandler<?>>() {
            @Override
            public Type<AddedFileEvent.AddedFileHandler<?>> getAssociatedType() {
                return AddedFileEvent.getType();
            }

            @Override
            protected void dispatch(AddedFileEvent.AddedFileHandler<?> eventHandler) {
                eventHandler.onAddedFile(null);
            }
        });
        assertTrue(isAddedFileFired[0]);
        // RemovedFile Event
        final boolean[] isRemovedFileFired = {false};
        fileUploader.addRemovedFileHandler(event -> {
            isRemovedFileFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<RemovedFileEvent.RemovedFileHandler<?>>() {
            @Override
            public Type<RemovedFileEvent.RemovedFileHandler<?>> getAssociatedType() {
                return RemovedFileEvent.getType();
            }

            @Override
            protected void dispatch(RemovedFileEvent.RemovedFileHandler<?> eventHandler) {
                eventHandler.onRemovedFile(null);
            }
        });
        assertTrue(isRemovedFileFired[0]);
        // Error Event
        final boolean[] isErrorFired = {false};
        fileUploader.addErrorHandler(event -> {
            isErrorFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<ErrorEvent.ErrorHandler<?>>() {
            @Override
            public Type<ErrorEvent.ErrorHandler<?>> getAssociatedType() {
                return ErrorEvent.getType();
            }

            @Override
            protected void dispatch(ErrorEvent.ErrorHandler<?> eventHandler) {
                eventHandler.onError(null);
            }
        });
        assertTrue(isErrorFired[0]);
        // TotalUploadProgress Event
        final boolean[] isTotalUploadProgressFired = {false};
        fileUploader.addTotalUploadProgressHandler(event -> {
            isTotalUploadProgressFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<TotalUploadProgressEvent.TotalUploadProgressHandler>() {
            @Override
            public Type<TotalUploadProgressEvent.TotalUploadProgressHandler> getAssociatedType() {
                return TotalUploadProgressEvent.TYPE;
            }

            @Override
            protected void dispatch(TotalUploadProgressEvent.TotalUploadProgressHandler eventHandler) {
                eventHandler.onTotalUploadProgress(null);
            }
        });
        assertTrue(isTotalUploadProgressFired[0]);
        // CurrentUploadProgress Event
        final boolean[] isCurrentUploadProgressFired = {false};
        fileUploader.addCurrentUploadProgressHandler(event -> {
            isCurrentUploadProgressFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<CurrentUploadProgressEvent.CurrentUploadProgressHandler>() {
            @Override
            public Type<CurrentUploadProgressEvent.CurrentUploadProgressHandler> getAssociatedType() {
                return CurrentUploadProgressEvent.TYPE;
            }

            @Override
            protected void dispatch(CurrentUploadProgressEvent.CurrentUploadProgressHandler eventHandler) {
                eventHandler.onCurrentUploadProgress(null);
            }
        });
        assertTrue(isCurrentUploadProgressFired[0]);
        // Sending Event
        final boolean[] isSendingFired = {false};
        fileUploader.addSendingHandler(event -> {
            isSendingFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<SendingEvent.SendingHandler<?>>() {
            @Override
            public Type<SendingEvent.SendingHandler<?>> getAssociatedType() {
                return SendingEvent.getType();
            }

            @Override
            protected void dispatch(SendingEvent.SendingHandler<?> eventHandler) {
                eventHandler.onSending(null);
            }
        });
        assertTrue(isSendingFired[0]);
        // Success Event
        final boolean[] isSuccessFired = {false};
        fileUploader.addSuccessHandler(event -> {
            isSuccessFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<SuccessEvent.SuccessHandler<?>>() {
            @Override
            public Type<SuccessEvent.SuccessHandler<?>> getAssociatedType() {
                return SuccessEvent.getType();
            }

            @Override
            protected void dispatch(SuccessEvent.SuccessHandler<?> eventHandler) {
                eventHandler.onSuccess(null);
            }
        });
        assertTrue(isSuccessFired[0]);
        // Complete Event
        final boolean[] isCompleteFired = {false};
        fileUploader.addCompleteHandler(event -> {
            isCompleteFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<CompleteEvent.CompleteHandler<?>>() {
            @Override
            public Type<CompleteEvent.CompleteHandler<?>> getAssociatedType() {
                return CompleteEvent.getType();
            }

            @Override
            protected void dispatch(CompleteEvent.CompleteHandler<?> eventHandler) {
                eventHandler.onComplete(null);
            }
        });
        assertTrue(isCompleteFired[0]);
        // Canceled Event
        final boolean[] isCanceledFired = {false};
        fileUploader.addCancelHandler(event -> {
            isCanceledFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<CanceledEvent.CanceledHandler<?>>() {
            @Override
            public Type<CanceledEvent.CanceledHandler<?>> getAssociatedType() {
                return CanceledEvent.getType();
            }

            @Override
            protected void dispatch(CanceledEvent.CanceledHandler<?> eventHandler) {
                eventHandler.onCanceled(null);
            }
        });
        assertTrue(isCanceledFired[0]);
        // MaxFilesReached Event
        final boolean[] isMaxFilesReachedFired = {false};
        fileUploader.addMaxFilesReachHandler(event -> {
            isMaxFilesReachedFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<MaxFilesReachedEvent.MaxFilesReachedHandler<?>>() {
            @Override
            public Type<MaxFilesReachedEvent.MaxFilesReachedHandler<?>> getAssociatedType() {
                return MaxFilesReachedEvent.getType();
            }

            @Override
            protected void dispatch(MaxFilesReachedEvent.MaxFilesReachedHandler<?> eventHandler) {
                eventHandler.onMaxFilesReached(null);
            }
        });
        assertTrue(isMaxFilesReachedFired[0]);
        // MaxFilesExceeded Event
        final boolean[] isMaxFilesExceededFired = {false};
        fileUploader.addMaxFilesExceededHandler(event -> {
            isMaxFilesExceededFired[0] = true;
        });
        fileUploader.fireEvent(new GwtEvent<MaxFilesExceededEvent.MaxFilesExceededHandler<?>>() {
            @Override
            public Type<MaxFilesExceededEvent.MaxFilesExceededHandler<?>> getAssociatedType() {
                return MaxFilesExceededEvent.getType();
            }

            @Override
            protected void dispatch(MaxFilesExceededEvent.MaxFilesExceededHandler<?> eventHandler) {
                eventHandler.onMaxFilesExceeded(null);
            }
        });
        assertTrue(isMaxFilesExceededFired[0]);
    }

    protected <T extends MaterialFileUploader> void checkStructure(T fileUploader) {
        assertEquals(fileUploader.getWidgetCount(), 1);
        assertTrue(fileUploader.getWidget(0) instanceof MaterialUploadPreview);
        MaterialUploadPreview uploadPreview = (MaterialUploadPreview) fileUploader.getWidget(0);
        assertEquals(fileUploader.getUploadPreview(), uploadPreview);

        // Upload Header
        assertNotNull(uploadPreview.getWidget(0));
        assertTrue(uploadPreview.getWidget(0) instanceof MaterialUploadHeader);
        MaterialUploadHeader header = (MaterialUploadHeader) uploadPreview.getWidget(0);
        assertEquals(header, fileUploader.getUploadPreview().getUploadHeader());
        // Uploaded Files Label
        assertTrue(header.getWidget(0) instanceof Span);
        Span uploadedfiles = (Span) header.getWidget(0);
        assertEquals(uploadedfiles.getId(), AddinsCssName.NO_UPLOADED_FILES);
        // Close Icon
        assertTrue(header.getWidget(1) instanceof MaterialIcon);
        MaterialIcon iconClose = (MaterialIcon) header.getWidget(1);
        assertEquals(iconClose.getIconType(), IconType.CLOSE);
        assertEquals(iconClose.getId(), AddinsCssName.UPLOAD_CLOSE);
        // Minimize Icon
        assertTrue(header.getWidget(2) instanceof MaterialIcon);
        MaterialIcon iconMinimize = (MaterialIcon) header.getWidget(2);
        assertEquals(iconMinimize.getIconType(), IconType.KEYBOARD_ARROW_DOWN);
        assertEquals(iconMinimize.getId(), AddinsCssName.UPLOAD_COLAPS);
        // Total Progress
        assertTrue(header.getWidget(3) instanceof MaterialProgress);
        MaterialProgress progress = (MaterialProgress) header.getWidget(3);
        assertEquals(progress.getType(), ProgressType.DETERMINATE);
        assertEquals(progress.getId(), AddinsCssName.TOTAL_UPLOAD_PROGRESS);

        // Upload Collection
        assertNotNull(uploadPreview.getWidget(1));
        assertTrue(uploadPreview.getWidget(1) instanceof MaterialUploadCollection);
        MaterialUploadCollection collection = (MaterialUploadCollection) uploadPreview.getWidget(1);
        assertEquals(collection, fileUploader.getUploadPreview().getUploadCollection());
        assertTrue(collection.getElement().hasClassName(AddinsCssName.PREVIEWS));
        assertTrue(collection.getElement().hasClassName(CssName.CARD));

        // Collection Item
        assertTrue(collection.getWidget(0) instanceof MaterialCollectionItem);
        MaterialCollectionItem item = (MaterialCollectionItem) collection.getWidget(0);
        assertEquals(item.getId(), AddinsCssName.ZDROP_TEMPLATE);
        assertTrue(item.getElement().hasClassName(AddinsCssName.CLEARHACK));
        assertTrue(item.getElement().hasClassName(CssName.VALIGN_WRAPPER));
        assertTrue(item.getElement().hasClassName(AddinsCssName.ITEM_TEMPLATE));

        // Upload Information
        assertTrue(item.getWidget(0) instanceof MaterialWidget);
        MaterialWidget dropInfo = (MaterialWidget) item.getWidget(0);
        assertTrue(dropInfo.getElement().hasAttribute("data-dz-thumbnail"));
        assertTrue(dropInfo.getElement().hasClassName(CssName.LEFT));
        assertTrue(dropInfo.getElement().hasClassName(AddinsCssName.PV));
        assertTrue(dropInfo.getElement().hasClassName(AddinsCssName.ZDROP_INFO));
        // Name Wrapper
        assertTrue(dropInfo.getWidget(0) instanceof MaterialWidget);
        MaterialWidget nameWrapper = (MaterialWidget) dropInfo.getWidget(0);
        // Name
        assertTrue(nameWrapper.getWidget(0) instanceof Span);
        Span name = (Span) nameWrapper.getWidget(0);
        assertTrue(name.getElement().hasAttribute("data-dz-name"));
        // Size
        assertTrue(nameWrapper.getWidget(1) instanceof Span);
        Span size = (Span) nameWrapper.getWidget(1);
        assertTrue(size.getElement().hasAttribute("data-dz-size"));

        // Preview Icon
        assertTrue(dropInfo.getWidget(1) instanceof MaterialIcon);
        MaterialIcon previewIcon = (MaterialIcon) dropInfo.getWidget(1);
        assertEquals(previewIcon.getIconType(), IconType.INSERT_DRIVE_FILE);
        assertTrue(previewIcon.getElement().hasClassName(AddinsCssName.PREVIEW_ICON));
        // Upload Progress
        assertTrue(dropInfo.getWidget(2) instanceof MaterialProgress);
        MaterialProgress currentProgress = (MaterialProgress) dropInfo.getWidget(2);
        assertEquals(currentProgress.getType(), ProgressType.DETERMINATE);
        assertTrue(currentProgress.getWidget(0).getElement().hasAttribute("data-dz-uploadprogress"));
        // Error Wrapper
        assertTrue(dropInfo.getWidget(3) instanceof MaterialWidget);
        MaterialWidget errorWrapper = (MaterialWidget) dropInfo.getWidget(3);
        assertTrue(errorWrapper.getElement().hasClassName(AddinsCssName.DZ_ERROR_MESSAGE));
        assertTrue(errorWrapper.getWidget(0) instanceof Span);
        Span errorMessage = (Span) errorWrapper.getWidget(0);
        assertTrue(errorMessage.getElement().hasAttribute("data-dz-errormessage"));
        assertEquals(errorMessage.getId(), AddinsCssName.ERROR_MESSAGE);

        assertTrue(item.getWidget(1) instanceof MaterialCollectionSecondary);
        MaterialCollectionSecondary secondary = (MaterialCollectionSecondary) item.getWidget(1);
        assertTrue(secondary.getWidget(0) instanceof MaterialButton);
        MaterialButton btnClear = (MaterialButton) secondary.getWidget(0);
        assertTrue(btnClear.getElement().hasAttribute("data-dz-remove"));
        assertTrue(btnClear.getElement().hasClassName(AddinsCssName.PH));
    }
}
