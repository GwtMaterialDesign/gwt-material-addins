package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.DragIcon;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmCategoryAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmChartScrollbar;

//@formatter:off

/**
 * Create a scrollbar for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} and
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ChartScrollbar">Official Documentation</a>
 */
//@formatter:on
public class ChartScrollbar extends ChartOptions {

    private AmChartScrollbar chartScrollbar;

    public String getAccessibleLabel() {
        return getAmChartScrollbar().accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over or sets focus using tab key (this is possible only if
     * tabIndex property of AmGraph is set to some number) on the grips or draggable part of a scrollbar. Text is
     * added as aria-label tag. Note - not all screen readers and browsers support getAmChartScrollbar(). Note, you should set tabIndex
     * to some number in order it would be possible to zoom chart using cursor keys. Default to "Zoom chart using cursor
     * arrows"
     */

    public void setAccessibleLabel(String accessibleLabel) {
        getAmChartScrollbar().accessibleLabel = accessibleLabel;
    }

    public boolean isAutoGridCount() {
        return getAmChartScrollbar().autoGridCount;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, according to the axis size. Default to false
     */

    public void setAutoGridCount(boolean autoGridCount) {
        getAmChartScrollbar().autoGridCount = autoGridCount;
    }

    public double getBackgroundAlpha() {
        return getAmChartScrollbar().backgroundAlpha;
    }

    /**
     * Background opacity. Default to 1
     */

    public void setBackgroundAlpha(double backgroundAlpha) {
        getAmChartScrollbar().backgroundAlpha = backgroundAlpha;
    }

    public String getBackgroundColor() {
        return getAmChartScrollbar().backgroundColor;
    }

    /**
     * Background color of the scrollbar. Default to #D4D4D4
     */

    public void setBackgroundColor(String backgroundColor) {
        getAmChartScrollbar().backgroundColor = backgroundColor;
    }

    public AmCategoryAxis getCategoryAxis() {
        return getAmChartScrollbar().categoryAxis;
    }

    /**
     * Read-only. Category axis of the scrollbar.
     */

    public void setCategoryAxis(AmCategoryAxis categoryAxis) {
        getAmChartScrollbar().categoryAxis = categoryAxis;
    }

    public String getColor() {
        return getAmChartScrollbar().color;
    }

    /**
     * Text color. Default to #FFFFFF
     */

    public void setColor(String color) {
        getAmChartScrollbar().color = color;
    }

    public String getDragCursorDown() {
        return getAmChartScrollbar().dragCursorDown;
    }

    /**
     * Mouse cursor displayed when clicked on selected part of a scrollbar.
     */

    public void setDragCursorDown(String dragCursorDown) {
        getAmChartScrollbar().dragCursorDown = dragCursorDown;
    }

    public String getDragCursorHover() {
        return getAmChartScrollbar().dragCursorHover;
    }

    /**
     * Mouse cursor displayed when hovering over selected part of a scrollbar.
     */

    public void setDragCursorHover(String dragCursorHover) {
        getAmChartScrollbar().dragCursorHover = dragCursorHover;
    }

    public String getDragIcon() {
        return getAmChartScrollbar().dragIcon;
    }

    /**
     * File name of scrollbar drag (resize grip) icon. You can find a set of icons in amcharts/images folder - you can
     * choose from these: dragIconRectBig, dragIconRectBigBlack, dragIconRectSmall, dragIconRectSmallBlack,
     * dragIconRoundBig, dragIconRoundBigBlack, dragIconRoundSmall, dragIconRoundSmallBlack.
     * You can also use your own custom icons. Don't forget to change dragIconWidth and dragIconHeight if you change
     * icons. Default to {@link DragIcon#DRAG_ICON_ROUND_BIG}
     */

    public void setDragIcon(DragIcon dragIcon) {
        getAmChartScrollbar().dragIcon = dragIcon.getName();
    }

    public int getDragIconHeight() {
        return getAmChartScrollbar().dragIconHeight;
    }

    /**
     * Height of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */

    public void setDragIconHeight(int dragIconHeight) {
        getAmChartScrollbar().dragIconHeight = dragIconHeight;
    }

    public int getDragIconWidth() {
        return getAmChartScrollbar().dragIconWidth;
    }

    /**
     * Width of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */

    public void setDragIconWidth(int dragIconWidth) {
        getAmChartScrollbar().dragIconWidth = dragIconWidth;
    }

    public boolean isEnabled() {
        return getAmChartScrollbar().enabled;
    }

    /**
     * Specifies if scrollbar is enabled. You can hide/show scrollbar using this property without actually removing it.
     * Default to true
     */

    public void setEnabled(boolean enabled) {
        getAmChartScrollbar().enabled = enabled;
    }

    public String getGraph() {
        return getAmChartScrollbar().graph;
    }

    /**
     * Specifies which graph will be displayed in the scrollbar. Only Serial chart's category scrollbar can display a
     * graph.
     */

    public void setGraph(String graph) {
        getAmChartScrollbar().graph = graph;
    }

    public double getGraphFillAlpha() {
        return getAmChartScrollbar().graphFillAlpha;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to 1
     */

    public void setGraphFillAlpha(double graphFillAlpha) {
        getAmChartScrollbar().graphFillAlpha = graphFillAlpha;
    }

    public String getGraphFillColor() {
        return getAmChartScrollbar().graphFillColor;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to #BBBBBB
     */

    public void setGraphFillColor(String graphFillColor) {
        getAmChartScrollbar().graphFillColor = graphFillColor;
    }

    public double getGraphLineAlpha() {
        return getAmChartScrollbar().graphLineAlpha;
    }

    /**
     * Graph line opacity. Value range is 0 - 1. Default to 0
     */

    public void setGraphLineAlpha(double graphLineAlpha) {
        getAmChartScrollbar().graphLineAlpha = graphLineAlpha;
    }

    public String getGraphLineColor() {
        return getAmChartScrollbar().graphLineColor;
    }

    /**
     * Graph line color. Default to #BBBBBB
     */

    public void setGraphLineColor(String graphLineColor) {
        getAmChartScrollbar().graphLineColor = graphLineColor;
    }

    public String getGraphType() {
        return getAmChartScrollbar().graphType;
    }

    /**
     * By default the graph type is the same as the original graph's type, however in case of candlestick or ohlc you
     * might want to show line graph in the scrollbar. Possible values are: line, column, step, smoothedLine, candlestick,
     * ohlc
     */

    public void setGraphType(String graphType) {
        getAmChartScrollbar().graphType = graphType;
    }

    public double getGridAlpha() {
        return getAmChartScrollbar().gridAlpha;
    }

    /**
     * Grid opacity. Value range is 0 - 1. Default to 0.7
     */

    public void setGridAlpha(double gridAlpha) {
        getAmChartScrollbar().gridAlpha = gridAlpha;
    }

    public String getGridColor() {
        return getAmChartScrollbar().gridColor;
    }

    /**
     * Grid color. Default to #FFFFFF
     */

    public void setGridColor(String gridColor) {
        getAmChartScrollbar().gridColor = gridColor;
    }

    public int getGridCount() {
        return getAmChartScrollbar().gridCount;
    }

    /**
     * The number of grid lines. Default to 0
     */

    public void setGridCount(int gridCount) {
        getAmChartScrollbar().gridCount = gridCount;
    }

    public boolean isHideResizeGrips() {
        return getAmChartScrollbar().hideResizeGrips;
    }

    /**
     * Specifies whether resize grips are hidden when mouse is away from the scrollbar. Default to false
     */

    public void setHideResizeGrips(boolean hideResizeGrips) {
        getAmChartScrollbar().hideResizeGrips = hideResizeGrips;
    }

    public String gethResizeCursor() {
        return getAmChartScrollbar().hResizeCursor;
    }

    /**
     * Mouse cursor type shown when user hovers horizontal cursor's resize grips. Default to "ew-resize"
     */

    public void sethResizeCursor(String hResizeCursor) {
        getAmChartScrollbar().hResizeCursor = hResizeCursor;
    }

    public String gethResizeCursorDown() {
        return getAmChartScrollbar().hResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over horizontal cursor's resize grip.
     */

    public void sethResizeCursorDown(String hResizeCursorDown) {
        getAmChartScrollbar().hResizeCursorDown = hResizeCursorDown;
    }

    public String gethResizeCursorHover() {
        return getAmChartScrollbar().hResizeCursorHover;
    }

    /**
     * CSS value of cursor displayed when hovering over horizontal cursor's resize grip.
     */

    public void sethResizeCursorHover(String hResizeCursorHover) {
        getAmChartScrollbar().hResizeCursorHover = hResizeCursorHover;
    }

    public boolean isIgnoreCustomColors() {
        return getAmChartScrollbar().ignoreCustomColors;
    }

    /**
     * If you have column type graph in your scrollbar, and this graph has custom colors for one or more columns in data
     * provider, those columns will be colored with this custom color. However you might not want this in some cases.
     * Set this property to true to use scrollbar's graph colors. Default to false
     */

    public void setIgnoreCustomColors(boolean ignoreCustomColors) {
        getAmChartScrollbar().ignoreCustomColors = ignoreCustomColors;
    }

    public int getMaximum() {
        return getAmChartScrollbar().maximum;
    }

    /**
     * Maximum value of AmValueAxis of AmgetAmChartScrollbar(). Calculated automatically, if not set.
     */

    public void setMaximum(int maximum) {
        getAmChartScrollbar().maximum = maximum;
    }

    public int getMinimum() {
        return getAmChartScrollbar().minimum;
    }

    /**
     * Minimum value of AmValueAxis of AmgetAmChartScrollbar(). Calculated automatically, if not set.
     */

    public void setMinimum(int minimum) {
        getAmChartScrollbar().minimum = minimum;
    }

    public int getOffset() {
        return getAmChartScrollbar().offset;
    }

    /**
     * Distance from plot area to scrollbar, in pixels. Default to 0
     */

    public void setOffset(int offset) {
        getAmChartScrollbar().offset = offset;
    }

    public boolean isOppositeAxis() {
        return getAmChartScrollbar().oppositeAxis;
    }

    /**
     * By default, scrollbar is in the opsite side of plot area from the axis. If you set this property to false,
     * scrollbar will be placed next to category/value axis. However it won't adjust it's position regarding axis
     * labels, so you might need to use offset property to move scrollbar away from labels.Default to true. Default
     * to true
     */

    public void setOppositeAxis(boolean oppositeAxis) {
        getAmChartScrollbar().oppositeAxis = oppositeAxis;
    }

    public boolean isResizeEnabled() {
        return getAmChartScrollbar().resizeEnabled;
    }

    /**
     * If set to false it will prevent the chart scroll bar to change selection scope. The grip images will not be
     * shown as well. The user would still be able to pan / move selection. Default to true
     */

    public void setResizeEnabled(boolean resizeEnabled) {
        getAmChartScrollbar().resizeEnabled = resizeEnabled;
    }

    public int getScrollbarHeight() {
        return getAmChartScrollbar().scrollbarHeight;
    }

    /**
     * Height (width, if chart is rotated) of a scrollbar. Default to 20
     */

    public void setScrollbarHeight(int scrollbarHeight) {
        getAmChartScrollbar().scrollbarHeight = scrollbarHeight;
    }

    public int getScrollDuration() {
        return getAmChartScrollbar().scrollDuration;
    }

    /**
     * Duration of scrolling, when the user clicks on scrollbar's background, in seconds. Note, updateOnReleaseOnly
     * should be set to false in order animation to happen. Default to 1
     */

    public void setScrollDuration(int scrollDuration) {
        getAmChartScrollbar().scrollDuration = scrollDuration;
    }

    public double getSelectedBackgroundAlpha() {
        return getAmChartScrollbar().selectedBackgroundAlpha;
    }

    /**
     * Selected backround opacity. Default to 1
     */

    public void setSelectedBackgroundAlpha(double selectedBackgroundAlpha) {
        getAmChartScrollbar().selectedBackgroundAlpha = selectedBackgroundAlpha;
    }

    public String getSelectedBackgroundColor() {
        return getAmChartScrollbar().selectedBackgroundColor;
    }

    /**
     * Selected background color. Default to #EFEFEF
     */

    public void setSelectedBackgroundColor(String selectedBackgroundColor) {
        getAmChartScrollbar().selectedBackgroundColor = selectedBackgroundColor;
    }

    public int getSelectedGraphFillAlpha() {
        return getAmChartScrollbar().selectedGraphFillAlpha;
    }

    /**
     * Selected graph's fill opacity. Value range is 0 - 1. Default to 1
     */

    public void setSelectedGraphFillAlpha(int selectedGraphFillAlpha) {
        getAmChartScrollbar().selectedGraphFillAlpha = selectedGraphFillAlpha;
    }

    public String getSelectedGraphFillColor() {
        return getAmChartScrollbar().selectedGraphFillColor;
    }

    /**
     * Selected graph's fill color. Default to #888888
     */

    public void setSelectedGraphFillColor(String selectedGraphFillColor) {
        getAmChartScrollbar().selectedGraphFillColor = selectedGraphFillColor;
    }

    public double getSelectedGraphLineAlpha() {
        return getAmChartScrollbar().selectedGraphLineAlpha;
    }

    /**
     * Selected graph's line opacity. Value range is 0 - 1. Default to 0
     */

    public void setSelectedGraphLineAlpha(double selectedGraphLineAlpha) {
        getAmChartScrollbar().selectedGraphLineAlpha = selectedGraphLineAlpha;
    }

    public String getSelectedGraphLineColor() {
        return getAmChartScrollbar().selectedGraphLineColor;
    }

    /**
     * Selected graph's line color. Default to #888888
     */

    public void setSelectedGraphLineColor(String selectedGraphLineColor) {
        getAmChartScrollbar().selectedGraphLineColor = selectedGraphLineColor;
    }

    public int getTabIndex() {
        return getAmChartScrollbar().tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on grips and draggable area of the scrollbar when
     * user clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set
     * using accessibleLabel property of AmgetAmChartScrollbar(). When a focus is set user can zoom-in, zoom-out or pan the
     * scrollbar using cursor keys. Note, not all browsers and readers support getAmChartScrollbar().
     */

    public void setTabIndex(int tabIndex) {
        getAmChartScrollbar().tabIndex = tabIndex;
    }

    public boolean isUpdateOnReleaseOnly() {
        return getAmChartScrollbar().updateOnReleaseOnly;
    }

    /**
     * Specifies if the chart should be updated while dragging/resizing the scrollbar or only at the moment when user
     * releases mouse button. Default to false
     */

    public void setUpdateOnReleaseOnly(boolean updateOnReleaseOnly) {
        getAmChartScrollbar().updateOnReleaseOnly = updateOnReleaseOnly;
    }

    public String getvResizeCursor() {
        return getAmChartScrollbar().vResizeCursor;
    }

    /**
     * Mouse cursor type shown when user hovers vertical cursor's resize grips. Default to "ns-resize"
     */

    public void setvResizeCursor(String vResizeCursor) {
        getAmChartScrollbar().vResizeCursor = vResizeCursor;
    }

    public String getvResizeCursorDown() {
        return getAmChartScrollbar().vResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over vertical cursor's resize grip.
     */

    public void setvResizeCursorDown(String vResizeCursorDown) {
        getAmChartScrollbar().vResizeCursorDown = vResizeCursorDown;
    }

    public String getvResizeCursorHover() {
        return getAmChartScrollbar().vResizeCursorHover;
    }

    /**
     * CSS value of cursor displayed when hovering over vertical cursor's resize grip.
     */

    public void setvResizeCursorHover(String vResizeCursorHover) {
        getAmChartScrollbar().vResizeCursorHover = vResizeCursorHover;
    }

    public AmChartScrollbar getAmChartScrollbar() {
        if (chartScrollbar == null) {
            chartScrollbar = new AmChartScrollbar();
        }
        return chartScrollbar;
    }
}
