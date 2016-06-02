package gwt.material.design.addins.client.dnd.base;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.events.DragEndEvent;
import gwt.material.design.addins.client.dnd.events.DragMoveEvent;
import gwt.material.design.addins.client.dnd.events.DragStartEvent;

public interface HasDraggable {

    /**
     * Sets the target widget to apply draggable feature
     * @param target
     */
    void setTarget(Widget target);

    /**
     * Gets the draggable target
     * @return
     */
    Widget getTarget();

    /**
     * Sets the ignoreFrom widget to exclude from dragging
     * @param ignoreFrom
     */
    void setIgnoreFrom(Widget ignoreFrom);

    /**
     * Sets the ignoreFrom as selector to exclude from dragging
     * @param selector - can accept multiple selector separated by comma e.g. input, i, a, .content
     */
    void setIgnoreFrom(String selector);

    /**
     * Gets the ignoreFrom widget
     * @return
     */
    Widget isIgnoreFrom();

    /**
     * Sets the restriction properties of dnd feature
     * @param restriction
     * @see <a href="http://interactjs.io/docs/restriction/#restrict">Documentation</a>
     */
    void setRestriction(Restriction restriction);

    /**
     * Gets the restriction properties
     */
    Restriction getRestriction();

    /**
     * Add a drag start handler
     * @param handler
     */
    HandlerRegistration addDragStartHandler(DragStartEvent.DragStartHandler handler);

    /**
     * Add a drag move handler
     * @param handler
     */
    HandlerRegistration addDragMoveHandler(DragMoveEvent.DragMoveHandler handler);

    /**
     * Add a drag end handler
     * @param handler
     */
    HandlerRegistration addDragEndHandler(DragEndEvent.DragEndHandler handler);


}
