package gwt.material.design.addins.client.pinch.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class OnZoomStartEvent extends GwtEvent<OnZoomStartEvent.OnZoomStartHandler> {

    public interface OnZoomStartHandler extends EventHandler {
        void onOnZoomStart(OnZoomStartEvent event);
    }

    public static final Type<OnZoomStartHandler> TYPE = new Type<>();

    public static void fire(HasHandlers source) {
        source.fireEvent(new OnZoomStartEvent());
    }

    @Override
    public Type<OnZoomStartHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OnZoomStartHandler handler) {
        handler.onOnZoomStart(this);
    }
}