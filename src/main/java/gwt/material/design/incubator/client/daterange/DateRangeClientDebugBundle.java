package gwt.material.design.incubator.client.daterange;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface DateRangeClientDebugBundle extends ClientBundle {

    DateRangeClientDebugBundle INSTANCE = GWT.create(DateRangeClientDebugBundle.class);

    @Source("resources/js/daterangepicker.js")
    TextResource dateRangePickerDebugJs();

    @Source("resources/css/daterangepicker.css")
    TextResource dateRangePickerDebugCss();

    @Source("resources/css/daterangepicker-override.css")
    TextResource dateRangePickerOverrideDebugCss();
}
