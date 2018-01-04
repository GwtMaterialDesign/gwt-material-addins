package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.events.*;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.AxisBase} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasAxisHandler {

    /**
     * Dispatched when user clicks on a guide.
     */
    void addClickGuideHandler(ClickGuideEvent.ClickGuideHandler handler);

    /**
     * Fired if user clicks on axis label.
     */
    void addClickItemHandler(ClickItemEvent.ClickItemHandler handler);

    /**
     * Dispatched when user rolls-out of the guide.
     */
    void addRollOutGuideHandler(RollOutGuideEvent.RollOutGuideHandler handler);

    /**
     * Fired if user rolls-out of the axis label.
     */
    void addRollOutItemHandler(RollOutGuideItemEvent.RollOutGuideItemHandler handler);

    /**
     * Dispatched when user rolls-over some guide.
     */
    void addRollOverGuideHandler(RollOverGuideEvent.RollOverGuideHandler handler);

    /**
     * Fired if user rolls-over axis label.
     */
    void addRollOverItemHandler(RollOverGuideItemEvent.RollOverGuideItemHandler handler);
}
