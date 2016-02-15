package gwt.material.design.addins.client.base;

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

import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.constants.Restriction;
import gwt.material.design.client.base.MaterialWidget;

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
}
