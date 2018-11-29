package gwt.material.design.incubator.client.daterange.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DateRangeOptions {

    @JsProperty
    public Date startDate;

    @JsProperty
    public Date endDate;

    @JsProperty
    public Date minDate;

    @JsProperty
    public Date maxDate;

    @JsProperty
    public Object maxSpan;

    @JsProperty
    public boolean showDropdowns;

    @JsProperty
    public int minYear;

    @JsProperty
    public int maxYear;

    @JsProperty
    public boolean showWeekNumbers;

    @JsProperty
    public boolean showISOWeekNumbers;

    @JsProperty
    public boolean timePicker;

    @JsProperty
    public int timePickerIncrement;

    @JsProperty
    public boolean timePicker24Hour;

    @JsProperty
    public boolean timePickerSeconds;

    @JsProperty
    public Object ranges;

    @JsProperty
    public boolean showCustomRangeLabel;

    @JsProperty
    public boolean alwaysShowCalendars;

    /**
     * @see DropdownAlignment
     */
    @JsProperty
    public String opens;

    @JsProperty
    public String drops;

    @JsProperty
    public String buttonClasses;

    @JsProperty
    public String applyButtonClasses;

    @JsProperty
    public String cancelButtonClasses;

    @JsProperty
    public Object locale;

    @JsProperty
    public boolean singleDatePicker;

    @JsProperty
    public boolean autoApply;

    @JsProperty
    public boolean linkedCalendars;

    @JsProperty
    public Functions.FuncRet1<Boolean> isInvalidDate;

    @JsProperty
    public Functions.FuncRet1<Object> isCustomDate;

    @JsProperty
    public boolean autoUpdateInput;

    @JsProperty
    public String parentEl;
}
