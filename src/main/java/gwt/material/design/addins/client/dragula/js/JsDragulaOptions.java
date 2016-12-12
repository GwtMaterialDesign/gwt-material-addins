package gwt.material.design.addins.client.dragula.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for dragula component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDragulaOptions {

    @JsProperty
    public String direction;

    @JsProperty
    public boolean copy;

    @JsProperty
    public boolean copySortSource;

    @JsProperty
    public boolean revertOnSpill;

    @JsProperty
    public boolean removeOnSpill;

    @JsProperty
    public boolean ignoreInputTextSelection;
}
