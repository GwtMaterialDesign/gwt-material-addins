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
package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmRectangularChart;
import gwt.material.design.incubator.client.chart.amcharts.options.ChartCursor;
import gwt.material.design.incubator.client.chart.amcharts.options.ChartScrollbar;
import gwt.material.design.incubator.client.chart.amcharts.options.TrendLine;

//@formatter:off

/**
 * Extension for {@link CoordinateChart} and base class of {@link SerialChart} and {@link XyChart}. It can not be
 * instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRectangularChart">Official Documentation</a>
 */
//@formatter:on
public abstract class RectangularChart extends CoordinateChart {

    public RectangularChart(ChartType chartType) {
        super(chartType);
    }

    /**
     * The angle of the 3D part of plot area. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to 10
     */
    public void setAutoMarginOffset(int autoMarginOffset) {
        getChart().autoMarginOffset = autoMarginOffset;
    }

    /**
     * Space left from axis labels/title to the chart's outside border, if autoMargins set to true. Default to true
     */
    public void setAutoMargins(boolean autoMargins) {
        getChart().autoMargins = autoMargins;
    }

    /**
     * Cursor of a chart.
     */
    public void setChartCursor(ChartCursor chartCursor) {
        getChart().chartCursor = chartCursor.getChartCursor();
    }

    /**
     * Chart's scrollbar.
     */
    public void setChartScrollbar(ChartScrollbar chartScrollbar) {
        getChart().chartScrollbar = chartScrollbar.getChartScrollbar();
    }

    /**
     * The depth of the 3D part of plot area. This creates a 3D effect (if the "angle" is > 0). Default to 0
     */
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    /**
     * Number of pixels between the container's bottom border and plot area. This space can be used for bottom axis'
     * values. If autoMargin is true and bottom side has axis, this property is ignored. Default to 20
     */
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    /**
     * Number of pixels between the container's bottom border and plot area. This space can be used for left axis' values.
     * If autoMargin is true and left side has axis, this property is ignored. Default to 20
     */
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    /**
     * Number of pixels between the container's right border and plot area. This space can be used for Right axis'
     * values. If autoMargin is true and right side has axis, this property is ignored. Default to 20
     */
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    /**
     * Number of pixels between the container's top border and plot area. This space can be used for top axis' values.
     * If autoMargin is true and top side has axis, this property is ignored. Default to 20
     */
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    /**
     * Flag which should be set to false if you need margins to be recalculated on next chart.validateNow() call.
     * Default to false
     */
    public void setMarginsUpdated(boolean marginsUpdated) {
        getChart().marginsUpdated = marginsUpdated;
    }

    /**
     * Maximum zoom factor value axes. Default to 20
     */
    public void setMaxZoomFactor(int maxZoomFactor) {
        getChart().maxZoomFactor = maxZoomFactor;
    }

    /**
     * If bottom side has a value axis and autoMargins is set to true (default), the margin of this side will be not
     * less than set on minMarginBottom property.
     */
    public void setMinMarginBottom(int minMarginBottom) {
        getChart().minMarginBottom = minMarginBottom;
    }

    /**
     * If left side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginLeft property.
     */
    public void setMinMarginLeft(int minMarginLeft) {
        getChart().minMarginLeft = minMarginLeft;
    }

    /**
     * If right side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginRight property.
     */
    public void setMinMarginRight(int minMarginRight) {
        getChart().minMarginRight = minMarginRight;
    }

    /**
     * If top side has a value axis and autoMargins is set to true (default), the margin of this side will be not less
     * than set on minMarginTop property.
     */
    public void setMinMarginTop(int minMarginTop) {
        getChart().minMarginTop = minMarginTop;
    }

    /**
     * The opacity of plot area's border. Value range is 0 - 1. Default to 0
     */
    public void setPlotAreaBorderAlpha(double plotAreaBorderAlpha) {
        getChart().plotAreaBorderAlpha = plotAreaBorderAlpha;
    }

    /**
     * The color of the plot area's border. Note, the it is invisible by default, as plotAreaBorderAlpha default value
     * is 0. Set it to a value higher than 0 to make it visible. Default to #000000
     */
    public void setPlotAreaBorderColor(String plotAreaBorderColor) {
        getChart().plotAreaBorderColor = plotAreaBorderColor;
    }

    /**
     * Opacity of plot area. Plural form is used to keep the same property names as our Flex charts'. Flex charts can
     * accept array of numbers to generate gradients. Although you can set array here, only first value of this array
     * will be used. Default to 0
     */
    public void setPlotAreaFillAlphas(double plotAreaFillAlphas) {
        getChart().plotAreaFillAlphas = plotAreaFillAlphas;
    }

    /**
     * You can set both one color if you need a solid color or array of colors to generate gradients, for example:
     * ["#000000", "#0000CC"]. Default to #FFFFFF
     */
    public void setPlotAreaFillColors(String plotAreaFillColors) {
        getChart().plotAreaFillColors = plotAreaFillColors;
    }

    /**
     * If you are using gradients to fill the plot area, you can use this property to set gradient angle. The only
     * allowed values are horizontal and vertical: 0, 90, 180, 270. Default to 0
     */
    public void setPlotAreaGradientAngle(int plotAreaGradientAngle) {
        getChart().plotAreaGradientAngle = plotAreaGradientAngle;
    }

    /**
     * Array of trend lines added to a chart. You can add trend lines to a chart using this array or access already
     * existing trend lines
     */
    public void setTrendLines(TrendLine... trendLines) {
        for (int i = 0; i < trendLines.length; i++) {
            getChart().trendLines[i] = trendLines[i].getTrendLine();
        }
    }

    /**
     * Opacity of zoom-out button background. Default to 0
     */
    public void setZoomOutButtonAlpha(double zoomOutButtonAlpha) {
        getChart().zoomOutButtonAlpha = zoomOutButtonAlpha;
    }

    /**
     * Zoom-out button background color. Default to #e5e5e5
     */
    public void setZoomOutButtonColor(String zoomOutButtonColor) {
        getChart().zoomOutButtonColor = zoomOutButtonColor;
    }

    /**
     * Name of zoom-out button image. In the images folder there is another lens image, called lensWhite.png.
     * You might want to have white lens when background is dark. Or you can simply use your own image. Note,
     * you don't have to set image extension. If svgIcons is set to true (default) .svg will be added to the
     * file name if SVG is supported by the browser, otherwise – .png. Default to "lens"
     */
    public void setZoomOutButtonImage(String zoomOutButtonImage) {
        getChart().zoomOutButtonImage = zoomOutButtonImage;
    }

    /**
     * Size of zoom-out button image. Default to 17
     */
    public void setZoomOutButtonImageSize(int zoomOutButtonImageSize) {
        getChart().zoomOutButtonImageSize = zoomOutButtonImageSize;
    }

    /**
     * Padding around the text and image. Default to 8
     */
    public void setZoomOutButtonPadding(int zoomOutButtonPadding) {
        getChart().zoomOutButtonPadding = zoomOutButtonPadding;
    }

    /**
     * Opacity of zoom-out button background when mouse is over it. Default to 1
     */
    public void setZoomOutButtonRollOverAlpha(double zoomOutButtonRollOverAlpha) {
        getChart().zoomOutButtonRollOverAlpha = zoomOutButtonRollOverAlpha;
    }

    /**
     * In case you set it to some number, the chart will set focus on zoom-out button when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read zoomOutText. If user clicks Enter when a focus is
     * set, the chart will zoom-out. Note, not all browsers and readers support this.
     */
    public void setZoomOutButtonTabIndex(int zoomOutButtonTabIndex) {
        getChart().zoomOutButtonTabIndex = zoomOutButtonTabIndex;
    }

    /**
     * Text in the zoom-out button. Default to "Show All"
     */
    public void setZoomOutText(String zoomOutText) {
        getChart().zoomOutText = zoomOutText;
    }

    /**
     * Adds a {@link ChartCursor} object to a chart
     */
    public void addChartCursor(ChartCursor chartCursor) {
        getChart().addChartCursor(chartCursor.getChartCursor());
    }

    /**
     * Adds a {@link ChartScrollbar} to a chart
     */
    public void addChartScrollbar(ChartScrollbar chartScrollBar) {
        getChart().addChartScrollbar(chartScrollBar.getChartScrollbar());
    }

    /**
     * Adds a {@link TrendLine} to a chart. You should call chart.validateNow() after this method is called in order the trend
     * line to be visible.
     */
    public void addTrendLine(TrendLine trendLine) {
        getChart().addTrendLine(trendLine.getTrendLine());
    }

    /**
     * Removes cursor from the chart
     */
    public void removeChartCursor() {
        getChart().removeChartCursor();
    }

    /**
     * Removes scrollbar from the chart
     */
    public void removeChartScrollbar() {
        getChart().removeChartScrollbar();
    }

    /**
     * Removes a trend line from a chart. You should call chart.validateNow() in order the changes to be visible.
     */
    public void removeTrendLine(TrendLine trendLine) {
        getChart().removeTrendLine(trendLine.getTrendLine());
    }

    /**
     * Zooms-out value axes.
     */
    public void zoomOutValueAxes() {
        getChart().zoomOutValueAxes();
    }

    @Override
    public abstract AmRectangularChart getChart();
}
