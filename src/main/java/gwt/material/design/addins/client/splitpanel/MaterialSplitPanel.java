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
import gwt.material.design.addins.client.splitpanel.constants.MaterialSplitPanelCss;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;

/**
 * A high performance content splitter compatible with touch events
 * <pre>
 *{@code
    <m.addins:MaterialSplitPanel height="500px">
        <m:MaterialPanel grid="l6 m6 s6" backgroundColor="grey lighten-2">
            <m:MaterialTitle textAlign="CENTER" title="Left Zone" description="Content must be added here"/>
        </m:MaterialPanel>
        <m:MaterialPanel grid="l6 m6 s6" backgroundColor="grey lighten-3">
            <m:MaterialTitle textAlign="CENTER" title="Right Zone" description="Content must be added here"/>
        </m:MaterialPanel>
    </m.addins:MaterialSplitPanel>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#splitpanel">Split Panel</a>
 */
//@formatter:on
public class MaterialSplitPanel extends MaterialWidget {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectDebugJs(MaterialSplitPanelClientBundle.INSTANCE.splitPanelJs());
        } else {
            MaterialResourceInjector.injectJs(MaterialSplitPanelDebugClientBundle.INSTANCE.splitPanelJs());
        }
        MaterialResourceInjector.injectCss(MaterialSplitPanelCss.splitPanel);
    }

    private double leftMax;
    private double leftMin;
    private double rightMax;
    private double rightMin;
    private double topMin;
    private double topMax;
    private double bottomMin;
    private double bottomMax;
    private Dock dock = Dock.LEFT;
    private Axis axis = Axis.HORIZONTAL;

    public MaterialSplitPanel() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        initSplitter(getElement(), getRightMax(), getRightMin(), getLeftMax(), getLeftMin(), getTopMax(), getTopMin(), getBottomMax(), getBottomMin(), getDock().getCssName(), getAxis().getCssName());
    }

    private native void initSplitter(Element e, double rightMax, double rightMin, double leftMax, double leftMin, double topMax, double topMin, double bottomMin, double bottomMax, String dock, String orientation) /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery(e).touchSplit({thickness: "8px", rightMax: rightMax, rightMin: rightMin, leftMax: leftMax, leftMin: leftMin, topMax: topMax, topMin: topMin, bottomMax: bottomMax, bottomMin: bottomMin, dock: dock, orientation: orientation});
        });
    }-*/;

    public double getLeftMax() {
        return leftMax;
    }

    public void setLeftMax(double leftMax) {
        this.leftMax = leftMax;
    }

    public double getLeftMin() {
        return leftMin;
    }

    public void setLeftMin(double leftMin) {
        this.leftMin = leftMin;
    }

    public double getRightMax() {
        return rightMax;
    }

    public void setRightMax(double rightMax) {
        this.rightMax = rightMax;
    }

    public double getRightMin() {
        return rightMin;
    }

    public void setRightMin(double rightMin) {
        this.rightMin = rightMin;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public double getTopMin() {
        return topMin;
    }

    public void setTopMin(double topMin) {
        this.topMin = topMin;
    }

    public double getTopMax() {
        return topMax;
    }

    public void setTopMax(double topMax) {
        this.topMax = topMax;
    }

    public double getBottomMin() {
        return bottomMin;
    }

    public void setBottomMin(double bottomMin) {
        this.bottomMin = bottomMin;
    }

    public double getBottomMax() {
        return bottomMax;
    }

    public void setBottomMax(double bottomMax) {
        this.bottomMax = bottomMax;
    }
}
