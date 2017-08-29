package gwt.material.design.addins.client.cropper.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasCropEvents {

    HandlerRegistration addCropHandler(CropEvent.CropHandler handler);
}
