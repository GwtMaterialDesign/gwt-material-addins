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
package gwt.material.design.incubator.client.chart.amcharts.events.serial;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.SerialChangedData;
//@formatter:off

/**
 * Dispatched when cursor position is changed. "index" is a series index over which chart cursors currently is. "zooming"
 * specifies if user is currently zooming (is selecting) the chart.
 *
 * @author kevzlou7979
 */
public class SerialChangedEvent extends GwtEvent<SerialChangedEvent.SerialChangedHandler> {

    public static final Type<SerialChangedHandler> TYPE = new Type<>();
    private SerialChangedData data;

    public SerialChangedEvent(SerialChangedData data) {
        this.data = data;
    }

    public static Type<SerialChangedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, SerialChangedData data) {
        source.fireEvent(new SerialChangedEvent(data));
    }

    @Override
    public Type<SerialChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SerialChangedHandler handler) {
        handler.onChangedEvent(this);
    }

    public SerialChangedData getData() {
        return data;
    }

    public interface SerialChangedHandler extends EventHandler {
        void onChangedEvent(SerialChangedEvent event);
    }
}
