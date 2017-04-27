/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.addins.client.timepicker;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.timepicker.js.JsTimePicker;
import gwt.material.design.addins.client.timepicker.js.JsTimePickerOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.base.mixin.ReadOnlyMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.js.Window;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialInput;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.html.Label;

import java.util.Date;

import static gwt.material.design.addins.client.timepicker.js.JsTimePicker.$;

//@formatter:off

/**
 * Material Time Picker - provide a simple way to select a single value from a pre-determined set.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code <ma:timepicker.MaterialTimePicker placeholder="Time Arrival" />}
 * </pre>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#timepickers">Material Pickers</a>
 * @see <a href="https://material.io/guidelines/components/pickers.html#pickers-time-pickers">Material Design Specification</a>
 */
//@formatter:on
public class MaterialTimePicker extends AbstractValueWidget<Date> implements HasPlaceholder, HasOrientation,
        HasCloseHandlers<Date>, HasOpenHandlers<Date>, HasIcon, HasReadOnly {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerJsDebug());
            MaterialDesignBase.injectCss(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialTimePickerClientBundle.INSTANCE.timepickerJs());
            MaterialDesignBase.injectCss(MaterialTimePickerClientBundle.INSTANCE.timepickerCss());
        }
    }

    /**
     * Wraps the actual input.
     */
    private MaterialPanel container = new MaterialPanel();

    /**
     * The input element for the time picker.
     */
    private MaterialInput timeInput = new MaterialInput();

    /**
     * Label to display errors messages.
     */
    private MaterialLabel errorLabel = new MaterialLabel();

    /**
     * The current value held by the time picker.
     */
    private Date time;

    private Label placeholderLabel = new Label();

    private MaterialIcon icon = new MaterialIcon();

    private ToggleStyleMixin<MaterialInput> validMixin = new ToggleStyleMixin<>(this.timeInput, CssName.VALID);
    private final ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin = new ErrorMixin<>(this, errorLabel, timeInput, placeholderLabel);
    private ReadOnlyMixin<MaterialTimePicker, MaterialInput> readOnlyMixin;

    private String uniqueId;
    private String placeholder;
    private boolean autoClose;
    private boolean hour24;
    private boolean detectOrientation = false;
    private Orientation orientation = Orientation.PORTRAIT;

    protected HandlerRegistration orientationHandler;

    public MaterialTimePicker() {
        super(Document.get().createElement("div"), AddinsCssName.TIMEPICKER, CssName.INPUT_FIELD);
    }

    public MaterialTimePicker(String placeholder) {
        this();
        setPlaceholder(placeholder);
    }

    public MaterialTimePicker(String placeholder, Date value) {
        this(placeholder);
        setValue(value);
    }

    @Override
    protected void onLoad() {
        build();

        super.onLoad();
    }

    @Override
    protected void build() {
        uniqueId = DOM.createUniqueId();
        timeInput.setType(InputType.TEXT);
        readOnlyMixin = new ReadOnlyMixin<>(this, timeInput);
        container.add(placeholderLabel);
        container.add(timeInput);
        container.add(errorLabel);
        add(container);
        timeInput.getElement().setAttribute("type", "text");
        initialize();
    }

    @Override
    protected void initialize() {
        JsTimePickerOptions options = new JsTimePickerOptions();
        options.autoclose = isAutoClose();
        options.orientation = getOrientation().getCssName();
        options.hour24 = isHour24();
        options.uniqueId = getUniqueId();
        options.beforeShow = this::beforeShow;
        options.afterShow = this::afterShow;
        options.afterHide = this::afterHide;
        $(timeInput.getElement()).lolliclock(options);
        $(timeInput.getElement()).blur();
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        $(timeInput.getElement()).lolliclock("remove");
    }

    /**
     * Side effects:
     * <ul>
     * <li>Resets the time to <i>now<i></li>
     * <li>Clears errors/success message</li>
     * </ul>
     */
    public void reset() {
        setValue(new Date());
        clearErrorOrSuccess();
    }

    public boolean isAutoClose() {
        return this.autoClose;
    }

    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    /**
     * False (default) change to 24 hours system.
     *
     * @return <code>false</code> in case 12 hours mode is set;
     * <code>true</code> otherwise.
     */
    public boolean isHour24() {
        return this.hour24;
    }

    /**
     * Set the time to 24 hour mode.
     */
    public void setHour24(boolean hour24) {
        this.hour24 = hour24;
    }

    /**
     * @return The placeholder text.
     */
    @Override
    public String getPlaceholder() {
        return this.placeholder;
    }

    /**
     * @param placeholder The placeholder text to set.
     */
    @Override
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        placeholderLabel.setText(placeholder);
    }

    /**
     * @return The orientation.
     */
    @Override
    public Orientation getOrientation() {
        return this.orientation;
    }

    /**
     * @param orientation The orientation to set: Can be Horizontal or Vertical.
     */
    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        if(isInitialize()) {
            JsTimePicker.$(timeInput.getElement()).lolliclock("setOrientation", orientation.getCssName());
        } else {
            initialize();
        }
    }

    public void setDetectOrientation(boolean detectOrientation) {
        this.detectOrientation = detectOrientation;

        if(orientationHandler != null) {
            orientationHandler.removeHandler();
            orientationHandler = null;
        }

        if(detectOrientation) {
            orientationHandler = com.google.gwt.user.client.Window.addResizeHandler(resizeEvent -> {
                detectAndApplyOrientation();
            });
            detectAndApplyOrientation();
        }
    }

    public boolean isDetectOrientation() {
        return detectOrientation;
    }

    protected void detectAndApplyOrientation() {
        if (Window.matchMedia("(orientation: portrait)")) {
            setOrientation(Orientation.PORTRAIT);
        } else {
            setOrientation(Orientation.LANDSCAPE);
        }
    }

    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    protected void beforeShow() {
        timeInput.getElement().blur();

        // Add class 'valid' for visual feedback.
        validMixin.setOn(true);
    }

    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    protected void afterShow() {
        OpenEvent.fire(this, this.time);
        fireEvent(new FocusEvent() {});
    }

    /**
     * Called after the lolliclock event <code>afterHide</code>.
     */
    protected void afterHide() {
        String timeString = getTime();
        Date parsedDate = null;

        if (timeString != null && !timeString.equals("")) {
            try {
                parsedDate = DateTimeFormat.getFormat(this.hour24 ? "HH:mm" : "hh:mm aa").parse(timeString);
            } catch (IllegalArgumentException e) {
                // Silently catch parse errors
            }
        }

        setValue(parsedDate, true);

        // Remove class 'valid' after hide.
        validMixin.setOn(false);

        CloseEvent.fire(this, this.time);
        fireEvent(new BlurEvent() {});
    }

    protected String getTime() {
        return $(timeInput.getElement()).val().toString();
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.timeInput.setEnabled(enabled);
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<Date> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<Date> handler) {
        return addHandler(handler, OpenEvent.getType());
    }

    /**
     * Programmatically open the time picker component
     */
    public void open() {
        Scheduler.get().scheduleDeferred(() -> $(timeInput.getElement()).lolliclock("show"));
    }

    /**
     * Programmatically close the time picker component
     */
    public void close() {
        Scheduler.get().scheduleDeferred(() -> $(timeInput.getElement()).lolliclock("hide"));
    }

    @Override
    public void clear() {
        time = null;
        this.clearErrorOrSuccess();
        placeholderLabel.removeStyleName(CssName.ACTIVE);
        timeInput.removeStyleName(CssName.VALID);
        $(timeInput.getElement()).val("");
    }

    @Override
    public Date getValue() {
        return time;
    }

    @Override
    public void setValue(Date time, boolean fireEvents) {
        this.time = time;
        if (this.time == null) {
            return;
        }
        placeholderLabel.removeStyleName(CssName.ACTIVE);
        placeholderLabel.addStyleName(CssName.ACTIVE);
        $(timeInput.getElement()).val(DateTimeFormat.getFormat(hour24 ? "HH:mm" : "hh:mm aa").format(time));
        super.setValue(time, fireEvents);
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public MaterialIcon getIcon() {
        return icon;
    }

    @Override
    public void setIconType(IconType iconType) {
        icon.setIconType(iconType);
        icon.setIconPrefix(true);
        errorLabel.setPaddingLeft(44);
        container.insert(icon, 0);
    }

    @Override
    public void setIconPosition(IconPosition position) {
        icon.setIconPosition(position);
    }

    @Override
    public void setIconSize(IconSize size) {
        icon.setIconSize(size);
    }

    @Override
    public void setIconFontSize(double size, Style.Unit unit) {
        icon.setIconFontSize(size, unit);
    }

    @Override
    public void setIconColor(Color iconColor) {
        icon.setIconColor(iconColor);
    }

    @Override
    public void setIconPrefix(boolean prefix) {
        icon.setIconPrefix(prefix);
    }

    @Override
    public boolean isIconPrefix() {
        return icon.isIconPrefix();
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        return errorMixin;
    }

    public ReadOnlyMixin<MaterialTimePicker, MaterialInput> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, timeInput);
        }
        return readOnlyMixin;
    }

    @Override
    public void setReadOnly(boolean value) {
        getReadOnlyMixin().setReadOnly(value);
    }

    @Override
    public boolean isReadOnly() {
        return getReadOnlyMixin().isReadOnly();
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {
        getReadOnlyMixin().setToggleReadOnly(toggle);
    }

    @Override
    public boolean isToggleReadOnly() {
        return getReadOnlyMixin().isToggleReadOnly();
    }

    public MaterialInput getTimeInput() {
        return timeInput;
    }

    public MaterialPanel getContainer() {
        return container;
    }

    public MaterialLabel getErrorLabel() {
        return errorLabel;
    }

    public Label getPlaceholderLabel() {
        return placeholderLabel;
    }
}