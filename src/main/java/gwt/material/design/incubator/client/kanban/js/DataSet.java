package gwt.material.design.incubator.client.kanban.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DataSet {

    @JsProperty
    private String eid;

    @JsOverlay
    public final String getId() {
        return eid;
    }
}
