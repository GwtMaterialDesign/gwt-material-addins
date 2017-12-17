package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.ICoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

public abstract class CoordinateChart extends AbstractChart implements ICoordinateChart {

    @Override
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    @Override
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    @Override
    public void setAmGraphs(AmGraph... amGraphs) {
        getChart().amGraphs = amGraphs;
    }

    @Override
    public void setGridAboveGraphs(boolean gridAboveGraphs) {
        getChart().gridAboveGraphs = gridAboveGraphs;
    }

    @Override
    public void setGuides(Guide... guides) {
        getChart().guides = guides;
    }

    @Override
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    @Override
    public void setStartDuration(double startDuration) {
        getChart().startDuration = startDuration;
    }

    @Override
    public void setStartEffect(String startEffect) {
        getChart().startEffect = startEffect;
    }

    @Override
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    @Override
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    @Override
    public void setValueAxes(ValueAxis valueAxes) {
        getChart().valueAxes = valueAxes;
    }

    @Override
    public void addGraph(AmGraph amGraph) {
        getChart().addGraph(amGraph);
    }

    @Override
    public void addValueAxis(ValueAxis valueAxis) {
        getChart().addValueAxis(valueAxis);
    }

    @Override
    public void animateAgain() {
        getChart().animateAgain();
    }

    @Override
    public AmGraph getGraphById(String id) {
        return getChart().getGraphById(id);
    }

    @Override
    public ValueAxis getValueAxisById(String id) {
        return getChart().getValueAxisById(id);
    }

    @Override
    public void hideGraph(AmGraph amGraph) {
        getChart().hideGraph(amGraph);
    }

    @Override
    public void hideGraphsBalloon(AmGraph amGraph) {
        getChart().hideGraphsBalloon(amGraph);
    }

    @Override
    public void highlightGraph(AmGraph amGraph) {
        getChart().highlightGraph(amGraph);
    }

    @Override
    public void removeGraph(AmGraph amGraph) {
        getChart().removeGraph(amGraph);
    }

    @Override
    public void removeValueAxis(ValueAxis valueAxis) {
        getChart().removeValueAxis(valueAxis);
    }

    @Override
    public void showGraph(AmGraph amGraph) {
        getChart().showGraph(amGraph);
    }

    @Override
    public void showGraphsBalloon(AmGraph amGraph) {
        getChart().showGraphsBalloon(amGraph);
    }

    @Override
    public void unhighlightGraph(AmGraph amGraph) {
        getChart().unhighlightGraph(amGraph);
    }

    @Override
    public abstract AmCoordinateChart getChart();
}
