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
package gwt.material.design.incubator.client.ui;

import com.google.gwt.event.logical.shared.SelectionEvent;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.incubator.client.toggle.GroupToggleButton;

/**
 * Test case for Group Toggle Button Component
 *
 * @author kevzlou7979
 */
public class GroupToggleButtonTest extends MaterialWidgetTest<GroupToggleButton> {

    @Override
    protected GroupToggleButton createWidget() {
        return new GroupToggleButton();
    }

    public void testSelectionHandler() {
        GroupToggleButton button = getWidget();

        final boolean[] selectionFired = {false};
        button.addSelectionHandler((SelectionEvent<Integer> selectionEvent) -> {
            selectionFired[0] = true;
        });

        SelectionEvent.fire(button, 1);
        assertTrue(selectionFired[0]);
    }

    public void testProperties() {
        GroupToggleButton button = getWidget();

        final String FIRST = "1";
        final String SECOND = "2";
        final String THIRD = "3";
        button.setFirstToggleText(FIRST);
        assertEquals(button.getFirstToggle().getText(), FIRST);
        button.setSecondToggleText(SECOND);
        assertEquals(button.getSecondToggle().getText(), SECOND);
        button.setThirdToggleText(THIRD);
        assertEquals(button.getThirdToggle().getText(), THIRD);
    }
}
