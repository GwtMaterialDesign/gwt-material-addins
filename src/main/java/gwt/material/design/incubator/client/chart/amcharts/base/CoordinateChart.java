package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;

public abstract class CoordinateChart<T extends AmCoordinateChart> extends AbstractChart<T> {

    public void addGraph(AmGraph amGraph) {
        getChart().addGraph(amGraph);
    }
}
