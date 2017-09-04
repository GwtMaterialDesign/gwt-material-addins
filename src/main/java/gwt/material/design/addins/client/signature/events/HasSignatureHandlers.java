package gwt.material.design.addins.client.signature.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasSignatureHandlers {

    HandlerRegistration addClearSignatureHandler(ClearSignatureEvent.ClearSignatureHandler handler);

    HandlerRegistration addBeginSignatureHandler(BeginSignatureEvent.BeginSignatureHandler handler);

    HandlerRegistration addEndSignatureHandler(EndSignatureEvent.EndSignatureHandler handler);
}
