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
package gwt.material.design.addins.client;

import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.addins.client.splitpanel.constants.Dock;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.ui.MaterialPanel;

public class MaterialSplitPanelTest extends MaterialAddinsTest {

    public void init() {
        MaterialSplitPanel splitPanel = new MaterialSplitPanel();
        checkWidget(splitPanel);
        checkStructure(splitPanel);
        checkProperties(splitPanel);
    }

    protected <T extends MaterialSplitPanel> void checkStructure(T splitPanel) {
        MaterialPanel panelLeft = new MaterialPanel();
        MaterialPanel panelRight = new MaterialPanel();
        splitPanel.add(panelLeft);
        splitPanel.add(panelRight);
        assertEquals(splitPanel.getWidget(0), panelLeft);
        assertEquals(splitPanel.getWidget(1), panelRight);
    }

    protected <T extends MaterialSplitPanel> void checkProperties(T splitPanel) {
        splitPanel.setBarPosition(20);
        assertEquals(splitPanel.getBarPosition(), 0.2);
        splitPanel.setLeftMin(10);
        assertEquals(splitPanel.getLeftMin(), Double.valueOf(10));
        splitPanel.setLeftMax(40);
        assertEquals(splitPanel.getLeftMax(), Double.valueOf(40));
        splitPanel.setBottomMax(20);
        assertEquals(splitPanel.getBottomMax(), Double.valueOf(20));
        splitPanel.setBottomMin(30);
        assertEquals(splitPanel.getBottomMin(), Double.valueOf(30));
        splitPanel.setTopMax(20);
        assertEquals(splitPanel.getTopMax(), Double.valueOf(20));
        splitPanel.setTopMin(30);
        assertEquals(splitPanel.getTopMin(), Double.valueOf(30));
        splitPanel.setRightMax(20);
        assertEquals(splitPanel.getRightMax(), Double.valueOf(20));
        splitPanel.setRightMin(30);
        assertEquals(splitPanel.getRightMin(), Double.valueOf(30));
        splitPanel.setDock(Dock.RIGHT);
        assertEquals(splitPanel.getDock(), Dock.RIGHT);
        splitPanel.setDock(Dock.BOTTOM);
        assertEquals(splitPanel.getDock(), Dock.BOTTOM);
        splitPanel.setDock(Dock.LEFT);
        assertEquals(splitPanel.getDock(), Dock.LEFT);
        splitPanel.setDock(Dock.TOP);
        assertEquals(splitPanel.getDock(), Dock.TOP);
        splitPanel.setAxis(Axis.HORIZONTAL);
        assertEquals(splitPanel.getAxis(), Axis.HORIZONTAL);
        splitPanel.setAxis(Axis.VERTICAL);
        assertEquals(splitPanel.getAxis(), Axis.VERTICAL);
        splitPanel.setThickness(200);
        assertEquals(splitPanel.getThickness(), Double.valueOf(200));
    }
}
