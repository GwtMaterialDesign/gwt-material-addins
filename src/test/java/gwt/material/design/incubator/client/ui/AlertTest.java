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

import com.google.gwt.dom.client.Element;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.incubator.client.ui.base.MaterialWidgetTest;
import gwt.material.design.incubator.client.alert.Alert;
import gwt.material.design.incubator.client.alert.constants.AlertType;

/**
 * Test case for Alert Component
 *
 * @author kevzlou7979
 */
public class AlertTest extends MaterialWidgetTest<Alert> {

    @Override
    protected Alert createWidget() {
        return new Alert();
    }

    public void testShowHide() {
        Alert alert = getWidget();

        Element element = alert.getElement();
        alert.open();
        assertTrue(element.hasClassName(CssName.OPEN));
        alert.close();
        assertFalse(element.hasClassName(CssName.OPEN));
    }

    public void testStructure() {
        Alert alert = getWidget();

        final String TEXT = "text";
        final IconType ICON = IconType.AC_UNIT;
        // Check Structure
        assertEquals(alert.getWidgetCount(), 2);
        assertTrue(alert.getWidget(0) instanceof MaterialIcon);
        assertTrue(alert.getWidget(1) instanceof MaterialLabel);
        // Check setText()
        alert.setText(TEXT);
        assertEquals(alert.getText(), TEXT);
        // Check setIconType()
        alert.setIconType(ICON);
        assertEquals(alert.getIcon().getIconType(), ICON);
    }

    public void testType() {
        Alert alert = getWidget();

        alert.setType(AlertType.ERROR);
        assertEquals(alert.getType(), AlertType.ERROR);
        assertTrue(alert.getElement().hasClassName(AlertType.ERROR.getCssName()));

        alert.setType(AlertType.INFORMATION);
        assertEquals(alert.getType(), AlertType.INFORMATION);
        assertTrue(alert.getElement().hasClassName(AlertType.INFORMATION.getCssName()));

        alert.setType(AlertType.WARNING);
        assertEquals(alert.getType(), AlertType.WARNING);
        assertTrue(alert.getElement().hasClassName(AlertType.WARNING.getCssName()));
    }
}
