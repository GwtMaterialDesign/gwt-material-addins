package gwt.material.design.addins.client.pinch;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface PinchClientBundle extends ClientBundle {

    PinchClientBundle INSTANCE = GWT.create(PinchClientBundle.class);

    @Source("resources/js/pinch.min.js")
    TextResource pinchJs();
}
