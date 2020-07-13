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
 *  Triggered when the Previous button is pressed to proceed to the previous calendar
 *
 * @author kevzlou7979
 */
public class PreviousCalendarEvent extends GwtEvent<PreviousCalendarEvent.PreviousCalendarEventHandler> {

    public interface PreviousCalendarEventHandler extends EventHandler {
        void onPreviousCalendarEvent(PreviousCalendarEvent event);
    }

    public static final Type<PreviousCalendarEventHandler> TYPE = new Type<>();

    private JsDateRangePicker dateRange;

    public PreviousCalendarEvent(JsDateRangePicker dateRange) {
        this.dateRange = dateRange;
    }

    public static Type<PreviousCalendarEventHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, JsDateRangePicker dateRange) {
        source.fireEvent(new PreviousCalendarEvent(dateRange));
    }

    public JsDateRangePicker getDateRange() {
        return dateRange;
    }

    @Override
    public Type<PreviousCalendarEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PreviousCalendarEventHandler handler) {
        handler.onPreviousCalendarEvent(this);
    }
}
