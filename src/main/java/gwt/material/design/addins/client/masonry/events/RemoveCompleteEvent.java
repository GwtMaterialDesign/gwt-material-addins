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
package gwt.material.design.addins.client.masonry.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Widget;


/**
 * Fired when masonry removes an item.
 *
 * @author kevzlou7979
 */
public class RemoveCompleteEvent extends GwtEvent<RemoveCompleteEvent.RemoveCompleteHandler> {

    public interface RemoveCompleteHandler extends EventHandler {
        void onRemoveComplete(RemoveCompleteEvent event);
    }

    private Widget target;

    public static final Type<RemoveCompleteHandler> TYPE = new Type<>();

    public RemoveCompleteEvent(Widget target) {
        this.target = target;
    }

    public static void fire(HasHandlers source, Widget target) {
        source.fireEvent(new RemoveCompleteEvent(target));
    }

    @Override
    public Type<RemoveCompleteHandler> getAssociatedType() {
        return TYPE;
    }

    public Widget getTarget() {
        return target;
    }

    @Override
    protected void dispatch(RemoveCompleteHandler handler) {
        handler.onRemoveComplete(this);
    }
}