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
package gwt.material.design.addins.client.ui;

import gwt.material.design.addins.client.ui.base.AddinsWidgetTestCase;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.ui.MaterialPanel;

/**
 * Test case for splitpanel component
 *
 * @author kevzlou7979
 */
public class MaterialSplitPanelTest extends AddinsWidgetTestCase<MaterialSplitPanel> {

    @Override
    protected MaterialSplitPanel createWidget() {
        return new MaterialSplitPanel();
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialSplitPanel splitPanel = getWidget(false);
        MaterialPanel leftPanel = new MaterialPanel();
        MaterialPanel rightPanel = new MaterialPanel();
        splitPanel.add(leftPanel);
        splitPanel.add(rightPanel);

        // when / then
        checkStructure(splitPanel, leftPanel, rightPanel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(splitPanel, leftPanel, rightPanel);
    }

    protected void checkStructure(MaterialSplitPanel splitPanel, MaterialPanel leftPanel, MaterialPanel rightPanel) {
        assertEquals(leftPanel, splitPanel.getWidget(0));
        assertEquals(rightPanel, splitPanel.getWidget(1));
    }

    public void testProperties() {
        // UiBinder
        // given
        MaterialSplitPanel splitPanel = getWidget(false);

        // when / then
        checkProperties(splitPanel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkProperties(splitPanel);
    }

    protected void checkProperties(MaterialSplitPanel splitPanel) {
        splitPanel.setBarPosition(20);
        assertEquals(0.2, splitPanel.getBarPosition());
        splitPanel.setLeftMin(10);
        assertEquals(Double.valueOf(10), splitPanel.getLeftMin());
        splitPanel.setLeftMax(40);
        assertEquals(Double.valueOf(40), splitPanel.getLeftMax());
        splitPanel.setBottomMax(20);
        assertEquals(Double.valueOf(20), splitPanel.getBottomMax());
        splitPanel.setBottomMin(30);
        assertEquals(Double.valueOf(30), splitPanel.getBottomMin());
        splitPanel.setTopMax(20);
        assertEquals(Double.valueOf(20), splitPanel.getTopMax());
        splitPanel.setTopMin(30);
        assertEquals(Double.valueOf(30), splitPanel.getTopMin());
        splitPanel.setRightMax(20);
        assertEquals(Double.valueOf(20), splitPanel.getRightMax());
        splitPanel.setRightMin(30);
        assertEquals(Double.valueOf(30), splitPanel.getRightMin());
        splitPanel.setDock(Dock.RIGHT);
        assertEquals(Dock.RIGHT, splitPanel.getDock());
        splitPanel.setDock(Dock.BOTTOM);
        assertEquals(Dock.BOTTOM, splitPanel.getDock());
        splitPanel.setDock(Dock.LEFT);
        assertEquals(Dock.LEFT, splitPanel.getDock());
        splitPanel.setDock(Dock.TOP);
        assertEquals(Dock.TOP, splitPanel.getDock());
        splitPanel.setAxis(Axis.HORIZONTAL);
        assertEquals(Axis.HORIZONTAL, splitPanel.getAxis());
        splitPanel.setAxis(Axis.VERTICAL);
        assertEquals(Axis.VERTICAL, splitPanel.getAxis());
        splitPanel.setThickness(200);
        assertEquals(Double.valueOf(200), splitPanel.getThickness());
    }
}
