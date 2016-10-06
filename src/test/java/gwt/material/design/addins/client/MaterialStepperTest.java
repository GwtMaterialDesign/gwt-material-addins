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

import gwt.material.design.addins.client.base.GwtMaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.stepper.MaterialStep;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialPanel;
import org.junit.Test;

/**
 * Test case for stepper component
 *
 * @author kevzlou7979
 */
public class MaterialStepperTest extends GwtMaterialAddinsTest {

    @Test
    public void testStepper() {
        MaterialStepper stepper = new MaterialStepper();
        checkWidget(stepper);
        checkStructure(stepper);
    }

    protected <T extends MaterialStepper> void checkStructure(T stepper) {
        for (int i = 1; i <= 5; i++) {
            MaterialStep step = new MaterialStep();
            step.setStep(i);
            step.setTitle("step" + i);
            step.setDescription("description" + i);
            stepper.add(step);
            assertEquals(step.getWidgetCount(), 2);
            assertTrue(step.getWidget(0) instanceof MaterialWidget);
            MaterialWidget conCircle = (MaterialWidget) step.getWidget(0);
            MaterialWidget conBody = (MaterialWidget) step.getWidget(1);
            assertEquals(conCircle.getWidgetCount(), 2);
            assertEquals(conBody.getWidgetCount(), 3);

            MaterialWidget divCircle = (MaterialWidget) conCircle.getWidget(0);
            MaterialWidget divLine = (MaterialWidget) conCircle.getWidget(1);

            assertEquals(step.getStep(), i);
            assertTrue(divCircle.getElement().hasClassName(CssName.CIRCLE));
            assertTrue(divLine.getElement().hasClassName(AddinsCssName.LINE));
            assertEquals(divCircle.getElement().getInnerHTML(), String.valueOf(i));

            MaterialWidget divTitle = (MaterialWidget) conBody.getWidget(0);
            MaterialWidget divDescription = (MaterialWidget) conBody.getWidget(1);
            MaterialWidget divBody = (MaterialWidget) conBody.getWidget(2);

            assertTrue(divTitle.getElement().hasClassName(CssName.TITLE));
            assertEquals(divTitle.getElement().getInnerHTML(), "step" + i);
            assertTrue(divDescription.getElement().hasClassName(AddinsCssName.DESCRIPTION));
            assertEquals(divDescription.getElement().getInnerHTML(), "description" + i);
            assertTrue(divBody.getElement().hasClassName(AddinsCssName.BODY));

            MaterialPanel panel = new MaterialPanel();
            step.add(panel);
            assertEquals(step.getDivBody().getWidgetCount(), 1);
            assertEquals(step.getDivBody().getWidget(0), panel);
        }

        assertEquals(stepper.getWidgetCount(), 5);
        for (int i = 0; i < 5; i++) {
            assertTrue(stepper.getWidget(i) instanceof MaterialStep);
            MaterialStep step = (MaterialStep) stepper.getWidget(i);
            assertEquals(step.getTitle(), "step" + (i + 1));
            assertEquals(step.getDescription(), "description" + (i + 1));
        }
    }
}
