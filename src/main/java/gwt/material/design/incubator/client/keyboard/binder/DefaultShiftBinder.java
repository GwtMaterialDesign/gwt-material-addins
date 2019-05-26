package gwt.material.design.incubator.client.keyboard.binder;

import gwt.material.design.incubator.client.keyboard.ScreenKeyboard;
import gwt.material.design.incubator.client.keyboard.constants.KeyboardButton;
import gwt.material.design.incubator.client.keyboard.js.KeyboardOptions;

public class DefaultShiftBinder implements KeyBinder {

    @Override
    public void bind(ScreenKeyboard screenKeyboard, KeyboardButton button) {
        if (button != null && (button.equals(KeyboardButton.SHIFT) || button.equals(KeyboardButton.LOCK))) {
            String currentLayout = screenKeyboard.getOptions().getLayoutName();
            String shiftToggle = currentLayout.equals("default") ? "shift" : "default";
            KeyboardOptions options = screenKeyboard.getOptions();
            options.setLayoutName(shiftToggle);
            screenKeyboard.updateOptions(options);
        }
    }
}
