/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.daterange;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.combobox.MaterialComboBoxDebugClientBundle;
import gwt.material.design.addins.client.combobox.js.JsComboBox;
import gwt.material.design.addins.client.combobox.js.JsComboBoxOptions;
import gwt.material.design.addins.client.moment.Moment;
import gwt.material.design.addins.client.moment.resources.MomentClientBundle;
import gwt.material.design.addins.client.moment.resources.MomentClientDebugBundle;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.base.mixin.*;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.events.RegexValidationEvent;
import gwt.material.design.client.js.Window;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.matcher.DateMonthMatcher;
import gwt.material.design.incubator.client.dark.IncubatorDarkThemeReloader;
import gwt.material.design.incubator.client.daterange.constants.DateRangeType;
import gwt.material.design.incubator.client.daterange.constants.DateRangeElementSelector;
import gwt.material.design.incubator.client.daterange.events.SelectionEvent;
import gwt.material.design.incubator.client.daterange.events.*;
import gwt.material.design.incubator.client.daterange.js.*;
import gwt.material.design.jquery.client.api.Functions;
import gwt.material.design.jquery.client.api.JQuery;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.Date;

import static gwt.material.design.incubator.client.daterange.js.JsDateRangePicker.$;

public class DateRangePicker extends AbstractValueWidget<Date[]> implements HasDateRangeHandlers, HasFieldTypes, HasType<DateRangeType>,
    HasDateRangeOptions, HasIcon, HasReadOnly, HasPlaceholder, HasNativeBrowserStyle, HasLabel, HasSingleValue<Date>, HasRegex {

    private static final String DATE_RANGE_STYLENAME = "date-range-picker";

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentDebugJs());
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentLocale());
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentJDateConverterDebugJs());
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentWithTimezone());
            MaterialDesignBase.injectDebugJs(DateRangeClientDebugBundle.INSTANCE.dateRangePickerDebugJs());
            MaterialDesignBase.injectCss(DateRangeClientDebugBundle.INSTANCE.dateRangePickerDebugCss());
            MaterialDesignBase.injectCss(DateRangeClientDebugBundle.INSTANCE.dateRangePickerOverrideDebugCss());
        } else {
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentJs());
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentWithLocale());
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentJDateConverterJs());
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentWithTimezone());
            MaterialDesignBase.injectJs(DateRangeClientBundle.INSTANCE.dateRangePickerJs());
            MaterialDesignBase.injectCss(DateRangeClientBundle.INSTANCE.dateRangePickerCss());
            MaterialDesignBase.injectCss(DateRangeClientBundle.INSTANCE.dateRangePickerOverrideCss());
        }
        MaterialDesignBase.injectDebugJs(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugJs());
        MaterialDesignBase.injectCss(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugCss());
    }

    private final ScrollHelper scrollHelper = new ScrollHelper();
    private final MaterialTextBox dateInput = new MaterialTextBox();
    private final Label label = new Label();
    private final MaterialLabel errorLabel = new MaterialLabel();
    private final MaterialIcon calendar = new MaterialIcon(IconType.CALENDAR_MONTH);
    private final MaterialIcon icon = new MaterialIcon();
    private final DateRangeOptions options = new DateRangeOptions();

    private boolean open;
    private double addedOffsetHeight = 480;
    private String mask;
    private Date startDate;
    private Date endDate;
    private Date[] value;
    private String predefinedLabel;

    private FieldTypeMixin<DateRangePicker> fieldTypeMixin;
    private StatusTextMixin<AbstractValueWidget, MaterialLabel> statusTextMixin;
    private ReadOnlyMixin<DateRangePicker, MaterialTextBox> readOnlyMixin;
    private NativeBrowserStyleMixin<DateRangePicker> nativeBrowserStyleMixin;
    private RegexMixin<MaterialTextBox> regexMixin;
    private ToggleStyleMixin<DateRangePicker> singleMixin;
    private CssTypeMixin<DateRangeType, DateRangePicker> typeMixin;

    public DateRangePicker() {
        super(Document.get().createDivElement(), CssName.INPUT_FIELD, DATE_RANGE_STYLENAME);

        calendar.addStyleName("calendar");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    protected void load() {
        add(dateInput);
        add(label);
        add(errorLabel);

        getInputElement().daterangepicker(options, (startDate, endDate, label) -> {
            this.predefinedLabel = label;
            setValue(new Date[]{new Date(startDate.toString()), new Date(endDate.toString())}, true);
        });

        getInputElement().on(DateRangeEvents.UPDATE_CALENDAR, (e, picker) -> {
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.NEXT, (e, picker) -> {
            NextCalendarEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.PREV, (e, picker) -> {
            PreviousCalendarEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.SELECT, (e, picker) -> {
            SelectionEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.OPEN, (e, picker) -> {
            if (Window.matchMedia(Resolution.ALL_MOBILE.asMediaQuery()) || Window.matchMedia(Resolution.TABLET.asMediaQuery())) {
                JQuery.$(dateInput.getElement()).blur();
            }
            OpenEvent.fire(this, picker);
            detectPosition();
            return true;
        });

        getInputElement().on(DateRangeEvents.CLOSE, (e, picker) -> {
            CloseEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.CLOSE_CALENDAR, (e, picker) -> {
            CloseCalendarEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.OPEN_CALENDAR, (e, picker) -> {
            OpenCalendarEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.APPLY, (e, picker) -> {
            ApplyEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.CANCEL, (e, picker) -> {
            CancelEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.TIME_CHANGED, (e, picker) -> {
            toggleTimePickerTypeAssist();
            return true;
        });

        addClickHandler(clickEvent -> {
           if (getType() == DateRangeType.LABEL) {
               open();
           }
        });

        add(calendar);
        getHandlerRegistry().registerHandler(Window.addResizeHandler(event -> detectPosition()));
        setId(DOM.createUniqueId());
        IncubatorDarkThemeReloader.get().reload(DateRangeDarkTheme.class);
    }


    protected void detectPosition() {
        if (!isInVerticalViewPort()) {
            getMethodProvider().setDrops(DropdownPosition.UP.getCssName());
        } else {
            getMethodProvider().setDrops(DropdownPosition.DOWN.getCssName());
        }
    }

    public boolean isInVerticalViewPort() {
        return scrollHelper.isInViewPort(getElement(), addedOffsetHeight);
    }

    protected void toggleTypeAssist() {
        if (options.showDropdowns) {
            toggleMonthYearTypeAssist();
        }
        toggleTimePickerTypeAssist();
    }

    protected void toggleMonthYearTypeAssist() {
        if (options.showDropdowns) {
            toggleTypeAssistSelector(DateRangeElementSelector.MONTH_SELECT, DateRangeElementSelector.YEAR_SELECT);
        }
    }

    protected void toggleTimePickerTypeAssist() {
        if (options.timePicker) {
            toggleTypeAssistSelector(DateRangeElementSelector.HOUR_SELECT, DateRangeElementSelector.MINUTE_SELECT, DateRangeElementSelector.AM_PM_SELECT);
            if (options.timePickerSeconds) {
                toggleTypeAssistSelector(DateRangeElementSelector.SECONDS_SELECT);
            }
        }
    }

    protected void toggleTypeAssistSelector(String... selectors) {
        for (String selector : selectors) {
            JsComboBox selectElement = JsComboBox.$(selector);
            if (!isNativeBrowserStyle()) {
                JQueryElement parent = JsComboBox.$(getElement());
                JsComboBoxOptions option = JsComboBoxOptions.create();
                if (selector.equals(DateRangeElementSelector.MONTH_SELECT)) {
                    option.matcher = DateMonthMatcher.getDefaultMonthMatcher();
                }
                option.dropdownParent = parent;
                selectElement.select2(option);
                selectElement.removeClass(CssName.BROWSER_DEFAULT);
            } else {
                selectElement.addClass(CssName.BROWSER_DEFAULT);
            }
        }
    }

    @Override
    protected void onUnload() {
        unload();

        super.onUnload();
    }

    protected void unload() {
        getInputElement().off(DateRangeEvents.OPEN);
        getInputElement().off(DateRangeEvents.CLOSE);
        getInputElement().off(DateRangeEvents.CLOSE_CALENDAR);
        getInputElement().off(DateRangeEvents.OPEN_CALENDAR);
        getInputElement().off(DateRangeEvents.APPLY);
        getInputElement().off(DateRangeEvents.CANCEL);
        getInputElement().off(DateRangeEvents.NEXT);
        getInputElement().off(DateRangeEvents.PREV);
        getInputElement().off(DateRangeEvents.UPDATE_CALENDAR);
    }

    public void reload() {
        unload();
        load();
    }

    public JsDateRangePicker getInputElement() {
        return $(dateInput.getValueBoxBase().getElement());
    }

    protected JsDateRangeMethod getMethodProvider() {
        return getInputElement().data("daterangepicker");
    }

    @Override
    public void open() {
        open(true);
    }

    public void open(boolean fireEvent) {
        getMethodProvider().show(fireEvent);
        open = true;
    }

    @Override
    public void close() {
        close(true);
    }

    @Override
    public void close(boolean fireEvent) {
        getMethodProvider().hide(fireEvent);
        open = false;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void remove() {
        getMethodProvider().remove();
    }

    @Override
    public void nextCalendar() {
        getMethodProvider().clickNext();
    }

    @Override
    public void previousCalendar() {
        getMethodProvider().clickPrev();
    }

    @Override
    public void setStartDate(Date startDate) {
        options.setStartDate(startDate);
    }

    @Override
    public void setEndDate(Date endDate) {
        options.setEndDate(endDate);
    }

    @Override
    public void setMinDate(Date minDate) {
        options.setMinDate(minDate);
    }

    @Override
    public void setMaxDate(Date maxDate) {
        options.setMaxDate(maxDate);
    }

    @Override
    public void setMaxSpan(Object maxSpan) {
        options.setMaxSpan(maxSpan);
    }

    @Override
    public void setShowDropdowns(boolean showDropdowns) {
        options.setShowDropdowns(showDropdowns);
    }

    @Override
    public void setMinYear(int minYear) {
        options.setMinYear(minYear);
    }

    @Override
    public void setMaxYear(int maxYear) {
        options.setMaxYear(maxYear);
    }

    @Override
    public void setShowWeekNumbers(boolean showWeekNumbers) {
        options.setShowWeekNumbers(showWeekNumbers);
    }

    @Override
    public void setShowISOWeekNumbers(boolean showISOWeekNumbers) {
        options.setShowISOWeekNumbers(showISOWeekNumbers);
    }

    @Override
    public void setTimePicker(boolean timePicker) {
        options.setTimePicker(timePicker);
    }

    @Override
    public void setTimePickerIncrement(int timePickerIncrement) {
        options.setTimePickerIncrement(timePickerIncrement);
    }

    @Override
    public void setTimePicker24Hour(boolean timePicker24Hour) {
        options.setTimePicker24Hour(timePicker24Hour);
    }

    @Override
    public void setTimePickerSeconds(boolean timePickerSeconds) {
        options.setTimePickerSeconds(timePickerSeconds);
    }

    @Override
    public void setRanges(Object ranges) {
        options.setRanges(ranges);
    }

    @Override
    public void setShowCustomRangeLabel(boolean showCustomRangeLabel) {
        options.setShowCustomRangeLabel(showCustomRangeLabel);
    }

    @Override
    public void setAlwaysShowCalendars(boolean alwaysShowCalendars) {
        options.setAlwaysShowCalendars(alwaysShowCalendars);
    }

    @Override
    public void setDropdownAlignment(DropdownAlignment alignment) {
        options.setOpens(alignment.getCssName());
    }

    @Override
    public void setDropdownPosition(DropdownPosition dropdownPosition) {
        options.setDrops(dropdownPosition.getCssName());
    }

    @Override
    public void setButtonClasses(String buttonClasses) {
        options.setButtonClasses(buttonClasses);
    }

    @Override
    public void setApplyButtonClasses(String applyButtonClasses) {
        options.setApplyButtonClasses(applyButtonClasses);
    }

    @Override
    public void setCancelButtonClasses(String cancelButtonClasses) {
        options.setCancelButtonClasses(cancelButtonClasses);
    }

    @Override
    public void setLocale(DateRangeLocale locale) {
        options.setLocale(locale);
    }

    @Override
    public void setSingleDatePicker(boolean singleDatePicker) {
        options.setSingleDatePicker(singleDatePicker);
        getSingleMixin().setOn(singleDatePicker);
    }

    @Override
    public void setAutoApply(boolean autoApply) {
        options.setAutoApply(autoApply);
    }

    @Override
    public void setLinkedCalendars(boolean linkedCalendars) {
        options.setLinkedCalendars(linkedCalendars);
    }

    @Override
    public void setInvalidDate(Functions.FuncRet1<Boolean> invalidDate) {
        options.setInvalidDate(invalidDate);
    }

    @Override
    public void setCustomDate(Functions.FuncRet1<Object> customDate) {
        options.setCustomDate(customDate);
    }

    @Override
    public void setAutoUpdateInput(boolean autoUpdateInput) {
        options.setAutoUpdateInput(autoUpdateInput);
    }

    @Override
    public void setParentEl(String parentEl) {
        options.setParentEl(parentEl);
    }

    @Override
    public void setValue(Date[] value, boolean fireEvents) {
        this.value = value;

        if (value != null) {
            if (value.length >= 1) {
                this.startDate = value[0];

                if (value.length >= 2) {
                    this.endDate = value[1];
                }
            }

            // If autoUpdateInput is false then we need to set the date input value manually
            if (!options.autoUpdateInput) {
                setDateInputValue(value[0], value[1]);
            }
        } else {
            clearInputValue();
        }

        super.setValue(value, fireEvents);
    }

    @Override
    public void setSingleValue(Date value) {
        setValue(new Date[]{value}, false);
    }

    @Override
    public void setSingleValue(Date value, boolean fireEvents) {
        setValue(new Date[]{value}, fireEvents);
    }

    @Override
    public Date getSingleValue() {
        if (getValue().length >= 1) {
            return getValue()[0];
        }
        return null;
    }

    /**
     * Call this if you have defined {@link DateRangePicker#setAutoUpdateInput(boolean)} to false.
     * This will be required in order to update the input date textfield manually.
     */
    public void setDateInputValue(Date creationDate, Date endDate) {
        if (dateInput != null && creationDate != null && endDate != null) {
            String betweenDelimiter = options != null && options.locale != null && options.locale.getToLabel() != null ? options.locale.getToLabel() : " - ";
            String creationDateFormatted = Moment.moment(creationDate.getTime()).format(getFormat());
            String endDateFormatted = Moment.moment(endDate.getTime()).format(getFormat());
            dateInput.setValue(getOptions().singleDatePicker ? creationDateFormatted :
                creationDateFormatted + " " + betweenDelimiter + " " + endDateFormatted);
        } else {
            clearInputValue();
        }
    }

    /**
     * Set the format of the date range picker
     *
     * @param format Java Date format using {@link java.text.SimpleDateFormat}.
     */
    public void setFormat(String format) {
        if (options.locale == null) {
            options.locale = new DateRangeLocale();
        }
        options.locale.setFormat(format);
    }

    /**
     * Set the format of the date range picker
     *
     * @param format Moment js native format
     */
    public void setMomentJsDateFormat(String format) {
        if (options.locale == null) {
            options.locale = new DateRangeLocale();
        }
        options.locale.setMomentJsDateFormat(format);
    }

    public String getFormat() {
        return options != null && options.locale != null && options.locale.getFormat() != null ? options.locale.getFormat() : "MM/dd/yyyy";
    }

    public void clearInputValue() {
        dateInput.setValue("");
    }

    @Override
    public Date[] getValue() {
        return value;
    }

    public MaterialTextBox getDateInput() {
        return dateInput;
    }

    public Label getLabelWidget() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label.setText(label);
    }

    @Override
    public String getLabel() {
        return label.getText();
    }

    public MaterialLabel getErrorLabel() {
        return errorLabel;
    }

    public DateRangeOptions getOptions() {
        return options;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    @Override
    public MaterialIcon getIcon() {
        return icon;
    }

    @Override
    public void setIconType(IconType iconType) {
        icon.setIconType(iconType);
        icon.setIconPrefix(true);
        errorLabel.setPaddingLeft(44);
        insert(icon, 0);
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
        return icon.getIconColor();
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
    public void setCustomIconType(String iconType) {
        icon.setCustomIconType(iconType);
    }

    @Override
    public String getCustomIconType() {
        return icon.getCustomIconType();
    }

    @Override
    public void setIconDisplay(IconDisplay iconDisplay) {
        icon.setIconDisplay(iconDisplay);
    }

    @Override
    public IconDisplay getIconDisplay() {
        return icon.getIconDisplay();
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
    public String getPlaceholder() {
        return label.getText();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        dateInput.setPlaceholder(placeholder);
    }

    @Override
    public double getAddedOffsetHeight() {
        return addedOffsetHeight;
    }

    @Override
    public void setAddedOffsetHeight(double addedOffsetHeight) {
        this.addedOffsetHeight = addedOffsetHeight;
    }

    @Override
    public void setNativeBrowserStyle(boolean nativeBrowserStyle) {
        getNativeBrowserStyleMixin().setNativeBrowserStyle(nativeBrowserStyle);
    }

    @Override
    public void setRegex(String regex) {
        getRegexMixin().setRegex(regex);
    }

    @Override
    public void setRegex(String regex, String replaceRegex) {
        getRegexMixin().setRegex(regex, replaceRegex);
    }

    @Override
    public String getRegex() {
        return getRegexMixin().getRegex();
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getPredefinedLabel() {
        return predefinedLabel;
    }

    @Override
    public DateRangeType getType() {
        return getTypeMixin().getType();
    }

    @Override
    public void setType(DateRangeType type) {
        getTypeMixin().setType(type);
        dateInput.setReadOnly(type == DateRangeType.LABEL);
    }

    @Override
    public void reset() {
        super.reset();

        setAutoUpdateInput(false);
        getDateInput().clear();
        reload();
    }

    @Override
    public boolean isNativeBrowserStyle() {
        return getNativeBrowserStyleMixin().isNativeBrowserStyle();
    }

    @Override
    public HandlerRegistration addOpenCalendarHandler(OpenCalendarEvent.OpenCalendarEventHandler handler) {
        return addHandler(handler, OpenCalendarEvent.getType());
    }

    @Override
    public HandlerRegistration addPreviousCalendarHandler(PreviousCalendarEvent.PreviousCalendarEventHandler handler) {
        return addHandler(handler, PreviousCalendarEvent.getType());
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionEvent.SelectionEventHandler handler) {
        return addHandler(handler, SelectionEvent.getType());
    }

    @Override
    public HandlerRegistration addCloseCalendarHandler(CloseCalendarEvent.CloseCalendarEventHandler handler) {
        return addHandler(handler, CloseCalendarEvent.getType());
    }

    @Override
    public HandlerRegistration addNextCalendarHandler(NextCalendarEvent.NextCalendarEventHandler handler) {
        return addHandler(handler, NextCalendarEvent.getType());
    }

    @Override
    public HandlerRegistration addApplyHandler(ApplyEvent.ApplyEventHandler handler) {
        return addHandler(handler, ApplyEvent.getType());
    }

    @Override
    public HandlerRegistration addCancelHandler(CancelEvent.CancelEventHandler handler) {
        return addHandler(handler, CancelEvent.getType());
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler handler) {
        return addHandler(handler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler handler) {
        return addHandler(handler, OpenEvent.getType());
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date[]> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public HandlerRegistration addRegexValidationHandler(RegexValidationEvent.RegexValidationHandler handler) {
        return addHandler(handler, RegexValidationEvent.getType());
    }

    protected FieldTypeMixin<DateRangePicker> getFieldTypeMixin() {
        if (fieldTypeMixin == null) {
            fieldTypeMixin = new FieldTypeMixin<>(this);
        }
        return fieldTypeMixin;
    }

    @Override
    public StatusTextMixin<AbstractValueWidget, MaterialLabel> getStatusTextMixin() {
        if (statusTextMixin == null) {
            statusTextMixin = new StatusTextMixin<>(this, errorLabel, dateInput);
        }
        return statusTextMixin;
    }

    protected ReadOnlyMixin<DateRangePicker, MaterialTextBox> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, dateInput);
        }
        return readOnlyMixin;
    }

    protected NativeBrowserStyleMixin<DateRangePicker> getNativeBrowserStyleMixin() {
        if (nativeBrowserStyleMixin == null) {
            nativeBrowserStyleMixin = new NativeBrowserStyleMixin<>(this);
        }
        return nativeBrowserStyleMixin;
    }

    public ToggleStyleMixin<DateRangePicker> getSingleMixin() {
        if (singleMixin == null) {
            singleMixin = new ToggleStyleMixin<>(this, "single");
        }
        return singleMixin;
    }

    protected RegexMixin<MaterialTextBox> getRegexMixin() {
        if (regexMixin == null) {
            regexMixin = new RegexMixin<>(dateInput);
        }
        return regexMixin;
    }

    public CssTypeMixin<DateRangeType, DateRangePicker> getTypeMixin() {
        if (typeMixin == null) {
            typeMixin = new CssTypeMixin<>(this);
        }
        return typeMixin;
    }
}
