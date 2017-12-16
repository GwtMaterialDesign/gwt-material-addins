package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.client.MaterialDesign;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmSerialChart;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartThemeClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartTypeClientBundle;

public class SerialChart extends RectangularChart {

    static {
        MaterialDesign.injectJs(ChartTypeClientBundle.INSTANCE.serialJs());
        MaterialDesign.injectJs(ChartThemeClientBundle.INSTANCE.darkJs());
    }

    protected AmSerialChart chart;

    public SerialChart() {
        super();
        setType(ChartType.SERIAL);
    }

    @Override
    public AmSerialChart getChart() {
        if (chart == null) {
            chart = new AmSerialChart();
        }
        return chart;
    }

    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }
}
