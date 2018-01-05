package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.events.axis.*;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.AxisBase} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasAxisHandlers {

    /**
     * Dispatched when user clicks on a guide.
     */
    HandlerRegistration addClickGuideHandler(ClickGuideEvent.ClickGuideHandler handler);

    /**
     * Fired if user clicks on axis label.
     */
    HandlerRegistration addClickItemHandler(ClickItemEvent.ClickItemHandler handler);

    /**
     * Dispatched when user rolls-out of the guide.
     */
    HandlerRegistration addRollOutGuideHandler(RollOutGuideEvent.RollOutGuideHandler handler);

    /**
     * Fired if user rolls-out of the axis label.
     */
    HandlerRegistration addRollOutItemHandler(RollOutGuideItemEvent.RollOutGuideItemHandler handler);

    /**
     * Dispatched when user rolls-over some guide.
     */
    HandlerRegistration addRollOverGuideHandler(RollOverGuideEvent.RollOverGuideHandler handler);

    /**
     * Fired if user rolls-over axis label.
     */
    HandlerRegistration addRollOverItemHandler(RollOverGuideItemEvent.RollOverGuideItemHandler handler);
}
