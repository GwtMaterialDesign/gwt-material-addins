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
package gwt.material.design.incubator.client.google.recaptcha;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.google.recaptcha.api.RecaptchaApi;
import gwt.material.design.incubator.client.google.recaptcha.constants.RecaptchaTheme;
import gwt.material.design.incubator.client.google.recaptcha.constants.RecaptchaType;
import gwt.material.design.incubator.client.google.recaptcha.js.JsReCaptcha;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * ReCaptcha is a free service that protects your website from spam and abuse.
 * ReCaptcha uses an advanced risk analysis engine and adaptive CAPTCHAs to keep automated
 * software from engaging in abusive activities on your site.
 * It does this while letting your valid users pass through with ease.
 * <p>
 * <h3>UiBinder</h3>
 * <pre>
 * {@code
 *      <recaptcha:ReCaptcha ui:field="recaptcha" />
 * }
 * </pre>
 * <h3>Java - Loading the API</h3>
 * <pre>
 * {@code
 *  @literal @UiField
 *      ReCaptcha recaptcha;
 *
 *      // Load the Api
 *      RecaptchaApi recaptchaApi = new RecaptchaApi("6LeZSRIUAAAAAE3JdZpdi6shhA87ZUG4U2ICsGlJ");
 *      ApiRegistry.register(recaptchaApi, new Callback<Void, Exception>() {
 *         @literal @Override
 *          public void onFailure(Exception reason) {
 *              MaterialToast.fireToast(reason.getMessage());
 *          }
 *
 *         @literal @Override
 *          public void onSuccess(Void result) {
 *              recaptcha.load(recaptchaApi);
 *          }
 *      });
 * }
 * </pre>
 * <p>
 * <p><i>
 * Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class ReCaptcha extends MaterialWidget {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectDebugJs(ReCaptchaDebugClientBundle.INSTANCE.recaptchaDebugJs());
        } else {
            MaterialDesignBase.injectJs(ReCaptchaClientBundle.INSTANCE.recaptchaJs());
        }
    }

    public ReCaptcha() {
        super(Document.get().createDivElement());
    }

    private RecaptchaTheme theme = RecaptchaTheme.LIGHT;
    private RecaptchaType type = RecaptchaType.IMAGE;
    private Functions.Func callback;
    private JsReCaptcha reCaptcha;

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
    }

    public void load(RecaptchaApi recaptchaApi) {
        String uid = DOM.createUniqueId();
        setId(uid);

        reCaptcha = JsReCaptcha.initReCaptcha(uid, recaptchaApi.getApiKey(), callback, theme.getTheme(), type.getType());
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    public void unload() {
        if (reCaptcha != null) {
            reCaptcha.off();
        }
    }

    public void reload() {
        if (reCaptcha != null) {
            reCaptcha.reset();
        }
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
    public void setTheme(RecaptchaTheme theme) {
        this.theme = theme;
    }

    public RecaptchaTheme getTheme() {
        return theme;
    }

    /**
     * Set the type of reCaptcha, at the moment we have 2 types (IMAGE : AUDIO)
     */
    public void setType(RecaptchaType type) {
        this.type = type;
    }

    public RecaptchaType getType() {
        return type;
    }
}
