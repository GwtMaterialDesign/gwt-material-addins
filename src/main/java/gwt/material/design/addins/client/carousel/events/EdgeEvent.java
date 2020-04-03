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
package gwt.material.design.addins.client.carousel.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Fires when an edge is overscrolled in non-infinite mode.
 *
 * @author kevzlou7979
 */
public class EdgeEvent extends GwtEvent<EdgeEvent.EdgeHandler> {

    public interface EdgeHandler extends EventHandler {
        void onEdge(EdgeEvent event);
    }

    private Object direction;
    public static final Type<EdgeHandler> TYPE = new Type<>();

    public static Type<EdgeHandler> getType() {
        return TYPE;
    }

    public EdgeEvent(Object direction) {
        this.direction = direction;
    }

    public static void fire(HasHandlers source, Object direction) {
        source.fireEvent(new EdgeEvent(direction));
    }

    @Override
    public Type<EdgeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EdgeEvent.EdgeHandler handler) {
        handler.onEdge(this);
    }

    public Object getDirection() {
        return direction;
    }
}
