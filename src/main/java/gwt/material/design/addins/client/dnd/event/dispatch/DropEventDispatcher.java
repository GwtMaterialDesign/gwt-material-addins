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

import com.google.gwt.event.shared.GwtEvent;
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
        target.fireEvent(new GwtEvent<DropActivateEvent.DropActivateHandler>() {
            @Override
            public Type<DropActivateEvent.DropActivateHandler> getAssociatedType() {
                return DropActivateEvent.TYPE;
            }

            @Override
            protected void dispatch(DropActivateEvent.DropActivateHandler handler) {
                handler.onDropActivate(new DropActivateEvent());
            }
        });
    }

    public void fireDropEvent(JQueryElement relatedTarget) {
        target.fireEvent(new GwtEvent<DropEvent.DropHandler>() {
            @Override
            public Type<DropEvent.DropHandler> getAssociatedType() {
                return DropEvent.TYPE;
            }

            @Override
            protected void dispatch(DropEvent.DropHandler handler) {
                handler.onDrop(new DropEvent(relatedTarget));
            }
        });
    }

    public void fireDropDeactivateEvent() {
        target.fireEvent(new GwtEvent<DropDeactivateEvent.DropDeactivateHandler>() {
            @Override
            public Type<DropDeactivateEvent.DropDeactivateHandler> getAssociatedType() {
                return DropDeactivateEvent.TYPE;
            }

            @Override
            protected void dispatch(DropDeactivateEvent.DropDeactivateHandler handler) {
                handler.onDropDeactivate(new DropDeactivateEvent());
            }
        });
    }
}
