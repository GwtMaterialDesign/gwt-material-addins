package gwt.material.design.incubator.client.daterange;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.incubator.client.infinitescroll.InfiniteScrollPanel;

/**
 * Client Bundle for {@link DateRangePicker}
 *
 * @author kevzlou7979
 */
public interface DateRangeClientBundle extends ClientBundle {

    DateRangeClientBundle INSTANCE = GWT.create(DateRangeClientBundle.class);

    @Source("resources/js/daterangepicker.min.js")
    TextResource dateRangePickerJs();

    @Source("resources/css/daterangepicker.min.css")
    TextResource dateRangePickerCss();

    @Source("resources/css/daterangepicker-materialize.min.css")
    TextResource dateRangePickerOverrideCss();
}
