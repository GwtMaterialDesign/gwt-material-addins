package gwt.material.design.addins.client.moment;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Moment {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Moment moment();

    @JsMethod
    public native Moment subtract(int number, String duration);

    @JsMethod
    public native Moment startOf(String duration);

    @JsMethod
    public native Moment endOf(String duration);
}
