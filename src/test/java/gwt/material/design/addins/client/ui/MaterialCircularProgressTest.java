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
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.circularprogress.MaterialCircularProgress;
import gwt.material.design.addins.client.circularprogress.events.CompleteEvent;
import gwt.material.design.addins.client.circularprogress.events.ProgressEvent;
import gwt.material.design.addins.client.circularprogress.events.StartEvent;
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
        // UiBinder
        // given
        MaterialCircularProgress circularProgress = getWidget(false);

        // when / then
        checkEvents(circularProgress);

        // Standard
        // given
        attachWidget();

        // when / then
        checkEvents(circularProgress);
    }

    protected void checkEvents(MaterialCircularProgress circularProgress) {
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
        // UiBinder
        // given
        MaterialCircularProgress circularProgress = getWidget(false);

        // when / then
        checkFontSize(circularProgress);

        // Standard
        // given
        attachWidget();

        // when / then
        checkFontSize(circularProgress);
    }

    protected void checkFontSize(MaterialCircularProgress circularProgress) {
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

        assertTrue(circularProgress.getWidget(0) instanceof Span);
        Span lblText = (Span) circularProgress.getWidget(0);
        circularProgress.setText("50%");
        assertEquals("50%", lblText.getText());
    }

    public void testProperties() {
        // UiBinder
        // given
        MaterialCircularProgress circularProgress = getWidget(false);

        // when / then
        checkProperties(circularProgress);

        // Standard
        // given
        attachWidget();

        // when / then
        checkProperties(circularProgress);
    }

    protected void checkProperties(MaterialCircularProgress circularProgress) {
        // Size
        circularProgress.setSize(200);
        assertEquals(200.0, circularProgress.getSize());
        // Thickness
        circularProgress.setThickness(20);
        assertEquals(20, circularProgress.getThickness());
        // Start Angle
        circularProgress.setStartAngle(Math.PI / 2);
        assertEquals(Math.PI / 2, circularProgress.getStartAngle());
        // Fill Color
        circularProgress.setFillColor(Color.RED);
        assertEquals(Color.RED, circularProgress.getFillColor());
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getFillColor()));
        // Empty Fill Color
        circularProgress.setEmptyFillColor(Color.RED_LIGHTEN_2);
        assertEquals(Color.RED_LIGHTEN_2, circularProgress.getEmptyFillColor());
        assertNotNull(ColorHelper.setupComputedBackgroundColor(circularProgress.getEmptyFillColor()));
        // Reverse
        circularProgress.setReverse(true);
        assertTrue(circularProgress.isReverse());
    }

    public void testValue() {
        // UiBinder
        // given
        MaterialCircularProgress circularProgress = getWidget(false);

        // when / then
        checkValue(circularProgress);

        // Standard
        // given
        attachWidget();

        // when / then
        //TODO Check value
        //checkValue(circularProgress);
    }

    protected void checkValue(MaterialCircularProgress circularProgress) {
        circularProgress.setValue(0.5);
        assertEquals(0.5, circularProgress.getValue());
        circularProgress.setValue(0.0);
        assertEquals(0.0, circularProgress.getValue());
    }

    public void testResponsive() {
        // UiBinder
        // given
        MaterialCircularProgress circularProgress = getWidget(false);

        // when / then
        checkResponsive(circularProgress);

        // Standard
        // given
        attachWidget();

        // when / then
        checkResponsive(circularProgress);
    }

    protected void checkResponsive(MaterialCircularProgress circularProgress) {
        circularProgress.setResponsive(true);
        assertTrue(circularProgress.isResponsive());
        assertTrue(circularProgress.getElement().hasClassName(AddinsCssName.RESPONSIVE));
        assertEquals(1000.0, circularProgress.getSize());

        circularProgress.setResponsive(false);
        assertFalse(circularProgress.isResponsive());
        assertFalse(circularProgress.getElement().hasClassName(AddinsCssName.RESPONSIVE));
        assertEquals(100.0, circularProgress.getSize());
    }
}
