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
import gwt.material.design.client.base.mixin.CssNameMixin;
import gwt.material.design.client.constants.Axis;

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
public class MaterialStepper extends ComplexWidget implements HasAxis {

    private int totalSteps = 0;
    private int currentStep = 0;

    private final CssNameMixin<MaterialStepper, Axis> axisMixin = new CssNameMixin<>(this);

    public MaterialStepper (){
        super(Document.get().createDivElement());
        setStyleName("stepper");
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
        if(currentStep >= getWidgetCount() - 1){
            GWT.log("You have reach the maximum step.");
        }else{
            Widget w = getWidget(currentStep);
            if(w instanceof MaterialStep){
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);

                // next step
                int nextStepIndex = getWidgetIndex(step) + 1;
                MaterialStep nextStep = (MaterialStep) getWidget(nextStepIndex);
                nextStep.setActive(true);
            }
            currentStep++;
        }
    }

    /**
     * Go to previous step , used by linear stepper.
     */
    public void prevStep() {
        if(currentStep > 0) {
            Widget w = getWidget(currentStep);
            if (w instanceof MaterialStep) {
                MaterialStep step = (MaterialStep) w;
                step.setActive(false);

                // next step
                int prevStepIndex = getWidgetIndex(step) - 1;
                MaterialStep prevStep = (MaterialStep) getWidget(prevStepIndex);
                prevStep.setActive(true);
            }
            currentStep--;
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
        currentStep = step - 1;
    }

    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    @Override
    public void setAxis(Axis axis) {
        axisMixin.setCssName(axis);
    }

    @Override
    public Axis getAxis() {
        return axisMixin.getCssName();
    }
}
