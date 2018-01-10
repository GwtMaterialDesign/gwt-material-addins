package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class StartEvent extends GwtEvent<StartEvent.StartHandler> {

    public static final Type<StartHandler> TYPE = new Type<>();

    public StartEvent() {}

    public static Type<StartHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new StartEvent());
    }

    @Override
    public Type<StartHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(StartHandler handler) {
        handler.onChartEnter(this);
    }

    public interface StartHandler extends EventHandler {
        void onChartEnter(StartEvent event);
    }
}
