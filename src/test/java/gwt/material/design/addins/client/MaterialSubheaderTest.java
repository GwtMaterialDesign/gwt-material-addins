/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.subheader.MaterialSubHeader;
import gwt.material.design.addins.client.subheader.MaterialSubHeaderContainer;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;

/**
 * Test case for subheader component
 *
 * @author kevzlou7979
 */
public class MaterialSubheaderTest extends MaterialAddinsTest {

    public void init() {
        MaterialSubHeaderContainer container = new MaterialSubHeaderContainer();
        RootPanel.get().add(container);
        checkStructure(container);
        checkWidget(container);
        checkType(container);
    }

    protected <T extends MaterialSubHeaderContainer> void checkStructure(T container) {
        for (int i = 1; i <= 5; i++) {
            MaterialSubHeader subHeader = new MaterialSubHeader();
            subHeader.setText("item" + i);
            container.add(subHeader);
        }

        assertEquals(container.getWidgetCount(), 5);
        for (int i = 0; i < 4; i++) {
            assertTrue(container.getWidget(i) instanceof MaterialSubHeader);
            MaterialSubHeader subHeader = (MaterialSubHeader) container.getWidget(i);
            final String TEXT = "item" + (i + 1);
            assertEquals(subHeader.getText(), TEXT);
            assertTrue(subHeader.getElement().hasClassName(AddinsCssName.SUBHEADER));
        }
    }

    protected <T extends MaterialSubHeaderContainer> void checkType(T container) {
        container.setType(SubHeaderType.PINNED);
        assertTrue(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        container.setType(SubHeaderType.STATIC);
        assertFalse(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        assertTrue(container.getElement().hasClassName(SubHeaderType.STATIC.getCssName()));
    }
}
