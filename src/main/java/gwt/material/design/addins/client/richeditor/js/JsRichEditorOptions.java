package gwt.material.design.addins.client.richeditor.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for rich editor component
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsRichEditorOptions {

    @JsProperty
    public Object[][] toolbar;

    @JsProperty
    public boolean airMode;

    @JsProperty
    public boolean disableDragAndDrop;

    @JsProperty
    public boolean followingToolbar;

    @JsProperty
    public String placeholder;

    @JsProperty
    public String height;

    @JsProperty
    public double minHeight;

    @JsProperty
    public String defaultBackColor;

    @JsProperty
    public String defaultTextColor;
}
