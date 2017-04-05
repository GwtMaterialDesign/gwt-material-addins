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
 * Combobox event fired once user is opening the combobox menu items.
 *
 * @author kevzlou7979
 */
public class ComboBoxClosingEvent<T> extends GwtEvent<ComboBoxClosingEvent.ComboBoxClosingHandler<T>> {

    private static Type<ComboBoxClosingHandler<?>> TYPE;

    public interface ComboBoxClosingHandler<T> extends EventHandler {
        void onComboBoxClosing(ComboBoxClosingEvent<T> event);
    }

    public static <T> void fire(HasComboBoxHandlers<T> source) {
        if (TYPE != null) {
            source.fireEvent(new ComboBoxClosingEvent<T>());
        }
    }

    public static Type<ComboBoxClosingHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
    
    @Override
    public final Type<ComboBoxClosingHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(ComboBoxClosingHandler<T> handler) {
        handler.onComboBoxClosing(this);
    }
}
