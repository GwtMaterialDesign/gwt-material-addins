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
import gwt.material.design.incubator.client.chart.amcharts.events.object.CoreEventData;

//@formatter:off

/**
 * Dispatched when chart is build for the first time or after validateData() method was called.
 *
 * @author kevzlou7979
 */
public class DataUpdatedEvent extends GwtEvent<DataUpdatedEvent.DataUpdatedHandler> {

    public static final Type<DataUpdatedHandler> TYPE = new Type<>();
    private CoreEventData data;

    public DataUpdatedEvent(CoreEventData data) {
        this.data = data;
    }

    public static Type<DataUpdatedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoreEventData data) {
        source.fireEvent(new DataUpdatedEvent(data));
    }

    @Override
    public Type<DataUpdatedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DataUpdatedEvent.DataUpdatedHandler handler) {
        handler.onDataUpdated(this);
    }

    public CoreEventData getData() {
        return data;
    }

    public interface DataUpdatedHandler extends EventHandler {
        void onDataUpdated(DataUpdatedEvent event);
    }
}
