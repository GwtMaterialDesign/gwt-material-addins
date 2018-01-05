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
package gwt.material.design.incubator.client.chart.amcharts.events.cursor;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.MovedData;
//@formatter:off

/**
 * Dispatched when mouse is moved over the chart. X and Y are coordinates of the mouse, relative to the plot area of
 * the chart.
 *
 * @author kevzlou7979
 */
public class CursorMovedEvent extends GwtEvent<CursorMovedEvent.CursorMovedHandler> {

    public static final Type<CursorMovedHandler> TYPE = new Type<>();
    private MovedData data;

    public CursorMovedEvent(MovedData data) {
        this.data = data;
    }

    public static Type<CursorMovedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, MovedData data) {
        source.fireEvent(new CursorMovedEvent(data));
    }

    @Override
    public Type<CursorMovedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CursorMovedHandler handler) {
        handler.onMoved(this);
    }

    public MovedData getData() {
        return data;
    }

    public interface CursorMovedHandler extends EventHandler {
        void onMoved(CursorMovedEvent event);
    }
}
