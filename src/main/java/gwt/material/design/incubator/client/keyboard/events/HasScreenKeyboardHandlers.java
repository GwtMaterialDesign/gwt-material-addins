/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasScreenKeyboardHandlers  {

    /**
     * Executes the callback function on key press. Returns button layout name (i.e.: “{shift}”).
     */
    HandlerRegistration addKeyPressHandler(KeyPressEvent.KeyPressHandler handler);

    /**
     * Executes the callback function on input change. Returns the current input’s string.
     */
    HandlerRegistration addChangeHandler(ChangeEvent.ChangeHandler handler);

    /**
     * Executes the callback function on input change. Returns the input object with all defined inputs.
     * This is useful if you’re handling several inputs with simple-keyboard, as specified in the “Using several inputs” guide.
     */
    HandlerRegistration addChangeAllHandler(ChangeAllEvent.ChangeAllHandler handler);

    /**
     * Executes the callback function before the first simple-keyboard render.
     */
    HandlerRegistration addBeforeFirstRenderHandler(BeforeFirstRenderEvent.BeforeFirstRenderHandler handler);

    /**
     * Executes the callback function every time simple-keyboard is rendered (e.g: when you change layouts).
     */
    HandlerRegistration addRenderHandler(RenderEvent.RenderHandler handler);

    /**
     * Executes the callback function once simple-keyboard is rendered for the first time (on initialization).
     */
    HandlerRegistration addInitHandler(InitEvent.InitHandler handler);

}
