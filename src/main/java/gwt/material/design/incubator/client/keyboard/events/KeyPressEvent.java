/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.keyboard.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.keyboard.constants.KeyboardButton;

//@formatter:off

/**
 * Executes the callback function on key press. Returns button layout name (i.e.: “{shift}”).
 *
 * @author kevzlou7979
 */
public class KeyPressEvent extends GwtEvent<KeyPressEvent.KeyPressHandler> {

    public static final Type<KeyPressHandler> TYPE = new Type<>();

    private KeyboardButton button;

    public KeyPressEvent(KeyboardButton button) {
        this.button = button;
    }

    public static Type<KeyPressHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, KeyboardButton message) {
        source.fireEvent(new KeyPressEvent(message));
    }

    @Override
    public Type<KeyPressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(KeyPressHandler handler) {
        handler.onKeyPress(this);
    }

    public KeyboardButton getButton() {
        return button;
    }

    public interface KeyPressHandler extends EventHandler {
        void onKeyPress(KeyPressEvent event);
    }
}
