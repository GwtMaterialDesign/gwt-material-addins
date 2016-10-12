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
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.events.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class MaterialDndTest extends MaterialAddinsTest {

    public void init() {
        checkDragEvents();
        checkDropEvents();
        checkRestriction();
        checkInertia();
        checkAxis();
    }

    protected void checkAxis() {
        final String VERTICAL_AXIS = "y";
        final String HORIZONTAL_AXIS = "x";
        MaterialPanel panel = new MaterialPanel();
        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(Axis.VERTICAL));
        assertEquals(dnd.getDragOptions().axis, VERTICAL_AXIS);
        dnd.getDragOptions().axis = HORIZONTAL_AXIS;
        assertEquals(dnd.getDragOptions().axis, HORIZONTAL_AXIS);
    }

    protected void checkInertia() {
        MaterialPanel panel = new MaterialPanel();
        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(true));
        assertTrue(dnd.getDragOptions().inertia);
        dnd.getDragOptions().inertia = false;
        assertFalse(dnd.getDragOptions().inertia);
    }

    protected void checkRestriction() {
        MaterialPanel panel = new MaterialPanel();
        MaterialIcon iconIgnore = new MaterialIcon();
        panel.add(iconIgnore);

        Restriction restriction = new Restriction();
        restriction.setBottom(20);
        restriction.setLeft(20);
        restriction.setRight(20);
        restriction.setTop(20);
        restriction.setEndOnly(true);
        restriction.setRestriction(Restriction.Restrict.PARENT);

        MaterialDnd dnd = MaterialDnd.draggable(panel, JsDragOptions.create(restriction));
        dnd.ignoreFrom(iconIgnore);
        JsDragOptions options = dnd.getDragOptions();
        assertEquals(dnd.getTarget(), panel);
        assertEquals(dnd.getIgnoreFrom(), iconIgnore.getElement());
        assertEquals(options.restrict.elementRect.top, Double.valueOf(20));
        assertEquals(options.restrict.elementRect.left, Double.valueOf(20));
        assertEquals(options.restrict.elementRect.right, Double.valueOf(20));
        assertEquals(options.restrict.elementRect.bottom, Double.valueOf(20));
        assertEquals(options.restrict.restriction, Restriction.Restrict.PARENT.getValue());
        assertTrue(options.restrict.endOnly);
    }

    protected void checkDropEvents() {
        MaterialPanel panel = new MaterialPanel();
        MaterialDnd.draggable(panel);
        // Drop Activate Event
        final boolean[] isDropActivateFired = {false};
        panel.addDropActivateHandler(event -> {
            isDropActivateFired[0] = true;
        });
        panel.fireEvent(new DropActivateEvent() {
        });
        assertTrue(isDropActivateFired[0]);
        // Drop Deactivate Event
        final boolean[] isDropDeactivateFired = {false};
        panel.addDropDeactivateHandler(event -> {
            isDropDeactivateFired[0] = true;
        });
        panel.fireEvent(new DropDeactivateEvent() {
        });
        assertTrue(isDropDeactivateFired[0]);
        // Drop Event
        final boolean[] isDropFired = {false};
        panel.addDropHandler(event -> {
            isDropFired[0] = true;
        });
        panel.fireEvent(new DropEvent($(panel.getElement())) {
        });
        assertTrue(isDropFired[0]);
    }

    protected void checkDragEvents() {
        MaterialPanel panel = new MaterialPanel();
        MaterialDnd.draggable(panel);
        // Drag Start Event
        final boolean[] isDragStartFired = {false};
        panel.addDragStartHandler(event -> {
            isDragStartFired[0] = true;
        });
        panel.fireEvent(new DragStartEvent() {
        });
        assertTrue(isDragStartFired[0]);
        // Drag Enter Event
        final boolean[] isDragEnterFired = {false};
        panel.addDragEnterHandler(event -> {
            isDragEnterFired[0] = true;
        });
        panel.fireEvent(new DragEnterEvent($(panel.getElement())) {
        });
        assertTrue(isDragEnterFired[0]);
        // Drag Move Event
        final boolean[] isDragMoveFired = {false};
        panel.addDragMoveHandler(event -> {
            isDragMoveFired[0] = true;
        });
        panel.fireEvent(new DragMoveEvent() {
        });
        assertTrue(isDragMoveFired[0]);
        // Drag End Event
        final boolean[] isDragEndFired = {false};
        panel.addDragEndHandler(event -> {
            isDragEndFired[0] = true;
        });
        panel.fireEvent(new DragEndEvent() {
        });
        assertTrue(isDragEndFired[0]);
        // Drag Over Event
        final boolean[] isDragOverFired = {false};
        panel.addDragOverHandler(event -> {
            isDragOverFired[0] = true;
        });
        panel.fireEvent(new DragOverEvent() {
        });
        assertTrue(isDragOverFired[0]);
    }
}
