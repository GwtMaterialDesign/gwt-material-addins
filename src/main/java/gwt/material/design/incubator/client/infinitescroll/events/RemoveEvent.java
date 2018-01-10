package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class RemoveEvent extends GwtEvent<RemoveEvent.RemoveHandler> {

    public static final Type<RemoveHandler> TYPE = new Type<>();

    public RemoveEvent() {}

    public static Type<RemoveHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new RemoveEvent());
    }

    @Override
    public Type<RemoveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RemoveHandler handler) {
        handler.onChartEnter(this);
    }

    public interface RemoveHandler extends EventHandler {
        void onChartEnter(RemoveEvent event);
    }
}
