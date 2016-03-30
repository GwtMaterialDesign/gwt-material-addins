package gwt.material.design.addins.client.fileuploader.base;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.dnd.events.DragEndEvent;
import gwt.material.design.addins.client.dnd.events.DragStartEvent;
import gwt.material.design.addins.client.fileuploader.events.*;

public interface HasFileUpload {

    /**
     * The user dropped something onto the dropzone
     * @param handler
     */
    HandlerRegistration addDropHandlert(DropEvent.DropHandler handler);

    void fireDropEvent();

    /**
     * The user started to drag anywhere
     * @param handler
     */
    HandlerRegistration addDragStartHandler(DragStartEvent.DragStartHandler handler);

    void fireDragStartEvent();

    /**
     * Dragging has ended
     * @param handler
     */
    HandlerRegistration addDragEndHandler(DragEndEvent.DragEndHandler handler);

    void fireDragEndEvent();

    /**
     * The user dragged a file onto the Dropzone
     * @param handler
     */
    HandlerRegistration addDragEnterHandler(DragEnterEvent.DragEnterHandler handler);

    void fireDragEnterEvent();

    /**
     * The user is dragging a file over the Dropzone
     * @param handler
     */
    HandlerRegistration addDragOverHandler(DragOverEvent.DragOverHandler handler);

    void fireDragOverEvent();

    /**
     * The user is dragging a file over the Dropzone
     * @param handler
     */
    HandlerRegistration addDragLeaveHandler(DragLeaveEvent.DragLeaveHandler handler);

    void fireDragLeaveEvent();

    /**
     * When a file is added to the list
     * @param handler
     */
    HandlerRegistration addAddedFileHandler(AddedFileEvent.AddedFileHandler handler);

    void fireAddedFileEvent();

    /**
     * Called whenever a file is removed from the list. You can listen to this and delete the file from your server if you want to.
     * @param handler
     */
    HandlerRegistration addRemovedFileHandler(RemovedFileEvent.RemovedFileHandler handler);

    void fireRemovedFileEvent();

    /**
     * An error occured. Receives the errorMessage as second parameter and if the error was due to the XMLHttpRequest the xhr object as third.
     * @param handler
     */
    HandlerRegistration addErrorHandler(ErrorEvent.ErrorHandler handler);

    void fireErrorEvent();

    /**
     * Called just before each file is sent. Gets the xhr object and the formData objects as second and third parameters, so you can modify them (for example to add a CSRF token) or add additional data.
     * @param handler
     */
    HandlerRegistration addSendingHandler(SendingEvent.SendingHandler handler);

    void fireSendingEvent();

    /**
     * The file has been uploaded successfully. Gets the server response as second argument. (This event was called finished previously)
     * @param handler
     */
    HandlerRegistration addSuccessHandler(SuccessEvent.SuccessHandler handler);

    void fireSuccessEvent();

    /**
     * Called when the upload was either successful or erroneous.
     * @param handler
     */
    HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler);

    void fireCompleteEvent();

    /**
     * Called when a file upload gets canceled.
     * @param handler
     */
    HandlerRegistration addCancelHandler(CanceledEvent.CanceledHandler handler);

    void fireCancelEvent();

    /**
     * Called when the number of files accepted reaches the maxFiles limit.
     * @param handler
     */
    HandlerRegistration addMaxFilesReachHandler(MaxFilesReachedEvent.MaxFilesReachedHandler handler);

    void fireMaxFilesReachEvent();

    /**
     * Called for each file that has been rejected because the number of files exceeds the maxFiles limit.
     * @param handler
     */
    HandlerRegistration addMaxFilesExceededHandler(MaxFilesExceededEvent.MaxFilesExceededHandler handler);

    void fireMaxFilesExceededEvent();
}
