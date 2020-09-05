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

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.ui.base.MaterialWidgetTest;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.timer.TimerProgress;

/**
 * Test case for TimerProgress Component
 *
 * @author kevzlou7979
 */
public class TimerProgressTest extends MaterialWidgetTest<TimerProgress> {

    @Override
    protected TimerProgress createWidget() {
        return new TimerProgress();
    }

    public void testStructure() {
        TimerProgress timerProgress = getWidget();

        assertTrue(timerProgress.getElement().hasClassName(IncubatorCssName.TIMER_PROGRESS));
        assertTrue(timerProgress.getElement().hasClassName(IncubatorCssName.BOUNCING));

        assertEquals(timerProgress.getWidgetCount(), 1);
        assertTrue(timerProgress.getWidget(0) instanceof MaterialPanel);
        MaterialPanel fillPanel = (MaterialPanel) timerProgress.getWidget(0);
        assertTrue(fillPanel.getElement().hasClassName(IncubatorCssName.FILL));
        assertEquals(fillPanel, timerProgress.getFill());
    }

    public void testFillColor() {
        TimerProgress timerProgress = getWidget();

        timerProgress.setFillColor(Color.RED);
        assertEquals(timerProgress.getFillColor(), Color.RED);
        assertTrue(timerProgress.getFill().getElement().hasClassName(Color.RED.getCssName()));

        timerProgress.setEmptyFillColor(Color.YELLOW);
        assertEquals(timerProgress.getEmptyFillColor(), Color.YELLOW);
        assertTrue(timerProgress.getElement().hasClassName(Color.YELLOW.getCssName()));
    }

    public void testDuration() {
        TimerProgress timerProgress = getWidget();

        final int DURATION = 3000;
        timerProgress.setDuration(DURATION);
        assertEquals(timerProgress.getDuration(), DURATION);
    }
}
