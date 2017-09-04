package gwt.material.design.addins.client.signature.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class EndSignatureEvent extends GwtEvent<EndSignatureEvent.EndSignatureHandler> {

    public interface EndSignatureHandler extends EventHandler {
        void onEndSignature(EndSignatureEvent event);
    }

    public static final Type<EndSignatureEvent.EndSignatureHandler> TYPE = new Type<>();

    public EndSignatureEvent() {}

    public static void fire(HasHandlers source) {
        source.fireEvent(new EndSignatureEvent());
    }

    @Override
    public Type<EndSignatureEvent.EndSignatureHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EndSignatureEvent.EndSignatureHandler handler) {
        handler.onEndSignature(this);
    }
}