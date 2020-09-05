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
package gwt.material.design.addins.client.fileuploader.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.fileuploader.base.HasFileUploadHandlers;

public class QueueCompleteEvent extends GwtEvent<QueueCompleteEvent.QueueCompleteHandler> {

    private static Type<QueueCompleteHandler> TYPE;

    protected QueueCompleteEvent() {
    }

    public static void fire(HasFileUploadHandlers source) {
        if (TYPE != null) {
            QueueCompleteEvent event = new QueueCompleteEvent();
            source.fireEvent(event);
        }
    }

    public static Type<QueueCompleteHandler> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    @Override
    public final Type<QueueCompleteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(QueueCompleteHandler handler) {
        handler.onQueueComplete(this);
    }

    public interface QueueCompleteHandler extends EventHandler {
        void onQueueComplete(QueueCompleteEvent event);
    }
}
