package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class AddEvent extends GwtEvent<AddEvent.AddHandler> {

    public static final Type<AddHandler> TYPE = new Type<>();

    public AddEvent() {}

    public static Type<AddHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new AddEvent());
    }

    @Override
    public Type<AddHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddHandler handler) {
        handler.onChartEnter(this);
    }

    public interface AddHandler extends EventHandler {
        void onChartEnter(AddEvent event);
    }
}
