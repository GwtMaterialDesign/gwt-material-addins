package gwt.material.design.incubator.client.password;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface PasswordStrengthTextBoxDebugClientBundle extends ClientBundle {
    PasswordStrengthTextBoxDebugClientBundle INSTANCE = GWT.create(PasswordStrengthTextBoxDebugClientBundle.class);

    @Source("resources/css/pwd-strength-meter.css")
    TextResource pwdStrengthMeterDebugCss();

    @Source("resources/js/pwd-strength-meter.js")
    TextResource pwdStrengthMeterDebugJs();
}
