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

import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.circularprogress.MaterialCircularProgress;
import gwt.material.design.addins.client.circularprogress.events.CircularProgressEvent;
import gwt.material.design.addins.client.stepper.events.CompleteEvent;
import gwt.material.design.addins.client.stepper.events.StartEvent;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.html.Span;

public class MaterialCircularProgressTest extends MaterialAddinsTest {

    public void init() {
        MaterialCircularProgress circularProgress = new MaterialCircularProgress();
        checkWidget(circularProgress);
        checkStructure(circularProgress);
        checkValue(circularProgress);
        checkProperties(circularProgress);
        checkEvents(circularProgress);
    }

    protected <T extends MaterialCircularProgress> void checkEvents(T circularProgress) {
        final boolean[] startEventFired = {false};
        circularProgress.addStartHandler(e -> startEventFired[0] = true);
        circularProgress.fireEvent(new StartEvent());
        assertTrue(startEventFired[0]);

        final boolean[] completeEventFired = {false};
        circularProgress.addCompleteHandler(e -> completeEventFired[0] = true);
        circularProgress.fireEvent(new CompleteEvent(100));
        assertTrue(completeEventFired[0]);

        final boolean[] progressEventFired = {false};
        circularProgress.addCircularProgressEvent(event -> progressEventFired[0] = true);
        circularProgress.fireEvent(new CircularProgressEvent(100, 75));
        assertTrue(progressEventFired[0]);
    }

    protected <T extends MaterialCircularProgress> void checkStructure(T circularProgress) {
        RootPanel.get().add(circularProgress);
        assertEquals(circularProgress.getChildren().size(), 1);
        assertTrue(circularProgress.getWidget(0) instanceof Span);
        Span lblText = (Span) circularProgress.getWidget(0);
        circularProgress.setText("50%");
        assertEquals(lblText.getText(), "50%");
    }

    protected <T extends MaterialCircularProgress> void checkProperties(T circularProgress) {
        // Size
        assertEquals(circularProgress.getSize(), 100.0);
        circularProgress.setSize(200);
        assertEquals(circularProgress.getSize(), 200.0);
        // Thickness
        assertEquals(circularProgress.getThickness(), 8);
        circularProgress.setThickness(20);
        assertEquals(circularProgress.getThickness(), 20);
        // Start Angle
        assertEquals(circularProgress.getStartAngle(), Math.PI);
        circularProgress.setStartAngle(Math.PI / 2);
        assertEquals(circularProgress.getStartAngle(), Math.PI / 2);
        // Fill Color
        assertEquals(circularProgress.getFillColor(), Color.BLUE);
        circularProgress.setFillColor(Color.RED);
        assertEquals(circularProgress.getFillColor(), Color.RED);
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getFillColor()));
        // Empty Fill Color
        assertEquals(circularProgress.getEmptyFillColor(), Color.GREY_LIGHTEN_2);
        circularProgress.setEmptyFillColor(Color.RED_LIGHTEN_2);
        assertEquals(circularProgress.getEmptyFillColor(), Color.RED_LIGHTEN_2);
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getEmptyFillColor()));
        // Reverse
        assertFalse(circularProgress.isReverse());
        circularProgress.setReverse(true);
        assertTrue(circularProgress.isReverse());
    }

    protected <T extends MaterialCircularProgress> void checkValue(T circularProgress) {
        assertEquals(circularProgress.getValue(), 0.0);
        circularProgress.setValue(0.5);
        assertEquals(circularProgress.getValue(), 0.5);
    }
}
