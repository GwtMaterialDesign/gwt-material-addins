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
package gwt.material.design.addins.client.base;

import com.google.gwt.user.client.ui.*;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.HasPlaceholder;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;

public class AbstractValueWidgetTest extends MaterialAddinsTest {

    public <T extends AbstractValueWidget & HasPlaceholder, H extends UIObject> void checkAbstractValueWidget(T widget, H target) {
        checkWidget(widget);
        checkErrorSuccess(widget, target);
        checkPlaceholder(widget);
    }

    public <T extends AbstractValueWidget, H extends UIObject> void checkAbstractValueWidgetWoPlaceholder(T widget, H target) {
        checkWidget(widget);
        checkErrorSuccess(widget, target);
    }

    protected <T extends MaterialWidget & HasError, H extends UIObject> void checkErrorSuccess(T widget, H target) {
        assertNotNull(target);
        widget.setError("Error");
        assertTrue(target.getElement().hasClassName(CssName.INVALID));
        widget.setSuccess("Success");
        assertTrue(target.getElement().hasClassName(CssName.VALID));
        widget.clearErrorOrSuccess();
        assertFalse(target.getElement().hasClassName(CssName.VALID));
        assertFalse(target.getElement().hasClassName(CssName.INVALID));
    }

    protected <T extends HasPlaceholder> void checkPlaceholder(T widget) {
        widget.setPlaceholder("Placeholder");
        assertEquals(widget.getPlaceholder(), "Placeholder");
        widget.setPlaceholder("");
        assertEquals(widget.getPlaceholder(), "");
    }

    protected <T extends Widget & HasValue & HasEnabled> void checkValueChangeEvent(T widget, Object value, Object secondValue) {
        RootPanel.get().add(widget);
        assertNotSame(value, secondValue);
        // Widget must be enabled before firing the event
        widget.setEnabled(true);
        assertTrue(widget.isEnabled());
        // Ensure the widget is attached to the root panel
        assertTrue(widget.isAttached());
        // Register value change handler that listens when the widget
        // set the value
        final boolean[] isValueChanged = {false};
        widget.addValueChangeHandler(event -> isValueChanged[0] = true);
        // By default setValue(boolean) will not fire the value change event.
        widget.setValue(value);
        assertEquals(widget.getValue(), value);
        // Expected result : false
        assertFalse(isValueChanged[0]);
        // Calling setValue(value, fireEvents) with fireEvents set to false
        widget.setValue(secondValue, false);
        // Expected result : secondValue
        assertEquals(widget.getValue(), secondValue);
        // Expected result : false
        assertFalse(isValueChanged[0]);
        // Calling setValue(value, fireEvents) with fireEvents set to true
        widget.setValue(value, true);
        // Expected result : true
        assertTrue(isValueChanged[0]);
        // Expected result : value
        assertEquals(widget.getValue(), value);
    }
}
