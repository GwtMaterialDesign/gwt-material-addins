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

import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.constants.Orientation;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Label;

import java.util.Date;

/**
 * Test case for Time Picker
 *
 * @author kevzlou7979
 */
public class MaterialTimePickerTest extends MaterialWidgetTest<MaterialTimePicker> {

    @Override
    protected MaterialTimePicker createWidget() {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        checkOpenHandler(timePicker);
        checkCloseHandler(timePicker);
        return timePicker;
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
        MaterialTimePicker timePicker = getWidget(true);

        // when / then
        final Date VALUE = new Date(116, 9, 14, 10, 10);
        final Date SECOND_VALUE = new Date(116, 9, 14, 12, 32);
        timePicker.setValue(VALUE);
        assertEquals(VALUE, timePicker.getValue());
        timePicker.reset();
        assertEquals(String.valueOf(new Date()), String.valueOf(timePicker.getValue()));
        checkValueChangeEvent(timePicker, VALUE, SECOND_VALUE);
    }
}
