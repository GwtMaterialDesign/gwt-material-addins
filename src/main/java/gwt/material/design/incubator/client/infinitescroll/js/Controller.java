package gwt.material.design.incubator.client.infinitescroll.js;

import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for ScrollMagic.Controller
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = "ScrollMagic")
public class Controller extends JQueryElement {

    @JsMethod
    public native Controller addScene(Scene scene);

    @JsMethod
    public native void destroy(boolean resetScenes);

    @JsMethod
    public native Controller removeScene(Scene scene);

    @JsMethod
    public native Controller scrollTo(Object scrollTarget, Object additionalParameter);

    @JsMethod
    public native Controller update(boolean immediately);

    @JsMethod
    public native Controller updateScene(Scene scene, boolean immediately);

    @JsMethod
    public native Controller enabled(boolean enabled);

    @JsMethod
    public native boolean enabled();

    @JsMethod
    public native Controller loglevel(int loglevel);

    @JsMethod
    public native int loglevel();

    @JsMethod
    public native Controller scrollPos(int scrollPos);

    @JsMethod
    public native int scrollPos();

    @JsProperty
    public native Object info(Object object);
}