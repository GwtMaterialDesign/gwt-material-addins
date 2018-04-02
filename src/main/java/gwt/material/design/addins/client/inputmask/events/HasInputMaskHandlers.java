package gwt.material.design.addins.client.inputmask.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasInputMaskHandlers {

    HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler);

    HandlerRegistration addChangeHandler(ChangeEvent.ChangeHandler handler);

    HandlerRegistration addInvalidHandler(InvalidEvent.InvalidHandler handler);

    HandlerRegistration addKeyPressHandler(KeyPressEvent.KeyPressHandler handler);
}
