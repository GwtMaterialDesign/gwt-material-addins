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

    /**
     * Properties
     */
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
    private boolean syncInstanceInputs;

    @JsProperty
    private boolean physicalKeyboardHighlight;

    @JsProperty
    private String physicalKeyboardHighlightTextColor;

    @JsProperty
    private String physicalKeyboardHighlightBgColor;

    @JsProperty
    private KeyboardButtonTheme buttonTheme;

    /**
     * Events
     */

    @JsProperty
    public Functions.Func1<String> onChange;

    @JsProperty
    public Functions.Func1<String> onKeyPress;

    @JsProperty
    public Functions.Func onRender;

    @JsProperty
    public Functions.Func beforeFirstRender;

    @JsProperty
    public Functions.Func beforeRender;

    @JsProperty
    public Functions.Func onInit;

    @JsProperty
    public Functions.Func1<String> onChangeAll;

    @JsOverlay
    public final KeyboardLayout getLayout() {
        return layout;
    }

    @JsOverlay
    public final void setLayout(KeyboardLayout layout) {
        this.layout = layout;
    }

    @JsOverlay
    public final String getLayoutName() {
        return layoutName;
    }

    @JsOverlay
    public final void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    @JsOverlay
    public final Object getDisplay() {
        return display;
    }

    @JsOverlay
    public final void setDisplay(Object display) {
        this.display = display;
    }

    @JsOverlay
    public final boolean isMergeDisplay() {
        return mergeDisplay;
    }

    @JsOverlay
    public final void setMergeDisplay(boolean mergeDisplay) {
        this.mergeDisplay = mergeDisplay;
    }

    @JsOverlay
    public final String getTheme() {
        return theme;
    }

    @JsOverlay
    public final void setTheme(String theme) {
        this.theme = theme;
    }

    @JsOverlay
    public final boolean isDebug() {
        return debug;
    }

    @JsOverlay
    public final void setDebug(boolean debug) {
        this.debug = debug;
    }

    @JsOverlay
    public final boolean isUseMouseEvents() {
        return useMouseEvents;
    }

    @JsOverlay
    public final void setUseMouseEvents(boolean useMouseEvents) {
        this.useMouseEvents = useMouseEvents;
    }

    @JsOverlay
    public final boolean isUseTouchEvents() {
        return useTouchEvents;
    }

    @JsOverlay
    public final void setUseTouchEvents(boolean useTouchEvents) {
        this.useTouchEvents = useTouchEvents;
    }

    @JsOverlay
    public final boolean isAutoUseTouchEvents() {
        return autoUseTouchEvents;
    }

    @JsOverlay
    public final void setAutoUseTouchEvents(boolean autoUseTouchEvents) {
        this.autoUseTouchEvents = autoUseTouchEvents;
    }

    @JsOverlay
    public final boolean isPreventMouseDownDefault() {
        return preventMouseDownDefault;
    }

    @JsOverlay
    public final void setPreventMouseDownDefault(boolean preventMouseDownDefault) {
        this.preventMouseDownDefault = preventMouseDownDefault;
    }

    @JsOverlay
    public final boolean isStopMouseDownPropagation() {
        return stopMouseDownPropagation;
    }

    @JsOverlay
    public final void setStopMouseDownPropagation(boolean stopMouseDownPropagation) {
        this.stopMouseDownPropagation = stopMouseDownPropagation;
    }

    @JsOverlay
    public final boolean isDisableCaretPositioning() {
        return disableCaretPositioning;
    }

    @JsOverlay
    public final void setDisableCaretPositioning(boolean disableCaretPositioning) {
        this.disableCaretPositioning = disableCaretPositioning;
    }

    @JsOverlay
    public final boolean isUseButtonTag() {
        return useButtonTag;
    }

    @JsOverlay
    public final void setUseButtonTag(boolean useButtonTag) {
        this.useButtonTag = useButtonTag;
    }

    @JsOverlay
    public final boolean isNewLineOnEnter() {
        return newLineOnEnter;
    }

    @JsOverlay
    public final void setNewLineOnEnter(boolean newLineOnEnter) {
        this.newLineOnEnter = newLineOnEnter;
    }

    @JsOverlay
    public final boolean isTabCharOnTab() {
        return tabCharOnTab;
    }

    @JsOverlay
    public final void setTabCharOnTab(boolean tabCharOnTab) {
        this.tabCharOnTab = tabCharOnTab;
    }

    @JsOverlay
    public final String getInputName() {
        return inputName;
    }

    @JsOverlay
    public final void setInputName(String inputName) {
        this.inputName = inputName;
    }

    @JsOverlay
    public final int getMaxLength() {
        return maxLength;
    }

    @JsOverlay
    public final void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @JsOverlay
    public final String getInputPattern() {
        return inputPattern;
    }

    @JsOverlay
    public final void setInputPattern(String inputPattern) {
        this.inputPattern = inputPattern;
    }

    @JsOverlay
    public final boolean isDisableRowButtonContainers() {
        return disableRowButtonContainers;
    }

    @JsOverlay
    public final void setDisableRowButtonContainers(boolean disableRowButtonContainers) {
        this.disableRowButtonContainers = disableRowButtonContainers;
    }

    @JsOverlay
    public final boolean isSyncInstanceInputs() {
        return syncInstanceInputs;
    }

    @JsOverlay
    public final void setSyncInstanceInputs(boolean syncInstanceInputs) {
        this.syncInstanceInputs = syncInstanceInputs;
    }

    @JsOverlay
    public final boolean isPhysicalKeyboardHighlight() {
        return physicalKeyboardHighlight;
    }

    @JsOverlay
    public final void setPhysicalKeyboardHighlight(boolean physicalKeyboardHighlight) {
        this.physicalKeyboardHighlight = physicalKeyboardHighlight;
    }

    @JsOverlay
    public final String getPhysicalKeyboardHighlightTextColor() {
        return physicalKeyboardHighlightTextColor;
    }

    @JsOverlay
    public final void setPhysicalKeyboardHighlightTextColor(String physicalKeyboardHighlightTextColor) {
        this.physicalKeyboardHighlightTextColor = physicalKeyboardHighlightTextColor;
    }

    @JsOverlay
    public final String getPhysicalKeyboardHighlightBgColor() {
        return physicalKeyboardHighlightBgColor;
    }

    @JsOverlay
    public final void setPhysicalKeyboardHighlightBgColor(String physicalKeyboardHighlightBgColor) {
        this.physicalKeyboardHighlightBgColor = physicalKeyboardHighlightBgColor;
    }

    @JsOverlay
    public final KeyboardButtonTheme getButtonTheme() {
        return buttonTheme;
    }

    @JsOverlay
    public final void setButtonTheme(KeyboardButtonTheme buttonTheme) {
        this.buttonTheme = buttonTheme;
    }
}
