/* -----------------------------------------------------
  Material Design Sliders
  CodePen URL: https://codepen.io/rkchauhan/pen/xVGGpR
  By: Ravikumar Chauhan
  
  Find me on:-
  * Twitter: https://twitter.com/rkchauhan01
  * Facebook: https://www.facebook.com/ravi032chauhan
  * GitHub: https://github.com/rkchauhan
  * CodePen: https://codepen.io/rkchauhan
  * UpLabs: http://uplabs.com/rkchauhan01

  Thanks to:-
  * Google Material design - https://www.google.com/design/spec/material-design/introduction.html
  * Google Material Color - https://www.google.com/design/spec/style/color.html
  * Google Material Icons - https://design.google.com/icons/
  * Roboto Font - https://google.com/fonts/specimen/Roboto
  * jQuery - https://jquery.com
-------------------------------------------------------- */
/* Range Slider Function */
(function($) {

    $.fn.rkmd_rangeSlider = function() {
        var self, slider_width, slider_offset, curnt, sliderContinuous, sliderDiscrete, range, slider;
        self             = $(this);
        slider_width     = self.outerWidth();
        slider_offset    = self.offset().left;

        sliderContinuous = $('.slider-continuous');
        sliderDiscrete   = $('.slider-discrete');

        if(self.hasClass('slider-continuous') === true) {

            sliderContinuous.each(function(i, v) {
                curnt         = $(this);
                curnt.append(sliderContinuous_tmplt());
                range         = curnt.find('input[type="range"]');
                slider        = curnt.find('.slider');
                slider_fill   = slider.find('.slider-fill');
                slider_handle = slider.find('.slider-handle');
                max           = range.attr("max");
                var range_val = (range.val() / max) * 100;
                slider_fill.css('width', range_val +'%');
                slider_handle.css('left', range_val +'%');

            });
        }

        if(self.hasClass('slider-discrete') === true) {

            sliderDiscrete.each(function(i, v) {
                curnt         = $(this);
                curnt.append(sliderDiscrete_tmplt());
                range         = curnt.find('input[type="range"]');
                slider        = curnt.find('.slider');
                slider_fill   = slider.find('.slider-fill');
                slider_handle = slider.find('.slider-handle');
                slider_label  = slider.find('.slider-label');
                max           = range.attr("max");
                var range_val = (range.val() / max) * 100;
                slider_fill.css('width', range_val +'%');
                slider_handle.css('left', range_val +'%');
                slider_label.find('span').text(range_val);
            });
        }

        self.on('mousedown touchstart', '.slider-handle', function(e) {
            if(e.button === 2) {
                return false;
            }

            var parents       = $(this).parents('.rkmd-slider');
            var slider_width  = parents.outerWidth();
            var slider_offset = parents.offset().left;
            var check_range   = parents.find('input[type="range"]').is(':disabled');

            if(check_range === true) {
                return false;
            }

            if(parents.hasClass('slider-discrete') === true) {
                $(this).addClass('is-active');
            }
            var handlers = {
                mousemove: function(e) {
                    var slider_new_width = e.pageX - slider_offset;

                    if(slider_new_width <= slider_width && !(slider_new_width < '0')) {
                        slider_move(parents, slider_new_width, slider_width);
                    }
                },
                touchmove: function(e) {
                    var touch = event.touches[0];
                    var slider_new_width = touch.pageX - slider_offset;

                    if(slider_new_width <= slider_width && !(slider_new_width < '0')) {
                        slider_move(parents, slider_new_width, slider_width);
                    }
                },
                mouseup: function(e) {
                    $(this).off(handlers);
                    var range          = self.find('input[type="range"]');
                    var slider_fill    = self.find('.slider-fill');
                    var slider_handle  = self.find('.slider-handle');
                    var step = range.attr("step");
                    var max = range.attr("max");
                    var value = range.val();
                    var slider_new_val;

                    // Manage Step
                    if (step && step > 0) {

                        var x = (value / step);
                        var y = (max / step) ;
                        var total = (x / y) * 100;
                        slider_new_val = total;

                        console.log(total);

                        slider_fill.css('width', slider_new_val +'%');
                        slider_handle.css({
                            'left': slider_new_val +'%',
                            'transition': 'none',
                            '-webkit-transition': 'none',
                            '-moz-transition': 'none'
                        });
                    }

                    if(parents.hasClass('slider-discrete') === true) {
                        parents.find('.is-active').removeClass('is-active');
                    }


                },
                touchend: function(e) {
                    $(this).off(handlers);

                    if(parents.hasClass('slider-discrete') === true) {
                        parents.find('.is-active').removeClass('is-active');
                    }
                }
            };
            $(document).on(handlers);
        });

        self.on('mousedown', '.slider', function(e) {
            if(e.button === 2) {
                return false;
            }

            var parents       = $(this).parents('.rkmd-slider');
            var slider_width  = parents.outerWidth();
            var slider_offset = parents.offset().left;
            var check_range   = parents.find('input[type="range"]').is(':disabled');

            if(check_range === true) {
                return false;
            }

            var slider_new_width = e.pageX - slider_offset;
            if(slider_new_width <= slider_width && !(slider_new_width < '0')) {
                slider_move(parents, slider_new_width, slider_width);
            }

            var handlers = {
                mouseup: function(e) {
                    $(this).off(handlers);
                }
            };
            $(document).on(handlers);

        });
    };

    function sliderContinuous_tmplt() {
        var tmplt = '<div class="slider">' +
            '<div class="slider-fill"></div>' +
            '<div class="slider-handle"></div>' +
            '</div>';

        return tmplt;
    }
    function sliderDiscrete_tmplt() {
        var tmplt = '<div class="slider">' +
            '<div class="slider-fill"></div>' +
            '<div class="slider-handle"><div class="slider-label"><span>0</span></div></div>' +
            '</div>';

        return tmplt;
    }
    function slider_move(parents, newW, sliderW) {
        var slider_new_val = parseInt(Math.round(newW / sliderW * 100));

        var slider_fill    = parents.find('.slider-fill');
        var slider_handle  = parents.find('.slider-handle');
        var range          = parents.find('input[type="range"]');


        slider_fill.css('width', slider_new_val +'%');
        slider_handle.css({
            'left': slider_new_val +'%',
            'transition': 'none',
            '-webkit-transition': 'none',
            '-moz-transition': 'none'
        });

        range.val(slider_new_val);

        if(parents.hasClass('slider-discrete') === true) {
            parents.find('.slider-handle span').text(slider_new_val);
        }

        parents.trigger("slider-change", range.val());
    }

}(jQuery));
