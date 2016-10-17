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
import gwt.material.design.addins.client.menubar.MaterialMenuBar;
import gwt.material.design.client.ui.MaterialDropDown;
import gwt.material.design.client.ui.MaterialLink;

/**
 * Test case for menu bar component
 *
 * @author kevzlou7979
 */
public class MaterialMenuBarTest extends MaterialAddinsTest {

    public void init() {
        MaterialMenuBar menuBar = new MaterialMenuBar();
        checkWidget(menuBar);
        checkStructure(menuBar);
    }

    protected <T extends MaterialMenuBar> void checkStructure(T menuBar) {
        final String ACTIVATOR = "dp-activator";
        MaterialLink link = new MaterialLink();
        MaterialDropDown dropDown = new MaterialDropDown();
        link.setActivates(ACTIVATOR);
        dropDown.setActivator(ACTIVATOR);
        menuBar.add(link);
        menuBar.add(dropDown);
        assertEquals(link.getActivates(), ACTIVATOR);
        assertEquals(dropDown.getActivator(), ACTIVATOR);
        assertEquals(menuBar.getWidget(0), link);
        assertEquals(menuBar.getWidget(1), dropDown);
    }
}
