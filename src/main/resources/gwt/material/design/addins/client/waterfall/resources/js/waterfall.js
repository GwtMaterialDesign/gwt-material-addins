function initWaterfall(height, showCallback, hideCallback, offset) {
    $('nav').pushpin({ top: height });
    $('nav').addClass('z-depth-0');

    var callbacks = $.Callbacks();
    var show;
    function stickyScroll(e) {

        if( window.pageYOffset > offset) {
            if (show !== true) {
                $('nav').removeClass('z-depth-0');
                $('nav').addClass('z-depth-1');
                show = true;
            }
        }else{
            if (show === true) {
                $('nav').removeClass('z-depth-1');
                $('nav').addClass('z-depth-0');
                show = false;
            }
        }

        if( window.pageYOffset > 1) {
            callbacks.add(hideCallback);
            callbacks.fire();

        }else{
            callbacks.add(showCallback);
            callbacks.fire();
        }
    }

    window.addEventListener('scroll', stickyScroll, false);
}