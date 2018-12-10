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
package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.addins.client.moment.Moment;
import gwt.material.design.jquery.client.api.Functions;

import java.util.Date;

/**
 * Options for {@link gwt.material.design.incubator.client.daterange.DateRangePicker}
 *
 * @author kevzlou7979
 */
public interface HasDateRangeOptions {

    Moment getStartDate();

    /**
     * The beginning date of the initially selected date range. If you provide a string, it must match the date format
     * string set in your locale setting.
     */
    void setStartDate(Moment startDate);

    Date getEndDate();

    /**
     * The end date of the initially selected date range.
     */
    void setEndDate(Date endDate);

    Date getMinDate();

    /**
     * The earliest date a user may select.
     */
    void setMinDate(Date minDate);

    Date getMaxDate();

    /**
     * The latest date a user may select.
     */
    void setMaxDate(Date maxDate);

    Object getMaxSpan();

    /**
     * The maximum span between the selected start and end dates. Check off maxSpan in the configuration generator for
     * an example of how to use this. You can provide any object the moment library would let you add to a date.
     */
    void setMaxSpan(Object maxSpan);

    boolean isShowDropdowns();

    /**
     * Show year and month select boxes above calendars to jump to a specific month and year.
     */
    void setShowDropdowns(boolean showDropdowns);

    int getMinYear();

    /**
     * The minimum year shown in the dropdowns when showDropdowns is set to true.
     */
    void setMinYear(int minYear);

    int getMaxYear();

    /**
     * The maximum year shown in the dropdowns when showDropdowns is set to true.
     */
    void setMaxYear(int maxYear);

    boolean isShowWeekNumbers();

    /**
     * Show localized week numbers at the start of each week on the calendars.
     */
    void setShowWeekNumbers(boolean showWeekNumbers);

    boolean isShowISOWeekNumbers();

    /**
     * Show ISO week numbers at the start of each week on the calendars.
     */
    void setShowISOWeekNumbers(boolean showISOWeekNumbers);

    boolean isTimePicker();

    /**
     * Adds select boxes to choose times in addition to dates.
     */
    void setTimePicker(boolean timePicker);

    int getTimePickerIncrement();

    /**
     * Increment of the minutes selection list for times (i.e. 30 to allow only selection of times ending in 0 or 30).
     */
    void setTimePickerIncrement(int timePickerIncrement);

    boolean isTimePicker24Hour();

    /**
     * Use 24-hour instead of 12-hour times, removing the AM/PM selection.
     */
    void setTimePicker24Hour(boolean timePicker24Hour);

    boolean isTimePickerSeconds();

    /**
     * Show seconds in the timePicker.
     */
    void setTimePickerSeconds(boolean timePickerSeconds);

    Object getRanges();

    /**
     * Set predefined date ranges the user can select from. Each key is the label for the range, and its value an array
     * with two dates representing the bounds of the range. Click ranges in the configuration generator for examples.
     */
    void setRanges(Object ranges);

    boolean isShowCustomRangeLabel();

    /**
     * Displays "Custom Range" at the end of the list of predefined ranges, when the ranges option is used. This option
     * will be highlighted whenever the current date range selection does not match one of the predefined ranges.
     * Clicking it will display the calendars to select a new range.
     */
    void setShowCustomRangeLabel(boolean showCustomRangeLabel);

    boolean isAlwaysShowCalendars();

    /**
     *  Normally, if you use the ranges option to specify pre-defined date ranges, calendars for choosing a custom date
     *  range are not shown until the user clicks "Custom Range". When this option is set to true, the calendars for
     *  choosing a custom date range are always shown instead.
     */
    void setAlwaysShowCalendars(boolean alwaysShowCalendars);

    DropdownAlignment getDropdownAlignment();

    /**
     * Whether the picker appears aligned to the left, to the right, or centered under the HTML element it's attached to.
     * @see DropdownAlignment
     */
    void setDropdownAlignment(DropdownAlignment alignment);

    DropdownPosition getDropdownPosition();

    /**
     * Whether the picker appears below (default) or above the HTML element it's attached to.
     * @see DropdownPosition
     */
    void setDropdownPosition(DropdownPosition position);

    String getButtonClasses();

    /**
     * CSS class names that will be added to both the apply and cancel buttons.
     */
    void setButtonClasses(String buttonClasses);

    String getApplyButtonClasses();

    /**
     * CSS class names that will be added only to the apply button.
     */
    void setApplyButtonClasses(String applyButtonClasses);

    String getCancelButtonClasses();

    /**
     * CSS class names that will be added only to the cancel button.
     */
    void setCancelButtonClasses(String cancelButtonClasses);

    DateRangeLocale getLocale();

    /**
     * Allows you to provide localized strings for buttons and labels, customize the date format, and change the first
     * day of week for the calendars. Check off locale in the configuration generator to see how to customize these options.
     */
    void setLocale(DateRangeLocale locale);

    boolean isSingleDatePicker();

    /**
     * Show only a single calendar to choose one date, instead of a range picker with two calendars.
     * The start and end dates provided to your callback will be the same single date chosen.
     */
    void setSingleDatePicker(boolean singleDatePicker);

    boolean isAutoApply();

    /**
     * Hide the apply and cancel buttons, and automatically apply a new date range as soon as two dates are clicked.
     */
    void setAutoApply(boolean autoApply);

    boolean isLinkedCalendars();

    /**
     * When enabled, the two calendars displayed will always be for two sequential months (i.e. January and February),
     * and both will be advanced when clicking the left or right arrows above the calendars. When disabled, the two calendars can be individually advanced and display any month/year.
     */
    void setLinkedCalendars(boolean linkedCalendars);

    Functions.FuncRet1<Boolean> isInvalidDate();

    /**
     * A function that is passed each date in the two calendars before they are displayed, and may return true or false
     * to indicate whether that date should be available for selection or not.
     */
    void setInvalidDate(Functions.FuncRet1<Boolean> isInvalidDate);

    Functions.FuncRet1<Object> isCustomDate();

    /**
     * A function that is passed each date in the two calendars before they are displayed, and may return a string or
     * array of CSS class names to apply to that date's calendar cell.
     */
    void setCustomDate(Functions.FuncRet1<Object> isCustomDate);

    boolean isAutoUpdateInput();

    /**
     * Indicates whether the date range picker should automatically update the value of the <input> element it's
     * attached to at initialization and when the selected dates change.
     */
    void setAutoUpdateInput(boolean autoUpdateInput);

    String getParentEl();

    /**
     *  jQuery selector of the parent element that the date range picker will be added to, if not provided this will be
     *  'body'
     */
    void setParentEl(String parentEl);
}
