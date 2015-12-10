package gwt.material.design.addins.client.ui;

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
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.ComplexWidget;
import gwt.material.design.client.base.HasAxis;
import gwt.material.design.client.base.HasError;
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
 * xmlns:m.addins='urn:import:gwt.material.design.addins.client.ui'
 * }
 * </pre>
 *
 * <h3>UiBinder Usage:</h3>
 *
 * <pre>
 * {@code
 *  <m.addins:MaterialStepper ui:field="stepper">
 *      <m.addins:MaterialStep step="1" title="Name of Step 1">
 *          <m.addins:MaterialPanel width="100%" height="300px" backgroundColor="grey lighten-2"/>
 *          <m.addins:MaterialButton ui:field="btnContinue1" text="Continue to Step 2" grid="l4" marginTop="12" backgroundColor="blue" textColor="white" waves="DEFAULT"/>
 *          <m.addins:MaterialButton ui:field="btnPrev1" text="Cancel" grid="l4" marginTop="12" type="FLAT" waves="DEFAULT"/>
 *      </m.addins:MaterialStep>
 *  &lt;!-- Other Step components here -->
 *  </m.addins:MaterialStepper>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/snapshot/#steppers">Material Steppers</a>
 */
// @formatter:on
public class MaterialStepper extends ComplexWidget implements HasAxis, HasError {

    private int totalSteps = 0;
    private int currentStepIndex = 0;
    private Div divFeedback = new Div();
    private Span feedback = new Span();

    private final CssNameMixin<MaterialStepper, Axis> axisMixin = new CssNameMixin<>(this);

    public MaterialStepper (){
        super(Document.get().createDivElement());
        setStyleName("stepper");
        divFeedback.setStyleName("feedback");
        divFeedback.add(feedback);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        goToStep(1);
    }

    /**
     * Go to next Step , used by linear stepper
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
                MaterialStep nextStep = (MaterialStep) getWidget(nextStepIndex);
                nextStep.setActive(true);
            }
            currentStepIndex++;
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
                MaterialStep prevStep = (MaterialStep) getWidget(prevStepIndex);
                prevStep.setActive(true);
            }
            currentStepIndex--;
        }else{
            GWT.log("You have reach the minimum step.");
        }
    }

    /**
     * Go to specific step manually by setting which step you want to go.
     * @param step
     */
    public void goToStep(int step){
        totalSteps = getWidgetCount();
        for(int i = 0; i < totalSteps; i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                ((MaterialStep) w).setActive(false);
            }
        }

        Widget w = getWidget(step - 1);
        if(w instanceof MaterialStep){
            ((MaterialStep) w).setActive(true);
        }
        currentStepIndex = step - 1;
    }

    /**
     * Reset the Stepper to initial step (first step)
     */
    public void reset() {
        goToStep(1);
        clearErrorOrSuccess();
    }

    public void setCurrentStepIndex(int currentStepIndex) {
        this.currentStepIndex = currentStepIndex;
    }

    public int getCurrentStepIndex() {
        return currentStepIndex;
    }

    @Override
    public void setAxis(Axis axis) {
        axisMixin.setCssName(axis);
    }

    @Override
    public Axis getAxis() {
        return axisMixin.getCssName();
    }

    /**
     * Gets the current step component
     * @return
     */
    public MaterialStep getCurrentStep() {
        return (MaterialStep) getWidget(getCurrentStepIndex());
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
        for(int i = 0; i < totalSteps; i++){
            Widget w = getWidget(i);
            if(w instanceof MaterialStep){
                ((MaterialStep) w).clearErrorOrSuccess();
            }
        }
    }

    public String getFeedback() {
        return feedback.getElement().getInnerHTML();
    }

    public void setFeedback(String feedbackText) {
        feedback.setText(feedbackText);
        MaterialAnimator.animate(Transition.FADEINUP, feedback, 500);
        MaterialLoader.showLoading(true, getCurrentStep().getDivBody());
        add(divFeedback);
    }

    public void hideFeedback() {
        divFeedback.removeFromParent();
    }
}
