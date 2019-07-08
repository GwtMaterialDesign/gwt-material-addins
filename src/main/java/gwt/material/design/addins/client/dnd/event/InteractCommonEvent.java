package gwt.material.design.addins.client.dnd.event;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Event;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class InteractCommonEvent extends Event {

    public InteractCommonEvent(String type) {
        super(type);
    }

    /**
     * The element that is being interacted with
     */
    @JsProperty
    public Element target;

    /**
     * The Interactable that is being interacted with
     */
    @JsProperty
    public Object interactable;

    /**
     * The Interaction that the event belongs to
     */
    @JsProperty
    public Object interaction;

    /**
     * Page x coordinate of the starting event
     */
    @JsProperty
    public float x0;

    /**
     * Page y coordinate of the starting event
     */
    @JsProperty
    public float y0;

    /**
     * Client x coordinate of the starting event
     */
    @JsProperty
    public float clientX0;

    /**
     * Client y coordinate of the starting event
     */
    @JsProperty
    public float clientY0;

    /**
     * Change in coordinates of the mouse/touch
     */
    @JsProperty
    public float dx;

    /**
     * Change in coordinates of the mouse/touch
     */
    @JsProperty
    public float dy;

    /**
     * The Velocity of the pointer
     */
    @JsProperty
    public float velocityX;

    /**
     * The Velocity of the pointer
     */
    @JsProperty
    public float velocityY;

    /**
     * The speed of the pointer
     */
    @JsProperty
    public double speed;

    /**
     * The time of creation of the event object
     */
    @JsProperty
    public Date timeStamp;
}
