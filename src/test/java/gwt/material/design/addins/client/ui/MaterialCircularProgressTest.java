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
package gwt.material.design.addins.client.ui;

import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.circularprogress.MaterialCircularProgress;
import gwt.material.design.addins.client.circularprogress.events.CompleteEvent;
import gwt.material.design.addins.client.circularprogress.events.ProgressEvent;
import gwt.material.design.addins.client.circularprogress.events.StartEvent;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.html.Span;

public class MaterialCircularProgressTest extends MaterialWidgetTest<MaterialCircularProgress> {

    @Override
    protected MaterialCircularProgress createWidget() {
        MaterialCircularProgress circularProgress = new MaterialCircularProgress();
        return circularProgress;
    }

    public void testEvents() {
        // given
        MaterialCircularProgress circularProgress = getWidget();
        final double VALUE = 20;
        final double PROGRESS = 10;

        // when / then
        final boolean[] startEventFired = {false};
        circularProgress.addStartHandler(e -> {
            startEventFired[0] = true;
            assertEquals(VALUE, e.getValue());
        });
        circularProgress.fireEvent(new StartEvent(VALUE));
        assertTrue(startEventFired[0]);

        final boolean[] completeEventFired = {false};
        circularProgress.addCompleteHandler(e -> {
            completeEventFired[0] = true;
            assertEquals(VALUE, e.getValue());
        });
        circularProgress.fireEvent(new CompleteEvent(VALUE));
        assertTrue(completeEventFired[0]);

        final boolean[] progressEventFired = {false};
        circularProgress.addProgressHandler(e -> {
            progressEventFired[0] = true;
            assertEquals(PROGRESS, e.getProgress());
            assertEquals(VALUE, e.getValue());
        });
        circularProgress.fireEvent(new ProgressEvent(PROGRESS, VALUE));
        assertTrue(progressEventFired[0]);
    }

    @Override
    public void testFontSize() {
        // given
        MaterialCircularProgress circularProgress = getWidget();

        // when
        circularProgress.setFontSize("12px");

        // then
        assertEquals("12px", circularProgress.getLabel().getFontSize());
        assertEquals("12px", circularProgress.getLabel().getElement().getStyle().getFontSize());

        // when
        circularProgress.setFontSize(14, Style.Unit.PX);

        // then
        assertEquals("14px", circularProgress.getLabel().getFontSize());
        assertEquals("14px", circularProgress.getLabel().getElement().getStyle().getFontSize());
    }

    public void testStructure() {
        // given
        MaterialCircularProgress circularProgress = getWidget();

        // when / then
        assertEquals(1, circularProgress.getChildren().size());
        assertTrue(circularProgress.getWidget(0) instanceof Span);
        Span lblText = (Span) circularProgress.getWidget(0);
        circularProgress.setText("50%");
        assertEquals("50%", lblText.getText());
    }

    public void testProperties() {
        // given
        MaterialCircularProgress circularProgress = getWidget();

        // when / then
        // Size
        assertEquals(100.0, circularProgress.getSize());
        circularProgress.setSize(200);
        assertEquals(200.0, circularProgress.getSize());
        // Thickness
        assertEquals(8, circularProgress.getThickness());
        circularProgress.setThickness(20);
        assertEquals(20, circularProgress.getThickness());
        // Start Angle
        assertEquals(Math.PI, circularProgress.getStartAngle());
        circularProgress.setStartAngle(Math.PI / 2);
        assertEquals(Math.PI / 2, circularProgress.getStartAngle());
        // Fill Color
        assertEquals(Color.BLUE, circularProgress.getFillColor());
        circularProgress.setFillColor(Color.RED);
        assertEquals(Color.RED, circularProgress.getFillColor());
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getFillColor()));
        // Empty Fill Color
        assertEquals(Color.GREY_LIGHTEN_2, circularProgress.getEmptyFillColor());
        circularProgress.setEmptyFillColor(Color.RED_LIGHTEN_2);
        assertEquals(Color.RED_LIGHTEN_2, circularProgress.getEmptyFillColor());
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getEmptyFillColor()));
        // Reverse
        assertFalse(circularProgress.isReverse());
        circularProgress.setReverse(true);
        assertTrue(circularProgress.isReverse());
    }

    public void testValue() {
        // given
        MaterialCircularProgress circularProgress = getWidget();

        // when / then
        assertEquals(0.0, circularProgress.getValue());
        circularProgress.setValue(0.5);
        assertEquals(0.5, circularProgress.getValue());
    }
}
