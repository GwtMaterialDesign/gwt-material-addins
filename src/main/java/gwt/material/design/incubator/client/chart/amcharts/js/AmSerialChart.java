package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "AmCharts")
public class AmSerialChart extends AmRectangularChart {

    @JsProperty
    public String categoryField;

    private AmSerialChart() {}

    @JsOverlay
    public static final AmSerialChart create() {
        AmSerialChart defaults = new AmSerialChart();
        defaults.type = ChartType.SERIAL.getName();
        defaults.fontFamily = "Roboto";
        return defaults;
    }
}
