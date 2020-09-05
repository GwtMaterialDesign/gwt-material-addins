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

public class CanceledEvent<T> extends GwtEvent<CanceledEvent.CanceledHandler<T>> {

    private final T target;

    protected CanceledEvent(T target) {
        this.target = target;
    }

    @Override
    public final Type<CanceledHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    @Override
    protected void dispatch(CanceledHandler<T> handler) {
        handler.onCanceled(this);
    }

    private static Type<CanceledHandler<?>> TYPE;

    public interface CanceledHandler<T> extends EventHandler {
        void onCanceled(CanceledEvent<T> event);
    }

    public static <T> void fire(HasFileUploadHandlers<T> source, T target) {
        if (TYPE != null) {
            CanceledEvent<T> event = new CanceledEvent<T>(target);
            source.fireEvent(event);
        }
    }

    public static Type<CanceledHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
}
