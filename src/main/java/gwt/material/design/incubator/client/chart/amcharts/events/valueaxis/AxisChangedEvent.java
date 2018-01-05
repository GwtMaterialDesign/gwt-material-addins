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
import gwt.material.design.incubator.client.chart.amcharts.events.object.ValueAxisChangedData;
//@formatter:off

/**
 * Dispatched when value axis min/max values are changed.
 *
 * @author kevzlou7979
 */
public class AxisChangedEvent extends GwtEvent<AxisChangedEvent.AxisChangedHandler> {

    public static final Type<AxisChangedHandler> TYPE = new Type<>();
    private ValueAxisChangedData data;

    public AxisChangedEvent(ValueAxisChangedData data) {
        this.data = data;
    }

    public static Type<AxisChangedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, ValueAxisChangedData data) {
        source.fireEvent(new AxisChangedEvent(data));
    }

    @Override
    public Type<AxisChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AxisChangedHandler handler) {
        handler.onAxisChanged(this);
    }

    public ValueAxisChangedData getData() {
        return data;
    }

    public interface AxisChangedHandler extends EventHandler {
        void onAxisChanged(AxisChangedEvent event);
    }
}
