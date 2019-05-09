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

import com.google.gwt.core.client.JsDate;
import gwt.material.design.addins.client.moment.Moment;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.daterange.js.DropdownAlignment;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

import static gwt.material.design.addins.client.moment.Moment.moment;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DateRangeOptions {

    @JsProperty
    protected JsDate startDate;

    @JsProperty
    protected JsDate endDate;

    @JsProperty
    protected JsDate minDate;

    @JsProperty
    protected JsDate maxDate;

    @JsProperty
    protected Object maxSpan;

    @JsProperty
    protected boolean showDropdowns;

    @JsProperty
    protected int minYear;

    @JsProperty
    protected int maxYear;

    @JsProperty
    protected boolean showWeekNumbers;

    @JsProperty
    protected boolean showISOWeekNumbers;

    @JsProperty
    protected boolean timePicker;

    @JsProperty
    protected int timePickerIncrement;

    @JsProperty
    protected boolean timePicker24Hour;

    @JsProperty
    protected boolean timePickerSeconds;

    @JsProperty
    protected Object ranges;

    @JsProperty
    protected boolean showCustomRangeLabel;

    @JsProperty
    protected boolean alwaysShowCalendars;

    /**
     * @see DropdownAlignment
     */
    @JsProperty
    protected String opens;

    @JsProperty
    protected String drops;

    @JsProperty
    protected String buttonClasses;

    @JsProperty
    protected String applyButtonClasses;

    @JsProperty
    protected String cancelButtonClasses;

    @JsProperty
    protected Object locale;

    @JsProperty
    protected boolean singleDatePicker;

    @JsProperty
    protected boolean autoApply;

    @JsProperty
    protected boolean linkedCalendars;

    @JsProperty
    protected Functions.FuncRet1<Boolean> isInvalidDate;

    @JsProperty
    protected Functions.FuncRet1<Object> isCustomDate;

    @JsProperty
    protected boolean autoUpdateInput;

    @JsProperty
    protected String parentEl;
    

    @JsOverlay
    public final void setStartDate(Date startDate) {
        this.startDate = JsDate.create(startDate.getTime());
    }

    @JsOverlay
    public final void setEndDate(Date endDate) {
        this.endDate = JsDate.create(endDate.getTime());
    }

    @JsOverlay
    public final void setMinDate(Date minDate) {
        this.minDate = JsDate.create(minDate.getTime());
    }

    @JsOverlay
    public final void setMaxDate(Date maxDate) {
        this.maxDate = JsDate.create(maxDate.getTime());
    }

    @JsOverlay
    public final void setMaxSpan(Object maxSpan) {
        this.maxSpan = maxSpan;
    }

    @JsOverlay
    public final void setShowDropdowns(boolean showDropdowns) {
        this.showDropdowns = showDropdowns;
    }

    @JsOverlay
    public final void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    @JsOverlay
    public final void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    @JsOverlay
    public final void setShowWeekNumbers(boolean showWeekNumbers) {
        this.showWeekNumbers = showWeekNumbers;
    }

    @JsOverlay
    public final void setShowISOWeekNumbers(boolean showISOWeekNumbers) {
        this.showISOWeekNumbers = showISOWeekNumbers;
    }

    @JsOverlay
    public final void setTimePicker(boolean timePicker) {
        this.timePicker = timePicker;
    }

    @JsOverlay
    public final void setTimePickerIncrement(int timePickerIncrement) {
        this.timePickerIncrement = timePickerIncrement;
    }

    @JsOverlay
    public final void setTimePicker24Hour(boolean timePicker24Hour) {
        this.timePicker24Hour = timePicker24Hour;
    }

    @JsOverlay
    public final void setTimePickerSeconds(boolean timePickerSeconds) {
        this.timePickerSeconds = timePickerSeconds;
    }

    @JsOverlay
    public final void setRanges(Object ranges) {
        this.ranges = ranges;
    }

    @JsOverlay
    public final void setShowCustomRangeLabel(boolean showCustomRangeLabel) {
        this.showCustomRangeLabel = showCustomRangeLabel;
    }

    @JsOverlay
    public final void setAlwaysShowCalendars(boolean alwaysShowCalendars) {
        this.alwaysShowCalendars = alwaysShowCalendars;
    }

    @JsOverlay
    public final void setOpens(String opens) {
        this.opens = opens;
    }

    @JsOverlay
    public final void setDrops(String drops) {
        this.drops = drops;
    }

    @JsOverlay
    public final void setButtonClasses(String buttonClasses) {
        this.buttonClasses = buttonClasses;
    }

    @JsOverlay
    public final void setApplyButtonClasses(String applyButtonClasses) {
        this.applyButtonClasses = applyButtonClasses;
    }

    @JsOverlay
    public final void setCancelButtonClasses(String cancelButtonClasses) {
        this.cancelButtonClasses = cancelButtonClasses;
    }

    @JsOverlay
    public final void setLocale(Object locale) {
        this.locale = locale;
    }

    @JsOverlay
    public final void setSingleDatePicker(boolean singleDatePicker) {
        this.singleDatePicker = singleDatePicker;
    }

    @JsOverlay
    public final void setAutoApply(boolean autoApply) {
        this.autoApply = autoApply;
    }

    @JsOverlay
    public final void setLinkedCalendars(boolean linkedCalendars) {
        this.linkedCalendars = linkedCalendars;
    }

    @JsOverlay
    public final void setInvalidDate(Functions.FuncRet1<Boolean> isInvalidDate) {
        this.isInvalidDate = isInvalidDate;
    }

    @JsOverlay
    public final void setCustomDate(Functions.FuncRet1<Object> isCustomDate) {
        this.isCustomDate = isCustomDate;
    }

    @JsOverlay
    public final void setAutoUpdateInput(boolean autoUpdateInput) {
        this.autoUpdateInput = autoUpdateInput;
    }

    @JsOverlay
    public final void setParentEl(String parentEl) {
        this.parentEl = parentEl;
    }
}
