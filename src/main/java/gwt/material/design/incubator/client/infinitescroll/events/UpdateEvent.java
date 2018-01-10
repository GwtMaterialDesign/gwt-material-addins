package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class UpdateEvent extends GwtEvent<UpdateEvent.UpdateHandler> {

    public static final Type<UpdateHandler> TYPE = new Type<>();

    public UpdateEvent() {}

    public static Type<UpdateHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new UpdateEvent());
    }

    @Override
    public Type<UpdateHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(UpdateHandler handler) {
        handler.onChartEnter(this);
    }

    public interface UpdateHandler extends EventHandler {
        void onChartEnter(UpdateEvent event);
    }
}
