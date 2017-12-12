package gwt.material.design.incubator.client.chart.amcharts.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface ChartTypeClientBundle extends ClientBundle {

    ChartTypeClientBundle INSTANCE = GWT.create(ChartTypeClientBundle.class);

    @Source("js/charts/serial.js")
    TextResource serialJs();

    @Source("js/charts/funnel.js")
    TextResource funnelJs();

    @Source("js/charts/gantt.js")
    TextResource ganttJs();

    @Source("js/charts/gauge.js")
    TextResource gaugeJs();

    @Source("js/charts/pie.js")
    TextResource pieJs();

    @Source("js/charts/radar.js")
    TextResource radarJs();

    @Source("js/charts/xy.js")
    TextResource xyJs();
}
