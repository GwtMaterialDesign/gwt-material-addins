package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class ShiftEvent extends GwtEvent<ShiftEvent.ShiftHandler> {

    public static final Type<ShiftHandler> TYPE = new Type<>();

    public ShiftEvent() {}

    public static Type<ShiftHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new ShiftEvent());
    }

    @Override
    public Type<ShiftHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShiftHandler handler) {
        handler.onChartEnter(this);
    }

    public interface ShiftHandler extends EventHandler {
        void onChartEnter(ShiftEvent event);
    }
}
