package gwt.material.design.addins.client.pinch.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class OnZoomEndEvent extends GwtEvent<OnZoomEndEvent.OnZoomEndHandler> {

    public interface OnZoomEndHandler extends EventHandler {
        void onOnZoomEnd(OnZoomEndEvent event);
    }

    public static final Type<OnZoomEndHandler> TYPE = new Type<>();

    public static void fire(HasHandlers source) {
        source.fireEvent(new OnZoomEndEvent());
    }

    @Override
    public Type<OnZoomEndHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OnZoomEndHandler handler) {
        handler.onOnZoomEnd(this);
    }
}