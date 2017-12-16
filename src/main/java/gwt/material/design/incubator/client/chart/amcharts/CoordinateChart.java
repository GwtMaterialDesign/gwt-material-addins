package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.IsCoordinate;
import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

public abstract class CoordinateChart extends AbstractChart implements IsCoordinate {


    public CoordinateChart() {
        super();
    }


    @Override
    public void setChartData(Object[] chartData) {

    }

    @Override
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    @Override
    public void setAmGraphs(AmGraph[] amGraphs) {

    }

    @Override
    public void setGridAboveGraphs(boolean gridAboveGraphs) {

    }

    @Override
    public void setGuides(Guide[] guides) {

    }

    @Override
    public void setSequencedAnimation(boolean value) {

    }

    @Override
    public void setStartDuration(double value) {

    }

    @Override
    public void setStartEffect(String startEffect) {

    }

    @Override
    public void setStartAlpha(double value) {

    }

    @Override
    public void setUrlTarget(String target) {

    }

    @Override
    public void setValueAxes(ValueAxis valueAxis) {

    }

    @Override
    public void addGraph(AmGraph amGraph) {
        getChart().addGraph(amGraph);
    }

    @Override
    public void addValueAxis(ValueAxis valueAxis) {

    }

    @Override
    public void animateAgain() {

    }

    @Override
    public AmGraph getGraphById(String id) {
        return null;
    }

    @Override
    public ValueAxis getValueAxisById(String id) {
        return null;
    }

    @Override
    public void hideGraph(AmGraph amGraph) {

    }

    @Override
    public void hideGraphsBalloon(AmGraph amGraph) {

    }

    @Override
    public void highlightGraph(AmGraph amGraph) {

    }

    @Override
    public void removeGraph(AmGraph amGraph) {

    }

    @Override
    public void removeValueAxis(ValueAxis valueAxis) {

    }

    @Override
    public void showGraph(AmGraph amGraph) {

    }

    @Override
    public void showGraphsBalloon(AmGraph amGraph) {

    }

    @Override
    public void unhighlightGraph(AmGraph amGraph) {

    }

    public abstract AmCoordinateChart getChart();
}
