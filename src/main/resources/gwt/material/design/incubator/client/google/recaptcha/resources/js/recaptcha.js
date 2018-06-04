var _element;
var _siteKey;
var _callback;
var _theme;
var _validation_type;
var _callbacks = $.Callbacks();

function initReCaptcha(element, siteKey, callback, theme, type) {
    _element = element;
    _siteKey = siteKey;
    _callback = callback;
    _callbacks.add(callback);
    _theme = theme;
    _validation_type = type;
}

var recaptchaCallback = function() {
    grecaptcha.render(_element, {
        'sitekey' : _siteKey,
        'callback' : recaptchaVerifyCallback,
        'theme' : _theme,
        'type' : _validation_type
    });
};

var recaptchaVerifyCallback = function(response) {
    _callbacks.fire();
}