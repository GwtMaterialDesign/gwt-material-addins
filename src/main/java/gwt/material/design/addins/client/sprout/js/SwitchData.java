package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class SwitchData {

    /**
     * The ID of the video to which the playlist just switched.
     */
    @JsProperty
    public String videoID;

    /**
     * The index of the video in the playlist to which the playlist just switched.
     */
    @JsProperty
    public int videoIndex;
}
