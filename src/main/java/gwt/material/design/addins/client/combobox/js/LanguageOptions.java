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
package gwt.material.design.addins.client.combobox.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for combobox component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class LanguageOptions {

    @JsProperty
    private Functions.FuncRet1<String> errorLoading;

    @JsProperty
    private Functions.FuncRet1<String> inputTooLong;

    @JsProperty
    private Functions.FuncRet1<String> inputTooShort;

    @JsProperty
    private Functions.FuncRet1<String> loadingMore;

    @JsProperty
    private Functions.FuncRet1<String> maximumSelected;

    @JsProperty
    private Functions.FuncRet1<String> noResults;

    @JsProperty
    private Functions.FuncRet1<String> searching;

    @JsOverlay
    public final Functions.FuncRet1<String> getErrorLoading() {
        return errorLoading;
    }

    @JsOverlay
    public final void setErrorLoading(Functions.FuncRet1<String> errorLoading) {
        this.errorLoading = errorLoading;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getInputTooLong() {
        return inputTooLong;
    }

    @JsOverlay
    public final void setInputTooLong(Functions.FuncRet1<String> inputTooLong) {
        this.inputTooLong = inputTooLong;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getInputTooShort() {
        return inputTooShort;
    }

    @JsOverlay
    public final void setInputTooShort(Functions.FuncRet1<String> inputTooShort) {
        this.inputTooShort = inputTooShort;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getLoadingMore() {
        return loadingMore;
    }

    @JsOverlay
    public final void setLoadingMore(Functions.FuncRet1<String> loadingMore) {
        this.loadingMore = loadingMore;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getMaximumSelected() {
        return maximumSelected;
    }

    @JsOverlay
    public final void setMaximumSelected(Functions.FuncRet1<String> maximumSelected) {
        this.maximumSelected = maximumSelected;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getNoResults() {
        return noResults;
    }

    @JsOverlay
    public final void setNoResults(Functions.FuncRet1<String> noResults) {
        this.noResults = noResults;
    }

    @JsOverlay
    public final Functions.FuncRet1<String> getSearching() {
        return searching;
    }

    @JsOverlay
    public final void setSearching(Functions.FuncRet1<String> searching) {
        this.searching = searching;
    }
}