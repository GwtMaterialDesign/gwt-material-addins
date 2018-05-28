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
package gwt.material.design.addins.client.splitpanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.addins.client.splitpanel.constants.Side;
import gwt.material.design.addins.client.splitpanel.js.JsSplitPanelOptions;
import gwt.material.design.addins.client.splitpanel.js.TouchSplitter;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.ColorsMixin;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.Color;
import gwt.material.design.jquery.client.api.JQueryElement;

import static gwt.material.design.addins.client.splitpanel.js.JsSplitPanel.$;

//@formatter:off

/**
 * A high performance content splitter compatible with touch events
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
 *   <ma:splitpanel.MaterialSplitPanel height="500px">
 *       <m:MaterialPanel grid="l6 m6 s6" backgroundColor="grey lighten-2">
 *           <m:MaterialTitle textAlign="CENTER" title="Left Zone" description="Content must be added here"/>
 *       </m:MaterialPanel>
 *       <m:MaterialPanel grid="l6 m6 s6" backgroundColor="grey lighten-3">
 *           <m:MaterialTitle textAlign="CENTER" title="Right Zone" description="Content must be added here"/>
 *       </m:MaterialPanel>
 *   </ma:splitpanel.MaterialSplitPanel>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#splitpanel">Split Panel</a>
 * @see <a href="https://material.io/guidelines/layout/split-screen.html#split-screen-usage">Material Design Specification</a>
 * @see <a href="https://github.com/colelawrence/Touch-Splitter-jQuery">TouchSplitterJQuery 0.5.1</a>
 */
//@formatter:on
public class MaterialSplitPanel extends MaterialWidget implements JsLoader {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugJs());
            MaterialDesignBase.injectCss(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugCss());
        } else {
            MaterialDesignBase.injectDebugJs(MaterialSplitPanelClientBundle.INSTANCE.splitPanelJs());
            MaterialDesignBase.injectCss(MaterialSplitPanelClientBundle.INSTANCE.splitPanelCss());
        }
    }

    private TouchSplitter touchSplitter;
    private JsSplitPanelOptions options = JsSplitPanelOptions.create();
    private Color splitterLineColor = Color.BLACK;

    public MaterialSplitPanel() {
        super(Document.get().createDivElement());
        setSplitterLineColor(splitterLineColor);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        options.dock = getDock().getCssName();
        options.orientation = getAxis().getCssName();
        touchSplitter = $(getElement()).touchSplit(options);
    }

    public TouchSplitter getTouchSplitter() {
        return touchSplitter;
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        destroy();
    }

    public void destroy() {
        destroy(Side.ALL);
    }

    public void destroy(Side side) {
        if (touchSplitter != null) {
            touchSplitter.destroy(side.getCssName());
        } else {
            GWT.log("Please initialize the touchsplitter.", new IllegalStateException());
        }
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    /**
     * Get the bar position in percent divided by 100.
     */
    public double getBarPosition() {
        return options.barPosition;
    }

    /**
     * Set the bar position in percent.
     */
    public void setBarPosition(double barPosition) {
        options.barPosition = barPosition / 100;
    }

    /**
     * Get the bar's thickness in px.
     */
    public double getThickness() {
        return options.thickness != null ? Double.parseDouble(options.thickness.replace("px", "")) : null;
    }

    /**
     * Set the bar's thickness in px.
     */
    public void setThickness(double thickness) {
        options.thickness = thickness + "px";
    }

    /**
     * Get the Maximum left space.
     */
    public double getLeftMax() {
        return options.leftMax;
    }

    /**
     * Set the Maximum left space while dragging horizontally.
     */
    public void setLeftMax(double leftMax) {
        options.leftMax = leftMax;
    }

    /**
     * Get the Minimum left max space.
     */
    public double getLeftMin() {
        return options.leftMin;
    }

    /**
     * Set the Minimum left space while dragging horizontally.
     */
    public void setLeftMin(double leftMin) {
        options.leftMin = leftMin;
    }

    /**
     * Get the Maximum right space.
     */
    public double getRightMax() {
        return options.rightMax;
    }

    /**
     * Set the Maximum right space while dragging horizontally.
     */
    public void setRightMax(double rightMax) {
        options.rightMax = rightMax;
    }

    /**
     * Get the minimum right space.
     */
    public double getRightMin() {
        return options.rightMin;
    }

    /**
     * Set the minimum right space while dragging horizontally.
     */
    public void setRightMin(double rightMin) {
        options.rightMin = rightMin;
    }

    /**
     * Get the minimum top space.
     */
    public double getTopMin() {
        return options.topMin;
    }

    /**
     * Set the minimum top space while dragging vertically.
     */
    public void setTopMin(double topMin) {
        options.topMin = topMin;
    }

    /**
     * Get the maximum top space.
     */
    public double getTopMax() {
        return options.topMax;
    }

    /**
     * Set the maximum top space while dragging vertically.
     */
    public void setTopMax(double topMax) {
        options.topMax = topMax;
    }

    /**
     * Get the minimum bottom space.
     */
    public double getBottomMin() {
        return options.bottomMin;
    }

    /**
     * Set the minimum bottom space while dragging vertically.
     */
    public void setBottomMin(double bottomMin) {
        options.bottomMin = bottomMin;
    }

    /**
     * Get the maximum bottom space.
     */
    public double getBottomMax() {
        return options.bottomMax;
    }

    /**
     * Set the maximum bottom space while dragging vertically.
     */
    public void setBottomMax(double bottomMax) {
        options.bottomMax = bottomMax;
    }

    /**
     * Get the axis orientation of splitter component.
     */
    public Axis getAxis() {
        return options.orientation != null ? Axis.fromStyleName(options.orientation) : null;
    }

    /**
     * Set the axis orientation of splitter component (HORIZONTAL(Default) and VERTICAL).
     */
    public void setAxis(Axis axis) {
        options.orientation = axis.getCssName();
    }

    /**
     * Get the dock value.
     */
    public Dock getDock() {
        return options.dock != null ? Dock.fromStyleName(options.dock) : null;
    }

    /**
     * Set the dock value (LEFT, RIGHT -> HORIZONTAL AXIS and TOP,LEFT -> VERTICAL AXIS).
     */
    public void setDock(Dock dock) {
        options.dock = dock.getCssName();
    }

    public Color getSplitterLineColor() {
        return splitterLineColor;
    }

    /**
     * Will set the separator / splitter line color. Default {@link Color#RED}
     */
    public void setSplitterLineColor(Color splitterLineColor) {
        this.splitterLineColor = splitterLineColor;

        if (isAttached()) {
            applySplitterLineColor(splitterLineColor);
        } else {
            registerHandler(addAttachHandler(attachEvent -> applySplitterLineColor(splitterLineColor)));
        }
    }

    protected void applySplitterLineColor(Color splitterLineColor) {
        JQueryElement splitterBar = $(getElement()).find(".splitter-bar");
        if (splitterBar != null) {
            if (splitterLineColor != null) {
                splitterBar.addClass(splitterLineColor.getCssName());
            } else {
                splitterBar.removeClass(splitterLineColor.getCssName());
            }
        }
    }
}
