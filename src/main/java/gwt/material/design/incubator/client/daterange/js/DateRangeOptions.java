package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.addins.client.moment.Moment;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DateRangeOptions {

    @JsProperty
    private Moment startDate;

    @JsProperty
    private Date endDate;

    @JsProperty
    private Date minDate;

    @JsProperty
    private Date maxDate;

    @JsProperty
    private Object maxSpan;

    @JsProperty
    private boolean showDropdowns;

    @JsProperty
    private int minYear;

    @JsProperty
    private int maxYear;

    @JsProperty
    private boolean showWeekNumbers;

    @JsProperty
    private boolean showISOWeekNumbers;

    @JsProperty
    private boolean timePicker;

    @JsProperty
    private int timePickerIncrement;

    @JsProperty
    private boolean timePicker24Hour;

    @JsProperty
    private boolean timePickerSeconds;

    @JsProperty
    private Object ranges;

    @JsProperty
    private boolean showCustomRangeLabel;

    @JsProperty
    private boolean alwaysShowCalendars;

    /**
     * @see DropdownAlignment
     */
    @JsProperty
    private String opens;

    @JsProperty
    private String drops;

    @JsProperty
    private String buttonClasses;

    @JsProperty
    private String applyButtonClasses;

    @JsProperty
    private String cancelButtonClasses;

    @JsProperty
    private Object locale;

    @JsProperty
    private boolean singleDatePicker;

    @JsProperty
    private boolean autoApply;

    @JsProperty
    private boolean linkedCalendars;

    @JsProperty
    private Functions.FuncRet1<Boolean> isInvalidDate;

    @JsProperty
    private Functions.FuncRet1<Object> isCustomDate;

    @JsProperty
    private boolean autoUpdateInput;

    @JsProperty
    private String parentEl;

    @JsOverlay
    public final Moment getStartDate() {
        return startDate;
    }

    @JsOverlay
    public final void setStartDate(Moment startDate) {
        this.startDate = startDate;
    }

    @JsOverlay
    public final Date getEndDate() {
        return endDate;
    }

    @JsOverlay
    public final void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsOverlay
    public final Date getMinDate() {
        return minDate;
    }

    @JsOverlay
    public final void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    @JsOverlay
    public final Date getMaxDate() {
        return maxDate;
    }

    @JsOverlay
    public final void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    @JsOverlay
    public final Object getMaxSpan() {
        return maxSpan;
    }

    @JsOverlay
    public final void setMaxSpan(Object maxSpan) {
        this.maxSpan = maxSpan;
    }

    @JsOverlay
    public final boolean isShowDropdowns() {
        return showDropdowns;
    }

    @JsOverlay
    public final void setShowDropdowns(boolean showDropdowns) {
        this.showDropdowns = showDropdowns;
    }

    @JsOverlay
    public final int getMinYear() {
        return minYear;
    }

    @JsOverlay
    public final void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    @JsOverlay
    public final int getMaxYear() {
        return maxYear;
    }

    @JsOverlay
    public final void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    @JsOverlay
    public final boolean isShowWeekNumbers() {
        return showWeekNumbers;
    }

    @JsOverlay
    public final void setShowWeekNumbers(boolean showWeekNumbers) {
        this.showWeekNumbers = showWeekNumbers;
    }

    @JsOverlay
    public final boolean isShowISOWeekNumbers() {
        return showISOWeekNumbers;
    }

    @JsOverlay
    public final void setShowISOWeekNumbers(boolean showISOWeekNumbers) {
        this.showISOWeekNumbers = showISOWeekNumbers;
    }

    @JsOverlay
    public final boolean isTimePicker() {
        return timePicker;
    }

    @JsOverlay
    public final void setTimePicker(boolean timePicker) {
        this.timePicker = timePicker;
    }

    @JsOverlay
    public final int getTimePickerIncrement() {
        return timePickerIncrement;
    }

    @JsOverlay
    public final void setTimePickerIncrement(int timePickerIncrement) {
        this.timePickerIncrement = timePickerIncrement;
    }

    @JsOverlay
    public final boolean isTimePicker24Hour() {
        return timePicker24Hour;
    }

    @JsOverlay
    public final void setTimePicker24Hour(boolean timePicker24Hour) {
        this.timePicker24Hour = timePicker24Hour;
    }

    @JsOverlay
    public final boolean isTimePickerSeconds() {
        return timePickerSeconds;
    }

    @JsOverlay
    public final void setTimePickerSeconds(boolean timePickerSeconds) {
        this.timePickerSeconds = timePickerSeconds;
    }

    @JsOverlay
    public final Object getRanges() {
        return ranges;
    }

    @JsOverlay
    public final void setRanges(Object ranges) {
        this.ranges = ranges;
    }

    @JsOverlay
    public final boolean isShowCustomRangeLabel() {
        return showCustomRangeLabel;
    }

    @JsOverlay
    public final void setShowCustomRangeLabel(boolean showCustomRangeLabel) {
        this.showCustomRangeLabel = showCustomRangeLabel;
    }

    @JsOverlay
    public final boolean isAlwaysShowCalendars() {
        return alwaysShowCalendars;
    }

    @JsOverlay
    public final void setAlwaysShowCalendars(boolean alwaysShowCalendars) {
        this.alwaysShowCalendars = alwaysShowCalendars;
    }

    @JsOverlay
    public final String getOpens() {
        return opens;
    }

    @JsOverlay
    public final void setOpens(String opens) {
        this.opens = opens;
    }

    @JsOverlay
    public final String getDrops() {
        return drops;
    }

    @JsOverlay
    public final void setDrops(String drops) {
        this.drops = drops;
    }

    @JsOverlay
    public final String getButtonClasses() {
        return buttonClasses;
    }

    @JsOverlay
    public final void setButtonClasses(String buttonClasses) {
        this.buttonClasses = buttonClasses;
    }

    @JsOverlay
    public final String getApplyButtonClasses() {
        return applyButtonClasses;
    }

    @JsOverlay
    public final void setApplyButtonClasses(String applyButtonClasses) {
        this.applyButtonClasses = applyButtonClasses;
    }

    @JsOverlay
    public final String getCancelButtonClasses() {
        return cancelButtonClasses;
    }

    @JsOverlay
    public final void setCancelButtonClasses(String cancelButtonClasses) {
        this.cancelButtonClasses = cancelButtonClasses;
    }

    @JsOverlay
    public final Object getLocale() {
        return locale;
    }

    @JsOverlay
    public final void setLocale(Object locale) {
        this.locale = locale;
    }

    @JsOverlay
    public final boolean isSingleDatePicker() {
        return singleDatePicker;
    }

    @JsOverlay
    public final void setSingleDatePicker(boolean singleDatePicker) {
        this.singleDatePicker = singleDatePicker;
    }

    @JsOverlay
    public final boolean isAutoApply() {
        return autoApply;
    }

    @JsOverlay
    public final void setAutoApply(boolean autoApply) {
        this.autoApply = autoApply;
    }

    @JsOverlay
    public final boolean isLinkedCalendars() {
        return linkedCalendars;
    }

    @JsOverlay
    public final void setLinkedCalendars(boolean linkedCalendars) {
        this.linkedCalendars = linkedCalendars;
    }

    @JsOverlay
    public final Functions.FuncRet1<Boolean> isInvalidDate() {
        return isInvalidDate;
    }

    @JsOverlay
    public final void setInvalidDate(Functions.FuncRet1<Boolean> isInvalidDate) {
        this.isInvalidDate = isInvalidDate;
    }

    @JsOverlay
    public final Functions.FuncRet1<Object> isCustomDate() {
        return isCustomDate;
    }

    @JsOverlay
    public final void setCustomDate(Functions.FuncRet1<Object> isCustomDate) {
        this.isCustomDate = isCustomDate;
    }

    @JsOverlay
    public final boolean isAutoUpdateInput() {
        return autoUpdateInput;
    }

    @JsOverlay
    public final void setAutoUpdateInput(boolean autoUpdateInput) {
        this.autoUpdateInput = autoUpdateInput;
    }

    @JsOverlay
    public final String getParentEl() {
        return parentEl;
    }

    @JsOverlay
    public final void setParentEl(String parentEl) {
        this.parentEl = parentEl;
    }
}
