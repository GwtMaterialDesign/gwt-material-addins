/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.incubator.client.ui;

import com.google.gwt.dom.client.ScriptElement;
import gwt.material.design.incubator.client.MaterialWidgetTest;
import gwt.material.design.incubator.client.google.recaptcha.ReCaptcha;
import gwt.material.design.incubator.client.google.recaptcha.constants.RecaptchaTheme;
import gwt.material.design.incubator.client.google.recaptcha.constants.RecaptchaType;
import gwt.material.design.jquery.client.api.Functions;

/**
 * Test case for ReCaptcha Component
 *
 * @author kevzlou7979
 */
public class ReCaptchaTest extends MaterialWidgetTest<ReCaptcha> {

    @Override
    protected ReCaptcha createWidget() {
        return new ReCaptcha();
    }

    public void testProperties() {
        ReCaptcha reCaptcha = getWidget();

        // Check Themes
        reCaptcha.setTheme(RecaptchaTheme.LIGHT);
        assertEquals(reCaptcha.getTheme(), RecaptchaTheme.LIGHT);
        reCaptcha.setTheme(RecaptchaTheme.DARK);
        assertEquals(reCaptcha.getTheme(), RecaptchaTheme.DARK);

        // Check Callback
        final Functions.Func callback = () -> {};
        reCaptcha.setCallback(callback);
        assertEquals(reCaptcha.getCallback(), callback);

        // Check Type
        // Expected by default - IMAGE
        assertEquals(reCaptcha.getType(), RecaptchaType.IMAGE);
        reCaptcha.setType(RecaptchaType.AUDIO);
        assertEquals(reCaptcha.getType(), RecaptchaType.AUDIO);
        reCaptcha.setType(RecaptchaType.IMAGE);
        assertEquals(reCaptcha.getType(), RecaptchaType.IMAGE);
    }
}
