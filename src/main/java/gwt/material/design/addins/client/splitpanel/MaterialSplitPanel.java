/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.addins.client.splitpanel.js.JsSplitPanel;
import gwt.material.design.addins.client.splitpanel.js.JsSplitPanelOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;

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
 */
//@formatter:on
public class MaterialSplitPanel extends MaterialWidget {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectJs(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugJs());
            MaterialDesignBase.injectCss(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugCss());
        } else {
            MaterialDesignBase.injectDebugJs(MaterialSplitPanelClientBundle.INSTANCE.splitPanelJs());
            MaterialDesignBase.injectCss(MaterialSplitPanelClientBundle.INSTANCE.splitPanelCss());
        }
    }

    private double leftMax;
    private double leftMin;
    private double rightMax;
    private double rightMin;
    private double topMin;
    private double topMax;
    private double bottomMin;
    private double bottomMax;
    private double barPosition = 50;
    private double thickness = 8;
    private Dock dock = Dock.LEFT;
    private Axis axis = Axis.HORIZONTAL;
    private boolean initialized;

    public MaterialSplitPanel() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (!initialized) {
            initSplitter();
            initialized = true;
        }
    }

    /**
     * Initialize the splitter component.
     */
    protected void initSplitter() {
        JsSplitPanel splitted = $(getElement());
        if (splitted.get(0) != null) {
            JsSplitPanelOptions options = new JsSplitPanelOptions();
            options.barPosition = getBarPosition();
            options.thickness = getThickness() + "px";
            options.rightMax = getRightMax();
            options.rightMin = getRightMin();
            options.leftMax = getLeftMax();
            options.leftMin = getLeftMin();
            options.topMax = getTopMax();
            options.topMin = getTopMin();
            options.bottomMax = getBottomMax();
            options.bottomMin = getBottomMin();
            options.dock = getDock().getCssName();
            options.orientation = getAxis().getCssName();
            splitted.touchSplit(options);
        }
    }

    /**
     * Get the Maximum left space.
     */
    public double getLeftMax() {
        return leftMax;
    }

    /**
     * Set the Maximum left space while dragging horizontally.
     */
    public void setLeftMax(double leftMax) {
        this.leftMax = leftMax;
    }

    /**
     * Get the Minimum left max space.
     */
    public double getLeftMin() {
        return leftMin;
    }

    /**
     * Set the Minimum left space while dragging horizontally.
     */
    public void setLeftMin(double leftMin) {
        this.leftMin = leftMin;
    }

    /**
     * Get the Maximum right space.
     */
    public double getRightMax() {
        return rightMax;
    }

    /**
     * Set the Maximum right space while dragging horizontally.
     */
    public void setRightMax(double rightMax) {
        this.rightMax = rightMax;
    }

    /**
     * Get the minimum right space.
     */
    public double getRightMin() {
        return rightMin;
    }

    /**
     * Set the minimum right space while dragging horizontally.
     */
    public void setRightMin(double rightMin) {
        this.rightMin = rightMin;
    }

    /**
     * Get the axis orientation of splitter component.
     */
    public Axis getAxis() {
        return axis;
    }

    /**
     * Set the axis orientation of splitter component (HORIZONTAL(Default) and VERTICAL).
     */
    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    /**
     * Get the dock value.
     */
    public Dock getDock() {
        return dock;
    }

    /**
     * Set the dock value (LEFT, RIGHT -> HORIZONTAL AXIS and TOP,LEFT -> VERTICAL AXIS).
     */
    public void setDock(Dock dock) {
        this.dock = dock;
    }

    /**
     * Get the minimum top space.
     */
    public double getTopMin() {
        return topMin;
    }

    /**
     * Set the minimum top space while dragging vertically.
     */
    public void setTopMin(double topMin) {
        this.topMin = topMin;
    }

    /**
     * Get the maximum top space.
     */
    public double getTopMax() {
        return topMax;
    }

    /**
     * Set the maximum top space while dragging vertically.
     */
    public void setTopMax(double topMax) {
        this.topMax = topMax;
    }

    /**
     * Get the minimum bottom space.
     */
    public double getBottomMin() {
        return bottomMin;
    }

    /**
     * Set the minimum bottom space while dragging vertically.
     */
    public void setBottomMin(double bottomMin) {
        this.bottomMin = bottomMin;
    }

    /**
     * Get the maximum bottom space.
     */
    public double getBottomMax() {
        return bottomMax;
    }

    /**
     * Set the maximum bottom space while dragging vertically.
     */
    public void setBottomMax(double bottomMax) {
        this.bottomMax = bottomMax;
    }

    /**
     * Get the bar position in percent divided by 100.
     */
    public double getBarPosition() {
        return barPosition / 100;
    }

    /**
     * Set the bar position in percent.
     */
    public void setBarPosition(double barPosition) {
        this.barPosition = barPosition;
    }

    /**
     * Get the bar's thickness in px.
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Set the bar's thickness in px.
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
