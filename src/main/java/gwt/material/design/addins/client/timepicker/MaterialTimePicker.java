/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
import gwt.material.design.client.base.mixin.*;
import gwt.material.design.client.constants.*;
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
 * @see <a href="https://github.com/weareoutman/clockpicker">ClockPicker 0.0.7</a>
 */
//@formatter:on
public class MaterialTimePicker extends AbstractValueWidget<Date> implements JsLoader, HasPlaceholder,
        HasCloseHandlers<Date>, HasOpenHandlers<Date>, HasIcon, HasReadOnly, HasFieldTypes {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerJsDebug());
            MaterialDesignBase.injectCss(MaterialTimePickerDebugClientBundle.INSTANCE.timepickerCssDebug());
        } else {
            MaterialDesignBase.injectJs(MaterialTimePickerClientBundle.INSTANCE.timepickerJs());
            MaterialDesignBase.injectCss(MaterialTimePickerClientBundle.INSTANCE.timepickerCss());
        }
    }

    private Date time;
    private String placeholder;
    private MaterialPanel container = new MaterialPanel();
    private MaterialInput timeInput = new MaterialInput();
    private MaterialLabel errorLabel = new MaterialLabel();
    private Label label = new Label();
    private MaterialIcon icon = new MaterialIcon();
    private JsTimePickerOptions options = new JsTimePickerOptions();

    private ToggleStyleMixin<MaterialInput> validMixin;
    private ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin;
    private ReadOnlyMixin<MaterialTimePicker, MaterialInput> readOnlyMixin;
    private EnabledMixin<MaterialWidget> enabledMixin;
    private FieldTypeMixin<MaterialTimePicker> fieldTypeMixin;

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
        super.onLoad();

        setUniqueId(DOM.createUniqueId());
        timeInput.setType(InputType.TEXT);
        container.add(label);
        container.add(timeInput);
        container.add(errorLabel);
        add(container);
        timeInput.getElement().setAttribute("type", "text");

        load();
    }

    @Override
    public void load() {
        options.beforeShow = this::beforeShow;
        options.afterShow = this::afterShow;
        options.afterHide = this::afterHide;

        $(timeInput.getElement()).lolliclock(options);
        $(timeInput.getElement()).blur();

        registerHandler(addOrientationChangeHandler(event -> {
            JsTimePicker.$(timeInput.getElement()).lolliclock("setOrientation", event.getOrientation().getCssName());
        }));
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        $(timeInput.getElement()).lolliclock("remove");
    }

    @Override
    public void reload() {
        unload();
        load();
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
        clearErrorOrSuccess();
        label.removeStyleName(CssName.ACTIVE);
        timeInput.removeStyleName(CssName.VALID);
        $(timeInput.getElement()).val("");
    }

    /**
     * Side effects:
     * <ul>
     * <li>Resets the time to <i>now<i></li>
     * <li>Clears errors/success message</li>
     * </ul>
     */
    public void reset() {
        clear();
        clearErrorOrSuccess();
    }

    public boolean isAutoClose() {
        return options.autoclose;
    }

    public void setAutoClose(boolean autoClose) {
        options.autoclose = autoClose;
    }

    /**
     * False (default) change to 24 hours system.
     *
     * @return <code>false</code> in case 12 hours mode is set;
     * <code>true</code> otherwise.
     */
    public boolean isHour24() {
        return options.hour24;
    }

    /**
     * Set the time to 24 hour mode.
     */
    public void setHour24(boolean hour24) {
        options.hour24 = hour24;
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
        label.setText(placeholder);
    }

    /**
     * Called after the lolliclock event <code>afterShow</code>.
     */
    protected void beforeShow() {
        timeInput.getElement().blur();

        // Add class 'valid' for visual feedback.
        getValidMixin().setOn(true);
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
                parsedDate = DateTimeFormat.getFormat(options.hour24 ? "HH:mm" : "hh:mm aa").parse(timeString);
            } catch (IllegalArgumentException e) {
                // Silently catch parse errors
            }
        }

        setValue(parsedDate, true);

        // Remove class 'valid' after hide.
        getValidMixin().setOn(false);

        CloseEvent.fire(this, this.time);
        fireEvent(new BlurEvent() {});
    }

    protected String getTime() {
        return $(timeInput.getElement()).val().toString();
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
        label.removeStyleName(CssName.ACTIVE);
        label.addStyleName(CssName.ACTIVE);
        $(timeInput.getElement()).val(DateTimeFormat.getFormat(options.hour24 ? "HH:mm" : "hh:mm aa").format(time));
        super.setValue(time, fireEvents);
    }

    public String getUniqueId() {
        return options.uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        options.uniqueId = uniqueId;
    }

    public String getCancelText() {
        return options.cancelText;
    }

    /**
     * Set the "Cancel" text located on TimePicker's action buttons
     */
    public void setCancelText(String cancelText) {
        options.cancelText = cancelText;

        if (isAttached()) {
            reload();
        }
    }

    public String getOkText() {
        return options.okText;
    }

    /**
     * Set the "Ok" text located on TimePicker's action buttons
     */
    public void setOkText(String okText) {
        options.okText = okText;

        if (isAttached()) {
            reload();
        }
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
    public Color getIconColor() {
        return getIcon().getIconColor();
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
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);

        getEnabledMixin().updateWaves(enabled, this);
    }

    @Override
    protected EnabledMixin<MaterialWidget> getEnabledMixin() {
        if (enabledMixin == null) {
            enabledMixin = new EnabledMixin<>(timeInput);
        }
        return enabledMixin;
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        if (errorMixin == null) {
            errorMixin = new ErrorMixin<>(this, errorLabel, timeInput, label);
        }
        return errorMixin;
    }

    protected ReadOnlyMixin<MaterialTimePicker, MaterialInput> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, timeInput);
        }
        return readOnlyMixin;
    }

    protected ToggleStyleMixin<MaterialInput> getValidMixin() {
        if (validMixin == null) {
            validMixin = new ToggleStyleMixin<>(timeInput, CssName.VALID);
        }
        return validMixin;
    }

    protected FieldTypeMixin<MaterialTimePicker> getFieldTypeMixin() {
        if (fieldTypeMixin == null) {
            fieldTypeMixin = new FieldTypeMixin<>(this);
        }
        return fieldTypeMixin;
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

    @Override
    public void setFieldType(FieldType type) {
        getFieldTypeMixin().setFieldType(type);
    }

    @Override
    public FieldType getFieldType() {
        return getFieldTypeMixin().getFieldType();
    }

    @Override
    public void setLabelWidth(double percentWidth) {
        getFieldTypeMixin().setLabelWidth(percentWidth);
    }

    @Override
    public void setFieldWidth(double percentWidth) {
        getFieldTypeMixin().setFieldWidth(percentWidth);
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

    public Label getLabel() {
        return label;
    }

    @Override
    public HandlerRegistration addCloseHandler(final CloseHandler<Date> handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(final OpenHandler<Date> handler) {
        return addHandler(handler, OpenEvent.getType());
    }
}