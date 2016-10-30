package gwt.material.design.addins.client.fileuploader.events;

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


import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.fileuploader.base.HasFileUpload;
import gwt.material.design.addins.client.fileuploader.base.UploadResponse;

public class ErrorEvent<T> extends GwtEvent<ErrorEvent.ErrorHandler<T>> {

    private static Type<ErrorHandler<?>> TYPE;

    public interface ErrorHandler<T> extends EventHandler {
        void onError(ErrorEvent<T> event);
    }

    public static <T> void fire(HasFileUpload<T> source, T target, UploadResponse response) {
        if (TYPE != null) {
            ErrorEvent<T> event = new ErrorEvent<T>(target, response);
            source.fireEvent(event);
        }
    }

    public static Type<ErrorHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    private final T target;
    private final UploadResponse response;

    protected ErrorEvent(T target, UploadResponse response) {
        this.target = target;
        this.response = response;
    }

    @Override
    public final Type<ErrorHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    public UploadResponse getResponse() {
        return response;
    }

    @Override
    protected void dispatch(ErrorHandler<T> handler) {
        handler.onError(this);
    }
}
