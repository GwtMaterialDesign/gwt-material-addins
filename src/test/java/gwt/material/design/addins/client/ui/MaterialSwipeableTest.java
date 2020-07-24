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
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.swipeable.MaterialSwipeablePanel;
import gwt.material.design.addins.client.swipeable.events.*;
import gwt.material.design.client.ui.MaterialLabel;

/**
 * Test case for Swipeable component
 *
 * @author kevzlou7979
 */
public class MaterialSwipeableTest extends AddinsWidgetTestCase<MaterialSwipeablePanel> {

    private MaterialLabel label1;
    private MaterialLabel label2;

    @Override
    protected MaterialSwipeablePanel createWidget() {
        MaterialSwipeablePanel swipeablePanel = new MaterialSwipeablePanel();
        label1 = new MaterialLabel();
        swipeablePanel.add(label1);
        label2 = new MaterialLabel();
        swipeablePanel.add(label2);
        return swipeablePanel;
    }

    @Override
    protected void gwtTearDown() throws Exception {
        super.gwtTearDown();

        label1.removeFromParent();
        label2.removeFromParent();
    }

    public void testSwipeHandler() {
        // given
        MaterialSwipeablePanel swipeablePanel = getWidget(false);

        // when / then
        checkSwipeHandlers(swipeablePanel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkSwipeHandlers(swipeablePanel);
    }

    protected void checkSwipeHandlers(MaterialSwipeablePanel swipeablePanel) {
        swipeablePanel.setEnabled(true);
        assertTrue(swipeablePanel.isEnabled());
        // given
        final boolean[] isSwipeRightFired = {false};
        final boolean[] isSwipeLeftFired = {false};
        final boolean[] isOnStartSwipeLeftFired = {false};
        final boolean[] isOnStartSwipeRightFired = {false};
        final boolean[] isOnEndSwipeLeftFired = {false};
        final boolean[] isOnEndSwipeRightFired = {false};

        // when / then
        swipeablePanel.addSwipeRightHandler(event -> {
            assertEquals(label1, event.getTarget());
            isSwipeRightFired[0] = true;
        });
        SwipeRightEvent.fire(swipeablePanel, label1);

        swipeablePanel.addSwipeLeftHandler(event -> {
            assertEquals(label2, event.getTarget());
            isSwipeLeftFired[0] = true;
        });
        SwipeLeftEvent.fire(swipeablePanel, label2);

        swipeablePanel.addOnStartSwipeLeftHandler(event -> {
            assertEquals(label1, event.getTarget());
            isOnStartSwipeLeftFired[0] = true;
        });
        OnStartSwipeLeftEvent.fire(swipeablePanel, label1);

        swipeablePanel.addOnStartSwipeRightHandler(event -> {
            assertEquals(label2, event.getTarget());
            isOnStartSwipeRightFired[0] = true;
        });
        OnStartSwipeRightEvent.fire(swipeablePanel, label2);

        swipeablePanel.addOnEndSwipeLeftHandler(event -> {
            assertEquals(label1, event.getTarget());
            isOnEndSwipeLeftFired[0] = true;
        });
        OnEndSwipeLeftEvent.fire(swipeablePanel, label1);

        swipeablePanel.addOnEndSwipeRightHandler(event -> {
            assertEquals(label2, event.getTarget());
            isOnEndSwipeRightFired[0] = true;
        });
        OnEndSwipeRightEvent.fire(swipeablePanel, label2);

        assertTrue(isSwipeRightFired[0]);
        assertTrue(isSwipeLeftFired[0]);
        assertTrue(isOnStartSwipeLeftFired[0]);
        assertTrue(isOnStartSwipeRightFired[0]);
        assertTrue(isOnEndSwipeLeftFired[0]);
        assertTrue(isOnEndSwipeRightFired[0]);
    }

    public void testIgnored() {
        // UiBinder
        // given
        MaterialSwipeablePanel swipeablePanel = getWidget(false);

        // when / then
        checkIgnored(swipeablePanel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkIgnored(swipeablePanel);
    }

    protected void checkIgnored(MaterialSwipeablePanel swipeablePanel) {
        assertEquals(2, swipeablePanel.getWidgetCount());
        MaterialLabel label1 = (MaterialLabel) swipeablePanel.getWidget(0);
        MaterialLabel label2 = (MaterialLabel) swipeablePanel.getWidget(1);
        swipeablePanel.ignore(label1, label2);
        assertTrue(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertTrue(label2.getElement().hasClassName(AddinsCssName.IGNORED));
    }

    public void testStructure() {
        // UiBinder
        // given
        MaterialSwipeablePanel swipeablePanel = getWidget(false);

        // when / then
        checkStructure(swipeablePanel);

        // Standard
        // given
        attachWidget();

        // when / then
        checkStructure(swipeablePanel);
    }

    protected void checkStructure(MaterialSwipeablePanel swipeablePanel) {
        assertEquals(label1, swipeablePanel.getWidget(0));
        assertEquals(label2, swipeablePanel.getWidget(1));
        swipeablePanel.ignore(label1, label2);
        assertTrue(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertTrue(label2.getElement().hasClassName(AddinsCssName.IGNORED));
        swipeablePanel.removeIgnore(label1, label2);
        assertFalse(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertFalse(label2.getElement().hasClassName(AddinsCssName.IGNORED));
    }
}
