package gwt.material.design.incubator.client.daterange;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.TextBox;
import gwt.material.design.addins.client.combobox.MaterialComboBoxDebugClientBundle;
import gwt.material.design.addins.client.combobox.js.JsComboBox;
import gwt.material.design.addins.client.combobox.js.JsComboBoxOptions;
import gwt.material.design.addins.client.moment.Moment;
import gwt.material.design.addins.client.moment.resources.MomentClientBundle;
import gwt.material.design.addins.client.moment.resources.MomentClientDebugBundle;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.FieldTypeMixin;
import gwt.material.design.client.base.mixin.ReadOnlyMixin;
import gwt.material.design.client.base.mixin.StatusTextMixin;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.daterange.events.*;
import gwt.material.design.incubator.client.daterange.js.*;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Date;

import static gwt.material.design.incubator.client.daterange.js.JsDateRange.$;


public class DateRangePicker extends AbstractValueWidget<Date> implements HasDateRangeHandlers, HasFieldTypes,
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
        MaterialDesignBase.injectDebugJs(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugJs());
        MaterialDesignBase.injectCss(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugCss());
    }

    private static final String DATE_RANGE_STYLENAME = "date-range-picker";
    private FieldTypeMixin<DateRangePicker> fieldTypeMixin;
    private TextBox dateInput = new TextBox();
    private Label label = new Label();
    private MaterialLabel errorLabel = new MaterialLabel();
    private MaterialIcon icon = new MaterialIcon();
    private DateRangeOptions options = new DateRangeOptions();
    private StatusTextMixin<AbstractValueWidget, MaterialLabel> statusTextMixin;
    private ReadOnlyMixin<DateRangePicker, TextBox> readOnlyMixin;

    public DateRangePicker() {
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

        getInputElement().daterangepicker(options, (param1, param2, param3) -> {
            //TODO Change event
        });

        getInputElement().on(DateRangeEvents.UPDATE_CALENDAR, (e, picker) -> {
            //  OpenEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.NEXT, (e, picker) -> {
            //  OpenEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.PREV, (e, picker) -> {
            //  OpenEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.SELECT, (e, picker) -> {
            //  OpenEvent.fire(this, picker);
            toggleTypeAssist();
            return true;
        });

        getInputElement().on(DateRangeEvents.OPEN, (e, picker) -> {
            //  OpenEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.CLOSE, (e, picker) -> {
            // CloseEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.CLOSE_CALENDAR, (e, picker) -> {
            // CloseCalendarEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.OPEN_CALENDAR, (e, picker) -> {
            // OpenCalendarEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.APPLY, (e, picker) -> {
            // ApplyEvent.fire(this, picker);
            return true;
        });

        getInputElement().on(DateRangeEvents.CANCEL, (e, picker) -> {
            // CancelEvent.fire(this, picker);
            return true;
        });

        setId(DOM.createUniqueId());
    }

    protected void toggleTypeAssist() {
        if (isShowDropdowns()) {
            JsComboBox monthSelect = JsComboBox.$(".monthselect");
            JsComboBox yearSelect = JsComboBox.$(".yearselect");
            JsComboBoxOptions op = JsComboBoxOptions.create();
            op.dropdownParent = JsComboBox.$(getElement());
            monthSelect.select2(op);
            yearSelect.select2(op);
        }
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
        getInputElement().off(DateRangeEvents.NEXT);
        getInputElement().off(DateRangeEvents.PREV);
        getInputElement().off(DateRangeEvents.UPDATE_CALENDAR);
    }

    public void reload() {
        unload();
        load();
    }

    public JsDateRange getInputElement() {
        return $(dateInput.getElement());
    }

    @Override
    public Moment getStartDate() {
        return options.getStartDate();
    }

    @Override
    public void setStartDate(Moment startDate) {
        options.setStartDate(startDate);
    }

    @Override
    public Date getEndDate() {
        return options.getEndDate();
    }

    @Override
    public void setEndDate(Date endDate) {
        options.setEndDate(endDate);
    }

    @Override
    public Date getMinDate() {
        return options.getMinDate();
    }

    @Override
    public void setMinDate(Date minDate) {
        options.setMinDate(minDate);
    }

    @Override
    public Date getMaxDate() {
        return options.getMaxDate();
    }

    @Override
    public void setMaxDate(Date maxDate) {
        options.setMaxDate(maxDate);
    }

    @Override
    public Object getMaxSpan() {
        return options.getMaxSpan();
    }

    @Override
    public void setMaxSpan(Object maxSpan) {
        options.setMaxSpan(maxSpan);
    }

    @Override
    public boolean isShowDropdowns() {
        return options.isShowDropdowns();
    }

    @Override
    public void setShowDropdowns(boolean showDropdowns) {
        options.setShowDropdowns(showDropdowns);
    }

    @Override
    public int getMinYear() {
        return options.getMinYear();
    }

    @Override
    public void setMinYear(int minYear) {
        options.setMinYear(minYear);
    }

    @Override
    public int getMaxYear() {
        return options.getMaxYear();
    }

    @Override
    public void setMaxYear(int maxYear) {
        options.setMaxYear(maxYear);
    }

    @Override
    public boolean isShowWeekNumbers() {
        return options.isShowWeekNumbers();
    }

    @Override
    public void setShowWeekNumbers(boolean showWeekNumbers) {
        options.setShowWeekNumbers(showWeekNumbers);
    }

    @Override
    public boolean isShowISOWeekNumbers() {
        return options.isShowISOWeekNumbers();
    }

    @Override
    public void setShowISOWeekNumbers(boolean showISOWeekNumbers) {
        options.setShowISOWeekNumbers(showISOWeekNumbers);
    }

    @Override
    public boolean isTimePicker() {
        return options.isTimePicker();
    }

    @Override
    public void setTimePicker(boolean timePicker) {
        options.setTimePicker(timePicker);
    }

    @Override
    public int getTimePickerIncrement() {
        return options.getTimePickerIncrement();
    }

    @Override
    public void setTimePickerIncrement(int timePickerIncrement) {
        options.setTimePickerIncrement(timePickerIncrement);
    }

    @Override
    public boolean isTimePicker24Hour() {
        return options.isTimePicker24Hour();
    }

    @Override
    public void setTimePicker24Hour(boolean timePicker24Hour) {
        options.setTimePicker24Hour(timePicker24Hour);
    }

    @Override
    public boolean isTimePickerSeconds() {
        return options.isTimePickerSeconds();
    }

    @Override
    public void setTimePickerSeconds(boolean timePickerSeconds) {
        options.setTimePickerSeconds(timePickerSeconds);
    }

    @Override
    public Object getRanges() {
        return options.getRanges();
    }

    @Override
    public void setRanges(Object ranges) {
        options.setRanges(ranges);
    }

    @Override
    public boolean isShowCustomRangeLabel() {
        return options.isShowCustomRangeLabel();
    }

    @Override
    public void setShowCustomRangeLabel(boolean showCustomRangeLabel) {
        options.setShowCustomRangeLabel(showCustomRangeLabel);
    }

    @Override
    public boolean isAlwaysShowCalendars() {
        return options.isAlwaysShowCalendars();
    }

    @Override
    public void setAlwaysShowCalendars(boolean alwaysShowCalendars) {
        options.setAlwaysShowCalendars(alwaysShowCalendars);
    }

    @Override
    public DropdownAlignment getDropdownAlignment() {
        return options.getOpens() != null ? DropdownAlignment.fromStyleName(options.getOpens()) : null;
    }

    @Override
    public void setDropdownAlignment(DropdownAlignment alignment) {
        options.setOpens(alignment.getCssName());
    }

    @Override
    public DropdownPosition getDropdownPosition() {
        return options.getDrops() != null ? DropdownPosition.fromStyleName(options.getDrops()) : null;
    }

    @Override
    public void setDropdownPosition(DropdownPosition dropdownPosition) {
        options.setDrops(dropdownPosition.getCssName());
    }

    @Override
    public String getButtonClasses() {
        return options.getButtonClasses();
    }

    @Override
    public void setButtonClasses(String buttonClasses) {
        options.setButtonClasses(buttonClasses);
    }

    @Override
    public String getApplyButtonClasses() {
        return options.getApplyButtonClasses();
    }

    @Override
    public void setApplyButtonClasses(String applyButtonClasses) {
        options.setApplyButtonClasses(applyButtonClasses);
    }

    @Override
    public String getCancelButtonClasses() {
        return options.getCancelButtonClasses();
    }

    @Override
    public void setCancelButtonClasses(String cancelButtonClasses) {
        options.setCancelButtonClasses(cancelButtonClasses);
    }

    @Override
    public DateRangeLocale getLocale() {
        return options.getLocale() != null ? (DateRangeLocale) options.getLocale() : null;
    }

    @Override
    public void setLocale(DateRangeLocale locale) {
        options.setLocale(locale != null ? locale : false);
    }

    @Override
    public boolean isSingleDatePicker() {
        return options.isSingleDatePicker();
    }

    @Override
    public void setSingleDatePicker(boolean singleDatePicker) {
        options.setSingleDatePicker(singleDatePicker);
    }

    @Override
    public boolean isAutoApply() {
        return options.isAutoApply();
    }

    @Override
    public void setAutoApply(boolean autoApply) {
        options.setAutoApply(autoApply);
    }

    @Override
    public boolean isLinkedCalendars() {
        return options.isLinkedCalendars();
    }

    @Override
    public void setLinkedCalendars(boolean linkedCalendars) {
        options.setLinkedCalendars(linkedCalendars);
    }

    @Override
    public Functions.FuncRet1<Boolean> isInvalidDate() {
        return options.isInvalidDate();
    }

    @Override
    public void setInvalidDate(Functions.FuncRet1<Boolean> invalidDate) {
        options.setInvalidDate(invalidDate);
    }

    @Override
    public Functions.FuncRet1<Object> isCustomDate() {
        return options.isCustomDate();
    }

    @Override
    public void setCustomDate(Functions.FuncRet1<Object> customDate) {
        options.setCustomDate(customDate);
    }

    @Override
    public boolean isAutoUpdateInput() {
        return options.isAutoUpdateInput();
    }

    @Override
    public void setAutoUpdateInput(boolean autoUpdateInput) {
        options.setAutoUpdateInput(autoUpdateInput);
    }

    @Override
    public String getParentEl() {
        return options.getParentEl();
    }

    @Override
    public void setParentEl(String parentEl) {
        options.setParentEl(parentEl);
    }

    @Override
    public Date getValue() {
        /*Date date = null;
        if (getInputElement().val() != null) {
            date = (Date) getInputElement().val();
        }*/
        return null;
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

    protected ReadOnlyMixin<DateRangePicker, TextBox> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, dateInput);
        }
        return readOnlyMixin;
    }
}
