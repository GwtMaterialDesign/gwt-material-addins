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
package gwt.material.design.incubator.client.keyboard.binder;

import gwt.material.design.incubator.client.keyboard.ScreenKeyboard;
import gwt.material.design.incubator.client.keyboard.constants.KeyboardButton;
import gwt.material.design.incubator.client.keyboard.js.KeyboardOptions;

public class DefaultShiftBinder implements KeyBinder {

    @Override
    public void bind(ScreenKeyboard screenKeyboard, KeyboardButton button) {
        if (button != null && (button.equals(KeyboardButton.SHIFT) || button.equals(KeyboardButton.LOCK))) {
            String currentLayout = screenKeyboard.getOptions().getLayoutName();
            String shiftToggle = currentLayout.equals("default") ? "shift" : "default";
            KeyboardOptions options = screenKeyboard.getOptions();
            options.setLayoutName(shiftToggle);
            screenKeyboard.updateOptions(options);
        }
    }
}
