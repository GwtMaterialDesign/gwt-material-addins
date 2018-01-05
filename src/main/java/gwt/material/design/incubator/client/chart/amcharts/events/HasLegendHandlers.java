package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.events.legend.*;

//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.Legend} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasLegendHandlers {

    /**
     * Dispatched when legend label is clicked.
     */
    HandlerRegistration addClickLabelHandler(ClickLabelEvent.ClickLabelHandler handler);

    /**
     * Dispatched when legend marker is clicked.
     */
    HandlerRegistration addClickMarkerHandler(ClickMarkerEvent.ClickMarkerHandler handler);

    /**
     * Dispatched when user clicks on a legend item marker and hides corresponding object.
     */
    HandlerRegistration addHideItemHandler(HideItemEvent.HideItemHandler handler);

    /**
     * Dispatched when user rolls-out of the legend item label (or whole item, if switchable is set to false).
     */
    HandlerRegistration addRollOutItemHandler(RollOutItemEvent.RollOutItemHandler handler);

    /**
     * Dispatched when user rolls-over the legend item label (or whole item, if switchable is set to false).
     */
    HandlerRegistration addRollOverItemHandler(RollOverItemEvent.RollOverItemHandler handler);

    /**
     * Dispatched when user rolls-over the legend item marker.
     */
    HandlerRegistration addRollOverMarkerHandler(RollOverMarkerEvent.RollOverMarkerHandler handler);

    /**
     * Dispatched when user clicks on a legend item marker and shows corresponding object.
     */
    HandlerRegistration addShowItemHandler(ShowItemEvent.ShowItemHandler handler);
}
