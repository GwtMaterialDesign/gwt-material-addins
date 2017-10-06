package gwt.material.design.addins.client.splitpanel.js;

import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class TouchSplitter extends JQueryElement {

    public native void destroy();

    public native void destroy(String side);

    public native void toggleDock();

    public native void startDragging(Functions.EventFunc eventFunc);
}
