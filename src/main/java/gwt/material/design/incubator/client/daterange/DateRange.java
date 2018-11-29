package gwt.material.design.incubator.client.daterange;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.TextBox;
import gwt.material.design.addins.client.moment.resources.MomentClientBundle;
import gwt.material.design.addins.client.moment.resources.MomentClientDebugBundle;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.FieldTypeMixin;
import gwt.material.design.client.base.mixin.ReadOnlyMixin;
import gwt.material.design.client.base.mixin.StatusTextMixin;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.DateInput;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.daterange.events.*;
import gwt.material.design.incubator.client.daterange.js.*;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Date;

import static gwt.material.design.incubator.client.daterange.js.JsDateRange.$;


public class DateRange extends AbstractValueWidget<Date> implements HasDateRangeHandlers, HasFieldTypes,
        HasDateRangeOptions, HasIcon, HasReadOnly, HasPlaceholder {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectDebugJs(MomentClientDebugBundle.INSTANCE.momentDebugJs());
            MaterialDesignBase.injectDebugJs(DateRangeClientDebugBundle.INSTANCE.dateRangePickerDebugJs());
            MaterialDesignBase.injectCss(DateRangeClientDebugBundle.INSTANCE.dateRangePickerDebugCss());
            MaterialDesignBase.injectCss(DateRangeClientDebugBundle.INSTANCE.dateRangePickerOverrideDebugCss());
        } else {
            MaterialDesignBase.injectJs(MomentClientBundle.INSTANCE.momentJs());
            MaterialDesignBase.injectJs(DateRangeClientBundle.INSTANCE.dateRangePickerJs());
            MaterialDesignBase.injectCss(DateRangeClientBundle.INSTANCE.dateRangePickerCss());
            MaterialDesignBase.injectCss(DateRangeClientBundle.INSTANCE.dateRangePickerOverrideCss());
        }
    }

    private static final String DATE_RANGE_STYLENAME = "date-range-picker";
    private FieldTypeMixin<DateRange> fieldTypeMixin;
    private TextBox dateInput = new TextBox();
    private Label label = new Label();
    private MaterialLabel errorLabel = new MaterialLabel();
    private MaterialIcon icon = new MaterialIcon();
    private DateRangeOptions options = new DateRangeOptions();
    private StatusTextMixin<AbstractValueWidget, MaterialLabel> statusTextMixin;
    private ReadOnlyMixin<DateRange, TextBox> readOnlyMixin;

    public DateRange() {
        super(Document.get().createDivElement(), CssName.INPUT_FIELD, DATE_RANGE_STYLENAME);
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

        getInputElement().daterangepicker(options);

        //TODO: Change target to Date
        getInputElement().on(DateRangeEvents.OPEN, (e, param1) -> {
            OpenEvent.fire(this, this);
            return true;
        });

        //TODO: Change target to Date
        getInputElement().on(DateRangeEvents.CLOSE, (e, param1) -> {
            CloseEvent.fire(this, this);
            return true;
        });

        getInputElement().on(DateRangeEvents.CLOSE_CALENDAR, (e, param1) -> {
            MaterialToast.fireToast("Close Calendar");
            return true;
        });

        getInputElement().on(DateRangeEvents.OPEN_CALENDAR, (e, param1) -> {
            MaterialToast.fireToast("Open Calendar");
            return true;
        });

        getInputElement().on(DateRangeEvents.APPLY, (e, param1) -> {
            MaterialToast.fireToast("Apply");
            return true;
        });

        getInputElement().on(DateRangeEvents.CANCEL, (e, param1) -> {
            MaterialToast.fireToast("Cancel");
            return true;
        });
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    protected void unload() {
        getInputElement().off(DateRangeEvents.OPEN);
        getInputElement().off(DateRangeEvents.CLOSE);
        getInputElement().off(DateRangeEvents.CLOSE_CALENDAR);
        getInputElement().off(DateRangeEvents.OPEN_CALENDAR);
        getInputElement().off(DateRangeEvents.APPLY);
        getInputElement().off(DateRangeEvents.CANCEL);
    }

    public void reload() {
        unload();
        load();
    }

    public JsDateRange getInputElement() {
        return $(dateInput.getElement());
    }

    @Override
    public Date getStartDate() {
        return options.startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        options.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return options.endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        options.endDate = endDate;
    }

    @Override
    public Date getMinDate() {
        return options.minDate;
    }

    @Override
    public void setMinDate(Date minDate) {
        options.minDate = minDate;
    }

    @Override
    public Date getMaxDate() {
        return options.maxDate;
    }

    @Override
    public void setMaxDate(Date maxDate) {
        options.maxDate = maxDate;
    }

    @Override
    public Object getMaxSpan() {
        return options.maxSpan;
    }

    @Override
    public void setMaxSpan(Object maxSpan) {
        options.maxSpan = maxSpan;
    }

    @Override
    public boolean isShowDropdowns() {
        return options.showDropdowns;
    }

    @Override
    public void setShowDropdowns(boolean showDropdowns) {
        options.showDropdowns = showDropdowns;
    }

    @Override
    public int getMinYear() {
        return options.minYear;
    }

    @Override
    public void setMinYear(int minYear) {
        options.minYear = minYear;
    }

    @Override
    public int getMaxYear() {
        return options.maxYear;
    }

    @Override
    public void setMaxYear(int maxYear) {
        options.maxYear = maxYear;
    }

    @Override
    public boolean isShowWeekNumbers() {
        return options.showWeekNumbers;
    }

    @Override
    public void setShowWeekNumbers(boolean showWeekNumbers) {
        options.showWeekNumbers = showWeekNumbers;
    }

    @Override
    public boolean isShowISOWeekNumbers() {
        return options.showISOWeekNumbers;
    }

    @Override
    public void setShowISOWeekNumbers(boolean showISOWeekNumbers) {
        options.showISOWeekNumbers = showISOWeekNumbers;
    }

    @Override
    public boolean isTimePicker() {
        return options.timePicker;
    }

    @Override
    public void setTimePicker(boolean timePicker) {
        options.timePicker = timePicker;
    }

    @Override
    public int getTimePickerIncrement() {
        return options.timePickerIncrement;
    }

    @Override
    public void setTimePickerIncrement(int timePickerIncrement) {
        options.timePickerIncrement = timePickerIncrement;
    }

    @Override
    public boolean isTimePicker24Hour() {
        return options.timePicker24Hour;
    }

    @Override
    public void setTimePicker24Hour(boolean timePicker24Hour) {
        options.timePicker24Hour = timePicker24Hour;
    }

    @Override
    public boolean isTimePickerSeconds() {
        return options.timePickerSeconds;
    }

    @Override
    public void setTimePickerSeconds(boolean timePickerSeconds) {
        options.timePickerSeconds = timePickerSeconds;
    }

    @Override
    public Object getRanges() {
        return options.ranges;
    }

    @Override
    public void setRanges(Object ranges) {
        options.ranges = ranges;
    }

    @Override
    public boolean isShowCustomRangeLabel() {
        return options.showCustomRangeLabel;
    }

    @Override
    public void setShowCustomRangeLabel(boolean showCustomRangeLabel) {
        options.showCustomRangeLabel = showCustomRangeLabel;
    }

    @Override
    public boolean isAlwaysShowCalendars() {
        return options.alwaysShowCalendars;
    }

    @Override
    public void setAlwaysShowCalendars(boolean alwaysShowCalendars) {
        options.alwaysShowCalendars = alwaysShowCalendars;
    }

    @Override
    public DropdownAlignment getDropdownAlignment() {
        return options.opens != null ? DropdownAlignment.fromStyleName(options.opens) : null;
    }

    @Override
    public void setDropdownAlignment(DropdownAlignment alignment) {
        options.opens = alignment.getCssName();
    }

    @Override
    public DropdownPosition getDropdownPosition() {
        return options.drops != null ? DropdownPosition.fromStyleName(options.drops) : null;
    }

    @Override
    public void setDropdownPosition(DropdownPosition dropdownPosition) {
        options.drops = dropdownPosition.getCssName();
    }

    @Override
    public String getButtonClasses() {
        return options.buttonClasses;
    }

    @Override
    public void setButtonClasses(String buttonClasses) {
        options.buttonClasses = buttonClasses;
    }

    @Override
    public String getApplyButtonClasses() {
        return options.applyButtonClasses;
    }

    @Override
    public void setApplyButtonClasses(String applyButtonClasses) {
        options.applyButtonClasses = applyButtonClasses;
    }

    @Override
    public String getCancelButtonClasses() {
        return options.cancelButtonClasses;
    }

    @Override
    public void setCancelButtonClasses(String cancelButtonClasses) {
        options.cancelButtonClasses = cancelButtonClasses;
    }

    @Override
    public Object getLocale() {
        return options.locale;
    }

    @Override
    public void setLocale(Object locale) {
        options.locale = locale;
    }

    @Override
    public boolean isSingleDatePicker() {
        return options.singleDatePicker;
    }

    @Override
    public void setSingleDatePicker(boolean singleDatePicker) {
        options.singleDatePicker = singleDatePicker;
    }

    @Override
    public boolean isAutoApply() {
        return options.autoApply;
    }

    @Override
    public void setAutoApply(boolean autoApply) {
        options.autoApply = autoApply;
    }

    @Override
    public boolean isLinkedCalendars() {
        return options.linkedCalendars;
    }

    @Override
    public void setLinkedCalendars(boolean linkedCalendars) {
        options.linkedCalendars = linkedCalendars;
    }

    @Override
    public Functions.FuncRet1<Boolean> isInvalidDate() {
        return options.isInvalidDate;
    }

    @Override
    public void setInvalidDate(Functions.FuncRet1<Boolean> invalidDate) {
        options.isInvalidDate = invalidDate;
    }

    @Override
    public Functions.FuncRet1<Object> isCustomDate() {
        return options.isCustomDate;
    }

    @Override
    public void setCustomDate(Functions.FuncRet1<Object> customDate) {
        options.isCustomDate = customDate;
    }

    @Override
    public boolean isAutoUpdateInput() {
        return options.autoUpdateInput;
    }

    @Override
    public void setAutoUpdateInput(boolean autoUpdateInput) {
        options.autoUpdateInput = autoUpdateInput;
    }

    @Override
    public String getParentEl() {
        return options.parentEl;
    }

    @Override
    public void setParentEl(String parentEl) {
        options.parentEl = parentEl;
    }

    @Override
    public Date getValue() {
        Date date = null;
        if (getInputElement().val() != null) {
            date = (Date) getInputElement().val();
        }
        return date;
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
        label.setText(placeholder);
    }

    @Override
    public HandlerRegistration addOpenCalendarHandler(OpenCalendarEvent.OpenCalendarEventHandler handler) {
        return addHandler(handler, OpenCalendarEvent.getType());
    }

    @Override
    public HandlerRegistration addCloseCalendarHandler(CloseCalendarEvent.CloseCalendarEventHandler handler) {
        return addHandler(handler, CloseCalendarEvent.getType());
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
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    protected FieldTypeMixin<DateRange> getFieldTypeMixin() {
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

    protected ReadOnlyMixin<DateRange, TextBox> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, dateInput);
        }
        return readOnlyMixin;
    }
}
