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
