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
        return getAmAxis().autoGridCount;
    }

    /**
     * Specifies whether number of gridCount is specified automatically, acoarding to the axis size. Default to true
     */

    public void setAutoGridCount(boolean autoGridCount) {
        getAmAxis().autoGridCount = autoGridCount;
    }

    public int getAutoRotateAngle() {
        return getAmAxis().autoRotateAngle;
    }

    /**
     * Angle of label rotation, if the number of series exceeds autoRotateCount. Works on horizontal axis only. It is
     * not recommended to use it with charts with zoom/scroll features, as chart adjusts margin only based on initial
     * render.
     */

    public void setAutoRotateAngle(int autoRotateAngle) {
        getAmAxis().autoRotateAngle = autoRotateAngle;
    }

    public int getAutoRotateCount() {
        return getAmAxis().autoRotateCount;
    }

    /**
     * If the number of category axis items will exceed the autoRotateCount, the labels will be rotated by
     * autoRotateAngle degree. Works on horizontal axis only. Not recommended with scrollable/zoomable charts.
     */

    public void setAutoRotateCount(int autoRotateCount) {
        getAmAxis().autoRotateCount = autoRotateCount;
    }

    public double getAxisAlpha() {
        return getAmAxis().axisAlpha;
    }

    /**
     * Axis opacity. Value range is 0 - 1. Default to 1
     */

    public void setAxisAlpha(double axisAlpha) {
        getAmAxis().axisAlpha = axisAlpha;
    }

    public String getAxisColor() {
        return getAmAxis().axisColor;
    }

    /**
     * Axis color. Default to #000000
     */

    public void setAxisColor(String axisColor) {
        getAmAxis().axisColor = axisColor;
    }

    public int getAxisThickness() {
        return getAmAxis().axisThickness;
    }

    /**
     * Thickness of the axis. Default to 1
     */

    public void setAxisThickness(int axisThickness) {
        getAmAxis().axisThickness = axisThickness;
    }

    public int getAxisX() {
        return getAmAxis().axisX;
    }

    /**
     * Read-only. Returns x coordinate of the axis.
     */

    public void setAxisX(int axisX) {
        getAmAxis().axisX = axisX;
    }

    public int getAxisY() {
        return getAmAxis().axisY;
    }

    /**
     * Read-only. Returns y coordinate of the axis.
     */

    public void setAxisY(int axisY) {
        getAmAxis().axisY = axisY;
    }

    public AmBalloon getBalloon() {
        return getAmAxis().balloon;
    }

    /**
     * Allows customizing axes balloons individually.
     */

    public void setBalloon(AmBalloon balloon) {
        getAmAxis().balloon = balloon;
    }

    public boolean isBoldLabels() {
        return getAmAxis().boldLabels;
    }

    /**
     * Specifies if axis labels should be bold or not. Default to false
     */

    public void setBoldLabels(boolean boldLabels) {
        getAmAxis().boldLabels = boldLabels;
    }

    public boolean isBoldPeriodBeginning() {
        return getAmAxis().boldPeriodBeginning;
    }

    /**
     * When parse dates is on for the category axis, the chart will try to highlight the beginning of the periods,
     * like month, in bold. Set this to false to disable the functionality. Default to true
     */

    public void setBoldPeriodBeginning(boolean boldPeriodBeginning) {
        getAmAxis().boldPeriodBeginning = boldPeriodBeginning;
    }

    public boolean isCenterLabelOnFullPeriod() {
        return getAmAxis().centerLabelOnFullPeriod;
    }

    /**
     * This setting works only when parseDates is set to true and equalSpacing is set to false. In case you set it to false,
     * labels will never be centered between grid lines. Default to true
     */

    public void setCenterLabelOnFullPeriod(boolean centerLabelOnFullPeriod) {
        getAmAxis().centerLabelOnFullPeriod = centerLabelOnFullPeriod;
    }

    public boolean isCenterLabels() {
        return getAmAxis().centerLabels;
    }

    /**
     * Force-centers labels of date-based axis (in case it's category axis, equalSpacing must be false). Default to false
     */

    public void setCenterLabels(boolean centerLabels) {
        getAmAxis().centerLabels = centerLabels;
    }

    public boolean isCenterRotatedLabels() {
        return getAmAxis().centerRotatedLabels;
    }

    /**
     * In case you have rotated labels on horizontal axis, you can force-center them using this property. Default to false
     */

    public void setCenterRotatedLabels(boolean centerRotatedLabels) {
        getAmAxis().centerRotatedLabels = centerRotatedLabels;
    }

    public String getColor() {
        return getAmAxis().color;
    }

    /**
     * Color of axis value labels. Will use chart's color if not set.
     */

    public void setColor(String color) {
        getAmAxis().color = color;
    }

    public int getDashLength() {
        return getAmAxis().dashLength;
    }

    /**
     * Length of a dash. 0 means line is not dashed. Default to 0
     */

    public void setDashLength(int dashLength) {
        getAmAxis().dashLength = dashLength;
    }

    public Object[] getDateFormats() {
        return getAmAxis().dateFormats;
    }

    /**
     * Date formats of different periods. Possible period values: fff - milliseconds, ss - seconds, mm - minutes,
     * hh - hours, DD - days, MM - months, WW - weeks, YYYY - years. Check this page for date formatting strings.
     */

    public void setDateFormats(Object[] dateFormats) {
        getAmAxis().dateFormats = dateFormats;
    }

    public double getFillAlpha() {
        return getAmAxis().fillAlpha;
    }

    /**
     * Fill opacity. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater
     * than 0 to see the fills. Default to 0
     */

    public void setFillAlpha(double fillAlpha) {
        getAmAxis().fillAlpha = fillAlpha;
    }

    public String getFillColor() {
        return getAmAxis().fillColor;
    }

    /**
     * Fill color. Every second space between grid lines can be filled with color. Set fillAlpha to a value greater than
     * 0 to see the fills. Default to #FFFFFF
     */

    public void setFillColor(String fillColor) {
        getAmAxis().fillColor = fillColor;
    }

    public int getFirstDayOfWeek() {
        return getAmAxis().firstDayOfWeek;
    }

    /**
     * Sets first day of the week. 0 is Sunday, 1 is Monday, etc. Default to 1
     */

    public void setFirstDayOfWeek(int firstDayOfWeek) {
        getAmAxis().firstDayOfWeek = firstDayOfWeek;
    }

    public int getFontSize() {
        return getAmAxis().fontSize;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */

    public void setFontSize(int fontSize) {
        getAmAxis().fontSize = fontSize;
    }

    public double getGridAlpha() {
        return getAmAxis().gridAlpha;
    }

    /**
     * Opacity of grid lines. Default to 0.15
     */

    public void setGridAlpha(double gridAlpha) {
        getAmAxis().gridAlpha = gridAlpha;
    }

    public String getGridColor() {
        return getAmAxis().gridColor;
    }

    /**
     * Color of grid lines. Default to #000000
     */

    public void setGridColor(String gridColor) {
        getAmAxis().gridColor = gridColor;
    }

    public int getGridCount() {
        return getAmAxis().gridCount;
    }

    /**
     * Number of grid lines. In case this is value axis, or your categoryAxis parses dates, the number is approximate.
     * The default value is 5. If you set autoGridCount to true, this property is ignored. Default to 5
     */

    public void setGridCount(int gridCount) {
        getAmAxis().gridCount = gridCount;
    }

    public int getGridThickness() {
        return getAmAxis().gridThickness;
    }

    /**
     * Thickness of grid lines. Default to 1
     */

    public void setGridThickness(int gridThickness) {
        getAmAxis().gridThickness = gridThickness;
    }

    public AmGuide[] getGuides() {
        return getAmAxis().guides;
    }

    /**
     * The array of guides belonging to this axis.
     */

    public void setGuides(Guide... guides) {
        for (int i = 0; i < guides.length; i++) {
            getAmAxis().guides[i] = guides[i].getAmGuide();
        }
    }

    public boolean isIgnoreAxisWidth() {
        return getAmAxis().ignoreAxisWidth;
    }

    /**
     * If autoMargins of a chart is set to true, but you want this axis not to be measured when calculating margin,
     * set ignoreAxisWidth to true. Default to false
     */

    public void setIgnoreAxisWidth(boolean ignoreAxisWidth) {
        getAmAxis().ignoreAxisWidth = ignoreAxisWidth;
    }

    public boolean isInside() {
        return getAmAxis().inside;
    }

    /**
     * Specifies whether values should be placed inside or outside plot area. Default to false
     */

    public void setInside(boolean inside) {
        getAmAxis().inside = inside;
    }

    public int getLabelFrequency() {
        return getAmAxis().labelFrequency;
    }

    /**
     * Frequency at which labels should be placed. Doesn't work for CategoryAxis if parseDates is set to true. Default
     * to 1
     */

    public void setLabelFrequency(int labelFrequency) {
        getAmAxis().labelFrequency = labelFrequency;
    }

    public int getLabelOffset() {
        return getAmAxis().labelOffset;
    }

    /**
     * You can use it to adjust position of axes labels. Works both with CategoryAxis and AmValueAxis. Default to 0
     */

    public void setLabelOffset(int labelOffset) {
        getAmAxis().labelOffset = labelOffset;
    }

    public int getLabelRotation() {
        return getAmAxis().labelRotation;
    }

    /**
     * Rotation angle of a label. Only horizontal axis' values can be rotated. If you set this for vertical axis, the
     * setting will be ignored. Possible values from -90 to 90. Default to 0
     */

    public void setLabelRotation(int labelRotation) {
        getAmAxis().labelRotation = labelRotation;
    }

    public boolean isLabelsEnabled() {
        return getAmAxis().labelsEnabled;
    }

    /**
     * Specifies whether axis displays category axis' labels and value axis' values. Default to true
     */

    public void setLabelsEnabled(boolean labelsEnabled) {
        getAmAxis().labelsEnabled = labelsEnabled;
    }

    public Object[] getListeners() {
        return getAmAxis().listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickItem",
     * "method":handleEvent}];
     */

    public void setListeners(Listener... listeners) {
        getAmAxis().listeners = listeners;
    }

    public boolean isMarkPeriodChange() {
        return getAmAxis().markPeriodChange;
    }

    /**
     * If you set it to false, the start of longer periods won't use a different date format and won't be bold. Default
     * to true
     */

    public void setMarkPeriodChange(boolean markPeriodChange) {
        getAmAxis().markPeriodChange = markPeriodChange;
    }

    public int getMinHorizontalGap() {
        return getAmAxis().minHorizontalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell width
     * required for one span between grid lines. Default to 75
     */

    public void setMinHorizontalGap(int minHorizontalGap) {
        getAmAxis().minHorizontalGap = minHorizontalGap;
    }

    public double getMinorGridAlpha() {
        return getAmAxis().minorGridAlpha;
    }

    /**
     * Opacity of minor grid. In order minor to be visible, you should set minorGridEnabled to true. Default to 0.07
     */

    public void setMinorGridAlpha(double minorGridAlpha) {
        getAmAxis().minorGridAlpha = minorGridAlpha;
    }

    public boolean isMinorGridEnabled() {
        return getAmAxis().minorGridEnabled;
    }

    /**
     * Specifies if minor grid should be displayed. Default to false
     * <p>
     * NOTE: If equalSpacing is set to true, this setting will be ignored.
     */

    public void setMinorGridEnabled(boolean minorGridEnabled) {
        getAmAxis().minorGridEnabled = minorGridEnabled;
    }

    public int getMinorTickLength() {
        return getAmAxis().minorTickLength;
    }

    /**
     * Length of minor grid tick. Default to 0
     */

    public void setMinorTickLength(int minorTickLength) {
        getAmAxis().minorTickLength = minorTickLength;
    }

    public int getMinVerticalGap() {
        return getAmAxis().minVerticalGap;
    }

    /**
     * This property is used when calculating grid count (when autoGridCount is true). It specifies minimum cell height
     * required for one span between grid lines. Default to 35
     */

    public void setMinVerticalGap(int minVerticalGap) {
        getAmAxis().minVerticalGap = minVerticalGap;
    }

    public int getOffset() {
        return getAmAxis().offset;
    }

    /**
     * The distance of the axis to the plot area, in pixels. Negative values can also be used. Default to 0
     */

    public void setOffset(int offset) {
        getAmAxis().offset = offset;
    }

    public String getPosition() {
        return getAmAxis().position;
    }

    /**
     * Possible values are: "top", "bottom", "left", "right". If axis is vertical, default position is "left".
     * If axis is horizontal, default position is "bottom".
     */

    public void setPosition(Position position) {
        getAmAxis().position = position.getName();
    }

    public boolean isShowFirstLabel() {
        return getAmAxis().showFirstLabel;
    }

    /**
     * Whether to show first axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * first label. Default to true
     */

    public void setShowFirstLabel(boolean showFirstLabel) {
        getAmAxis().showFirstLabel = showFirstLabel;
    }

    public boolean isShowLastLabel() {
        return getAmAxis().showLastLabel;
    }

    /**
     * Whether to show last axis label or not. This works properly only on AmValueAxis. With CategoryAxis it wont work
     * 100%, it depends on the period, zooming, etc. There is no guaranteed way to force category axis to show or hide
     * last label. Default to true
     */

    public void setShowLastLabel(boolean showLastLabel) {
        getAmAxis().showLastLabel = showLastLabel;
    }

    public int getTickLength() {
        return getAmAxis().tickLength;
    }

    /**
     * Length of the tick marks. Default to 5
     */

    public void setTickLength(int tickLength) {
        getAmAxis().tickLength = tickLength;
    }

    public String getTitle() {
        return getAmAxis().title;
    }

    /**
     * Title of the axis.
     */

    public void setTitle(String title) {
        getAmAxis().title = title;
    }

    public boolean isTitleBold() {
        return getAmAxis().titleBold;
    }

    /**
     * Specifies if title should be bold or not. Default to true
     */

    public void setTitleBold(boolean titleBold) {
        getAmAxis().titleBold = titleBold;
    }

    public String getTitleColor() {
        return getAmAxis().titleColor;
    }

    /**
     * Color of axis title. Will use text color of chart if not set any.
     */

    public void setTitleColor(String titleColor) {
        getAmAxis().titleColor = titleColor;
    }

    public int getTitleFontSize() {
        return getAmAxis().titleFontSize;
    }

    /**
     * Font size of axis title. Will use font size of chart plus two pixels if not set any.
     */

    public void setTitleFontSize(int titleFontSize) {
        getAmAxis().titleFontSize = titleFontSize;
    }

    public int getTitleRotation() {
        return getAmAxis().titleRotation;
    }

    /**
     * Rotation of axis title. Useful if you want to make vertical axis title to be shown from top to down.
     */

    public void setTitleRotation(int titleRotation) {
        getAmAxis().titleRotation = titleRotation;
    }

    /**
     * Adds guide to the axis.
     */
    public void addGuide(AmGuide guide) {
        getAmAxis().addGuide(guide);
    }

    /**
     * Removes guide from the axis.
     */
    public void removeGuide(AmGuide guide) {
        getAmAxis().removeGuide(guide);
    }

    protected abstract AmAxisBase getAmAxis();

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
