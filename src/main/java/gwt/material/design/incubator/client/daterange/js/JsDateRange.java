package gwt.material.design.incubator.client.daterange.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.combobox.js.JsComboBoxOptions;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true)
public class JsDateRange extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsDateRange $(String selector);

    @JsMethod
    public native void daterangepicker(DateRangeOptions options);

    @JsMethod
    public native void daterangepicker();

    @JsMethod
    public native void setStartDate(Date date);

    @JsMethod
    public native void setEndDate(Date date);


}
