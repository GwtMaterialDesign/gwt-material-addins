function initWaterfall(showCallback, hideCallback, offset) {
    $('nav').pushpin({ top: $('.waterfall').offset().height });
    $('nav').addClass('z-depth-0');

    var callbacks = $.Callbacks();

    function stickyScroll(e) {

        if( window.pageYOffset > offset) {
            $('nav').removeClass('z-depth-0');
            $('nav').addClass('z-depth-1');
        }else{
            $('nav').removeClass('z-depth-1');
            $('nav').addClass('z-depth-0');
        }

        if( window.pageYOffset > 1) {
            callbacks.add(hideCallback);
            callbacks.fire();

        }else{
            callbacks.add(showCallback);
            callbacks.fire();
        }
    }

    // Scroll handler to toggle classes.
    window.addEventListener('scroll', stickyScroll, false);
}