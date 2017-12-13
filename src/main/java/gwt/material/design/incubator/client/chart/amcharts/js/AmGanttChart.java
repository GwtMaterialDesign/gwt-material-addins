package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, namespace = "AmCharts")
public class AmGanttChart extends AmSerialChart {

    @JsProperty
    public int brightnessStep;

    @JsProperty
    public String columnWidthField;

    @JsProperty
    public String durationField;

    @JsProperty
    public String endDateField;

    @JsProperty
    public String endField;

    @JsProperty
    public AmGraph amGraph;

    @JsProperty
    public String period;

    @JsProperty
    public String segmentsField;

    @JsProperty
    public Date startDate;

    @JsProperty
    public String startDateField;

    @JsProperty
    public String startField;

    @JsProperty
    public ValueAxis valueAxis;
}
