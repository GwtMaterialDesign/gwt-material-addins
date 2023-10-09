package gwt.material.design.addins.client.moment;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "moment")
public class MomentTimezone {

    public native MomentTimezone zone(String timeZone);

    public native String format(String format);

    @JsMethod(namespace = "moment.tz")
    public static native String guess();

    public native MomentTimezone add(int amount, String unit);
}
