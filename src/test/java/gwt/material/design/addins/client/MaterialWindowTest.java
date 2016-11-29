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

import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.base.HasColors;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialPanel;

/**
 * Test case for window component
 *
 * @author kevzlou7979
 */
public class MaterialWindowTest extends MaterialAddinsTest {

    public void init() {
        MaterialWindow window = new MaterialWindow();
        window.open();
        checkWidget(window);
        checkStructure(window);
        checkMaximizeAndClose(window);
        checkHeightAndWidth(window);
    }

    protected <T extends MaterialWindow> void checkHeightAndWidth(T window) {
        window.setWidth("200px");
        window.setHeight("100px");
        assertEquals(window.getElement().getStyle().getWidth(), "200px");
        assertEquals(window.getElement().getStyle().getHeight(), "100px");
    }

    protected <T extends MaterialWindow> void checkStructure(T window) {
        assertNotNull(window);
        // Check Window Toolbar Structure
        assertTrue(window.getWidget(0) instanceof MaterialWidget);
        MaterialWidget toolbar = (MaterialWidget) window.getWidget(0);
        assertEquals(window.getToolbar(), toolbar);
        assertTrue(toolbar.getElement().hasClassName(AddinsCssName.WINDOW_TOOLBAR));
        assertEquals(toolbar.getWidget(0), window.getLabelTitle());
        assertTrue(toolbar.getWidget(0).getElement().hasClassName(AddinsCssName.WINDOW_TITLE));
        window.setTitle("Title");
        assertEquals(window.getLabelTitle().getText(), "Title");
        assertEquals(toolbar.getWidget(1), window.getIconClose());
        assertTrue(toolbar.getWidget(1).getElement().hasClassName(AddinsCssName.WINDOW_ACTION));
        assertEquals(toolbar.getWidget(2), window.getIconMaximize());
        assertTrue(toolbar.getWidget(2).getElement().hasClassName(AddinsCssName.WINDOW_ACTION));
        // Check Window Content structure
        assertNotNull(window.getWidget(1));
        assertTrue(window.getWidget(1) instanceof MaterialWidget);
        MaterialWidget content = (MaterialWidget) window.getWidget(1);
        assertEquals(window.getContent(), content);
        MaterialPanel panel = new MaterialPanel();
        window.add(panel);
        assertEquals(content.getWidget(0), panel);
    }

    @Override
    protected <T extends MaterialWidget & HasColors> void checkColor(T widget) {
        MaterialWindow window = new MaterialWindow();
        window.setBackgroundColor(Color.RED);
        assertEquals(window.getBackgroundColor(), Color.RED);
        window.setToolbarColor(Color.BLUE);
        assertEquals(window.getToolbarColor(), Color.BLUE);
        assertTrue(window.getToolbar().getElement().hasClassName(Color.BLUE.getCssName()));
    }

    protected <T extends MaterialWindow> void checkMaximizeAndClose(T window) {
        window.setEnabled(true);
        assertTrue(window.isEnabled());
        checkOpenHandler(window);
        checkCloseHandler(window);
        final boolean[] isOpenFired = {false};
        window.addOpenHandler(openEvent -> {
            isOpenFired[0] = true;
        });
        window.open();

        boolean[] isCloseFired = {false};
        window.addCloseHandler(closeEvent -> {
            isCloseFired[0] = true;
        });
        window.close();

        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);

        assertEquals(window.getIconMaximize().getIconType(), IconType.CHECK_BOX_OUTLINE_BLANK);
        assertFalse(window.getElement().hasClassName(AddinsCssName.MAXIMIZE));
        window.setMaximize(true);
        assertEquals(window.getIconMaximize().getIconType(), IconType.FILTER_NONE);
        window.open();
        assertTrue(window.isMaximized());
        assertTrue(window.getElement().hasClassName(AddinsCssName.MAXIMIZE));
    }
}