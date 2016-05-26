package gwt.material.design.addins.client.stepper;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent.HasSelectionChangedHandlers;
import gwt.material.design.addins.client.MaterialResourceInjector;
import gwt.material.design.client.base.HasAxis;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.animate.MaterialAnimator;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Span;

//@formatter:off

/**
 * Steppers convey progress through numbered steps. They may also be used for navigation.
 *
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 *
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
 */
// @formatter:on
public class MaterialStepper extends MaterialWidget implements HasAxis, HasError, SelectionHandler<MaterialStep>, HasSelectionChangedHandlers {

    static {
        if(MaterialResourceInjector.isDebug()) {
            MaterialResourceInjector.injectCss(MaterialStepperDebugClientBundle.INSTANCE.stepperDebugCss());
        } else {
            MaterialResourceInjector.injectCss(MaterialStepperClientBundle.INSTANCE.stepperCss());
        }
    }

    private int currentStepIndex = 0;
    private Div divFeedback = new Div();
    private Span feedback = new Span();
    private boolean stepSkippingAllowed = true;

    private final CssNameMixin<MaterialStepper, Axis> axisMixin = new CssNameMixin<>(this);

    public MaterialStepper (){
        super(Document.get().createDivElement(), "stepper");
        divFeedback.setStyleName("feedback");
        divFeedback.add(feedback);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        if(getChildren().size() != 0) {
            goToStep(currentStepIndex + 1);
        }
    }

    /**
     * Specific method to add {@link MaterialStep}s to the stepper.
     */
    public void add(MaterialStep step) {
        this.add((Widget)step);
        step.setAxis(getAxis());
        step.addSelectionHandler(this);
    }

    /**
     * Go to next Step , used by linear stepper.
     */
    public void nextStep() {
        if(currentStepIndex >= getWidgetCount() - 1){
            GWT.log("You have reach the maximum step.");
        }else{
            Widget w = getWidget(currentStepIndex);
            if(w instanceof MaterialStep){
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);
                step.setSuccess(step.getDescription());

                // next step
                int nextStepIndex = getWidgetIndex(step) + 1;
                if (nextStepIndex >= 0){
                    for(int i = nextStepIndex; i < getWidgetCount(); i++){
                        w = getWidget(i);
                        if (!(w instanceof MaterialStep)){
                            continue;
                        }
                        MaterialStep nextStep = (MaterialStep) w;
                        if (nextStep.isEnabled() && nextStep.isVisible()){
                            nextStep.setActive(true);
                            setCurrentStepIndex(i);
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
        if(currentStepIndex > 0) {
            Widget w = getWidget(currentStepIndex);
            if (w instanceof MaterialStep) {
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);

                // next step
                int prevStepIndex = getWidgetIndex(step) - 1;
                if (prevStepIndex >= 0){
                    for(int i = prevStepIndex; i >= 0; i--){
                        w = getWidget(i);
                        if (!(w instanceof MaterialStep)){
                            continue;
                        }
                        MaterialStep prevStep = (MaterialStep) w;
                        if (prevStep.isEnabled() && prevStep.isVisible()){
                            prevStep.setActive(true);
                            setCurrentStepIndex(i);
                            break;
                        }
                    }
                }
            }
        }else{
            GWT.log("You have reach the minimum step.");
        }
    }

    /**
     * Go to specific step manually by setting which step index you want to go.
     */
    public void goToStep(int step){
        for(int i = 0; i < getWidgetCount(); i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                ((MaterialStep) w).setActive(false);
            }
        }

        Widget w = getWidget(step - 1);
        if(w instanceof MaterialStep){
            ((MaterialStep) w).setActive(true);
        }
        setCurrentStepIndex(step - 1);
    }

    /**
     * Go to the specfic {@link MaterialStep}.
     */
    public void goToStep(MaterialStep step){
        for(int i = 0; i < getWidgetCount(); i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                MaterialStep materialStep = (MaterialStep) w;
                boolean active = materialStep.equals(step);
                materialStep.setActive(active);
                if (active){
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
    public void goToStepId(int id){
        for(int i = 0; i < getWidgetCount(); i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                MaterialStep materialStep = (MaterialStep) w;
                boolean active = materialStep.getStep() == id;
                materialStep.setActive(active);
                if (active){
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
        if (this.currentStepIndex != currentStepIndex){
            this.currentStepIndex = currentStepIndex;
            SelectionChangeEvent.fire(this);
        }
    }

    public int getCurrentStepIndex() {
        return currentStepIndex;
    }

    @Override
    public void setAxis(Axis axis) {
        axisMixin.setCssName(axis);
        for(int i = 0; i < getWidgetCount(); i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                ((MaterialStep) w).setAxis(axis);
            }
        }
    }

    @Override
    public Axis getAxis() {
        return axisMixin.getCssName();
    }

    /**
     * Gets the current step component.
     */
    public MaterialStep getCurrentStep() {
        if(currentStepIndex >= getWidgetCount() - 1 || currentStepIndex < 0){
            return null;
        }
        Widget w = getWidget(currentStepIndex);
        if (w instanceof MaterialStep){
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
    public void clearErrorOrSuccess() {
        for(int i = 0; i < getWidgetCount(); i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                ((MaterialStep) w).clearErrorOrSuccess();
            }
        }
    }

    /**
     * Get feedback message.
     */
    public String getFeedback() {
        return feedback.getElement().getInnerHTML();
    }

    /**
     * Show feedback message and circular loader on body container
     */
    public void showFeedback(String feedbackText) {
        feedback.setText(feedbackText);
        MaterialAnimator.animate(Transition.FADEINUP, feedback, 500);
        MaterialLoader.showLoading(true, getCurrentStep().getDivBody());
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

    /**
     * Called when a step title is clicked.
     */
    @Override
    public void onSelection(SelectionEvent<MaterialStep> event) {
        if (stepSkippingAllowed){
            goToStep(event.getSelectedItem());
        }
    }

    @Override
    public HandlerRegistration addSelectionChangeHandler(final Handler handler) {
        return addHandler(new Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                if(isEnabled()){
                    handler.onSelectionChange(event);
                }
            }
        }, SelectionChangeEvent.getType());
    }
}