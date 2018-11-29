package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.jquery.client.api.Functions;

import java.util.Date;

public interface HasDateRangeOptions {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    Date getMinDate();

    void setMinDate(Date minDate);

    Date getMaxDate();

    void setMaxDate(Date maxDate);

    Object getMaxSpan();

    void setMaxSpan(Object maxSpan);

    boolean isShowDropdowns();

    void setShowDropdowns(boolean showDropdowns);

    int getMinYear();

    void setMinYear(int minYear);

    int getMaxYear();

    void setMaxYear(int maxYear);

    boolean isShowWeekNumbers();

    void setShowWeekNumbers(boolean showWeekNumbers);

    boolean isShowISOWeekNumbers();

    void setShowISOWeekNumbers(boolean showISOWeekNumbers);

    boolean isTimePicker();

    void setTimePicker(boolean timePicker);

    int getTimePickerIncrement();

    void setTimePickerIncrement(int timePickerIncrement);

    boolean isTimePicker24Hour();

    void setTimePicker24Hour(boolean timePicker24Hour);

    boolean isTimePickerSeconds();

    void setTimePickerSeconds(boolean timePickerSeconds);

    Object getRanges();

    void setRanges(Object ranges);

    boolean isShowCustomRangeLabel();

    void setShowCustomRangeLabel(boolean showCustomRangeLabel);

    boolean isAlwaysShowCalendars();

    void setAlwaysShowCalendars(boolean alwaysShowCalendars);

    DropdownAlignment getDropdownAlignment();

    void setDropdownAlignment(DropdownAlignment alignment);

    DropdownPosition getDropdownPosition();

    void setDropdownPosition(DropdownPosition position);

    String getButtonClasses();

    void setButtonClasses(String buttonClasses);

    String getApplyButtonClasses();

    void setApplyButtonClasses(String applyButtonClasses);

    String getCancelButtonClasses();

    void setCancelButtonClasses(String cancelButtonClasses);

    Object getLocale();

    void setLocale(Object locale);

    boolean isSingleDatePicker();

    void setSingleDatePicker(boolean singleDatePicker);

    boolean isAutoApply();

    void setAutoApply(boolean autoApply);

    boolean isLinkedCalendars();

    void setLinkedCalendars(boolean linkedCalendars);

    Functions.FuncRet1<Boolean> isInvalidDate();

    void setInvalidDate(Functions.FuncRet1<Boolean> isInvalidDate);

    Functions.FuncRet1<Object> isCustomDate();

    void setCustomDate(Functions.FuncRet1<Object> isCustomDate);

    boolean isAutoUpdateInput();

    void setAutoUpdateInput(boolean autoUpdateInput);

    String getParentEl();

    void setParentEl(String parentEl);
}
