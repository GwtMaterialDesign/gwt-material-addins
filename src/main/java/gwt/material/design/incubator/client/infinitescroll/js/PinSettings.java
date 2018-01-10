package gwt.material.design.incubator.client.infinitescroll.js;

import gwt.material.design.jscore.client.api.core.Element;
import jsinterop.annotations.JsProperty;

/**
 * Pin Settings set in {@link Scene#setPin(Element, PinSettings)}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://scrollmagic.io/docs/ScrollMagic.Scene.html#setPin">Official Documentation</a>
 */
public class PinSettings {

    /**
     * If true following elements will be "pushed" down for the duration of the pin, if false the pinned element will
     * just scroll past them. Ignored, when duration is 0. Default to true
     */
    @JsProperty
    public boolean pushFollowers;

    /**
     * Classname of the pin spacer element, which is used to replace the element. Default to "scrollmagic-pin-spacer"
     */
    @JsProperty
    public String spacerClass;
}
