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
package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.LegendEventData;
//@formatter:off

/**
 * Dispatched when user rolls-out of the legend item label (or whole item, if switchable is set to false).
 *
 * @author kevzlou7979
 */
public class RollOutItemEvent extends GwtEvent<RollOutItemEvent.RollOutItemHandler> {

    public static final Type<RollOutItemHandler> TYPE = new Type<>();
    private LegendEventData data;

    public RollOutItemEvent(LegendEventData data) {
        this.data = data;
    }

    public static Type<RollOutItemHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, LegendEventData data) {
        source.fireEvent(new RollOutItemEvent(data));
    }

    @Override
    public Type<RollOutItemHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RollOutItemEvent.RollOutItemHandler handler) {
        handler.onRollOutItem(this);
    }

    public LegendEventData getData() {
        return data;
    }

    public interface RollOutItemHandler extends EventHandler {
        void onRollOutItem(RollOutItemEvent event);
    }
}
