package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Position;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmAxisBase;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGuide;

public abstract class AxisBase extends ChartOptions {

    private AmAxisBase axisBase = new AmAxisBase();

    protected abstract AmAxisBase getAxis();

    public boolean isAutoGridCount() {
        return axisBase.autoGridCount;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, acoarding to the axis size. Default to true
     */

    public void setAutoGridCount(boolean autoGridCount) {
        axisBase.autoGridCount = autoGridCount;
    }

    public int getAutoRotateAngle() {
        return axisBase.autoRotateAngle;
    }

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount. Works on horizontal axis only. It is
     * not recommended to use it with charts with zoom/scroll features, as chart adjusts margin only based on initial
     * render.
     */

    public void setAutoRotateAngle(int autoRotateAngle) {
        axisBase.autoRotateAngle = autoRotateAngle;
    }

    public int getAutoRotateCount() {
        return axisBase.autoRotateCount;
    }

    /**
     * If the number of category axis items will exceed the autoRotateCount, the labels will be rotated by
     * autoRotateAngle degree. Works on horizontal axis only. Not recommended with scrollable/zoomable charts.
     */

    public void setAutoRotateCount(int autoRotateCount) {
        axisBase.autoRotateCount = autoRotateCount;
    }

    public double getAxisAlpha() {
        return axisBase.axisAlpha;
    }

    /**
     * Axis opacity. Value range is 0 - 1. Default to 1
     */

    public void setAxisAlpha(double axisAlpha) {
        axisBase.axisAlpha = axisAlpha;
    }

    public String getAxisColor() {
        return axisBase.axisColor;
    }

    /**
     * Axis color. Default to #000000
     */

    public void setAxisColor(String axisColor) {
        axisBase.axisColor = axisColor;
    }

    public int getAxisThickness() {
        return axisBase.axisThickness;
    }

    /**
     * Thickness of the axis. Default to 1
     */

    public void setAxisThickness(int axisThickness) {
        axisBase.axisThickness = axisThickness;
    }

    public int getAxisX() {
        return axisBase.axisX;
    }

    /**
     * Read-only. Returns x coordinate of the axis.
     */

    public void setAxisX(int axisX) {
        axisBase.axisX = axisX;
    }

    public int getAxisY() {
        return axisBase.axisY;
    }

    /**
     * Read-only. Returns y coordinate of the axis.
     */

    public void setAxisY(int axisY) {
        axisBase.axisY = axisY;
    }

    public AmBalloon getBalloon() {
        return axisBase.balloon;
    }

    /**
     * Allows customizing axes balloons individually.
     */

    public void setBalloon(AmBalloon balloon) {
        axisBase.balloon = balloon;
    }

    public boolean isBoldLabels() {
        return axisBase.boldLabels;
    }

    /**
     * Specifies if axis labels should be bold or not. Default to false
     */

    public void setBoldLabels(boolean boldLabels) {
        axisBase.boldLabels = boldLabels;
    }

    public boolean isBoldPeriodBeginning() {
        return axisBase.boldPeriodBeginning;
    }

    /**
     * When parse dates is on for the category axis, the chart will try to highlight the beginning of the periods,
     * like month, in bold. Set this to false to disable the functionality. Default to true
     */

    public void setBoldPeriodBeginning(boolean boldPeriodBeginning) {
        axisBase.boldPeriodBeginning = boldPeriodBeginning;
    }

    public boolean isCenterLabelOnFullPeriod() {
        return axisBase.centerLabelOnFullPeriod;
    }

    /**
     * This setting works only when parseDates is set to true and equalSpacing is set to false. In case you set it to false,
     * labels will never be centered between grid lines. Default to true
     */

    public void setCenterLabelOnFullPeriod(boolean centerLabelOnFullPeriod) {
        axisBase.centerLabelOnFullPeriod = centerLabelOnFullPeriod;
    }

    public boolean isCenterLabels() {
        return axisBase.centerLabels;
    }

    /**
     * Force-centers labels of date-based axis (in case it's category axis, equalSpacing must be false). Default to false
     */

    public void setCenterLabels(boolean centerLabels) {
        axisBase.centerLabels = centerLabels;
    }

    public boolean isCenterRotatedLabels() {
        return axisBase.centerRotatedLabels;
    }

    /**
     * In case you have rotated labels on horizontal axis, you can force-center them using this property. Default to false
     */

    public void setCenterRotatedLabels(boolean centerRotatedLabels) {
        axisBase.centerRotatedLabels = centerRotatedLabels;
    }

    public String getColor() {
        return axisBase.color;
    }

    /**
     * Color of axis value labels. Will use chart's color if not set.
     */

    public void setColor(String color) {
        axisBase.color = color;
    }

    public int getDashLength() {
        return axisBase.dashLength;
    }

    /**
     * Length of a dash. 0 means line is not dashed. Default to 0
     */

    public void setDashLength(int dashLength) {
        axisBase.dashLength = dashLength;
    }

    public Object[] getDateFormats() {
        return axisBase.dateFormats;
    }

    /**
     * Date formats of different periods. Possible period values: fff - milliseconds, ss - seconds, mm - minutes,
     * hh - hours, DD - days, MM - months, WW - weeks, YYYY - years. Check this page for date formatting strings.
     */

    public void setDateFormats(Object[] dateFormats) {
        axisBase.dateFormats = dateFormats;
    }

    public double getFillAlpha() {
        return axisBase.fillAlpha;
    }

    /**
     * Fill opacity. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater
     * than 0 to see the fills. Default to 0
     */

    public void setFillAlpha(double fillAlpha) {
        axisBase.fillAlpha = fillAlpha;
    }

    public String getFillColor() {
        return axisBase.fillColor;
    }

    /**
     * Fill color. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater than
     * 0 to see the fills. Default to #FFFFFF
     */

    public void setFillColor(String fillColor) {
        axisBase.fillColor = fillColor;
    }

    public int getFirstDayOfWeek() {
        return axisBase.firstDayOfWeek;
    }

    /**
     * Sets first day of the week. 0 is Sunday, 1 is Monday, etc. Default to 1
     */

    public void setFirstDayOfWeek(int firstDayOfWeek) {
        axisBase.firstDayOfWeek = firstDayOfWeek;
    }

    public int getFontSize() {
        return axisBase.fontSize;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */

    public void setFontSize(int fontSize) {
        axisBase.fontSize = fontSize;
    }

    public double getGridAlpha() {
        return axisBase.gridAlpha;
    }

    /**
     * Opacity of grid lines. Default to 0.15
     */

    public void setGridAlpha(double gridAlpha) {
        axisBase.gridAlpha = gridAlpha;
    }

    public String getGridColor() {
        return axisBase.gridColor;
    }

    /**
     * Color of grid lines. Default to #000000
     */

    public void setGridColor(String gridColor) {
        axisBase.gridColor = gridColor;
    }

    public int getGridCount() {
        return axisBase.gridCount;
    }

    /**
     * Number of grid lines. In case this is value axis, or your categoryAxis parses dates, the number is approximate.
     * The default value is 5. If you set autoGridCount to true, this property is ignored. Default to 5
     */

    public void setGridCount(int gridCount) {
        axisBase.gridCount = gridCount;
    }

    public int getGridThickness() {
        return axisBase.gridThickness;
    }

    /**
     * Thickness of grid lines. Default to 1
     */

    public void setGridThickness(int gridThickness) {
        axisBase.gridThickness = gridThickness;
    }

    public AmGuide[] getGuides() {
        return axisBase.guides;
    }

    /**
     * The array of guides belonging to this axis.
     */

    public void setGuides(AmGuide[] guides) {
        axisBase.guides = guides;
    }

    public boolean isIgnoreAxisWidth() {
        return axisBase.ignoreAxisWidth;
    }

    /**
     * If autoMargins of a chart is set to true, but you want this axis not to be measured when calculating margin,
     * set ignoreAxisWidth to true. Default to false
     */

    public void setIgnoreAxisWidth(boolean ignoreAxisWidth) {
        axisBase.ignoreAxisWidth = ignoreAxisWidth;
    }

    public boolean isInside() {
        return axisBase.inside;
    }

    /**
     * Specifies whether values should be placed inside or outside plot area. Default to false
     */

    public void setInside(boolean inside) {
        axisBase.inside = inside;
    }

    public int getLabelFrequency() {
        return axisBase.labelFrequency;
    }

    /**
     * Frequency at which labels should be placed. Doesn't work for CategoryAxis if parseDates is set to true. Default
     * to 1
     */

    public void setLabelFrequency(int labelFrequency) {
        axisBase.labelFrequency = labelFrequency;
    }

    public int getLabelOffset() {
        return axisBase.labelOffset;
    }

    /**
     * You can use it to adjust position of axes labels. Works both with CategoryAxis and AmValueAxis. Default to 0
     */

    public void setLabelOffset(int labelOffset) {
        axisBase.labelOffset = labelOffset;
    }

    public int getLabelRotation() {
        return axisBase.labelRotation;
    }

    /**
     * Rotation angle of a label. Only horizontal axis' values can be rotated. If you set this for vertical axis, the
     * setting will be ignored. Possible values from -90 to 90. Default to 0
     */

    public void setLabelRotation(int labelRotation) {
        axisBase.labelRotation = labelRotation;
    }

    public boolean isLabelsEnabled() {
        return axisBase.labelsEnabled;
    }

    /**
     * Specifies whether axis displays category axis' labels and value axis' values. Default to true
     */

    public void setLabelsEnabled(boolean labelsEnabled) {
        axisBase.labelsEnabled = labelsEnabled;
    }

    public Object[] getListeners() {
        return axisBase.listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickItem",
     * "method":handleEvent}];
     */

    public void setListeners(Object[] listeners) {
        axisBase.listeners = listeners;
    }

    public boolean isMarkPeriodChange() {
        return axisBase.markPeriodChange;
    }

    /**
     * If you set it to false, the start of longer periods won't use a different date format and won't be bold. Default
     * to true
     */

    public void setMarkPeriodChange(boolean markPeriodChange) {
        axisBase.markPeriodChange = markPeriodChange;
    }

    public int getMinHorizontalGap() {
        return axisBase.minHorizontalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell width
     * required for one span between grid lines. Default to 75
     */

    public void setMinHorizontalGap(int minHorizontalGap) {
        axisBase.minHorizontalGap = minHorizontalGap;
    }

    public double getMinorGridAlpha() {
        return axisBase.minorGridAlpha;
    }

    /**
     * Opacity of minor grid. In order minor to be visible, you should set minorGridEnabled to true. Default to 0.07
     */

    public void setMinorGridAlpha(double minorGridAlpha) {
        axisBase.minorGridAlpha = minorGridAlpha;
    }

    public boolean isMinorGridEnabled() {
        return axisBase.minorGridEnabled;
    }

    /**
     * Specifies if minor grid should be displayed. Default to false
     * <p>
     * NOTE: If equalSpacing is set to true, this setting will be ignored.
     */

    public void setMinorGridEnabled(boolean minorGridEnabled) {
        axisBase.minorGridEnabled = minorGridEnabled;
    }

    public int getMinorTickLength() {
        return axisBase.minorTickLength;
    }

    /**
     * Length of minor grid tick. Default to 0
     */

    public void setMinorTickLength(int minorTickLength) {
        axisBase.minorTickLength = minorTickLength;
    }

    public int getMinVerticalGap() {
        return axisBase.minVerticalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell height
     * required for one span between grid lines. Default to 35
     */

    public void setMinVerticalGap(int minVerticalGap) {
        axisBase.minVerticalGap = minVerticalGap;
    }

    public int getOffset() {
        return axisBase.offset;
    }

    /**
     * The distance of the axis to the plot area, in pixels. Negative values can also be used. Default to 0
     */

    public void setOffset(int offset) {
        axisBase.offset = offset;
    }

    public String getPosition() {
        return axisBase.position;
    }

    /**
     * Possible values are: "top", "bottom", "left", "right". If axis is vertical, default position is "left".
     * If axis is horizontal, default position is "bottom".
     */

    public void setPosition(Position position) {
        axisBase.position = position.getName();
    }

    public boolean isShowFirstLabel() {
        return axisBase.showFirstLabel;
    }

    /**
     * Whether to show first axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * first label. Default to true
     */

    public void setShowFirstLabel(boolean showFirstLabel) {
        axisBase.showFirstLabel = showFirstLabel;
    }

    public boolean isShowLastLabel() {
        return axisBase.showLastLabel;
    }

    /**
     * Whether to show last axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * last label. Default to true
     */

    public void setShowLastLabel(boolean showLastLabel) {
        axisBase.showLastLabel = showLastLabel;
    }

    public int getTickLength() {
        return axisBase.tickLength;
    }

    /**
     * Length of the tick marks. Default to 5
     */

    public void setTickLength(int tickLength) {
        axisBase.tickLength = tickLength;
    }

    public String getTitle() {
        return axisBase.title;
    }

    /**
     * Title of the axis.
     */

    public void setTitle(String title) {
        axisBase.title = title;
    }

    public boolean isTitleBold() {
        return axisBase.titleBold;
    }

    /**
     * Specifies if title should be bold or not. Default to true
     */

    public void setTitleBold(boolean titleBold) {
        axisBase.titleBold = titleBold;
    }

    public String getTitleColor() {
        return axisBase.titleColor;
    }

    /**
     * Color of axis title. Will use text color of chart if not set any.
     */

    public void setTitleColor(String titleColor) {
        axisBase.titleColor = titleColor;
    }

    public int getTitleFontSize() {
        return axisBase.titleFontSize;
    }

    /**
     * Font size of axis title. Will use font size of chart plus two pixels if not set any.
     */

    public void setTitleFontSize(int titleFontSize) {
        axisBase.titleFontSize = titleFontSize;
    }

    public int getTitleRotation() {
        return axisBase.titleRotation;
    }

    /**
     * Rotation of axis title. Useful if you want to make vertical axis title to be shown from top to down.
     */

    public void setTitleRotation(int titleRotation) {
        axisBase.titleRotation = titleRotation;
    }
}
