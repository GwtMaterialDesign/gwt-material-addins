package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmDataLoader;
import gwt.material.design.jquery.client.api.Functions;

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
public class DataLoader extends ChartOptions {

    private AmDataLoader dataLoader;

    public boolean isAsync() {
        return getAmDataLoader().async;
    }

    /**
     * If set to false (not recommended) everything will wait until data is fully loaded. Default to true
     */

    public void setAsync(boolean async) {
        getAmDataLoader().async = async;
    }


    public Functions.Func getComplete() {
        return getAmDataLoader().complete;
    }

    /**
     * Callback function to execute when loader is done.
     */

    public void setComplete(Functions.Func complete) {
        getAmDataLoader().complete = complete;
    }


    public String getDelimiter() {
        return getAmDataLoader().delimiter;
    }

    /**
     * [CSV only] a delimiter for columns (use t for tab delimiters). Default to comma(,).
     */

    public void setDelimiter(String delimiter) {
        getAmDataLoader().delimiter = delimiter;
    }


    public Functions.Func getError() {
        return getAmDataLoader().error;
    }

    /**
     * Callback function to execute if file load fails.
     */

    public void setError(Functions.Func error) {
        getAmDataLoader().error = error;
    }


    public String getFormat() {
        return getAmDataLoader().format;
    }

    /**
     * Type of data: json, csv. Default to Json
     */

    public void setFormat(String format) {
        getAmDataLoader().format = format;
    }


    public Functions.Func getLoad() {
        return getAmDataLoader().load;
    }

    /**
     * Callback function to execute when file is successfully loaded (might be invoked multiple times).
     */

    public void setLoad(Functions.Func load) {
        getAmDataLoader().load = load;
    }


    public boolean isNoStyles() {
        return getAmDataLoader().noStyles;
    }

    /**
     * If set to true no styles will be applied to “Data loading” curtain. Default to false
     */

    public void setNoStyles(boolean noStyles) {
        getAmDataLoader().noStyles = noStyles;
    }


    public Functions.Func getPostProcess() {
        return getAmDataLoader().postProcess;
    }

    /**
     * If set to function reference, that function will be called to “post-process” loaded data before passing it on
     * to chart.
     */

    public void setPostProcess(Functions.Func postProcess) {
        getAmDataLoader().postProcess = postProcess;
    }


    public boolean isShowErrors() {
        return getAmDataLoader().showErrors;
    }

    /**
     * Show loading errors in a chart curtain. Default to true
     */

    public void setShowErrors(boolean showErrors) {
        getAmDataLoader().showErrors = showErrors;
    }


    public boolean isShowCurtain() {
        return getAmDataLoader().showCurtain;
    }

    /**
     * Show curtain over the chart area when loading data. Default to true
     */

    public void setShowCurtain(boolean showCurtain) {
        getAmDataLoader().showCurtain = showCurtain;
    }


    public int getReload() {
        return getAmDataLoader().reload;
    }

    /**
     * Reload data every X seconds. Default to 0
     */

    public void setReload(int reload) {
        getAmDataLoader().reload = reload;
    }


    public String getUrl() {
        return getAmDataLoader().url;
    }

    /**
     * Url Resource of your data.
     */

    public void setUrl(String url) {
        getAmDataLoader().url = url;
    }


    public boolean isReverse() {
        return getAmDataLoader().reverse;
    }

    /**
     * [CSV only] add data points in revers order. Default to false
     */

    public void setReverse(boolean reverse) {
        getAmDataLoader().reverse = reverse;
    }


    public int getSkip() {
        return getAmDataLoader().skip;
    }

    /**
     * [CSV only] skip X first rows in data (includes first row if useColumnNames is used). Default to 0
     */

    public void setSkip(int skip) {
        getAmDataLoader().skip = skip;
    }


    public boolean isTimestamp() {
        return getAmDataLoader().timestamp;
    }

    /**
     * Add current timestamp to data URLs (to avoid caching). Default false
     */

    public void setTimestamp(boolean timestamp) {
        getAmDataLoader().timestamp = timestamp;
    }


    public boolean isUseColumnNames() {
        return getAmDataLoader().useColumnNames;
    }

    /**
     * [CSV only] Use first row in data as column names when parsing. Default to false
     */

    public void setUseColumnNames(boolean useColumnNames) {
        getAmDataLoader().useColumnNames = useColumnNames;
    }

    public AmDataLoader getAmDataLoader() {
        if (dataLoader == null) {
            dataLoader = new AmDataLoader();
        }
        return dataLoader;
    }
}
