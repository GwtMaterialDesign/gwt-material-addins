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

//@formatter:off

/**
 * Executes the callback function on input change. Returns the current input’s string.
 *
 * @author kevzlou7979
 */
public class ChangeEvent extends GwtEvent<ChangeEvent.ChangeHandler> {

    public static final Type<ChangeHandler> TYPE = new Type<>();

    private String input;

    public ChangeEvent(String input) {
        this.input = input;
    }

    public static Type<ChangeHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, String message) {
        source.fireEvent(new ChangeEvent(message));
    }

    @Override
    public Type<ChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ChangeHandler handler) {
        handler.onChange(this);
    }

    public String getInput() {
        return input;
    }

    public interface ChangeHandler extends EventHandler {
        void onChange(ChangeEvent event);
    }
}
