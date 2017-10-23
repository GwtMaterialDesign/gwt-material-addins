/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.waterfall;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.waterfall.js.JsWaterfall;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Material Waterfall - Act like a collapsible header below the nav bar component when scrolling up / down to provide delightful transition of components.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
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
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#waterfall">Material Waterfall</a>
 */
//@formatter:on
public class MaterialWaterfall extends MaterialWidget implements JsLoader {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialWaterfallDebugClientBundle.INSTANCE.waterfallJsDebug());
            MaterialDesignBase.injectCss(MaterialWaterfallDebugClientBundle.INSTANCE.waterfallCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialWaterfallClientBundle.INSTANCE.waterfallJs());
            MaterialDesignBase.injectCss(MaterialWaterfallClientBundle.INSTANCE.waterfallCss());
        }
    }

    private Functions.Func openCallback;
    private Functions.Func closeCallback;
    private double offset;

    public MaterialWaterfall() {
        super(Document.get().createDivElement(), AddinsCssName.WATERFALL);
        setShadow(1);
    }

    public MaterialWaterfall(Color backgroundColor, Color textColor) {
        this();
        setBackgroundColor(backgroundColor);
        setTextColor(textColor);
    }

    @Override
    protected void onLoad() {
        if (openCallback == null) {
            openCallback = () -> {
                for (Widget w : getChildren()) {
                    w.getElement().getStyle().setOpacity(1);
                }
            };
        }
        if (closeCallback == null) {
            closeCallback = () -> {
                for (Widget w : getChildren()) {
                    w.getElement().getStyle().setOpacity(0);
                }
            };
        }
        if (offset == 0) {
            offset = getOffsetHeight();
        }

        super.onLoad();

        load();
    }

    @Override
    public void load() {
        JsWaterfall.initWaterfall(getElement().getOffsetHeight(), openCallback::call, closeCallback::call, offset);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        closeCallback = null;
        openCallback = null;
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public void setCallbacks(Functions.Func openCallback, Functions.Func closeCallback) {
        this.openCallback = openCallback;
        this.closeCallback = closeCallback;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }


}
