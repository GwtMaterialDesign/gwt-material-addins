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

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import gwt.material.design.addins.client.MaterialWidgetTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.stepper.MaterialStep;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.addins.client.stepper.constants.State;
import gwt.material.design.addins.client.stepper.events.StartEvent;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Span;

import java.util.ArrayList;
import java.util.List;

/**
 * Test case for stepper component
 *
 * @author kevzlou7979
 */
public class MaterialStepperTest extends MaterialWidgetTest<MaterialStepper> {

    private List<MaterialStep> steps;

    @Override
    protected MaterialStepper createWidget() {
        MaterialStepper stepper = new MaterialStepper();
        steps = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            MaterialStep step = new MaterialStep();
            step.setStep(i);
            step.setTitle("step" + i);
            step.setDescription("description" + i);
            stepper.add(step);
            steps.add(step);
        }

        return stepper;
    }

    public void testStructure() {
        MaterialWidget stepper = getWidget();

        steps.forEach(step -> {
            int i = steps.indexOf(step) + 1;
            assertEquals(2, step.getWidgetCount());
            assertTrue(step.getWidget(0) instanceof MaterialWidget);
            MaterialWidget cle = (MaterialWidget) step.getWidget(0);
            MaterialWidget conBody = (MaterialWidget) step.getWidget(1);
            assertEquals(2, cle.getWidgetCount());
            assertEquals(3, conBody.getWidgetCount());

            MaterialWidget divCircle = (MaterialWidget) cle.getWidget(0);
            MaterialWidget divLine = (MaterialWidget) cle.getWidget(1);

            assertEquals(step.getStep(), i);
            assertTrue(divCircle.getElement().hasClassName(CssName.CIRCLE));
            assertTrue(divLine.getElement().hasClassName(AddinsCssName.LINE));
            assertEquals(String.valueOf(i), divCircle.getElement().getInnerHTML());

            MaterialWidget divTitle = (MaterialWidget) conBody.getWidget(0);
            MaterialWidget divDescription = (MaterialWidget) conBody.getWidget(1);
            MaterialWidget divBody = (MaterialWidget) conBody.getWidget(2);

            assertTrue(divTitle.getElement().hasClassName(CssName.TITLE));
            assertEquals("step" + i, divTitle.getElement().getInnerHTML());
            assertTrue(divDescription.getElement().hasClassName(AddinsCssName.DESCRIPTION));
            assertEquals("description" + i, divDescription.getElement().getInnerHTML());
            assertTrue(divBody.getElement().hasClassName(AddinsCssName.BODY));

            MaterialPanel panel = new MaterialPanel();
            step.add(panel);
            assertEquals(1, step.getDivBody().getWidgetCount());
            assertEquals(panel, step.getDivBody().getWidget(0));
            assertEquals("step" + i, step.getTitle());
            assertEquals("description" + i, step.getDescription());
        });

        assertEquals(stepper.getWidgetCount(), 5);
    }

    public void testSelection() {
        MaterialStepper stepper = getWidget();
        final boolean[] isSelectionFired = {false};
        stepper.addSelectionChangeHandler(event -> isSelectionFired[0] = true);
        SelectionChangeEvent.fire(stepper);
        assertTrue(isSelectionFired[0]);
    }

    public void testErrorSuccess() {
        MaterialStepper stepper = getWidget();
        // Specific tests for error and success
        MaterialStep step = stepper.getCurrentStep();
        MaterialWidget conCircle = (MaterialWidget) step.getWidget(0);

        stepper.setError("error");
        assertTrue(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertEquals(step.getIconError(), conCircle.getWidget(0));
        assertEquals(State.ERROR, step.getState());

        stepper.setSuccess("success");
        assertFalse(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertTrue(step.getElement().hasClassName(AddinsCssName.SUCCESS));
        assertEquals(step.getIconSuccess(), conCircle.getWidget(0));
        assertEquals(State.SUCCESS, step.getState());

        stepper.clearErrorOrSuccess();
        assertFalse(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertFalse(step.getElement().hasClassName(AddinsCssName.SUCCESS));
    }

    public void testAxis() {
        MaterialStepper stepper = getWidget();
        assertNotNull(stepper.getCurrentStep());
        MaterialStep step = stepper.getCurrentStep();
        MaterialWidget conCircle = (MaterialWidget) step.getWidget(0);
        MaterialWidget conBody = (MaterialWidget) step.getWidget(1);

        stepper.setAxis(Axis.VERTICAL);
        assertEquals(Axis.VERTICAL, stepper.getAxis());
        assertTrue(stepper.getElement().hasClassName(Axis.VERTICAL.getCssName()));

        assertTrue(conBody.getWidget(0).getElement().hasClassName(CssName.TITLE));
        assertTrue(conBody.getWidget(1).getElement().hasClassName(AddinsCssName.DESCRIPTION));
        assertTrue(conBody.getWidget(2).getElement().hasClassName(AddinsCssName.BODY));

        stepper.setAxis(Axis.HORIZONTAL);
        assertEquals(Axis.HORIZONTAL, stepper.getAxis());
        assertTrue(stepper.getElement().hasClassName(Axis.HORIZONTAL.getCssName()));
        assertTrue(step.getWidget(0) instanceof MaterialWidget);
        MaterialWidget horiCon = (MaterialWidget) step.getWidget(0);
        assertTrue(horiCon.getWidget(1).getElement().hasClassName(CssName.TITLE));
        assertTrue(horiCon.getWidget(3).getElement().hasClassName(AddinsCssName.DESCRIPTION));
    }

    public void testStepNavigation() {
        MaterialStepper stepper = getWidget();
        final boolean[] isStartFired = {false};
        stepper.addStartHandler(event -> isStartFired[0] = true);
        StartEvent.fire(stepper);
        assertTrue(isStartFired[0]);
        assertEquals(5, stepper.getWidgetCount());
        assertEquals(stepper.getWidget(0), stepper.getCurrentStep());
        // Next Step Test
        for (int i = 0; i < stepper.getWidgetCount() - 1; i++) {
            final boolean[] isNextFired = {false};
            stepper.addNextHandler(event -> {
                isNextFired[0] = true;
            });
            stepper.nextStep();
            assertTrue(stepper.getWidget(i) instanceof MaterialStep);
            MaterialStep step = (MaterialStep) stepper.getWidget(i + 1);
            assertEquals(step, stepper.getCurrentStep());
            // Check Next Event
            assertTrue(isNextFired[0]);
        }

        // Previous Step Test
        final int lastStepIndex = stepper.getWidgetCount();
        stepper.goToStep(lastStepIndex); // Go to last step
        assertEquals(stepper.getWidget(lastStepIndex - 1), stepper.getCurrentStep());
        for (int i = stepper.getWidgetCount() - 1; i > 0; i--) {
            final boolean[] isPreviousFired = {false};
            stepper.addPreviousHandler(event -> isPreviousFired[0] = true);

            stepper.prevStep();
            assertTrue(stepper.getWidget(i - 1) instanceof MaterialStep);
            MaterialStep step = (MaterialStep) stepper.getWidget(i - 1);
            assertEquals(stepper.getCurrentStep(), step);
            // Check Previous Event
            assertTrue(isPreviousFired[0]);
        }

        // Check Complete Event
        final boolean[] isCompleteFired = {false};
        stepper.addCompleteHandler(event -> isCompleteFired[0] = true);
        stepper.goToStep(lastStepIndex);
        stepper.nextStep();
        assertTrue(isCompleteFired[0]);

        // Reset the Stepper
        stepper.reset();
        assertEquals(0, stepper.getCurrentStepIndex());
        assertEquals(stepper.getWidget(0), stepper.getCurrentStep());
    }

    public void testFeedback() {
        MaterialStepper stepper = getWidget();
        final String FEEDBACK = "feedback";
        final int FEEDBACK_INDEX = stepper.getWidgetCount();
        stepper.showFeedback(FEEDBACK);
        assertEquals(FEEDBACK, stepper.getFeedback());
        MaterialWidget feedback = (MaterialWidget) stepper.getWidget(FEEDBACK_INDEX);
        assertTrue(feedback.getWidget(0) instanceof Span);
        assertEquals(feedback.getWidget(0), stepper.getFeedbackSpan());
        assertEquals(FEEDBACK, stepper.getFeedbackSpan().getText());
        stepper.hideFeedback();
        assertFalse(feedback.isAttached());
        assertFalse(stepper.getFeedbackSpan().isAttached());
    }
}
