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

import com.google.gwt.json.client.JSONValue;
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
import gwt.material.design.jquery.client.api.Functions;

public interface ICoreChart {


    void setAccessible(boolean accessible);


    void setAccessibleDescription(String accessibleDescription);


    void setAccessibleTitle(String accessibleTitle);


    void setAddClassNames(boolean addClassNames);


    void setAllLabels(Label... allLabels);


    void setAutoDisplay(boolean autoDisplay);


    void setAutoResize(boolean autoResize);


    void setAutoTransform(boolean autoTransform);


    void setBackgroundAlpha(double backgroundAlpha);


    void setBackgroundColor(String backgroundColor);


    void setBalloon(AmBalloon balloon);


    void setBorderAlpha(double borderAlpha);


    void setBorderColor(String borderColor);


    void setClassNamePrefix(String classNamePrefix);


    void setColor(String color);


    void setCreditsPosition(String creditsPosition);


    void setDataLoader(DataLoader dataLoader);


    void setDataProvider(Object dataProvider);


    void setDecimalSeparator(String decimalSeparator);


    void setDefs(Object defs);


    void setExport(Object export);


    void setFontFamily(String fontFamily);


    void setFontSize(int fontSize);


    void setHandDrawn(boolean handDrawn);


    void setHandDrawScatter(int handDrawScatter);


    void setHandDrawThickness(int handDrawThickness);


    void setHideBalloonTime(int hideBalloonTime);


    void setLanguage(Language language);


    void setLegend(AmLegend legend);


    void setLegendDiv(String legendDiv);


    void setListeners(Object... listeners);


    void setPanEventsEnabled(boolean panEventsEnabled);


    void setPath(String path);


    void setPathToImages(String pathToImages);


    void setPercentPrecision(int percentPrecision);


    void setPrecision(int precision);


    void setPrefixesOfBigNumbers(Object... prefixesOfSmallNumbers);


    void setPrefixesOfSmallNumbers(Object... prefixesOfSmallNumbers);


    void setProcessCount(int processCount);


    void setProcessTimeout(int processTimeout);


    void setResponsive(Object responsive);


    void setSvgIcons(boolean svgIcons);


    void setTapToActivate(boolean tapToActivate);

    void setTheme(ChartTheme theme);


    void setThousandsSeparator(String thousandsSeparator);


    void setTitles(Title[] titles);


    void setTouchClickDuration(int touchClickDuration);


    void setType(ChartType type);


    void setUsePrefixes(boolean usePrefixes);


    void setVersion(String version);


    void addLabel(int x, int y, String text, String align, int size, String color, int rotation, double alpha, boolean bold, String url);


    void addLegend(AmLegend legend, String targetElementId);


    void addListener(String type, Functions.Func handler);


    void addTitle(String text, int size, String color, double alpha, boolean bold);

    /**
     * Clears the chart area, intervals, etc.
     */
    void clear();


    void clearLabels();


    void invalidateSize();

    /**
     * This method allows to create charts with a single config.
     *
     * @param containerId id of a DIV or reference of the container element
     * @param config      contains the whole setup for the chart
     * @param delay       delay the initiation of the chart
     */
    void makeChart(String containerId, JSONValue config, int delay);

    /**
     * Removes chart's legend.
     */
    void removeLegend();

    /**
     * Removes event listener from chart object.
     *
     * @param object  chart object
     * @param type    event name
     * @param handler method called when listener has been called.
     */
    void removeListener(AmChart object, String type, Functions.Func handler);

    /**
     * This method should be called after data in your data provider changed or a new array was set to dataProvider.
     * After calling this method the chart will parse data and redraw.
     */
    void validateData();

    /**
     * This method should be called after you changed one or more properties of any class. The chart will redraw after
     * this method is called.Both attributes, validateData and skipEvents are optional (false by default).
     */
    void validateNow(Object validateData, boolean skipEvents);

    /**
     * Adds chart to the specified DIV.
     *
     * @param elementId id of a DIV or DIV object which will hold the chart
     */
    void write(String elementId);

    /**
     * Load any plugins in amchart {@link ChartPlugin}
     *
     * @param plugin
     */
    void loadPlugin(ChartPlugin plugin);
}
