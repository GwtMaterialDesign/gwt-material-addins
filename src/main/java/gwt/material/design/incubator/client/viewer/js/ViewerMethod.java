package gwt.material.design.incubator.client.viewer.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ViewerMethod {

    @JsMethod
    public native void show(boolean fireEvent);

    @JsMethod
    public native void hide(boolean fireEvent);

    @JsMethod
    public native void view(Integer index);

    @JsMethod
    public native void prev(boolean fireEvent);

    @JsMethod
    public native void next(boolean fireEvent);

    @JsMethod
    public native void move(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void moveTo(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void rotate(Integer degree);

    @JsMethod
    public native void rotateTo(Integer degree);

    @JsMethod
    public native void rotateTo(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void scaleX(Integer scaleX);

    @JsMethod
    public native void scaleY(Integer scaleX);

    @JsMethod
    public native void zoom(Integer ratio, boolean hasToolTip);

    @JsMethod
    public native void zoomTo(Integer ratio, boolean hasToolTip);

    @JsMethod
    public native void play(boolean fullScreen);

    @JsMethod
    public native void stop();

    @JsMethod
    public native void full();

    @JsMethod
    public native void exit();

    @JsMethod
    public native void tooltip();

    @JsMethod
    public native void toggle();

    @JsMethod
    public native void reset();

    @JsMethod
    public native void update();

    @JsMethod
    public native void destroy();

}
