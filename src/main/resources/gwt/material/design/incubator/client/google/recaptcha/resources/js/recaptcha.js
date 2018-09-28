var _element;
var _siteKey;
var _callback;
var _expiredCallback;
var _errorCallback;
var _theme;
var _validation_type;
var _callbacks = $.Callbacks();
var _errorCallbacks = $.Callbacks();
var _expiredCallbacks = $.Callbacks();

function initReCaptcha(element, siteKey, callback, expiredCallback, errorCallback, theme, type) {
    _element = element;
    _siteKey = siteKey;
    _theme = theme;
    _validation_type = type;

    // Data Callback
    _callback = callback;
    _callbacks.add(callback);

    // Data Expired Callback
    _expiredCallback = expiredCallback;
    _expiredCallbacks.add(expiredCallback);

    // Data Error Callback
    _errorCallback = errorCallback;
    _errorCallbacks.add(errorCallback);
}

var recaptchaCallback = function() {
    grecaptcha.render(_element, {
        'sitekey' : _siteKey,
        'callback' : recaptchaVerifyCallback,
        'expired-callback' : recaptchaExpiredCallback,
        'error-callback' : recaptchaErrorCallback,
        'theme' : _theme,
        'type' : _validation_type
    });
};

function getResponse() {
    return grecaptcha.getResponse();
}

function reset() {
    grecaptcha.reset();
}

var recaptchaVerifyCallback = function(response) {
    _callbacks.fire(response);
}

var recaptchaExpiredCallback = function() {
    _expiredCallbacks.fire();
}

var recaptchaErrorCallback = function() {
    _errorCallbacks.fire();
}