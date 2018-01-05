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
import gwt.material.design.incubator.client.chart.amcharts.events.object.LogarithmicAxisFailedData;
//@formatter:off

/**
 * Dispatched when valueAxis is logarithmic and values equal or less then zero were found in data.
 *
 * @author kevzlou7979
 */
public class LogarithmicAxisFailedEvent extends GwtEvent<LogarithmicAxisFailedEvent.LogarithmicAxisFailedHandler> {

    public static final Type<LogarithmicAxisFailedHandler> TYPE = new Type<>();
    private LogarithmicAxisFailedData data;

    public LogarithmicAxisFailedEvent(LogarithmicAxisFailedData data) {
        this.data = data;
    }

    public static Type<LogarithmicAxisFailedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, LogarithmicAxisFailedData data) {
        source.fireEvent(new LogarithmicAxisFailedEvent(data));
    }

    @Override
    public Type<LogarithmicAxisFailedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LogarithmicAxisFailedHandler handler) {
        handler.onLogarithmicAxisFailed(this);
    }

    public LogarithmicAxisFailedData getData() {
        return data;
    }

    public interface LogarithmicAxisFailedHandler extends EventHandler {
        void onLogarithmicAxisFailed(LogarithmicAxisFailedEvent event);
    }
}
