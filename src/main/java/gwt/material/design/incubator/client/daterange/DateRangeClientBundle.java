package gwt.material.design.incubator.client.daterange;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface DateRangeClientBundle extends ClientBundle {

    DateRangeClientBundle INSTANCE = GWT.create(DateRangeClientBundle.class);

    @Source("resources/js/daterangepicker.min.js")
    TextResource dateRangePickerJs();

    @Source("resources/css/daterangepicker.min.css")
    TextResource dateRangePickerCss();

    @Source("resources/css/daterangepicker-override.min.css")
    TextResource dateRangePickerOverrideCss();
}
