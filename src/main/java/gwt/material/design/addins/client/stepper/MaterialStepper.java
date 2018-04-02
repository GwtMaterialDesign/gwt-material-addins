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
package gwt.material.design.addins.client.stepper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent.HasSelectionChangedHandlers;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.stepper.base.HasStepsHandler;
import gwt.material.design.addins.client.stepper.constants.State;
import gwt.material.design.addins.client.stepper.events.CompleteEvent;
import gwt.material.design.addins.client.stepper.events.NextEvent;
import gwt.material.design.addins.client.stepper.events.PreviousEvent;
import gwt.material.design.addins.client.stepper.events.StartEvent;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.HasAxis;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.js.Window;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Span;

//@formatter:off

/**
 * Steppers convey progress through numbered steps. They may also be used for navigation.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 *  <ma:stepper.MaterialStepper ui:field="stepper">
 *      <ma:stepper.MaterialStep step="1" title="Name of Step 1">
 *          <m:MaterialPanel width="100%" height="300px" backgroundColor="grey lighten-2"/>
 *          <m:MaterialButton ui:field="btnContinue1" text="Continue to Step 2" grid="l4" marginTop="12" backgroundColor="blue" textColor="white" waves="DEFAULT"/>
 *          <m:MaterialButton ui:field="btnPrev1" text="Cancel" grid="l4" marginTop="12" type="FLAT" waves="DEFAULT"/>
 *      </ma:stepper.MaterialStep>
 *      &lt;!-- Other Step components here -->
 *  </ma:stepper.MaterialStepper>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#steppers">Material Steppers</a>
 * @see <a href="https://material.io/guidelines/components/steppers.html">Material Design Specification</a>
 */
// @formatter:on
public class MaterialStepper extends MaterialWidget implements HasAxis, HasError, SelectionHandler<MaterialStep>,
        HasSelectionChangedHandlers, HasStepsHandler {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialStepperDebugClientBundle.INSTANCE.stepperDebugCss());
        } else {
            MaterialDesignBase.injectCss(MaterialStepperClientBundle.INSTANCE.stepperCss());
        }
    }

    private int currentStepIndex = 0;
    private boolean stepSkippingAllowed = true;
    private boolean detectOrientation = true;
    private Div divFeedback = new Div();
    private Span feedbackSpan = new Span();
    private HandlerRegistration orientationHandler;

    private CssNameMixin<MaterialStepper, Axis> axisMixin;

    public MaterialStepper() {
        super(Document.get().createDivElement(), AddinsCssName.STEPPER);

        divFeedback.setStyleName(AddinsCssName.FEEDBACK);
        divFeedback.add(feedbackSpan);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (getChildren().size() != 0) {
            StartEvent.fire(MaterialStepper.this);
            goToStep(currentStepIndex + 1);
        }

        setDetectOrientation(detectOrientation);
    }

    public void setDetectOrientation(boolean detectOrientation) {
        this.detectOrientation = detectOrientation;

        if (orientationHandler != null) {
            orientationHandler.removeHandler();
            orientationHandler = null;
        }

        if (detectOrientation) {
            orientationHandler = registerHandler(Window.addResizeHandler(resizeEvent -> detectAndApplyOrientation()));
            detectAndApplyOrientation();
        }
    }

    protected void detectAndApplyOrientation() {
        if (Window.matchMedia("(orientation: portrait)")) {
            setAxis(Axis.VERTICAL);
        } else {
            setAxis(Axis.HORIZONTAL);
        }
    }

    public boolean isDetectOrientation() {
        return detectOrientation;
    }

    /**
     * Specific method to add {@link MaterialStep}s to the stepper.
     */
    public void add(MaterialStep step) {
        this.add((Widget) step);
        step.setAxis(getAxis());
        registerHandler(step.addSelectionHandler(this));
    }

    /**
     * Go to next step, used by linear stepper.
     */
    public void nextStep() {
        if (currentStepIndex >= getWidgetCount() - 1) {
            CompleteEvent.fire(MaterialStepper.this, currentStepIndex + 1);
        } else {
            Widget w = getWidget(currentStepIndex);
            if (w instanceof MaterialStep) {
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);

                step.setSuccess(step.getDescription());

                // next step
                int nextStepIndex = getWidgetIndex(step) + 1;
                if (nextStepIndex >= 0) {
                    for (int i = nextStepIndex; i < getWidgetCount(); i++) {
                        w = getWidget(i);
                        if (!(w instanceof MaterialStep)) {
                            continue;
                        }
                        MaterialStep nextStep = (MaterialStep) w;
                        if (nextStep.isEnabled() && nextStep.isVisible()) {
                            nextStep.setActive(true);
                            setCurrentStepIndex(i);
                            NextEvent.fire(MaterialStepper.this);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Go to previous step , used by linear stepper.
     */
    public void prevStep() {
        if (currentStepIndex > 0) {
            Widget w = getWidget(currentStepIndex);
            if (w instanceof MaterialStep) {
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);

                // prev step
                int prevStepIndex = getWidgetIndex(step) - 1;
                if (prevStepIndex >= 0) {
                    for (int i = prevStepIndex; i >= 0; i--) {
                        w = getWidget(i);
                        if (!(w instanceof MaterialStep)) {
                            continue;
                        }
                        MaterialStep prevStep = (MaterialStep) w;
                        if (prevStep.isEnabled() && prevStep.isVisible()) {
                            prevStep.setActive(true);
                            setCurrentStepIndex(i);
                            PreviousEvent.fire(MaterialStepper.this);
                            break;
                        }
                    }
                }
            }
        } else {
            GWT.log("You have reached the minimum step.");
        }
    }

    /**
     * Go to specific step manually by setting which step index you want to go.
     */
    public void goToStep(int step) {
        for (int i = 0; i < getWidgetCount(); i++) {
            Widget w = getWidget(i);
            if (w instanceof MaterialStep) {
                ((MaterialStep) w).setActive(false);
            }
        }

        Widget w = getWidget(step - 1);
        if (w instanceof MaterialStep) {
            ((MaterialStep) w).setActive(true);
        }
        setCurrentStepIndex(step - 1);
    }

    /**
     * Go to the specfic {@link MaterialStep}.
     */
    public void goToStep(MaterialStep step) {
        for (int i = 0; i < getWidgetCount(); i++) {
            Widget w = getWidget(i);
            if (w instanceof MaterialStep) {
                MaterialStep materialStep = (MaterialStep) w;
                boolean active = materialStep.equals(step);
                materialStep.setActive(active);
                if (active) {
                    setCurrentStepIndex(i);
                }
            }
        }
    }

    /**
     * Go to the step with the specified step id.
     *
     * @see MaterialStep#getStep()
     */
    public void goToStepId(int id) {
        for (int i = 0; i < getWidgetCount(); i++) {
            Widget w = getWidget(i);
            if (w instanceof MaterialStep) {
                MaterialStep materialStep = (MaterialStep) w;
                boolean active = materialStep.getStep() == id;
                materialStep.setActive(active);
                if (active) {
                    setCurrentStepIndex(i);
                }
            }
        }
    }

    /**
     * Reset the Stepper to initial step (first step).
     */
    public void reset() {
        goToStep(1);
        clearErrorOrSuccess();
    }

    /**
     * Called internally when the index is changed. Fires a {@link SelectionChangeEvent}
     * when the current index changes.
     */
    protected void setCurrentStepIndex(int currentStepIndex) {
        if (this.currentStepIndex != currentStepIndex) {
            this.currentStepIndex = currentStepIndex;
            SelectionChangeEvent.fire(this);
        }

    }

    public int getCurrentStepIndex() {
        return currentStepIndex;
    }

    @Override
    public void setAxis(Axis axis) {
        getAxisMixin().setCssName(axis);
        for (int i = 0; i < getWidgetCount(); i++) {
            Widget w = getWidget(i);
            if (w instanceof MaterialStep) {
                ((MaterialStep) w).setAxis(axis);
            }
        }
    }

    @Override
    public Axis getAxis() {
        return getAxisMixin().getCssName();
    }

    /**
     * Gets the current step component.
     */
    public MaterialStep getCurrentStep() {
        if (currentStepIndex > getWidgetCount() - 1 || currentStepIndex < 0) {
            return null;
        }
        Widget w = getWidget(currentStepIndex);
        if (w instanceof MaterialStep) {
            return (MaterialStep) w;
        }
        return null;
    }

    @Override
    public void setError(String error) {
        getCurrentStep().setError(error);
    }

    @Override
    public void setSuccess(String success) {
        getCurrentStep().setSuccess(success);
    }

    @Override
    public void setHelperText(String helperText) {
        getCurrentStep().setDescription(helperText);
    }

    @Override
    public void clearErrorOrSuccess() {
        for (int i = 0; i < getWidgetCount(); i++) {
            Widget w = getWidget(i);
            if (w instanceof MaterialStep) {
                ((MaterialStep) w).clearErrorOrSuccess();
            }
        }
    }

    /**
     * Get feedback message.
     */
    public String getFeedback() {
        return feedbackSpan.getElement().getInnerHTML();
    }

    /**
     * Show feedback message and circular loader on body container
     */
    public void showFeedback(String feedbackText) {
        feedbackSpan.setText(feedbackText);
        new MaterialAnimation().transition(Transition.FADEINUP).duration(400).animate(feedbackSpan);
        MaterialLoader.loading(true, getCurrentStep().getDivBody());
        add(divFeedback);
    }

    /**
     * Hide feedback message and circular loader on body container.
     */
    public void hideFeedback() {
        divFeedback.removeFromParent();
    }

    /**
     * Sets whether the user is allowed to skip steps by clicking on the step title.
     * The default is <code>true</code>.
     */
    public void setStepSkippingAllowed(boolean stepSkippingAllowed) {
        this.stepSkippingAllowed = stepSkippingAllowed;
    }

    /**
     * Returns whether the user is allowed to skip steps by clicking on the step title.
     * The default is <code>true</code>.
     */
    public boolean isStepSkippingAllowed() {
        return stepSkippingAllowed;
    }

    public Span getFeedbackSpan() {
        return feedbackSpan;
    }

    /**
     * Called when a step title is clicked.
     */
    @Override
    public void onSelection(SelectionEvent<MaterialStep> event) {
        if (stepSkippingAllowed) {
            if (event.getSelectedItem().getState() == State.SUCCESS) {
                goToStep(event.getSelectedItem());
            }
        }
    }

    @Override
    public HandlerRegistration addSelectionChangeHandler(final Handler handler) {
        return addHandler(handler, SelectionChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addStartHandler(StartEvent.StartHandler handler) {
        return addHandler(handler, StartEvent.TYPE);
    }

    @Override
    public HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        return addHandler(handler, CompleteEvent.TYPE);
    }

    @Override
    public HandlerRegistration addNextHandler(NextEvent.NextHandler handler) {
        return addHandler(handler, NextEvent.TYPE);
    }

    @Override
    public HandlerRegistration addPreviousHandler(PreviousEvent.PreviousHandler handler) {
        return addHandler(handler, PreviousEvent.TYPE);
    }

    protected CssNameMixin<MaterialStepper, Axis> getAxisMixin() {
        if (axisMixin == null) {
            axisMixin = new CssNameMixin<>(this);
        }
        return axisMixin;
    }
}