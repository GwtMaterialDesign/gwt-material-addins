package gwt.material.design.incubator.client.chart.amcharts.events;

import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineClickEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineRollOutEvent;
import gwt.material.design.incubator.client.chart.amcharts.events.trendline.TrendLineRollOverEvent;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.TrendLine} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasTrendLineHandlers {

    /**
     * Dispatched when user clicks on a trend line.
     */
    void addTrendLineClickHandler(TrendLineClickEvent.TrendLineClickHandler handler);

    /**
     * Dispatched when user rolls out of a trend line.
     */
    void addTrendLineRollOutHandler(TrendLineRollOutEvent.TrendLineRollOutHandler handler);

    /**
     * Dispatched when user clicks rolls-over a trend line.
     */
    void addTrendLineRollOverHandler(TrendLineRollOverEvent.TrendLineRollOverHandler handler);
}
