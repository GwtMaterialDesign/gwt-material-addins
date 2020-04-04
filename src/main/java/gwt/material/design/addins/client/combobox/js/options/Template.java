package gwt.material.design.addins.client.combobox.js.options;

import gwt.material.design.jscore.client.api.core.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Template {

    @JsProperty
    public boolean selected;

    @JsProperty
    public boolean disabled;

    @JsProperty
    public String text;

    @JsProperty
    public String id;

    @JsProperty
    public Element element;
}
