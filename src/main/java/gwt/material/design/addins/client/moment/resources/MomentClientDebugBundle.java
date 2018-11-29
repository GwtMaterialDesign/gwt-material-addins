package gwt.material.design.addins.client.moment.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface MomentClientDebugBundle extends ClientBundle {

    MomentClientDebugBundle INSTANCE = GWT.create(MomentClientDebugBundle.class);

    @Source("js/moment.js")
    TextResource momentDebugJs();
}
