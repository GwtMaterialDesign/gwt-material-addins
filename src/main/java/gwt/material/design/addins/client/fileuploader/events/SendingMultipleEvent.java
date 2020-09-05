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
import gwt.material.design.addins.client.fileuploader.base.UploadResponse;

import java.util.List;

public class SendingMultipleEvent<T extends List<?>> extends GwtEvent<SendingMultipleEvent.SendingMultipleHandler<T>> {

    private final T target;
    private final List<UploadResponse> response;

    protected SendingMultipleEvent(T target, List<UploadResponse> response) {
        this.target = target;
        this.response = response;
    }

    @Override
    public final Type<SendingMultipleHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    public List<UploadResponse> getResponse() {
        return response;
    }

    @Override
    protected void dispatch(SendingMultipleHandler<T> handler) {
        handler.onSendingMultiple(this);
    }

    private static Type<SendingMultipleHandler<?>> TYPE;

    public interface SendingMultipleHandler<T> extends EventHandler {
        void onSendingMultiple(SendingMultipleEvent event);
    }

    public static <T> void fire(HasFileUploadHandlers<T> source, List<T> target, List<UploadResponse> response) {
        if (TYPE != null) {
            SendingMultipleEvent event = new SendingMultipleEvent(target, response);
            source.fireEvent(event);
        }
    }

    public static Type<SendingMultipleHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
}
