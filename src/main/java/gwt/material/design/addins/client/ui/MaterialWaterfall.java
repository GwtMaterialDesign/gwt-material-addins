package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Document;
import gwt.material.design.client.base.ComplexWidget;

/**
 * Created by Mark Kevin on 12/18/2015.
 */
public class MaterialWaterfall extends ComplexWidget {

    public MaterialWaterfall() {
        super(Document.get().createDivElement());
        setStyleName("waterfall");
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        final ComplexWidget child = (ComplexWidget) getWidget(0);
        final Runnable openCallback = new Runnable() {
            @Override
            public void run() {

                child.setOpacity(1);

            }
        };

        final Runnable closeCallback = new Runnable() {
            @Override
            public void run() {

                child.setOpacity(0);

            }
        };
        initWaterfall(openCallback, closeCallback);
    }



    private native void initWaterfall(Runnable openCallback, Runnable closeCallback) /*-{
        $wnd.jQuery(document).ready(function() {

            var openCallbackFn = $entry(function() {
                openCallback.@java.lang.Runnable::run()();
            });

            var closeCallbackFn = $entry(function() {
                closeCallback.@java.lang.Runnable::run()();
            });

            $wnd.initWaterfall(openCallbackFn, closeCallbackFn);
        });
    }-*/;
}
