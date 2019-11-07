package gwt.material.design.incubator.client.password;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface PasswordStrengthTextBoxClientBundle extends ClientBundle {
    PasswordStrengthTextBoxClientBundle INSTANCE = GWT.create(PasswordStrengthTextBoxClientBundle.class);

    @Source("resources/css/pwd-strength-meter.min.css")
    TextResource pwdStrengthMeterCss();

    @Source("resources/js/pwd-strength-meter.min.js")
    TextResource pwdStrengthMeterJs();
}
