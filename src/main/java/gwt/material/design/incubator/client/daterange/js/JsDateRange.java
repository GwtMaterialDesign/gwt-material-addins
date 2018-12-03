package gwt.material.design.incubator.client.daterange.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Date;

/**
 * JSInterop utils for {@link gwt.material.design.incubator.client.daterange.DateRangePicker}
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "DateRangePicker")
public class JsDateRange extends DateRangeOptions {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(String selector);

    @JsMethod
    public native void daterangepicker(DateRangeOptions options);

    @JsMethod
    public native void daterangepicker(DateRangeOptions options, Functions.Func3<Date, Date, Object> callback);

    @JsMethod
    public native void daterangepicker();

    public native JsDateRange on(String event, Functions.EventFunc1<JsDateRange> callback);

    public native JsDateRange off(String event);
}
