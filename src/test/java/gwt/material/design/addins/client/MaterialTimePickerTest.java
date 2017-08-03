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
package gwt.material.design.addins.client;

import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.addins.client.base.AbstractValueWidgetTest;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.base.MaterialWidget;
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
public class MaterialTimePickerTest extends AbstractValueWidgetTest {

    public void init() {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        checkWidget(timePicker);
        checkValue(timePicker);
        checkPlaceholder(timePicker);
        checkOrientation(timePicker);
    }

    protected <T extends MaterialTimePicker> void checkOrientation(T timePicker) {
        timePicker.setOrientation(Orientation.LANDSCAPE);
        assertEquals(timePicker.getOrientation(), Orientation.LANDSCAPE);
        timePicker.setOrientation(Orientation.PORTRAIT);
        assertEquals(timePicker.getOrientation(), Orientation.PORTRAIT);
    }

    @Override
    protected <T extends MaterialWidget & HasEnabled, H extends MaterialWidget> void checkEnabled(T widget, H target) {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        super.checkEnabled(timePicker, timePicker.getTimeInput());
    }

    @Override
    protected <T extends MaterialWidget> void checkInteractionEvents(T widget, boolean enabled) {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        checkOpenHandler(timePicker);
        checkCloseHandler(timePicker);

    }

    @Override
    protected <T extends MaterialWidget> void checkChildren(T widget) {
        MaterialTimePicker timePicker = new MaterialTimePicker();
        RootPanel.get().add(timePicker);
        assertEquals(timePicker.getWidgetCount(), 1);
        assertTrue(timePicker.getWidget(0) instanceof MaterialPanel);
        MaterialPanel panel = (MaterialPanel) timePicker.getWidget(0);
        assertEquals(panel.getWidgetCount(), 3);
        assertTrue(panel.getWidget(0) instanceof Label);
        assertTrue(panel.getWidget(1) instanceof MaterialInput);
        assertTrue(panel.getWidget(2) instanceof MaterialLabel);
    }

    protected <T extends MaterialTimePicker> void checkValue(T timePicker) {
        final Date VALUE = new Date(116, 9, 14, 10, 10);
        final Date SECOND_VALUE = new Date(116, 9, 14, 12, 32);
        timePicker.setValue(VALUE);
        assertEquals(timePicker.getValue(), VALUE);
        timePicker.reset();
        assertEquals(String.valueOf(timePicker.getValue()), String.valueOf(new Date()));
        checkValueChangeEvent(timePicker, VALUE, SECOND_VALUE);
    }
}
