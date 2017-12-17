package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IRectangularChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmRectangularChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartCursor;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import gwt.material.design.incubator.client.chart.amcharts.js.options.TrendLine;

public abstract class RectangularChartChart extends CoordinateChart implements IRectangularChart {

    @Override
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    @Override
    public void setAutoMarginOffset(int autoMarginOffset) {
        getChart().autoMarginOffset = autoMarginOffset;
    }

    @Override
    public void setAutoMargins(boolean autoMargins) {
        getChart().autoMargins = autoMargins;
    }

    @Override
    public void setChartCursor(ChartCursor chartCursor) {
        getChart().chartCursor = chartCursor;
    }

    @Override
    public void setChartScrollbar(ChartScrollbar chartScrollbar) {
        getChart().chartScrollbar = chartScrollbar;
    }

    @Override
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    @Override
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    @Override
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    @Override
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    @Override
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    @Override
    public void setMarginsUpdated(boolean marginsUpdated) {
        getChart().marginsUpdated = marginsUpdated;
    }

    @Override
    public void setMaxZoomFactor(int maxZoomFactor) {
        getChart().maxZoomFactor = maxZoomFactor;
    }

    @Override
    public void setMinMarginBottom(int minMarginBottom) {
        getChart().minMarginBottom = minMarginBottom;
    }

    @Override
    public void setMinMarginLeft(int minMarginLeft) {
        getChart().minMarginLeft = minMarginLeft;
    }

    @Override
    public void setMinMarginRight(int minMarginRight) {
        getChart().minMarginRight = minMarginRight;
    }

    @Override
    public void setMinMarginTop(int minMarginTop) {
        getChart().minMarginTop = minMarginTop;
    }

    @Override
    public void setPlotAreaBorderAlpha(double plotAreaBorderAlpha) {
        getChart().plotAreaBorderAlpha = plotAreaBorderAlpha;
    }

    @Override
    public void setPlotAreaBorderColor(String plotAreaBorderColor) {
        getChart().plotAreaBorderColor = plotAreaBorderColor;
    }

    @Override
    public void setPlotAreaFillAlphas(double plotAreaFillAlphas) {
        getChart().plotAreaFillAlphas = plotAreaFillAlphas;
    }

    @Override
    public void setPlotAreaFillColors(String plotAreaFillColors) {
        getChart().plotAreaFillColors = plotAreaFillColors;
    }

    @Override
    public void setPlotAreaGradientAngle(int plotAreaGradientAngle) {
        getChart().plotAreaGradientAngle = plotAreaGradientAngle;
    }

    @Override
    public void setTrendLines(TrendLine... trendLines) {
        getChart().trendLines = trendLines;
    }

    @Override
    public void setZoomOutButtonAlpha(double zoomOutButtonAlpha) {
        getChart().zoomOutButtonAlpha = zoomOutButtonAlpha;
    }

    @Override
    public void setZoomOutButtonColor(String zoomOutButtonColor) {
        getChart().zoomOutButtonColor = zoomOutButtonColor;
    }

    @Override
    public void setZoomOutButtonImage(String zoomOutButtonImage) {
        getChart().zoomOutButtonImage = zoomOutButtonImage;
    }

    @Override
    public void setZoomOutButtonImageSize(int zoomOutButtonImageSize) {
        getChart().zoomOutButtonImageSize = zoomOutButtonImageSize;
    }

    @Override
    public void setZoomOutButtonPadding(int zoomOutButtonPadding) {
        getChart().zoomOutButtonPadding = zoomOutButtonPadding;
    }

    @Override
    public void setZoomOutButtonRollOverAlpha(double zoomOutButtonRollOverAlpha) {
        getChart().zoomOutButtonRollOverAlpha = zoomOutButtonRollOverAlpha;
    }

    @Override
    public void setZoomOutButtonTabIndex(int zoomOutButtonTabIndex) {
        getChart().zoomOutButtonTabIndex = zoomOutButtonTabIndex;
    }

    @Override
    public void setZoomOutText(String zoomOutText) {
        getChart().zoomOutText = zoomOutText;
    }

    @Override
    public void addChartCursor(ChartCursor chartCursor) {
        getChart().addChartCursor(chartCursor);
    }

    @Override
    public void addChartScrollbar(ChartScrollbar chartScrollBar) {
        getChart().addChartScrollbar(chartScrollBar);
    }

    @Override
    public void addTrendLine(TrendLine trendLine) {
        getChart().addTrendLine(trendLine);
    }

    @Override
    public void removeChartCursor() {
        getChart().removeChartCursor();
    }

    @Override
    public void removeChartScrollbar() {
        getChart().removeChartScrollbar();
    }

    @Override
    public void removeTrendLine(TrendLine trendLine) {
        getChart().removeTrendLine(trendLine);
    }

    @Override
    public void zoomOutValueAxes() {
        getChart().zoomOutValueAxes();
    }

    @Override
    public abstract AmRectangularChart getChart();
}
