package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class EndEvent extends GwtEvent<EndEvent.EndHandler> {

    public static final Type<EndHandler> TYPE = new Type<>();

    public EndEvent() {}

    public static Type<EndHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new EndEvent());
    }

    @Override
    public Type<EndHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EndHandler handler) {
        handler.onChartEnter(this);
    }

    public interface EndHandler extends EventHandler {
        void onChartEnter(EndEvent event);
    }
}
