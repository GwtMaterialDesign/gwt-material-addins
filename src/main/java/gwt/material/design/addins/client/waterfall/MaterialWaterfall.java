package gwt.material.design.addins.client.waterfall;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.MaterialWidget;

//@formatter:off
/**
 * Material Waterfall - Act like a collapsible header below the nav bar component when scrolling up / down to provide delightful transition of components.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *
 * <ma:waterfall.MaterialWaterfall backgroundColor="blue" textColor="white" height="280px">
 *      <m:MaterialPanel addStyleNames="container" paddingTop="20">
 *          <m:MaterialTitle title="GWT Material" description="Google Material Design UI / UX for GWT Applications."/>
 *          <m:MaterialAnchorButton text="Get Started" size="LARGE" backgroundColor="blue lighten-2" textColor="white"/>
 *      </m:MaterialPanel>
 * </ma:waterfall.MaterialWaterfall>
 *
 * </pre>
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#waterfall">Material Waterfall</a>
 * @author kevzlou7979
 */
//@formatter:on
public class MaterialWaterfall extends MaterialWidget {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialWaterfallDebugClientBundle.INSTANCE.waterfallJsDebug());
            MaterialResourceInjector.injectCss(MaterialWaterfallDebugClientBundle.INSTANCE.waterfallCssDebug());
        } else {
            MaterialResourceInjector.injectJs(MaterialWaterfallClientBundle.INSTANCE.waterfallJs());
            MaterialResourceInjector.injectCss(MaterialWaterfallClientBundle.INSTANCE.waterfallCss());
        }
    }

    private Runnable openCallback;
    private Runnable closeCallback;
    private double offset;

    public MaterialWaterfall() {
        super(Document.get().createDivElement(), "waterfall");
        setShadow(1);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(openCallback == null && closeCallback == null) {
            openCallback = new Runnable() {
                @Override
                public void run() {
                    for(Widget w : getChildren()){
                        w.getElement().getStyle().setOpacity(1);
                    }
                }
            };
            closeCallback = new Runnable() {
                @Override
                public void run() {
                    for(Widget w : getChildren()){
                        w.getElement().getStyle().setOpacity(0);
                    }
                }
            };
        }
        if(offset == 0){
            offset = getOffsetHeight();
        }
        initWaterfall(getElement().getOffsetHeight(), openCallback, closeCallback, offset);
    }

    public void setCallbacks(Runnable openCallback, Runnable closeCallback) {
        this.openCallback = openCallback;
        this.closeCallback = closeCallback;
    }

    private native void initWaterfall(double height, Runnable openCallback, Runnable closeCallback, double offset) /*-{
        $wnd.jQuery(document).ready(function() {

            var openCallbackFn = $entry(function() {
                openCallback.@java.lang.Runnable::run()();
            });

            var closeCallbackFn = $entry(function() {
                closeCallback.@java.lang.Runnable::run()();
            });

            $wnd.initWaterfall(height, openCallbackFn, closeCallbackFn, offset);
        });
    }-*/;

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }
}
