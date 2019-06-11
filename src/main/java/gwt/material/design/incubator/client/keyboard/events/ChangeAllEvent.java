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
 * Executes the callback function on input change. Returns the input object with all defined inputs.
 * This is useful if you’re handling several inputs with simple-keyboard, as specified in the “Using several inputs” guide.
 *
 * @author kevzlou7979
 */
public class ChangeAllEvent extends GwtEvent<ChangeAllEvent.ChangeAllHandler> {

    public static final Type<ChangeAllHandler> TYPE = new Type<>();

    private String input;

    public ChangeAllEvent(String input) {
        this.input = input;
    }

    public static Type<ChangeAllHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, String input) {
        source.fireEvent(new ChangeAllEvent(input));
    }

    @Override
    public Type<ChangeAllHandler> getAssociatedType() {
        return TYPE;
    }

    public String getInput() {
        return input;
    }

    @Override
    protected void dispatch(ChangeAllHandler handler) {
        handler.onChangeAll(this);
    }

    public interface ChangeAllHandler extends EventHandler {
        void onChangeAll(ChangeAllEvent event);
    }
}
