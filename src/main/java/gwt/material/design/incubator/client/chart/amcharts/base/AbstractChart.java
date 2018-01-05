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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Language;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasChartHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.core.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.CoreData;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmLegend;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Label;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Title;
import gwt.material.design.incubator.client.chart.amcharts.options.DataLoader;
import gwt.material.design.incubator.client.chart.amcharts.options.Legend;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartResourceLoader;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Base class of all core charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmChart">Official Documentation</a>
 */
//@formatter:on
public abstract class AbstractChart extends MaterialWidget implements JsLoader, HasChartHandlers {

    static {
        MaterialDesign.injectDebugJs(ChartClientBundle.INSTANCE.amChartJs());
    }

    public AbstractChart(ChartType chartType) {
        super(Document.get().createDivElement());

        setId(DOM.createUniqueId());
        setType(chartType);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        // Load the default configs
        loadDefaults();

        // Initialize the events
        addListener(AmChartEvents.ANIMATION_FINISHED, object -> AnimationFinishedEvent.fire(this, (CoreData) object));
        addListener(AmChartEvents.BUILD_STARTED, object -> BuildStartedEvent.fire(this, (CoreData) object));
        addListener(AmChartEvents.DATA_UPDATED, object -> DataUpdatedEvent.fire(this, (CoreData) object));
        addListener(AmChartEvents.DRAWN, object -> DrawnEvent.fire(AbstractChart.this, (CoreData) object));
        addListener(AmChartEvents.INIT, object -> InitEvent.fire(this, (CoreData) object));
        addListener(AmChartEvents.RENDERED, object -> RenderedEvent.fire(this, (CoreData) object));

        // Build the graph with given container id
        getChart().write(getId());
    }

    protected void loadDefaults() {
        setFontFamily("Roboto");
        setTheme(ChartTheme.LIGHT);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        getChart().clear();

        // TODO Figure out how to destroy chart events
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    /**
     * Type of a chart. Required when creating chart using JSON. Possible types are: serial, pie, xy, radar, funnel,
     * gauge, map, gantt, stock.
     */
    public void setType(ChartType type) {
        ChartResourceLoader.loadChartTypeResource(type);
        getChart().type = type.getName();
    }

    /**
     * Set the theme of AmChart see {@link ChartTheme}
     */
    public void setTheme(ChartTheme theme) {
        ChartResourceLoader.loadTheme(theme);
        getChart().theme = theme.getName();
    }

    /**
     * When enabled, chart adds aria-label attributes to columns, bullets or map objects. You can control values of
     * these labels using properties like accessibleLabel of AmGraph. Note, not all screen readers support these tags.
     * We tested this mostly with NVDA Screen reader. WAI-ARIA is now official W3 standard, so in future more readers
     * will handle this well. We will be improving accessibility on our charts, so we would be glad to hear your feedback.
     * Default to true
     */
    public void setAccessible(boolean accessible) {
        getChart().accessible = accessible;
    }

    /**
     * Description which will be added to node of SVG element. Most of the screen readers will read this description.
     */
    public void setAccessibleDescription(String accessibleDescription) {
        getChart().accessibleDescription = accessibleDescription;
    }

    /**
     * Description which is added to of a SVG element. Some of the screen readers will read this description.
     */
    public void setAccessibleTitle(String accessibleTitle) {
        getChart().accessibleTitle = accessibleTitle;
    }

    /**
     * Specifies, if class names should be added to chart elements.
     */
    public void setAddClassNames(boolean addClassNames) {
        getChart().addClassNames = addClassNames;
    }

    /**
     * Array of {@link Label}. Example of label object, with all possible properties:
     * {"x": 20, "y": 20, "text": "this is label", "align": "left", "size": 12, "color": "#CC0000", "alpha": 1,
     * "rotation": 0, "bold": true, "url": "http://www.amcharts.com"}
     */
    public void setAllLabels(Label... allLabels) {
        getChart().allLabels = allLabels;
    }

    /**
     * If you set it to true the chart will automatically monitor changes of display style of chart’s container
     * (or any of it’s parents) and will render chart correctly if it is changed from none to block. We recommend
     * setting it to true if you change this style at a run time, as it affects performance a bit. Default to false
     */
    public void setAutoDisplay(boolean autoDisplay) {
        getChart().autoDisplay = autoDisplay;
    }

    /**
     * Set this to false if you don't want chart to resize itself whenever its parent container size changes. Default
     * to true
     */
    public void setAutoResize(boolean autoResize) {
        getChart().autoResize = autoResize;
    }

    /**
     * If you set it to true and your chart div (or any of the parent div) has css scale applied, the chart will
     * position mouse at a correct position. Default value is false because this operation consumes some CPU and
     * quite a few people are using css transforms. Default to false
     */
    public void setAutoTransform(boolean autoTransform) {
        getChart().autoTransform = autoTransform;
    }

    /**
     * Opacity of background. Set it to >0 value if you want backgroundColor to work. However we recommend changing
     * div's background-color style for changing background color. Default to 0
     */
    public void setBackgroundAlpha(double backgroundAlpha) {
        getChart().backgroundAlpha = backgroundAlpha;
    }

    /**
     * Background color. You should set backgroundAlpha to >0 value in order background to be visible. We recommend
     * setting background color directly on a chart's DIV instead of using this property. Default to #FFFFFF
     */
    public void setBackgroundColor(String backgroundColor) {
        getChart().backgroundColor = backgroundColor;
    }

    /**
     * The chart creates {@link AmBalloon} class itself. If you want to customize balloon, get balloon instance using this
     * property, and then change balloon's properties.
     */
    public void setBalloon(AmBalloon balloon) {
        getChart().balloon = balloon;
    }

    /**
     * Opacity of chart's border. Value range is 0 - 1. Default to 0
     */
    public void setBorderAlpha(double borderAlpha) {
        getChart().borderAlpha = borderAlpha;
    }

    /**
     * Color of chart's border. You should set borderAlpha >0 in order border to be visible. We recommend setting border
     * color directly on a chart's DIV instead of using this property. Default to #000000
     */
    public void setBorderColor(String borderColor) {
        getChart().borderColor = borderColor;
    }

    /**
     * This prefix is added to all class names which are added to all visual elements of a chart in case addClassNames
     * is set to true. Default to "amcharts".
     */
    public void setClassNamePrefix(String classNamePrefix) {
        getChart().classNamePrefix = classNamePrefix;
    }

    /**
     * Non-commercial version only. Specifies position of link to amCharts site. Allowed values are: top-left,
     * top-right, bottom-left and bottom-right. Default to "top-left"
     */
    public void setColor(String color) {
        getChart().color = color;
    }

    /**
     * A config object for Data Loader plugin. Please refer to the following page for more information.
     */
    public void setCreditsPosition(String creditsPosition) {
        getChart().creditsPosition = creditsPosition;
    }

    /**
     * Array of data objects, for example: [{country:"US", value:524},{country:"UK", value:624},{country:"Lithuania",
     * value:824}]. You can have any number of fields and use any field names. In case of AmMap, data provider should
     * be MapData object.
     * </p>
     * The data set data.
     * </p>
     * <p>
     * Important: if you are using date/time-based category axis, the data points needs to come pre-ordered in ascending
     * order. Data with incorrect order might result in visual and functional glitches on the chart.
     * </p>
     */
    public void setDataProvider(Object dataProvider) {
        getChart().dataProvider = dataProvider;
    }

    /**
     * Decimal separator.
     */
    public void setDecimalSeparator(String decimalSeparator) {
        getChart().decimalSeparator = decimalSeparator;
    }

    /**
     * Using this property you can add any additional information to SVG, like SVG filters or clip paths.
     * The structure of this object should be identical to XML structure of a object you are adding, only in JSON format.
     */
    public void setDefs(Object defs) {
        getChart().defs = defs;
    }

    /**
     * Export config. Specifies how export to image/data export/print/annotate menu will look and behave.
     * You can find a lot of examples in amcharts/plugins/export folder. More details can be found
     * <a href="http://www.amcharts.com/tutorials/intro-exporting-charts/">here</a>.
     */
    public void setExport(Object export) {
        getChart().export = export;
    }

    /**
     * Font size. Default to 11
     */
    public void setFontSize(int fontSize) {
        getChart().fontSize = fontSize;
    }

    /**
     * If you set this to true, the lines of the chart will be distorted and will produce hand-drawn effect.
     * Try to adjust chart.handDrawScatter and chart.handDrawThickness properties for a more scattered result.
     * Default to false
     */
    public void setHandDrawn(boolean handDrawn) {
        getChart().handDrawn = handDrawn;
    }

    /**
     * Defines by how many pixels hand-drawn line (when handDrawn is set to true) will fluctuate. Default to 2
     */
    public void setHandDrawScatter(int handDrawScatter) {
        getChart().handDrawScatter = handDrawScatter;
    }

    /**
     * Defines by how many pixels line thickness will fluctuate (when handDrawn is set to true). Default to 1
     */
    public void setHandDrawThickness(int handDrawThickness) {
        getChart().handDrawThickness = handDrawThickness;
    }

    /**
     * Time, in milliseconds after which balloon is hidden if the user rolls-out of the object. Might be useful for
     * AmMap to avoid balloon flickering while moving mouse over the areas. Note, this is not duration of fade-out.
     * Duration of fade-out is set in {@link AmBalloon} class. Default to 150
     */
    public void setHideBalloonTime(int hideBalloonTime) {
        getChart().hideBalloonTime = hideBalloonTime;
    }

    /**
     * Allows changing language easily. Note, you should include language js file from amcharts/lang or ammap/lang
     * folder and then use variable name used in this file, like chart.language = "de"; Note, for maps this works
     * differently - you use language only for country names, as there are no other strings in the maps application.
     */
    public void setLanguage(Language language) {
        getChart().language = language.name().toLowerCase();
    }

    /**
     * Allows changing language easily. Note, you should include language js file from amcharts/lang or ammap/lang
     * folder and then use variable name used in this file, like chart.language = "de"; Note, for maps this works
     * differently - you use language only for country names, as there are no other strings in the maps application.
     */
    public void setLegend(Legend legend) {
        getChart().legend = legend.getLegend();
        legend.load();
    }

    /**
     * Read-only. Reference to the div of the legend.
     */
    public void setLegendDiv(String legendDiv) {
        getChart().legendDiv = legendDiv;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"dataUpdated",
     * "method":handleEvent}];
     */
    public void setListeners(Object... listeners) {
        getChart().listeners = listeners;
    }

    /**
     * This setting affects touch-screen devices only. If a chart is on a page, and panEventsEnabled are set to true,
     * the page won't move if the user touches the chart first. If a chart is big enough and occupies all the screen
     * of your touch device, the user won’t be able to move the page at all. If you think that selecting/panning the
     * chart or moving/pinching the map is a primary purpose of your users, you should set panEventsEnabled to true,
     * otherwise - false. Default to true
     */
    public void setPanEventsEnabled(boolean panEventsEnabled) {
        getChart().panEventsEnabled = panEventsEnabled;
    }

    /**
     * Specifies absolute or relative path to amCharts files, i.e. "amcharts/". (where all .js files are located)
     * <p>
     * If relative URLs are used, they will be relative to the current web page, displaying the chart.
     * <p>
     * You can also set path globally, using global JavaScript variable AmCharts_path. If this variable is set,
     * and "path" is not set in chart config, the chart will assume the path from the global variable. This allows
     * setting amCharts path globally. I.e.:
     * <p>
     * <pre>
     * var AmCharts_path = "/libs/amcharts/";
     * </pre>
     * <p>
     * "path" parameter will be used by the charts to locate it's files, like images, plugins or patterns.
     * </p>
     */
    public void setPath(String path) {
        getChart().path = path;
    }

    /**
     * Specifies path to the folder where images like resize grips, lens and similar are.
     * <p>
     * MPORTANT: Since V3.14.12, you should use "path" to point to amCharts directory instead. The "pathToImages"
     * will be automatically set and does not need to be in the chart config, unless you keep your images separately
     * from other amCharts files. </p>
     */
    public void setPathToImages(String pathToImages) {
        getChart().pathToImages = pathToImages;
    }

    /**
     * Precision of percent values. -1 means percent values won't be rounded at all and show as they are. Default to 2
     */
    public void setPercentPrecision(int percentPrecision) {
        getChart().percentPrecision = percentPrecision;
    }

    /**
     * Precision of values. -1 means values won't be rounded at all and show as they are. Default to -1
     */
    public void setPrecision(int precision) {
        getChart().precision = precision;
    }

    /**
     * Prefixes which are used to make big numbers shorter: 2M instead of 2000000, etc. Prefixes are used on value
     * axes and in the legend. To enable prefixes, set usePrefixes property to true.
     */
    public void setPrefixesOfBigNumbers(Object... prefixesOfBigNumbers) {
        getChart().prefixesOfBigNumbers = prefixesOfBigNumbers;
    }

    /**
     * Prefixes which are used to make small numbers shorter: 2μ instead of 0.000002, etc. Prefixes are used on
     * value axes and in the legend. To enable prefixes, set usePrefixes property to true.
     */
    public void setPrefixesOfSmallNumbers(Object... prefixesOfSmallNumbers) {
        getChart().prefixesOfSmallNumbers = prefixesOfSmallNumbers;
    }

    /**
     * If processTimeout is > 0, 1000 data items will be parsed at a time, then the chart will make pause and continue
     * parsing data until it finishes. Default to 1000
     */
    public void setProcessCount(int processCount) {
        getChart().processCount = processCount;
    }

    /**
     * If you set it to 1 millisecond or some bigger value, chart will be built in chunks instead of all at once.
     * This is useful if you work with a lot of data and the initial build of the chart takes a lot of time, which
     * freezes the whole web application by not allowing other processes to do their job while the chart is busy.
     * Default to 0
     */
    public void setProcessTimeout(int processTimeout) {
        getChart().processTimeout = processTimeout;
    }

    /**
     * A config object for Responsive plugin. Please refer to the
     * <a href="http://www.amcharts.com/tutorials/making-charts-responsive/">following page</a> for more information.
     */
    public void setResponsive(Object responsive) {
        getChart().responsive = responsive;
    }

    /**
     * Charts will use SVG icons (some are loaded from images folder and some are drawn inline) if browser supports SVG.
     * his makes icons look good on retina displays on all resolutions. Default to true
     */
    public void setSvgIcons(boolean svgIcons) {
        getChart().svgIcons = svgIcons;
    }

    /**
     * Theme of a chart. Config files of themes can be found in amcharts/themes/ folder. More info about using
     * <a href="http://www.amcharts.com/tutorials/working-with-themes/">themes</a>. Default to "theme"
     */
    public void setTapToActivate(boolean tapToActivate) {
        getChart().tapToActivate = tapToActivate;
    }

    /**
     * Thousands separator. Default to comma(,).
     */
    public void setThousandsSeparator(String thousandsSeparator) {
        getChart().thousandsSeparator = thousandsSeparator;
    }

    /**
     * Array of {@link Title} objects.
     */
    public void setTitles(Title... titles) {
        getChart().titles = titles;
    }

    /**
     * If you set it to 200 (milliseconds) or so, the chart will fire clickGraphItem or clickSlice (AmSlicedChart) or
     * clickMapObject only if user holds his/her finger for 0.2 seconds (200 ms) on the column/bullet/slice/map object.
     * Default to 0
     */
    public void setTouchClickDuration(int touchClickDuration) {
        getChart().touchClickDuration = touchClickDuration;
    }

    /**
     * If true, prefixes will be used for big and small numbers. You can set arrays of prefixes via
     * prefixesOfSmallNumbers and prefixesOfBigNumbers properties. Default to false
     */
    public void setUsePrefixes(boolean usePrefixes) {
        getChart().usePrefixes = usePrefixes;
    }

    /**
     * Read-only. Indicates current version of a script.
     */
    public void setVersion(String version) {
        getChart().version = version;
    }

    /**
     * Adds a label on a chart. You can use it for labeling axes, adding chart title, etc. x and y coordinates can be
     * set in number, percent, or a number with ! in front of it - coordinate will be calculated from right or bottom
     * instead of left or top.
     *
     * @param x        horizontal coordinate
     * @param y        vertical coordinate
     * @param text     label's text align
     * @param align    (left/right/center)
     * @param size     text size color
     * @param color    text color
     * @param rotation angle of rotation
     * @param alpha    label alpha
     * @param bold     specifies if text is bold (true/false)
     * @param url      url of a label
     */
    public void addLabel(int x, int y, String text, String align, int size, String color, int rotation, double alpha, boolean bold, String url) {
        getChart().addLabel(x, y, text, align, size, color, rotation, alpha, bold, url);
    }

    /**
     * Adds a legend to the chart. By default, you don't need to create div for your legend, however if you want it to
     * be positioned in some different way, you can create div anywhere you want and pass id or reference to your div
     * as a second parameter. (NOTE: This method will not work on StockPanel.)
     *
     * @param legend          {@link AmLegend}
     * @param targetElementId id or reference to legend div
     */
    public void addLegend(Legend legend, String targetElementId) {
        getChart().addLegend(legend.getLegend(), targetElementId);
        legend.load();
    }


    public void addListener(String type, Functions.Func1<Object> handler) {
        getChart().addListener(type, handler);
    }

    /**
     * Adds title to the top of the chart. Pie, Radar positions are updated so that they won't overlap. Plot area of
     * Serial/XY chart is also updated unless autoMargins property is set to false. You can add any number of titles -
     * each of them will be placed in a new line. To remove titles, simply clear titles array: chart.titles = []; and
     * call chart.validateNow() method.
     *
     * @param text  text of a title
     * @param size  font size
     * @param color title color
     * @param alpha title opacity
     * @param bold  boolean value indicating if title should be bold
     */
    public void addTitle(String text, int size, String color, double alpha, boolean bold) {
        getChart().addTitle(text, size, color, alpha, bold);
    }

    /**
     * Removes all labels added to the chart.
     */
    public void clearLabels() {
        getChart().clearLabels();
    }

    /**
     * Use this method to force the chart to resize to it's current container size.
     */
    public void invalidateSize() {
        getChart().invalidateSize();
    }

    /**
     * This method allows to create charts with a single config.
     *
     * @param containerId id of a DIV or reference of the container element
     * @param config      contains the whole setup for the chart
     * @param delay       delay the initiation of the chart
     */
    public void makeChart(String containerId, JSONValue config, int delay) {
        getChart().makeChart(containerId, config, delay);
    }

    /**
     * Removes chart's legend.
     */
    public void removeLegend() {
        getChart().removeLegend();
    }

    /**
     * Removes event listener from chart object.
     *
     * @param object  chart object
     * @param type    event name
     * @param handler method called when listener has been called.
     */
    public void removeListener(AmChart object, String type, Functions.Func handler) {
        getChart().removeListener(object, type, handler);
    }

    /**
     * This method should be called after data in your data provider changed or a new array was set to dataProvider.
     * After calling this method the chart will parse data and redraw.
     */
    public void validateData() {
        getChart().validateData();
    }

    /**
     * This method should be called after you changed one or more properties of any class. The chart will redraw after
     * this method is called.Both attributes, validateData and skipEvents are optional (false by default).
     */
    public void validateNow(Object validateData, boolean skipEvents) {
        getChart().validateNow(validateData, skipEvents);
    }

    /**
     * Adds chart to the specified DIV.
     *
     * @param elementId id of a DIV or DIV object which will hold the chart
     */
    public void write(String elementId) {
        getChart().write(elementId);
    }

    /**
     * Font family. Default to Verdana
     */
    public void setFontFamily(String fontFamily) {
        getChart().fontFamily = fontFamily;
    }

    /**
     * Load any plugins in amchart {@link ChartPlugin}
     *
     * @param plugin
     */
    public void loadPlugin(ChartPlugin plugin) {
        ChartResourceLoader.loadPluginResource(plugin);
    }

    /**
     * A config object for Data Loader plugin. Please refer to the following page for more information.
     */
    public void setDataLoader(DataLoader loader) {
        loadPlugin(ChartPlugin.DATA_LOADER);
        getChart().dataLoader = loader.getDataLoader();
    }

    public abstract AmChart getChart();

    @Override
    public HandlerRegistration addAnimationFinishedHandler(AnimationFinishedEvent.AnimationFinishedHandler handler) {
        return addHandler(handler, AnimationFinishedEvent.getType());
    }

    @Override
    public HandlerRegistration addBuildStartedHandler(BuildStartedEvent.BuildStartedHandler handler) {
        return addHandler(handler, BuildStartedEvent.getType());
    }

    @Override
    public HandlerRegistration addDataUpdatedHandler(DataUpdatedEvent.DataUpdatedHandler handler) {
        return addHandler(handler, DataUpdatedEvent.getType());
    }

    @Override
    public HandlerRegistration addDrawnHandler(DrawnEvent.DrawnHandler handler) {
        return addHandler(handler, DrawnEvent.getType());
    }

    @Override
    public HandlerRegistration addInitHandler(InitEvent.InitHandler handler) {
        return addHandler(handler, InitEvent.getType());
    }

    @Override
    public HandlerRegistration addRenderedHandler(RenderedEvent.RenderedHandler handler) {
        return addHandler(handler, RenderedEvent.getType());
    }
}