(function ($) {
    var _container;
    var _labelContainer;
    var _strengthLabel;
    var _progressLabel;
    var _progressBar;
    var _progressFill;
    var _suggestionUl;
    var _errorLabel;

    $.fn.extend({
        pwdstrength: function (options) {
            var _this = this;

            // Setup default options
            var defaults = {
                url: location.origin + "/pwd/strength/",
                limit: 4,
                showSuggestions: true,
                label : {
                    strength : "Password Strength",
                    weak : "Weak",
                    fair : "Fair",
                    good : "Good",
                    strong : "Strong"
                },
                progress : {
                    width  : "100%",
                    height : "8px",
                    color : {
                        weak : "#f44336",
                        fair : "#ffc107",
                        good : "#2196f3",
                        strong : "#4caf50"
                    }
                }
            };
            options = $.extend(defaults, options);

            // Create PWD Strength Container
            _container = document.createElement("div");
            _container.classList.add("pwd-strength-meter");
            _this.parent().append(_container);

            // Create Progress Indicator Label
            _labelContainer = document.createElement("div");
            _labelContainer.classList.add("row");
            _labelContainer.classList.add("label-container");
            _container.append(_labelContainer);

            _strengthLabel = document.createElement("span");
            _strengthLabel.innerHTML = options.label.strength;
            _strengthLabel.classList.add("strength-label");
            _labelContainer.append(_strengthLabel);

            _progressLabel = document.createElement("span");
            _progressLabel.classList.add("progress-label");
            _labelContainer.append(_progressLabel);

            // Create ProgressBar
            _progressBar = document.createElement("div");
            _progressBar.classList.add("progress");
            _progressBar.style.height = options.progress.height;
            _progressFill = document.createElement("div");
            _progressFill.classList.add("determinate");
            _progressBar.append(_progressFill);
            _container.append(_progressBar);

            // Create Suggestion UL
            _suggestionUl = document.createElement("ul");
            _suggestionUl.classList.add("pwd-suggestions");
            _container.append(_suggestionUl);

            // Create Error Label
            _errorLabel = document.createElement("span");
            _errorLabel.classList.add("pwd-error-label");
            _container.append(_errorLabel);

            // Assign Input Field change handlers
            _this.on("change keyup paste blur", function () {
                var value = _this.val();
                var url = options.url + options.limit;

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: url,
                    data: value,
                    dataType: 'json',
                    success: function (data) {
                        var percent = data.percent;
                        var suggestions = data.suggestions;

                        // Update Progress
                        var color;
                        _progressFill.style.width = percent + "%";
                        if (percent > 0 && percent <= 25) {
                            color = options.progress.color.weak;
                            _progressLabel.innerText = options.label.weak;
                        } else if (percent > 25 && percent <= 50) {
                            color = options.progress.color.fair;
                            _progressLabel.innerText = options.label.fair;
                        } else if (percent > 50 && percent <= 75) {
                            color = options.progress.color.good;
                            _progressLabel.innerText = options.label.good;
                        } else if (percent > 75 && percent <= 100) {
                            color = options.progress.color.strong;
                            _progressLabel.innerText = options.label.strong;
                        } else {
                            _progressLabel.innerText = "";
                        }

                        _progressLabel.style.color = color;
                        _progressFill.style.backgroundColor = color;

                        // Update Suggestions
                        if (options.showSuggestions) {
                            _suggestionUl.innerHTML = "";
                            for (i = 0; i < suggestions.length; i++) {
                                var suggestionListItem = document.createElement("li");
                                var suggestion = suggestions[i];
                                suggestionListItem.innerHTML = "<span>" + suggestion + "</span>"
                                _suggestionUl.append(suggestionListItem)
                            }
                        } else {
                            _suggestionUl.remove();
                        }
                    },
                    error: function (xhr, status, error) {
                        _errorLabel.innerHTML = error;
                    }
                });

                if (value === "") {
                    $(_this).reset();
                }
            });
        },
        destroy: function() {
            _container.remove();
        },
        reset: function() {
            _errorLabel.innerHTML = "";
            _suggestionUl.innerHTML = "";
            _progressLabel.innerText = "";
            _progressFill.style.width = "0%";
        }
    });
})(jQuery);