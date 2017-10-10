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
package gwt.material.design.addins.client.fileuploader.constants;

import gwt.material.design.addins.client.dnd.constants.DragEvents;
import gwt.material.design.addins.client.dnd.constants.DropEvents;

public interface FileUploaderEvents extends DragEvents, DropEvents {

    String ADDED_FILE = "addedfile";
    String REMOVED_FILE = "removedfile";
    String TOTAL_UPLOAD_PROGRESS = "totaluploadprogress";
    String UPLOAD_PROGRESS = "uploadprogress";
    String SENDING = "sending";
    String SUCCESS = "success";
    String COMPLETE = "complete";
    String CANCELED = "canceled";
    String MAX_FILES_REACHED = "maxfilesreached";
    String MAX_FILES_EXCEEDED = "maxfilesexceeded";
}
