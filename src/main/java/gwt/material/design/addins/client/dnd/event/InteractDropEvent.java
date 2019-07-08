package gwt.material.design.addins.client.dnd.event;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class InteractDropEvent extends InteractCommonEvent {

    public InteractDropEvent(String type) {
        super(type);
    }

    @JsProperty
    public Object dropzone;

    @JsProperty
    public Object relatedTarget;

    @JsProperty
    public Object draggable;

    @JsProperty
    public InteractDragEvent dragEvent;

    @JsProperty
    public Date timeStamp;

    @JsProperty
    public String type;
}
