/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.keyboard.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class KeyboardOptions {

    @JsProperty
    private KeyboardLayout layout;

    @JsProperty
    private String layoutName;

    @JsProperty
    private Object display;

    @JsProperty
    private boolean mergeDisplay;

    @JsProperty
    private String theme;

    @JsProperty
    private ButtonAttribute[] buttonAttributes;

    @JsProperty
    private KeyboardButtonTheme[] buttonTheme;

    @JsProperty
    private boolean debug;

    @JsProperty
    private boolean useMouseEvents;

    @JsProperty
    private boolean useTouchEvents;

    @JsProperty
    private boolean autoUseTouchEvents;

    @JsProperty
    private boolean preventMouseDownDefault;

    @JsProperty
    private boolean stopMouseDownPropagation;

    @JsProperty
    private boolean disableCaretPositioning;

    @JsProperty
    private boolean useButtonTag;

    @JsProperty
    private boolean newLineOnEnter;

    @JsProperty
    private boolean tabCharOnTab;

    @JsProperty
    private String inputName;

    @JsProperty
    private int maxLength;

    @JsProperty
    private String inputPattern;

    @JsProperty
    private boolean disableRowButtonContainers;

    @JsProperty
    private boolean disableButtonHold;

    @JsProperty
    private boolean syncInstanceInputs;

    @JsProperty
    private boolean physicalKeyboardHighlight;

    @JsProperty
    private String physicalKeyboardHighlightTextColor;

    @JsProperty
    private String physicalKeyboardHighlightBgColor;

    /**
     * Executes the callback function on input change. Returns the current input’s string.
     */
    @JsProperty
    public Functions.Func1<String> onChange;

    /**
     * Executes the callback function on key press. Returns button layout name (i.e.: “{shift}”).
     */
    @JsProperty
    public Functions.Func1<String> onKeyPress;

    /**
     * Executes the callback function every time simple-keyboard is rendered (e.g: when you change layouts).
     */
    @JsProperty
    public Functions.Func onRender;

    /**
     * Executes the callback function before the first simple-keyboard render.
     */
    @JsProperty
    public Functions.Func beforeFirstRender;

    /**
     * Executes the callback function before a simple-keyboard render.
     */
    @JsProperty
    public Functions.Func beforeRender;

    /**
     * Executes the callback function once simple-keyboard is rendered for the first time (on initialization).
     */
    @JsProperty
    public Functions.Func onInit;

    /**
     * Executes the callback function once a simple-keyboard button is released (keyUp).
     */
    @JsProperty
    public Functions.Func1<String> onKeyReleased;

    /**
     * Executes the callback function on input change. Returns the input object with all defined inputs.
     * This is useful if you’re handling several inputs with simple-keyboard, as specified in the “Using several inputs” guide.
     */
    @JsProperty
    public Functions.Func1<KeyInput> onChangeAll;

    @JsOverlay
    public final KeyboardLayout getLayout() {
        return layout;
    }

    /**
     * Modify the keyboard layout
     */
    @JsOverlay
    public final void setLayout(KeyboardLayout layout) {
        this.layout = layout;
    }

    @JsOverlay
    public final String getLayoutName() {
        return layoutName;
    }

    /**
     * Specifies which layout should be used.
     */
    @JsOverlay
    public final void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    @JsOverlay
    public final Object getDisplay() {
        return display;
    }

    /**
     * Replaces layout buttons with a human-friendly name (e.g.: “backspace”).
     */
    @JsOverlay
    public final void setDisplay(Object display) {
        this.display = display;
    }

    @JsOverlay
    public final boolean isMergeDisplay() {
        return mergeDisplay;
    }

    /**
     * By default, when you set the display property, you replace the default one. This setting merges them instead.
     */
    @JsOverlay
    public final void setMergeDisplay(boolean mergeDisplay) {
        this.mergeDisplay = mergeDisplay;
    }

    @JsOverlay
    public final String getTheme() {
        return theme;
    }

    /**
     * A prop to add your own css classes to the keyboard wrapper. You can add multiple classes separated by a space.
     */
    @JsOverlay
    public final void setTheme(String theme) {
        this.theme = theme;
    }

    @JsOverlay
    public final ButtonAttribute[] getButtonAttributes() {
        return buttonAttributes;
    }

    /**
     * A prop to add your own attributes to one or several buttons.
     */
    @JsOverlay
    public final void setButtonAttributes(ButtonAttribute[] buttonAttributes) {
        this.buttonAttributes = buttonAttributes;
    }

    @JsOverlay
    public final KeyboardButtonTheme[] getButtonTheme() {
        return buttonTheme;
    }

    /**
     * A prop to add your own css classes to one or several buttons.
     *
     * To add or remove individual buttonTheme entries, check out the methods addButtonTheme and removeButtonTheme below.
     */
    @JsOverlay
    public final void setButtonTheme(KeyboardButtonTheme[] buttonTheme) {
        this.buttonTheme = buttonTheme;
    }

    @JsOverlay
    public final boolean isDebug() {
        return debug;
    }

    /**
     * Runs a console.log every time a key is pressed. Displays the buttons pressed and the current input.
     */
    @JsOverlay
    public final void setDebug(boolean debug) {
        this.debug = debug;
    }

    @JsOverlay
    public final boolean isUseMouseEvents() {
        return useMouseEvents;
    }

    /**
     * As of simple-keyboard 2.17.0, PointerEvents are used on browsers that support it. However, if you wish to fall back
     * to the previous mouse event logic, you can use this option.
     */
    @JsOverlay
    public final void setUseMouseEvents(boolean useMouseEvents) {
        this.useMouseEvents = useMouseEvents;
    }

    @JsOverlay
    public final boolean isUseTouchEvents() {
        return useTouchEvents;
    }

    /**
     * As of simple-keyboard 2.17.0, PointerEvents are used on browsers that support it. However, if you wish to only
     * support touch events, you can use this option.
     */
    @JsOverlay
    public final void setUseTouchEvents(boolean useTouchEvents) {
        this.useTouchEvents = useTouchEvents;
    }

    @JsOverlay
    public final boolean isAutoUseTouchEvents() {
        return autoUseTouchEvents;
    }

    /**
     * This enables the option useTouchEvents automatically on touch capable devices.
     */
    @JsOverlay
    public final void setAutoUseTouchEvents(boolean autoUseTouchEvents) {
        this.autoUseTouchEvents = autoUseTouchEvents;
    }

    @JsOverlay
    public final boolean isPreventMouseDownDefault() {
        return preventMouseDownDefault;
    }

    /**
     * Prevents loss of input focus from clicking simple-keyboard buttons
     */
    @JsOverlay
    public final void setPreventMouseDownDefault(boolean preventMouseDownDefault) {
        this.preventMouseDownDefault = preventMouseDownDefault;
    }

    @JsOverlay
    public final boolean isStopMouseDownPropagation() {
        return stopMouseDownPropagation;
    }

    /**
     * Stops pointer down events on simple-keyboard buttons from bubbling to parent elements.
     */
    @JsOverlay
    public final void setStopMouseDownPropagation(boolean stopMouseDownPropagation) {
        this.stopMouseDownPropagation = stopMouseDownPropagation;
    }

    @JsOverlay
    public final boolean isDisableCaretPositioning() {
        return disableCaretPositioning;
    }

    /**
     * Disables caret positioning, meaning that characters will always be added/removed at the end of the string.
     */
    @JsOverlay
    public final void setDisableCaretPositioning(boolean disableCaretPositioning) {
        this.disableCaretPositioning = disableCaretPositioning;
    }

    @JsOverlay
    public final boolean isUseButtonTag() {
        return useButtonTag;
    }

    /**
     * Render buttons as <button> elements instead of the default <div> elements.
     */
    @JsOverlay
    public final void setUseButtonTag(boolean useButtonTag) {
        this.useButtonTag = useButtonTag;
    }

    @JsOverlay
    public final boolean isNewLineOnEnter() {
        return newLineOnEnter;
    }

    /**
     * Specifies whether clicking the “ENTER” button will input a newline (\n) or not.
     */
    @JsOverlay
    public final void setNewLineOnEnter(boolean newLineOnEnter) {
        this.newLineOnEnter = newLineOnEnter;
    }

    @JsOverlay
    public final boolean isTabCharOnTab() {
        return tabCharOnTab;
    }

    /**
     * Specifies whether clicking the “TAB” button will input a tab character (\t) or not.
     */
    @JsOverlay
    public final void setTabCharOnTab(boolean tabCharOnTab) {
        this.tabCharOnTab = tabCharOnTab;
    }

    @JsOverlay
    public final String getInputName() {
        return inputName;
    }

    /**
     * Allows you to use a single simple-keyboard instance for several inputs.
     */
    @JsOverlay
    public final void setInputName(String inputName) {
        this.inputName = inputName;
    }

    @JsOverlay
    public final int getMaxLength() {
        return maxLength;
    }

    /**
     * Limits simple-keyboard’s input to a certain length. This should be used in addition to the input element’s maxlengthattribute.
     */
    @JsOverlay
    public final void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @JsOverlay
    public final String getInputPattern() {
        return inputPattern;
    }

    /**
     * Limits simple-keyboard’s input to a certain regular expression. This means that if a key doesn’t match the regex,
     * it will be ignored. If you’re looking for input validation instead, check the docs entry here.
     */
    @JsOverlay
    public final void setInputPattern(String inputPattern) {
        this.inputPattern = inputPattern;
    }

    @JsOverlay
    public final boolean isDisableRowButtonContainers() {
        return disableRowButtonContainers;
    }

    /**
     * When set to true, this option disables the button grouping functionality added in simple-keyboard 2.19.0.
     */
    @JsOverlay
    public final void setDisableRowButtonContainers(boolean disableRowButtonContainers) {
        this.disableRowButtonContainers = disableRowButtonContainers;
    }

    @JsOverlay
    public final boolean isDisableButtonHold() {
        return disableButtonHold;
    }

    /**
     * When set to true, this option disables the button hold action.
     */
    @JsOverlay
    public final void setDisableButtonHold(boolean disableButtonHold) {
        this.disableButtonHold = disableButtonHold;
    }

    @JsOverlay
    public final boolean isSyncInstanceInputs() {
        return syncInstanceInputs;
    }

    /**
     * When set to true, this option synchronizes the internal input of every simple-keyboard instance.
     */
    @JsOverlay
    public final void setSyncInstanceInputs(boolean syncInstanceInputs) {
        this.syncInstanceInputs = syncInstanceInputs;
    }

    @JsOverlay
    public final boolean isPhysicalKeyboardHighlight() {
        return physicalKeyboardHighlight;
    }

    /**
     * Enable highlighting of keys pressed on physical keyboard.
     * <br/><br/>
     * For functional keys such as shift, note that the key’s event.code is used. In that instance, pressing the left
     * key will result in the code ShiftLeft. Therefore, the key must be named {shiftleft}. Click here for some of keys
     * supported out of the box.
     * <br/><br/>
     * If in doubt, you can also set the debug option to true to see the key events.
     */
    @JsOverlay
    public final void setPhysicalKeyboardHighlight(boolean physicalKeyboardHighlight) {
        this.physicalKeyboardHighlight = physicalKeyboardHighlight;
    }

    @JsOverlay
    public final String getPhysicalKeyboardHighlightTextColor() {
        return physicalKeyboardHighlightTextColor;
    }

    /**
     * Define the text color that the physical keyboard highlighted key should have. Used when physicalKeyboardHighlight is set to true.
     */
    @JsOverlay
    public final void setPhysicalKeyboardHighlightTextColor(String physicalKeyboardHighlightTextColor) {
        this.physicalKeyboardHighlightTextColor = physicalKeyboardHighlightTextColor;
    }

    @JsOverlay
    public final String getPhysicalKeyboardHighlightBgColor() {
        return physicalKeyboardHighlightBgColor;
    }

    /**
     * Define the background color that the physical keyboard highlighted key should have. Used when
     * physicalKeyboardHighlightis set to true.
     */
    @JsOverlay
    public final void setPhysicalKeyboardHighlightBgColor(String physicalKeyboardHighlightBgColor) {
        this.physicalKeyboardHighlightBgColor = physicalKeyboardHighlightBgColor;
    }
}
