$.fn.bubble = function (options){

    var position = options.position,
        color = options.color;
    triangle = $(this).find('.triangle');

    if(position === 'left'){
        triangle.css('borderRightColor', color);
    }else if(position === 'right'){
        triangle.css('borderLeftColor', color);
    }else if(position === 'top'){
        triangle.css('borderBottomColor', color);
    }else if(position === 'bottom'){
        triangle.css('borderTopColor', color);
    }
};