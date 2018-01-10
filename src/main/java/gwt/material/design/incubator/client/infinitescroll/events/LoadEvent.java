package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class LoadEvent extends GwtEvent<LoadEvent.LoadHandler> {

    public static final Type<LoadHandler> TYPE = new Type<>();

    public LoadEvent() {}

    public static Type<LoadHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new LoadEvent());
    }

    @Override
    public Type<LoadHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoadHandler handler) {
        handler.onChartEnter(this);
    }

    public interface LoadHandler extends EventHandler {
        void onChartEnter(LoadEvent event);
    }
}
