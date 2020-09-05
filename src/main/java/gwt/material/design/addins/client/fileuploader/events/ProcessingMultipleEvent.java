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

import java.util.List;

public class ProcessingMultipleEvent<T extends List<?>> extends GwtEvent<ProcessingMultipleEvent.ProcessingMultipleHandler<T>> {

    private final T target;

    protected ProcessingMultipleEvent(T target) {
        this.target = target;
    }

    @Override
    public final Type<ProcessingMultipleHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    @Override
    protected void dispatch(ProcessingMultipleHandler<T> handler) {
        handler.onProcessingMultiple(this);
    }

    private static Type<ProcessingMultipleHandler<?>> TYPE;

    public interface ProcessingMultipleHandler<T> extends EventHandler {
        void onProcessingMultiple(ProcessingMultipleEvent event);
    }

    public static <T> void fire(HasFileUploadHandlers<T> source, List<T> target) {
        if (TYPE != null) {
            ProcessingMultipleEvent event = new ProcessingMultipleEvent(target);
            source.fireEvent(event);
        }
    }

    public static Type<ProcessingMultipleHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
}
