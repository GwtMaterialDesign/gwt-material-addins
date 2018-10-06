/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.addins.client.stepper.mixin;

import gwt.material.design.client.ui.animate.Transition;

public interface HasStepperTransition {

    /**
     * Will set the next incoming transition of {@link gwt.material.design.addins.client.stepper.MaterialStepper}
     */
    void setNextInTransition(Transition transition);

    /**
     * Will set the next out coming transition of {@link gwt.material.design.addins.client.stepper.MaterialStepper}
     */
    void setNextOutTransition(Transition transition);

    /**
     * Will set the previous incoming transition of {@link gwt.material.design.addins.client.stepper.MaterialStepper}
     */
    void setPreviousInTransition(Transition transition);

    /**
     * Will set the previous out coming transition of {@link gwt.material.design.addins.client.stepper.MaterialStepper}
     */
    void setPreviousOutTransition(Transition transition);

    /**
     * Performs animation when {@link gwt.material.design.addins.client.stepper.MaterialStepper} proceeds to next step
     */
    void animateNext();

    /**
     * Performs animation when {@link gwt.material.design.addins.client.stepper.MaterialStepper} proceeds to previous step
     */
    void animatePrevious();

    /**
     * Will enable the {@link gwt.material.design.addins.client.stepper.MaterialStepper} transition. True by Default
     */
    void setEnableTransition(boolean enableTransition);

    /**
     * Check if transition is enabled by the {@link gwt.material.design.addins.client.stepper.MaterialStepper}
     */
    boolean isEnableTransition();
}
