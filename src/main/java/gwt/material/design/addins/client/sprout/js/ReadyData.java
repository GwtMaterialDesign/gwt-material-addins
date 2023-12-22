package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ReadyData {

    /**
     * The duration of the video in seconds.
     */
    @JsProperty
    public int duration;

    /**
     * The unique identifier for the current viewer.
     */
    @JsProperty
    public String viewerId;

    /**
     * The unique identifier for the current playback session.
     */
    @JsProperty
    public String sessionId;

    /**
     * The email address entered if the video requires an email address in ordered to be played.
     */
    @JsProperty
    public String email;

    /**
     * The first name entered if the video requires a name in ordered to be played.
     */
    @JsProperty
    public String vfname;

    /**
     * The last name entered if the video requires a name in ordered to be played.
     */
    @JsProperty
    public String vlname;
}
