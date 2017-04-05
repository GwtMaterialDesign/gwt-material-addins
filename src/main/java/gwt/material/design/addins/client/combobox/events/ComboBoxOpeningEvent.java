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

/**
 * Combobox event fired once user is closing the combobox menu items.
 *
 * @author kevzlou7979
 */
public class ComboBoxOpeningEvent<T> extends GwtEvent<ComboBoxOpeningEvent.ComboBoxOpeningHandler<T>> {

    private static Type<ComboBoxOpeningHandler<?>> TYPE;

    public interface ComboBoxOpeningHandler<T> extends EventHandler {
        void onComboBoxOpening(ComboBoxOpeningEvent<T> event);
    }

    public static <T> void fire(HasComboBoxHandlers<T> source) {
        if (TYPE != null) {
            source.fireEvent(new ComboBoxOpeningEvent<T>());
        }
    }

    public static Type<ComboBoxOpeningHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    @Override
    public final Type<ComboBoxOpeningHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ComboBoxOpeningHandler<T> handler) {
        handler.onComboBoxOpening(this);
    }
}
