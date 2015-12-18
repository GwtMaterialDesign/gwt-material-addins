package gwt.material.design.addins.client.ui;

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
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.ComplexWidget;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;

/**
 * Created by Mark Kevin on 12/18/2015.
 */
public class MaterialWaterfall extends ComplexWidget {

    private Runnable openCallback;
    private Runnable closeCallback;
    private double offset;

    public MaterialWaterfall() {
        super(Document.get().createDivElement());
        setStyleName("waterfall");
        setShadow(1);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(openCallback == null && closeCallback == null) {
            final Runnable openCallback = new Runnable() {
                @Override
                public void run() {
                    for(Widget w : getChildren()){
                        w.getElement().getStyle().setOpacity(1);
                    }
                }
            };
            final Runnable closeCallback = new Runnable() {
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
        initWaterfall(openCallback, closeCallback, offset);
    }

    public void setCallbacks(Runnable openCallback, Runnable closeCallback) {
        this.openCallback = openCallback;
        this.closeCallback = closeCallback;
    }

    private native void initWaterfall(Runnable openCallback, Runnable closeCallback, double offset) /*-{
        $wnd.jQuery(document).ready(function() {

            var openCallbackFn = $entry(function() {
                openCallback.@java.lang.Runnable::run()();
            });

            var closeCallbackFn = $entry(function() {
                closeCallback.@java.lang.Runnable::run()();
            });

            $wnd.initWaterfall(openCallbackFn, closeCallbackFn, offset);
        });
    }-*/;

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }
}
