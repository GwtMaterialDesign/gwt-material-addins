/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.DragIcon;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Create a scrollbar for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} and
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ChartScrollbar">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ChartScrollbar {

    @JsProperty
    private String accessibleLabel;

    @JsProperty
    private boolean autoGridCount;

    @JsProperty
    private double backgroundAlpha;

    @JsProperty
    private String backgroundColor;

    @JsProperty
    private CategoryAxis categoryAxis;

    @JsProperty
    private String color;

    @JsProperty
    private String dragCursorDown;

    @JsProperty
    private String dragCursorHover;

    @JsProperty
    private String dragIcon;

    @JsProperty
    private int dragIconHeight;

    @JsProperty
    private int dragIconWidth;

    @JsProperty
    private boolean enabled;

    @JsProperty
    private String graph;

    @JsProperty
    private double graphFillAlpha;

    @JsProperty
    private String graphFillColor;

    @JsProperty
    private double graphLineAlpha;

    @JsProperty
    private String graphLineColor;

    @JsProperty
    private String graphType;

    @JsProperty
    private double gridAlpha;

    @JsProperty
    private String gridColor;

    @JsProperty
    private int gridCount;

    @JsProperty
    private boolean hideResizeGrips;

    @JsProperty
    private String hResizeCursor;

    @JsProperty
    private String hResizeCursorDown;

    @JsProperty
    private String hResizeCursorHover;

    @JsProperty
    private boolean ignoreCustomColors;

    @JsProperty
    private int maximum;

    @JsProperty
    private int minimum;

    @JsProperty
    private int offset;

    @JsProperty
    private boolean oppositeAxis;

    @JsProperty
    private boolean resizeEnabled;

    @JsProperty
    private int scrollbarHeight;

    @JsProperty
    private int scrollDuration;

    @JsProperty
    private double selectedBackgroundAlpha;

    @JsProperty
    private String selectedBackgroundColor;

    @JsProperty
    private int selectedGraphFillAlpha;

    @JsProperty
    private String selectedGraphFillColor;

    @JsProperty
    private double selectedGraphLineAlpha;

    @JsProperty
    private String selectedGraphLineColor;

    @JsProperty
    private int tabIndex;

    @JsProperty
    private boolean updateOnReleaseOnly;

    @JsProperty
    private String vResizeCursor;

    @JsProperty
    private String vResizeCursorDown;

    @JsProperty
    private String vResizeCursorHover;

    /**
     * Text which screen readers will read if user rolls-over or sets focus using tab key (this is possible only if
     * tabIndex property of AmGraph is set to some number) on the grips or draggable part of a scrollbar. Text is
     * added as aria-label tag. Note - not all screen readers and browsers support this. Note, you should set tabIndex
     * to some number in order it would be possible to zoom chart using cursor keys. Default to "Zoom chart using cursor
     * arrows"
     */
    @JsOverlay
    public final void setAccessibleLabel(String accessibleLabel) {
        this.accessibleLabel = accessibleLabel;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, according to the axis size. Default to false
     */
    @JsOverlay
    public final void setAutoGridCount(boolean autoGridCount) {
        this.autoGridCount = autoGridCount;
    }

    /**
     * Background opacity. Default to 1
     */
    @JsOverlay
    public final void setBackgroundAlpha(double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
    }

    /**
     * Background color of the scrollbar. Default to #D4D4D4
     */
    @JsOverlay
    public final void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Read-only. Category axis of the scrollbar.
     */
    @JsOverlay
    public final void setCategoryAxis(CategoryAxis categoryAxis) {
        this.categoryAxis = categoryAxis;
    }

    /**
     * Text color. Default to #FFFFFF
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Mouse cursor displayed when clicked on selected part of a scrollbar.
     */
    @JsOverlay
    public final void setDragCursorDown(String dragCursorDown) {
        this.dragCursorDown = dragCursorDown;
    }

    /**
     * Mouse cursor displayed when hovering over selected part of a scrollbar.
     */
    @JsOverlay
    public final void setDragCursorHover(String dragCursorHover) {
        this.dragCursorHover = dragCursorHover;
    }

    /**
     * File name of scrollbar drag (resize grip) icon. You can find a set of icons in amcharts/images folder - you can
     * choose from these: dragIconRectBig, dragIconRectBigBlack, dragIconRectSmall, dragIconRectSmallBlack,
     * dragIconRoundBig, dragIconRoundBigBlack, dragIconRoundSmall, dragIconRoundSmallBlack.
     * You can also use your own custom icons. Don't forget to change dragIconWidth and dragIconHeight if you change
     * icons. Default to {@link DragIcon#DRAG_ICON_ROUND_BIG}
     */
    @JsOverlay
    public final void setDragIcon(DragIcon dragIcon) {
        this.dragIcon = dragIcon.getName();
    }

    /**
     * Height of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */
    @JsOverlay
    public final void setDragIconHeight(int dragIconHeight) {
        this.dragIconHeight = dragIconHeight;
    }

    /**
     * Width of resize grip image. Note, you should also update the image in amcharts/images folder if you don't want
     * it to be distorted because of resizing. Default to 35
     */
    @JsOverlay
    public final void setDragIconWidth(int dragIconWidth) {
        this.dragIconWidth = dragIconWidth;
    }

    /**
     * Specifies if scrollbar is enabled. You can hide/show scrollbar using this property without actually removing it.
     * Default to true
     */
    @JsOverlay
    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Specifies which graph will be displayed in the scrollbar. Only Serial chart's category scrollbar can display a
     * graph.
     */
    @JsOverlay
    public final void setGraph(String graph) {
        this.graph = graph;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to 1
     */
    @JsOverlay
    public final void setGraphFillAlpha(double graphFillAlpha) {
        this.graphFillAlpha = graphFillAlpha;
    }

    /**
     * Graph fill opacity. Value range is 0 - 1. Default to #BBBBBB
     */
    @JsOverlay
    public final void setGraphFillColor(String graphFillColor) {
        this.graphFillColor = graphFillColor;
    }

    /**
     * Graph line opacity. Value range is 0 - 1. Default to 0
     */
    @JsOverlay
    public final void setGraphLineAlpha(double graphLineAlpha) {
        this.graphLineAlpha = graphLineAlpha;
    }

    /**
     * Graph line color. Default to #BBBBBB
     */
    @JsOverlay
    public final void setGraphLineColor(String graphLineColor) {
        this.graphLineColor = graphLineColor;
    }

    /**
     * By default the graph type is the same as the original graph's type, however in case of candlestick or ohlc you
     * might want to show line graph in the scrollbar. Possible values are: line, column, step, smoothedLine, candlestick,
     * ohlc
     */
    @JsOverlay
    public final void setGraphType(String graphType) {
        this.graphType = graphType;
    }

    /**
     * Grid opacity. Value range is 0 - 1. Default to 0.7
     */
    @JsOverlay
    public final void setGridAlpha(double gridAlpha) {
        this.gridAlpha = gridAlpha;
    }

    /**
     * Grid color. Default to #FFFFFF
     */
    @JsOverlay
    public final void setGridColor(String gridColor) {
        this.gridColor = gridColor;
    }

    /**
     * The number of grid lines. Default to 0
     */
    @JsOverlay
    public final void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    /**
     * Specifies whether resize grips are hidden when mouse is away from the scrollbar. Default to false
     */
    @JsOverlay
    public final void setHideResizeGrips(boolean hideResizeGrips) {
        this.hideResizeGrips = hideResizeGrips;
    }

    /**
     * Mouse cursor type shown when user hovers horizontal cursor's resize grips. Default to "ew-resize"
     */
    @JsOverlay
    public final void sethResizeCursor(String hResizeCursor) {
        this.hResizeCursor = hResizeCursor;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over horizontal cursor's resize grip.
     */
    @JsOverlay
    public final void sethResizeCursorDown(String hResizeCursorDown) {
        this.hResizeCursorDown = hResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when hovering over horizontal cursor's resize grip.
     */
    @JsOverlay
    public final void sethResizeCursorHover(String hResizeCursorHover) {
        this.hResizeCursorHover = hResizeCursorHover;
    }

    /**
     * If you have column type graph in your scrollbar, and this graph has custom colors for one or more columns in data
     * provider, those columns will be colored with this custom color. However you might not want this in some cases.
     * Set this property to true to use scrollbar's graph colors. Default to false
     */
    @JsOverlay
    public final void setIgnoreCustomColors(boolean ignoreCustomColors) {
        this.ignoreCustomColors = ignoreCustomColors;
    }

    /**
     * Maximum value of ValueAxis of ChartScrollbar. Calculated automatically, if not set.
     */
    @JsOverlay
    public final void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    /**
     * Minimum value of ValueAxis of ChartScrollbar. Calculated automatically, if not set.
     */
    @JsOverlay
    public final void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    /**
     * Distance from plot area to scrollbar, in pixels. Default to 0
     */
    @JsOverlay
    public final void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * By default, scrollbar is in the opsite side of plot area from the axis. If you set this property to false,
     * scrollbar will be placed next to category/value axis. However it won't adjust it's position regarding axis
     * labels, so you might need to use offset property to move scrollbar away from labels.Default to true. Default
     * to true
     */
    @JsOverlay
    public final void setOppositeAxis(boolean oppositeAxis) {
        this.oppositeAxis = oppositeAxis;
    }

    /**
     * If set to false it will prevent the chart scroll bar to change selection scope. The grip images will not be
     * shown as well. The user would still be able to pan / move selection. Default to true
     */
    @JsOverlay
    public final void setResizeEnabled(boolean resizeEnabled) {
        this.resizeEnabled = resizeEnabled;
    }

    /**
     * Height (width, if chart is rotated) of a scrollbar. Default to 20
     */
    @JsOverlay
    public final void setScrollbarHeight(int scrollbarHeight) {
        this.scrollbarHeight = scrollbarHeight;
    }

    /**
     * Duration of scrolling, when the user clicks on scrollbar's background, in seconds. Note, updateOnReleaseOnly
     * should be set to false in order animation to happen. Default to 1
     */
    @JsOverlay
    public final void setScrollDuration(int scrollDuration) {
        this.scrollDuration = scrollDuration;
    }

    /**
     * Selected backround opacity. Default to 1
     */
    @JsOverlay
    public final void setSelectedBackgroundAlpha(double selectedBackgroundAlpha) {
        this.selectedBackgroundAlpha = selectedBackgroundAlpha;
    }

    /**
     * Selected background color. Default to #EFEFEF
     */
    @JsOverlay
    public final void setSelectedBackgroundColor(String selectedBackgroundColor) {
        this.selectedBackgroundColor = selectedBackgroundColor;
    }

    /**
     * Selected graph's fill opacity. Value range is 0 - 1. Default to 1
     */
    @JsOverlay
    public final void setSelectedGraphFillAlpha(int selectedGraphFillAlpha) {
        this.selectedGraphFillAlpha = selectedGraphFillAlpha;
    }

    /**
     * Selected graph's fill color. Default to #888888
     */
    @JsOverlay
    public final void setSelectedGraphFillColor(String selectedGraphFillColor) {
        this.selectedGraphFillColor = selectedGraphFillColor;
    }

    /**
     * Selected graph's line opacity. Value range is 0 - 1. Default to 0
     */
    @JsOverlay
    public final void setSelectedGraphLineAlpha(double selectedGraphLineAlpha) {
        this.selectedGraphLineAlpha = selectedGraphLineAlpha;
    }

    /**
     * Selected graph's line color. Default to #888888
     */
    @JsOverlay
    public final void setSelectedGraphLineColor(String selectedGraphLineColor) {
        this.selectedGraphLineColor = selectedGraphLineColor;
    }

    /**
     * In case you set it to some number, the chart will set focus on grips and draggable area of the scrollbar when
     * user clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set
     * using accessibleLabel property of ChartScrollbar. When a focus is set user can zoom-in, zoom-out or pan the
     * scrollbar using cursor keys. Note, not all browsers and readers support this.
     */
    @JsOverlay
    public final void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    /**
     * Specifies if the chart should be updated while dragging/resizing the scrollbar or only at the moment when user
     * releases mouse button. Default to false
     */
    @JsOverlay
    public final void setUpdateOnReleaseOnly(boolean updateOnReleaseOnly) {
        this.updateOnReleaseOnly = updateOnReleaseOnly;
    }

    /**
     * Mouse cursor type shown when user hovers vertical cursor's resize grips. Default to "ns-resize"
     */
    @JsOverlay
    public final void setvResizeCursor(String vResizeCursor) {
        this.vResizeCursor = vResizeCursor;
    }

    /**
     * CSS value of cursor displayed when mouse is pressed down over vertical cursor's resize grip.
     */
    @JsOverlay
    public final void setvResizeCursorDown(String vResizeCursorDown) {
        this.vResizeCursorDown = vResizeCursorDown;
    }

    /**
     * CSS value of cursor displayed when hovering over vertical cursor's resize grip.
     */
    @JsOverlay
    public final void setvResizeCursorHover(String vResizeCursorHover) {
        this.vResizeCursorHover = vResizeCursorHover;
    }

    @JsOverlay
    public final String getAccessibleLabel() {
        return accessibleLabel;
    }

    @JsOverlay
    public final boolean isAutoGridCount() {
        return autoGridCount;
    }

    @JsOverlay
    public final double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    @JsOverlay
    public final String getBackgroundColor() {
        return backgroundColor;
    }

    @JsOverlay
    public final CategoryAxis getCategoryAxis() {
        return categoryAxis;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    @JsOverlay
    public final String getDragCursorDown() {
        return dragCursorDown;
    }

    @JsOverlay
    public final String getDragCursorHover() {
        return dragCursorHover;
    }

    @JsOverlay
    public final String getDragIcon() {
        return dragIcon;
    }

    @JsOverlay
    public final int getDragIconHeight() {
        return dragIconHeight;
    }

    @JsOverlay
    public final int getDragIconWidth() {
        return dragIconWidth;
    }

    @JsOverlay
    public final boolean isEnabled() {
        return enabled;
    }

    @JsOverlay
    public final String getGraph() {
        return graph;
    }

    @JsOverlay
    public final double getGraphFillAlpha() {
        return graphFillAlpha;
    }

    @JsOverlay
    public final String getGraphFillColor() {
        return graphFillColor;
    }

    @JsOverlay
    public final double getGraphLineAlpha() {
        return graphLineAlpha;
    }

    @JsOverlay
    public final String getGraphLineColor() {
        return graphLineColor;
    }

    @JsOverlay
    public final String getGraphType() {
        return graphType;
    }

    @JsOverlay
    public final double getGridAlpha() {
        return gridAlpha;
    }

    @JsOverlay
    public final String getGridColor() {
        return gridColor;
    }

    @JsOverlay
    public final int getGridCount() {
        return gridCount;
    }

    @JsOverlay
    public final boolean isHideResizeGrips() {
        return hideResizeGrips;
    }

    @JsOverlay
    public final String gethResizeCursor() {
        return hResizeCursor;
    }

    @JsOverlay
    public final String gethResizeCursorDown() {
        return hResizeCursorDown;
    }

    @JsOverlay
    public final String gethResizeCursorHover() {
        return hResizeCursorHover;
    }

    @JsOverlay
    public final boolean isIgnoreCustomColors() {
        return ignoreCustomColors;
    }

    @JsOverlay
    public final int getMaximum() {
        return maximum;
    }

    @JsOverlay
    public final int getMinimum() {
        return minimum;
    }

    @JsOverlay
    public final int getOffset() {
        return offset;
    }

    @JsOverlay
    public final boolean isOppositeAxis() {
        return oppositeAxis;
    }

    @JsOverlay
    public final boolean isResizeEnabled() {
        return resizeEnabled;
    }

    @JsOverlay
    public final int getScrollbarHeight() {
        return scrollbarHeight;
    }

    @JsOverlay
    public final int getScrollDuration() {
        return scrollDuration;
    }

    @JsOverlay
    public final double getSelectedBackgroundAlpha() {
        return selectedBackgroundAlpha;
    }

    @JsOverlay
    public final String getSelectedBackgroundColor() {
        return selectedBackgroundColor;
    }

    @JsOverlay
    public final int getSelectedGraphFillAlpha() {
        return selectedGraphFillAlpha;
    }

    @JsOverlay
    public final String getSelectedGraphFillColor() {
        return selectedGraphFillColor;
    }

    @JsOverlay
    public final double getSelectedGraphLineAlpha() {
        return selectedGraphLineAlpha;
    }

    @JsOverlay
    public final String getSelectedGraphLineColor() {
        return selectedGraphLineColor;
    }

    @JsOverlay
    public final int getTabIndex() {
        return tabIndex;
    }

    @JsOverlay
    public final boolean isUpdateOnReleaseOnly() {
        return updateOnReleaseOnly;
    }

    @JsOverlay
    public final String getvResizeCursor() {
        return vResizeCursor;
    }

    @JsOverlay
    public final String getvResizeCursorDown() {
        return vResizeCursorDown;
    }

    @JsOverlay
    public final String getvResizeCursorHover() {
        return vResizeCursorHover;
    }
}
