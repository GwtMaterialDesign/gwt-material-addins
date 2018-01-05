package gwt.material.design.incubator.client.chart.amcharts.options;


import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.events.AmChartEvents;
import gwt.material.design.incubator.client.chart.amcharts.events.HasLegendHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.legend.*;
import gwt.material.design.incubator.client.chart.amcharts.events.object.LegendData;
import gwt.material.design.incubator.client.chart.amcharts.js.AmLegend;
import gwt.material.design.jquery.client.api.Functions;

public class Legend extends ChartOptions implements HasLegendHandlers {

    private AmLegend legend = new AmLegend();

    @Override
    public void load() {
        legend.addListener(AmChartEvents.CLICK_LABEL, object -> ClickLabelEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.CLICK_MARKER, object -> ClickMarkerEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.HIDE_ITEM, object -> HideItemEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.ROLL_OUT_ITEM, object -> RollOutItemEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.ROLL_OVER_ITEM, object -> RollOverItemEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.ROLL_OVER_MARKER, object -> RollOverMarkerEvent.fire(this, (LegendData) object));
        legend.addListener(AmChartEvents.SHOW_ITEM, object -> ShowItemEvent.fire(this, (LegendData) object));
    }

    @Override
    public void unload() {
        // TODO Unload Events
    }

    public String getAccessibleLabel() {
        return legend.accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over the element or sets focus on it using tab key
     * (this is possible only if tabIndex property of AmLegend is set to some number). Text is added as aria-label
     * tag. Note - not all screen readers and browsers support legend. Default to [[title]]
     */

    public void setAccessibleLabel(String accessibleLabel) {
        legend.accessibleLabel = accessibleLabel;
    }


    public String getAlign() {
        return legend.align;
    }

    /**
     * Alignment of legend entries. Possible values are: "left", "center", "right". Default to left
     */

    public void setAlign(String align) {
        legend.align = align;
    }


    public boolean isAutoMargins() {
        return legend.autoMargins;
    }

    /**
     * Used if chart is Serial or XY. In case true, margins of the legend are adjusted and made equal to chart's
     * margins. Default to true
     */

    public void setAutoMargins(boolean autoMargins) {
        legend.autoMargins = autoMargins;
    }


    public double getBackgroundAlpha() {
        return legend.backgroundAlpha;
    }

    /**
     * Opacity of legend's background. Value range is 0 - 1. Default to 0
     */

    public void setBackgroundAlpha(double backgroundAlpha) {
        legend.backgroundAlpha = backgroundAlpha;
    }


    public String getLegendBackgroundColor() {
        return legend.backgroundColor;
    }

    /**
     * Background color. You should set backgroundAlpha to >0 vallue in order background to be visible. Default to
     * #FFFFFF
     */

    public void setLegendBackgroundColor(String backgroundColor) {
        legend.backgroundColor = backgroundColor;
    }


    public int getBorderAlpha() {
        return legend.borderAlpha;
    }

    /**
     * Opacity of chart's border. Value range is 0 - 1. Default to 0
     */

    public void setBorderAlpha(int borderAlpha) {
        legend.borderAlpha = borderAlpha;
    }


    public String getBorderColor() {
        return legend.borderColor;
    }

    /**
     * Color of legend's border. You should set borderAlpha >0 in order border to be visible. Default to #000000
     */

    public void setBorderColor(String borderColor) {
        legend.borderColor = borderColor;
    }


    public int getBottom() {
        return legend.bottom;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from bottom of the chart, in pixels.
     */

    public void setBottom(int bottom) {
        legend.bottom = bottom;
    }


    public String getColor() {
        return legend.color;
    }

    /**
     * Text color. Default to #000000
     */

    public void setColor(String color) {
        legend.color = color;
    }


    public boolean isCombineLegend() {
        return legend.combineLegend;
    }

    /**
     * If you set it to true, and you have some legend items set using legend.data property, both graph’s entries and
     * those added using data property will be displayed. Default to false
     */

    public void setCombineLegend(boolean combineLegend) {
        legend.combineLegend = combineLegend;
    }


    public Object[] getData() {
        return legend.data;
    }

    /**
     * You can pass array of objects with title, color, markerType values, for example:
     * [{title: "One", color: "#3366CC"},{title: "Two", color: "#FFCC33"}]
     */

    public void setData(Object[] data) {
        legend.data = data;
    }


    public String getDivId() {
        return legend.divId;
    }

    /**
     * You can set id of a div or a reference to div object in case you want the legend to be placed in a separate
     * container.
     */

    public void setDivId(String divId) {
        legend.divId = divId;
    }


    public boolean isEnabled() {
        return legend.enabled;
    }

    /**
     * Specifies if legend is enabled or not. Default to true
     */

    public void setEnabled(boolean enabled) {
        legend.enabled = enabled;
    }


    public boolean isEqualWidths() {
        return legend.equalWidths;
    }

    /**
     * Specifies if each of legend entry should be equal to the most wide entry. Won't look good if legend has more
     * than one line. Default to true
     */

    public void setEqualWidths(boolean equalWidths) {
        legend.equalWidths = equalWidths;
    }


    public int getLegendFontSize() {
        return legend.fontSize;
    }

    /**
     * Font size. Default to 11
     */

    public void setLegendFontSize(int fontSize) {
        legend.fontSize = fontSize;
    }


    public boolean isForceWidth() {
        return legend.forceWidth;
    }

    /**
     * If you set this property to true, width of legend item labels won't be adjusted. Useful when you have more than
     * one chart and want to align all the legends. Default to false
     */

    public void setForceWidth(boolean forceWidth) {
        legend.forceWidth = forceWidth;
    }


    public int getGradientRotation() {
        return legend.gradientRotation;
    }

    /**
     * Can be used if legend uses custom data. Set it to 0, 90, 180 or 270.
     */

    public void setGradientRotation(int gradientRotation) {
        legend.gradientRotation = gradientRotation;
    }


    public int getHorizontalGap() {
        return legend.horizontalGap;
    }

    /**
     * Horizontal space between legend item and left/right border. Default to 0
     */

    public void setHorizontalGap(int horizontalGap) {
        legend.horizontalGap = horizontalGap;
    }


    public String getLabelText() {
        return legend.labelText;
    }

    /**
     * The text which will be displayed in the legend. Tag [[title]] will be replaced with the title of the graph.
     * Default to [[title]]
     */

    public void setLabelText(String labelText) {
        legend.labelText = labelText;
    }


    public int getLabelWidth() {
        return legend.labelWidth;
    }

    /**
     * If width of the label is bigger than labelWidth, it will be wrapped.
     */

    public void setLabelWidth(int labelWidth) {
        legend.labelWidth = labelWidth;
    }


    public int getLeft() {
        return legend.left;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from left side of the chart, in pixels.
     */

    public void setLeft(int left) {
        legend.left = left;
    }


    public Object[] getListeners() {
        return legend.listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickLabel",
     * "method":handleEvent}];
     */

    public void setListeners(Object[] listeners) {
        legend.listeners = listeners;
    }


    public int getMarginBottom() {
        return legend.marginBottom;
    }

    /**
     * Bottom margin. Default to 0
     */

    public void setMarginBottom(int marginBottom) {
        legend.marginBottom = marginBottom;
    }


    public int getMarginLeft() {
        return legend.marginLeft;
    }

    /**
     * Left margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */

    public void setMarginLeft(int marginLeft) {
        legend.marginLeft = marginLeft;
    }


    public int getMarginRight() {
        return legend.marginRight;
    }

    /**
     * Right margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */

    public void setMarginRight(int marginRight) {
        legend.marginRight = marginRight;
    }


    public int getMarginTop() {
        return legend.marginTop;
    }

    /**
     * Top margin. Default to 0
     */

    public void setMarginTop(int marginTop) {
        legend.marginTop = marginTop;
    }


    public int getMarkerBorderAlpha() {
        return legend.markerBorderAlpha;
    }

    /**
     * Marker border opacity. Default to 1
     */

    public void setMarkerBorderAlpha(int markerBorderAlpha) {
        legend.markerBorderAlpha = markerBorderAlpha;
    }


    public String getMarkerBorderColor() {
        return legend.markerBorderColor;
    }

    /**
     * Marker border color. If not set, will use the same color as marker.
     */

    public void setMarkerBorderColor(String markerBorderColor) {
        legend.markerBorderColor = markerBorderColor;
    }


    public int getMarkerBorderThickness() {
        return legend.markerBorderThickness;
    }

    /**
     * Thickness of the legend border. The default value (0) means the line will be a "hairline" (1 px). In case marker
     * type is line, this style will be used for line thickness. Default to 1
     */

    public void setMarkerBorderThickness(int markerBorderThickness) {
        legend.markerBorderThickness = markerBorderThickness;
    }


    public String getMarkerDisabledColor() {
        return legend.markerDisabledColor;
    }

    /**
     * The color of the disabled marker (when the graph is hidden). Default to #AAB3B3
     */

    public void setMarkerDisabledColor(String markerDisabledColor) {
        legend.markerDisabledColor = markerDisabledColor;
    }


    public int getMarkerLabelGap() {
        return legend.markerLabelGap;
    }

    /**
     * Space between legend marker and legend text, in pixels. Default to 5
     */

    public void setMarkerLabelGap(int markerLabelGap) {
        legend.markerLabelGap = markerLabelGap;
    }


    public int getMarkerSize() {
        return legend.markerSize;
    }

    /**
     * Size of the legend marker (key). Default to 16
     */

    public void setMarkerSize(int markerSize) {
        legend.markerSize = markerSize;
    }


    public String getMarkerType() {
        return legend.markerType;
    }

    /**
     * Shape of the legend marker (key). Possible values are: square, circle, diamond, triangleUp, triangleDown,
     * triangleLeft, triangleDown, bubble, line, none.
     */

    public void setMarkerType(String markerType) {
        legend.markerType = markerType;
    }


    public int getMaxColumns() {
        return legend.maxColumns;
    }

    /**
     * Maximum number of columns in the legend. If ChartLegend's position is set to "right" or "left", maxColumns is
     * automatically set to 1.
     */

    public void setMaxColumns(int maxColumns) {
        legend.maxColumns = maxColumns;
    }


    public String getPeriodValueText() {
        return legend.periodValueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data
     * point. The tags should be made out of two parts - the name of a field (value / open / close / high / low) and
     * the value of the period you want to be show - open / close / high / low / sum / average / count. For example:
     * [[value.sum]] means that sum of all data points of value field in the selected period will be displayed.
     */

    public void setPeriodValueText(String periodValueText) {
        legend.periodValueText = periodValueText;
    }


    public String getPosition() {
        return legend.position;
    }

    /**
     * Position of a legend. Possible values are: "bottom", "top", "left", "right" and "absolute". In case "absolute",
     * you should set left and top properties too. (this setting is ignored in Stock charts). In case legend is used
     * with AmMap, position is set to "absolute" automatically. Default to bottom
     */

    public void setPosition(String position) {
        legend.position = position;
    }


    public boolean isReversedOrder() {
        return legend.reversedOrder;
    }

    /**
     * Specifies whether legend entries should be placed in reversed order. Default to false
     */

    public void setReversedOrder(boolean reversedOrder) {
        legend.reversedOrder = reversedOrder;
    }


    public int getRight() {
        return legend.right;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from right side of the chart, in pixels.
     */

    public void setRight(int right) {
        legend.right = right;
    }


    public String getRollOverColor() {
        return legend.rollOverColor;
    }

    /**
     * ChartLegend item text color on roll-over. Default #CC0000
     */

    public void setRollOverColor(String rollOverColor) {
        legend.rollOverColor = rollOverColor;
    }


    public double getRollOverGraphAlpha() {
        return legend.rollOverGraphAlpha;
    }

    /**
     * When you roll-over the legend entry, all other graphs can reduce their opacity, so that the graph you rolled-over
     * would be distinguished. This style specifies the opacity of the non-hovered graphs. Default to 1
     */

    public void setRollOverGraphAlpha(double rollOverGraphAlpha) {
        legend.rollOverGraphAlpha = rollOverGraphAlpha;
    }


    public boolean isShowEntries() {
        return legend.showEntries;
    }

    /**
     * You can use this property to turn all the legend entries off. Default to true
     */

    public void setShowEntries(boolean showEntries) {
        legend.showEntries = showEntries;
    }


    public int getSpacing() {
        return legend.spacing;
    }

    /**
     * Horizontal space between legend items, in pixels. Default to 10
     */

    public void setSpacing(int spacing) {
        legend.spacing = spacing;
    }


    public boolean isSwitchable() {
        return legend.switchable;
    }

    /**
     * Whether showing/hiding of graphs by clicking on the legend marker is enabled or not. In case legend is used with
     * AmMap, this is set to false automatically. Default to true
     */

    public void setSwitchable(boolean switchable) {
        legend.switchable = switchable;
    }


    public String getSwitchColor() {
        return legend.switchColor;
    }

    /**
     * ChartLegend switch color. Default to #FFFFFF
     */

    public void setSwitchColor(String switchColor) {
        legend.switchColor = switchColor;
    }


    public String getSwitchType() {
        return legend.switchType;
    }

    /**
     * ChartLegend switch type (in case the legend is switchable). Possible values are "x" and "v". Default to x
     */

    public void setSwitchType(String switchType) {
        legend.switchType = switchType;
    }


    public int getTabIndex() {
        return legend.tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on legend entry when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read label which is set using accessibleLabel property
     * of AmLegend. If legend has switchable set to true, pressing Enter (Return) key will show/hide the graph. Note,
     * not all browsers and readers support legend.
     */

    public void setTabIndex(int tabIndex) {
        legend.tabIndex = tabIndex;
    }


    public boolean isTextClickEnabled() {
        return legend.textClickEnabled;
    }

    /**
     * If true, clicking on the text will show/hide balloon of the graph. Otherwise it will show/hide graph/slice,
     * if switchable is set to true. Default to false
     */

    public void setTextClickEnabled(boolean textClickEnabled) {
        legend.textClickEnabled = textClickEnabled;
    }


    public int getTop() {
        return legend.top;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from top of the chart, in pixels. Default to
     * false
     */

    public void setTop(int top) {
        legend.top = top;
    }


    public boolean isUseGraphSettings() {
        return legend.useGraphSettings;
    }

    /**
     * ChartLegend markers can mirror graph’s settings, displaying a line and a real bullet as in the graph itself.
     * Set this property to true if you want to enable this feature. Note, if you set graph colors in dataProvider,
     * they will not be reflected in the marker. Default to false
     */

    public void setUseGraphSettings(boolean useGraphSettings) {
        legend.useGraphSettings = useGraphSettings;
    }


    public boolean isUseMarkerColorForLabels() {
        return legend.useMarkerColorForLabels;
    }

    /**
     * Labels will use marker color if you set this to true. Default to false
     */

    public void setUseMarkerColorForLabels(boolean useMarkerColorForLabels) {
        legend.useMarkerColorForLabels = useMarkerColorForLabels;
    }


    public boolean isUseMarkerColorForValues() {
        return legend.useMarkerColorForValues;
    }

    /**
     * Specifies if legend values should be use same color as corresponding markers.
     */

    public void setUseMarkerColorForValues(boolean useMarkerColorForValues) {
        legend.useMarkerColorForValues = useMarkerColorForValues;
    }


    public String getValueAlign() {
        return legend.valueAlign;
    }

    /**
     * Alignment of the value text. Possible values are "left" and "right". Default to Right
     */

    public void setValueAlign(String valueAlign) {
        legend.valueAlign = valueAlign;
    }


    public Functions.Func getValueFunction() {
        return legend.valueFunction;
    }

    /**
     * You can use it to format value labels in any way you want. ChartLegend will call this method and will pass
     * GraphDataItem and formatted text of currently hovered item (works only with ChartCursor added to the chart).
     * This method should return legend. string which will be displayed as value in the legend.
     */

    public void setValueFunction(Functions.Func valueFunction) {
        legend.valueFunction = valueFunction;
    }


    public String getValueText() {
        return legend.valueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend. You can use tags like [[value]], [[open]],
     * [[high]], [[low]], [[close]], [[percents]], [[description]]. Default to [[value]]
     */

    public void setValueText(String valueText) {
        legend.valueText = valueText;
    }


    public int getValueWidth() {
        return legend.valueWidth;
    }

    /**
     * Width of the value text. Default to 50
     */

    public void setValueWidth(int valueWidth) {
        legend.valueWidth = valueWidth;
    }


    public int getVerticalGap() {
        return legend.verticalGap;
    }

    /**
     * Vertical space between legend items also between legend border and first and last legend row. Default to 10
     */

    public void setVerticalGap(int verticalGap) {
        legend.verticalGap = verticalGap;
    }


    public int getWidth() {
        return legend.width;
    }

    /**
     * Width of a legend, when position is set to absolute.
     */

    public void setWidth(int width) {
        legend.width = width;
    }

    public AmLegend getLegend() {
        return legend;
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
