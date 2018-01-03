/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
import gwt.material.design.incubator.client.chart.amcharts.js.AmGanttChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

//@formatter:off

/**
 * Extension for AmSerialChart to gantt charts. Gantt charts usually display multiple bars on one series where value
 * axis displays date/time and is horizontal.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmGanttChart">Official Documentation</a>
 */
//@formatter:on
public class GanttChart extends SerialChart {


    public GanttChart() {
        super(ChartType.GANTT);
    }

    /**
     * Lightness increase of each subsequent bar of one series. Value range is from -255 to 255.
     */
    public void setBrightnessStep(int brightnessStep) {
        getChart().brightnessStep = brightnessStep;
    }

    /**
     * Field of column width of a segments in your data provider.
     */
    public void setColumnWidthField(String columnWidthField) {
        getChart().columnWidthField = columnWidthField;
    }

    /**
     * Instead of specifying end date or end value in your data, you can specify duration of a segment.
     */
    public void setDurationField(String durationField) {
        getChart().durationField = durationField;
    }

    /**
     * Field in your data provider which holds end date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    public void setEndDateField(String endDateField) {
        getChart().endDateField = endDateField;
    }

    /**
     * Field in your data provider which holds end value of a segment. If your data is date-based, you should use
     * endDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * endField and set number of periods instead of providing exact end date.
     */
    public void setEndField(String endField) {
        getChart().endField = endField;
    }

    /**
     * Graph of a Gantt chart. Gant chart actually creates multiple graphs (separate for each segment). Properties of
     * this graph are passed to each of the created graphs - this allows you to control the look of segments.
     */
    public void setGraph(AmGraph graph) {
        getChart().graph = graph;
    }

    /**
     * Data period. Used only value axis is date-based.
     */
    public void setPeriod(String period) {
        getChart().period = period;
    }

    /**
     * Segments field in your data provider.
     */
    public void setSegmentsField(String segmentsField) {
        getChart().segmentsField = segmentsField;
    }

    /**
     * Field in your data provider which holds start date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    public void setStartDateField(String startDateField) {
        getChart().startDateField = startDateField;
    }

    /**
     * Field in your data provider which holds start value of a segment. If your data is date-based, you should use
     * startDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * startField and set number of periods instead of providing exact start date.
     */
    public void setStartField(String startField) {
        getChart().startField = startField;
    }

    /**
     * Value axis of Gantt chart. Set it's type to "date" if your data is date or time based.
     */
    public void setValueAxis(ValueAxis valueAxis) {
        getChart().valueAxis = valueAxis;
    }

    @Override
    public AmGanttChart getChart() {
        return new AmGanttChart();
    }
}
