package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.addins.client.moment.Moment;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import static gwt.material.design.addins.client.moment.Moment.moment;

/**
 * @author kevzlou7979
 * @see {@link gwt.material.design.incubator.client.daterange.DateRangePicker#setRanges(Object)}
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class RangeOption {

    private RangeOption() {
    }

    @JsOverlay
    public static final RangeOption create() {
        RangeOption range = new RangeOption();
        range.Today = new Moment[]{moment(), moment()};
        range.Yesterday = new Moment[]{moment().subtract(1, "days"), moment().subtract(1, "days")};
        range.Last7Days = new Moment[]{moment().subtract(6, "days"), moment()};
        range.Last30Days = new Moment[]{moment().subtract(29, "days"), moment()};
        range.ThisMonth = new Moment[]{moment().startOf("month"), moment().endOf("month")};
        range.LastMonth = new Moment[]{moment().subtract(1, "month"), moment().startOf("month")};
        return range;
    }

    @JsProperty
    public Moment[] Today;

    @JsProperty
    public Moment[] Yesterday;

    @JsProperty
    public Moment[] Last7Days;

    @JsProperty
    public Moment[] Last30Days;

    @JsProperty
    public Moment[] ThisMonth;

    @JsProperty
    public Moment[] LastMonth;
}
