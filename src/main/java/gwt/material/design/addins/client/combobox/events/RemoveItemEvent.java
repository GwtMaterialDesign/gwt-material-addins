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
package gwt.material.design.addins.client.combobox.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.combobox.base.HasRemoveItemHandler;

/**
 * Combobox event fired once user removes an item from multiple list selection.
 * @author kevzlou7979
 */
public class RemoveItemEvent<T> extends GwtEvent<RemoveItemEvent.RemoveItemHandler<T>> {

    private static Type<RemoveItemHandler<?>> TYPE;

    public interface RemoveItemHandler<T> extends EventHandler {
        void onRemoveItem(RemoveItemEvent<T> event);
    }

    public static <T> void fire(HasRemoveItemHandler<T> source, T target) {
        if (TYPE != null) {
            RemoveItemEvent<T> event = new RemoveItemEvent<T>(target);
            source.fireEvent(event);
        }
    }

    public static Type<RemoveItemHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    private final T target;

    protected RemoveItemEvent(T target) {
        this.target = target;
    }

    @Override
    public final Type<RemoveItemHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    @Override
    protected void dispatch(RemoveItemHandler<T> handler) {
        handler.onRemoveItem(this);
    }
}
