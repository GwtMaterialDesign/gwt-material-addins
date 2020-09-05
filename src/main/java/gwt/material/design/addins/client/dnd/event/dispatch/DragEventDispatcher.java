/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.addins.client.dnd.event.dispatch;

import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.*;
import gwt.material.design.jquery.client.api.JQueryElement;

public class DragEventDispatcher {

    private final MaterialWidget target;

    public DragEventDispatcher(MaterialWidget target) {
        this.target = target;
    }

    public void fireDragStartEvent() {
        target.fireEvent(new DragStartEvent());
    }

    public void fireDragMoveEvent() {
        target.fireEvent(new DragMoveEvent());
    }

    public void fireDragEndEvent() {
        target.fireEvent(new DragEndEvent());
    }

    public void fireDragEnterEvent(JQueryElement relatedTarget) {
        target.fireEvent(new DragEnterEvent(relatedTarget));
    }

    public void fireDragLeaveEvent(JQueryElement relatedTarget) {
        target.fireEvent(new DragLeaveEvent(relatedTarget));
    }
}
