package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
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
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmLegend {

    /**
     * Text which screen readers will read if user rolls-over the element or sets focus on it using tab key
     * (this is possible only if tabIndex property of AmLegend is set to some number). Text is added as aria-label
     * tag. Note - not all screen readers and browsers support this. Default to [[title]]
     */
    @JsProperty
    public String accessibleLabel;

    /**
     * Alignment of legend entries. Possible values are: "left", "center", "right". Default to left
     */
    @JsProperty
    public String align;

    /**
     * Used if chart is Serial or XY. In case true, margins of the legend are adjusted and made equal to chart's
     * margins. Default to true
     */
    @JsProperty
    public boolean autoMargins;

    /**
     * Opacity of legend's background. Value range is 0 - 1. Default to 0
     */
    @JsProperty
    public double backgroundAlpha;

    /**
     * Background color. You should set backgroundAlpha to >0 vallue in order background to be visible. Default to
     * #FFFFFF
     */
    @JsProperty
    public String backgroundColor;

    /**
     * Opacity of chart's border. Value range is 0 - 1. Default to 0
     */
    @JsProperty
    public int borderAlpha;

    /**
     * Color of legend's border. You should set borderAlpha >0 in order border to be visible. Default to #000000
     */
    @JsProperty
    public String borderColor;

    /**
     * In case legend position is set to "absolute", you can set distance from bottom of the chart, in pixels.
     */
    @JsProperty
    public int bottom;

    /**
     * Text color. Default to #000000
     */
    @JsProperty
    public String color;

    /**
     * If you set it to true, and you have some legend items set using legend.data property, both graph’s entries and
     * those added using data property will be displayed. Default to false
     */
    @JsProperty
    public boolean combineLegend;

    /**
     * You can pass array of objects with title, color, markerType values, for example:
     * [{title: "One", color: "#3366CC"},{title: "Two", color: "#FFCC33"}]
     */
    @JsProperty
    public Object[] data;

    /**
     * You can set id of a div or a reference to div object in case you want the legend to be placed in a separate
     * container.
     */
    @JsProperty
    public String divId;

    /**
     * Specifies if legend is enabled or not. Default to true
     */
    @JsProperty
    public boolean enabled;

    /**
     * Specifies if each of legend entry should be equal to the most wide entry. Won't look good if legend has more
     * than one line. Default to true
     */
    @JsProperty
    public boolean equalWidths;

    /**
     * Font size. Default to 11
     */
    @JsProperty
    public int fontSize;

    /**
     * If you set this property to true, width of legend item labels won't be adjusted. Useful when you have more than
     * one chart and want to align all the legends. Default to false
     */
    @JsProperty
    public boolean forceWidth;

    /**
     * Can be used if legend uses custom data. Set it to 0, 90, 180 or 270.
     */
    @JsProperty
    public int gradientRotation;

    /**
     * Horizontal space between legend item and left/right border. Default to 0
     */
    @JsProperty
    public int horizontalGap;

    /**
     * The text which will be displayed in the legend. Tag [[title]] will be replaced with the title of the graph.
     * Default to [[title]]
     */
    @JsProperty
    public String labelText;

    /**
     * If width of the label is bigger than labelWidth, it will be wrapped.
     */
    @JsProperty
    public int labelWidth;

    /**
     * In case legend position is set to "absolute", you can set distance from left side of the chart, in pixels.
     */
    @JsProperty
    public int left;

    /**
     * You can add listeners of events using this property. Example: listeners = [{"event":"clickLabel",
     * "method":handleEvent}];
     */
    @JsProperty
    public Object[] listeners;

    /**
     * Bottom margin. Default to 0
     */
    @JsProperty
    public int marginBottom;

    /**
     * Left margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */
    @JsProperty
    public int marginLeft;

    /**
     * Right margin. This property will be ignored if chart is Serial or XY and autoMargins property of the legend is
     * true (default). Default to 20
     */
    @JsProperty
    public int marginRight;

    /**
     * Top margin. Default to 0
     */
    @JsProperty
    public int marginTop;

    /**
     * Marker border opacity. Default to 1
     */
    @JsProperty
    public int markerBorderAlpha;

    /**
     * Marker border color. If not set, will use the same color as marker.
     */
    @JsProperty
    public String markerBorderColor;

    /**
     * Thickness of the legend border. The default value (0) means the line will be a "hairline" (1 px). In case marker
     * type is line, this style will be used for line thickness. Default to 1
     */
    @JsProperty
    public int markerBorderThickness;

    /**
     * The color of the disabled marker (when the graph is hidden). Default to #AAB3B3
     */
    @JsProperty
    public String markerDisabledColor;

    /**
     * Space between legend marker and legend text, in pixels. Default to 5
     */
    @JsProperty
    public int markerLabelGap;

    /**
     * Size of the legend marker (key). Default to 16
     */
    @JsProperty
    public int markerSize;

    /**
     * Shape of the legend marker (key). Possible values are: square, circle, diamond, triangleUp, triangleDown,
     * triangleLeft, triangleDown, bubble, line, none.
     */
    @JsProperty
    public String markerType;

    /**
     * Maximum number of columns in the legend. If Legend's position is set to "right" or "left", maxColumns is
     * automatically set to 1.
     */
    @JsProperty
    public int maxColumns;

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data
     * point. The tags should be made out of two parts - the name of a field (value / open / close / high / low) and
     * the value of the period you want to be show - open / close / high / low / sum / average / count. For example:
     * [[value.sum]] means that sum of all data points of value field in the selected period will be displayed.
     */
    @JsProperty
    public String periodValueText;

    /**
     * Position of a legend. Possible values are: "bottom", "top", "left", "right" and "absolute". In case "absolute",
     * you should set left and top properties too. (this setting is ignored in Stock charts). In case legend is used
     * with AmMap, position is set to "absolute" automatically. Default to bottom
     */
    @JsProperty
    public String position;

    /**
     * Specifies whether legend entries should be placed in reversed order. Default to false
     */
    @JsProperty
    public boolean reversedOrder;

    /**
     * In case legend position is set to "absolute", you can set distance from right side of the chart, in pixels.
     */
    @JsProperty
    public int right;

    /**
     * Legend item text color on roll-over. Default #CC0000
     */
    @JsProperty
    public String rollOverColor;

    /**
     * When you roll-over the legend entry, all other graphs can reduce their opacity, so that the graph you rolled-over
     * would be distinguished. This style specifies the opacity of the non-hovered graphs. Default to 1
     */
    @JsProperty
    public double rollOverGraphAlpha;

    /**
     * You can use this property to turn all the legend entries off. Default to true
     */
    @JsProperty
    public boolean showEntries;

    /**
     * Horizontal space between legend items, in pixels. Default to 10
     */
    @JsProperty
    public int spacing;

    /**
     * Whether showing/hiding of graphs by clicking on the legend marker is enabled or not. In case legend is used with
     * AmMap, this is set to false automatically. Default to true
     */
    @JsProperty
    public boolean switchable;

    /**
     * Legend switch color. Default to #FFFFFF
     */
    @JsProperty
    public String switchColor;

    /**
     * Legend switch type (in case the legend is switchable). Possible values are "x" and "v". Default to x
     */
    @JsProperty
    public String switchType;

    /**
     * In case you set it to some number, the chart will set focus on legend entry when user clicks tab key. When a
     * focus is set, screen readers like NVDA Screen reader will read label which is set using accessibleLabel property
     * of AmLegend. If legend has switchable set to true, pressing Enter (Return) key will show/hide the graph. Note,
     * not all browsers and readers support this.
     */
    @JsProperty
    public int tabIndex;

    /**
     * If true, clicking on the text will show/hide balloon of the graph. Otherwise it will show/hide graph/slice,
     * if switchable is set to true. Default to false
     */
    @JsProperty
    public boolean textClickEnabled;

    /**
     * In case legend position is set to "absolute", you can set distance from top of the chart, in pixels. Default to
     * false
     */
    @JsProperty
    public int top;

    /**
     * Legend markers can mirror graph’s settings, displaying a line and a real bullet as in the graph itself.
     * Set this property to true if you want to enable this feature. Note, if you set graph colors in dataProvider,
     * they will not be reflected in the marker. Default to false
     */
    @JsProperty
    public boolean useGraphSettings;

    /**
     * Labels will use marker color if you set this to true. Default to false
     */
    @JsProperty
    public boolean useMarkerColorForLabels;

    /**
     * Specifies if legend values should be use same color as corresponding markers.
     */
    @JsProperty
    public boolean useMarkerColorForValues;

    /**
     * Alignment of the value text. Possible values are "left" and "right". Default to Right
     */
    @JsProperty
    public String valueAlign;

    /**
     * You can use it to format value labels in any way you want. Legend will call this method and will pass
     * GraphDataItem and formatted text of currently hovered item (works only with ChartCursor added to the chart).
     * This method should return string which will be displayed as value in the legend.
     */
    @JsProperty
    public Functions.Func valueFunction;

    /**
     * The text which will be displayed in the value portion of the legend. You can use tags like [[value]], [[open]],
     * [[high]], [[low]], [[close]], [[percents]], [[description]]. Default to [[value]]
     */
    @JsProperty
    public String valueText;

    /**
     * Width of the value text. Default to 50
     */
    @JsProperty
    public int valueWidth;

    /**
     * Vertical space between legend items also between legend border and first and last legend row. Default to 10
     */
    @JsProperty
    public int verticalGap;

    /**
     * Width of a legend, when position is set to absolute.
     */
    @JsProperty
    public int width;

    /**
     * Adds event listener to the object.
     */
    @JsMethod
    public native void addListener(String type, Functions.EventFunc handler);

    /**
     * Removes event listener from the legend object.
     */
    @JsMethod
    public native void removeListener(AmLegend legend, String type, Functions.EventFunc handler);

    /**
     * Dispatched when legend label is clicked.
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> clickLabel;

    /**
     * Dispatched when legend marker is clicked.
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> clickMarker;

    /**
     * Dispatched when user clicks on a legend item marker and hides corresponding object.
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> hideItem;

    /**
     * Dispatched when user rolls-out of the legend item label (or whole item, if switchable is set to false).
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> rollOutItem;

    /**
     * Dispatched when user rolls-over the legend item label (or whole item, if switchable is set to false).
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> rollOverItem;

    /**
     * Dispatched when user rolls-over the legend item marker.
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> rollOverMarker;

    /**
     * Dispatched when user clicks on a legend item marker and shows corresponding object.
     */
    @JsProperty
    public Functions.EventFunc3<String, Object, AmChart> showItem;
}
