package gwt.material.design.incubator.client.google.recaptcha.api;

import gwt.material.design.client.api.google.maps.GoogleApi;

public class RecaptchaApi extends GoogleApi {

    public RecaptchaApi(String apiKey) {
        super(apiKey);
    }

    @Override
    public String getApiUrl() {
        return "https://www.google.com/recaptcha/api.js?onload=recaptchaCallback&render=explicit";
    }
}
