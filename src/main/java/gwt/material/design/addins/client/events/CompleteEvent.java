package gwt.material.design.addins.client.events;

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
import gwt.material.design.addins.client.base.HasFileUpload;

public class CompleteEvent<T> extends GwtEvent<CompleteEvent.CompleteHandler<T>> {

    private static Type<CompleteHandler<?>> TYPE;

    public interface CompleteHandler<T> extends EventHandler {
        void onComplete(CompleteEvent<T> event);
    }

    public static <T> void fire(HasFileUpload<T> source, T target) {
        if (TYPE != null) {
            CompleteEvent<T> event = new CompleteEvent<T>(target);
            source.fireEvent(event);
        }
    }

    public static Type<CompleteHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<CompleteHandler<?>>());
    }

    private final T target;

    protected CompleteEvent(T target) {
        this.target = target;
    }

    @Override
    public final Type<CompleteHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    @Override
    protected void dispatch(CompleteHandler<T> handler) {
        handler.onComplete(this);
    }
}
