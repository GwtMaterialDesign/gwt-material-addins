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
package gwt.material.design.incubator.client.chart.amcharts.events.valueaxis;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.ValueAxisZoomedData;
//@formatter:off

/**
 * Dispatched when axis is zoomed.
 *
 * @author kevzlou7979
 */
public class AxisZoomedEvent extends GwtEvent<AxisZoomedEvent.AxisZoomedHandler> {

    public static final Type<AxisZoomedHandler> TYPE = new Type<>();
    private ValueAxisZoomedData data;

    public AxisZoomedEvent(ValueAxisZoomedData data) {
        this.data = data;
    }

    public static Type<AxisZoomedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, ValueAxisZoomedData data) {
        source.fireEvent(new AxisZoomedEvent(data));
    }

    @Override
    public Type<AxisZoomedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AxisZoomedHandler handler) {
        handler.onAxisZoomed(this);
    }

    public ValueAxisZoomedData getData() {
        return data;
    }

    public interface AxisZoomedHandler extends EventHandler {
        void onAxisZoomed(AxisZoomedEvent event);
    }
}
