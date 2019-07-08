package gwt.material.design.addins.client.dnd.event;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class InteractDragEvent extends InteractCommonEvent {

    public InteractDragEvent(String type) {
        super(type);
    }

    @JsProperty
    public Object dragEnter;

    @JsProperty
    public Object dragLeave;
}
