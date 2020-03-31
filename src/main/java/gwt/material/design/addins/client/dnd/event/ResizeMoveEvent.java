package gwt.material.design.addins.client.dnd.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ResizeMoveEvent extends GwtEvent<ResizeMoveEvent.ResizeMoveHandler> {

    public interface ResizeMoveHandler extends EventHandler {
        void onResizeMove(ResizeMoveEvent event);
    }

    public static final Type<ResizeMoveEvent.ResizeMoveHandler> TYPE = new Type<>();

    public static Type<ResizeMoveEvent.ResizeMoveHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new ResizeMoveEvent());
    }

    @Override
    public Type<ResizeMoveEvent.ResizeMoveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ResizeMoveEvent.ResizeMoveHandler handler) {
        handler.onResizeMove(this);
    }
}