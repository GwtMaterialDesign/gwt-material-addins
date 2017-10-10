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

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.client.ui.MaterialLink;

/**
 * Test case for popup menu component
 *
 * @author kevzlou7979
 */
public class MaterialPopupMenuTest extends MaterialWidgetTest<MaterialPopupMenu> {

    @Override
    protected MaterialPopupMenu createWidget() {
        MaterialPopupMenu popupMenu = new MaterialPopupMenu();
        for (int i = 1; i <= 5; i++) {
            MaterialLink link = new MaterialLink();
            popupMenu.add(link);
        }
        return popupMenu;
    }

    public void testStructure() {
        // given
        MaterialPopupMenu popupMenu = getWidget();

        // when / then
        assertTrue(popupMenu.getElement().hasAttribute("tabindex"));
        assertEquals("0", popupMenu.getElement().getAttribute("tabindex"));
        assertEquals(5, popupMenu.getWidgetCount());
        for (Widget w : popupMenu) {
            assertNotNull(w);
        }
    }

    public void testOpenCloseHandler() {
        // given
        MaterialPopupMenu popupMenu = getWidget();
        final int X = 10;
        final int Y = 10;
        final boolean[] isOpenFired = {false};
        final boolean[] isCloseFired = {false};

        // when / then
        checkOpenHandler(popupMenu);
        checkCloseHandler(popupMenu);
        popupMenu.addOpenHandler(closeEvent -> isOpenFired[0] = true);
        popupMenu.setPopupPosition(X, Y);
        assertEquals(Y, popupMenu.getPopupY());
        assertEquals(X, popupMenu.getPopupX());
        popupMenu.open();
        popupMenu.addCloseHandler(closeEvent -> isCloseFired[0] = true);
        popupMenu.close();
        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);
    }

    public void testSelectionHandler() {
        // given
        MaterialPopupMenu popupMenu = getWidget();
        final boolean[] isSelectionFired = {false};

        // when / then
        popupMenu.setEnabled(true);
        popupMenu.addSelectionHandler(selectionEvent -> isSelectionFired[0] = true);
        popupMenu.fireEvent(new GwtEvent<SelectionHandler<?>>() {
            @Override
            public Type<SelectionHandler<?>> getAssociatedType() {
                return SelectionEvent.getType();
            }

            @Override
            protected void dispatch(SelectionHandler<?> eventHandler) {
                eventHandler.onSelection(null);
            }
        });
        assertTrue(isSelectionFired[0]);
    }
}
