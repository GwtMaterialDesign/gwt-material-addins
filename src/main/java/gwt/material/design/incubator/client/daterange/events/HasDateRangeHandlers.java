/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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

import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.daterange.js.JsDateRangePicker;

public interface HasDateRangeHandlers<T extends JsDateRangePicker> extends HasOpenHandlers<T>, HasCloseHandlers<T> {

    HandlerRegistration addApplyHandler(ApplyEvent.ApplyEventHandler handler);
    HandlerRegistration addCancelHandler(CancelEvent.CancelEventHandler handler);
    HandlerRegistration addCloseCalendarHandler(CloseCalendarEvent.CloseCalendarEventHandler handler);
    HandlerRegistration addNextCalendarHandler(NextCalendarEvent.NextCalendarEventHandler handler);
    HandlerRegistration addOpenCalendarHandler(OpenCalendarEvent.OpenCalendarEventHandler handler);
    HandlerRegistration addPreviousCalendarHandler(PreviousCalendarEvent.PreviousCalendarEventHandler handler);
    HandlerRegistration addSelectionHandler(SelectionEvent.SelectionEventHandler handler);
}
