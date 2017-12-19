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
package gwt.material.design.incubator.client.chart.amcharts.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Language;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmLegend;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Label;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Title;
import gwt.material.design.incubator.client.chart.amcharts.js.plugins.DataLoader;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartResourceLoader;
import gwt.material.design.jquery.client.api.Functions;

public abstract class AbstractChart extends MaterialWidget implements ICoreChart {

    static {
        MaterialDesign.injectDebugJs(ChartClientBundle.INSTANCE.amChartJs());
    }

    public AbstractChart(ChartType chartType) {
        super(Document.get().createDivElement());

        setId(DOM.createUniqueId());
        setType(chartType);
        loadDefaults();
    }

    @Override
    protected void onLoad() {
        super.onLoad();
    }

    protected void loadDefaults() {
        setFontFamily("Roboto");
        setTheme(ChartTheme.LIGHT);
    }

    @Override
    public void setType(ChartType type) {
        ChartResourceLoader.loadChartTypeResource(type);
        getChart().type = type.getName();
    }

    @Override
    public void setTheme(ChartTheme theme) {
        ChartResourceLoader.loadTheme(theme);
        getChart().theme = theme.getName();
    }

    @Override
    public void setAccessible(boolean accessible) {
        getChart().accessible = accessible;
    }

    @Override
    public void setAccessibleDescription(String accessibleDescription) {
        getChart().accessibleDescription = accessibleDescription;
    }

    @Override
    public void setAccessibleTitle(String accessibleTitle) {
        getChart().accessibleTitle = accessibleTitle;
    }

    @Override
    public void setAddClassNames(boolean addClassNames) {
        getChart().addClassNames = addClassNames;
    }

    @Override
    public void setAllLabels(Label... allLabels) {
        getChart().allLabels = allLabels;
    }

    @Override
    public void setAutoDisplay(boolean autoDisplay) {
        getChart().autoDisplay = autoDisplay;
    }

    @Override
    public void setAutoResize(boolean autoResize) {
        getChart().autoResize = autoResize;
    }

    @Override
    public void setAutoTransform(boolean autoTransform) {
        getChart().autoTransform = autoTransform;
    }

    @Override
    public void setBackgroundAlpha(double backgroundAlpha) {
        getChart().backgroundAlpha = backgroundAlpha;
    }

    @Override
    public void setBackgroundColor(String backgroundColor) {
        getChart().backgroundColor = backgroundColor;
    }

    @Override
    public void setBalloon(AmBalloon balloon) {
        getChart().balloon = balloon;
    }

    @Override
    public void setBorderAlpha(double borderAlpha) {
        getChart().borderAlpha = borderAlpha;
    }

    @Override
    public void setBorderColor(String borderColor) {
        getChart().borderColor = borderColor;
    }

    @Override
    public void setClassNamePrefix(String classNamePrefix) {
        getChart().classNamePrefix = classNamePrefix;
    }

    @Override
    public void setColor(String color) {
        getChart().color = color;
    }

    @Override
    public void setCreditsPosition(String creditsPosition) {
        getChart().creditsPosition = creditsPosition;
    }

    @Override
    public void setDataProvider(Object dataProvider) {
        getChart().dataProvider = dataProvider;
    }

    @Override
    public void setDecimalSeparator(String decimalSeparator) {
        getChart().decimalSeparator = decimalSeparator;
    }

    @Override
    public void setDefs(Object defs) {
        getChart().defs = defs;
    }

    @Override
    public void setExport(Object export) {
        getChart().export = export;
    }

    @Override
    public void setFontSize(int fontSize) {
        getChart().fontSize = fontSize;
    }

    @Override
    public void setHandDrawn(boolean handDrawn) {
        getChart().handDrawn = handDrawn;
    }

    @Override
    public void setHandDrawScatter(int handDrawScatter) {
        getChart().handDrawScatter = handDrawScatter;
    }

    @Override
    public void setHandDrawThickness(int handDrawThickness) {
        getChart().handDrawThickness = handDrawThickness;
    }

    @Override
    public void setHideBalloonTime(int hideBalloonTime) {
        getChart().hideBalloonTime = hideBalloonTime;
    }

    @Override
    public void setLanguage(Language language) {
        getChart().language = language.name().toLowerCase();
    }

    @Override
    public void setLegend(AmLegend legend) {
        getChart().legend = legend;
    }

    @Override
    public void setLegendDiv(String legendDiv) {
        getChart().legendDiv = legendDiv;
    }

    @Override
    public void setListeners(Object... listeners) {
        getChart().listeners = listeners;
    }

    @Override
    public void setPanEventsEnabled(boolean panEventsEnabled) {
        getChart().panEventsEnabled = panEventsEnabled;
    }

    @Override
    public void setPath(String path) {
        getChart().path = path;
    }

    @Override
    public void setPathToImages(String pathToImages) {
        getChart().pathToImages = pathToImages;
    }

    @Override
    public void setPercentPrecision(int percentPrecision) {
        getChart().percentPrecision = percentPrecision;
    }

    @Override
    public void setPrecision(int precision) {
        getChart().precision = precision;
    }

    @Override
    public void setPrefixesOfBigNumbers(Object... prefixesOfBigNumbers) {
        getChart().prefixesOfBigNumbers = prefixesOfBigNumbers;
    }

    @Override
    public void setPrefixesOfSmallNumbers(Object... prefixesOfSmallNumbers) {
        getChart().prefixesOfSmallNumbers = prefixesOfSmallNumbers;
    }

    @Override
    public void setProcessCount(int processCount) {
        getChart().processCount = processCount;
    }

    @Override
    public void setProcessTimeout(int processTimeout) {
        getChart().processTimeout = processTimeout;
    }

    @Override
    public void setResponsive(Object responsive) {
        getChart().responsive = responsive;
    }

    @Override
    public void setSvgIcons(boolean svgIcons) {
        getChart().svgIcons = svgIcons;
    }

    @Override
    public void setTapToActivate(boolean tapToActivate) {
        getChart().tapToActivate = tapToActivate;
    }

    @Override
    public void setThousandsSeparator(String thousandsSeparator) {
        getChart().thousandsSeparator = thousandsSeparator;
    }

    @Override
    public void setTitles(Title[] titles) {
        getChart().titles = titles;
    }

    @Override
    public void setTouchClickDuration(int touchClickDuration) {
        getChart().touchClickDuration = touchClickDuration;
    }

    @Override
    public void setUsePrefixes(boolean usePrefixes) {
        getChart().usePrefixes = usePrefixes;
    }

    @Override
    public void setVersion(String version) {
        getChart().version = version;
    }

    @Override
    public void addLabel(int x, int y, String text, String align, int size, String color, int rotation, double alpha, boolean bold, String url) {
        getChart().addLabel(x, y, text, align, size, color, rotation, alpha, bold, url);
    }

    @Override
    public void addLegend(AmLegend legend, String targetElementId) {
        getChart().addLegend(legend, targetElementId);
    }

    @Override
    public void addListener(String type, Functions.Func handler) {
        getChart().addListener(type, handler);
    }

    @Override
    public void addTitle(String text, int size, String color, double alpha, boolean bold) {
        getChart().addTitle(text, size, color, alpha, bold);
    }

    @Override
    public void clearLabels() {
        getChart().clearLabels();
    }

    @Override
    public void invalidateSize() {
        getChart().invalidateSize();
    }

    @Override
    public void makeChart(String containerId, JSONValue config, int delay) {
        getChart().makeChart(containerId, config, delay);
    }

    @Override
    public void removeLegend() {
        getChart().removeLegend();
    }

    @Override
    public void removeListener(AmChart object, String type, Functions.Func handler) {
        getChart().removeListener(object, type, handler);
    }

    @Override
    public void validateData() {
        getChart().validateData();
    }

    @Override
    public void validateNow(Object validateData, boolean skipEvents) {
        getChart().validateNow(validateData, skipEvents);
    }

    @Override
    public void write(String elementId) {
        getChart().write(elementId);
    }

    @Override
    public void setFontFamily(String fontFamily) {
        getChart().fontFamily = fontFamily;
    }

    @Override
    public void loadPlugin(ChartPlugin plugin) {
        ChartResourceLoader.loadPluginResource(plugin);
    }

    public void setDataLoader(DataLoader loader) {
        getChart().dataLoader = loader;
    }

    public void load() {
        getChart().write(getId());
    }

    public abstract AmChart getChart();
}
