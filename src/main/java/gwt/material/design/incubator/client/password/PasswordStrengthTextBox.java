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

import gwt.material.design.addins.client.base.dependency.DependencyMixin;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.base.dependency.HasDependency;
import gwt.material.design.client.constants.InputType;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.incubator.client.password.js.JsPasswordStrengthMeter;
import gwt.material.design.incubator.client.password.js.PasswordStrengthOptions;

import java.util.Collections;
import java.util.List;

import static gwt.material.design.incubator.client.password.js.JsPasswordStrengthMeter.$;

public class PasswordStrengthTextBox extends MaterialTextBox implements HasDependency {

    protected DependencyMixin<HasDependency> dependencyMixin;
    protected PasswordStrengthOptions options = new PasswordStrengthOptions();
    protected JsPasswordStrengthMeter strengthMeter;

    @Override
    protected void onLoad() {
        getDependencyMixin().install(() -> {
            internalLoad();
            super.onLoad();
        });
    }

    protected void internalLoad() {
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

    public DependencyMixin<HasDependency> getDependencyMixin() {
        if (dependencyMixin == null) {
            dependencyMixin = new DependencyMixin<>(this);
        }
        return dependencyMixin;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(PasswordStrengthTextBoxClientBundle.INSTANCE.pwdStrengthMeterCss(), PasswordStrengthTextBoxDebugClientBundle.INSTANCE.pwdStrengthMeterDebugCss()));
    }

    @Override
    public List<DependencyResource> getJsDependencies() {
        return Collections.singletonList(new DependencyResource(PasswordStrengthTextBoxClientBundle.INSTANCE.pwdStrengthMeterJs(), PasswordStrengthTextBoxClientBundle.INSTANCE.pwdStrengthMeterJs()));
    }
}
