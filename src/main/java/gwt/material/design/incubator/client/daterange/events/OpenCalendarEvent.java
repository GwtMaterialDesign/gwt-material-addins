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
package gwt.material.design.incubator.client.daterange.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.daterange.js.JsDateRangePicker;

/**
 * Triggered when the picker is shown
 *
 * @author kevzlou7979
 */
public class OpenCalendarEvent extends GwtEvent<OpenCalendarEvent.OpenCalendarEventHandler> {

    public interface OpenCalendarEventHandler extends EventHandler {
        void onOpenCalendarEvent(OpenCalendarEvent event);
    }

    private JsDateRangePicker dateRange;

    public OpenCalendarEvent(JsDateRangePicker dateRange) {
        this.dateRange = dateRange;
    }

    public static final Type<OpenCalendarEventHandler> TYPE = new Type<>();

    public static Type<OpenCalendarEventHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, JsDateRangePicker dateRange) {
        source.fireEvent(new OpenCalendarEvent(dateRange));
    }

    public JsDateRangePicker getDateRange() {
        return dateRange;
    }

    @Override
    public Type<OpenCalendarEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OpenCalendarEvent.OpenCalendarEventHandler handler) {
        handler.onOpenCalendarEvent(this);
    }
}
