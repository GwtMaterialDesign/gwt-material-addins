package gwt.material.design.incubator.client.keyboard;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.keyboard.binder.DefaultShiftBinder;
import gwt.material.design.incubator.client.keyboard.binder.KeyBinder;
import gwt.material.design.incubator.client.keyboard.constants.KeyboardButton;
import gwt.material.design.incubator.client.keyboard.events.*;
import gwt.material.design.incubator.client.keyboard.js.Keyboard;
import gwt.material.design.incubator.client.keyboard.js.KeyboardOptions;
import gwt.material.design.incubator.client.keyboard.js.SimpleKeyboard;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQuery;

/**
 * On Screen Keyboard support
 *
 * @author kevzlou7979
 * @see <a href="https://franciscohodge.com/projects/simple-keyboard/">Website</a>
 * @see <a href="https://franciscohodge.com/projects/simple-keyboard/documentation/">Documentation</a>
 * @see <a href="https://franciscohodge.com/projects/simple-keyboard/demos/">Demos</a>
 */
public class ScreenKeyboard extends MaterialWidget implements HasScreenKeyboardHandlers {

    static {
        MaterialDesign.injectCss(ScreenKeyboardClientBundle.INSTANCE.screenKeyboardCss());
        MaterialDesign.injectCss(ScreenKeyboardClientBundle.INSTANCE.screenKeyboardCustomCss());
        MaterialDesign.injectDebugJs(ScreenKeyboardClientBundle.INSTANCE.screenKeyboardJs());
    }

    private static final String KEYBOARD_PROPERTY = "Keyboard";
    private static final String SIMPLE_KEYBOARD_PROPERTY = "SimpleKeyboard";
    protected Keyboard keyboard;
    protected KeyboardOptions options = new KeyboardOptions();
    protected KeyBinder shiftBinding = new DefaultShiftBinder();

    public ScreenKeyboard() {
        super(Document.get().createDivElement(), "simple-keyboard");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    protected void load() {
        // Initial SimpleKeyboard Defaults
        SimpleKeyboard simpleKeyboard = (SimpleKeyboard)    JQuery.window().getPropertyObject(SIMPLE_KEYBOARD_PROPERTY);
        JQuery.window().setPropertyObject(KEYBOARD_PROPERTY, simpleKeyboard._default);

        if (options != null) {
            // Setup events
            options.beforeFirstRender = () -> BeforeFirstRenderEvent.fire(this);
            options.beforeRender = () -> BeforeRenderEvent.fire(this);
            options.onRender = () -> RenderEvent.fire(this);
            options.onInit = () -> InitEvent.fire(this);
            options.onKeyPress = button -> {
                KeyboardButton keyboardButton = null;
                if (button != null) {
                    keyboardButton = KeyboardButton.get(button);
                    shiftBinding.bind(this, keyboardButton);
                }
                KeyPressEvent.fire(this, keyboardButton);
            };
            options.onChange = input -> ChangeEvent.fire(this, input);
            options.onChangeAll = input -> ChangeAllEvent.fire(this, input);

            // Construct Keyboard with required options
            keyboard = new Keyboard(options);
        }
    }

    /**
     * Clear the keyboard’s input.
     */
    public void clearInput() {
        getKeyboard().clearInput();
    }

    /**
     * Clear the keyboard’s specific input
     * Must have been previously set using the "inputName" prop.
     */
    public void clearInput(String inputName) {
        getKeyboard().clearInput(inputName);
    }

    /**
     * Get the keyboard’s input (You can also get it from the onChange prop).
     */
    public String getInput() {
        return getKeyboard().getInput();
    }

    /**
     * Get the keyboard’s input (You can also get it from the onChange prop).
     * Must have been previously set using the "inputName" prop.
     */
    public String getInput(String inputName) {
        return getKeyboard().getInput(inputName);
    }

    /**
     * Set the keyboard’s input. Useful if you want to track input changes made outside simple-keyboard.
     */
    public void setInput(String input) {
        getKeyboard().setInput(input);
    }

    /**
     * Set the keyboard’s input. Useful if you want to track input changes made outside simple-keyboard.
     * Must have been previously set using the "inputName" prop.
     */
    public void setInput(String input, String inputName) {
        getKeyboard().setInput(input, inputName);
    }

    /**
     * Replaces the entire internal input object. The difference with “setInput” is that “setInput” only changes a
     * single key of the input object, while “replaceInput” replaces the full input object.
     */
    public void replaceInput(Object object) {
        getKeyboard().replaceInput(object);
    }

    /**
     * Set new option or modify existing ones after initialization. The changes are applied immediately.
     */
    public void updateOptions(KeyboardOptions options) {
        getKeyboard().setOptions(options);
    }

    /**
     * Send a command to all simple-keyboard instances at once (if you have multiple instances).
     */
    public void dispatch(Functions.Func1<Object> method) {
        getKeyboard().dispatch(method);
    }

    /**
     * Get the DOM Element of a button. If there are several buttons with the same name, an array of the DOM Elements
     * is returned.
     */
    public Object getButtonElement(String buttonName) {
        return getKeyboard().getButtonElement(buttonName);
    }

    /**
     * Adds an entry to the buttonTheme. Basically a way to add a class to a button.
     */
    public void addButtonTheme(String buttons, String classNames) {
        getKeyboard().addButtonTheme(buttons, classNames);
    }

    /**
     * Removes an entry to the buttonTheme. Basically a way to remove a class previously added to a button through
     * buttonTheme or addButtonTheme.
     *
     * @param clasNames
     */
    public void removeButtonTheme(String buttons, String clasNames) {
        getKeyboard().removeButtonTheme(buttons, clasNames);
    }

    public KeyboardOptions getOptions() {
        return options;
    }

    public void setOptions(KeyboardOptions options) {
        this.options = options;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public KeyBinder getShiftBinding() {
        return shiftBinding;
    }

    /**
     * Set the default shift binding registration.
     * @see DefaultShiftBinder
     */
    public void setShiftBinding(KeyBinder shiftBinding) {
        this.shiftBinding = shiftBinding;
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressEvent.KeyPressHandler handler) {
        return addHandler(handler, KeyPressEvent.getType());
    }

    @Override
    public HandlerRegistration addChangeHandler(ChangeEvent.ChangeHandler handler) {
        return addHandler(handler, ChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addChangeAllHandler(ChangeAllEvent.ChangeAllHandler handler) {
        return addHandler(handler, ChangeAllEvent.getType());
    }

    @Override
    public HandlerRegistration addBeforeFirstRenderHandler(BeforeFirstRenderEvent.BeforeFirstRenderHandler handler) {
        return addHandler(handler, BeforeFirstRenderEvent.getType());
    }

    @Override
    public HandlerRegistration addRenderHandler(RenderEvent.RenderHandler handler) {
        return addHandler(handler, RenderEvent.getType());
    }

    @Override
    public HandlerRegistration addInitHandler(InitEvent.InitHandler handler) {
        return addHandler(handler, InitEvent.getType());
    }
}
