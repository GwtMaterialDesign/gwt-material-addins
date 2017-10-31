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
package gwt.material.design.incubator.client.recaptcha;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;
import gwt.material.design.incubator.client.recaptcha.constants.CaptchaTheme;
import gwt.material.design.incubator.client.recaptcha.constants.CaptchaType;
import gwt.material.design.incubator.client.recaptcha.js.JsReCaptcha;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * ReCaptcha is a free service that protects your website from spam and abuse.
 * ReCaptcha uses an advanced risk analysis engine and adaptive CAPTCHAs to keep automated
 * software from engaging in abusive activities on your site.
 * It does this while letting your valid users pass through with ease.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      ReCaptcha reCaptcha = new ReCaptcha();
 *      reCaptcha.setSiteKey("site_key")
 *      reCaptcha.setTheme(CaptchaTheme.DARK);
 *      reCaptcha.setType(CaptchaType.AUDIO);
 * }
 * </pre>
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class ReCaptcha extends MaterialWidget implements JsLoader {

    public ReCaptcha() {
        super(Document.get().createDivElement());
    }

    private CaptchaTheme theme = CaptchaTheme.LIGHT;
    private CaptchaType type = CaptchaType.IMAGE;
    private String siteKey;
    private Functions.Func callback;
    private JsReCaptcha reCaptcha;
    private ScriptElement reCaptchaScriptElement = Document.get().createScriptElement();

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectJs(ReCaptchaDebugClientBundle.INSTANCE.recaptchaDebugJs());
        } else {
            MaterialDesignBase.injectJs(ReCaptchaClientBundle.INSTANCE.recaptchaJs());
        }
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        load();
    }

    @Override
    public void load() {

        String uid = DOM.createUniqueId();
        setId(uid);

        Element head = Document.get().getElementsByTagName("head").getItem(0);
        reCaptchaScriptElement.setType("text/javascript");
        reCaptchaScriptElement.setSrc("https://www.google.com/recaptcha/api.js?onload=recaptchaCallback&render=explicit");
        reCaptchaScriptElement.setAttribute("async", "");
        reCaptchaScriptElement.setAttribute("defer", "");
        head.appendChild(reCaptchaScriptElement);

        reCaptcha = JsReCaptcha.initReCaptcha(uid, siteKey, () -> callback.call(), theme.getTheme(), type.getType());
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        if (reCaptchaScriptElement != null) {
            reCaptchaScriptElement.removeFromParent();
            reCaptcha = null;
        }
    }

    @Override
    public void reload() {
        if (reCaptcha != null) {
            reCaptcha.reset();
        }
    }

    /**
     * Site key needed to sign your reCaptcha
     */
    public void setSiteKey(String siteKey) {
        this.siteKey = siteKey;
    }

    public String getSiteKey() {
        return siteKey;
    }

    /**
     * Set a callback method once reCaptcha is confirmed and validated
     */
    public void setCallback(Functions.Func callback) {
        this.callback = callback;
    }

    public Functions.Func getCallback() {
        return callback;
    }

    /**
     * Set the theme of reCaptcha component (Default : LIGHT)
     */
    public void setTheme(CaptchaTheme theme) {
        this.theme = theme;
    }

    public CaptchaTheme getTheme() {
        return theme;
    }

    /**
     * Set the type of reCaptcha, at the moment we have 2 types (IMAGE : AUDIO)
     */
    public void setType(CaptchaType type) {
        this.type = type;
    }

    public CaptchaType getType() {
        return type;
    }

    /**
     * Get the reCaptcha API script element attached on head.
     */
    public ScriptElement getReCaptchaScriptElement() {
        return reCaptchaScriptElement;
    }
}
