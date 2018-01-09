package gwt.material.design.incubator.client.infinitescroll.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for ScrollMagic.Scene
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = "ScrollMagic")
public class Scene extends JQueryElement {

    public Scene(SceneOptions options) {}

    @JsMethod
    public native Scene addTo(Controller controller);

    @JsMethod
    public native void update();
}
