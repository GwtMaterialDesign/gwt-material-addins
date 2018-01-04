package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmDataLoader;
import gwt.material.design.jquery.client.api.Functions;

public class DataLoader extends ChartOptions {

    private AmDataLoader dataLoader = new AmDataLoader();

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    public boolean isAsync() {
        return dataLoader.async;
    }

    /**
     * If set to false (not recommended) everything will wait until data is fully loaded. Default to true
     */

    public void setAsync(boolean async) {
        dataLoader.async = async;
    }


    public Functions.Func getComplete() {
        return dataLoader.complete;
    }

    /**
     * Callback function to execute when loader is done.
     */

    public void setComplete(Functions.Func complete) {
        dataLoader.complete = complete;
    }


    public String getDelimiter() {
        return dataLoader.delimiter;
    }

    /**
     * [CSV only] a delimiter for columns (use t for tab delimiters). Default to comma(,).
     */

    public void setDelimiter(String delimiter) {
        dataLoader.delimiter = delimiter;
    }


    public Functions.Func getError() {
        return dataLoader.error;
    }

    /**
     * Callback function to execute if file load fails.
     */

    public void setError(Functions.Func error) {
        dataLoader.error = error;
    }


    public String getFormat() {
        return dataLoader.format;
    }

    /**
     * Type of data: json, csv. Default to Json
     */

    public void setFormat(String format) {
        dataLoader.format = format;
    }


    public Functions.Func getLoad() {
        return dataLoader.load;
    }

    /**
     * Callback function to execute when file is successfully loaded (might be invoked multiple times).
     */

    public void setLoad(Functions.Func load) {
        dataLoader.load = load;
    }


    public boolean isNoStyles() {
        return dataLoader.noStyles;
    }

    /**
     * If set to true no styles will be applied to “Data loading” curtain. Default to false
     */

    public void setNoStyles(boolean noStyles) {
        dataLoader.noStyles = noStyles;
    }


    public Functions.Func getPostProcess() {
        return dataLoader.postProcess;
    }

    /**
     * If set to function reference, that function will be called to “post-process” loaded data before passing it on
     * to chart.
     */

    public void setPostProcess(Functions.Func postProcess) {
        dataLoader.postProcess = postProcess;
    }


    public boolean isShowErrors() {
        return dataLoader.showErrors;
    }

    /**
     * Show loading errors in a chart curtain. Default to true
     */

    public void setShowErrors(boolean showErrors) {
        dataLoader.showErrors = showErrors;
    }


    public boolean isShowCurtain() {
        return dataLoader.showCurtain;
    }

    /**
     * Show curtain over the chart area when loading data. Default to true
     */

    public void setShowCurtain(boolean showCurtain) {
        dataLoader.showCurtain = showCurtain;
    }


    public int getReload() {
        return dataLoader.reload;
    }

    /**
     * Reload data every X seconds. Default to 0
     */

    public void setReload(int reload) {
        dataLoader.reload = reload;
    }


    public String getUrl() {
        return dataLoader.url;
    }

    /**
     * Url Resource of your data.
     */

    public void setUrl(String url) {
        dataLoader.url = url;
    }


    public boolean isReverse() {
        return dataLoader.reverse;
    }

    /**
     * [CSV only] add data points in revers order. Default to false
     */

    public void setReverse(boolean reverse) {
        dataLoader.reverse = reverse;
    }


    public int getSkip() {
        return dataLoader.skip;
    }

    /**
     * [CSV only] skip X first rows in data (includes first row if useColumnNames is used). Default to 0
     */

    public void setSkip(int skip) {
        dataLoader.skip = skip;
    }


    public boolean isTimestamp() {
        return dataLoader.timestamp;
    }

    /**
     * Add current timestamp to data URLs (to avoid caching). Default false
     */

    public void setTimestamp(boolean timestamp) {
        dataLoader.timestamp = timestamp;
    }


    public boolean isUseColumnNames() {
        return dataLoader.useColumnNames;
    }

    /**
     * [CSV only] Use first row in data as column names when parsing. Default to false
     */

    public void setUseColumnNames(boolean useColumnNames) {
        dataLoader.useColumnNames = useColumnNames;
    }

    public AmDataLoader getDataLoader() {
        return dataLoader;
    }
}
