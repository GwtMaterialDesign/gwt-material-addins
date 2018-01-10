package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class LeaveEvent extends GwtEvent<LeaveEvent.LeaveHandler> {

    public static final Type<LeaveHandler> TYPE = new Type<>();

    public LeaveEvent() {}

    public static Type<LeaveHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new LeaveEvent());
    }

    @Override
    public Type<LeaveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LeaveHandler handler) {
        handler.onChartEnter(this);
    }

    public interface LeaveHandler extends EventHandler {
        void onChartEnter(LeaveEvent event);
    }
}
