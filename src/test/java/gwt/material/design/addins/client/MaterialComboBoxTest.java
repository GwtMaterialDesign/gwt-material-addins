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
package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.UIObject;
import gwt.material.design.addins.client.base.GwtMaterialAddinsTest;
import gwt.material.design.addins.client.base.User;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.base.MaterialWidget;
import org.junit.Test;

public class MaterialComboBoxTest extends GwtMaterialAddinsTest {

    @Test
    public void testComboBox() {
        MaterialComboBox<User> comboBox = new MaterialComboBox<>();
        checkWidget(comboBox);
    }

    @Override
    protected <T extends MaterialWidget & HasEnabled> void checkEnabled(T widget) {
        MaterialComboBox<User> comboBox = new MaterialComboBox<>();
        super.checkEnabled(comboBox, comboBox.getListbox());
    }

    @Override
    protected <T extends MaterialWidget> void checkChildren(T widget) {
        // TODO Check Structure
    }

    @Override
    protected <T extends MaterialWidget> void checkInteractionEvents(T widget, boolean enabled) {
        // TODO Check Specific Interaction Events
    }
}
