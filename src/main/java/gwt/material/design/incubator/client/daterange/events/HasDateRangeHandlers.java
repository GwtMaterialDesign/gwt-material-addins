package gwt.material.design.incubator.client.daterange.events;

import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.daterange.js.JsDateRange;

public interface HasDateRangeHandlers<T extends JsDateRange> extends HasOpenHandlers<T>, HasCloseHandlers<T> {

    HandlerRegistration addOpenCalendarHandler(OpenCalendarEvent.OpenCalendarEventHandler handler);
    HandlerRegistration addCloseCalendarHandler(CloseCalendarEvent.CloseCalendarEventHandler handler);
    HandlerRegistration addApplyHandler(ApplyEvent.ApplyEventHandler handler);
    HandlerRegistration addCancelHandler(CancelEvent.CancelEventHandler handler);
}
