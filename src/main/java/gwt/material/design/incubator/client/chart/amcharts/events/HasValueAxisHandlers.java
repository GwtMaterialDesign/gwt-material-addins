package gwt.material.design.incubator.client.chart.amcharts.events;

import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.AxisChangedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.AxisZoomedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.valueaxis.LogarithmicAxisFailedEvent;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.ValueAxis} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasValueAxisHandlers {

    /**
     * Dispatched when value axis min/max values are changed.
     */
    void addAxisChangedHandler(AxisChangedEvent.AxisChangedHandler handler);

    /**
     * Dispatched when axis is zoomed.
     */
    void addAxisZoomedHandler(AxisZoomedEvent.AxisZoomedHandler handler);

    /**
     * Dispatched when valueAxis is logarithmic and values equal or less then zero were found in data.
     */
    void addLogarithmicAxisFailedHandler(LogarithmicAxisFailedEvent.LogarithmicAxisFailedHandler handler);
}
