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
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.toggle.GroupToggleButton;
import gwt.material.design.incubator.client.toggle.ToggleButton;

/**
 * Test case for Group Toggle Button Component
 *
 * @author kevzlou7979
 */
public class GroupToggleButtonTest extends MaterialWidgetTest<GroupToggleButton<Integer>> {

    static final int NUMBER_ITEMS = 10;

    @Override
    protected GroupToggleButton<Integer> createWidget() {
        GroupToggleButton<Integer> groupToggleButton = new GroupToggleButton<>();
        for (int i = 0; i < NUMBER_ITEMS; i++) {
            groupToggleButton.addItem(String.valueOf(i), i);
        }
        return groupToggleButton;
    }

    public void testSelectionHandler() {
        Integer SELECTED_ITEM = 1;
        GroupToggleButton<Integer> button = getWidget();

        final boolean[] selectionFired = {false};
        button.addSelectionHandler((SelectionEvent<Integer> selectionEvent) -> {
            assertEquals(SELECTED_ITEM, selectionEvent.getSelectedItem());
            selectionFired[0] = true;
        });

        SelectionEvent.fire(button, SELECTED_ITEM);
        assertTrue(selectionFired[0]);
    }

    public void testStructure() {
        GroupToggleButton<Integer> groupToggleButton = getWidget();

        assertEquals(groupToggleButton.getLabel(), groupToggleButton.getWidget(0));
        assertEquals(groupToggleButton.getWrapper(), groupToggleButton.getWidget(1));
        assertEquals(groupToggleButton.getErrorLabel(), groupToggleButton.getWidget(2));

        Div wrapper = groupToggleButton.getWrapper();
        assertTrue(wrapper.getElement().hasClassName(IncubatorCssName.WRAPPER));
        assertEquals(NUMBER_ITEMS, wrapper.getChildren().size());

        assertTrue(wrapper.getWidget(0) instanceof ToggleButton);

        checkToggleButton((ToggleButton) wrapper.getWidget(0), groupToggleButton);
    }

    protected void checkToggleButton(ToggleButton button, GroupToggleButton<Integer> groupToggleButton) {
        assertEquals(button.getGroupParent(), groupToggleButton);
        assertFalse(button.isToggle());
        assertFalse(button.isActive());
    }

    // TODO Do more Testing
}
