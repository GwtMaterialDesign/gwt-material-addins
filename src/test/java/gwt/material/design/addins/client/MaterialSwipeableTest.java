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

import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.swipeable.MaterialSwipeablePanel;
import gwt.material.design.addins.client.swipeable.events.SwipeLeftEvent;
import gwt.material.design.addins.client.swipeable.events.SwipeRightEvent;
import gwt.material.design.client.ui.MaterialLabel;

/**
 * Test case for Swipeable component
 *
 * @author kevzlou7979
 */
public class MaterialSwipeableTest extends MaterialAddinsTest {

    public void init() {
        MaterialSwipeablePanel swipeablePanel = new MaterialSwipeablePanel();
        checkWidget(swipeablePanel);
        checkStructure(swipeablePanel);
        checkIgnored(swipeablePanel);
        checkSwipeHandler(swipeablePanel);
    }

    protected <T extends MaterialSwipeablePanel> void checkSwipeHandler(T swipeablePanel) {
        swipeablePanel.setEnabled(true);
        assertTrue(swipeablePanel.isEnabled());
        final boolean[] isSwipeRightFired = {false};
        swipeablePanel.addSwipeRightHandler(event -> {
            isSwipeRightFired[0] = true;
        });
        swipeablePanel.fireEvent(new GwtEvent<SwipeRightEvent.SwipeRightHandler<?>>() {
            @Override
            public Type<SwipeRightEvent.SwipeRightHandler<?>> getAssociatedType() {
                return SwipeRightEvent.getType();
            }

            @Override
            protected void dispatch(SwipeRightEvent.SwipeRightHandler<?> eventHandler) {
                eventHandler.onSwipeRight(null);
            }
        });

        final boolean[] isSwipeLeftFired = {false};
        swipeablePanel.addSwipeLeftHandler(event -> {
            isSwipeLeftFired[0] = true;
        });
        swipeablePanel.fireEvent(new GwtEvent<SwipeLeftEvent.SwipeLeftHandler<?>>() {
            @Override
            public Type<SwipeLeftEvent.SwipeLeftHandler<?>> getAssociatedType() {
                return SwipeLeftEvent.getType();
            }

            @Override
            protected void dispatch(SwipeLeftEvent.SwipeLeftHandler<?> eventHandler) {
                eventHandler.onSwipeLeft(null);
            }
        });

        assertTrue(isSwipeRightFired[0]);
        assertTrue(isSwipeLeftFired[0]);
    }

    protected <T extends MaterialSwipeablePanel> void checkIgnored(T swipeablePanel) {
        assertEquals(swipeablePanel.getWidgetCount(), 2);
        MaterialLabel label1 = (MaterialLabel) swipeablePanel.getWidget(0);
        MaterialLabel label2 = (MaterialLabel) swipeablePanel.getWidget(1);
        swipeablePanel.ignore(label1, label2);
        assertTrue(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertTrue(label2.getElement().hasClassName(AddinsCssName.IGNORED));
    }

    protected <T extends MaterialSwipeablePanel> void checkStructure(T swipeablePanel) {
        MaterialLabel label1 = new MaterialLabel();
        swipeablePanel.add(label1);
        MaterialLabel label2 = new MaterialLabel();
        swipeablePanel.add(label2);
        assertEquals(swipeablePanel.getWidget(0), label1);
        assertEquals(swipeablePanel.getWidget(1), label2);
        swipeablePanel.ignore(label1, label2);
        assertTrue(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertTrue(label2.getElement().hasClassName(AddinsCssName.IGNORED));
        swipeablePanel.removeIgnore(label1, label2);
        assertFalse(label1.getElement().hasClassName(AddinsCssName.IGNORED));
        assertFalse(label2.getElement().hasClassName(AddinsCssName.IGNORED));
    }
}
