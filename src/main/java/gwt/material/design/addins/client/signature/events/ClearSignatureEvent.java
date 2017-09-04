package gwt.material.design.addins.client.signature.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ClearSignatureEvent extends GwtEvent<ClearSignatureEvent.ClearSignatureHandler> {

    public interface ClearSignatureHandler extends EventHandler {
        void onClearSignature(ClearSignatureEvent event);
    }

    public static final Type<ClearSignatureEvent.ClearSignatureHandler> TYPE = new Type<>();

    public ClearSignatureEvent() {}

    public static void fire(HasHandlers source) {
        source.fireEvent(new ClearSignatureEvent());
    }

    @Override
    public Type<ClearSignatureEvent.ClearSignatureHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClearSignatureEvent.ClearSignatureHandler handler) {
        handler.onClearSignature(this);
    }
}