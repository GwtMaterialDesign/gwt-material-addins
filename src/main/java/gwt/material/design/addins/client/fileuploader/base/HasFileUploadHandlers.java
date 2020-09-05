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
package gwt.material.design.addins.client.fileuploader.base;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.addins.client.fileuploader.events.*;

import java.util.List;

public interface HasFileUploadHandlers<T> extends HasHandlers {

    /**
     * When a file is added to the list.
     */
    HandlerRegistration addAddedFileHandler(AddedFileEvent.AddedFileHandler<T> handler);

    /**
     * Called whenever a file is removed from the list.
     * You can listen to this and delete the file from your server if you want to.
     */
    HandlerRegistration addRemovedFileHandler(RemovedFileEvent.RemovedFileHandler<T> handler);

    /**
     * An error occured. Receives the errorMessage as second parameter and if
     * the error was due to the XMLHttpRequest the xhr object as third.
     */
    HandlerRegistration addErrorHandler(ErrorEvent.ErrorHandler<T> handler);

    /**
     * An unauthorized error occured. Probably because of session expiration.
     * Receives the errorMessage as second parameter and if the error was due to
     * the XMLHttpRequest the xhr object as third.
     */
    HandlerRegistration addUnauthorizedHandler(UnauthorizedEvent.UnauthorizedHandler<T> handler);

    /**
     * Called with the total uploadProgress (0-100). This event can be used
     * to show the overall upload progress of all files.
     */
    HandlerRegistration addTotalUploadProgressHandler(TotalUploadProgressEvent.TotalUploadProgressHandler handler);

    /**
     * Gets called periodically whenever the file upload progress changes.
     */
    HandlerRegistration addCurrentUploadProgressHandler(CurrentUploadProgressEvent.CurrentUploadProgressHandler handler);

    /**
     * Called just before each file is sent.
     * Gets the xhr object and the formData objects as second and third parameters,
     * so you can modify them (for example to add a CSRF token) or add additional data.
     */
    HandlerRegistration addSendingHandler(SendingEvent.SendingHandler<T> handler);

    /**
     * The file has been uploaded successfully.
     * Gets the server response as second argument.(This event was called finished previously).
     */
    HandlerRegistration addSuccessHandler(SuccessEvent.SuccessHandler<T> handler);

    /**
     * Called when the upload was either successful or erroneous.
     */
    HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler<T> handler);

    /**
     * Called when a file upload gets canceled.
     */
    HandlerRegistration addCanceledHandler(CanceledEvent.CanceledHandler<T> handler);

    /**
     * Called when the number of files accepted reaches the maxFiles limit.
     */
    HandlerRegistration addMaxFilesReachHandler(MaxFilesReachedEvent.MaxFilesReachedHandler<T> handler);

    /**
     * Called for each file that has been rejected because the number of files exceeds the maxFiles limit.
     */
    HandlerRegistration addMaxFilesExceededHandler(MaxFilesExceededEvent.MaxFilesExceededHandler<T> handler);

    /**
     * When the thumbnail has been generated. Receives the dataUrl as second parameter.
     */
    HandlerRegistration addThumbnailHandler(ThumbnailEvent.ThumbnailHandler<T> handler);

    /**
     * When a file gets processed (since there is a queue not all files are processed immediately). This event was called processingfile previously.
     */
    HandlerRegistration addProcessingHandler(ProcessingEvent.ProcessingHandler<T> handler);

    /**
     * @see #addProcessingHandler(ProcessingEvent.ProcessingHandler)
     */
    HandlerRegistration addProcessingMultipleHandler(ProcessingMultipleEvent.ProcessingMultipleHandler<List<T>> handler);

    /**
     * @see #addSendingHandler(SendingEvent.SendingHandler)
     */
    HandlerRegistration addSendingMultipleHandler(SendingMultipleEvent.SendingMultipleHandler<List<T>> handler);

    /**
     * @see #addSuccessHandler(SuccessEvent.SuccessHandler)
     */
    HandlerRegistration addSuccessMultipleHandler(SuccessMultipleEvent.SuccessMulttipleHandler<List<T>> handler);

    /**
     * @see #addCompleteHandler(CompleteEvent.CompleteHandler)
     */
    HandlerRegistration addCompleteMultipleHandler(CompleteMultipleEvent.CompleteMulttipleHandler<List<T>> handler);

    /**
     * @see #addCanceledHandler(CanceledEvent.CanceledHandler)
     */
    HandlerRegistration addCanceledMultipleHandler(CanceledMultipleEvent.CanceledMulttipleHandler<List<T>> handler);

    /**
     * Called when all files in the list are removed and the dropzone is reset to initial state.
     */
    HandlerRegistration addResetHandler(ResetEvent.ResetHandler handler);

    /**
     * Called when all files in the queue finish uploading.
     */
    HandlerRegistration addQueueCompleteHandler(QueueCompleteEvent.QueueCompleteHandler handler);
}
