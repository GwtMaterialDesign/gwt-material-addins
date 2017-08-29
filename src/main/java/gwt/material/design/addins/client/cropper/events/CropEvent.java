package gwt.material.design.addins.client.cropper.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class CropEvent extends GwtEvent<CropEvent.CropHandler> {

    private String result;

    public interface CropHandler extends EventHandler {
        void onCrop(CropEvent event);
    }

    public static final Type<CropEvent.CropHandler> TYPE = new Type<>();

    public CropEvent(String result) {
        this.result = result;
    }

    public static void fire(HasHandlers source, String result) {
        source.fireEvent(new CropEvent(result));
    }

    @Override
    public Type<CropEvent.CropHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CropEvent.CropHandler handler) {
        handler.onCrop(this);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}