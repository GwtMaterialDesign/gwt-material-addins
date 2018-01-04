package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.DragIcon;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmCategoryAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmChartScrollbar;

public class ChartScrollbar extends ChartOptions {

    private AmChartScrollbar chartScrollbar = new AmChartScrollbar();

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    public String getAccessibleLabel() {
        return chartScrollbar.accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over or sets focus using tab key (this is possible only if
     * tabIndex property of AmGraph is set to some number) on the grips or draggable part of a scrollbar. Text is
     * added as aria-label tag. Note - not all screen readers and browsers support chartScrollbar. Note, you should set tabIndex
     * to some number in order it would be possible to zoom chart using cursor keys. Default to "Zoom chart using cursor
     * arrows"
     */

    public void setAccessibleLabel(String accessibleLabel) {
        chartScrollbar.accessibleLabel = accessibleLabel;
    }

    public boolean isAutoGridCount() {
        return chartScrollbar.autoGridCount;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, according to the axis size. Default to false
     */

    public void setAutoGridCount(boolean autoGridCount) {
        chartScrollbar.autoGridCount = autoGridCount;
    }

    public double getBackgroundAlpha() {
        return chartScrollbar.backgroundAlpha;
    }

    /**
     * Background opacity. Default to 1
     */

    public void setBackgroundAlpha(double backgroundAlpha) {
        chartScrollbar.backgroundAlpha = backgroundAlpha;
    }

    public String getBackgroundColor() {
        return chartScrollbar.backgroundColor;
    }

    /**
     * Background color of the scrollbar. Default to #D4D4D4
     */

    public void setBackgroundColor(String backgroundColor) {
        chartScrollbar.backgroundColor = backgroundColor;
    }

    public AmCategoryAxis getCategoryAxis() {
        return chartScrollbar.categoryAxis;
    }

    /**
     * Read-only. Category axis of the scrollbar.
     */

    public void setCategoryAxis(AmCategoryAxis categoryAxis) {
        chartScrollbar.categoryAxis = categoryAxis;
    }

    public String getColor() {
        return chartScrollbar.color;
    }

    /**
     * Text color. Default to #FFFFFF
     */

    public void setColor(String color) {
        chartScrollbar.color = color;
    }

    public String getDragCursorDown() {
        return chartScrollbar.dragCursorDown;
    }

    /**
     * Mouse cursor displayed when clicked on selected part of a scrollbar.
     */

    public void setDragCursorDown(String dragCursorDown) {
        chartScrollbar.dragCursorDown = dragCursorDown;
    }

    public String getDragCursorHover() {
        return chartScrollbar.dragCursorHover;
    }

    /**
     * Mouse cursor displayed when hovering over selected part of a scrollbar.
     */

    public void setDragCursorHover(String dragCursorHover) {
        chartScrollbar.dragCursorHover = dragCursorHover;
    }

    public String getDragIcon() {
        return chartScrollbar.dragIcon;
    }

    /**
     * File name of scrollbar drag (resize grip) icon. You can find a set of icons in amcharts/images folder - you can
     * choose from these: dragIconRectBig, dragIconRectBigBlack, dragIconRectSmall, dragIconRectSmallBlack,
     * dragIconRoundBig, dragIconRoundBigBlack, dragIconRoundSmall, dragIconRoundSmallBlack.
     * You can also use your own custom icons. Don't forget to change dragIconWidth and dragIconHeight if you change
     * icons. Default to {@link DragIcon#DRAG_ICON_ROUND_BIG}
     */

    public void setDragIcon(DragIcon dragIcon) {
        chartScrollbar.dragIcon = dragIcon.getName();
    }

    public int getDragIconHeight() {
        return chartScrollbar.dragIconHeight;
    }

    /**
     * Height of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */

    public void setDragIconHeight(int dragIconHeight) {
        chartScrollbar.dragIconHeight = dragIconHeight;
    }

    public int getDragIconWidth() {
        return chartScrollbar.dragIconWidth;
    }

    /**
     * Width of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */

    public void setDragIconWidth(int dragIconWidth) {
        chartScrollbar.dragIconWidth = dragIconWidth;
    }

    public boolean isEnabled() {
        return chartScrollbar.enabled;
    }

    /**
     * Specifies if scrollbar is enabled. You can hide/show scrollbar using this property without actually removing it.
     * Default to true
     */

    public void setEnabled(boolean enabled) {
        chartScrollbar.enabled = enabled;
    }

    public String getGraph() {
        return chartScrollbar.graph;
    }

    /**
     * Specifies which graph will be displayed in the scrollbar. Only Serial chart's category scrollbar can display a
     * graph.
     */

    public void setGraph(String graph) {
        chartScrollbar.graph = graph;
    }

    public double getGraphFillAlpha() {
        return chartScrollbar.graphFillAlpha;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to 1
     */

    public void setGraphFillAlpha(double graphFillAlpha) {
        chartScrollbar.graphFillAlpha = graphFillAlpha;
    }

    public String getGraphFillColor() {
        return chartScrollbar.graphFillColor;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to #BBBBBB
     */

    public void setGraphFillColor(String graphFillColor) {
        chartScrollbar.graphFillColor = graphFillColor;
    }

    public double getGraphLineAlpha() {
        return chartScrollbar.graphLineAlpha;
    }

    /**
     * Graph line opacity. Value range is 0 - 1. Default to 0
     */

    public void setGraphLineAlpha(double graphLineAlpha) {
        chartScrollbar.graphLineAlpha = graphLineAlpha;
    }

    public String getGraphLineColor() {
        return chartScrollbar.graphLineColor;
    }

    /**
     * Graph line color. Default to #BBBBBB
     */

    public void setGraphLineColor(String graphLineColor) {
        chartScrollbar.graphLineColor = graphLineColor;
    }

    public String getGraphType() {
        return chartScrollbar.graphType;
    }

    /**
     * By default the graph type is the same as the original graph's type, however in case of candlestick or ohlc you
     * might want to show line graph in the scrollbar. Possible values are: line, column, step, smoothedLine, candlestick,
     * ohlc
     */

    public void setGraphType(String graphType) {
        chartScrollbar.graphType = graphType;
    }

    public double getGridAlpha() {
        return chartScrollbar.gridAlpha;
    }

    /**
     * Grid opacity. Value range is 0 - 1. Default to 0.7
     */

    public void setGridAlpha(double gridAlpha) {
        chartScrollbar.gridAlpha = gridAlpha;
    }

    public String getGridColor() {
        return chartScrollbar.gridColor;
    }

    /**
     * Grid color. Default to #FFFFFF
     */

    public void setGridColor(String gridColor) {
        chartScrollbar.gridColor = gridColor;
    }

    public int getGridCount() {
        return chartScrollbar.gridCount;
    }

    /**
     * The number of grid lines. Default to 0
     */

    public void setGridCount(int gridCount) {
        chartScrollbar.gridCount = gridCount;
    }

    public boolean isHideResizeGrips() {
        return chartScrollbar.hideResizeGrips;
    }

    /**
     * Specifies whether resize grips are hidden when mouse is away from the scrollbar. Default to false
     */

    public void setHideResizeGrips(boolean hideResizeGrips) {
        chartScrollbar.hideResizeGrips = hideResizeGrips;
    }

    public String gethResizeCursor() {
        return chartScrollbar.hResizeCursor;
    }

    /**
     * Mouse cursor type shown when user hovers horizontal cursor's resize grips. Default to "ew-resize"
     */

    public void sethResizeCursor(String hResizeCursor) {
        chartScrollbar.hResizeCursor = hResizeCursor;
    }

    public String gethResizeCursorDown() {
        return chartScrollbar.hResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over horizontal cursor's resize grip.
     */

    public void sethResizeCursorDown(String hResizeCursorDown) {
        chartScrollbar.hResizeCursorDown = hResizeCursorDown;
    }

    public String gethResizeCursorHover() {
        return chartScrollbar.hResizeCursorHover;
    }

    /**
     * CSS value of cursor displayed when hovering over horizontal cursor's resize grip.
     */

    public void sethResizeCursorHover(String hResizeCursorHover) {
        chartScrollbar.hResizeCursorHover = hResizeCursorHover;
    }

    public boolean isIgnoreCustomColors() {
        return chartScrollbar.ignoreCustomColors;
    }

    /**
     * If you have column type graph in your scrollbar, and this graph has custom colors for one or more columns in data
     * provider, those columns will be colored with this custom color. However you might not want this in some cases.
     * Set this property to true to use scrollbar's graph colors. Default to false
     */

    public void setIgnoreCustomColors(boolean ignoreCustomColors) {
        chartScrollbar.ignoreCustomColors = ignoreCustomColors;
    }

    public int getMaximum() {
        return chartScrollbar.maximum;
    }

    /**
     * Maximum value of AmValueAxis of AmChartScrollbar. Calculated automatically, if not set.
     */

    public void setMaximum(int maximum) {
        chartScrollbar.maximum = maximum;
    }

    public int getMinimum() {
        return chartScrollbar.minimum;
    }

    /**
     * Minimum value of AmValueAxis of AmChartScrollbar. Calculated automatically, if not set.
     */

    public void setMinimum(int minimum) {
        chartScrollbar.minimum = minimum;
    }

    public int getOffset() {
        return chartScrollbar.offset;
    }

    /**
     * Distance from plot area to scrollbar, in pixels. Default to 0
     */

    public void setOffset(int offset) {
        chartScrollbar.offset = offset;
    }

    public boolean isOppositeAxis() {
        return chartScrollbar.oppositeAxis;
    }

    /**
     * By default, scrollbar is in the opsite side of plot area from the axis. If you set this property to false,
     * scrollbar will be placed next to category/value axis. However it won't adjust it's position regarding axis
     * labels, so you might need to use offset property to move scrollbar away from labels.Default to true. Default
     * to true
     */

    public void setOppositeAxis(boolean oppositeAxis) {
        chartScrollbar.oppositeAxis = oppositeAxis;
    }

    public boolean isResizeEnabled() {
        return chartScrollbar.resizeEnabled;
    }

    /**
     * If set to false it will prevent the chart scroll bar to change selection scope. The grip images will not be
     * shown as well. The user would still be able to pan / move selection. Default to true
     */

    public void setResizeEnabled(boolean resizeEnabled) {
        chartScrollbar.resizeEnabled = resizeEnabled;
    }

    public int getScrollbarHeight() {
        return chartScrollbar.scrollbarHeight;
    }

    /**
     * Height (width, if chart is rotated) of a scrollbar. Default to 20
     */

    public void setScrollbarHeight(int scrollbarHeight) {
        chartScrollbar.scrollbarHeight = scrollbarHeight;
    }

    public int getScrollDuration() {
        return chartScrollbar.scrollDuration;
    }

    /**
     * Duration of scrolling, when the user clicks on scrollbar's background, in seconds. Note, updateOnReleaseOnly
     * should be set to false in order animation to happen. Default to 1
     */

    public void setScrollDuration(int scrollDuration) {
        chartScrollbar.scrollDuration = scrollDuration;
    }

    public double getSelectedBackgroundAlpha() {
        return chartScrollbar.selectedBackgroundAlpha;
    }

    /**
     * Selected backround opacity. Default to 1
     */

    public void setSelectedBackgroundAlpha(double selectedBackgroundAlpha) {
        chartScrollbar.selectedBackgroundAlpha = selectedBackgroundAlpha;
    }

    public String getSelectedBackgroundColor() {
        return chartScrollbar.selectedBackgroundColor;
    }

    /**
     * Selected background color. Default to #EFEFEF
     */

    public void setSelectedBackgroundColor(String selectedBackgroundColor) {
        chartScrollbar.selectedBackgroundColor = selectedBackgroundColor;
    }

    public int getSelectedGraphFillAlpha() {
        return chartScrollbar.selectedGraphFillAlpha;
    }

    /**
     * Selected graph's fill opacity. Value range is 0 - 1. Default to 1
     */

    public void setSelectedGraphFillAlpha(int selectedGraphFillAlpha) {
        chartScrollbar.selectedGraphFillAlpha = selectedGraphFillAlpha;
    }

    public String getSelectedGraphFillColor() {
        return chartScrollbar.selectedGraphFillColor;
    }

    /**
     * Selected graph's fill color. Default to #888888
     */

    public void setSelectedGraphFillColor(String selectedGraphFillColor) {
        chartScrollbar.selectedGraphFillColor = selectedGraphFillColor;
    }

    public double getSelectedGraphLineAlpha() {
        return chartScrollbar.selectedGraphLineAlpha;
    }

    /**
     * Selected graph's line opacity. Value range is 0 - 1. Default to 0
     */

    public void setSelectedGraphLineAlpha(double selectedGraphLineAlpha) {
        chartScrollbar.selectedGraphLineAlpha = selectedGraphLineAlpha;
    }

    public String getSelectedGraphLineColor() {
        return chartScrollbar.selectedGraphLineColor;
    }

    /**
     * Selected graph's line color. Default to #888888
     */

    public void setSelectedGraphLineColor(String selectedGraphLineColor) {
        chartScrollbar.selectedGraphLineColor = selectedGraphLineColor;
    }

    public int getTabIndex() {
        return chartScrollbar.tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on grips and draggable area of the scrollbar when
     * user clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set
     * using accessibleLabel property of AmChartScrollbar. When a focus is set user can zoom-in, zoom-out or pan the
     * scrollbar using cursor keys. Note, not all browsers and readers support chartScrollbar.
     */

    public void setTabIndex(int tabIndex) {
        chartScrollbar.tabIndex = tabIndex;
    }

    public boolean isUpdateOnReleaseOnly() {
        return chartScrollbar.updateOnReleaseOnly;
    }

    /**
     * Specifies if the chart should be updated while dragging/resizing the scrollbar or only at the moment when user
     * releases mouse button. Default to false
     */

    public void setUpdateOnReleaseOnly(boolean updateOnReleaseOnly) {
        chartScrollbar.updateOnReleaseOnly = updateOnReleaseOnly;
    }

    public String getvResizeCursor() {
        return chartScrollbar.vResizeCursor;
    }

    /**
     * Mouse cursor type shown when user hovers vertical cursor's resize grips. Default to "ns-resize"
     */

    public void setvResizeCursor(String vResizeCursor) {
        chartScrollbar.vResizeCursor = vResizeCursor;
    }

    public String getvResizeCursorDown() {
        return chartScrollbar.vResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over vertical cursor's resize grip.
     */

    public void setvResizeCursorDown(String vResizeCursorDown) {
        chartScrollbar.vResizeCursorDown = vResizeCursorDown;
    }

    public String getvResizeCursorHover() {
        return chartScrollbar.vResizeCursorHover;
    }

    /**
     * CSS value of cursor displayed when hovering over vertical cursor's resize grip.
     */

    public void setvResizeCursorHover(String vResizeCursorHover) {
        chartScrollbar.vResizeCursorHover = vResizeCursorHover;
    }

    public AmChartScrollbar getChartScrollbar() {
        return chartScrollbar;
    }
}
