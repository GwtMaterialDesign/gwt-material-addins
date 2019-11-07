package gwt.material.design.incubator.client.password;

import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.password.js.PasswordStrengthOptions;

import static gwt.material.design.incubator.client.password.js.JsPasswordStrengthMeter.$;

public class PasswordStrengthTextBox extends MaterialTextBox {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(PasswordStrengthTextBoxDebugClientBundle.INSTANCE.pwdStrengthMeterDebugCss());
            MaterialDesignBase.injectDebugJs(PasswordStrengthTextBoxDebugClientBundle.INSTANCE.pwdStrengthMeterDebugJs());
        } else {
            MaterialDesignBase.injectCss(PasswordStrengthTextBoxClientBundle.INSTANCE.pwdStrengthMeterCss());
            MaterialDesignBase.injectJs(PasswordStrengthTextBoxClientBundle.INSTANCE.pwdStrengthMeterJs());
        }
    }

    protected PasswordStrengthOptions options = new PasswordStrengthOptions();

    @Override
    protected void onLoad() {
        super.onLoad();

        setType(InputType.PASSWORD);
        $(valueBoxBase.getElement()).pwdstrength(options);
    }

    public PasswordStrengthOptions getOptions() {
        return options;
    }

    public void setOptions(PasswordStrengthOptions options) {
        this.options = options;
    }
}
