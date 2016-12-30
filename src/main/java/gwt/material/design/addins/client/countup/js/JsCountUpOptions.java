package gwt.material.design.addins.client.countup.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for CountUp component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCountUpOptions {

    @JsProperty
    public String separator;

    @JsProperty
    public String decimal;

    @JsProperty
    public String prefix;

    @JsProperty
    public String suffix;
}
