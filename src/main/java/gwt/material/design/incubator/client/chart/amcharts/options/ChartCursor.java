package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.CursorPosition;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmChartCursor;
import gwt.material.design.jquery.client.api.Functions;

public class ChartCursor extends ChartOptions {

    private AmChartCursor chartCursor = new AmChartCursor();

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    public int getAdjustment() {
        return chartCursor.adjustment;
    }

    /**
     * If you set adjustment to -1, the balloon will be shown near previous, if you set it to 1 - near next data point.
     * Default to 0
     */

    public void setAdjustment(int adjustment) {
        chartCursor.adjustment = adjustment;
    }

    public double getAnimationDuration() {
        return chartCursor.animationDuration;
    }

    /**
     * Duration of animation of a line, in seconds. Default to 0.3
     */

    public void setAnimationDuration(double animationDuration) {
        chartCursor.animationDuration = animationDuration;
    }

    public boolean isAvoidBalloonOverlapping() {
        return chartCursor.avoidBalloonOverlapping;
    }

    /**
     * Specifies if cursor should arrange balloons so they won't overlap. If chart is rotated, it might be good idea to
     * turn this off. Default to true
     */

    public void setAvoidBalloonOverlapping(boolean avoidBalloonOverlapping) {
        chartCursor.avoidBalloonOverlapping = avoidBalloonOverlapping;
    }

    public String getBalloonPointerOrientation() {
        return chartCursor.balloonPointerOrientation;
    }

    /**
     * Defines if the balloon should be shown above the datapoint or sideways. Default to
     * {@link gwt.material.design.incubator.client.chart.amcharts.base.constants.Orientation#HORIZONTAL}
     */

    public void setBalloonPointerOrientation(Orientation balloonPointerOrientation) {
        chartCursor.balloonPointerOrientation = balloonPointerOrientation.getName();
    }

    public boolean isBulletsEnabled() {
        return chartCursor.bulletsEnabled;
    }

    /**
     * Specifies if bullet for each graph will follow the cursor. Default to false
     */

    public void setBulletsEnabled(boolean bulletsEnabled) {
        chartCursor.bulletsEnabled = bulletsEnabled;
    }

    public int getBulletSize() {
        return chartCursor.bulletSize;
    }

    /**
     * Size of bullets, following the cursor. Default to 8
     */

    public void setBulletSize(int bulletSize) {
        chartCursor.bulletSize = bulletSize;
    }

    public double getCategoryBalloonAlpha() {
        return chartCursor.categoryBalloonAlpha;
    }

    /**
     * Opacity of the category balloon. Default to 1
     */

    public void setCategoryBalloonAlpha(double categoryBalloonAlpha) {
        chartCursor.categoryBalloonAlpha = categoryBalloonAlpha;
    }

    public String getCategoryBalloonColor() {
        return chartCursor.categoryBalloonColor;
    }

    /**
     * Color of the category balloon. cursorColor is used if not set.
     */

    public void setCategoryBalloonColor(String categoryBalloonColor) {
        chartCursor.categoryBalloonColor = categoryBalloonColor;
    }

    public String getCategoryBalloonDateFormat() {
        return chartCursor.categoryBalloonDateFormat;
    }

    /**
     * Category balloon date format (used only if category axis parses dates). Check this page for instructions on how
     * to format dates.
     */

    public void setCategoryBalloonDateFormat(String categoryBalloonDateFormat) {
        chartCursor.categoryBalloonDateFormat = categoryBalloonDateFormat;
    }

    public boolean isCategoryBalloonEnabled() {
        return chartCursor.categoryBalloonEnabled;
    }

    /**
     * Specifies whether category balloon is enabled. Default to true
     */

    public void setCategoryBalloonEnabled(boolean categoryBalloonEnabled) {
        chartCursor.categoryBalloonEnabled = categoryBalloonEnabled;
    }

    public Functions.Func getCategoryBalloonFunction() {
        return chartCursor.categoryBalloonFunction;
    }

    /**
     * Allows formatting any category balloon text you want. categoryBalloonFunction should return chartCursor. a string which will
     * be displayed in a balloon. When categoryBalloonFunction is called, category value (or date) is passed as an argument.
     */

    public void setCategoryBalloonFunction(Functions.Func categoryBalloonFunction) {
        chartCursor.categoryBalloonFunction = categoryBalloonFunction;
    }

    public String getCategoryBalloonText() {
        return chartCursor.categoryBalloonText;
    }

    /**
     * You can have [[category]] - [[toCategory]] tags in there and show category ranges this way. Default to [[category]]
     */

    public void setCategoryBalloonText(String categoryBalloonText) {
        chartCursor.categoryBalloonText = categoryBalloonText;
    }

    public String getColor() {
        return chartCursor.color;
    }

    /**
     * Text color. Default to #FFFFFF
     */

    public void setColor(String color) {
        chartCursor.color = color;
    }

    public int getCursorAlpha() {
        return chartCursor.cursorAlpha;
    }

    /**
     * Opacity of the cursor line. Default to 1
     */

    public void setCursorAlpha(int cursorAlpha) {
        chartCursor.cursorAlpha = cursorAlpha;
    }

    public String getCursorColor() {
        return chartCursor.cursorColor;
    }

    /**
     * Color of the cursor line. Default to #CC000
     */

    public void setCursorColor(String cursorColor) {
        chartCursor.cursorColor = cursorColor;
    }

    public String getCursorPosition() {
        return chartCursor.cursorPosition;
    }

    /**
     * Specifies where the cursor line should be placed - on the beginning of the period (day, hour, etc) or in the
     * middle (only when parseDates property of categoryAxis is set to true). If you want the cursor to follow mouse
     * and not to glue to the nearest data point, set "mouse" here. Possible values are: start, middle, mouse. Default
     * to {@link CursorPosition#MIDDLE}
     */

    public void setCursorPosition(CursorPosition cursorPosition) {
        chartCursor.cursorPosition = cursorPosition.getName();
    }

    public boolean isEnabled() {
        return chartCursor.enabled;
    }

    /**
     * Specifies whether cursor is enabled. Default true
     */

    public void setEnabled(boolean enabled) {
        chartCursor.enabled = enabled;
    }

    public boolean isFullWidth() {
        return chartCursor.fullWidth;
    }

    /**
     * If set to true, instead of a cursor line user will see a fill which width will always be equal to the width of
     * one data item. We'd recommend setting cursorAlpha to 0.1 or some other small number if using this feature.
     * Default to false.
     */

    public void setFullWidth(boolean fullWidth) {
        chartCursor.fullWidth = fullWidth;
    }

    public double getGraphBulletAlpha() {
        return chartCursor.graphBulletAlpha;
    }

    /**
     * If you make graph's bullets invisible by setting their opacity to 0 and will set graphBulletAlpha to 1, the
     * bullets will only appear at the cursor's position.
     */

    public void setGraphBulletAlpha(double graphBulletAlpha) {
        chartCursor.graphBulletAlpha = graphBulletAlpha;
    }

    public int getGraphBulletSize() {
        return chartCursor.graphBulletSize;
    }

    /**
     * Size of a graph's bullet (if available) at the cursor position. If you don't want the bullet to change it's size,
     * set this property to 1. Default to 1.7
     */

    public void setGraphBulletSize(int graphBulletSize) {
        chartCursor.graphBulletSize = graphBulletSize;
    }

    public boolean isLeaveAfterTouch() {
        return chartCursor.leaveAfterTouch;
    }

    /**
     * This makes cursor and balloons to remain after user touches the chart. Default to true
     */

    public void setLeaveAfterTouch(boolean leaveAfterTouch) {
        chartCursor.leaveAfterTouch = leaveAfterTouch;
    }

    public boolean isLeaveCursor() {
        return chartCursor.leaveCursor;
    }

    /**
     * Specifies if cursor should be left at it's last position. Useful for touch devices - user might want to see the
     * balloons after he moves finger away. Default to false
     */

    public void setLeaveCursor(boolean leaveCursor) {
        chartCursor.leaveCursor = leaveCursor;
    }

    public String getLimitToGraph() {
        return chartCursor.limitToGraph;
    }

    /**
     * If set to an id or a reference to AmGraph object, CategoryAxis cursor line will be limited to this graph instead
     * of being drawn through full height of plot area. Note, this works with serial chart only. Also, cursorPosition of
     * ChartCursor must be set to middle.
     */

    public void setLimitToGraph(String limitToGraph) {
        chartCursor.limitToGraph = limitToGraph;
    }

    public Object[] getListeners() {
        return chartCursor.listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners =
     * [{"event":"changed", "method":handleEvent}];
     */

    public void setListeners(Object[] listeners) {
        chartCursor.listeners = listeners;
    }

    public boolean isOneBalloonOnly() {
        return chartCursor.oneBalloonOnly;
    }

    /**
     * If this is set to true, only one balloon at a time will be displayed. Note, this is quite CPU consuming. Default
     * to false
     */

    public void setOneBalloonOnly(boolean oneBalloonOnly) {
        chartCursor.oneBalloonOnly = oneBalloonOnly;
    }

    public boolean isPan() {
        return chartCursor.pan;
    }

    /**
     * If this is set to true, the user will be able to pan the chart instead of zooming. Default to false
     */

    public void setPan(boolean pan) {
        chartCursor.pan = pan;
    }

    public double getSelectionAlpha() {
        return chartCursor.selectionAlpha;
    }

    /**
     * Opacity of the selection. Default to 0.2
     */

    public void setSelectionAlpha(double selectionAlpha) {
        chartCursor.selectionAlpha = selectionAlpha;
    }

    public boolean isSelectWithoutZooming() {
        return chartCursor.selectWithoutZooming;
    }

    /**
     * Specifies if cursor should only mark selected area but not zoom-in after user releases mouse button. Default
     * to false
     */

    public void setSelectWithoutZooming(boolean selectWithoutZooming) {
        chartCursor.selectWithoutZooming = selectWithoutZooming;
    }

    public boolean isShowNextAvailable() {
        return chartCursor.showNextAvailable;
    }

    /**
     * If true, the graph will display balloon on next available data point if currently hovered item doesn't have value
     * for this graph. Default to false
     */

    public void setShowNextAvailable(boolean showNextAvailable) {
        chartCursor.showNextAvailable = showNextAvailable;
    }

    public int getTabIndex() {
        return chartCursor.tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on chart cursor (works only with serial chart) when
     * user clicks tab key. When a focus is set user can move cursor using cursor keys. Note, not all browsers and
     * readers support chartCursor.
     */

    public void setTabIndex(int tabIndex) {
        chartCursor.tabIndex = tabIndex;
    }

    public boolean isValueBalloonsEnabled() {
        return chartCursor.valueBalloonsEnabled;
    }

    /**
     * Specifies whether value balloons are enabled. In case they are not, the balloons might be displayed anyway, when
     * the user rolls-over the column or bullet. Default to true
     */

    public void setValueBalloonsEnabled(boolean valueBalloonsEnabled) {
        chartCursor.valueBalloonsEnabled = valueBalloonsEnabled;
    }

    public double getValueLineAlpha() {
        return chartCursor.valueLineAlpha;
    }

    /**
     * Opacity of value line. Will use cursorAlpha value if not set. Default to false
     */

    public void setValueLineAlpha(double valueLineAlpha) {
        chartCursor.valueLineAlpha = valueLineAlpha;
    }

    public boolean isValueLineBalloonEnabled() {
        return chartCursor.valueLineBalloonEnabled;
    }

    /**
     * Specifies if value balloon next to value axes labels should be displayed. Default tot false
     */

    public void setValueLineBalloonEnabled(boolean valueLineBalloonEnabled) {
        chartCursor.valueLineBalloonEnabled = valueLineBalloonEnabled;
    }

    public boolean isValueLineEnabled() {
        return chartCursor.valueLineEnabled;
    }

    /**
     * Specifies if cursor of Serial chart should display horizontal (or vertical if chart is rotated) line.
     * This line might help users to compare distant values of a chart. You can also enable value balloons on
     * this line by setting valueLineBalloonEnabled to true. Default to false
     */

    public void setValueLineEnabled(boolean valueLineEnabled) {
        chartCursor.valueLineEnabled = valueLineEnabled;
    }

    public boolean isValueZoomable() {
        return chartCursor.valueZoomable;
    }

    /**
     * Specifies if the user can zoom-in value axess of a serial chart. Default to false
     */

    public void setValueZoomable(boolean valueZoomable) {
        chartCursor.valueZoomable = valueZoomable;
    }

    public boolean isZoomable() {
        return chartCursor.zoomable;
    }

    /**
     * Specifies if the user can zoom-in the chart. If pan is set to true, zoomable is switched to false automatically.
     * Default to true
     */

    public void setZoomable(boolean zoomable) {
        chartCursor.zoomable = zoomable;
    }

    public boolean isZooming() {
        return chartCursor.zooming;
    }

    /**
     * Read-only. Indicates if currently user is selecting some chart area to zoom-in.
     */

    public void setZooming(boolean zooming) {
        chartCursor.zooming = zooming;
    }

    public AmChartCursor getChartCursor() {
        return chartCursor;
    }
}
