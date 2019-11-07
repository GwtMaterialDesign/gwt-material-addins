(function ($) {
    $.fn.extend({
        pwdstrength: function (options) {
            var _this = this;

            // Setup default options
            var defaults = {
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
            var container = document.createElement("div");
            container.classList.add("pwd-strength-meter");
            _this.parent().append(container);

            // Create Progress Indicator Label
            var labelContainer = document.createElement("div");
            labelContainer.classList.add("row");
            labelContainer.classList.add("label-container");
            container.append(labelContainer);

            var strengthLabel = document.createElement("span");
            strengthLabel.innerHTML = options.label.strength;
            strengthLabel.classList.add("strength-label");
            labelContainer.append(strengthLabel);

            var progressLabel = document.createElement("span");
            progressLabel.classList.add("progress-label");
            labelContainer.append(progressLabel);

            // Create ProgressBar
            var progressBar = document.createElement("div");
            progressBar.classList.add("progress");
            progressBar.style.height = options.progress.height;
            var progressFill = document.createElement("div");
            progressFill.classList.add("determinate");
            progressBar.append(progressFill);
            container.append(progressBar);

            // Create Suggestion UL
            var suggestionUl = document.createElement("ul");
            suggestionUl.classList.add("pwd-suggestions");
            container.append(suggestionUl);

            // Create Error Label
            var errorLabel = document.createElement("span");
            errorLabel.classList.add("pwd-error-label");
            container.append(errorLabel);

            // Assign Input Field change handlers
            _this.on("change keyup paste blur", function () {
                var value = _this.val();
                var url = location.origin + "/pwd/" + value + "/strength/" + options.limit;

                $.ajax({
                    type: "GET",
                    contentType: "application/json",
                    url: url,
                    dataType: 'json',
                    success: function (data) {
                        var percent = data.percent;
                        var suggestions = data.suggestions;

                        // Update Progress
                        var color;
                        progressFill.style.width = percent + "%";
                        if (percent > 0 && percent <= 25) {
                            color = options.progress.color.weak;
                            progressLabel.innerText = options.label.weak;
                        } else if (percent > 25 && percent <= 50) {
                            color = options.progress.color.fair;
                            progressLabel.innerText = options.label.fair;
                        } else if (percent > 50 && percent <= 75) {
                            color = options.progress.color.good;
                            progressLabel.innerText = options.label.good;
                        } else if (percent > 75 && percent <= 100) {
                            color = options.progress.color.strong;
                            progressLabel.innerText = options.label.strong;
                        } else {
                            progressLabel.innerText = "";
                        }

                        progressLabel.style.color = color;
                        progressFill.style.backgroundColor = color;

                        // Update Suggestions
                        if (options.showSuggestions) {
                            suggestionUl.innerHTML = "";
                            for (i = 0; i < suggestions.length; i++) {
                                var suggestionListItem = document.createElement("li");
                                var suggestion = suggestions[i];
                                suggestionListItem.innerHTML = "<span>" + suggestion + "</span>"
                                suggestionUl.append(suggestionListItem)
                            }
                        } else {
                            suggestionUl.remove();
                        }
                    },
                    error: function (xhr, status, error) {
                        errorLabel.innerHTML = error;
                    }
                });
            });
        }
    });
})(jQuery);