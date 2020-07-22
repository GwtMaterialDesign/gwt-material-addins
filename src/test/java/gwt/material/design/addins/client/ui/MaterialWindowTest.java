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

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.ui.base.AddinsWidgetTestCase;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

/**
 * Test case for window component
 *
 * @author kevzlou7979
 */
public class MaterialWindowTest extends AddinsWidgetTestCase<MaterialWindow> {

    @Override
    protected MaterialWindow createWidget() {
        MaterialWindow window = new MaterialWindow();
        window.open();
        return window;
    }

    public void testHeightAndWidth() {
        // UiBinder
        // given
        MaterialWindow window = getWidget(false);

        // when / then
        checkHeightAndWidth(window);

        // Standard
        // given
        attachWidget();

        // when / then
        checkHeightAndWidth(window);
    }

    protected void checkHeightAndWidth(MaterialWindow window) {
        window.setWidth("200px");
        window.setHeight("100px");
        assertEquals("200px", window.getElement().getStyle().getWidth());
        assertEquals("100px", window.getElement().getStyle().getHeight());
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialWindow window = getWidget(false);

        // when / then
        assertNotNull(window);
        // Check Window Toolbar Structure
        assertTrue(window.getWidget(0) instanceof MaterialWidget);
        MaterialWidget toolbar = (MaterialWidget) window.getWidget(0);
        assertEquals(toolbar, window.getToolbar());
        assertTrue(toolbar.getElement().hasClassName(AddinsCssName.WINDOW_TOOLBAR));
        assertEquals(toolbar.getWidget(0), window.getLabelTitle());
        assertTrue(toolbar.getWidget(0).getElement().hasClassName(AddinsCssName.WINDOW_TITLE));
        window.setTitle("Title");
        assertEquals("Title", window.getLabelTitle().getText());
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

    public void testClearContent() {
        // UiBinder
        // given
        MaterialWindow window = getWidget(false);
        MaterialLabel content = new MaterialLabel("Content");
        window.add(content);

        // when / then
        assertEquals(content, window.getContent().getWidget(0));
        assertTrue(content.isAttached());
        assertEquals(0, content.getChildren().size());

        window.clear();
        assertEquals(0, window.getContent().getChildren().size());
    }

    //TODO: Failed Tests
    public void testDndArea() {
        /*// UiBinder
        // given
        MaterialWindow window = getWidget(false);
        MaterialPanel dndArea = new MaterialPanel();
        window.setDndArea(dndArea);

        attachWidget();

        window.open();

        assertTrue(window.getDnd().getDragOptions().restrict.restriction instanceof Element);
        Element element = (Element) window.getDnd().getDragOptions().restrict.restriction;
        assertEquals(dndArea.getElement().getInnerHTML(), element.getInnerHTML());
        assertEquals(dndArea.getElement(), element);*/
    }

    @Override
    public void testColor() {
        // UiBinder
        // given
        MaterialWindow window = getWidget(false);

        // when / then
        checkColor(window);

        // Standard
        // given
        attachWidget();

        // when / then
        checkColor(window);
    }

    protected void checkColor(MaterialWindow window) {
        window.setBackgroundColor(Color.RED);
        assertEquals(Color.RED, window.getBackgroundColor());
        window.setToolbarColor(Color.BLUE);
        assertEquals(Color.BLUE, window.getToolbarColor());
        assertTrue(window.getToolbar().getElement().hasClassName(Color.BLUE.getCssName()));
    }

    public void testMaximizeAndClose() {
        // UiBinder
        // given
        MaterialWindow window = getWidget();

        // when / then
        final boolean[] isOpenFired = {false};
        boolean[] isCloseFired = {false};

        // when / then
        window.setEnabled(true);
        assertTrue(window.isEnabled());

        window.addOpenHandler(openEvent -> isOpenFired[0] = true);
        window.open();

        window.addCloseHandler(closeEvent -> isCloseFired[0] = true);
        window.close();

        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);

        assertEquals(IconType.CHECK_BOX_OUTLINE_BLANK, window.getIconMaximize().getIconType());
        assertFalse(window.getElement().hasClassName(AddinsCssName.MAXIMIZE));
        window.setMaximize(true);
        assertEquals(IconType.FILTER_NONE, window.getIconMaximize().getIconType());
        window.open();
        assertTrue(window.isMaximized());
        assertTrue(window.getElement().hasClassName(AddinsCssName.MAXIMIZE));
    }
}