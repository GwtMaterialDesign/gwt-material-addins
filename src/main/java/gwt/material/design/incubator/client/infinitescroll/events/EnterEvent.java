package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class EnterEvent extends GwtEvent<EnterEvent.EnterHandler> {

    public static final Type<EnterHandler> TYPE = new Type<>();

    public EnterEvent() {}

    public static Type<EnterHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new EnterEvent());
    }

    @Override
    public Type<EnterHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EnterHandler handler) {
        handler.onChartEnter(this);
    }

    public interface EnterHandler extends EventHandler {
        void onChartEnter(EnterEvent event);
    }
}
