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
package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmSerialChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.CategoryAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;

import java.util.Date;

//@formatter:off

/**
 * Extension for {@link RectangularChart} to create line, area, column, bar, step line, smoothed line, candlestick and OHLC
 * charts. The charts support multiple axes with simple or logarithmic scales, the data points can be displayed at equal
 * / irregular intervals or on timeline basis.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmSerialChart">Official Documentation</a>
 */
//@formatter:on
public class SerialChart extends RectangularChart {


    protected AmSerialChart chart;

    public SerialChart() {
        super(ChartType.SERIAL);
    }

    public SerialChart(ChartType chartType) {
        super(chartType);
    }

    @Override
    public AmSerialChart getChart() {
        if (chart == null) {
            chart = new AmSerialChart();
        }
        return chart;
    }

    /**
     * Date format of the graph balloon (if chart parses dates and you don't use chartCursor). Default to MMM DD, YYYY
     */
    public void setBalloonDateFormat(String balloonDateFormat) {
        getChart().balloonDateFormat = balloonDateFormat;
    }

    /**
     * Horizontal tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    public void setBezierX(int bezierX) {
        getChart().bezierX = bezierX;
    }

    /**
     * Vertical tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    public void setBezierY(int bezierY) {
        getChart().bezierY = bezierY;
    }

    /**
     * Read-only. Chart creates category axis itself. If you want to change some properties, you should get this axis
     * from the chart and set properties to this object.
     */
    public void setCategoryAxis(CategoryAxis categoryAxis) {
        getChart().categoryAxis = categoryAxis;
    }

    /**
     * Category field name tells the chart the name of the field in your dataProvider object which will be used for
     * category axis values.
     */
    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }

    /**
     * The gap in pixels between two columns of the same category. Default to 5
     */
    public void setColumnSpacing(int columnSpacing) {
        getChart().columnSpacing = columnSpacing;
    }

    /**
     * Space between 3D stacked columns. Default to 0
     */
    public void setColumnSpacing3D(int columnSpacing3D) {
        getChart().columnSpacing3D = columnSpacing3D;
    }

    /**
     * Relative width of columns. Value range is 0 - 1. Default to 0.8
     */
    public void setColumnWidth(double columnWidth) {
        getChart().columnWidth = columnWidth;
    }

    /**
     * Even if your chart parses dates, you can pass them as strings in your data – all you need to do is to set data
     * date format and the chart will parse dates to date objects. Check this page for available formats.
     * Please note that two-digit years (YY) as well as literal month names (MMM) are NOT supported in this setting.
     */
    public void setDataDateFormat(String dataDateFormat) {
        getChart().dataDateFormat = dataDateFormat;
    }

    /**
     * Read-only. If category axis parses dates endDate indicates date to which the chart is currently displayed.
     */
    public void setEndDate(Date endDate) {
        getChart().endDate = endDate;
    }

    /**
     * Read-only. Category index to which the chart is currently displayed.
     */
    public void setEndIndex(int endIndex) {
        getChart().endIndex = endIndex;
    }

    /**
     * Maximum number of series allowed to select.
     */
    public void setMaxSelectedSeries(int maxSelectedSeries) {
        getChart().maxSelectedSeries = maxSelectedSeries;
    }

    /**
     * The longest time span allowed to select (in milliseconds) for example, 259200000 will limit selection to 3 days.
     * Works if equalSpacing is set to false (default).
     */
    public void setMaxSelectedTime(int maxSelectedSeries) {
        getChart().maxSelectedTime = maxSelectedSeries;
    }

    /**
     * The shortest time span allowed to select (in milliseconds) for example, 1000 will limit selection to 1 second.
     * Works if equalSpacing is set to false (default). Default to 0
     */
    public void setMinSelectedTime(int minSelectedTime) {
        getChart().minSelectedTime = minSelectedTime;
    }

    /**
     * Specifies if scrolling of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will zoom-in/out. Default to false
     */
    public void setMouseWheelScrollEnabled(boolean mouseWheelScrollEnabled) {
        getChart().mouseWheelScrollEnabled = mouseWheelScrollEnabled;
    }

    /**
     * Specifies if zooming of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will scroll. Default to false
     */
    public void setMouseWheelZoomEnabled(boolean mouseWheelZoomEnabled) {
        getChart().mouseWheelZoomEnabled = mouseWheelZoomEnabled;
    }

    /**
     * If you set this to true, the chart will be rotated by 90 degrees (the columns will become bars). Default to false
     */
    public void setRotate(boolean rotate) {
        getChart().rotate = rotate;
    }

    /**
     * Read-only. If category axis parses dates startDate indicates date from which the chart is currently displayed.
     */
    public void setStartDate(Date startDate) {
        getChart().startDate = startDate;
    }

    /**
     * Read-only. Category index from which the chart is currently displayed.
     */
    public void setStartIndex(int startIndex) {
        getChart().startIndex = startIndex;
    }

    /**
     * Value scrollbar, enables scrolling value axes.
     */
    public void setValueScrollbar(ChartScrollbar valueScrollbar) {
        getChart().valueScrollbar = valueScrollbar;
    }

    /**
     * Specifies if chart should zoom-out when data is updated. Default to true
     */
    public void setZoomOutOnDataUpdate(boolean zoomOutOnDataUpdate) {
        getChart().zoomOutOnDataUpdate = zoomOutOnDataUpdate;
    }

    /**
     * Returns index of the specified category value.
     */
    public int getCategoryIndexByValue(Object value) {
        return getChart().getCategoryIndexByValue(value);
    }

    /**
     * Zooms out, charts shows all available data.
     */
    public void zoomOut() {
        getChart().zoomOut();
    }

    /**
     * Zooms the chart by the value of the category axis.
     */
    public void zoomToCategoryValues(String start, String end) {
        getChart().zoomToCategoryValues(start, end);
    }

    /**
     * Zooms the chart from one date to another.
     */
    public void zoomToDates(Date start, Date end) {
        getChart().zoomToDates(start, end);
    }

    /**
     * Zooms the chart by the index of the category.
     */
    public void zoomToIndexes(int start, int end) {
        getChart().zoomToIndexes(start, end);
    }

    // TODO Events
}
