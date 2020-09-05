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

public class CompleteMultipleEvent<T extends List<?>> extends GwtEvent<CompleteMultipleEvent.CompleteMulttipleHandler<T>> {

    private final T target;
    private final List<UploadResponse> response;

    protected CompleteMultipleEvent(T target, List<UploadResponse> response) {
        this.target = target;
        this.response = response;
    }

    @Override
    public final Type<CompleteMulttipleHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    public List<UploadResponse> getResponse() {
        return response;
    }

    @Override
    protected void dispatch(CompleteMulttipleHandler<T> handler) {
        handler.onCompleteMulttiple(this);
    }

    private static Type<CompleteMulttipleHandler<?>> TYPE;

    public interface CompleteMulttipleHandler<T> extends EventHandler {
        void onCompleteMulttiple(CompleteMultipleEvent event);
    }

    public static <T> void fire(HasFileUploadHandlers<T> source, List<T> target, List<UploadResponse> response) {
        if (TYPE != null) {
            CompleteMultipleEvent event = new CompleteMultipleEvent(target, response);
            source.fireEvent(event);
        }
    }

    public static Type<CompleteMulttipleHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
}
