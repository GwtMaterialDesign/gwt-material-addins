package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IGanttChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGanttChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

public class GanttChart extends SerialChart implements IGanttChart {


    public GanttChart() {
        super(ChartType.GANTT);
    }

    @Override
    public void setBrightnessStep(int brightnessStep) {
        getChart().brightnessStep = brightnessStep;
    }

    @Override
    public void setColumnWidthField(String columnWidthField) {
        getChart().columnWidthField = columnWidthField;
    }

    @Override
    public void setDurationField(String durationField) {
        getChart().durationField = durationField;
    }

    @Override
    public void setEndDateField(String endDateField) {
        getChart().endDateField = endDateField;
    }

    @Override
    public void setEndField(String endField) {
        getChart().endField = endField;
    }

    @Override
    public void setGraph(AmGraph graph) {
        getChart().graph = graph;
    }

    @Override
    public void setPeriod(String period) {
        getChart().period = period;
    }

    @Override
    public void setSegmentsField(String segmentsField) {
        getChart().segmentsField = segmentsField;
    }

    @Override
    public void setStartDateField(String startDateField) {
        getChart().startDateField = startDateField;
    }

    @Override
    public void setStartField(String startField) {
        getChart().startField = startField;
    }

    @Override
    public void setValueAxis(ValueAxis valueAxis) {
        getChart().valueAxis = valueAxis;
    }

    @Override
    public AmGanttChart getChart() {
        return new AmGanttChart();
    }
}
