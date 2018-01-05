package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.events.serial.SerialChangedEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.serial.SerialZoomedEvent;

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
    HandlerRegistration addChangedHandler(SerialChangedEvent.SerialChangedHandler handler);

    /**
     * Dispatched when the chart is zoomed (even for the first time, when chart is initialized)
     */
    HandlerRegistration addZoomedHandler(SerialZoomedEvent.SerialZoomedHandler handler);
}
