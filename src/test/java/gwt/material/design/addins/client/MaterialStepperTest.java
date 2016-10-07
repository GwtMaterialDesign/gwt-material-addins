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

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import gwt.material.design.addins.client.base.GwtMaterialAddinsTest;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.stepper.MaterialStep;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Span;
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
        checkStepNavigation(stepper);
        checkAxis(stepper);
        checkErrorSuccess(stepper);
        checkFeedback(stepper);
        checkSelection(stepper);
    }

    protected <T extends MaterialStepper> void checkSelection(T stepper) {
        final boolean[] isSelectionFired = {false};
        stepper.addSelectionChangeHandler(event -> {
            isSelectionFired[0] = true;
        });
        stepper.fireEvent(new GwtEvent<SelectionChangeEvent.Handler>() {
            @Override
            public Type<SelectionChangeEvent.Handler> getAssociatedType() {
                return SelectionChangeEvent.getType();
            }

            @Override
            protected void dispatch(SelectionChangeEvent.Handler eventHandler) {
                eventHandler.onSelectionChange(null);
            }
        });
        assertTrue(isSelectionFired[0]);
    }

    protected <T extends MaterialStepper> void checkErrorSuccess(T stepper) {
        // Specific tests for error and success
        MaterialStep step = stepper.getCurrentStep();
        MaterialWidget conCircle = (MaterialWidget) step.getWidget(0);

        stepper.setError("error");
        assertTrue(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertEquals(step.getIconError(), conCircle.getWidget(0));

        stepper.setSuccess("success");
        assertFalse(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertTrue(step.getElement().hasClassName(AddinsCssName.SUCCESS));
        assertEquals(step.getIconSuccess(), conCircle.getWidget(0));

        stepper.clearErrorOrSuccess();
        assertFalse(step.getElement().hasClassName(AddinsCssName.ERROR));
        assertFalse(step.getElement().hasClassName(AddinsCssName.SUCCESS));
    }

    protected <T extends MaterialStepper> void checkAxis(T stepper) {
        stepper.setAxis(Axis.VERTICAL);
        assertEquals(stepper.getAxis(), Axis.VERTICAL);
        assertTrue(stepper.getElement().hasClassName(Axis.VERTICAL.getCssName()));
        stepper.setAxis(Axis.HORIZONTAL);
        assertEquals(stepper.getAxis(), Axis.HORIZONTAL);
        assertTrue(stepper.getElement().hasClassName(Axis.HORIZONTAL.getCssName()));
    }

    protected <T extends MaterialStepper> void checkStepNavigation(T stepper) {
        final boolean[] isStartFired = {false};
        stepper.addStartHandler(event -> {
            isStartFired[0] = true;
        });
        RootPanel.get().add(stepper);
        assertTrue(isStartFired[0]);
        assertEquals(stepper.getWidgetCount(), 5);
        assertEquals(stepper.getCurrentStep(), stepper.getWidget(0));
        // Next Step Test
        for (int i = 0; i < stepper.getWidgetCount() - 1; i++) {
            final boolean[] isNextFired = {false};
            stepper.addNextHandler(event -> {
                isNextFired[0] = true;
            });
            stepper.nextStep();
            assertTrue(stepper.getWidget(i) instanceof MaterialStep);
            MaterialStep step = (MaterialStep) stepper.getWidget(i + 1);
            assertEquals(stepper.getCurrentStep(), step);
            // Check Next Event
            assertTrue(isNextFired[0]);
        }

        // Previous Step Test
        final int lastStepIndex = stepper.getWidgetCount();
        stepper.goToStep(lastStepIndex); // Go to last step
        assertEquals(stepper.getCurrentStep(), stepper.getWidget(lastStepIndex - 1));
        for (int i = stepper.getWidgetCount() - 1; i > 0; i--) {
            final boolean[] isPreviousFired = {false};
            stepper.addPreviousHandler(event -> {
                isPreviousFired[0] = true;
            });

            stepper.prevStep();
            assertTrue(stepper.getWidget(i - 1) instanceof MaterialStep);
            MaterialStep step = (MaterialStep) stepper.getWidget(i - 1);
            assertEquals(stepper.getCurrentStep(), step);
            // Check Previous Event
            assertTrue(isPreviousFired[0]);
        }

        // Check Complete Event
        final boolean[] isCompleteFired = {false};
        stepper.addCompleteHandler(event -> {
            isCompleteFired[0] = true;
        });
        stepper.goToStep(lastStepIndex);
        stepper.nextStep();
        assertTrue(isCompleteFired[0]);

        // Reset the Stepper
        stepper.reset();
        assertEquals(stepper.getCurrentStepIndex(), 0);
        assertEquals(stepper.getWidget(0), stepper.getCurrentStep());
    }

    protected <T extends MaterialStepper> void checkFeedback(T stepper) {
        final String FEEDBACK = "feedback";
        final int FEEDBACK_INDEX = stepper.getWidgetCount();
        stepper.showFeedback(FEEDBACK);
        assertEquals(stepper.getFeedback(), FEEDBACK);
        MaterialWidget feedback = (MaterialWidget) stepper.getWidget(FEEDBACK_INDEX);
        assertTrue(feedback.getWidget(0) instanceof Span);
        assertEquals(feedback.getWidget(0), stepper.getFeedbackSpan());
        assertEquals(stepper.getFeedbackSpan().getText(), FEEDBACK);
        stepper.hideFeedback();
        assertFalse(feedback.isAttached());
        assertFalse(stepper.getFeedbackSpan().isAttached());
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
            MaterialWidget cle = (MaterialWidget) step.getWidget(0);
            MaterialWidget conBody = (MaterialWidget) step.getWidget(1);
            assertEquals(cle.getWidgetCount(), 2);
            assertEquals(conBody.getWidgetCount(), 3);

            MaterialWidget divCircle = (MaterialWidget) cle.getWidget(0);
            MaterialWidget divLine = (MaterialWidget) cle.getWidget(1);

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
