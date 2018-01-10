package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class ProgressEvent extends GwtEvent<ProgressEvent.ProgressHandler> {

    public static final Type<ProgressHandler> TYPE = new Type<>();

    public ProgressEvent() {}

    public static Type<ProgressHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new ProgressEvent());
    }

    @Override
    public Type<ProgressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ProgressHandler handler) {
        handler.onChartEnter(this);
    }

    public interface ProgressHandler extends EventHandler {
        void onChartEnter(ProgressEvent event);
    }
}
