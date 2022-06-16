package gwt.material.design.addins.client.pinch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface PinchDebugClientBundle extends ClientBundle {

    PinchDebugClientBundle INSTANCE = GWT.create(PinchDebugClientBundle.class);

    @Source("resources/js/pinch.js")
    TextResource pinchJs();
}