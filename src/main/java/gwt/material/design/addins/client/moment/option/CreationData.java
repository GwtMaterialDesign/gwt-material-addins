package gwt.material.design.addins.client.moment.option;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class CreationData {

    @JsProperty
    public String input;

    @JsProperty
    public String format;

    @JsProperty
    public Object locale;

    @JsProperty
    public boolean isUTC;

    @JsProperty
    public boolean strict;
}
