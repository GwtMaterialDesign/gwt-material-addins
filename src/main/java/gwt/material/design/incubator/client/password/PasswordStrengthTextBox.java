package gwt.material.design.incubator.client.password;

import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.password.js.JsPasswordStrengthMeter;
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
    protected JsPasswordStrengthMeter strengthMeter;

    @Override
    protected void onLoad() {
        super.onLoad();

        setType(InputType.PASSWORD);
        strengthMeter = $(valueBoxBase.getElement());
        strengthMeter.pwdstrength(options);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        destroy();
    }

    @Override
    public void reset() {
        clear();
        strengthMeter.reset();
    }

    public void destroy() {
        strengthMeter.destroy();
    }

    public PasswordStrengthOptions getOptions() {
        return options;
    }

    public void setOptions(PasswordStrengthOptions options) {
        this.options = options;
    }
}
