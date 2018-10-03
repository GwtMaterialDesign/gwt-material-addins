package gwt.material.design.addins.client.stepper.mixin;

import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.stepper.MaterialStep;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.js.Window;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;

/**
 * A mixin that provides the ability to set the {@link Transition} for {@link MaterialStepper}
 */
public class StepperTransitionMixin<T extends MaterialStepper> implements HasStepperTransition {

    private T stepper;
    private Transition nextInTransition = Transition.SLIDEINRIGHT;
    private Transition nextOutTransition = Transition.SLIDEOUTLEFT;
    private Transition previousInTransition = Transition.SLIDEINLEFT;
    private Transition previousOutTransition = Transition.SLIDEOUTRIGHT;
    private boolean enableTransition = true;

    public StepperTransitionMixin(T stepper) {
        this.stepper = stepper;
    }

    @Override
    public void setNextInTransition(Transition nextInTransition) {
        this.nextInTransition = nextInTransition;
    }

    @Override
    public void setNextOutTransition(Transition nextOutTransition) {
        this.nextOutTransition = nextOutTransition;
    }

    @Override
    public void setPreviousInTransition(Transition previousInTransition) {
        this.previousInTransition = previousInTransition;
    }

    @Override
    public void setPreviousOutTransition(Transition previousOutTransition) {
        this.previousOutTransition = previousOutTransition;
    }

    @Override
    public void animateNext() {
        MaterialStep currentStep = stepper.getCurrentStep();
        MaterialStep nextStep = stepper.getStep(currentStep.getStep() + 1);
        if (currentStep != null && nextStep != null) {

            if (enableTransition && stepper.getAxis() == Axis.HORIZONTAL) {
                stepper.setOverflow(Style.Overflow.HIDDEN);
                currentStep.getDivBody().setOverflow(Style.Overflow.HIDDEN);
                new MaterialAnimation().transition(nextOutTransition).animate(currentStep.getConBody(), () -> {
                    currentStep.setActive(false);
                    currentStep.getDivBody().setOverflow(Style.Overflow.AUTO);
                    stepper.setOverflow(Style.Overflow.AUTO);
                });

                nextStep.setActive(true);
                new MaterialAnimation().transition(nextInTransition).animate(nextStep.getConBody());
            } else {
                currentStep.setActive(false);
                nextStep.setActive(true);
            }
        }
    }

    @Override
    public void animatePrevious() {
        MaterialStep currentStep = stepper.getCurrentStep();
        MaterialStep previousStep = stepper.getStep(currentStep.getStep() - 1);
        if (currentStep != null && previousStep != null) {
            if (enableTransition && stepper.getAxis() == Axis.HORIZONTAL) {
                stepper.setOverflow(Style.Overflow.HIDDEN);
                currentStep.getDivBody().setOverflow(Style.Overflow.HIDDEN);
                new MaterialAnimation().transition(previousOutTransition).animate(currentStep.getConBody(), () -> {
                    currentStep.setActive(false);
                    currentStep.getDivBody().setOverflow(Style.Overflow.AUTO);
                    currentStep.getDivBody().setOverflow(Style.Overflow.AUTO);
                });

                previousStep.setActive(true);
                previousStep.getDivBody().setOverflow(Style.Overflow.HIDDEN);
                new MaterialAnimation().transition(previousInTransition).animate(previousStep.getConBody(), () -> {
                    previousStep.getDivBody().setOverflow(Style.Overflow.AUTO);
                });
            } else {
                currentStep.setActive(false);
                previousStep.setActive(true);
            }
        }
    }

    @Override
    public void setEnableTransition(boolean enableTransition) {
        this.enableTransition = enableTransition;
    }

    @Override
    public boolean isEnableTransition() {
        return enableTransition;
    }
}
