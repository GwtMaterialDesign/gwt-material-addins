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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.dto.User;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.client.ui.html.Option;

public class MaterialComboBoxTest extends MaterialAddinsTest {

    public void init() {
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
        checkAddItemOption();
    }

    protected void checkAddItemOption() {
        MaterialComboBox<String> comboBox = new MaterialComboBox<>();
        RootPanel.get().add(comboBox);
        // Check Initial children
        assertEquals(comboBox.getValues().size(), 0);
        assertEquals(comboBox.getChildren().size(), 3);
        // Check simple String object
        for (int i = 1; i <= 5; i++) {
            comboBox.addItem("item" + i);
        }
        assertEquals(comboBox.getValues().size(), 5);
        // Check ListBox
        assertNotNull(comboBox.getWidget(0));
        assertTrue(comboBox.getWidget(0) instanceof MaterialWidget);
        assertEquals(comboBox.getListbox(), comboBox.getWidget(0));
        MaterialWidget listBox = comboBox.getListbox();
        assertEquals(listBox.getWidgetCount(), 5);
        for (Widget w : listBox) {
            assertNotNull(w);
            assertTrue(w instanceof Option);
        }
        // Check Label
        assertNotNull(comboBox.getWidget(1));
        assertTrue(comboBox.getWidget(1) instanceof Label);
        Label lblTitle = (Label) comboBox.getWidget(1);
        assertTrue(lblTitle.getElement().hasClassName(AddinsCssName.SELECT2LABEL));
        // Check Error Label
        assertNotNull(comboBox.getWidget(2));
        assertTrue(comboBox.getWidget(2) instanceof MaterialLabel);
    }

    @Override
    protected <T extends MaterialWidget> void checkInteractionEvents(T widget, boolean enabled) {
        // TODO Check Specific Interaction Events
    }
}
