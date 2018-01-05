package gwt.material.design.incubator.client.chart.amcharts.events;

//@formatter:off

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.events.cursor.*;

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.options.ChartCursor} event handlers
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasCursorHandlers {

    /**
     * Dispatched when cursor position is changed. "index" is a series index over which chart cursors currently is.
     * "zooming" specifies if user is currently zooming (is selecting) the chart. mostCloseGraph property is set only
     * when oneBalloonOnly is set to true.
     */
    HandlerRegistration addChangedHandler(CursorChangedEvent.CursorChangedHandler handler);

    /**
     * Dispatched when user draws a trend line with mouse.
     */
    HandlerRegistration addDrawHandler(CursorDrawEvent.CursorDrawHandler handler);

    /**
     * Dispatched when mouse is moved over the chart. X and Y are coordinates of the mouse, relative to the plot area
     * of the chart.
     */
    HandlerRegistration addMovedHandler(CursorMovedEvent.CursorMovedHandler handler);

    /**
     * Dispatched when cursor is hidden.
     */
    HandlerRegistration addOnHideCursorHandler(OnHideCursorEvent.OnHideCursorHandler handler);

    /**
     * Dispatched when cursor is shown.
     */
    HandlerRegistration addOnShowCursorHandler(OnShowCursorEvent.OnShowCursorHandler handler);

    /**
     * Dispatched when user pans the chart (also when user pinch-zooms the chart). deltaX, deltaY, delta2X, delta2Y are
     * relative values. delta2X and delta2Y has values when pinching with two fingers.
     */
    HandlerRegistration addPanningHandler(CursorPanningEvent.CursorPanningHandler handler);

    /**
     * Dispatched if selectWithoutZooming is set to true and when user selects some period. start and end are indices or
     * time stamp (when categoryAxis.parseDates is true) of selection start/end.
     */
    HandlerRegistration addSelectedHandler(CursorSelectedEvent.CursorSelectedHandler handler);

    /**
     * Dispatched when user zooms to some period. start and end are indices or time stamp (when categoryAxis.parseDates
     * is true) of selection start/end.
     */
    HandlerRegistration addZoomedHandler(CursorZoomedEvent.CursorZoomedHandler handler);

    /**
     * Dispatched when user starts selecting chart area to zoom-in. x and y are relative values (0-1). Index is current
     * category index (of Serial chart)
     */
    HandlerRegistration addZoomStartedHandler(CursorZoomStartedEvent.CursorZoomStartedHandler handler);
}
