package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class QualityLevel {

    /**
     * The width of the quality level
     */
    @JsProperty
    public int width;

    /**
     * The height of the quality level.
     */
    @JsProperty
    public int level;

    /**
     * A label representing the quality level (e.g. 1080p, 4K).
     */
    @JsProperty
    public String label;
}
