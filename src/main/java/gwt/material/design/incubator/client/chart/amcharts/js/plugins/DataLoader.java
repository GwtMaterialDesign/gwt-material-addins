package gwt.material.design.incubator.client.chart.amcharts.js.plugins;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * By default all amCharts libraries accept data in JSON format. It needs to be there when the web page loads, defined
 * in-line or loaded via custom code.
 * <p>
 * This plugin introduces a native wrapper that enables automatic loading of data from external data data sources in
 * CSV and JSON formats.
 * <p>
 * Most of the times you will just need to provide a URL of the external data source – static file or dynamically
 * generated – and it will do the rest.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://www.amcharts.com/kbase/using-data-loader-plugin/">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class DataLoader {

    /**
     * If set to false (not recommended) everything will wait until data is fully loaded. Default to true
     */
    @JsProperty
    public boolean async;

    /**
     * Callback function to execute when loader is done.
     */
    @JsProperty
    public Functions.Func complete;

    /**
     * [CSV only] a delimiter for columns (use t for tab delimiters). Default to comma(,).
     */
    @JsProperty
    public String delimiter;

    /**
     * Callback function to execute if file load fails.
     */
    @JsProperty
    public Functions.Func error;

    /**
     * Type of data: json, csv. Default to Json
     */
    @JsProperty
    public String format;

    /**
     * Callback function to execute when file is successfully loaded (might be invoked multiple times).
     */
    @JsProperty
    public Functions.Func load;

    /**
     * If set to true no styles will be applied to “Data loading” curtain. Default to false
     */
    @JsProperty
    public boolean noStyles;

    /**
     * If set to function reference, that function will be called to “post-process” loaded data before passing it on
     * to chart.
     */
    @JsProperty
    public Functions.Func postProcess;

    /**
     * Show loading errors in a chart curtain. Default to true
     */
    @JsProperty
    public boolean showErrors;

    /**
     * Show curtain over the chart area when loading data. Default to true
     */
    @JsProperty
    public boolean showCurtain;

    /**
     * Reload data every X seconds. Default to 0
     */
    @JsProperty
    public int reload;

    /**
     * Url Resource of your data.
     */
    @JsProperty
    public String url;

    /**
     * [CSV only] add data points in revers order. Default to false
     */
    @JsProperty
    public boolean reverse;

    /**
     * [CSV only] skip X first rows in data (includes first row if useColumnNames is used). Default to 0
     */
    @JsProperty
    public int skip;

    /**
     * Add current timestamp to data URLs (to avoid caching). Default false
     */
    @JsProperty
    public boolean timestamp;

    /**
     * [CSV only] Use first row in data as column names when parsing. Default to false
     */
    @JsProperty
    public boolean useColumnNames;
}
