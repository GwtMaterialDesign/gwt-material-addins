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
        // given
        MaterialSubHeaderContainer container = getWidget();

        // when / then
        assertEquals(5, container.getWidgetCount());
        for (int i = 0; i < 4; i++) {
            assertTrue(container.getWidget(i) instanceof MaterialSubHeader);
            MaterialSubHeader subHeader = (MaterialSubHeader) container.getWidget(i);
            final String TEXT = "item" + (i + 1);
            assertEquals(TEXT, subHeader.getText());
            assertTrue(subHeader.getElement().hasClassName(AddinsCssName.SUBHEADER));
        }
    }

    public void testType() {
        // given
        MaterialSubHeaderContainer container = getWidget();

        // when / then
        container.setType(SubHeaderType.PINNED);
        assertTrue(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        container.setType(SubHeaderType.STATIC);
        assertFalse(container.getElement().hasClassName(SubHeaderType.PINNED.getCssName()));
        assertTrue(container.getElement().hasClassName(SubHeaderType.STATIC.getCssName()));
    }
}
