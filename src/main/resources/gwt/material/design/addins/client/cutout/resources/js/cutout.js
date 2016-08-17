function setupCutOutPosition(cutOut, relativeTo, padding, circle) {
    var rect = relativeTo.getBoundingClientRect();

    var top = rect.top;
    var left = rect.left;
    var width = rect.right - rect.left;
    var height = rect.bottom - rect.top;

    if (circle) {
        if (width != height) {
            var dif = width - height;
            if (width > height) {
                height += dif;
                top -= dif / 2;
            }
            else {
                dif = -dif;
                width += dif;
                left -= dif / 2;
            }
        }
    }

    top -= padding;
    left -= padding;
    width += padding * 2;
    height += padding * 2;

    cutOut.style.top = top + 'px';
    cutOut.style.left = left + 'px';
    cutOut.style.width = width + 'px';
    cutOut.style.height = height + 'px';
}