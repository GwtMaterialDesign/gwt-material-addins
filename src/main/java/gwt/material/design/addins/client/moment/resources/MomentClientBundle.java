package gwt.material.design.addins.client.moment.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface MomentClientBundle extends ClientBundle {

    MomentClientBundle INSTANCE = GWT.create(MomentClientBundle.class);

    @Source("js/moment.min.js")
    TextResource momentJs();
}
