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

import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.addins.client.timepicker.js.JsTimePicker;
import gwt.material.design.addins.client.ui.base.AbstractValueWidgetTest;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconSize;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.Orientation;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.Date;

import static gwt.material.design.jquery.client.api.JQuery.$;

/**
 * Test case for Time Picker
 *
 * @author kevzlou7979
 */
public class MaterialTimePickerTest extends AbstractValueWidgetTest<MaterialTimePicker> {

    final static Date VALUE = new Date(116, 9, 14, 10, 10);
    final static Date SECOND_VALUE = new Date(116, 9, 14, 12, 32);

    @Override
    protected MaterialTimePicker createWidget() {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        checkOpenHandler(timePicker);
        checkCloseHandler(timePicker);
        return timePicker;
    }

    public void test24Hour() {
        // UiBinder
        // given
        MaterialTimePicker timePicker = getWidget();

        // when / then
        timePicker.setHour24(true);
        assertTrue(timePicker.isHour24());

        timePicker.addOpenHandler(openEvent -> {
            assertEquals("00", $(".lolliclock-dial-hours .lolliclock-tick").eq(22).html());
            timePicker.setHour24(false);
            assertFalse(timePicker.isHour24());
            assertEquals("12", $(".lolliclock-dial-hours .lolliclock-tick").eq(11).html());
        });
        timePicker.open();
    }

    public void testReset() {
        // UiBinder
        // given
        MaterialTimePicker timePicker = getWidget();

        // when / then
        timePicker.setValue(VALUE);
        assertEquals(VALUE, timePicker.getValue());

        timePicker.clear();
        assertEquals(null, timePicker.getValue());
    }

    public void testPlacehoder() {
        MaterialTimePicker timePicker = getWidget(false);

        checkPlaceholder(timePicker);

        attachWidget();

        checkPlaceholder(timePicker);
    }

    public void testError() {
        MaterialTimePicker timePicker = getWidget(false);

        checkFieldErrorSuccess(timePicker, timePicker.getErrorLabel());

        attachWidget();

        checkFieldErrorSuccess(timePicker, timePicker.getErrorLabel());
    }

    public void testReadOnly() {
        MaterialTimePicker timePicker = getWidget();

        checkReadOnly(timePicker, timePicker.getTimeInput());
    }

    public void testFieldIcon() {
        MaterialTimePicker timePicker = getWidget();

        timePicker.setIconType(IconType.DATE_RANGE);
        timePicker.setIconSize(IconSize.LARGE);
        timePicker.setIconColor(Color.RED);

        assertEquals(timePicker.getIcon(), timePicker.getContainer().getWidget(0));
        assertEquals(IconType.DATE_RANGE, timePicker.getIcon().getIconType());
        assertEquals(IconSize.LARGE, timePicker.getIcon().getIconSize());
        assertEquals(Color.RED, timePicker.getIconColor());
    }

    public void testOrientation() {
        // UiBinder
        // given
        MaterialTimePicker timePicker = getWidget(false);

        // when / then
        checkOrientation(timePicker);

        // Standard
        // given
        attachWidget();

        // when / then
        checkOrientation(timePicker);
    }

    protected void checkOrientation(MaterialTimePicker timePicker) {
        timePicker.setOrientation(Orientation.LANDSCAPE);
        assertEquals(Orientation.LANDSCAPE, timePicker.getOrientation());
        timePicker.setOrientation(Orientation.PORTRAIT);
        assertEquals(Orientation.PORTRAIT, timePicker.getOrientation());
    }

    @Override
    public void testEnabled() {
        // given
        MaterialTimePicker timePicker = getWidget(false);

        // when / then
        checkEnabled(timePicker, timePicker.getTimeInput());

        // Standard
        // given
        attachWidget();

        // when / then
        checkEnabled(timePicker, timePicker.getTimeInput());
    }

    @Override
    public void testChildren() {
        // UiBinder
        // given
        MaterialTimePicker timePicker = getWidget(true);

        assertEquals(1, timePicker.getWidgetCount());
        assertTrue(timePicker.getWidget(0) instanceof MaterialPanel);
        MaterialPanel panel = (MaterialPanel) timePicker.getWidget(0);
        assertEquals(3, panel.getWidgetCount());
        assertTrue(panel.getWidget(0) instanceof Label);
        assertTrue(panel.getWidget(1) instanceof MaterialInput);
        assertTrue(panel.getWidget(2) instanceof MaterialLabel);
    }

    public void testValue() {
        // UiBinder
        // given
        MaterialTimePicker timePicker = getWidget();

        // when / then
        timePicker.setValue(VALUE);
        assertEquals(VALUE, timePicker.getValue());
        timePicker.reset();
        checkValueChangeEvent(timePicker, VALUE, SECOND_VALUE);
    }

    public void testLanguage() {
        // Given
        MaterialTimePicker timePicker = getWidget();

        // when / then
        checkOkCancelTextConfigs(timePicker);
    }

    protected void checkOkCancelTextConfigs(MaterialTimePicker timePicker) {
        final String OK_TEXT = "Tapos Na";
        final String CANCEL_TEXT = "Kanselahin";

        timePicker.setOkText(OK_TEXT);
        assertEquals(OK_TEXT, timePicker.getOkText());

        timePicker.setCancelText(CANCEL_TEXT);
        assertEquals(CANCEL_TEXT, timePicker.getCancelText());

        final boolean[] firedOpenHandler = {false};
        timePicker.addOpenHandler(openEvent -> {
            firedOpenHandler[0] = true;
            JQueryElement cancelButton = $(".lolliclock-buttons .lolliclock-button:nth-child(1)");
            assertNotNull(cancelButton);
            assertEquals(CANCEL_TEXT, cancelButton.text());

            JQueryElement okButton = $(".lolliclock-buttons .lolliclock-button:nth-child(2)");
            assertNotNull(okButton);
            assertEquals(OK_TEXT, okButton.text());
        });

        JsTimePicker.$(timePicker.getTimeInput().getElement()).lolliclock("show");
        assertTrue(firedOpenHandler[0]);
    }
}
