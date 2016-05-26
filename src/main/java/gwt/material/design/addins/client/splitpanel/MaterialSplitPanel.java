package gwt.material.design.addins.client.splitpanel;

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


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;

//@formatter:off
/**
 * A high performance content splitter compatible with touch events
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
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectJs(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugJs());
            MaterialResourceInjector.injectCss(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelDebugCss());
        } else {
            MaterialResourceInjector.injectDebugJs(MaterialSplitPanelClientBundle.INSTANCE.splitPanelJs());
            MaterialResourceInjector.injectCss(MaterialSplitPanelClientBundle.INSTANCE.splitPanelCss());
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
    private Dock dock = Dock.LEFT;
    private Axis axis = Axis.HORIZONTAL;

    public MaterialSplitPanel() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initSplitter(getElement(), getBarPosition(), getRightMax(), getRightMin(), getLeftMax(), getLeftMin(), getTopMax(), getTopMin(), getBottomMax(), getBottomMin(), getDock().getCssName(), getAxis().getCssName());
    }

    /**
     * Initialize the splitter component
     * @param e - The element you need to split
     * @param barPosition - The position of the bar based on percentage by default it's 50%
     * @param rightMax - The maximum right space while dragging the splitter bar horizontally
     * @param rightMin - The minimum right space while dragging the splitter bar horizontally
     * @param leftMax - The maximum left space while dragging the splitter bar horizontally
     * @param leftMin - The minimum left space while dragging the splitter bar horizontally
     * @param topMax - The maximum top space while dragging the splitter bar vertically
     * @param topMin - The minimum top space while dragging the splitter bar vertically
     * @param bottomMin - The minimum bottom space while dragging the splitter bar vertically
     * @param bottomMax - The maximum bottom space while dragging the splitter bar vertically
     * @param dock - When clicking on the white line located in the middle of splitter bar, depends on docking position it will collapse to that direction
     * @param orientation - There are two types of orientation : HORIZONTAL (Default) and VERTICAL
     */
    private native void initSplitter(Element e,double barPosition, double rightMax, double rightMin, double leftMax, double leftMin, double topMax, double topMin, double bottomMin, double bottomMax, String dock, String orientation) /*-{
        $wnd.jQuery(document).ready(function() {
            var splitted = $wnd.jQuery(e);
            if( splitted[0].touchSplitter == null ) {
                splitted.touchSplit({barPosition: barPosition, thickness: "8px", rightMax: rightMax, rightMin: rightMin, leftMax: leftMax, leftMin: leftMin, topMax: topMax, topMin: topMin, bottomMax: bottomMax, bottomMin: bottomMin, dock: dock, orientation: orientation});
            }
        });
    }-*/;

    /**
     * Get the Maximum left space
     * @return
     */
    public double getLeftMax() {
        return leftMax;
    }

    /**
     * Set the Maximum left space while dragging horizontally
     * @param leftMax
     */
    public void setLeftMax(double leftMax) {
        this.leftMax = leftMax;
    }

    /**
     * Get the Minimum left max space
     * @return
     */
    public double getLeftMin() {
        return leftMin;
    }

    /**
     * Set the Minimum left space while dragging horizontally
     * @param leftMin
     */
    public void setLeftMin(double leftMin) {
        this.leftMin = leftMin;
    }

    /**
     * Get the Maximum right space
     * @return
     */
    public double getRightMax() {
        return rightMax;
    }

    /**
     * Set the Maximum right space while dragging horizontally
     * @param rightMax
     */
    public void setRightMax(double rightMax) {
        this.rightMax = rightMax;
    }

    /**
     * Get the minimum right space
     * @return
     */
    public double getRightMin() {
        return rightMin;
    }

    /**
     * Set the minimum right space while dragging horizontally
     * @param rightMin
     */
    public void setRightMin(double rightMin) {
        this.rightMin = rightMin;
    }

    /**
     * Get the axis orientation of splitter component
     * @return
     */
    public Axis getAxis() {
        return axis;
    }

    /**
     * Set the axis orientation of splitter component (HORIZONTAL(Default) and VERTICAL)
     * @param axis
     */
    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    /**
     * Get the dock value
     * @return
     */
    public Dock getDock() {
        return dock;
    }

    /**
     * Set the dock value (LEFT, RIGHT -> HORIZONTAL AXIS and TOP,LEFT -> VERTICAL AXIS)
     * @param dock
     */
    public void setDock(Dock dock) {
        this.dock = dock;
    }

    /**
     * Get the minimum top space
     * @return
     */
    public double getTopMin() {
        return topMin;
    }

    /**
     * Set the minimum top space while dragging vertically
     * @param topMin
     */
    public void setTopMin(double topMin) {
        this.topMin = topMin;
    }

    /**
     * Get the maximum top space
     * @return
     */
    public double getTopMax() {
        return topMax;
    }

    /**
     * Set the maximum top space while dragging vertically
     * @param topMax
     */
    public void setTopMax(double topMax) {
        this.topMax = topMax;
    }

    /**
     * Get the minimum bottom space
     * @return
     */
    public double getBottomMin() {
        return bottomMin;
    }

    /**
     * Set the minimum bottom space while dragging vertically
     * @param bottomMin
     */
    public void setBottomMin(double bottomMin) {
        this.bottomMin = bottomMin;
    }

    /**
     * Get the maximum bottom space
     * @return
     */
    public double getBottomMax() {
        return bottomMax;
    }

    /**
     * Set the maximum bottom space while dragging vertically
     * @param bottomMax
     */
    public void setBottomMax(double bottomMax) {
        this.bottomMax = bottomMax;
    }

    /**
     * Get the bar position in percent divided by 100
     * @return
     */
    public double getBarPosition() {
        return barPosition / 100;
    }

    /**
     * Set the bar position in percent
     * @param barPosition
     */
    public void setBarPosition(double barPosition) {
        this.barPosition = barPosition;
    }
}
