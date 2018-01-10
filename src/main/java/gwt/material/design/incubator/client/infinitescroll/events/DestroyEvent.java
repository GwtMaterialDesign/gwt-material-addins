package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class DestroyEvent extends GwtEvent<DestroyEvent.DestroyHandler> {

    public static final Type<DestroyHandler> TYPE = new Type<>();

    public DestroyEvent() {}

    public static Type<DestroyHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new DestroyEvent());
    }

    @Override
    public Type<DestroyHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DestroyHandler handler) {
        handler.onChartEnter(this);
    }

    public interface DestroyHandler extends EventHandler {
        void onChartEnter(DestroyEvent event);
    }
}
