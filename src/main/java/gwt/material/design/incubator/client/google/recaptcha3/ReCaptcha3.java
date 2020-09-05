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
package gwt.material.design.incubator.client.google.recaptcha3;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.base.IncubatorWidget;
import gwt.material.design.incubator.client.google.recaptcha.api.RecaptchaApi;
import gwt.material.design.incubator.client.google.recaptcha.js.JsReCaptcha;
import gwt.material.design.incubator.client.google.recaptcha3.api.RecaptchaApi3;
import gwt.material.design.incubator.client.google.recaptcha3.constants.ReCaptcha3Actions;
import gwt.material.design.incubator.client.google.recaptcha3.constants.ReCaptcha3Option;
import gwt.material.design.incubator.client.google.recaptcha3.js.JsReCaptcha3;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * reCAPTCHA v3 returns a score for each request without user friction. The score is based on interactions with your
 * site and enables you to take an appropriate action for your site. Register reCAPTCHA v3 keys here.
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
public class ReCaptcha3 extends MaterialWidget {

    static {
        IncubatorWidget.showWarning(ReCaptcha3.class);
    }

    private ReCaptcha3Option option = ReCaptcha3Option.create();

    public ReCaptcha3() {
        super(Document.get().createDivElement());
    }

    /**
     * A function to load the recaptcha api.
     * @param recaptchaApi A class containing the Api Key and Url
     * @param callback A callback function to return the token to be verified by the server.
     */
    public void load(RecaptchaApi3 recaptchaApi, Functions.Func1<String> callback) {
        JsReCaptcha3.ready(() -> {
            JsReCaptcha3.execute(recaptchaApi.getApiKey(), option).then((object) -> {
                callback.call(object != null ? object.toString() : null);
                return object;
            });
        });
    }

    /**
     * Will get the option for the Recaptcha3
     */
    public ReCaptcha3Option getOption() {
        return option;
    }

    /**
     * Will set the option for the Recaptcha3
     */
    public void setOption(ReCaptcha3Option option) {
        this.option = option;
    }
}
