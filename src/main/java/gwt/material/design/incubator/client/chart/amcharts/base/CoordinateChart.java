package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Graph;

public abstract class CoordinateChart<T extends AmCoordinateChart> extends AbstractChart<T> {

    public void addGraph(Graph graph) {
        getChart().addGraph(graph);
    }
}
