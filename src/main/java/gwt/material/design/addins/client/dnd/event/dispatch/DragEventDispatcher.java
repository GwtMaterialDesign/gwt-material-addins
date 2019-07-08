package gwt.material.design.addins.client.dnd.event.dispatch;

import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.events.*;
import gwt.material.design.jquery.client.api.JQueryElement;

public class DragEventDispatcher {

    private final MaterialWidget target;

    public DragEventDispatcher(MaterialWidget target) {
        this.target = target;
    }

    public void fireDragStartEvent() {
        target.fireEvent(new GwtEvent<DragStartEvent.DragStartHandler>() {
            @Override
            public Type<DragStartEvent.DragStartHandler> getAssociatedType() {
                return DragStartEvent.TYPE;
            }

            @Override
            public void dispatch(DragStartEvent.DragStartHandler handler) {
                handler.onDragStart(new DragStartEvent());
            }
        });
    }

    public void fireDragMoveEvent() {
        target.fireEvent(new GwtEvent<DragMoveEvent.DragMoveHandler>() {
            @Override
            public Type<DragMoveEvent.DragMoveHandler> getAssociatedType() {
                return DragMoveEvent.TYPE;
            }

            @Override
            public void dispatch(DragMoveEvent.DragMoveHandler handler) {
                handler.onDragMove(new DragMoveEvent());
            }
        });
    }

    public void fireDragEndEvent() {
        target.fireEvent(new GwtEvent<DragEndEvent.DragEndHandler>() {
            @Override
            public Type<DragEndEvent.DragEndHandler> getAssociatedType() {
                return DragEndEvent.TYPE;
            }

            @Override
            public void dispatch(DragEndEvent.DragEndHandler handler) {
                handler.onDragEnd(new DragEndEvent());
            }
        });
    }

    public void fireDragEnterEvent(JQueryElement relatedTarget) {
        target.fireEvent(new GwtEvent<DragEnterEvent.DragEnterHandler>() {
            @Override
            public Type<DragEnterEvent.DragEnterHandler> getAssociatedType() {
                return DragEnterEvent.TYPE;
            }

            @Override
            protected void dispatch(DragEnterEvent.DragEnterHandler handler) {
                handler.onDragEnter(new DragEnterEvent(relatedTarget));
            }
        });
    }

    public void fireDragLeaveEvent(JQueryElement relatedTarget) {
        target.fireEvent(new GwtEvent<DragLeaveEvent.DragLeaveHandler>() {
            @Override
            public Type<DragLeaveEvent.DragLeaveHandler> getAssociatedType() {
                return DragLeaveEvent.TYPE;
            }

            @Override
            protected void dispatch(DragLeaveEvent.DragLeaveHandler handler) {
                handler.onDragLeave(new DragLeaveEvent(relatedTarget));
            }
        });
    }
}
