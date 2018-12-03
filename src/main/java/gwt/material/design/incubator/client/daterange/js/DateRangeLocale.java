package gwt.material.design.incubator.client.daterange.js;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONString;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.List;

/**
 * @author kevzlou7979
 * @see {@link gwt.material.design.incubator.client.daterange.DateRangePicker#setLocale(DateRangeLocale)}
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DateRangeLocale {

    @JsProperty
    private String format;

    @JsProperty
    private String separator;

    @JsProperty
    private String applyLabel;

    @JsProperty
    private String cancelLabel;

    @JsProperty
    private String fromLabel;

    @JsProperty
    private String toLabel;

    @JsProperty
    private String customRangeLabel;

    @JsProperty
    private String weekLabel;

    @JsProperty
    private LocaleString[] daysOfWeek;

    @JsProperty
    private LocaleString[] monthNames;

    @JsProperty
    private String firstDay;

    @JsOverlay
    public final String getFormat() {
        return format;
    }

    @JsOverlay
    public final void setFormat(String format) {
        this.format = format;
    }

    @JsOverlay
    public final String getSeparator() {
        return separator;
    }

    @JsOverlay
    public final void setSeparator(String separator) {
        this.separator = separator;
    }

    @JsOverlay
    public final String getApplyLabel() {
        return applyLabel;
    }

    @JsOverlay
    public final void setApplyLabel(String applyLabel) {
        this.applyLabel = applyLabel;
    }

    @JsOverlay
    public final String getCancelLabel() {
        return cancelLabel;
    }

    @JsOverlay
    public final void setCancelLabel(String cancelLabel) {
        this.cancelLabel = cancelLabel;
    }

    @JsOverlay
    public final String getFromLabel() {
        return fromLabel;
    }

    @JsOverlay
    public final void setFromLabel(String fromLabel) {
        this.fromLabel = fromLabel;
    }

    @JsOverlay
    public final String getToLabel() {
        return toLabel;
    }

    @JsOverlay
    public final void setToLabel(String toLabel) {
        this.toLabel = toLabel;
    }

    @JsOverlay
    public final String getCustomRangeLabel() {
        return customRangeLabel;
    }

    @JsOverlay
    public final void setCustomRangeLabel(String customRangeLabel) {
        this.customRangeLabel = customRangeLabel;
    }

    @JsOverlay
    public final String getWeekLabel() {
        return weekLabel;
    }

    @JsOverlay
    public final void setWeekLabel(String weekLabel) {
        this.weekLabel = weekLabel;
    }

    @JsOverlay
    public final LocaleString[] getDaysOfWeek() {
        return daysOfWeek;
    }

    @JsOverlay
    public final void setDaysOfWeek(LocaleString[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @JsOverlay
    public final LocaleString[] getMonthNames() {
        return monthNames;
    }

    @JsOverlay
    public final void setMonthNames(LocaleString[] monthNames) {
        if (monthNames.length == 12) {
            this.monthNames = monthNames;
        } else {
            GWT.log("Months must be equal to seven (12) months", new IllegalArgumentException());
        }
    }

    @JsOverlay
    public final String getFirstDay() {
        return firstDay;
    }

    @JsOverlay
    public final void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }
}
