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

import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.loadingstate.LoadingStatePanel;
import gwt.material.design.incubator.client.loadingstate.constants.State;
import gwt.material.design.incubator.client.loadingstate.events.ErrorEvent;
import gwt.material.design.incubator.client.loadingstate.events.LoadingEvent;
import gwt.material.design.incubator.client.loadingstate.events.SuccessEvent;

/**
 * Test case for Loading State Component
 *
 * @author kevzlou7979
 */
public class LoadingStateTest extends MaterialWidgetTest<LoadingStatePanel> {

    @Override
    protected LoadingStatePanel createWidget() {
        return new LoadingStatePanel();
    }

    public void testStructure() {
        LoadingStatePanel statePanel = getWidget();

        // By Default Loading State Panel must be invisible by default
        assertFalse(statePanel.isVisible());
        assertTrue(statePanel.getElement().hasClassName(IncubatorCssName.LOADING_STATE));
        // Check widget structure
        assertTrue(statePanel.getWidget(0) instanceof MaterialIcon);
        MaterialIcon icon = (MaterialIcon) statePanel.getWidget(0);
        statePanel.setIcon(IconType.POLYMER);
        assertEquals(statePanel.getIcon(), icon);

        final String TITLE = "title";
        final String DESCRIPTION = "description";
        assertTrue(statePanel.getWidget(1) instanceof MaterialLabel);
        MaterialLabel title = (MaterialLabel) statePanel.getWidget(1);
        statePanel.setTitle(TITLE);
        assertTrue(title.getElement().hasClassName(CssName.TITLE));
        assertEquals(title.getText(), TITLE);

        assertTrue(statePanel.getWidget(2) instanceof MaterialLabel);
        MaterialLabel description = (MaterialLabel) statePanel.getWidget(2);
        statePanel.setDescription(DESCRIPTION);
        assertTrue(description.getElement().hasClassName(AddinsCssName.DESCRIPTION));
        assertEquals(description.getText(), DESCRIPTION);
    }

    public void testStates() {
        LoadingStatePanel statePanel = getWidget();

        checkState(statePanel, State.ERROR);
        final boolean[] errorEventFired = {false};
        // Checks the Error Event State
        statePanel.addErrorHandler(event -> errorEventFired[0] = true);
        ErrorEvent.fire(statePanel);
        assertTrue(errorEventFired[0]);

        checkState(statePanel, State.LOADING);
        final boolean[] loadingEventFired = {false};
        // Checks the Loading Event State
        statePanel.addLoadingHandler(event -> loadingEventFired[0] = true);
        LoadingEvent.fire(statePanel);
        assertTrue(loadingEventFired[0]);

        checkState(statePanel, State.SUCCESS);
        final boolean[] successEventFired = {false};
        // Checks the Success Event State
        statePanel.addSuccessHandler(event -> successEventFired[0] = true);
        SuccessEvent.fire(statePanel);
        assertTrue(successEventFired[0]);
    }

    public void checkState(LoadingStatePanel statePanel, State state) {
        final String TITLE = "title";
        final String DESCRIPTION = "description";
        statePanel.setState(state, TITLE, DESCRIPTION);
        assertEquals(statePanel.getState(), state);
        // If state is set, make sure to check the visibility of the state panel (expected result : true)
        assertTrue(statePanel.isVisible());
    }

    public void testAnimation(LoadingStatePanel statePanel) {
        statePanel.setAnimation(true);
        assertTrue(statePanel.isAnimation());

        statePanel.setAnimation(false);
        assertFalse(statePanel.isAnimation());
    }
}
