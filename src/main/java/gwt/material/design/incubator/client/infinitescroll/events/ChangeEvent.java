package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class ChangeEvent extends GwtEvent<ChangeEvent.ChangeHandler> {

    public static final Type<ChangeHandler> TYPE = new Type<>();

    public ChangeEvent() {}

    public static Type<ChangeHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new ChangeEvent());
    }

    @Override
    public Type<ChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ChangeHandler handler) {
        handler.onChartEnter(this);
    }

    public interface ChangeHandler extends EventHandler {
        void onChartEnter(ChangeEvent event);
    }
}
