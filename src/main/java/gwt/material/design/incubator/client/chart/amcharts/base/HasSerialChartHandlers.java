package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.events.ChangedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.ZoomedEvent;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasSerialChartHandlers {

    /**
     * Dispatched when cursor position is changed. "index" is a series index over which chart cursors currently is.
     * "zooming" specifies if user is currently zooming (is selecting) the chart.
     */
    void addChangedHandler(ChangedEvent.ChangedHandler handler);

    /**
     * Dispatched when the chart is zoomed (even for the first time, when chart is initialized)
     */
    void addZoomedHandler(ZoomedEvent.ZoomedHandler handler);
}
