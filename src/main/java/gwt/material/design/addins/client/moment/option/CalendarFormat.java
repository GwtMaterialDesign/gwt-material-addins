package gwt.material.design.addins.client.moment.option;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class CalendarFormat {

    @JsProperty
    public String sameDay;

    @JsProperty
    public String nextDay;

    @JsProperty
    public String nextWeek;

    @JsProperty
    public String lastDay;

    @JsProperty
    public String lastWeek;

    @JsProperty
    public String sameElse;
}
