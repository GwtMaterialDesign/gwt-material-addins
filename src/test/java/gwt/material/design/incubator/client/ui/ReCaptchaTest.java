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
import gwt.material.design.incubator.client.recaptcha.ReCaptcha;
import gwt.material.design.incubator.client.recaptcha.constants.CaptchaTheme;
import gwt.material.design.incubator.client.recaptcha.constants.CaptchaType;
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

    public void testReCaptchaScriptElement() {
        ReCaptcha reCaptcha = getWidget();

        assertNotNull(reCaptcha.getReCaptchaScriptElement());
        ScriptElement element = reCaptcha.getReCaptchaScriptElement();
        assertEquals(element.getAttribute("async"), "");
        assertEquals(element.getAttribute("defer"), "");
        reCaptcha.removeFromParent();
        assertFalse(reCaptcha.isAttached());
    }

    public void testProperties() {
        ReCaptcha reCaptcha = getWidget();

        // Check Themes
        reCaptcha.setTheme(CaptchaTheme.LIGHT);
        assertEquals(reCaptcha.getTheme(), CaptchaTheme.LIGHT);
        reCaptcha.setTheme(CaptchaTheme.DARK);
        assertEquals(reCaptcha.getTheme(), CaptchaTheme.DARK);

        // Check Site Key
        final String SITE_KEY = "sampleSitekKey";
        reCaptcha.setSiteKey(SITE_KEY);
        assertEquals(reCaptcha.getSiteKey(), SITE_KEY);

        // Check Callback
        final Functions.Func callback = () -> {};
        reCaptcha.setCallback(callback);
        assertEquals(reCaptcha.getCallback(), callback);

        // Check Type
        // Expected by default - IMAGE
        assertEquals(reCaptcha.getType(), CaptchaType.IMAGE);
        reCaptcha.setType(CaptchaType.AUDIO);
        assertEquals(reCaptcha.getType(), CaptchaType.AUDIO);
        reCaptcha.setType(CaptchaType.IMAGE);
        assertEquals(reCaptcha.getType(), CaptchaType.IMAGE);
    }
}
