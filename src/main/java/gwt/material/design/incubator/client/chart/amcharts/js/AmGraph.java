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

import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Creates the visualization of the data in following types: line, column, step line, smoothed line, olhc and candlestick.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmGraph">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmGraph {

    /**
     * Text which screen readers will read if user rolls-over the bullet/column or sets focus using tab key (this is
     * possible only if tabIndex property of AmGraph is set to some number). Text is added as aria-label tag. Note -
     * not all screen readers and browsers support this.
     */
    @JsProperty
    private String accessibleLabel;

    /**
     * Name of the alpha field in your dataProvider.
     */
    @JsProperty
    private String alphaField;

    /**
     * If you set this to true before chart is drawn, the animation of this graph won't be played.
     */
    @JsProperty
    private boolean animationPlayed;

    /**
     * Allows customizing graphs balloons individually (only when ChartCursor is used). Note: the balloon object is not
     * created automatically, you should create it before setting properties
     */
    @JsProperty
    private AmBalloon balloon;

    /**
     * Value balloon color. Will use graph or data item color if not set.
     */
    @JsProperty
    private String ballonColor;

    /**
     * If you set some function, the graph will call it and pass GraphDataItem and AmGraph objects to it. This function
     * should return a string which will be displayed in a balloon.
     */
    @JsProperty
    private Functions.Func balloonFunction;

    /**
     * Balloon text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]] or any other
     * field name from your data provider. HTML tags can also be used.
     */
    @JsProperty
    private String balloonText;

    /**
     * Specifies if the line graph should be placed behind column graphs
     */
    @JsProperty
    private boolean behindColumns;

    /**
     * Type of the bullets. Possible values are: "none", "round", "square", "triangleUp", "triangleDown",
     * "triangleLeft", "triangleRight", "bubble", "diamond", "xError", "yError" and "custom".
     */
    @JsProperty
    private String bullet;

    /**
     * Opacity of bullets. Value range is 0 - 1.
     */
    @JsProperty
    private int bulletAlpha;

    // TODO Turn to ValueAxis
    /**
     * bulletAxis value is used when you are building error chart. Error chart is a regular serial or XY chart with
     * bullet type set to "xError" or "yError". The graph should know which axis should be used to determine the size
     * of this bullet - that's when bulletAxis should be set. Besides that, you should also set graph.errorField.
     * You can also use other bullet types with this feature too. For example, if you set bulletAxis for XY chart,
     * the size of a bullet will change as you zoom the chart.
     */
    @JsProperty
    private Object bulletAxis;

    /**
     * Bullet border opacity.
     */
    @JsProperty
    private int bulletBorderAlpha;

    /**
     * Bullet border color. Will use lineColor if not set.
     */
    @JsProperty
    private String bulletBorderColor;

    /**
     * Bullet border thickness.
     */
    @JsProperty
    private String bulletBorderThickness;

    /**
     * Bullet color. Will use lineColor if not set.
     */
    @JsProperty
    private String bulletColor;

    /**
     * Name of the bullet field in your dataProvider.
     */
    @JsProperty
    private String bulletField;

    /**
     * Useful for touch devices - if you set it to 20 or so, the bullets of a graph will have invisible circle around
     * the actual bullet (bullets should still be enabled), which will be easier to touch (bullets usually are smaller
     * and hard to hit).
     */
    @JsProperty
    private int bulletHitAreaSize;

    /**
     * Bullet offset. Distance from the actual data point to the bullet. Can be used to place custom bullets above
     * the columns.
     */
    @JsProperty
    private int bulletOffset;

    /**
     * Bullet size.
     */
    @JsProperty
    private int bulletSize;

    /**
     * Name of the bullet size field in your dataProvider.
     */
    @JsProperty
    private String bulletSizeField;

    /**
     * If this field is set and addClassNames is enabled, the chart will look for a class name string in data using
     * this setting and apply additional class names to elements of the particular data points, such as bullets.
     */
    @JsProperty
    private String classNameField;

    /**
     * Name of the close field (used by candlesticks and ohlc) in your dataProvider.
     */
    @JsProperty
    private String closeField;

    /**
     * In case you want to place this graph's columns in front of other columns, set this to false. In case "true",
     * the columns will be clustered next to each other.
     * NOTE: clustering works only for graphs of type "column".
     */
    @JsProperty
    private String clustered;

    /**
     * Color of value labels. Will use chart's color if not set.
     */
    @JsProperty
    private String color;

    /**
     * Name of the color field in your dataProvider.
     */
    @JsProperty
    private String colorField;

    /**
     * You can use this property with non-stacked column graphs and specify order of columns of each category
     * (starting from 0). Important: this feature does not work in stacked columns scenarios as well as with graph
     * toggling enabled in legend.
     */
    @JsProperty
    private String columnIndexField;

    /**
     * You can specify custom column width for each graph individually. Value range is 0 - 1 (we set relative width,
     * not pixel width here).
     */
    @JsProperty
    private String columnWidth;

    /**
     * Specifies whether to connect data points if data is missing. The default value is true. This feature does
     * not work with XY chart.
     */
    @JsProperty
    private boolean connect;

    /**
     * Corner radius of column. It can be set both in pixels or in percents. The chart's depth and angle styles must
     * be set to 0. The default value is 0. Note, cornerRadiusTop will be applied for all corners of the column,
     * JavaScript charts do not have a possibility to set separate corner radius for top and bottom. As we want all
     * the property names to be the same both on JS and Flex, we didn't change this too.
     */
    @JsProperty
    private int cornerRadiusTop;

    /**
     * If bulletsEnabled of ChartCurosor is true, a bullet on each graph follows the cursor. You can set opacity of
     * each graphs bullet. In case you want to disable these bullets for a certain graph, set opacity to 0.
     */
    @JsProperty
    private int cursorBulletAlpha;

    /**
     * Path to the image of custom bullet.
     */
    @JsProperty
    private String customBullet;

    /**
     * Name of the custom bullet field in your dataProvider.
     */
    @JsProperty
    private String customBulletField;

    /**
     * Path to the image for legend marker.
     */
    @JsProperty
    private String customMarker;

    /**
     * Dash length. If you set it to a value greater than 0, the graph line (or columns border) will be dashed.
     */
    @JsProperty
    private int dashLength;

    /**
     * Name of the dash length field in your dataProvider. This property adds a possibility to change graphs’ line
     * from solid to dashed on any data point. You can also make columns border dashed using this setting. Note,
     * this won't work with smoothedLineGraph.
     */
    @JsProperty
    private String dashLengthField;

    /**
     * Used to format balloons if value axis is date-based.
     */
    @JsProperty
    private String dateFormat;

    /**
     * Name of the description field in your dataProvider.
     */
    @JsProperty
    private String descriptionField;

    /**
     * Name of error value field in your data provider.
     */
    @JsProperty
    private String errorField;

    /**
     * Opacity of fill. Plural form is used to keep the same property names as our Flex charts'. Flex charts can accept
     * array of numbers to generate gradients. Although you can set array here, only first value of this array will be
     * used.
     */
    @JsProperty
    private int fillAlphas;

    /**
     * Fill color. Will use lineColor if not set. You can also set array of colors here.F
     */
    @JsProperty
    private String fillColors;

    /**
     * Name of the fill colors field in your dataProvider. This property adds a possibility to change line graphs’
     * fill color on any data point to create highlighted sections of the graph. Works only with AmSerialChart.
     */
    @JsProperty
    private String fillColorsField;

    /**
     * XY chart only. If you set this property to id or reference of your X or Y axis, and the fillAlphas is > 0,
     * the area between graph and axis will be filled with color, like in this demo.
     */
    @JsProperty
    private ValueAxis fillToAxis;

    /**
     * You can set another graph here and if fillAlpha is >0, the area from this graph to fillToGraph will be filled
     * (instead of filling the area to the X axis). This feature is not supported by smoothedLine graphs and Radar chart.
     */
    @JsProperty
    private AmGraph fillToAmGraph;

    /**
     * Column width in pixels. If you set this property, columns will be of a fixed width and won't adjust to the
     * available space.
     */
    @JsProperty
    private int fixedColumnWidth;

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */
    @JsProperty
    private int fontSize;

    /**
     * If this is set `true`, the graph will always break the line if the distance in time between two adjacent data
     * points is bigger than `gapPeriod x minPeriod`, even if `connect` is set to `true`.
     */
    @JsProperty
    private boolean forceGap;

    /**
     * Name of the gap field in your dataProvider. You can force graph to show gap at a desired data point using this
     * feature. This feature does not work with XY chart.
     */
    @JsProperty
    private String gapField;

    /**
     * Using this property you can specify when graph should display gap - if the time difference between data points
     * is bigger than duration of minPeriod * gapPeriod, and connect property of a graph is set to false, graph will
     * display gap.
     */
    @JsProperty
    private double gapPeriod;

    /**
     * Orientation of the gradient fills (only for "column" graph type). Possible values are "vertical" and "horizontal".
     */
    @JsProperty
    private String gradientOrientation;

    /**
     * Specifies whether the graph is hidden. Do not use this to show/hide the graph, use hideGraph(graph) and
     * showGraph(graph) methods instead.
     */
    @JsProperty
    private boolean hidden;

    /**
     * If there are more data points than hideBulletsCount, the bullets will not be shown. 0 means the bullets will
     * always be visible.
     */
    @JsProperty
    private int hideBulletsCount;

    /**
     * Name of the high field (used by candlesticks and ohlc) in your dataProvider.
     */
    @JsProperty
    private String highField;

    /**
     * Unique id of a graph. It is not required to set one, unless you want to use this graph for as your scrollbar's
     * graph and need to indicate which graph should be used.
     */
    @JsProperty
    private String id;

    /**
     * Whether to include this graph when calculating min and max value of the axis.
     */
    @JsProperty
    private boolean includeInMinMax;

    /**
     * Data label text anchor.
     */
    @JsProperty
    private String labelAnchor;

    /**
     * Name of label color field in data provider.
     */
    @JsProperty
    private String labelColorField;

    /**
     * You can use it to format labels of data items in any way you want. Graph will call this function and pass
     * reference to GraphDataItem and formatted text as attributes. This function should return string which will
     * be displayed as label.
     */
    @JsProperty
    private Functions.Func labelFunction;

    /**
     * Offset of data label.
     */
    @JsProperty
    private int labelOffset;

    /**
     * Position of value label. Possible values are: "bottom", "top", "right", "left", "inside", "middle".
     * Sometimes position is changed by the chart, depending on a graph type, rotation, etc.
     */
    @JsProperty
    private String labelPosition;

    /**
     * Rotation of a data label.
     */
    @JsProperty
    private int labelRotation;

    /**
     * Value label text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]].
     */
    @JsProperty
    private String labelText;

    /**
     * Legend marker opacity. Will use lineAlpha if not set. Value range is 0 - 1.
     */
    @JsProperty
    private double legendAlpha;

    /**
     * Legend marker color. Will use lineColor if not set.
     */
    @JsProperty
    private String legendColor;

    /**
     * It is called and the following attributes are passed: dataItem, formattedText, periodValues, periodPercentValues.
     * It should return hex color code which will be used for legend marker.
     */
    @JsProperty
    private Object legendColorFunction;

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data point.
     * The tags should be made out of two parts - the name of a field (value / open / close / high / low) and the value of
     * the period you want to be show - open / close / high / low / sum / average / count. For example: [[value.sum]] means
     * that sum of all data points of value field in the selected period will be displayed.
     */
    @JsProperty
    private String legendPeriodValueText;

    /**
     * Legend value text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]]
     * You can also use custom fields from your dataProvider. If not set, uses Legend's valueText.
     */
    @JsProperty
    private String legendValueText;

    /**
     * Opacity of the line (or column border). Value range is 0 - 1.
     */
    @JsProperty
    private double lineAlpha;

    /**
     * Color of the line (or column border). If you do not set any, the color from AmCoordinateChart.colors array will
     * be used for each subsequent graph.
     */
    @JsProperty
    private String lineColor;

    /**
     * Name of the line color field in your dataProvider. This property adds a possibility to change graphs’ line color
     * on any data point to create highlighted sections of the graph. Works only with AmSerialChart.
     */
    @JsProperty
    private String lineColorField;

    /**
     * Specifies thickness of the graph line (or column border).
     */
    @JsProperty
    private int lineThickness;

    /**
     * Name of the low field (used by candlesticks and ohlc) in your dataProvider.
     */
    @JsProperty
    private String lowField;

    /**
     * Legend marker type. You can set legend marker (key) type for individual graphs. Possible values are: square,
     * circle, diamond, triangleUp, triangleDown, triangleLeft, triangleDown, bubble, line, none.
     */
    @JsProperty
    private String markerType;

    /**
     * Specifies size of the bullet which value is the biggest (XY chart).
     */
    @JsProperty
    private int maxBulletSize;

    /**
     * It is useful if you have really lots of data points. Based on this property the graph will omit some of the
     * lines (if the distance between points is less that minDistance, in pixels). This will not affect the bullets or
     * indicator in anyway, so the user will not see any difference (unless you set minValue to a bigger value,
     * let say 5), but will increase performance as less lines will be drawn. By setting value to a bigger number
     * you can also make your lines look less jagged.
     */
    @JsProperty
    private int minDistance;

    /**
     * If you use different colors for your negative values, a graph below zero line is filled with negativeColor.
     * With this property you can define a different base value at which colors should be changed to negative colors.
     */
    @JsProperty
    private int negativeBase;

    /**
     * Fill opacity of negative part of the graph. Will use fillAlphas if not set.
     */
    @JsProperty
    private double negativeFillAlphas;

    /**
     * Fill color of negative part of the graph. Will use fillColors if not set.
     */
    @JsProperty
    private String negativeFillColors;

    /**
     * Opacity of the negative portion of the line (or column border). Value range is 0 - 1.
     */
    @JsProperty
    private double negativeLineAlpha;

    /**
     * Color of the line (or column) when the values are negative. In case the graph type is candlestick or ohlc,
     * negativeLineColor is used when close value is less then open value.
     */
    @JsProperty
    private String negativeLineColor;

    /**
     * If you set it to true, column chart will begin new stack. This allows having Clustered and Stacked column/bar
     * chart.
     */
    @JsProperty
    private boolean newStack;

    /**
     * In case you want to have a step line graph without risers, you should set this to true.
     */
    @JsProperty
    private boolean noStepRisers;

    /**
     * Name of the open field (used by floating columns, candlesticks and ohlc) in your dataProvider.
     */
    @JsProperty
    private String openField;

    /**
     * Value of pattern should be object with url, width, height of an image, optionally it might have x, y, randomX
     * and randomY values. For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}.
     * If you want to have individual patterns for each column, define patterns in data provider and set
     * graph.patternField property. Check amcharts/patterns folder for some patterns. You can create your own
     * patterns and use them. Note, x, y, randomX and randomY properties won't work with IE8 and older. 3D bar/Pie
     * charts won't work properly with patterns.
     */
    @JsProperty
    private Object pattern;

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values.
     * For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns
     * folder for some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY
     * properties won't work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */
    @JsProperty
    private String patternField;

    /**
     * This property can be used by step graphs - you can set how many periods one horizontal line should span.
     */
    @JsProperty
    private int periodSpan;

    /**
     * Specifies where data points should be placed - on the beginning of the period (day, hour, etc) or in the middle
     * (only when parseDates property of categoryAxis is set to true). This setting affects Serial chart only.
     * Possible values are "start", "middle" and "end"
     */
    @JsProperty
    private String pointPosition;

    /**
     * Precision of values. Will use chart's precision if not set any.
     */
    @JsProperty
    private int precision;

    /**
     * If this is set to true, candlesticks will be colored in a different manner - if current close is less than
     * current open, the candlestick will be empty, otherwise - filled with color. If previous close is less than
     * current close, the candlestick will use positive color, otherwise - negative color.
     */
    @JsProperty
    private boolean proCandlesticks;

    /**
     * Gantt chart only. Contains unmodified segment object from data provider.
     */
    @JsProperty
    private Object segmentData;

    /**
     * If graph's type is column and labelText is set, graph hides labels which do not fit into the column's space or
     * go outside plot area. If you don't want these labels to be hidden, set this to true.
     */
    @JsProperty
    private boolean showAllValueLabels;

    /**
     * Specifies whether the value balloon of this graph is shown when mouse is over data item or chart's indicator
     * is over some series.
     */
    @JsProperty
    private boolean showBalloon;

    /**
     * Specifies graphs value at which cursor is showed. This is only important for candlestick and ohlc charts, also
     * if column chart has "open" value. Possible values are: "open", "close", "high", "low". "top" and "bottom" values
     * will glue the balloon to top/bottom of the plot area.
     */
    @JsProperty
    private String showBalloonAt;

    /**
     * Works with candlestick graph type, you can set it to open, close, high, low. If you set it to high, the events
     * will be shown at the tip of the high line.
     */
    @JsProperty
    private String showBulletsAt;

    /**
     * If you want mouse pointer to change to hand when hovering the graph, set this property to true.
     */
    @JsProperty
    private boolean showHandOnHover;

    /**
     * It can only be used together with topRadius (when columns look like cylinders). If you set it to true, the
     * cylinder will be lowered down so that the center of it's bottom circle would be right on category axis.
     */
    @JsProperty
    private boolean showOnAxis;

    /**
     * If the value axis of this graph has stack types like "regular" or "100%" You can exclude this graph from stacking.
     */
    @JsProperty
    private boolean stackable;

    /**
     * Step graph only. Specifies to which direction step should be drawn.
     */
    @JsProperty
    private String stepDirection;

    /**
     * If you set it to false, the graph will not be hidden when user clicks on legend entry.
     */
    @JsProperty
    private boolean switchable;

    /**
     * In case you set it to some number, the chart will set focus on bullet/column (starting from first) when user
     * clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set using
     * accessibleLabel property of AmGraph. Note, not all browsers and readers support this.
     */
    @JsProperty
    private int tabIndex;

    /**
     * Graph title.
     */
    @JsProperty
    private String title;

    /**
     * If you set this to 1, columns will become cylinders (must set depth3D and angle properties of a chart to >0
     * values in order this to be visible). you can make columns look like cones (set topRadius to 0) or even like
     * some glasses (set to bigger than 1). We strongly recommend setting grid opacity to 0 in order this to look good.
     */
    @JsProperty
    private int topRadius;

    /**
     * Type of the graph. Possible values are: "line", "column", "step", "smoothedLine", "candlestick", "ohlc". XY and
     * Radar charts can only display "line" type graphs.
     */
    @JsProperty
    private String type;

    /**
     * Name of the url field in your dataProvider.
     */
    @JsProperty
    private String urlField;

    /**
     * Target to open URLs in, i.e. _blank, _top, etc.
     */
    @JsProperty
    private String urlTarget;

    /**
     * If set to true, the bullet border will take the same color as graph line.
     */
    @JsProperty
    private boolean useLineColorForBulletBorder;

    /**
     * If negativeLineColor and/or negativeFillColors are set and useNegativeColorIfDown is set to true
     * (default is false), the line, step and column graphs will use these colors for lines, bullets or
     * columns if previous value is bigger than current value. In case you set openField for the graph,
     * the graph will compare current value with openField value instead of comparing to previous value.
     */
    @JsProperty
    private boolean useNegativeColorIfDown;

    /**
     * Specifies which value axis the graph will use. Will use the first value axis if not set. You can use reference
     * to the real ValueAxis object or set value axis id.
     */
    @JsProperty
    private ValueAxis valueAxis;

    /**
     * Name of the value field in your dataProvider.
     */
    @JsProperty
    private String valueField;

    /**
     * Specifies whether this graph should be shown in the Legend.
     */
    @JsProperty
    private boolean visibleInLegend;

    /**
     * XY chart only. A horizontal value axis object to attach graph to.
     */
    @JsProperty
    private ValueAxis xAxis;

    /**
     * XY chart only. Name of the x field in your dataProvider.
     */
    @JsProperty
    private String xField;

    /**
     * XY chart only. A vertical value axis object to attach graph to.
     */
    @JsProperty
    private ValueAxis yAxis;

    /**
     * XY chart only. Name of the y field in your dataProvider.
     */
    @JsProperty
    private String yField;

    /**
     * Hides graph's bullets.
     */
    @JsMethod
    public native void hideBullets();

    /**
     * Shows graph's bullets
     */
    @JsMethod
    public native void showBullets();

    @JsOverlay
    public final void setAccessibleLabel(String accessibleLabel) {
        this.accessibleLabel = accessibleLabel;
    }

    @JsOverlay
    public final void setAlphaField(String alphaField) {
        this.alphaField = alphaField;
    }

    @JsOverlay
    public final void setAnimationPlayed(boolean animationPlayed) {
        this.animationPlayed = animationPlayed;
    }

    @JsOverlay
    public final void setBalloon(AmBalloon balloon) {
        this.balloon = balloon;
    }

    @JsOverlay
    public final void setBallonColor(String ballonColor) {
        this.ballonColor = ballonColor;
    }

    @JsOverlay
    public final void setBalloonFunction(Functions.Func balloonFunction) {
        this.balloonFunction = balloonFunction;
    }

    @JsOverlay
    public final void setBalloonText(String balloonText) {
        this.balloonText = balloonText;
    }

    @JsOverlay
    public final void setBehindColumns(boolean behindColumns) {
        this.behindColumns = behindColumns;
    }

    @JsOverlay
    public final void setBullet(String bullet) {
        this.bullet = bullet;
    }

    @JsOverlay
    public final void setBulletAlpha(int bulletAlpha) {
        this.bulletAlpha = bulletAlpha;
    }

    @JsOverlay
    public final void setBulletAxis(Object bulletAxis) {
        this.bulletAxis = bulletAxis;
    }

    @JsOverlay
    public final void setBulletBorderAlpha(int bulletBorderAlpha) {
        this.bulletBorderAlpha = bulletBorderAlpha;
    }

    @JsOverlay
    public final void setBulletBorderColor(String bulletBorderColor) {
        this.bulletBorderColor = bulletBorderColor;
    }

    @JsOverlay
    public final void setBulletBorderThickness(String bulletBorderThickness) {
        this.bulletBorderThickness = bulletBorderThickness;
    }

    @JsOverlay
    public final void setBulletColor(String bulletColor) {
        this.bulletColor = bulletColor;
    }

    @JsOverlay
    public final void setBulletField(String bulletField) {
        this.bulletField = bulletField;
    }

    @JsOverlay
    public final void setBulletHitAreaSize(int bulletHitAreaSize) {
        this.bulletHitAreaSize = bulletHitAreaSize;
    }

    @JsOverlay
    public final void setBulletOffset(int bulletOffset) {
        this.bulletOffset = bulletOffset;
    }

    @JsOverlay
    public final void setBulletSize(int bulletSize) {
        this.bulletSize = bulletSize;
    }

    @JsOverlay
    public final void setBulletSizeField(String bulletSizeField) {
        this.bulletSizeField = bulletSizeField;
    }

    @JsOverlay
    public final void setClassNameField(String classNameField) {
        this.classNameField = classNameField;
    }

    @JsOverlay
    public final void setCloseField(String closeField) {
        this.closeField = closeField;
    }

    @JsOverlay
    public final void setClustered(String clustered) {
        this.clustered = clustered;
    }

    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final void setColorField(String colorField) {
        this.colorField = colorField;
    }

    @JsOverlay
    public final void setColumnIndexField(String columnIndexField) {
        this.columnIndexField = columnIndexField;
    }

    @JsOverlay
    public final void setColumnWidth(String columnWidth) {
        this.columnWidth = columnWidth;
    }

    @JsOverlay
    public final void setConnect(boolean connect) {
        this.connect = connect;
    }

    @JsOverlay
    public final void setCornerRadiusTop(int cornerRadiusTop) {
        this.cornerRadiusTop = cornerRadiusTop;
    }

    @JsOverlay
    public final void setCursorBulletAlpha(int cursorBulletAlpha) {
        this.cursorBulletAlpha = cursorBulletAlpha;
    }

    @JsOverlay
    public final void setCustomBullet(String customBullet) {
        this.customBullet = customBullet;
    }

    @JsOverlay
    public final void setCustomBulletField(String customBulletField) {
        this.customBulletField = customBulletField;
    }

    @JsOverlay
    public final void setCustomMarker(String customMarker) {
        this.customMarker = customMarker;
    }

    @JsOverlay
    public final void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    @JsOverlay
    public final void setDashLengthField(String dashLengthField) {
        this.dashLengthField = dashLengthField;
    }

    @JsOverlay
    public final void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @JsOverlay
    public final void setDescriptionField(String descriptionField) {
        this.descriptionField = descriptionField;
    }

    @JsOverlay
    public final void setErrorField(String errorField) {
        this.errorField = errorField;
    }

    @JsOverlay
    public final void setFillAlphas(int fillAlphas) {
        this.fillAlphas = fillAlphas;
    }

    @JsOverlay
    public final void setFillColors(String fillColors) {
        this.fillColors = fillColors;
    }

    @JsOverlay
    public final void setFillColorsField(String fillColorsField) {
        this.fillColorsField = fillColorsField;
    }

    @JsOverlay
    public final void setFillToAxis(ValueAxis fillToAxis) {
        this.fillToAxis = fillToAxis;
    }

    @JsOverlay
    public final void setFillToAmGraph(AmGraph fillToAmGraph) {
        this.fillToAmGraph = fillToAmGraph;
    }

    @JsOverlay
    public final void setFixedColumnWidth(int fixedColumnWidth) {
        this.fixedColumnWidth = fixedColumnWidth;
    }

    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final void setForceGap(boolean forceGap) {
        this.forceGap = forceGap;
    }

    @JsOverlay
    public final void setGapField(String gapField) {
        this.gapField = gapField;
    }

    @JsOverlay
    public final void setGapPeriod(double gapPeriod) {
        this.gapPeriod = gapPeriod;
    }

    @JsOverlay
    public final void setGradientOrientation(String gradientOrientation) {
        this.gradientOrientation = gradientOrientation;
    }

    @JsOverlay
    public final void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @JsOverlay
    public final void setHideBulletsCount(int hideBulletsCount) {
        this.hideBulletsCount = hideBulletsCount;
    }

    @JsOverlay
    public final void setHighField(String highField) {
        this.highField = highField;
    }

    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    @JsOverlay
    public final void setIncludeInMinMax(boolean includeInMinMax) {
        this.includeInMinMax = includeInMinMax;
    }

    @JsOverlay
    public final void setLabelAnchor(String labelAnchor) {
        this.labelAnchor = labelAnchor;
    }

    @JsOverlay
    public final void setLabelColorField(String labelColorField) {
        this.labelColorField = labelColorField;
    }

    @JsOverlay
    public final void setLabelFunction(Functions.Func labelFunction) {
        this.labelFunction = labelFunction;
    }

    @JsOverlay
    public final void setLabelOffset(int labelOffset) {
        this.labelOffset = labelOffset;
    }

    @JsOverlay
    public final void setLabelPosition(String labelPosition) {
        this.labelPosition = labelPosition;
    }

    @JsOverlay
    public final void setLabelRotation(int labelRotation) {
        this.labelRotation = labelRotation;
    }

    @JsOverlay
    public final void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    @JsOverlay
    public final void setLegendAlpha(double legendAlpha) {
        this.legendAlpha = legendAlpha;
    }

    @JsOverlay
    public final void setLegendColor(String legendColor) {
        this.legendColor = legendColor;
    }

    @JsOverlay
    public final void setLegendColorFunction(Object legendColorFunction) {
        this.legendColorFunction = legendColorFunction;
    }

    @JsOverlay
    public final void setLegendPeriodValueText(String legendPeriodValueText) {
        this.legendPeriodValueText = legendPeriodValueText;
    }

    @JsOverlay
    public final void setLegendValueText(String legendValueText) {
        this.legendValueText = legendValueText;
    }

    @JsOverlay
    public final void setLineAlpha(double lineAlpha) {
        this.lineAlpha = lineAlpha;
    }

    @JsOverlay
    public final void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    @JsOverlay
    public final void setLineColorField(String lineColorField) {
        this.lineColorField = lineColorField;
    }

    @JsOverlay
    public final void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    @JsOverlay
    public final void setLowField(String lowField) {
        this.lowField = lowField;
    }

    @JsOverlay
    public final void setMarkerType(String markerType) {
        this.markerType = markerType;
    }

    @JsOverlay
    public final void setMaxBulletSize(int maxBulletSize) {
        this.maxBulletSize = maxBulletSize;
    }

    @JsOverlay
    public final void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    @JsOverlay
    public final void setNegativeBase(int negativeBase) {
        this.negativeBase = negativeBase;
    }

    @JsOverlay
    public final void setNegativeFillAlphas(double negativeFillAlphas) {
        this.negativeFillAlphas = negativeFillAlphas;
    }

    @JsOverlay
    public final void setNegativeFillColors(String negativeFillColors) {
        this.negativeFillColors = negativeFillColors;
    }

    @JsOverlay
    public final void setNegativeLineAlpha(double negativeLineAlpha) {
        this.negativeLineAlpha = negativeLineAlpha;
    }

    @JsOverlay
    public final void setNegativeLineColor(String negativeLineColor) {
        this.negativeLineColor = negativeLineColor;
    }

    @JsOverlay
    public final void setNewStack(boolean newStack) {
        this.newStack = newStack;
    }

    @JsOverlay
    public final void setNoStepRisers(boolean noStepRisers) {
        this.noStepRisers = noStepRisers;
    }

    @JsOverlay
    public final void setOpenField(String openField) {
        this.openField = openField;
    }

    @JsOverlay
    public final void setPattern(Object pattern) {
        this.pattern = pattern;
    }

    @JsOverlay
    public final void setPatternField(String patternField) {
        this.patternField = patternField;
    }

    @JsOverlay
    public final void setPeriodSpan(int periodSpan) {
        this.periodSpan = periodSpan;
    }

    @JsOverlay
    public final void setPointPosition(String pointPosition) {
        this.pointPosition = pointPosition;
    }

    @JsOverlay
    public final void setPrecision(int precision) {
        this.precision = precision;
    }

    @JsOverlay
    public final void setProCandlesticks(boolean proCandlesticks) {
        this.proCandlesticks = proCandlesticks;
    }

    @JsOverlay
    public final void setSegmentData(Object segmentData) {
        this.segmentData = segmentData;
    }

    @JsOverlay
    public final void setShowAllValueLabels(boolean showAllValueLabels) {
        this.showAllValueLabels = showAllValueLabels;
    }

    @JsOverlay
    public final void setShowBalloon(boolean showBalloon) {
        this.showBalloon = showBalloon;
    }

    @JsOverlay
    public final void setShowBalloonAt(String showBalloonAt) {
        this.showBalloonAt = showBalloonAt;
    }

    @JsOverlay
    public final void setShowBulletsAt(String showBulletsAt) {
        this.showBulletsAt = showBulletsAt;
    }

    @JsOverlay
    public final void setShowHandOnHover(boolean showHandOnHover) {
        this.showHandOnHover = showHandOnHover;
    }

    @JsOverlay
    public final void setShowOnAxis(boolean showOnAxis) {
        this.showOnAxis = showOnAxis;
    }

    @JsOverlay
    public final void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    @JsOverlay
    public final void setStepDirection(String stepDirection) {
        this.stepDirection = stepDirection;
    }

    @JsOverlay
    public final void setSwitchable(boolean switchable) {
        this.switchable = switchable;
    }

    @JsOverlay
    public final void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    @JsOverlay
    public final void setTitle(String title) {
        this.title = title;
    }

    @JsOverlay
    public final void setTopRadius(int topRadius) {
        this.topRadius = topRadius;
    }

    @JsOverlay
    public final void setType(String type) {
        this.type = type;
    }

    @JsOverlay
    public final void setUrlField(String urlField) {
        this.urlField = urlField;
    }

    @JsOverlay
    public final void setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
    }

    @JsOverlay
    public final void setUseLineColorForBulletBorder(boolean useLineColorForBulletBorder) {
        this.useLineColorForBulletBorder = useLineColorForBulletBorder;
    }

    @JsOverlay
    public final void setUseNegativeColorIfDown(boolean useNegativeColorIfDown) {
        this.useNegativeColorIfDown = useNegativeColorIfDown;
    }

    @JsOverlay
    public final void setValueAxis(ValueAxis valueAxis) {
        this.valueAxis = valueAxis;
    }

    @JsOverlay
    public final void setValueField(String valueField) {
        this.valueField = valueField;
    }

    @JsOverlay
    public final void setVisibleInLegend(boolean visibleInLegend) {
        this.visibleInLegend = visibleInLegend;
    }

    @JsOverlay
    public final void setxAxis(ValueAxis xAxis) {
        this.xAxis = xAxis;
    }

    @JsOverlay
    public final void setxField(String xField) {
        this.xField = xField;
    }

    @JsOverlay
    public final void setyAxis(ValueAxis yAxis) {
        this.yAxis = yAxis;
    }

    @JsOverlay
    public final void setyField(String yField) {
        this.yField = yField;
    }
}
