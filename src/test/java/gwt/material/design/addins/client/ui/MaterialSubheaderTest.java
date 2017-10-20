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
package gwt.material.design.addins.client.ui;

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.subheader.MaterialSubHeader;
import gwt.material.design.addins.client.subheader.MaterialSubHeaderContainer;
import gwt.material.design.addins.client.subheader.constants.SubHeaderType;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialSearch;

/**
 * Test case for subheader component
 *
 * @author kevzlou7979
 */
public class MaterialSubheaderTest extends MaterialWidgetTest<MaterialSubHeaderContainer> {

    @Override
    protected MaterialSubHeaderContainer createWidget() {
        MaterialSubHeaderContainer container = new MaterialSubHeaderContainer();
        for (int i = 1; i <= 5; i++) {
            MaterialSubHeader subHeader = new MaterialSubHeader();
            subHeader.setText("item" + i);
            container.add(subHeader);
        }
        return container;
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialSubHeaderContainer container = getWidget(false);

        // when / then
        checkStructure(container, false);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(container, true);
    }

    protected void checkStructure(MaterialSubHeaderContainer container, boolean checkElement) {
        assertEquals(5, container.getWidgetCount());
        for (int i = 0; i < 4; i++) {
            assertTrue(container.getWidget(i) instanceof MaterialSubHeader);
            MaterialSubHeader subHeader = (MaterialSubHeader) container.getWidget(i);
            final String TEXT = "item" + (i + 1);
            assertEquals(TEXT, subHeader.getText());
            if (checkElement) {
                assertTrue(subHeader.getElement().hasClassName(AddinsCssName.SUBHEADER));
            }
        }
    }

    public void testContainer() {
        // UiBinder
        // given
        MaterialSubHeaderContainer container = getWidget(true);

        // when / then
        assertEquals(5, container.getWidgetCount());
        container.clear();
        assertEquals(0, container.getWidgetCount());

        MaterialPanel notSubHeader = new MaterialPanel();
        container.add(notSubHeader);

        assertEquals(notSubHeader, container.getWidget(0));
        assertFalse(notSubHeader.getElement().hasClassName(AddinsCssName.SUBHEADER));
    }

    public void testType() {
        // UiBinder
        // given
        MaterialSubHeaderContainer container = getWidget(false);

        // when / then
        checkType(container);

        // Standard
        // given
        attachWidget();

        // when / then
        checkType(container);
    }

    protected void checkType(MaterialSubHeaderContainer container) {
        container.setType(SubHeaderType.PINNED);
        assertTrue(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        container.setType(SubHeaderType.STATIC);
        assertFalse(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        assertTrue(container.getElement().hasClassName(SubHeaderType.STATIC.getCssName()));
    }
}
