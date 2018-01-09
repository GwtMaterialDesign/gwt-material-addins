package gwt.material.design.incubator.client.infinitescroll.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class SceneOptions {

    @JsProperty
    public int duration;

    @JsProperty
    public int offset;

    @JsProperty
    public Object triggerElement;

    @JsProperty
    public Object triggerHook;

    @JsProperty
    public boolean reverse;

    @JsProperty
    public int loglevel;
}
