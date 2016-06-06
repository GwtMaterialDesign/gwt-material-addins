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

import gwt.material.design.addins.client.dnd.events.DragEndEvent;
import gwt.material.design.addins.client.dnd.events.DragStartEvent;
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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasFileUpload<T> extends HasHandlers {

	/**
	 * The user dropped something onto the dropzone
	 * 
	 * @param handler
	 */
	HandlerRegistration addDropHandler(DropEvent.DropHandler handler);

	void fireDropEvent();

	/**
	 * The user started to drag anywhere
	 * 
	 * @param handler
	 */
	HandlerRegistration addDragStartHandler(DragStartEvent.DragStartHandler handler);

	void fireDragStartEvent();

	/**
	 * Dragging has ended
	 * 
	 * @param handler
	 */
	HandlerRegistration addDragEndHandler(DragEndEvent.DragEndHandler handler);

	void fireDragEndEvent();

	/**
	 * The user dragged a file onto the Dropzone
	 * 
	 * @param handler
	 */
	HandlerRegistration addDragEnterHandler(DragEnterEvent.DragEnterHandler handler);

	void fireDragEnterEvent();

	/**
	 * The user is dragging a file over the Dropzone
	 * 
	 * @param handler
	 */
	HandlerRegistration addDragOverHandler(DragOverEvent.DragOverHandler handler);

	void fireDragOverEvent();

	/**
	 * The user is dragging a file over the Dropzone
	 * 
	 * @param handler
	 */
	HandlerRegistration addDragLeaveHandler(DragLeaveEvent.DragLeaveHandler handler);

	void fireDragLeaveEvent();

	/**
	 * When a file is added to the list
	 * 
	 * @param handler
	 */
	HandlerRegistration addAddedFileHandler(AddedFileEvent.AddedFileHandler<T> handler);

	void fireAddedFileEvent(String fileName, String lastModified, String size, String type);

	/**
	 * Called whenever a file is removed from the list. You can listen to this
	 * and delete the file from your server if you want to.
	 * 
	 * @param handler
	 */
	HandlerRegistration addRemovedFileHandler(RemovedFileEvent.RemovedFileHandler<T> handler);

	void fireRemovedFileEvent(String fileName, String lastModified, String size, String type);

	/**
	 * An error occured. Receives the errorMessage as second parameter and if
	 * the error was due to the XMLHttpRequest the xhr object as third.
	 * 
	 * @param handler
	 */
	HandlerRegistration addErrorHandler(ErrorEvent.ErrorHandler<T> handler);

	void fireErrorEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage);

	/**
	 * Called with the total uploadProgress (0-100). This event can be used to
	 * show the overall upload progress of all files.
	 * 
	 * @param handler
	 * @return
	 */
	HandlerRegistration addTotalUploadProgressHandler(TotalUploadProgressEvent.TotalUploadProgressHandler handler);

	void fireTotalUploadProgressEvent(double progress);

	/**
	 * Called just before each file is sent. Gets the xhr object and the
	 * formData objects as second and third parameters, so you can modify them
	 * (for example to add a CSRF token) or add additional data.
	 * 
	 * @param handler
	 */
	HandlerRegistration addSendingHandler(SendingEvent.SendingHandler<T> handler);

	void fireSendingEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage);

	/**
	 * The file has been uploaded successfully. Gets the server response as
	 * second argument. (This event was called finished previously)
	 * 
	 * @param handler
	 */
	HandlerRegistration addSuccessHandler(SuccessEvent.SuccessHandler<T> handler);

	void fireSuccessEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage, String responseBody);

	/**
	 * Called when the upload was either successful or erroneous.
	 * 
	 * @param handler
	 */
	HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler<T> handler);

	void fireCompleteEvent(String fileName, String lastModified, String size, String type, String responseCode, String responseMessage);

	/**
	 * Called when a file upload gets canceled.
	 * 
	 * @param handler
	 */
	HandlerRegistration addCancelHandler(CanceledEvent.CanceledHandler<T> handler);

	void fireCancelEvent(String fileName, String lastModified, String size, String type);

	/**
	 * Called when the number of files accepted reaches the maxFiles limit.
	 * 
	 * @param handler
	 */
	HandlerRegistration addMaxFilesReachHandler(MaxFilesReachedEvent.MaxFilesReachedHandler<T> handler);

	void fireMaxFilesReachEvent(String fileName, String lastModified, String size, String type);

	/**
	 * Called for each file that has been rejected because the number of files
	 * exceeds the maxFiles limit.
	 * 
	 * @param handler
	 */
	HandlerRegistration addMaxFilesExceededHandler(MaxFilesExceededEvent.MaxFilesExceededHandler<T> handler);

	void fireMaxFilesExceededEvent(String fileName, String lastModified, String size, String type);

}
