package gwt.material.design.addins.client.pinch.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasPinchZoomHandlers {

    HandlerRegistration addOnZoomStartHandler(OnZoomStartEvent.OnZoomStartHandler handler);

    HandlerRegistration addOnZoomEndHandler(OnZoomEndEvent.OnZoomEndHandler handler);
}
