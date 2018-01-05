package gwt.material.design.incubator.client.chart.amcharts.options;

import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.Position;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasAxisHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.axis.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.AxisGuideData;
import gwt.material.design.incubator.client.chart.amcharts.events.object.AxisItemData;
import gwt.material.design.incubator.client.chart.amcharts.events.object.Listener;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmAxisBase;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGuide;

public abstract class AxisBase extends ChartOptions implements HasAxisHandlers {

    protected abstract AmAxisBase getAxis();

    @Override
    public void load() {
        super.load();

        Listener clickItem = new Listener();
        clickItem.setEvent(AmChartEvents.CLICK_ITEM);
        clickItem.setMethod(object -> ClickItemEvent.fire(this, (AxisItemData) object));

        Listener clickGuide = new Listener();
        clickGuide.setEvent(AmChartEvents.CLICK_GUIDE);
        clickGuide.setMethod(object -> ClickGuideEvent.fire(this, (AxisGuideData) object));

        Listener rollOutGuide = new Listener();
        rollOutGuide.setEvent(AmChartEvents.ROLL_OUT_GUIDE);
        rollOutGuide.setMethod(object -> RollOutGuideEvent.fire(this, (AxisGuideData) object));

        Listener rollOverGuide = new Listener();
        rollOverGuide.setEvent(AmChartEvents.ROLL_OVER_GUIDE);
        rollOutGuide.setMethod(object -> RollOverGuideEvent.fire(this, (AxisGuideData) object));

        Listener rollOutGuideItem = new Listener();
        rollOutGuideItem.setEvent(AmChartEvents.ROLL_OUT_ITEM);
        rollOutGuideItem.setMethod(object -> RollOutGuideItemEvent.fire(this, (AxisItemData) object));

        Listener rollOverGuideItem = new Listener();
        rollOverGuideItem.setEvent(AmChartEvents.ROLL_OVER_ITEM);
        rollOverGuideItem.setMethod(object -> RollOverGuideItemEvent.fire(this, (AxisItemData) object));

        setListeners(clickItem, clickGuide, rollOutGuide, rollOverGuide, rollOutGuideItem, rollOverGuideItem);
    }

    @Override
    public void unload() {
        super.unload();

        // TODO Unload events
    }

    public boolean isAutoGridCount() {
        return getAxis().autoGridCount;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, acoarding to the axis size. Default to true
     */

    public void setAutoGridCount(boolean autoGridCount) {
        getAxis().autoGridCount = autoGridCount;
    }

    public int getAutoRotateAngle() {
        return getAxis().autoRotateAngle;
    }

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount. Works on horizontal axis only. It is
     * not recommended to use it with charts with zoom/scroll features, as chart adjusts margin only based on initial
     * render.
     */

    public void setAutoRotateAngle(int autoRotateAngle) {
        getAxis().autoRotateAngle = autoRotateAngle;
    }

    public int getAutoRotateCount() {
        return getAxis().autoRotateCount;
    }

    /**
     * If the number of category axis items will exceed the autoRotateCount, the labels will be rotated by
     * autoRotateAngle degree. Works on horizontal axis only. Not recommended with scrollable/zoomable charts.
     */

    public void setAutoRotateCount(int autoRotateCount) {
        getAxis().autoRotateCount = autoRotateCount;
    }

    public double getAxisAlpha() {
        return getAxis().axisAlpha;
    }

    /**
     * Axis opacity. Value range is 0 - 1. Default to 1
     */

    public void setAxisAlpha(double axisAlpha) {
        getAxis().axisAlpha = axisAlpha;
    }

    public String getAxisColor() {
        return getAxis().axisColor;
    }

    /**
     * Axis color. Default to #000000
     */

    public void setAxisColor(String axisColor) {
        getAxis().axisColor = axisColor;
    }

    public int getAxisThickness() {
        return getAxis().axisThickness;
    }

    /**
     * Thickness of the axis. Default to 1
     */

    public void setAxisThickness(int axisThickness) {
        getAxis().axisThickness = axisThickness;
    }

    public int getAxisX() {
        return getAxis().axisX;
    }

    /**
     * Read-only. Returns x coordinate of the axis.
     */

    public void setAxisX(int axisX) {
        getAxis().axisX = axisX;
    }

    public int getAxisY() {
        return getAxis().axisY;
    }

    /**
     * Read-only. Returns y coordinate of the axis.
     */

    public void setAxisY(int axisY) {
        getAxis().axisY = axisY;
    }

    public AmBalloon getBalloon() {
        return getAxis().balloon;
    }

    /**
     * Allows customizing axes balloons individually.
     */

    public void setBalloon(AmBalloon balloon) {
        getAxis().balloon = balloon;
    }

    public boolean isBoldLabels() {
        return getAxis().boldLabels;
    }

    /**
     * Specifies if axis labels should be bold or not. Default to false
     */

    public void setBoldLabels(boolean boldLabels) {
        getAxis().boldLabels = boldLabels;
    }

    public boolean isBoldPeriodBeginning() {
        return getAxis().boldPeriodBeginning;
    }

    /**
     * When parse dates is on for the category axis, the chart will try to highlight the beginning of the periods,
     * like month, in bold. Set this to false to disable the functionality. Default to true
     */

    public void setBoldPeriodBeginning(boolean boldPeriodBeginning) {
        getAxis().boldPeriodBeginning = boldPeriodBeginning;
    }

    public boolean isCenterLabelOnFullPeriod() {
        return getAxis().centerLabelOnFullPeriod;
    }

    /**
     * This setting works only when parseDates is set to true and equalSpacing is set to false. In case you set it to false,
     * labels will never be centered between grid lines. Default to true
     */

    public void setCenterLabelOnFullPeriod(boolean centerLabelOnFullPeriod) {
        getAxis().centerLabelOnFullPeriod = centerLabelOnFullPeriod;
    }

    public boolean isCenterLabels() {
        return getAxis().centerLabels;
    }

    /**
     * Force-centers labels of date-based axis (in case it's category axis, equalSpacing must be false). Default to false
     */

    public void setCenterLabels(boolean centerLabels) {
        getAxis().centerLabels = centerLabels;
    }

    public boolean isCenterRotatedLabels() {
        return getAxis().centerRotatedLabels;
    }

    /**
     * In case you have rotated labels on horizontal axis, you can force-center them using this property. Default to false
     */

    public void setCenterRotatedLabels(boolean centerRotatedLabels) {
        getAxis().centerRotatedLabels = centerRotatedLabels;
    }

    public String getColor() {
        return getAxis().color;
    }

    /**
     * Color of axis value labels. Will use chart's color if not set.
     */

    public void setColor(String color) {
        getAxis().color = color;
    }

    public int getDashLength() {
        return getAxis().dashLength;
    }

    /**
     * Length of a dash. 0 means line is not dashed. Default to 0
     */

    public void setDashLength(int dashLength) {
        getAxis().dashLength = dashLength;
    }

    public Object[] getDateFormats() {
        return getAxis().dateFormats;
    }

    /**
     * Date formats of different periods. Possible period values: fff - milliseconds, ss - seconds, mm - minutes,
     * hh - hours, DD - days, MM - months, WW - weeks, YYYY - years. Check this page for date formatting strings.
     */

    public void setDateFormats(Object[] dateFormats) {
        getAxis().dateFormats = dateFormats;
    }

    public double getFillAlpha() {
        return getAxis().fillAlpha;
    }

    /**
     * Fill opacity. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater
     * than 0 to see the fills. Default to 0
     */

    public void setFillAlpha(double fillAlpha) {
        getAxis().fillAlpha = fillAlpha;
    }

    public String getFillColor() {
        return getAxis().fillColor;
    }

    /**
     * Fill color. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater than
     * 0 to see the fills. Default to #FFFFFF
     */

    public void setFillColor(String fillColor) {
        getAxis().fillColor = fillColor;
    }

    public int getFirstDayOfWeek() {
        return getAxis().firstDayOfWeek;
    }

    /**
     * Sets first day of the week. 0 is Sunday, 1 is Monday, etc. Default to 1
     */

    public void setFirstDayOfWeek(int firstDayOfWeek) {
        getAxis().firstDayOfWeek = firstDayOfWeek;
    }

    public int getFontSize() {
        return getAxis().fontSize;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */

    public void setFontSize(int fontSize) {
        getAxis().fontSize = fontSize;
    }

    public double getGridAlpha() {
        return getAxis().gridAlpha;
    }

    /**
     * Opacity of grid lines. Default to 0.15
     */

    public void setGridAlpha(double gridAlpha) {
        getAxis().gridAlpha = gridAlpha;
    }

    public String getGridColor() {
        return getAxis().gridColor;
    }

    /**
     * Color of grid lines. Default to #000000
     */

    public void setGridColor(String gridColor) {
        getAxis().gridColor = gridColor;
    }

    public int getGridCount() {
        return getAxis().gridCount;
    }

    /**
     * Number of grid lines. In case this is value axis, or your categoryAxis parses dates, the number is approximate.
     * The default value is 5. If you set autoGridCount to true, this property is ignored. Default to 5
     */

    public void setGridCount(int gridCount) {
        getAxis().gridCount = gridCount;
    }

    public int getGridThickness() {
        return getAxis().gridThickness;
    }

    /**
     * Thickness of grid lines. Default to 1
     */

    public void setGridThickness(int gridThickness) {
        getAxis().gridThickness = gridThickness;
    }

    public AmGuide[] getGuides() {
        return getAxis().guides;
    }

    /**
     * The array of guides belonging to this axis.
     */

    public void setGuides(AmGuide[] guides) {
        getAxis().guides = guides;
    }

    public boolean isIgnoreAxisWidth() {
        return getAxis().ignoreAxisWidth;
    }

    /**
     * If autoMargins of a chart is set to true, but you want this axis not to be measured when calculating margin,
     * set ignoreAxisWidth to true. Default to false
     */

    public void setIgnoreAxisWidth(boolean ignoreAxisWidth) {
        getAxis().ignoreAxisWidth = ignoreAxisWidth;
    }

    public boolean isInside() {
        return getAxis().inside;
    }

    /**
     * Specifies whether values should be placed inside or outside plot area. Default to false
     */

    public void setInside(boolean inside) {
        getAxis().inside = inside;
    }

    public int getLabelFrequency() {
        return getAxis().labelFrequency;
    }

    /**
     * Frequency at which labels should be placed. Doesn't work for CategoryAxis if parseDates is set to true. Default
     * to 1
     */

    public void setLabelFrequency(int labelFrequency) {
        getAxis().labelFrequency = labelFrequency;
    }

    public int getLabelOffset() {
        return getAxis().labelOffset;
    }

    /**
     * You can use it to adjust position of axes labels. Works both with CategoryAxis and AmValueAxis. Default to 0
     */

    public void setLabelOffset(int labelOffset) {
        getAxis().labelOffset = labelOffset;
    }

    public int getLabelRotation() {
        return getAxis().labelRotation;
    }

    /**
     * Rotation angle of a label. Only horizontal axis' values can be rotated. If you set this for vertical axis, the
     * setting will be ignored. Possible values from -90 to 90. Default to 0
     */

    public void setLabelRotation(int labelRotation) {
        getAxis().labelRotation = labelRotation;
    }

    public boolean isLabelsEnabled() {
        return getAxis().labelsEnabled;
    }

    /**
     * Specifies whether axis displays category axis' labels and value axis' values. Default to true
     */

    public void setLabelsEnabled(boolean labelsEnabled) {
        getAxis().labelsEnabled = labelsEnabled;
    }

    public Object[] getListeners() {
        return getAxis().listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickItem",
     * "method":handleEvent}];
     */

    public void setListeners(Listener... listeners) {
        getAxis().listeners = listeners;
    }

    public boolean isMarkPeriodChange() {
        return getAxis().markPeriodChange;
    }

    /**
     * If you set it to false, the start of longer periods won't use a different date format and won't be bold. Default
     * to true
     */

    public void setMarkPeriodChange(boolean markPeriodChange) {
        getAxis().markPeriodChange = markPeriodChange;
    }

    public int getMinHorizontalGap() {
        return getAxis().minHorizontalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell width
     * required for one span between grid lines. Default to 75
     */

    public void setMinHorizontalGap(int minHorizontalGap) {
        getAxis().minHorizontalGap = minHorizontalGap;
    }

    public double getMinorGridAlpha() {
        return getAxis().minorGridAlpha;
    }

    /**
     * Opacity of minor grid. In order minor to be visible, you should set minorGridEnabled to true. Default to 0.07
     */

    public void setMinorGridAlpha(double minorGridAlpha) {
        getAxis().minorGridAlpha = minorGridAlpha;
    }

    public boolean isMinorGridEnabled() {
        return getAxis().minorGridEnabled;
    }

    /**
     * Specifies if minor grid should be displayed. Default to false
     * <p>
     * NOTE: If equalSpacing is set to true, this setting will be ignored.
     */

    public void setMinorGridEnabled(boolean minorGridEnabled) {
        getAxis().minorGridEnabled = minorGridEnabled;
    }

    public int getMinorTickLength() {
        return getAxis().minorTickLength;
    }

    /**
     * Length of minor grid tick. Default to 0
     */

    public void setMinorTickLength(int minorTickLength) {
        getAxis().minorTickLength = minorTickLength;
    }

    public int getMinVerticalGap() {
        return getAxis().minVerticalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell height
     * required for one span between grid lines. Default to 35
     */

    public void setMinVerticalGap(int minVerticalGap) {
        getAxis().minVerticalGap = minVerticalGap;
    }

    public int getOffset() {
        return getAxis().offset;
    }

    /**
     * The distance of the axis to the plot area, in pixels. Negative values can also be used. Default to 0
     */

    public void setOffset(int offset) {
        getAxis().offset = offset;
    }

    public String getPosition() {
        return getAxis().position;
    }

    /**
     * Possible values are: "top", "bottom", "left", "right". If axis is vertical, default position is "left".
     * If axis is horizontal, default position is "bottom".
     */

    public void setPosition(Position position) {
        getAxis().position = position.getName();
    }

    public boolean isShowFirstLabel() {
        return getAxis().showFirstLabel;
    }

    /**
     * Whether to show first axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * first label. Default to true
     */

    public void setShowFirstLabel(boolean showFirstLabel) {
        getAxis().showFirstLabel = showFirstLabel;
    }

    public boolean isShowLastLabel() {
        return getAxis().showLastLabel;
    }

    /**
     * Whether to show last axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * last label. Default to true
     */

    public void setShowLastLabel(boolean showLastLabel) {
        getAxis().showLastLabel = showLastLabel;
    }

    public int getTickLength() {
        return getAxis().tickLength;
    }

    /**
     * Length of the tick marks. Default to 5
     */

    public void setTickLength(int tickLength) {
        getAxis().tickLength = tickLength;
    }

    public String getTitle() {
        return getAxis().title;
    }

    /**
     * Title of the axis.
     */

    public void setTitle(String title) {
        getAxis().title = title;
    }

    public boolean isTitleBold() {
        return getAxis().titleBold;
    }

    /**
     * Specifies if title should be bold or not. Default to true
     */

    public void setTitleBold(boolean titleBold) {
        getAxis().titleBold = titleBold;
    }

    public String getTitleColor() {
        return getAxis().titleColor;
    }

    /**
     * Color of axis title. Will use text color of chart if not set any.
     */

    public void setTitleColor(String titleColor) {
        getAxis().titleColor = titleColor;
    }

    public int getTitleFontSize() {
        return getAxis().titleFontSize;
    }

    /**
     * Font size of axis title. Will use font size of chart plus two pixels if not set any.
     */

    public void setTitleFontSize(int titleFontSize) {
        getAxis().titleFontSize = titleFontSize;
    }

    public int getTitleRotation() {
        return getAxis().titleRotation;
    }

    /**
     * Rotation of axis title. Useful if you want to make vertical axis title to be shown from top to down.
     */

    public void setTitleRotation(int titleRotation) {
        getAxis().titleRotation = titleRotation;
    }

    @Override
    public HandlerRegistration addClickGuideHandler(ClickGuideEvent.ClickGuideHandler handler) {
        return addHandler(ClickGuideEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addClickItemHandler(ClickItemEvent.ClickItemHandler handler) {
        return addHandler(ClickItemEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOutGuideHandler(RollOutGuideEvent.RollOutGuideHandler handler) {
        return addHandler(RollOutGuideEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOutItemHandler(RollOutGuideItemEvent.RollOutGuideItemHandler handler) {
        return addHandler(RollOutGuideItemEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverGuideHandler(RollOverGuideEvent.RollOverGuideHandler handler) {
        return addHandler(RollOverGuideEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverItemHandler(RollOverGuideItemEvent.RollOverGuideItemHandler handler) {
        return addHandler(RollOverGuideItemEvent.getType(), handler);
    }
}
