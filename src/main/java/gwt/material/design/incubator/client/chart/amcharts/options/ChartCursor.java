package gwt.material.design.incubator.client.chart.amcharts.options;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.CursorPosition;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasCursorHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.cursor.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.*;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmChartCursor;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Creates a cursor for the chart which follows the mouse movements. In case of
 * {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} charts it shows the
 * balloons of hovered data points.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ChartCursor">Official Documentation</a>
 */
//@formatter:on
public class ChartCursor extends ChartOptions implements HasCursorHandlers {

    private AmChartCursor chartCursor;

    @Override
    public void load() {

        Listener changedEvent = new Listener();
        changedEvent.setEvent(AmChartEvents.CHANGED);
        changedEvent.setMethod(object -> CursorChangedEvent.fire(this, (CursorChangedData) object));

        Listener drawEvent = new Listener();
        drawEvent.setEvent(AmChartEvents.DRAW);
        drawEvent.setMethod(object -> CursorDrawEvent.fire(this, (DrawData) object));

        Listener movedEvent = new Listener();
        movedEvent.setEvent(AmChartEvents.MOVED);
        movedEvent.setMethod(object -> CursorMovedEvent.fire(this, (MovedData) object));

        Listener onHideCursorEvent = new Listener();
        onHideCursorEvent.setEvent(AmChartEvents.ON_HIDE_CURSOR);
        onHideCursorEvent.setMethod(object -> OnHideCursorEvent.fire(this, (CursorDisplayData) object));

        Listener onShowCursorEvent = new Listener();
        onShowCursorEvent.setEvent(AmChartEvents.ON_SHOW_CURSOR);
        onShowCursorEvent.setMethod(object -> OnShowCursorEvent.fire(this, (CursorDisplayData) object));

        Listener panningEvent = new Listener();
        panningEvent.setEvent(AmChartEvents.PANNING);
        panningEvent.setMethod(object -> CursorPanningEvent.fire(this, (CursorPanningData) object));

        Listener selectedEvent = new Listener();
        selectedEvent.setEvent(AmChartEvents.SELECTED);
        selectedEvent.setMethod(object -> CursorSelectedEvent.fire(this, (CursorSelectedData) object));

        Listener zoomedEvent = new Listener();
        zoomedEvent.setEvent(AmChartEvents.ZOOMED);
        zoomedEvent.setMethod(object -> CursorZoomedEvent.fire(this, (CursorZoomedData) object));

        Listener zoomStartedEvent = new Listener();
        zoomStartedEvent.setEvent(AmChartEvents.ZOOM_STARTED);
        zoomStartedEvent.setMethod(object -> CursorZoomStartedEvent.fire(this, (CursorZoomStartedData) object));

        setListeners(changedEvent, drawEvent, movedEvent, onHideCursorEvent, onShowCursorEvent, panningEvent, selectedEvent, zoomedEvent, zoomStartedEvent);
    }

    @Override
    public void unload() {
        // TODO Unload Events
    }

    public int getAdjustment() {
        return getAmChartCursor().adjustment;
    }

    /**
     * If you set adjustment to -1, the balloon will be shown near previous, if you set it to 1 - near next data point.
     * Default to 0
     */

    public void setAdjustment(int adjustment) {
        getAmChartCursor().adjustment = adjustment;
    }

    public double getAnimationDuration() {
        return getAmChartCursor().animationDuration;
    }

    /**
     * Duration of animation of a line, in seconds. Default to 0.3
     */

    public void setAnimationDuration(double animationDuration) {
        getAmChartCursor().animationDuration = animationDuration;
    }

    public boolean isAvoidBalloonOverlapping() {
        return getAmChartCursor().avoidBalloonOverlapping;
    }

    /**
     * Specifies if cursor should arrange balloons so they won't overlap. If chart is rotated, it might be good idea to
     * turn this off. Default to true
     */

    public void setAvoidBalloonOverlapping(boolean avoidBalloonOverlapping) {
        getAmChartCursor().avoidBalloonOverlapping = avoidBalloonOverlapping;
    }

    public String getBalloonPointerOrientation() {
        return getAmChartCursor().balloonPointerOrientation;
    }

    /**
     * Defines if the balloon should be shown above the datapoint or sideways. Default to
     * {@link gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation#HORIZONTAL}
     */

    public void setBalloonPointerOrientation(Orientation balloonPointerOrientation) {
        getAmChartCursor().balloonPointerOrientation = balloonPointerOrientation.getName();
    }

    public boolean isBulletsEnabled() {
        return getAmChartCursor().bulletsEnabled;
    }

    /**
     * Specifies if bullet for each graph will follow the cursor. Default to false
     */

    public void setBulletsEnabled(boolean bulletsEnabled) {
        getAmChartCursor().bulletsEnabled = bulletsEnabled;
    }

    public int getBulletSize() {
        return getAmChartCursor().bulletSize;
    }

    /**
     * Size of bullets, following the cursor. Default to 8
     */

    public void setBulletSize(int bulletSize) {
        getAmChartCursor().bulletSize = bulletSize;
    }

    public double getCategoryBalloonAlpha() {
        return getAmChartCursor().categoryBalloonAlpha;
    }

    /**
     * Opacity of the category balloon. Default to 1
     */

    public void setCategoryBalloonAlpha(double categoryBalloonAlpha) {
        getAmChartCursor().categoryBalloonAlpha = categoryBalloonAlpha;
    }

    public String getCategoryBalloonColor() {
        return getAmChartCursor().categoryBalloonColor;
    }

    /**
     * Color of the category balloon. cursorColor is used if not set.
     */

    public void setCategoryBalloonColor(String categoryBalloonColor) {
        getAmChartCursor().categoryBalloonColor = categoryBalloonColor;
    }

    public String getCategoryBalloonDateFormat() {
        return getAmChartCursor().categoryBalloonDateFormat;
    }

    /**
     * Category balloon date format (used only if category axis parses dates). Check this page for instructions on how
     * to format dates.
     */

    public void setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        getAmChartCursor().categoryBalloonDateFormat = categoryBalloonDateFormat;
    }

    public boolean isCategoryBalloonEnabled() {
        return getAmChartCursor().categoryBalloonEnabled;
    }

    /**
     * Specifies whether category balloon is enabled. Default to true
     */

    public void setCategoryBalloonEnabled(boolean categoryBalloonEnabled) {
        getAmChartCursor().categoryBalloonEnabled = categoryBalloonEnabled;
    }

    public Functions.Func getCategoryBalloonFunction() {
        return getAmChartCursor().categoryBalloonFunction;
    }

    /**
     * Allows formatting any category balloon text you want. categoryBalloonFunction should return getAmChartCursor(). a string which will
     * be displayed in a balloon. When categoryBalloonFunction is called, category value (or date) is passed as an argument.
     */

    public void setCategoryBalloonFunction(Functions.Func categoryBalloonFunction) {
        getAmChartCursor().categoryBalloonFunction = categoryBalloonFunction;
    }

    public String getCategoryBalloonText() {
        return getAmChartCursor().categoryBalloonText;
    }

    /**
     * You can have [[category]] - [[toCategory]] tags in there and show category ranges this way. Default to [[category]]
     */

    public void setCategoryBalloonText(String categoryBalloonText) {
        getAmChartCursor().categoryBalloonText = categoryBalloonText;
    }

    public String getColor() {
        return getAmChartCursor().color;
    }

    /**
     * Text color. Default to #FFFFFF
     */

    public void setColor(String color) {
        getAmChartCursor().color = color;
    }

    public int getCursorAlpha() {
        return getAmChartCursor().cursorAlpha;
    }

    /**
     * Opacity of the cursor line. Default to 1
     */

    public void setCursorAlpha(int cursorAlpha) {
        getAmChartCursor().cursorAlpha = cursorAlpha;
    }

    public String getCursorColor() {
        return getAmChartCursor().cursorColor;
    }

    /**
     * Color of the cursor line. Default to #CC000
     */

    public void setCursorColor(String cursorColor) {
        getAmChartCursor().cursorColor = cursorColor;
    }

    public String getCursorPosition() {
        return getAmChartCursor().cursorPosition;
    }

    /**
     * Specifies where the cursor line should be placed - on the beginning of the period (day, hour, etc) or in the
     * middle (only when parseDates property of categoryAxis is set to true). If you want the cursor to follow mouse
     * and not to glue to the nearest data point, set "mouse" here. Possible values are: start, middle, mouse. Default
     * to {@link CursorPosition#MIDDLE}
     */

    public void setCursorPosition(CursorPosition cursorPosition) {
        getAmChartCursor().cursorPosition = cursorPosition.getName();
    }

    public boolean isEnabled() {
        return getAmChartCursor().enabled;
    }

    /**
     * Specifies whether cursor is enabled. Default true
     */

    public void setEnabled(boolean enabled) {
        getAmChartCursor().enabled = enabled;
    }

    public boolean isFullWidth() {
        return getAmChartCursor().fullWidth;
    }

    /**
     * If set to true, instead of a cursor line user will see a fill which width will always be equal to the width of
     * one data item. We'd recommend setting cursorAlpha to 0.1 or some other small number if using this feature.
     * Default to false.
     */

    public void setFullWidth(boolean fullWidth) {
        getAmChartCursor().fullWidth = fullWidth;
    }

    public double getGraphBulletAlpha() {
        return getAmChartCursor().graphBulletAlpha;
    }

    /**
     * If you make graph's bullets invisible by setting their opacity to 0 and will set graphBulletAlpha to 1, the
     * bullets will only appear at the cursor's position.
     */

    public void setGraphBulletAlpha(double graphBulletAlpha) {
        getAmChartCursor().graphBulletAlpha = graphBulletAlpha;
    }

    public int getGraphBulletSize() {
        return getAmChartCursor().graphBulletSize;
    }

    /**
     * Size of a graph's bullet (if available) at the cursor position. If you don't want the bullet to change it's size,
     * set this property to 1. Default to 1.7
     */

    public void setGraphBulletSize(int graphBulletSize) {
        getAmChartCursor().graphBulletSize = graphBulletSize;
    }

    public boolean isLeaveAfterTouch() {
        return getAmChartCursor().leaveAfterTouch;
    }

    /**
     * This makes cursor and balloons to remain after user touches the chart. Default to true
     */

    public void setLeaveAfterTouch(boolean leaveAfterTouch) {
        getAmChartCursor().leaveAfterTouch = leaveAfterTouch;
    }

    public boolean isLeaveCursor() {
        return getAmChartCursor().leaveCursor;
    }

    /**
     * Specifies if cursor should be left at it's last position. Useful for touch devices - user might want to see the
     * balloons after he moves finger away. Default to false
     */

    public void setLeaveCursor(boolean leaveCursor) {
        getAmChartCursor().leaveCursor = leaveCursor;
    }

    public String getLimitToGraph() {
        return getAmChartCursor().limitToGraph;
    }

    /**
     * If set to an id or a reference to AmGraph object, CategoryAxis cursor line will be limited to this graph instead
     * of being drawn through full height of plot area. Note, this works with serial chart only. Also, cursorPosition of
     * ChartCursor must be set to middle.
     */

    public void setLimitToGraph(String limitToGraph) {
        getAmChartCursor().limitToGraph = limitToGraph;
    }

    public Object[] getListeners() {
        return getAmChartCursor().listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners =
     * [{"event":"changed", "method":handleEvent}];
     */

    public void setListeners(Listener... listeners) {
        getAmChartCursor().listeners = listeners;
    }

    public boolean isOneBalloonOnly() {
        return getAmChartCursor().oneBalloonOnly;
    }

    /**
     * If this is set to true, only one balloon at a time will be displayed. Note, this is quite CPU consuming. Default
     * to false
     */

    public void setOneBalloonOnly(boolean oneBalloonOnly) {
        getAmChartCursor().oneBalloonOnly = oneBalloonOnly;
    }

    public boolean isPan() {
        return getAmChartCursor().pan;
    }

    /**
     * If this is set to true, the user will be able to pan the chart instead of zooming. Default to false
     */

    public void setPan(boolean pan) {
        getAmChartCursor().pan = pan;
    }

    public double getSelectionAlpha() {
        return getAmChartCursor().selectionAlpha;
    }

    /**
     * Opacity of the selection. Default to 0.2
     */

    public void setSelectionAlpha(double selectionAlpha) {
        getAmChartCursor().selectionAlpha = selectionAlpha;
    }

    public boolean isSelectWithoutZooming() {
        return getAmChartCursor().selectWithoutZooming;
    }

    /**
     * Specifies if cursor should only mark selected area but not zoom-in after user releases mouse button. Default
     * to false
     */

    public void setSelectWithoutZooming(boolean selectWithoutZooming) {
        getAmChartCursor().selectWithoutZooming = selectWithoutZooming;
    }

    public boolean isShowNextAvailable() {
        return getAmChartCursor().showNextAvailable;
    }

    /**
     * If true, the graph will display balloon on next available data point if currently hovered item doesn't have value
     * for this graph. Default to false
     */

    public void setShowNextAvailable(boolean showNextAvailable) {
        getAmChartCursor().showNextAvailable = showNextAvailable;
    }

    public int getTabIndex() {
        return getAmChartCursor().tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on chart cursor (works only with serial chart) when
     * user clicks tab key. When a focus is set user can move cursor using cursor keys. Note, not all browsers and
     * readers support getAmChartCursor().
     */

    public void setTabIndex(int tabIndex) {
        getAmChartCursor().tabIndex = tabIndex;
    }

    public boolean isValueBalloonsEnabled() {
        return getAmChartCursor().valueBalloonsEnabled;
    }

    /**
     * Specifies whether value balloons are enabled. In case they are not, the balloons might be displayed anyway, when
     * the user rolls-over the column or bullet. Default to true
     */

    public void setValueBalloonsEnabled(boolean valueBalloonsEnabled) {
        getAmChartCursor().valueBalloonsEnabled = valueBalloonsEnabled;
    }

    public double getValueLineAlpha() {
        return getAmChartCursor().valueLineAlpha;
    }

    /**
     * Opacity of value line. Will use cursorAlpha value if not set. Default to false
     */

    public void setValueLineAlpha(double valueLineAlpha) {
        getAmChartCursor().valueLineAlpha = valueLineAlpha;
    }

    public boolean isValueLineBalloonEnabled() {
        return getAmChartCursor().valueLineBalloonEnabled;
    }

    /**
     * Specifies if value balloon next to value axes labels should be displayed. Default tot false
     */

    public void setValueLineBalloonEnabled(boolean valueLineBalloonEnabled) {
        getAmChartCursor().valueLineBalloonEnabled = valueLineBalloonEnabled;
    }

    public boolean isValueLineEnabled() {
        return getAmChartCursor().valueLineEnabled;
    }

    /**
     * Specifies if cursor of Serial chart should display horizontal (or vertical if chart is rotated) line.
     * This line might help users to compare distant values of a chart. You can also enable value balloons on
     * this line by setting valueLineBalloonEnabled to true. Default to false
     */

    public void setValueLineEnabled(boolean valueLineEnabled) {
        getAmChartCursor().valueLineEnabled = valueLineEnabled;
    }

    public boolean isValueZoomable() {
        return getAmChartCursor().valueZoomable;
    }

    /**
     * Specifies if the user can zoom-in value axess of a serial chart. Default to false
     */

    public void setValueZoomable(boolean valueZoomable) {
        getAmChartCursor().valueZoomable = valueZoomable;
    }

    public boolean isZoomable() {
        return getAmChartCursor().zoomable;
    }

    /**
     * Specifies if the user can zoom-in the chart. If pan is set to true, zoomable is switched to false automatically.
     * Default to true
     */

    public void setZoomable(boolean zoomable) {
        getAmChartCursor().zoomable = zoomable;
    }

    public boolean isZooming() {
        return getAmChartCursor().zooming;
    }

    /**
     * Read-only. Indicates if currently user is selecting some chart area to zoom-in.
     */

    public void setZooming(boolean zooming) {
        getAmChartCursor().zooming = zooming;
    }

    public AmChartCursor getAmChartCursor() {
        if (chartCursor == null) {
            chartCursor = new AmChartCursor();
        }
        return chartCursor;
    }

    @Override
    public HandlerRegistration addChangedHandler(CursorChangedEvent.CursorChangedHandler handler) {
        return addHandler(CursorChangedEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addDrawHandler(CursorDrawEvent.CursorDrawHandler handler) {
        return addHandler(CursorDrawEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addMovedHandler(CursorMovedEvent.CursorMovedHandler handler) {
        return addHandler(CursorMovedEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addOnHideCursorHandler(OnHideCursorEvent.OnHideCursorHandler handler) {
        return addHandler(OnHideCursorEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addOnShowCursorHandler(OnShowCursorEvent.OnShowCursorHandler handler) {
        return addHandler(OnShowCursorEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addPanningHandler(CursorPanningEvent.CursorPanningHandler handler) {
        return addHandler(CursorPanningEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addSelectedHandler(CursorSelectedEvent.CursorSelectedHandler handler) {
        return addHandler(CursorSelectedEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addZoomedHandler(CursorZoomedEvent.CursorZoomedHandler handler) {
        return addHandler(CursorZoomedEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addZoomStartedHandler(CursorZoomStartedEvent.CursorZoomStartedHandler handler) {
        return addHandler(CursorZoomStartedEvent.getType(), handler);
    }
}
