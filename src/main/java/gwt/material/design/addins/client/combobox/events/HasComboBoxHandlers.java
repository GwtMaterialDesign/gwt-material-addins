package gwt.material.design.addins.client.combobox.events;

import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.combobox.base.HasUnselectItemHandler;
import gwt.material.design.client.events.ClosingEvent;
import gwt.material.design.client.events.OpeningEvent;

public interface HasComboBoxHandlers<T> extends HasOpenHandlers<T>, HasCloseHandlers<T>, HasUnselectItemHandler<T> {

    HandlerRegistration addOpeningHandler(OpeningEvent.OpeningHandler handler);

    HandlerRegistration addClosingHandler(ClosingEvent.ClosingHandler handler);
}
