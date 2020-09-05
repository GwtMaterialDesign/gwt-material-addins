/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
