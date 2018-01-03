/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
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

    @JsProperty
    private boolean async;

    @JsProperty
    private Functions.Func complete;

    @JsProperty
    private String delimiter;

    @JsProperty
    private Functions.Func error;

    @JsProperty
    private String format;

    @JsProperty
    private Functions.Func load;

    @JsProperty
    private boolean noStyles;

    @JsProperty
    private Functions.Func postProcess;

    @JsProperty
    private boolean showErrors;

    @JsProperty
    private boolean showCurtain;

    @JsProperty
    private int reload;

    @JsProperty
    private String url;

    @JsProperty
    private boolean reverse;

    @JsProperty
    private int skip;

    @JsProperty
    private boolean timestamp;

    @JsProperty
    private boolean useColumnNames;

    @JsOverlay
    public final boolean isAsync() {
        return async;
    }

    /**
     * If set to false (not recommended) everything will wait until data is fully loaded. Default to true
     */
    @JsOverlay
    public final void setAsync(boolean async) {
        this.async = async;
    }

    @JsOverlay
    public final Functions.Func getComplete() {
        return complete;
    }

    /**
     * Callback function to execute when loader is done.
     */
    @JsOverlay
    public final void setComplete(Functions.Func complete) {
        this.complete = complete;
    }

    @JsOverlay
    public final String getDelimiter() {
        return delimiter;
    }

    /**
     * [CSV only] a delimiter for columns (use t for tab delimiters). Default to comma(,).
     */
    @JsOverlay
    public final void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @JsOverlay
    public final Functions.Func getError() {
        return error;
    }

    /**
     * Callback function to execute if file load fails.
     */
    @JsOverlay
    public final void setError(Functions.Func error) {
        this.error = error;
    }

    @JsOverlay
    public final String getFormat() {
        return format;
    }

    /**
     * Type of data: json, csv. Default to Json
     */
    @JsOverlay
    public final void setFormat(String format) {
        this.format = format;
    }

    @JsOverlay
    public final Functions.Func getLoad() {
        return load;
    }

    /**
     * Callback function to execute when file is successfully loaded (might be invoked multiple times).
     */
    @JsOverlay
    public final void setLoad(Functions.Func load) {
        this.load = load;
    }

    @JsOverlay
    public final boolean isNoStyles() {
        return noStyles;
    }

    /**
     * If set to true no styles will be applied to “Data loading” curtain. Default to false
     */
    @JsOverlay
    public final void setNoStyles(boolean noStyles) {
        this.noStyles = noStyles;
    }

    @JsOverlay
    public final Functions.Func getPostProcess() {
        return postProcess;
    }

    /**
     * If set to function reference, that function will be called to “post-process” loaded data before passing it on
     * to chart.
     */
    @JsOverlay
    public final void setPostProcess(Functions.Func postProcess) {
        this.postProcess = postProcess;
    }

    @JsOverlay
    public final boolean isShowErrors() {
        return showErrors;
    }

    /**
     * Show loading errors in a chart curtain. Default to true
     */
    @JsOverlay
    public final void setShowErrors(boolean showErrors) {
        this.showErrors = showErrors;
    }

    @JsOverlay
    public final boolean isShowCurtain() {
        return showCurtain;
    }

    /**
     * Show curtain over the chart area when loading data. Default to true
     */
    @JsOverlay
    public final void setShowCurtain(boolean showCurtain) {
        this.showCurtain = showCurtain;
    }

    @JsOverlay
    public final int getReload() {
        return reload;
    }

    /**
     * Reload data every X seconds. Default to 0
     */
    @JsOverlay
    public final void setReload(int reload) {
        this.reload = reload;
    }

    @JsOverlay
    public final String getUrl() {
        return url;
    }

    /**
     * Url Resource of your data.
     */
    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    @JsOverlay
    public final boolean isReverse() {
        return reverse;
    }

    /**
     * [CSV only] add data points in revers order. Default to false
     */
    @JsOverlay
    public final void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    @JsOverlay
    public final int getSkip() {
        return skip;
    }

    /**
     * [CSV only] skip X first rows in data (includes first row if useColumnNames is used). Default to 0
     */
    @JsOverlay
    public final void setSkip(int skip) {
        this.skip = skip;
    }

    @JsOverlay
    public final boolean isTimestamp() {
        return timestamp;
    }

    /**
     * Add current timestamp to data URLs (to avoid caching). Default false
     */
    @JsOverlay
    public final void setTimestamp(boolean timestamp) {
        this.timestamp = timestamp;
    }

    @JsOverlay
    public final boolean isUseColumnNames() {
        return useColumnNames;
    }

    /**
     * [CSV only] Use first row in data as column names when parsing. Default to false
     */
    @JsOverlay
    public final void setUseColumnNames(boolean useColumnNames) {
        this.useColumnNames = useColumnNames;
    }
}
