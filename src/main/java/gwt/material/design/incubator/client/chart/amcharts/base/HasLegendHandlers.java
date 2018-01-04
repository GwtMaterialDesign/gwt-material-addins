package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.events.*;

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
    void addClickLabelHandler(ClickLabelEvent.ClickLabelHandler handler);

    /**
     * Dispatched when legend marker is clicked.
     */
    void addClickMarkerHandler(ClickMarkerEvent.ClickMarkerHandler handler);

    /**
     * Dispatched when user clicks on a legend item marker and hides corresponding object.
     */
    void addHideItemHandler(HideItemEvent.HideItemHandler handler);

    /**
     * Dispatched when user rolls-out of the legend item label (or whole item, if switchable is set to false).
     */
    void addRollOutItemHandler(RollOutItemEvent.RollOutItemHandler handler);

    /**
     * Dispatched when user rolls-over the legend item label (or whole item, if switchable is set to false).
     */
    void addRollOverItemHandler(RollOverItemEvent.RollOverItemHandler handler);

    /**
     * Dispatched when user rolls-over the legend item marker.
     */
    void addRollOverMarkerHandler(RollOverMarkerEvent.RollOverMarkerHandler handler);

    /**
     * Dispatched when user clicks on a legend item marker and shows corresponding object.
     */
    void addShowItemHandler(ShowItemEvent.ShowItemHandler handler);
}
