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

import gwt.material.design.incubator.client.chart.amcharts.base.ISerialChart;
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
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
public class SerialChart extends RectangularChart implements ISerialChart {


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

    @Override
    public void setBalloonDateFormat(String balloonDateFormat) {
        getChart().balloonDateFormat = balloonDateFormat;
    }

    @Override
    public void setBezierX(int bezierX) {
        getChart().bezierX = bezierX;
    }

    @Override
    public void setBezierY(int bezierY) {
        getChart().bezierY = bezierY;
    }

    @Override
    public void setCategoryAxis(CategoryAxis categoryAxis) {
        getChart().categoryAxis = categoryAxis;
    }

    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }

    @Override
    public void setColumnSpacing(int columnSpacing) {
        getChart().columnSpacing = columnSpacing;
    }

    @Override
    public void setColumnSpacing3D(int columnSpacing3D) {
        getChart().columnSpacing3D = columnSpacing3D;
    }

    @Override
    public void setColumnWidth(double columnWidth) {
        getChart().columnWidth = columnWidth;
    }

    @Override
    public void setDataDateFormat(String dataDateFormat) {
        getChart().dataDateFormat = dataDateFormat;
    }

    @Override
    public void setEndDate(Date endDate) {
        getChart().endDate = endDate;
    }

    @Override
    public void setEndIndex(int endIndex) {
        getChart().endIndex = endIndex;
    }

    @Override
    public void setMaxSelectedSeries(int maxSelectedSeries) {
        getChart().maxSelectedSeries = maxSelectedSeries;
    }

    @Override
    public void setMaxSelectedTime(int maxSelectedSeries) {
        getChart().maxSelectedTime = maxSelectedSeries;
    }

    @Override
    public void setMinSelectedTime(int minSelectedTime) {
        getChart().minSelectedTime = minSelectedTime;
    }

    @Override
    public void setMouseWheelScrollEnabled(boolean mouseWheelScrollEnabled) {
        getChart().mouseWheelScrollEnabled = mouseWheelScrollEnabled;
    }

    @Override
    public void setMouseWheelZoomEnabled(boolean mouseWheelZoomEnabled) {
        getChart().mouseWheelZoomEnabled = mouseWheelZoomEnabled;
    }

    @Override
    public void setRotate(boolean rotate) {
        getChart().rotate = rotate;
    }

    @Override
    public void setStartDate(Date startDate) {
        getChart().startDate = startDate;
    }

    @Override
    public void setStartIndex(int startIndex) {
        getChart().startIndex = startIndex;
    }

    @Override
    public void setValueScrollbar(ChartScrollbar valueScrollbar) {
        getChart().valueScrollbar = valueScrollbar;
    }

    @Override
    public void setZoomOutOnDataUpdate(boolean zoomOutOnDataUpdate) {
        getChart().zoomOutOnDataUpdate = zoomOutOnDataUpdate;
    }

    @Override
    public int getCategoryIndexByValue(Object value) {
        return getChart().getCategoryIndexByValue(value);
    }

    @Override
    public void zoomOut() {
        getChart().zoomOut();
    }

    @Override
    public void zoomToCategoryValues(String start, String end) {
        getChart().zoomToCategoryValues(start, end);
    }

    @Override
    public void zoomToDates(Date start, Date end) {
        getChart().zoomToDates(start, end);
    }

    @Override
    public void zoomToIndexes(int start, int end) {
        getChart().zoomToIndexes(start, end);
    }
}
