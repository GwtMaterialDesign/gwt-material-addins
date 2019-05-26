package gwt.material.design.incubator.client.keyboard;

import gwt.material.design.incubator.client.keyboard.js.KeyboardLayout;

public class NumericScreenKeyboard extends ScreenKeyboard {

    public NumericScreenKeyboard() {
        super();
    }

    @Override
    protected void load() {
        super.load();

        KeyboardLayout layout = new KeyboardLayout();
        layout.defaultLayout = new String[]{"1 2 3", "4 5 6", "7 8 9", "{shift} 0 -", "{bksp}"};
        layout.shiftLayout = new String[]{"! / #", "$ % ^", "& * (", "{shift} ) +", "{bksp}"};
        options.setLayout(layout);
        options.setTheme("hg-theme-default hg-layout-numeric numeric-theme");
        updateOptions(options);
    }
}
