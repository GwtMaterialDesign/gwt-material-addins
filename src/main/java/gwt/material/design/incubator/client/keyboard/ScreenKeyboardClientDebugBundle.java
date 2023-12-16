package gwt.material.design.incubator.client.keyboard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface ScreenKeyboardClientDebugBundle {
    ScreenKeyboardClientDebugBundle INSTANCE = GWT.create(ScreenKeyboardClientDebugBundle.class);

    @ClientBundle.Source("resources/css/screen-keyboard.css")
    TextResource screenKeyboardDebugCss();

    @ClientBundle.Source("resources/css/screen-keyboard-custom.css")
    TextResource screenKeyboardCustomDebugCss();

    @ClientBundle.Source("resources/css/screen-keyboard-dark.css")
    TextResource screenKeyboardDarkDebugCss();

    @ClientBundle.Source("resources/js/screen-keyboard.js")
    TextResource screenKeyboardDebugJs();
}
