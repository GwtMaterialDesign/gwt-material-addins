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
import gwt.material.design.client.events.DropActivateEvent;
import gwt.material.design.client.events.DropDeactivateEvent;
import gwt.material.design.client.events.DropEvent;
import gwt.material.design.jquery.client.api.JQueryElement;

public class DropEventDispatcher {

    private final MaterialWidget target;

    public DropEventDispatcher(MaterialWidget target) {
        this.target = target;
    }

    public void fireDropActiveEvent() {
        target.fireEvent(new DropActivateEvent());
    }

    public void fireDropEvent(JQueryElement relatedTarget) {
        target.fireEvent(new DropEvent(relatedTarget));
    }

    public void fireDropDeactivateEvent() {
        target.fireEvent(new DropDeactivateEvent());
    }
}
