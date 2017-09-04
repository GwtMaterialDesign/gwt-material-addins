package gwt.material.design.addins.client.signature.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class BeginSignatureEvent extends GwtEvent<BeginSignatureEvent.BeginSignatureHandler> {

    public interface BeginSignatureHandler extends EventHandler {
        void onBeginSignature(BeginSignatureEvent event);
    }

    public static final Type<BeginSignatureEvent.BeginSignatureHandler> TYPE = new Type<>();

    public BeginSignatureEvent() {}

    public static void fire(HasHandlers source) {
        source.fireEvent(new BeginSignatureEvent());
    }

    @Override
    public Type<BeginSignatureEvent.BeginSignatureHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BeginSignatureEvent.BeginSignatureHandler handler) {
        handler.onBeginSignature(this);
    }
}