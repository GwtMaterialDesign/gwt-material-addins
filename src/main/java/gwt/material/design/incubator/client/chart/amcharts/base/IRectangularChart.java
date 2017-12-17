package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import gwt.material.design.incubator.client.chart.amcharts.js.options.TrendLine;

public interface IRectangularChart {

    /**
     * The angle of the 3D part of plot area. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    void setAngle(int angle);

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to 10
     */
    void setAutoMarginOffset(int autoMarginOffset);

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to true
     */
    void setAutoMargins(boolean autoMargins);

    /**
     * Cursor of a chart.
     */
    void setChartCursor(ChartCursor chartCursor);

    /**
     * Chart's scrollbar.
     */
    void setChartScrollbar(ChartScrollbar chartScrollbar);

    /**
     * The depth of the 3D part of plot area. This creates a 3D effect (if the "angle" is > 0). Default to 0
     */
    void setDepth3D(int depth3D);

    /**
     * Number of pixels between the container's bottom border and plot area. This space can be used for bottom axis'
     * values. If autoMargin is true and bottom side has axis, this property is ignored. Default to 20
     */
    void setMarginLeft(int marginLeft);

    /**
     * Number of pixels between the container's left border and plot area. This space can be used for left axis' values.
     * If autoMargin is true and left side has axis, this property is ignored. Default to 20
     */
    void setMarginBottom(int marginBottom);

    /**
     * Number of pixels between the container's right border and plot area. This space can be used for Right axis'
     * values. If autoMargin is true and right side has axis, this property is ignored. Default to 20
     */
    void setMarginRight(int marginRight);

    /**
     * Flag which should be set to false if you need margins to be recalculated on next chart.validateNow() call.
     * Default to false
     */
    void setMarginsUpdated(boolean marginsUpdated);

    /**
     * Number of pixels between the container's top border and plot area. This space can be used for top axis' values.
     * If autoMargin is true and top side has axis, this property is ignored. Default to 20
     */
    void setMarginTop(int marginTop);

    /**
     * Maximum zoom factor value axes. Default to 20
     */
    void setMaxZoomFactor(int maxZoomFactor);

    /**
     * If bottom side has a value axis and autoMargins is set to true (default), the margin of this side will be not
     * less than set on minMarginBottom property.
     */
    void setMinMarginBottom(int minMarginBottom);

    /**
     * If left side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginLeft property.
     */
    void setMinMarginLeft(int minMarginLeft);

    /**
     * If right side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginRight property.
     */
    void setMinMarginRight(int minMarginRight);

    /**
     * If top side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginTop property.
     */
    void setMinMarginTop(int minMarginTop);

    /**
     * The opacity of plot area's border. Value range is 0 - 1. Default to 0
     */
    void setPlotAreaBorderAlpha(double plotAreaBorderAlpha);

    /**
     * The color of the plot area's border. Note, the it is invisible by default, as plotAreaBorderAlpha default value
     * is 0. Set it to a value higher than 0 to make it visible. Default to #000000
     */
    void setPlotAreaBorderColor(String plotAreaBorderColor);

    /**
     * Opacity of plot area. Plural form is used to keep the same property names as our Flex charts'. Flex charts can
     * accept array of numbers to generate gradients. Although you can set array here, only first value of this array
     * will be used. Default to 0
     */
    void setPlotAreaFillAlphas(double plotAreaFillAlphas);

    /**
     * You can set both one color if you need a solid color or array of colors to generate gradients, for example:
     * ["#000000", "#0000CC"]. Default to #FFFFFF
     */
    void setPlotAreaFillColors(String plotAreaFillColors);

    /**
     * If you are using gradients to fill the plot area, you can use this property to set gradient angle. The only
     * allowed values are horizontal and vertical: 0, 90, 180, 270. Default to 0
     */
    void setPlotAreaGradientAngle(int plotAreaGradientAngle);

    /**
     * Array of trend lines added to a chart. You can add trend lines to a chart using this array or access already
     * existing trend lines
     */
    void setTrendLines(TrendLine... trendLines);

    /**
     * Opacity of zoom-out button background. Default to 0
     */
    void setZoomOutButtonAlpha(double zoomOutButtonAlpha);

    /**
     * Zoom-out button background color. Default to #e5e5e5
     */
    void setZoomOutButtonColor(String zoomOutButtonColor);

    /**
     * Name of zoom-out button image. In the images folder there is another lens image, called lensWhite.png.
     * You might want to have white lens when background is dark. Or you can simply use your own image. Note,
     * you don't have to set image extension. If svgIcons is set to true (default) .svg will be added to the
     * file name if SVG is supported by the browser, otherwise – .png. Default to "lens"
     */
    void setZoomOutButtonImage(String zoomOutButtonImage);

    /**
     * Size of zoom-out button image. Default to 17
     */
    void setZoomOutButtonImageSize(int zoomOutButtonImageSize);

    /**
     * Padding around the text and image. Default to 8
     */
    void setZoomOutButtonPadding(int zoomOutButtonPadding);

    /**
     * Opacity of zoom-out button background when mouse is over it. Default to 1
     */
    void setZoomOutButtonRollOverAlpha(double zoomOutButtonRollOverAlpha);

    /**
     * In case you set it to some number, the chart will set focus on zoom-out button when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read zoomOutText. If user clicks Enter when a focus is
     * set, the chart will zoom-out. Note, not all browsers and readers support this.
     */
    void setZoomOutButtonTabIndex(int zoomOutButtonTabIndex);

    /**
     * Text in the zoom-out button. Default to "Show All"
     */
    void setZoomOutText(String zoomOutText);

    /**
     * Adds a {@link ChartCursor} object to a chart
     */
    void addChartCursor(ChartCursor chartCursor);

    /**
     * Adds a {@link ChartScrollbar} to a chart
     */
    void addChartScrollbar(ChartScrollbar chartScrollBar);

    /**
     * Adds a {@link TrendLine} to a chart. You should call chart.validateNow() after this method is called in order the trend
     * line to be visible.
     */
    void addTrendLine(TrendLine trendLine);

    /**
     * Removes cursor from the chart
     */
    void removeChartCursor();

    /**
     * Removes scrollbar from the chart
     */
    void removeChartScrollbar();

    /**
     * Removes a trend line from a chart. You should call chart.validateNow() in order the changes to be visible.
     */
    void removeTrendLine(TrendLine trendLine);

    /**
     * Zooms-out value axes.
     */
    void zoomOutValueAxes();
}
