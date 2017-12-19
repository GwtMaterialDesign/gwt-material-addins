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
package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.ext.EventFunc4;
import gwt.material.design.incubator.client.chart.amcharts.js.ext.EventFunc7;
import gwt.material.design.incubator.client.chart.amcharts.js.options.CategoryAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

//@formatter:off

/**
 * Extension for AmRectangularChart to create line, area, column, bar, step line, smoothed line, candlestick and OHLC
 * charts. The charts support multiple axes with simple or logarithmic scales, the data points can be displayed at equal / irregular intervals or on timeline basis.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmSerialChart extends AmRectangularChart {

    /**
     * Date format of the graph balloon (if chart parses dates and you don't use chartCursor). Default to MMM DD, YYYY
     */
    @JsProperty
    public String balloonDateFormat;

    /**
     * Horizontal tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    @JsProperty
    public int bezierX;

    /**
     * Vertical tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    @JsProperty
    public int bezierY;

    /**
     * Read-only. Chart creates category axis itself. If you want to change some properties, you should get this axis
     * from the chart and set properties to this object.
     */
    @JsProperty
    public CategoryAxis categoryAxis;

    /**
     * Category field name tells the chart the name of the field in your dataProvider object which will be used for
     * category axis values.
     */
    @JsProperty
    public String categoryField;

    /**
     * The gap in pixels between two columns of the same category. Default to 5
     */
    @JsProperty
    public int columnSpacing;

    /**
     * Space between 3D stacked columns. Default to 0
     */
    @JsProperty
    public int columnSpacing3D;

    /**
     * Relative width of columns. Value range is 0 - 1. Default to 0.8
     */
    @JsProperty
    public double columnWidth;

    /**
     * Even if your chart parses dates, you can pass them as strings in your data – all you need to do is to set data
     * date format and the chart will parse dates to date objects. Check this page for available formats.
     * Please note that two-digit years (YY) as well as literal month names (MMM) are NOT supported in this setting.
     */
    @JsProperty
    public String dataDateFormat;

    /**
     * Read-only. If category axis parses dates endDate indicates date to which the chart is currently displayed.
     */
    @JsProperty
    public Date endDate;

    /**
     * Read-only. Category index to which the chart is currently displayed.
     */
    @JsProperty
    public int endIndex;

    /**
     * Maximum number of series allowed to select.
     */
    @JsProperty
    public int maxSelectedSeries;

    /**
     * The longest time span allowed to select (in milliseconds) for example, 259200000 will limit selection to 3 days.
     * Works if equalSpacing is set to false (default).
     */
    @JsProperty
    public int maxSelectedTime;

    /**
     * The shortest time span allowed to select (in milliseconds) for example, 1000 will limit selection to 1 second.
     * Works if equalSpacing is set to false (default). Default to 0
     */
    @JsProperty
    public int minSelectedTime;

    /**
     * Specifies if scrolling of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will zoom-in/out. Default to false
     */
    @JsProperty
    public boolean mouseWheelScrollEnabled;

    /**
     * Specifies if zooming of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will scroll. Default to false
     */
    @JsProperty
    public boolean mouseWheelZoomEnabled;

    /**
     * If you set this to true, the chart will be rotated by 90 degrees (the columns will become bars). Default to false
     */
    @JsProperty
    public boolean rotate;

    /**
     * Read-only. If category axis parses dates startDate indicates date from which the chart is currently displayed.
     */
    @JsProperty
    public Date startDate;

    /**
     * Read-only. Category index from which the chart is currently displayed.
     */
    @JsProperty
    public int startIndex;

    /**
     * Value scrollbar, enables scrolling value axes.
     */
    @JsProperty
    public ChartScrollbar valueScrollbar;

    /**
     * Specifies if chart should zoom-out when data is updated. Default to true
     */
    @JsProperty
    public boolean zoomOutOnDataUpdate;
    /**
     * Dispatched when cursor position is changed. "index" is a series index over which chart cursors currently is.
     * "zooming" specifies if user is currently zooming (is selecting) the chart.
     */
    @JsProperty
    public EventFunc4<String, Integer, Boolean, AmChart> changed;
    /**
     * Dispatched when the chart is zoomed (even for the first time, when chart is initialized)
     */
    @JsProperty
    public EventFunc7<Date, Integer, String, Date, Integer, String, AmChart> zoomed;

    /**
     * Returns index of the specified category value.
     */
    @JsMethod
    public native int getCategoryIndexByValue(Object value);

    /**
     * Zooms out, charts shows all available data.
     */
    @JsMethod
    public native void zoomOut();

    /**
     * Zooms the chart by the value of the category axis.
     */
    @JsMethod
    public native void zoomToCategoryValues(String start, String end);

    /**
     * Zooms the chart from one date to another.
     */
    @JsMethod
    public native void zoomToDates(Date start, Date end);

    /**
     * Zooms the chart by the index of the category.
     */
    @JsMethod
    public native void zoomToIndexes(int start, int end);
}
