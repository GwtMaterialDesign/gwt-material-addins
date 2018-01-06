package gwt.material.design.incubator.client.chart.amcharts.options;


import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasLegendHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.legend.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.LegendData;
import gwt.material.design.incubator.client.chart.amcharts.js.AmLegend;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Creates the legend for the chart, automatically adapts the color settings of the graphs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmLegend">Official Documentation</a>
 */
//@formatter:on
public class Legend extends ChartOptions implements HasLegendHandlers {

    private AmLegend legend;
    private Functions.Func1<Object> clickLabelEvent, clickMarkerEvent, hideItemEvent, rollOutItemEvent, rollOverItemEvent, rollOverMarkerEvent, showItemEvent;

    @Override
    public void load() {

        clickLabelEvent = object -> ClickLabelEvent.fire(this, (LegendData) object);
        clickMarkerEvent = object -> ClickMarkerEvent.fire(this, (LegendData) object);
        hideItemEvent = object -> HideItemEvent.fire(this, (LegendData) object);
        rollOutItemEvent = object -> RollOutItemEvent.fire(this, (LegendData) object);
        rollOverItemEvent = object -> RollOverItemEvent.fire(this, (LegendData) object);
        rollOverMarkerEvent = object -> RollOverMarkerEvent.fire(this, (LegendData) object);
        showItemEvent = object -> ShowItemEvent.fire(this, (LegendData) object);

        addListener(AmChartEvents.CLICK_LABEL, clickLabelEvent);
        addListener(AmChartEvents.CLICK_MARKER, clickMarkerEvent);
        addListener(AmChartEvents.HIDE_ITEM, hideItemEvent);
        addListener(AmChartEvents.ROLL_OUT_ITEM, rollOutItemEvent);
        addListener(AmChartEvents.ROLL_OVER_ITEM, rollOverItemEvent);
        addListener(AmChartEvents.ROLL_OVER_MARKER, rollOverMarkerEvent);
        addListener(AmChartEvents.SHOW_ITEM, showItemEvent);
    }

    @Override
    public void unload() {
        removeListener(getAmLegend(), AmChartEvents.CLICK_LABEL, clickLabelEvent);
        removeListener(getAmLegend(), AmChartEvents.CLICK_MARKER, clickMarkerEvent);
        removeListener(getAmLegend(), AmChartEvents.HIDE_ITEM, hideItemEvent);
        removeListener(getAmLegend(), AmChartEvents.ROLL_OUT_ITEM, rollOutItemEvent);
        removeListener(getAmLegend(), AmChartEvents.ROLL_OVER_ITEM, rollOverMarkerEvent);
        removeListener(getAmLegend(), AmChartEvents.ROLL_OVER_MARKER, rollOverMarkerEvent);
        removeListener(getAmLegend(), AmChartEvents.SHOW_ITEM, showItemEvent);
    }

    public String getAccessibleLabel() {
        return getAmLegend().accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over the element or sets focus on it using tab key
     * (this is possible only if tabIndex property of AmLegend is set to some number). Text is added as aria-label
     * tag. Note - not all screen readers and browsers support getAmLegend(). Default to [[title]]
     */

    public void setAccessibleLabel(String accessibleLabel) {
        getAmLegend().accessibleLabel = accessibleLabel;
    }


    public String getAlign() {
        return getAmLegend().align;
    }

    /**
     * Alignment of legend entries. Possible values are: "left", "center", "right". Default to left
     */

    public void setAlign(String align) {
        getAmLegend().align = align;
    }


    public boolean isAutoMargins() {
        return getAmLegend().autoMargins;
    }

    /**
     * Used if chart is Serial or XY. In case true, margins of the legend are adjusted and made equal to chart's
     * margins. Default to true
     */

    public void setAutoMargins(boolean autoMargins) {
        getAmLegend().autoMargins = autoMargins;
    }


    public double getBackgroundAlpha() {
        return getAmLegend().backgroundAlpha;
    }

    /**
     * Opacity of legend's background. Value range is 0 - 1. Default to 0
     */

    public void setBackgroundAlpha(double backgroundAlpha) {
        getAmLegend().backgroundAlpha = backgroundAlpha;
    }


    public String getLegendBackgroundColor() {
        return getAmLegend().backgroundColor;
    }

    /**
     * Background color. You should set backgroundAlpha to >0 vallue in order background to be visible. Default to
     * #FFFFFF
     */

    public void setLegendBackgroundColor(String backgroundColor) {
        getAmLegend().backgroundColor = backgroundColor;
    }


    public int getBorderAlpha() {
        return getAmLegend().borderAlpha;
    }

    /**
     * Opacity of chart's border. Value range is 0 - 1. Default to 0
     */

    public void setBorderAlpha(int borderAlpha) {
        getAmLegend().borderAlpha = borderAlpha;
    }


    public String getBorderColor() {
        return getAmLegend().borderColor;
    }

    /**
     * Color of legend's border. You should set borderAlpha >0 in order border to be visible. Default to #000000
     */

    public void setBorderColor(String borderColor) {
        getAmLegend().borderColor = borderColor;
    }


    public int getBottom() {
        return getAmLegend().bottom;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from bottom of the chart, in pixels.
     */

    public void setBottom(int bottom) {
        getAmLegend().bottom = bottom;
    }


    public String getColor() {
        return getAmLegend().color;
    }

    /**
     * Text color. Default to #000000
     */

    public void setColor(String color) {
        getAmLegend().color = color;
    }


    public boolean isCombineLegend() {
        return getAmLegend().combineLegend;
    }

    /**
     * If you set it to true, and you have some legend items set using getAmLegend().data property, both graph’s entries and
     * those added using data property will be displayed. Default to false
     */

    public void setCombineLegend(boolean combineLegend) {
        getAmLegend().combineLegend = combineLegend;
    }


    public Object[] getData() {
        return getAmLegend().data;
    }

    /**
     * You can pass array of objects with title, color, markerType values, for example:
     * [{title: "One", color: "#3366CC"},{title: "Two", color: "#FFCC33"}]
     */

    public void setData(Object[] data) {
        getAmLegend().data = data;
    }


    public String getDivId() {
        return getAmLegend().divId;
    }

    /**
     * You can set id of a div or a reference to div object in case you want the legend to be placed in a separate
     * container.
     */

    public void setDivId(String divId) {
        getAmLegend().divId = divId;
    }


    public boolean isEnabled() {
        return getAmLegend().enabled;
    }

    /**
     * Specifies if legend is enabled or not. Default to true
     */

    public void setEnabled(boolean enabled) {
        getAmLegend().enabled = enabled;
    }


    public boolean isEqualWidths() {
        return getAmLegend().equalWidths;
    }

    /**
     * Specifies if each of legend entry should be equal to the most wide entry. Won't look good if legend has more
     * than one line. Default to true
     */

    public void setEqualWidths(boolean equalWidths) {
        getAmLegend().equalWidths = equalWidths;
    }


    public int getLegendFontSize() {
        return getAmLegend().fontSize;
    }

    /**
     * Font size. Default to 11
     */

    public void setLegendFontSize(int fontSize) {
        getAmLegend().fontSize = fontSize;
    }


    public boolean isForceWidth() {
        return getAmLegend().forceWidth;
    }

    /**
     * If you set this property to true, width of legend item labels won't be adjusted. Useful when you have more than
     * one chart and want to align all the legends. Default to false
     */

    public void setForceWidth(boolean forceWidth) {
        getAmLegend().forceWidth = forceWidth;
    }


    public int getGradientRotation() {
        return getAmLegend().gradientRotation;
    }

    /**
     * Can be used if legend uses custom data. Set it to 0, 90, 180 or 270.
     */

    public void setGradientRotation(int gradientRotation) {
        getAmLegend().gradientRotation = gradientRotation;
    }


    public int getHorizontalGap() {
        return getAmLegend().horizontalGap;
    }

    /**
     * Horizontal space between legend item and left/right border. Default to 0
     */

    public void setHorizontalGap(int horizontalGap) {
        getAmLegend().horizontalGap = horizontalGap;
    }


    public String getLabelText() {
        return getAmLegend().labelText;
    }

    /**
     * The text which will be displayed in the getAmLegend(). Tag [[title]] will be replaced with the title of the graph.
     * Default to [[title]]
     */

    public void setLabelText(String labelText) {
        getAmLegend().labelText = labelText;
    }


    public int getLabelWidth() {
        return getAmLegend().labelWidth;
    }

    /**
     * If width of the label is bigger than labelWidth, it will be wrapped.
     */

    public void setLabelWidth(int labelWidth) {
        getAmLegend().labelWidth = labelWidth;
    }


    public int getLeft() {
        return getAmLegend().left;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from left side of the chart, in pixels.
     */

    public void setLeft(int left) {
        getAmLegend().left = left;
    }


    public Object[] getListeners() {
        return getAmLegend().listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickLabel",
     * "method":handleEvent}];
     */

    public void setListeners(Object[] listeners) {
        getAmLegend().listeners = listeners;
    }


    public int getMarginBottom() {
        return getAmLegend().marginBottom;
    }

    /**
     * Bottom margin. Default to 0
     */

    public void setMarginBottom(int marginBottom) {
        getAmLegend().marginBottom = marginBottom;
    }


    public int getMarginLeft() {
        return getAmLegend().marginLeft;
    }

    /**
     * Left margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */

    public void setMarginLeft(int marginLeft) {
        getAmLegend().marginLeft = marginLeft;
    }


    public int getMarginRight() {
        return getAmLegend().marginRight;
    }

    /**
     * Right margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */

    public void setMarginRight(int marginRight) {
        getAmLegend().marginRight = marginRight;
    }


    public int getMarginTop() {
        return getAmLegend().marginTop;
    }

    /**
     * Top margin. Default to 0
     */

    public void setMarginTop(int marginTop) {
        getAmLegend().marginTop = marginTop;
    }


    public int getMarkerBorderAlpha() {
        return getAmLegend().markerBorderAlpha;
    }

    /**
     * Marker border opacity. Default to 1
     */

    public void setMarkerBorderAlpha(int markerBorderAlpha) {
        getAmLegend().markerBorderAlpha = markerBorderAlpha;
    }


    public String getMarkerBorderColor() {
        return getAmLegend().markerBorderColor;
    }

    /**
     * Marker border color. If not set, will use the same color as marker.
     */

    public void setMarkerBorderColor(String markerBorderColor) {
        getAmLegend().markerBorderColor = markerBorderColor;
    }


    public int getMarkerBorderThickness() {
        return getAmLegend().markerBorderThickness;
    }

    /**
     * Thickness of the legend border. The default value (0) means the line will be a "hairline" (1 px). In case marker
     * type is line, this style will be used for line thickness. Default to 1
     */

    public void setMarkerBorderThickness(int markerBorderThickness) {
        getAmLegend().markerBorderThickness = markerBorderThickness;
    }


    public String getMarkerDisabledColor() {
        return getAmLegend().markerDisabledColor;
    }

    /**
     * The color of the disabled marker (when the graph is hidden). Default to #AAB3B3
     */

    public void setMarkerDisabledColor(String markerDisabledColor) {
        getAmLegend().markerDisabledColor = markerDisabledColor;
    }


    public int getMarkerLabelGap() {
        return getAmLegend().markerLabelGap;
    }

    /**
     * Space between legend marker and legend text, in pixels. Default to 5
     */

    public void setMarkerLabelGap(int markerLabelGap) {
        getAmLegend().markerLabelGap = markerLabelGap;
    }


    public int getMarkerSize() {
        return getAmLegend().markerSize;
    }

    /**
     * Size of the legend marker (key). Default to 16
     */

    public void setMarkerSize(int markerSize) {
        getAmLegend().markerSize = markerSize;
    }


    public String getMarkerType() {
        return getAmLegend().markerType;
    }

    /**
     * Shape of the legend marker (key). Possible values are: square, circle, diamond, triangleUp, triangleDown,
     * triangleLeft, triangleDown, bubble, line, none.
     */

    public void setMarkerType(String markerType) {
        getAmLegend().markerType = markerType;
    }


    public int getMaxColumns() {
        return getAmLegend().maxColumns;
    }

    /**
     * Maximum number of columns in the getAmLegend(). If ChartLegend's position is set to "right" or "left", maxColumns is
     * automatically set to 1.
     */

    public void setMaxColumns(int maxColumns) {
        getAmLegend().maxColumns = maxColumns;
    }


    public String getPeriodValueText() {
        return getAmLegend().periodValueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data
     * point. The tags should be made out of two parts - the name of a field (value / open / close / high / low) and
     * the value of the period you want to be show - open / close / high / low / sum / average / count. For example:
     * [[value.sum]] means that sum of all data points of value field in the selected period will be displayed.
     */

    public void setPeriodValueText(String periodValueText) {
        getAmLegend().periodValueText = periodValueText;
    }


    public String getPosition() {
        return getAmLegend().position;
    }

    /**
     * Position of a getAmLegend(). Possible values are: "bottom", "top", "left", "right" and "absolute". In case "absolute",
     * you should set left and top properties too. (this setting is ignored in Stock charts). In case legend is used
     * with AmMap, position is set to "absolute" automatically. Default to bottom
     */

    public void setPosition(String position) {
        getAmLegend().position = position;
    }


    public boolean isReversedOrder() {
        return getAmLegend().reversedOrder;
    }

    /**
     * Specifies whether legend entries should be placed in reversed order. Default to false
     */

    public void setReversedOrder(boolean reversedOrder) {
        getAmLegend().reversedOrder = reversedOrder;
    }


    public int getRight() {
        return getAmLegend().right;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from right side of the chart, in pixels.
     */

    public void setRight(int right) {
        getAmLegend().right = right;
    }


    public String getRollOverColor() {
        return getAmLegend().rollOverColor;
    }

    /**
     * ChartLegend item text color on roll-over. Default #CC0000
     */

    public void setRollOverColor(String rollOverColor) {
        getAmLegend().rollOverColor = rollOverColor;
    }


    public double getRollOverGraphAlpha() {
        return getAmLegend().rollOverGraphAlpha;
    }

    /**
     * When you roll-over the legend entry, all other graphs can reduce their opacity, so that the graph you rolled-over
     * would be distinguished. This style specifies the opacity of the non-hovered graphs. Default to 1
     */

    public void setRollOverGraphAlpha(double rollOverGraphAlpha) {
        getAmLegend().rollOverGraphAlpha = rollOverGraphAlpha;
    }


    public boolean isShowEntries() {
        return getAmLegend().showEntries;
    }

    /**
     * You can use this property to turn all the legend entries off. Default to true
     */

    public void setShowEntries(boolean showEntries) {
        getAmLegend().showEntries = showEntries;
    }


    public int getSpacing() {
        return getAmLegend().spacing;
    }

    /**
     * Horizontal space between legend items, in pixels. Default to 10
     */

    public void setSpacing(int spacing) {
        getAmLegend().spacing = spacing;
    }


    public boolean isSwitchable() {
        return getAmLegend().switchable;
    }

    /**
     * Whether showing/hiding of graphs by clicking on the legend marker is enabled or not. In case legend is used with
     * AmMap, this is set to false automatically. Default to true
     */

    public void setSwitchable(boolean switchable) {
        getAmLegend().switchable = switchable;
    }


    public String getSwitchColor() {
        return getAmLegend().switchColor;
    }

    /**
     * ChartLegend switch color. Default to #FFFFFF
     */

    public void setSwitchColor(String switchColor) {
        getAmLegend().switchColor = switchColor;
    }


    public String getSwitchType() {
        return getAmLegend().switchType;
    }

    /**
     * ChartLegend switch type (in case the legend is switchable). Possible values are "x" and "v". Default to x
     */

    public void setSwitchType(String switchType) {
        getAmLegend().switchType = switchType;
    }


    public int getTabIndex() {
        return getAmLegend().tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on legend entry when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read label which is set using accessibleLabel property
     * of AmgetAmLegend(). If legend has switchable set to true, pressing Enter (Return) key will show/hide the graph. Note,
     * not all browsers and readers support getAmLegend().
     */

    public void setTabIndex(int tabIndex) {
        getAmLegend().tabIndex = tabIndex;
    }


    public boolean isTextClickEnabled() {
        return getAmLegend().textClickEnabled;
    }

    /**
     * If true, clicking on the text will show/hide balloon of the graph. Otherwise it will show/hide graph/slice,
     * if switchable is set to true. Default to false
     */

    public void setTextClickEnabled(boolean textClickEnabled) {
        getAmLegend().textClickEnabled = textClickEnabled;
    }


    public int getTop() {
        return getAmLegend().top;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from top of the chart, in pixels. Default to
     * false
     */

    public void setTop(int top) {
        getAmLegend().top = top;
    }


    public boolean isUseGraphSettings() {
        return getAmLegend().useGraphSettings;
    }

    /**
     * ChartLegend markers can mirror graph’s settings, displaying a line and a real bullet as in the graph itself.
     * Set this property to true if you want to enable this feature. Note, if you set graph colors in dataProvider,
     * they will not be reflected in the marker. Default to false
     */

    public void setUseGraphSettings(boolean useGraphSettings) {
        getAmLegend().useGraphSettings = useGraphSettings;
    }


    public boolean isUseMarkerColorForLabels() {
        return getAmLegend().useMarkerColorForLabels;
    }

    /**
     * Labels will use marker color if you set this to true. Default to false
     */

    public void setUseMarkerColorForLabels(boolean useMarkerColorForLabels) {
        getAmLegend().useMarkerColorForLabels = useMarkerColorForLabels;
    }


    public boolean isUseMarkerColorForValues() {
        return getAmLegend().useMarkerColorForValues;
    }

    /**
     * Specifies if legend values should be use same color as corresponding markers.
     */

    public void setUseMarkerColorForValues(boolean useMarkerColorForValues) {
        getAmLegend().useMarkerColorForValues = useMarkerColorForValues;
    }


    public String getValueAlign() {
        return getAmLegend().valueAlign;
    }

    /**
     * Alignment of the value text. Possible values are "left" and "right". Default to Right
     */

    public void setValueAlign(String valueAlign) {
        getAmLegend().valueAlign = valueAlign;
    }


    public Functions.Func getValueFunction() {
        return getAmLegend().valueFunction;
    }

    /**
     * You can use it to format value labels in any way you want. ChartLegend will call this method and will pass
     * GraphDataItem and formatted text of currently hovered item (works only with ChartCursor added to the chart).
     * This method should return getAmLegend(). string which will be displayed as value in the getAmLegend().
     */

    public void setValueFunction(Functions.Func valueFunction) {
        getAmLegend().valueFunction = valueFunction;
    }


    public String getValueText() {
        return getAmLegend().valueText;
    }

    /**
     * The text which will be displayed in the value portion of the getAmLegend(). You can use tags like [[value]], [[open]],
     * [[high]], [[low]], [[close]], [[percents]], [[description]]. Default to [[value]]
     */

    public void setValueText(String valueText) {
        getAmLegend().valueText = valueText;
    }


    public int getValueWidth() {
        return getAmLegend().valueWidth;
    }

    /**
     * Width of the value text. Default to 50
     */

    public void setValueWidth(int valueWidth) {
        getAmLegend().valueWidth = valueWidth;
    }


    public int getVerticalGap() {
        return getAmLegend().verticalGap;
    }

    /**
     * Vertical space between legend items also between legend border and first and last legend row. Default to 10
     */

    public void setVerticalGap(int verticalGap) {
        getAmLegend().verticalGap = verticalGap;
    }


    public int getWidth() {
        return getAmLegend().width;
    }

    /**
     * Width of a legend, when position is set to absolute.
     */

    public void setWidth(int width) {
        getAmLegend().width = width;
    }

    public AmLegend getAmLegend() {
        if (legend == null) {
            legend = new AmLegend();
        }
        return legend;
    }

    /**
     * Adds event listener to the object.
     */
    public void addListener(String type, Functions.Func1<Object> handler) {
        getAmLegend().addListener(type, handler);
    }

    /**
     * Removes event listener from the legend object.
     */
    public void removeListener(AmLegend legend, String type, Functions.Func1<Object> handler) {
        getAmLegend().removeListener(legend, type, handler);
    }

    @Override
    public HandlerRegistration addClickLabelHandler(ClickLabelEvent.ClickLabelHandler handler) {
        return addHandler(ClickLabelEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addClickMarkerHandler(ClickMarkerEvent.ClickMarkerHandler handler) {
        return addHandler(ClickMarkerEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addHideItemHandler(HideItemEvent.HideItemHandler handler) {
        return addHandler(HideItemEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOutItemHandler(RollOutItemEvent.RollOutItemHandler handler) {
        return addHandler(RollOutItemEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverItemHandler(RollOverItemEvent.RollOverItemHandler handler) {
        return addHandler(RollOverItemEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addRollOverMarkerHandler(RollOverMarkerEvent.RollOverMarkerHandler handler) {
        return addHandler(RollOverMarkerEvent.getType(), handler);
    }

    @Override
    public HandlerRegistration addShowItemHandler(ShowItemEvent.ShowItemHandler handler) {
        return addHandler(ShowItemEvent.getType(), handler);
    }
}
