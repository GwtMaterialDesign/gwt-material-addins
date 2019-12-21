package gwt.material.design.addins.client.stepper;

import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.dark.AddinsWidgetDarkTheme;

public class MaterialStepperDarkTheme extends AddinsWidgetDarkTheme {

    public MaterialStepperDarkTheme() {
        super(MaterialAddins.isDebug() ? MaterialStepperDebugClientBundle.INSTANCE.stepperDarkCss() : MaterialStepperClientBundle.INSTANCE.stepperDarkCss());
    }
}
