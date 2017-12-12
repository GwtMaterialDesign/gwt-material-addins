package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.client.MaterialDesign;
import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.IsCoordinate;
import gwt.material.design.incubator.client.chart.amcharts.js.AmSerialChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Graph;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartThemeClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartTypeClientBundle;

public class SerialChart extends AbstractChart<AmSerialChart> implements IsCoordinate {

    static {
        MaterialDesign.injectJs(ChartTypeClientBundle.INSTANCE.serialJs());
        MaterialDesign.injectJs(ChartThemeClientBundle.INSTANCE.darkJs());
    }

    private AmSerialChart amSerialChart = AmSerialChart.create();

    public SerialChart() {
        super();
    }

    public void setCategoryField(String categoryField) {
        amSerialChart.categoryField = categoryField;
    }

    @Override
    public void addGraph(Graph graph) {
        amSerialChart.addGraph(graph);
    }

    @Override
    public AmSerialChart getChart() {
        return amSerialChart;
    }

    @Override
    public void setAngle(int angle) {
        amSerialChart.angle = angle;
    }

    @Override
    public void setAutoMarginOffset(int autoMarginOffset) {
        amSerialChart.autoMarginOffset = autoMarginOffset;
    }

    @Override
    public void setAutoMargins(boolean autoMargins) {
        amSerialChart.autoMargins = autoMargins;
    }

    @Override
    public void setMarginRight(int marginRight) {
        amSerialChart.marginRight = marginRight;
    }

    @Override
    public void setMarginTop(int marginTop) {
        amSerialChart.marginTop = marginTop;
    }
}
