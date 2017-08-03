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
package gwt.material.design.addins.client.combobox.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.combobox.base.HasUnselectItemHandler;

import java.util.List;

/**
 * Combobox event fired once user removes an item from multiple list selection.
 *
 * @author kevzlou7979
 */
public class SelectItemEvent<T> extends GwtEvent<SelectItemEvent.SelectComboHandler<T>> {

    private static Type<SelectComboHandler<?>> TYPE;

    public interface SelectComboHandler<T> extends EventHandler {
        void onSelectItem(SelectItemEvent<T> event);
    }

    public static <T> void fire(HasUnselectItemHandler<T> source, List<T> values) {
        if (TYPE != null) {
            source.fireEvent(new SelectItemEvent<>(values));
        }
    }

    public static Type<SelectComboHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    private final List<T> values;

    protected SelectItemEvent(List<T> values) {
        this.values = values;
    }

    @Override
    public final Type<SelectComboHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public List<T> getSelectedValues() {
        return values;
    }

    @Override
    protected void dispatch(SelectComboHandler<T> handler) {
        handler.onSelectItem(this);
    }
}
