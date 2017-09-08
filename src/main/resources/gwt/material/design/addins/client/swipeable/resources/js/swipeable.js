function initSwipeablePanel(element, leftCallback, rightCallback, onStartLeft, onStartRight, onEndLeft, onEndRight) {
    var swipeLeftToRight;
    var swipeRightToLeft;

    var callbacks = $.Callbacks();

    // Teardown previous callbacks
    callbacks.empty();

    $(element).each(function() {
        $(this).hammer({
            prevent_default: false
        }).bind('panstart', function(e) {
            if (e.gesture.pointerType === "touch") {
                var direction = e.gesture.direction;
                var x = e.gesture.deltaX;
                var velocityX = e.gesture.velocityX;
                // On Start Swipe Left
                if (direction === 4 && (x > (parent.innerWidth() / 2) || velocityX < -0.75)) {
                    callbacks.add(onStartLeft);
                    callbacks.fire();
                }

                // On Start Swipe Right
                if (direction === 2 && (x < (-1 * parent.innerWidth() / 2) || velocityX > 0.75)) {
                    callbacks.add(onStartRight);
                    callbacks.fire();
                }
            }
        }).bind('pan', function(e) {
            if (e.gesture.pointerType === "touch") {
                var parent = $(this);
                var direction = e.gesture.direction;
                var x = e.gesture.deltaX;
                var velocityX = e.gesture.velocityX;

                parent.velocity({ translateX: x
                }, {duration: 50, queue: false, easing: 'easeOutQuad'});

                // Swipe Left
                if (direction === 4 && (x > (parent.innerWidth() / 2) || velocityX < -0.75)) {
                    swipeLeftToRight = true;
                }

                // Swipe Right
                if (direction === 2 && (x < (-1 * parent.innerWidth() / 2) || velocityX > 0.75)) {
                    swipeRightToLeft = true;
                }
            }
        }).bind('panend', function(e) {
            // Reset if collection is moved back into original position
            if (Math.abs(e.gesture.deltaX) < ($(this).innerWidth() / 2)) {
                swipeRightToLeft = false;
                swipeLeftToRight = false;
            }

            if (e.gesture.pointerType === "touch") {
                var parent = $(this);
                if (swipeLeftToRight || swipeRightToLeft) {
                    var fullWidth;
                    if (swipeLeftToRight) {
                        fullWidth = parent.innerWidth();
                        callbacks.add(rightCallback);
                        callbacks.fire();
                    }
                    else {
                        fullWidth = -1 * parent.innerWidth();
                        callbacks.add(leftCallback);
                        callbacks.fire();
                    }

                    parent.velocity({ translateX: fullWidth,
                    }, {duration: 100, queue: false, easing: 'easeOutQuad', complete:
                        function() {
                            parent.css('border', 'none');
                            parent.velocity({ height: 0, padding: 0,
                            }, {duration: 200, queue: false, easing: 'easeOutQuad', complete:
                                function() {
                                    parent.remove();
                                }
                            });
                        }
                    });
                }
                else {
                    parent.velocity({ translateX: 0,
                    }, {duration: 100, queue: false, easing: 'easeOutQuad'});
                }
                swipeLeftToRight = false;
                swipeRightToLeft = false;
            }
        }).bind('panend', function(e) {
            if (e.gesture.pointerType === "touch") {
                var direction = e.gesture.direction;
                var x = e.gesture.deltaX;
                var velocityX = e.gesture.velocityX;
                // On Start Swipe Left
                if (direction === 4 && (x > (parent.innerWidth() / 2) || velocityX < -0.75)) {
                    callbacks.add(onEndLeft);
                    callbacks.fire();
                }

                // On Start Swipe Right
                if (direction === 2 && (x < (-1 * parent.innerWidth() / 2) || velocityX > 0.75)) {
                    callbacks.add(onEndRight);
                    callbacks.fire();
                }
            }
        });

    });
}