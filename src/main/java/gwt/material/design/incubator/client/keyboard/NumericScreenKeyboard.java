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
package gwt.material.design.incubator.client.keyboard;

import gwt.material.design.incubator.client.keyboard.js.KeyboardLayout;

public class NumericScreenKeyboard extends ScreenKeyboard {

    public NumericScreenKeyboard() {
        super();
    }

    @Override
    protected void load() {
        super.load();

        KeyboardLayout layout = new KeyboardLayout();
        layout.setDefaultLayout(new String[]{"1 2 3", "4 5 6", "7 8 9", "{shift} 0 -", "{bksp}"});
        layout.setShiftLayout(new String[]{"! / #", "$ % ^", "& * (", "{shift} ) +", "{bksp}"});
        options.setLayout(layout);
        options.setTheme("hg-theme-default hg-layout-numeric numeric-theme");
        updateOptions(options);
    }
}
