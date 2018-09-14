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
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.events.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Test case for dnd component
 *
 * @author kevzlou7979
 */
public class MaterialDndTest extends MaterialWidgetTest<MaterialPanel> {

    @Override
    protected MaterialPanel createWidget() {
        return new MaterialPanel();
    }

    public void testDropzone() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkDropzone(panel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkDropzone(panel);
    }

    protected void checkDropzone(MaterialPanel panel) {
        final String ACCEPT = "accept";
        final double OVERLAP = 20;
        MaterialDnd dnd = MaterialDnd.dropzone(panel, JsDropOptions.create(ACCEPT, OVERLAP));
        JsDropOptions options = dnd.getDropOptions();
        assertEquals(ACCEPT, options.accept);
        assertEquals(OVERLAP, options.overlap);
    }

    public void testAxis() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkAxis(panel);
    }

    protected void checkAxis(MaterialPanel panel) {
        final String VERTICAL_AXIS = "y";
        final String HORIZONTAL_AXIS = "x";
        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(Axis.VERTICAL));
        assertEquals(VERTICAL_AXIS, dnd.getDragOptions().axis);
        dnd.getDragOptions().axis = HORIZONTAL_AXIS;
        assertEquals(HORIZONTAL_AXIS, dnd.getDragOptions().axis);
    }

    public void testInertia() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkInertia(panel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkInertia(panel);
    }

    protected void checkInertia(MaterialPanel panel) {
        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(true));
        assertTrue(dnd.getDragOptions().inertia);
        dnd.getDragOptions().inertia = false;
        assertFalse(dnd.getDragOptions().inertia);
    }

    public void testRestriction() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);
        MaterialIcon iconIgnore = new MaterialIcon();
        MaterialLabel labelIgnore = new MaterialLabel();
        panel.add(iconIgnore);
        panel.add(labelIgnore);

        // when / then
        checkRestriction(panel, iconIgnore.getElement(), labelIgnore.getElement());

        // Standard
        // given
        attachWidget();

        // when / then
        checkRestriction(panel, iconIgnore.getElement(), labelIgnore.getElement());
    }

    protected void checkRestriction(MaterialPanel panel, Element... ignoredWidgets) {
        // when
        Restriction restriction = new Restriction();
        restriction.setBottom(20);
        restriction.setLeft(20);
        restriction.setRight(20);
        restriction.setTop(20);
        restriction.setEndOnly(true);
        restriction.setRestriction(Restriction.Restrict.PARENT);
        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(restriction));
        dnd.ignoreFrom(ignoredWidgets);
        JsDragOptions options = dnd.getDragOptions();

        // then
        assertEquals(panel, dnd.getTarget());
        assertEquals(Double.valueOf(20), options.restrict.elementRect.top);
        assertEquals(Double.valueOf(20), options.restrict.elementRect.left);
        assertEquals(Double.valueOf(20), options.restrict.elementRect.right);
        assertEquals(Double.valueOf(20), options.restrict.elementRect.bottom);
        assertEquals(Restriction.Restrict.PARENT, options.restrict.restriction);
        assertTrue(options.restrict.endOnly);
        assertEquals(2, dnd.getIgnoreFrom().length);
        for (Element element : dnd.getIgnoreFrom()) {
            assertTrue(element.hasClassName(AddinsCssName.INTERACT_IGNORED_CONTENT));
        }
    }

    public void testDropEvents() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkDropEvents(panel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkDropEvents(panel);
    }

    protected void checkDropEvents(MaterialPanel panel) {
        MaterialDnd.draggable(panel);
        // Drop Activate Event
        final boolean[] isDropActivateFired = {false};
        panel.addDropActivateHandler(event -> isDropActivateFired[0] = true);
        panel.fireEvent(new DropActivateEvent() {
        });
        assertTrue(isDropActivateFired[0]);
        // Drop Deactivate Event
        final boolean[] isDropDeactivateFired = {false};
        panel.addDropDeactivateHandler(event -> isDropDeactivateFired[0] = true);
        panel.fireEvent(new DropDeactivateEvent() {
        });
        assertTrue(isDropDeactivateFired[0]);
        // Drop Event
        final boolean[] isDropFired = {false};
        panel.addDropHandler(event -> isDropFired[0] = true);
        panel.fireEvent(new DropEvent($(panel.getElement())) {
        });
        assertTrue(isDropFired[0]);
    }

    public void testDragEvents() {
        // UiBinder
        // given
        MaterialPanel panel = getWidget(false);

        // when / then
        checkDragEvents(panel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkDragEvents(panel);
    }

    protected void checkDragEvents(MaterialPanel panel) {
        MaterialDnd.draggable(panel);
        // Drag Start Event
        final boolean[] isDragStartFired = {false};
        panel.addDragStartHandler(event -> isDragStartFired[0] = true);
        panel.fireEvent(new DragStartEvent() {
        });
        assertTrue(isDragStartFired[0]);
        // Drag Enter Event
        final boolean[] isDragEnterFired = {false};
        panel.addDragEnterHandler(event -> isDragEnterFired[0] = true);
        panel.fireEvent(new DragEnterEvent($(panel.getElement())) {
        });
        assertTrue(isDragEnterFired[0]);
        // Drag Move Event
        final boolean[] isDragMoveFired = {false};
        panel.addDragMoveHandler(event -> isDragMoveFired[0] = true);
        panel.fireEvent(new DragMoveEvent() {
        });
        assertTrue(isDragMoveFired[0]);
        // Drag End Event
        final boolean[] isDragEndFired = {false};
        panel.addDragEndHandler(event -> isDragEndFired[0] = true);
        panel.fireEvent(new DragEndEvent() {
        });
        assertTrue(isDragEndFired[0]);
        // Drag Over Event
        final boolean[] isDragOverFired = {false};
        panel.addDragOverHandler(event -> isDragOverFired[0] = true);
        panel.fireEvent(new DragOverEvent() {
        });
        assertTrue(isDragOverFired[0]);
    }
}
