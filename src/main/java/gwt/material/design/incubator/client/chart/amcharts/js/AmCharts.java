package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;
//@formatter:off

/**
 * Namespace of the framework which holds the general settings, gets automatically injected to document since the source
 * has been included.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmCharts">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmCharts {

    /**
     * Set it to true if you have base href set in your web page header. This will fix rendering issues caused by this
     * feature, like masks filters not working, causing graphs to protrude from plot area. Default to false
     */
    @JsProperty
    public boolean baseHref;

    /**
     * This array will hold references to all instances of the charts or maps created on the same page.
     */
    @JsProperty
    public AmChart[] charts;

    /**
     * Array of day names, used when formatting dates (if categoryAxis.parseDates is set to true)
     */
    @JsProperty
    public String[] dayNames;

    /**
     * Array of month names, used when formatting dates (if categoryAxis.parseDates is set to true)
     */
    @JsProperty
    public String[] monthNames;

    /**
     * Delay in ms at which each chart on the page should be rendered. This is very handy if you have a lot of charts
     * on the page and do not want to overload the device CPU. Default to 0
     */
    @JsProperty
    public int processDelay;

    /**
     * Array of short versions of day names, used when formatting dates (if categoryAxis.parseDates is set to true)
     */
    @JsProperty
    public String[] shortDayNames;

    /**
     * Array of short versions of month names, used when formatting dates (if categoryAxis.parseDates is set to true)
     */
    @JsProperty
    public String[] shortMonthNames;

    /**
     * You can set theme for all the charts on your page by setting: AmCharts.theme = AmCharts.themes.light; // or some
     * other theme. If you are creating charts using JavaScript API, not JSON, then this is quite a comfortable way, as
     * you won't need to pass theme to each object you create. Note, you should set theme before write method is called.
     * There is no way to change theme of already created chart, you have to create chart's instance once more if you
     * want to change theme.
     */
    @JsProperty
    public String theme;

    /**
     * Set it to true if you want UTC time to be used instead of local time. Default to false
     */
    @JsProperty
    public boolean useUTC;

    /**
     * handler is a method which will be called before initializing the chart. types is array of strings, specifying
     * which chart types should call this method. If you don't set any type, all the charts will call this method.
     * When handler method is called, chart instance is passed as an attribute. You can use this feature to preprocess
     * chart data or do some other things you need before initializing the chart.
     */
    @JsMethod(name = "AmCharts")
    public static native void addInitHandler(Functions.Func handler, String[] types);

    /**
     * Format the number according to rules set in prefixesBig, prefixesSmall and numberFormatter.
     * <p>
     * You can use chart instance's "prefixesOfSmallNumbers", "prefixesOfBigNumbers" as well as "precision", "decimalSeparator" and "thousandsSeparator" properties to form your request.
     */
    @JsMethod(name = "AmCharts")
    public static native void addPrefix(Object value, long prefixesBig, int prefixesSmall, String numberFormatter);

    /**
     * Clears all the charts on page, removes listeners and intervals.
     */
    @JsMethod(name = "AmCharts")
    public static native void clear();

    /**
     * You can use this method to format date object into date string.
     */
    @JsMethod(name = "AmCharts")
    public static native void formatDate(Date date, String format);

    /**
     * Returns string formatter with the provided settings. Formatter is an object with precision, decimalSeparator and
     * thousandsSeparator defined, like: {precision: 2, decimalSeparator: '.', thousandsSeparator: ','}; If you don't
     * need to adjust precision set it to -1. zeroCount defines how many zeros should be added after comma (useful when
     * formatting currencies).
     */
    @JsMethod(name = "AmCharts")
    public static native String formatNumber(int number, String formatter, int zeroCount);

    /**
     * You can use this method to convert date string to date object. Please note, that literal name codes such as
     * MMM or MMMM are not supported.
     */
    @JsMethod(name = "AmCharts")
    public static native Date stringToDate(String text, String format);

    /**
     * Called when AmChart is ready to build the graph.
     */
    @JsMethod(namespace = "AmCharts")
    public static native void ready(Functions.Func callback);

    /**
     * Creates chart. container can be either id or the reference to the element you want the chart to be placed in,
     * chartConfig is JSON object with chart properties defined and delay is time in ms, in which the chart should be
     * rendered (renders instantly if not set).
     */
    public static native void makeChart(String elementId, Object value);
}
