package gwt.material.design.addins.client.dnd.event.dispatch;

import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.DropActivateEvent;
import gwt.material.design.client.events.DropDeactivateEvent;
import gwt.material.design.client.events.DropEvent;
import gwt.material.design.jquery.client.api.JQueryElement;

public class DropEventDispatcher {

    private final MaterialWidget target;

    public DropEventDispatcher(MaterialWidget target) {
        this.target = target;
    }

    public void fireDropActiveEvent() {
        target.fireEvent(new GwtEvent<DropActivateEvent.DropActivateHandler>() {
            @Override
            public Type<DropActivateEvent.DropActivateHandler> getAssociatedType() {
                return DropActivateEvent.TYPE;
            }

            @Override
            protected void dispatch(DropActivateEvent.DropActivateHandler handler) {
                handler.onDropActivate(new DropActivateEvent());
            }
        });
    }

    public void fireDropEvent(JQueryElement relatedTarget) {
        target.fireEvent(new GwtEvent<DropEvent.DropHandler>() {
            @Override
            public Type<DropEvent.DropHandler> getAssociatedType() {
                return DropEvent.TYPE;
            }

            @Override
            protected void dispatch(DropEvent.DropHandler handler) {
                handler.onDrop(new DropEvent(relatedTarget));
            }
        });
    }

    public void fireDropDeactivateEvent() {
        target.fireEvent(new GwtEvent<DropDeactivateEvent.DropDeactivateHandler>() {
            @Override
            public Type<DropDeactivateEvent.DropDeactivateHandler> getAssociatedType() {
                return DropDeactivateEvent.TYPE;
            }

            @Override
            protected void dispatch(DropDeactivateEvent.DropDeactivateHandler handler) {
                handler.onDropDeactivate(new DropDeactivateEvent());
            }
        });
    }
}
