package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ProgressData {

    /**
     * A float value representing the position of the playhead in seconds from the beginning of the video.
     */
    @JsProperty
    public float time;

    /**
     * A float valuebetween 0.0 and 1.0 representing the position of the playhead as a percentage of the total duration
     * of the video.
     */
    @JsProperty
    public float percent;
}
