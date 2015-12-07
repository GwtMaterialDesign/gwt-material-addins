package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Element;

/**
 * Created by Mark Kevin on 12/7/2015.
 */
public class MaterialPathAnimator {

    public static native void animate(Element source, Element target) /*-{
      $wnd.cta(source, target);
    }-*/;

    public static native void animate(Element source, Element target, Runnable callback)/*-{
        $wnd.cta(source, target, function () {
            if(callback != null) {
                callback.@java.lang.Runnable::run()();
            }
        });
    }-*/;
}
