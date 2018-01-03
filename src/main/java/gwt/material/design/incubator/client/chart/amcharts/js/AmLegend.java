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
package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Creates the legend for the chart, automatically adapts the color settings of the graphs.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmLegend">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmLegend {

    @JsProperty
    public String accessibleLabel;

    @JsProperty
    public String align;

    @JsProperty
    public boolean autoMargins;

    @JsProperty
    public double backgroundAlpha;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public int borderAlpha;

    @JsProperty
    public String borderColor;

    @JsProperty
    public int bottom;

    @JsProperty
    public String color;

    @JsProperty
    public boolean combineLegend;

    @JsProperty
    public Object[] data;

    @JsProperty
    public String divId;

    @JsProperty
    public boolean enabled;

    @JsProperty
    public boolean equalWidths;

    @JsProperty
    public int fontSize;

    @JsProperty
    public boolean forceWidth;

    @JsProperty
    public int gradientRotation;

    @JsProperty
    public int horizontalGap;

    @JsProperty
    public String labelText;

    @JsProperty
    public int labelWidth;

    @JsProperty
    public int left;

    @JsProperty
    public Object[] listeners;

    @JsProperty
    public int marginBottom;

    @JsProperty
    public int marginLeft;

    @JsProperty
    public int marginRight;

    @JsProperty
    public int marginTop;

    @JsProperty
    public int markerBorderAlpha;

    @JsProperty
    public String markerBorderColor;

    @JsProperty
    public int markerBorderThickness;

    @JsProperty
    public String markerDisabledColor;

    @JsProperty
    public int markerLabelGap;

    @JsProperty
    public int markerSize;

    @JsProperty
    public String markerType;

    @JsProperty
    public int maxColumns;

    @JsProperty
    public String periodValueText;

    @JsProperty
    public String position;

    @JsProperty
    public boolean reversedOrder;

    @JsProperty
    public int right;

    @JsProperty
    public String rollOverColor;

    @JsProperty
    public double rollOverGraphAlpha;

    @JsProperty
    public boolean showEntries;

    @JsProperty
    public int spacing;

    @JsProperty
    public boolean switchable;

    @JsProperty
    public String switchColor;

    @JsProperty
    public String switchType;

    @JsProperty
    public int tabIndex;

    @JsProperty
    public boolean textClickEnabled;

    @JsProperty
    public int top;

    @JsProperty
    public boolean useGraphSettings;

    @JsProperty
    public boolean useMarkerColorForLabels;

    @JsProperty
    public boolean useMarkerColorForValues;

    @JsProperty
    public String valueAlign;

    @JsProperty
    public Functions.Func valueFunction;

    @JsProperty
    public String valueText;

    @JsProperty
    public int valueWidth;

    @JsProperty
    public int verticalGap;

    @JsProperty
    public int width;

    @JsOverlay
    public final String getAccessibleLabel() {
        return accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over the element or sets focus on it using tab key
     * (this is possible only if tabIndex property of AmLegend is set to some number). Text is added as aria-label
     * tag. Note - not all screen readers and browsers support this. Default to [[title]]
     */
    @JsOverlay
    public final void setAccessibleLabel(String accessibleLabel) {
        this.accessibleLabel = accessibleLabel;
    }

    @JsOverlay
    public final String getAlign() {
        return align;
    }

    /**
     * Alignment of legend entries. Possible values are: "left", "center", "right". Default to left
     */
    @JsOverlay
    public final void setAlign(String align) {
        this.align = align;
    }

    @JsOverlay
    public final boolean isAutoMargins() {
        return autoMargins;
    }

    /**
     * Used if chart is Serial or XY. In case true, margins of the legend are adjusted and made equal to chart's
     * margins. Default to true
     */
    @JsOverlay
    public final void setAutoMargins(boolean autoMargins) {
        this.autoMargins = autoMargins;
    }

    @JsOverlay
    public final double getBackgroundAlpha() {
        return backgroundAlpha;
    }

    /**
     * Opacity of legend's background. Value range is 0 - 1. Default to 0
     */
    @JsOverlay
    public final void setBackgroundAlpha(double backgroundAlpha) {
        this.backgroundAlpha = backgroundAlpha;
    }

    @JsOverlay
    public final String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Background color. You should set backgroundAlpha to >0 vallue in order background to be visible. Default to
     * #FFFFFF
     */
    @JsOverlay
    public final void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsOverlay
    public final int getBorderAlpha() {
        return borderAlpha;
    }

    /**
     * Opacity of chart's border. Value range is 0 - 1. Default to 0
     */
    @JsOverlay
    public final void setBorderAlpha(int borderAlpha) {
        this.borderAlpha = borderAlpha;
    }

    @JsOverlay
    public final String getBorderColor() {
        return borderColor;
    }

    /**
     * Color of legend's border. You should set borderAlpha >0 in order border to be visible. Default to #000000
     */
    @JsOverlay
    public final void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @JsOverlay
    public final int getBottom() {
        return bottom;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from bottom of the chart, in pixels.
     */
    @JsOverlay
    public final void setBottom(int bottom) {
        this.bottom = bottom;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    /**
     * Text color. Default to #000000
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final boolean isCombineLegend() {
        return combineLegend;
    }

    /**
     * If you set it to true, and you have some legend items set using legend.data property, both graph’s entries and
     * those added using data property will be displayed. Default to false
     */
    @JsOverlay
    public final void setCombineLegend(boolean combineLegend) {
        this.combineLegend = combineLegend;
    }

    @JsOverlay
    public final Object[] getData() {
        return data;
    }

    /**
     * You can pass array of objects with title, color, markerType values, for example:
     * [{title: "One", color: "#3366CC"},{title: "Two", color: "#FFCC33"}]
     */
    @JsOverlay
    public final void setData(Object[] data) {
        this.data = data;
    }

    @JsOverlay
    public final String getDivId() {
        return divId;
    }

    /**
     * You can set id of a div or a reference to div object in case you want the legend to be placed in a separate
     * container.
     */
    @JsOverlay
    public final void setDivId(String divId) {
        this.divId = divId;
    }

    @JsOverlay
    public final boolean isEnabled() {
        return enabled;
    }

    /**
     * Specifies if legend is enabled or not. Default to true
     */
    @JsOverlay
    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @JsOverlay
    public final boolean isEqualWidths() {
        return equalWidths;
    }

    /**
     * Specifies if each of legend entry should be equal to the most wide entry. Won't look good if legend has more
     * than one line. Default to true
     */
    @JsOverlay
    public final void setEqualWidths(boolean equalWidths) {
        this.equalWidths = equalWidths;
    }

    @JsOverlay
    public final int getFontSize() {
        return fontSize;
    }

    /**
     * Font size. Default to 11
     */
    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final boolean isForceWidth() {
        return forceWidth;
    }

    /**
     * If you set this property to true, width of legend item labels won't be adjusted. Useful when you have more than
     * one chart and want to align all the legends. Default to false
     */
    @JsOverlay
    public final void setForceWidth(boolean forceWidth) {
        this.forceWidth = forceWidth;
    }

    @JsOverlay
    public final int getGradientRotation() {
        return gradientRotation;
    }

    /**
     * Can be used if legend uses custom data. Set it to 0, 90, 180 or 270.
     */
    @JsOverlay
    public final void setGradientRotation(int gradientRotation) {
        this.gradientRotation = gradientRotation;
    }

    @JsOverlay
    public final int getHorizontalGap() {
        return horizontalGap;
    }

    /**
     * Horizontal space between legend item and left/right border. Default to 0
     */
    @JsOverlay
    public final void setHorizontalGap(int horizontalGap) {
        this.horizontalGap = horizontalGap;
    }

    @JsOverlay
    public final String getLabelText() {
        return labelText;
    }

    /**
     * The text which will be displayed in the legend. Tag [[title]] will be replaced with the title of the graph.
     * Default to [[title]]
     */
    @JsOverlay
    public final void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    @JsOverlay
    public final int getLabelWidth() {
        return labelWidth;
    }

    /**
     * If width of the label is bigger than labelWidth, it will be wrapped.
     */
    @JsOverlay
    public final void setLabelWidth(int labelWidth) {
        this.labelWidth = labelWidth;
    }

    @JsOverlay
    public final int getLeft() {
        return left;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from left side of the chart, in pixels.
     */
    @JsOverlay
    public final void setLeft(int left) {
        this.left = left;
    }

    @JsOverlay
    public final Object[] getListeners() {
        return listeners;
    }

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickLabel",
     * "method":handleEvent}];
     */
    @JsOverlay
    public final void setListeners(Object[] listeners) {
        this.listeners = listeners;
    }

    @JsOverlay
    public final int getMarginBottom() {
        return marginBottom;
    }

    /**
     * Bottom margin. Default to 0
     */
    @JsOverlay
    public final void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    @JsOverlay
    public final int getMarginLeft() {
        return marginLeft;
    }

    /**
     * Left margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */
    @JsOverlay
    public final void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    @JsOverlay
    public final int getMarginRight() {
        return marginRight;
    }

    /**
     * Right margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */
    @JsOverlay
    public final void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    @JsOverlay
    public final int getMarginTop() {
        return marginTop;
    }

    /**
     * Top margin. Default to 0
     */
    @JsOverlay
    public final void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    @JsOverlay
    public final int getMarkerBorderAlpha() {
        return markerBorderAlpha;
    }

    /**
     * Marker border opacity. Default to 1
     */
    @JsOverlay
    public final void setMarkerBorderAlpha(int markerBorderAlpha) {
        this.markerBorderAlpha = markerBorderAlpha;
    }

    @JsOverlay
    public final String getMarkerBorderColor() {
        return markerBorderColor;
    }

    /**
     * Marker border color. If not set, will use the same color as marker.
     */
    @JsOverlay
    public final void setMarkerBorderColor(String markerBorderColor) {
        this.markerBorderColor = markerBorderColor;
    }

    @JsOverlay
    public final int getMarkerBorderThickness() {
        return markerBorderThickness;
    }

    /**
     * Thickness of the legend border. The default value (0) means the line will be a "hairline" (1 px). In case marker
     * type is line, this style will be used for line thickness. Default to 1
     */
    @JsOverlay
    public final void setMarkerBorderThickness(int markerBorderThickness) {
        this.markerBorderThickness = markerBorderThickness;
    }

    @JsOverlay
    public final String getMarkerDisabledColor() {
        return markerDisabledColor;
    }

    /**
     * The color of the disabled marker (when the graph is hidden). Default to #AAB3B3
     */
    @JsOverlay
    public final void setMarkerDisabledColor(String markerDisabledColor) {
        this.markerDisabledColor = markerDisabledColor;
    }

    @JsOverlay
    public final int getMarkerLabelGap() {
        return markerLabelGap;
    }

    /**
     * Space between legend marker and legend text, in pixels. Default to 5
     */
    @JsOverlay
    public final void setMarkerLabelGap(int markerLabelGap) {
        this.markerLabelGap = markerLabelGap;
    }

    @JsOverlay
    public final int getMarkerSize() {
        return markerSize;
    }

    /**
     * Size of the legend marker (key). Default to 16
     */
    @JsOverlay
    public final void setMarkerSize(int markerSize) {
        this.markerSize = markerSize;
    }

    @JsOverlay
    public final String getMarkerType() {
        return markerType;
    }

    /**
     * Shape of the legend marker (key). Possible values are: square, circle, diamond, triangleUp, triangleDown,
     * triangleLeft, triangleDown, bubble, line, none.
     */
    @JsOverlay
    public final void setMarkerType(String markerType) {
        this.markerType = markerType;
    }

    @JsOverlay
    public final int getMaxColumns() {
        return maxColumns;
    }

    /**
     * Maximum number of columns in the legend. If ChartLegend's position is set to "right" or "left", maxColumns is
     * automatically set to 1.
     */
    @JsOverlay
    public final void setMaxColumns(int maxColumns) {
        this.maxColumns = maxColumns;
    }

    @JsOverlay
    public final String getPeriodValueText() {
        return periodValueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data
     * point. The tags should be made out of two parts - the name of a field (value / open / close / high / low) and
     * the value of the period you want to be show - open / close / high / low / sum / average / count. For example:
     * [[value.sum]] means that sum of all data points of value field in the selected period will be displayed.
     */
    @JsOverlay
    public final void setPeriodValueText(String periodValueText) {
        this.periodValueText = periodValueText;
    }

    @JsOverlay
    public final String getPosition() {
        return position;
    }

    /**
     * Position of a legend. Possible values are: "bottom", "top", "left", "right" and "absolute". In case "absolute",
     * you should set left and top properties too. (this setting is ignored in Stock charts). In case legend is used
     * with AmMap, position is set to "absolute" automatically. Default to bottom
     */
    @JsOverlay
    public final void setPosition(String position) {
        this.position = position;
    }

    @JsOverlay
    public final boolean isReversedOrder() {
        return reversedOrder;
    }

    /**
     * Specifies whether legend entries should be placed in reversed order. Default to false
     */
    @JsOverlay
    public final void setReversedOrder(boolean reversedOrder) {
        this.reversedOrder = reversedOrder;
    }

    @JsOverlay
    public final int getRight() {
        return right;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from right side of the chart, in pixels.
     */
    @JsOverlay
    public final void setRight(int right) {
        this.right = right;
    }

    @JsOverlay
    public final String getRollOverColor() {
        return rollOverColor;
    }

    /**
     * ChartLegend item text color on roll-over. Default #CC0000
     */
    @JsOverlay
    public final void setRollOverColor(String rollOverColor) {
        this.rollOverColor = rollOverColor;
    }

    @JsOverlay
    public final double getRollOverGraphAlpha() {
        return rollOverGraphAlpha;
    }

    /**
     * When you roll-over the legend entry, all other graphs can reduce their opacity, so that the graph you rolled-over
     * would be distinguished. This style specifies the opacity of the non-hovered graphs. Default to 1
     */
    @JsOverlay
    public final void setRollOverGraphAlpha(double rollOverGraphAlpha) {
        this.rollOverGraphAlpha = rollOverGraphAlpha;
    }

    @JsOverlay
    public final boolean isShowEntries() {
        return showEntries;
    }

    /**
     * You can use this property to turn all the legend entries off. Default to true
     */
    @JsOverlay
    public final void setShowEntries(boolean showEntries) {
        this.showEntries = showEntries;
    }

    @JsOverlay
    public final int getSpacing() {
        return spacing;
    }

    /**
     * Horizontal space between legend items, in pixels. Default to 10
     */
    @JsOverlay
    public final void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    @JsOverlay
    public final boolean isSwitchable() {
        return switchable;
    }

    /**
     * Whether showing/hiding of graphs by clicking on the legend marker is enabled or not. In case legend is used with
     * AmMap, this is set to false automatically. Default to true
     */
    @JsOverlay
    public final void setSwitchable(boolean switchable) {
        this.switchable = switchable;
    }

    @JsOverlay
    public final String getSwitchColor() {
        return switchColor;
    }

    /**
     * ChartLegend switch color. Default to #FFFFFF
     */
    @JsOverlay
    public final void setSwitchColor(String switchColor) {
        this.switchColor = switchColor;
    }

    @JsOverlay
    public final String getSwitchType() {
        return switchType;
    }

    /**
     * ChartLegend switch type (in case the legend is switchable). Possible values are "x" and "v". Default to x
     */
    @JsOverlay
    public final void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    @JsOverlay
    public final int getTabIndex() {
        return tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on legend entry when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read label which is set using accessibleLabel property
     * of AmLegend. If legend has switchable set to true, pressing Enter (Return) key will show/hide the graph. Note,
     * not all browsers and readers support this.
     */
    @JsOverlay
    public final void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    @JsOverlay
    public final boolean isTextClickEnabled() {
        return textClickEnabled;
    }

    /**
     * If true, clicking on the text will show/hide balloon of the graph. Otherwise it will show/hide graph/slice,
     * if switchable is set to true. Default to false
     */
    @JsOverlay
    public final void setTextClickEnabled(boolean textClickEnabled) {
        this.textClickEnabled = textClickEnabled;
    }

    @JsOverlay
    public final int getTop() {
        return top;
    }

    /**
     * In case legend position is set to "absolute", you can set distance from top of the chart, in pixels. Default to
     * false
     */
    @JsOverlay
    public final void setTop(int top) {
        this.top = top;
    }

    @JsOverlay
    public final boolean isUseGraphSettings() {
        return useGraphSettings;
    }

    /**
     * ChartLegend markers can mirror graph’s settings, displaying a line and a real bullet as in the graph itself.
     * Set this property to true if you want to enable this feature. Note, if you set graph colors in dataProvider,
     * they will not be reflected in the marker. Default to false
     */
    @JsOverlay
    public final void setUseGraphSettings(boolean useGraphSettings) {
        this.useGraphSettings = useGraphSettings;
    }

    @JsOverlay
    public final boolean isUseMarkerColorForLabels() {
        return useMarkerColorForLabels;
    }

    /**
     * Labels will use marker color if you set this to true. Default to false
     */
    @JsOverlay
    public final void setUseMarkerColorForLabels(boolean useMarkerColorForLabels) {
        this.useMarkerColorForLabels = useMarkerColorForLabels;
    }

    @JsOverlay
    public final boolean isUseMarkerColorForValues() {
        return useMarkerColorForValues;
    }

    /**
     * Specifies if legend values should be use same color as corresponding markers.
     */
    @JsOverlay
    public final void setUseMarkerColorForValues(boolean useMarkerColorForValues) {
        this.useMarkerColorForValues = useMarkerColorForValues;
    }

    @JsOverlay
    public final String getValueAlign() {
        return valueAlign;
    }

    /**
     * Alignment of the value text. Possible values are "left" and "right". Default to Right
     */
    @JsOverlay
    public final void setValueAlign(String valueAlign) {
        this.valueAlign = valueAlign;
    }

    @JsOverlay
    public final Functions.Func getValueFunction() {
        return valueFunction;
    }

    /**
     * You can use it to format value labels in any way you want. ChartLegend will call this method and will pass
     * GraphDataItem and formatted text of currently hovered item (works only with ChartCursor added to the chart).
     * This method should return string which will be displayed as value in the legend.
     */
    @JsOverlay
    public final void setValueFunction(Functions.Func valueFunction) {
        this.valueFunction = valueFunction;
    }

    @JsOverlay
    public final String getValueText() {
        return valueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend. You can use tags like [[value]], [[open]],
     * [[high]], [[low]], [[close]], [[percents]], [[description]]. Default to [[value]]
     */
    @JsOverlay
    public final void setValueText(String valueText) {
        this.valueText = valueText;
    }

    @JsOverlay
    public final int getValueWidth() {
        return valueWidth;
    }

    /**
     * Width of the value text. Default to 50
     */
    @JsOverlay
    public final void setValueWidth(int valueWidth) {
        this.valueWidth = valueWidth;
    }

    @JsOverlay
    public final int getVerticalGap() {
        return verticalGap;
    }

    /**
     * Vertical space between legend items also between legend border and first and last legend row. Default to 10
     */
    @JsOverlay
    public final void setVerticalGap(int verticalGap) {
        this.verticalGap = verticalGap;
    }

    @JsOverlay
    public final int getWidth() {
        return width;
    }

    /**
     * Width of a legend, when position is set to absolute.
     */
    @JsOverlay
    public final void setWidth(int width) {
        this.width = width;
    }

    /**
     * Adds event listener to the object.
     */
    @JsMethod
    public native void addListener(String type, Functions.Func1<Object> handler);

    /**
     * Removes event listener from the legend object.
     */
    @JsMethod
    public native void removeListener(AmLegend legend, String type, Functions.EventFunc handler);
}
