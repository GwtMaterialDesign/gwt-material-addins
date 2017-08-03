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

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.client.ui.MaterialLink;

/**
 * Test case for popup menu component
 *
 * @author kevzlou7979
 */
public class MaterialPopupMenuTest extends MaterialAddinsTest {

    public void init() {
        MaterialPopupMenu popupMenu = new MaterialPopupMenu();
        RootPanel.get().add(popupMenu);
        checkWidget(popupMenu);
        checkStructure(popupMenu);
        checkSelectionHandler(popupMenu);
        checkOpenCloseHandler(popupMenu);
    }

    protected <T extends MaterialPopupMenu> void checkStructure(T popupMenu) {
        assertTrue(popupMenu.getElement().hasAttribute("tabindex"));
        assertEquals(popupMenu.getElement().getAttribute("tabindex"), "0");
        for (int i = 1; i <= 5; i++) {
            MaterialLink link = new MaterialLink();
            popupMenu.add(link);
        }

        assertEquals(popupMenu.getWidgetCount(), 5);
        for (Widget w : popupMenu) {
            assertNotNull(w);
        }
    }

    protected <T extends MaterialPopupMenu> void checkOpenCloseHandler(T popupMenu) {
        final int X = 10;
        final int Y = 10;
        checkOpenHandler(popupMenu);
        checkCloseHandler(popupMenu);
        final boolean[] isOpenFired = {false};
        popupMenu.addOpenHandler(closeEvent -> {
            isOpenFired[0] = true;
        });
        popupMenu.setPopupPosition(X, Y);
        assertEquals(popupMenu.getPopupY(), Y);
        assertEquals(popupMenu.getPopupX(), X);
        popupMenu.open();

        final boolean[] isCloseFired = {false};
        popupMenu.addCloseHandler(closeEvent -> {
            isCloseFired[0] = true;
        });
        popupMenu.close();

        assertTrue(isOpenFired[0]);
        assertTrue(isCloseFired[0]);
    }

    protected <T extends MaterialPopupMenu> void checkSelectionHandler(T popupMenu) {
        popupMenu.setEnabled(true);
        final boolean[] isSelectionFired = {false};
        popupMenu.addSelectionHandler(selectionEvent -> {
            isSelectionFired[0] = true;
        });
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
