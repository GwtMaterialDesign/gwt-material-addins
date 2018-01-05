package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;
import gwt.material.design.jquery.client.api.Functions;

/**
 * Creates the visualization of the data in following types: line, column, step line, smoothed line, olhc and candlestick.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmGraph">Official Documentation</a>
 */
//@formatter:on
public class Graph extends ChartOptions {

    private AmGraph graph;

    public String getAccessibleLabel() {
        return getAmGraph().accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over the bullet/column or sets focus using tab key (this is
     * possible only if tabIndex property of AmGraph is set to some number). Text is added as aria-label tag. Note -
     * not all screen readers and browsers support getAmGraph().
     */

    public void setAccessibleLabel(String accessibleLabel) {
        getAmGraph().accessibleLabel = accessibleLabel;
    }


    public String getAlphaField() {
        return getAmGraph().alphaField;
    }

    /**
     * Name of the alpha field in your dataProvider.
     */

    public void setAlphaField(String alphaField) {
        getAmGraph().alphaField = alphaField;
    }


    public boolean isAnimationPlayed() {
        return getAmGraph().animationPlayed;
    }

    /**
     * If you set this to true before chart is drawn, the animation of this graph won't be played.
     */

    public void setAnimationPlayed(boolean animationPlayed) {
        getAmGraph().animationPlayed = animationPlayed;
    }


    public AmBalloon getBalloon() {
        return getAmGraph().balloon;
    }

    /**
     * Allows customizing graphs balloons individually (only when ChartCursor is used). Note: the balloon object is not
     * created automatically, you should create it before setting properties
     */

    public void setBalloon(Balloon balloon) {
        getAmGraph().balloon = balloon.getAmBalloon();
    }


    public String getBallonColor() {
        return getAmGraph().ballonColor;
    }

    /**
     * Value balloon color. Will use graph or data item color if not set.
     */

    public void setBallonColor(String ballonColor) {
        getAmGraph().ballonColor = ballonColor;
    }


    public Functions.Func getBalloonFunction() {
        return getAmGraph().balloonFunction;
    }

    /**
     * If you set some function, the graph will call it and pass GraphDataItem and AmGraph objects to it. This function
     * should return getAmGraph(). a string which will be displayed in a balloon.
     */

    public void setBalloonFunction(Functions.Func balloonFunction) {
        getAmGraph().balloonFunction = balloonFunction;
    }


    public String getBalloonText() {
        return getAmGraph().balloonText;
    }

    /**
     * Balloon text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]] or any other
     * field name from your data provider. HTML tags can also be used.
     */

    public void setBalloonText(String balloonText) {
        getAmGraph().balloonText = balloonText;
    }


    public boolean isBehindColumns() {
        return getAmGraph().behindColumns;
    }

    /**
     * Specifies if the line graph should be placed behind column graphs
     */

    public void setBehindColumns(boolean behindColumns) {
        getAmGraph().behindColumns = behindColumns;
    }


    public String getBullet() {
        return getAmGraph().bullet;
    }

    /**
     * Type of the bullets. Possible values are: "none", "round", "square", "triangleUp", "triangleDown",
     * "triangleLeft", "triangleRight", "bubble", "diamond", "xError", "yError" and "custom".
     */

    public void setBullet(String bullet) {
        getAmGraph().bullet = bullet;
    }


    public int getBulletAlpha() {
        return getAmGraph().bulletAlpha;
    }

    /**
     * Opacity of bullets. Value range is 0 - 1.
     */

    public void setBulletAlpha(int bulletAlpha) {
        getAmGraph().bulletAlpha = bulletAlpha;
    }


    public AmValueAxis getBulletAxis() {
        return getAmGraph().bulletAxis;
    }

    /**
     * BulletAxis value is used when you are building error chart. Error chart is a regular serial or XY chart with
     * bullet type set to "xError" or "yError". The graph should know which axis should be used to determine the size
     * of this bullet - that's when bulletAxis should be set. Besides that, you should also set getAmGraph().errorField.
     * You can also use other bullet types with this feature too. For example, if you set bulletAxis for XY chart,
     * the size of a bullet will change as you zoom the chart.
     */

    public void setBulletAxis(AmValueAxis bulletAxis) {
        getAmGraph().bulletAxis = bulletAxis;
    }


    public int getBulletBorderAlpha() {
        return getAmGraph().bulletBorderAlpha;
    }

    /**
     * Bullet border opacity.
     */

    public void setBulletBorderAlpha(int bulletBorderAlpha) {
        getAmGraph().bulletBorderAlpha = bulletBorderAlpha;
    }


    public String getBulletBorderColor() {
        return getAmGraph().bulletBorderColor;
    }

    /**
     * Bullet border color. Will use lineColor if not set.
     */

    public void setBulletBorderColor(String bulletBorderColor) {
        getAmGraph().bulletBorderColor = bulletBorderColor;
    }


    public String getBulletBorderThickness() {
        return getAmGraph().bulletBorderThickness;
    }

    /**
     * Bullet border thickness.
     */

    public void setBulletBorderThickness(String bulletBorderThickness) {
        getAmGraph().bulletBorderThickness = bulletBorderThickness;
    }


    public String getBulletColor() {
        return getAmGraph().bulletColor;
    }

    /**
     * Bullet color. Will use lineColor if not set.
     */

    public void setBulletColor(String bulletColor) {
        getAmGraph().bulletColor = bulletColor;
    }


    public String getBulletField() {
        return getAmGraph().bulletField;
    }

    /**
     * Name of the bullet field in your dataProvider.
     */

    public void setBulletField(String bulletField) {
        getAmGraph().bulletField = bulletField;
    }


    public int getBulletHitAreaSize() {
        return getAmGraph().bulletHitAreaSize;
    }

    /**
     * Useful for touch devices - if you set it to 20 or so, the bullets of a graph will have invisible circle around
     * the actual bullet (bullets should still be enabled), which will be easier to touch (bullets usually are smaller
     * and hard to hit).
     */

    public void setBulletHitAreaSize(int bulletHitAreaSize) {
        getAmGraph().bulletHitAreaSize = bulletHitAreaSize;
    }


    public int getBulletOffset() {
        return getAmGraph().bulletOffset;
    }

    /**
     * Bullet offset. Distance from the actual data point to the bullet. Can be used to place custom bullets above
     * the columns.
     */

    public void setBulletOffset(int bulletOffset) {
        getAmGraph().bulletOffset = bulletOffset;
    }


    public int getBulletSize() {
        return getAmGraph().bulletSize;
    }

    /**
     * Bullet size.
     */

    public void setBulletSize(int bulletSize) {
        getAmGraph().bulletSize = bulletSize;
    }


    public String getBulletSizeField() {
        return getAmGraph().bulletSizeField;
    }

    /**
     * Name of the bullet size field in your dataProvider.
     */

    public void setBulletSizeField(String bulletSizeField) {
        getAmGraph().bulletSizeField = bulletSizeField;
    }


    public String getClassNameField() {
        return getAmGraph().classNameField;
    }

    /**
     * If this field is set and addClassNames is enabled, the chart will look for a class name string in data using
     * this setting and apply additional class names to elements of the particular data points, such as bullets.
     */

    public void setClassNameField(String classNameField) {
        getAmGraph().classNameField = classNameField;
    }


    public String getCloseField() {
        return getAmGraph().closeField;
    }

    /**
     * Name of the close field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setCloseField(String closeField) {
        getAmGraph().closeField = closeField;
    }


    public String getClustered() {
        return getAmGraph().clustered;
    }

    /**
     * In case you want to place this graph's columns in front of other columns, set this to false. In case "true",
     * the columns will be clustered next to each other.
     * NOTE: clustering works only for graphs of type "column".
     */

    public void setClustered(String clustered) {
        getAmGraph().clustered = clustered;
    }


    public String getColor() {
        return getAmGraph().color;
    }

    /**
     * Color of value labels. Will use chart's color if not set.
     */

    public void setColor(String color) {
        getAmGraph().color = color;
    }


    public String getColorField() {
        return getAmGraph().colorField;
    }

    /**
     * Name of the color field in your dataProvider.
     */

    public void setColorField(String colorField) {
        getAmGraph().colorField = colorField;
    }


    public String getColumnIndexField() {
        return getAmGraph().columnIndexField;
    }

    /**
     * You can use this property with non-stacked column graphs and specify order of columns of each category
     * (starting from 0). Important: this feature does not work in stacked columns scenarios as well as with graph
     * toggling enabled in legend.
     */

    public void setColumnIndexField(String columnIndexField) {
        getAmGraph().columnIndexField = columnIndexField;
    }


    public String getColumnWidth() {
        return getAmGraph().columnWidth;
    }

    /**
     * You can specify custom column width for each graph individually. Value range is 0 - 1 (we set relative width,
     * not pixel width here).
     */

    public void setColumnWidth(String columnWidth) {
        getAmGraph().columnWidth = columnWidth;
    }


    public boolean isConnect() {
        return getAmGraph().connect;
    }

    /**
     * Specifies whether to connect data points if data is missing. The default value is true. This feature does
     * not work with XY chart.
     */

    public void setConnect(boolean connect) {
        getAmGraph().connect = connect;
    }


    public int getCornerRadiusTop() {
        return getAmGraph().cornerRadiusTop;
    }

    /**
     * Corner radius of column. It can be set both in pixels or in percents. The chart's depth and angle styles must
     * be set to 0. The default value is 0. Note, cornerRadiusTop will be applied for all corners of the column,
     * JavaScript charts do not have a possibility to set separate corner radius for top and bottom. As we want all
     * the property names to be the same both on JS and Flex, we didn't change this too.
     */

    public void setCornerRadiusTop(int cornerRadiusTop) {
        getAmGraph().cornerRadiusTop = cornerRadiusTop;
    }


    public int getCursorBulletAlpha() {
        return getAmGraph().cursorBulletAlpha;
    }

    /**
     * If bulletsEnabled of ChartCurosor is true, a bullet on each graph follows the cursor. You can set opacity of
     * each graphs bullet. In case you want to disable these bullets for a certain graph, set opacity to 0.
     */

    public void setCursorBulletAlpha(int cursorBulletAlpha) {
        getAmGraph().cursorBulletAlpha = cursorBulletAlpha;
    }


    public String getCustomBullet() {
        return getAmGraph().customBullet;
    }

    /**
     * Path to the image of custom bullet.
     */

    public void setCustomBullet(String customBullet) {
        getAmGraph().customBullet = customBullet;
    }


    public String getCustomBulletField() {
        return getAmGraph().customBulletField;
    }

    /**
     * Name of the custom bullet field in your dataProvider.
     */

    public void setCustomBulletField(String customBulletField) {
        getAmGraph().customBulletField = customBulletField;
    }


    public String getCustomMarker() {
        return getAmGraph().customMarker;
    }

    /**
     * Path to the image for legend marker.
     */

    public void setCustomMarker(String customMarker) {
        getAmGraph().customMarker = customMarker;
    }


    public int getDashLength() {
        return getAmGraph().dashLength;
    }

    /**
     * Dash length. If you set it to a value greater than 0, the graph line (or columns border) will be dashed.
     */

    public void setDashLength(int dashLength) {
        getAmGraph().dashLength = dashLength;
    }


    public String getDashLengthField() {
        return getAmGraph().dashLengthField;
    }

    /**
     * Name of the dash length field in your dataProvider. This property adds a possibility to change graphs’ line
     * from solid to dashed on any data point. You can also make columns border dashed using this setting. Note,
     * this won't work with smoothedLinegetAmGraph().
     */

    public void setDashLengthField(String dashLengthField) {
        getAmGraph().dashLengthField = dashLengthField;
    }


    public String getDateFormat() {
        return getAmGraph().dateFormat;
    }

    /**
     * Used to format balloons if value axis is date-based.
     */

    public void setDateFormat(String dateFormat) {
        getAmGraph().dateFormat = dateFormat;
    }


    public String getDescriptionField() {
        return getAmGraph().descriptionField;
    }

    /**
     * Name of the description field in your dataProvider.
     */

    public void setDescriptionField(String descriptionField) {
        getAmGraph().descriptionField = descriptionField;
    }


    public String getErrorField() {
        return getAmGraph().errorField;
    }

    /**
     * Name of error value field in your data provider.
     */

    public void setErrorField(String errorField) {
        getAmGraph().errorField = errorField;
    }


    public int getFillAlphas() {
        return getAmGraph().fillAlphas;
    }

    /**
     * Opacity of fill. Plural form is used to keep the same property names as our Flex charts'. Flex charts can accept
     * array of numbers to generate gradients. Although you can set array here, only first value of this array will be
     * used.
     */

    public void setFillAlphas(int fillAlphas) {
        getAmGraph().fillAlphas = fillAlphas;
    }


    public String getFillColors() {
        return getAmGraph().fillColors;
    }

    /**
     * Fill color. Will use lineColor if not set. You can also set array of colors here.F
     */

    public void setFillColors(String fillColors) {
        getAmGraph().fillColors = fillColors;
    }


    public String getFillColorsField() {
        return getAmGraph().fillColorsField;
    }

    /**
     * Name of the fill colors field in your dataProvider. This property adds a possibility to change line graphs’
     * fill color on any data point to create highlighted sections of the getAmGraph(). Works only with AmSerialChart.
     */

    public void setFillColorsField(String fillColorsField) {
        getAmGraph().fillColorsField = fillColorsField;
    }


    public AmValueAxis getFillToAxis() {
        return getAmGraph().fillToAxis;
    }

    /**
     * XY chart only. If you set this property to id or reference of your X or Y axis, and the fillAlphas is > 0,
     * the area between graph and axis will be filled with color, like in this demo.
     */

    public void setFillToAxis(AmValueAxis fillToAxis) {
        getAmGraph().fillToAxis = fillToAxis;
    }


    public AmGraph getFillToAmGraph() {
        return getAmGraph().fillToAmGraph;
    }

    /**
     * You can set another graph here and if fillAlpha is >0, the area from this graph to fillToGraph will be filled
     * (instead of filling the area to the X axis). This feature is not supported by smoothedLine graphs and Radar chart.
     */

    public void setFillToAmGraph(AmGraph fillToAmGraph) {
        getAmGraph().fillToAmGraph = fillToAmGraph;
    }


    public int getFixedColumnWidth() {
        return getAmGraph().fixedColumnWidth;
    }

    /**
     * Column width in pixels. If you set this property, columns will be of a fixed width and won't adjust to the
     * available space.
     */

    public void setFixedColumnWidth(int fixedColumnWidth) {
        getAmGraph().fixedColumnWidth = fixedColumnWidth;
    }


    public int getFontSize() {
        return getAmGraph().fontSize;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */

    public void setFontSize(int fontSize) {
        getAmGraph().fontSize = fontSize;
    }


    public boolean isForceGap() {
        return getAmGraph().forceGap;
    }

    /**
     * If this is set `true`, the graph will always break the line if the distance in time between two adjacent data
     * points is bigger than `gapPeriod x minPeriod`, even if `connect` is set to `true`.
     */

    public void setForceGap(boolean forceGap) {
        getAmGraph().forceGap = forceGap;
    }


    public String getGapField() {
        return getAmGraph().gapField;
    }

    /**
     * Name of the gap field in your dataProvider. You can force graph to show gap at a desired data point using this
     * feature. This feature does not work with XY chart.
     */

    public void setGapField(String gapField) {
        getAmGraph().gapField = gapField;
    }


    public double getGapPeriod() {
        return getAmGraph().gapPeriod;
    }

    /**
     * Using this property you can specify when graph should display gap - if the time difference between data points
     * is bigger than duration of minPeriod * gapPeriod, and connect property of a graph is set to false, graph will
     * display gap.
     */

    public void setGapPeriod(double gapPeriod) {
        getAmGraph().gapPeriod = gapPeriod;
    }


    public String getGradientOrientation() {
        return getAmGraph().gradientOrientation;
    }

    /**
     * Orientation of the gradient fills (only for "column" graph type). Possible values are "vertical" and "horizontal".
     */

    public void setGradientOrientation(String gradientOrientation) {
        getAmGraph().gradientOrientation = gradientOrientation;
    }


    public boolean isHidden() {
        return getAmGraph().hidden;
    }

    /**
     * Specifies whether the graph is hidden. Do not use this to show/hide the graph, use hideGraph(graph) and
     * showGraph(graph) methods instead.
     */

    public void setHidden(boolean hidden) {
        getAmGraph().hidden = hidden;
    }


    public int getHideBulletsCount() {
        return getAmGraph().hideBulletsCount;
    }

    /**
     * If there are more data points than hideBulletsCount, the bullets will not be shown. 0 means the bullets will
     * always be visible.
     */

    public void setHideBulletsCount(int hideBulletsCount) {
        getAmGraph().hideBulletsCount = hideBulletsCount;
    }


    public String getHighField() {
        return getAmGraph().highField;
    }

    /**
     * Name of the high field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setHighField(String highField) {
        getAmGraph().highField = highField;
    }


    public String getId() {
        return getAmGraph().id;
    }

    /**
     * Unique id of a getAmGraph(). It is not required to set one, unless you want to use this graph for as your scrollbar's
     * graph and need to indicate which graph should be used.
     */

    public void setId(String id) {
        getAmGraph().id = id;
    }


    public boolean isIncludeInMinMax() {
        return getAmGraph().includeInMinMax;
    }

    /**
     * Whether to include this graph when calculating min and max value of the axis.
     */

    public void setIncludeInMinMax(boolean includeInMinMax) {
        getAmGraph().includeInMinMax = includeInMinMax;
    }


    public String getLabelAnchor() {
        return getAmGraph().labelAnchor;
    }

    /**
     * Data label text anchor.
     */

    public void setLabelAnchor(String labelAnchor) {
        getAmGraph().labelAnchor = labelAnchor;
    }


    public String getLabelColorField() {
        return getAmGraph().labelColorField;
    }

    /**
     * Name of label color field in data provider.
     */

    public void setLabelColorField(String labelColorField) {
        getAmGraph().labelColorField = labelColorField;
    }


    public Functions.Func getLabelFunction() {
        return getAmGraph().labelFunction;
    }

    /**
     * You can use it to format labels of data items in any way you want. Graph will call this function and pass
     * reference to GraphDataItem and formatted text as attributes. This function should return getAmGraph(). string which will
     * be displayed as label.
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        getAmGraph().labelFunction = labelFunction;
    }


    public int getLabelOffset() {
        return getAmGraph().labelOffset;
    }

    /**
     * Offset of data label.
     */

    public void setLabelOffset(int labelOffset) {
        getAmGraph().labelOffset = labelOffset;
    }


    public String getLabelPosition() {
        return getAmGraph().labelPosition;
    }

    /**
     * Position of value label. Possible values are: "bottom", "top", "right", "left", "inside", "middle".
     * Sometimes position is changed by the chart, depending on a graph type, rotation, etc.
     */

    public void setLabelPosition(String labelPosition) {
        getAmGraph().labelPosition = labelPosition;
    }


    public int getLabelRotation() {
        return getAmGraph().labelRotation;
    }

    /**
     * Rotation of a data label.
     */

    public void setLabelRotation(int labelRotation) {
        getAmGraph().labelRotation = labelRotation;
    }


    public String getLabelText() {
        return getAmGraph().labelText;
    }

    /**
     * Value label text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]].
     */

    public void setLabelText(String labelText) {
        getAmGraph().labelText = labelText;
    }


    public double getLegendAlpha() {
        return getAmGraph().legendAlpha;
    }

    /**
     * ChartLegend marker opacity. Will use lineAlpha if not set. Value range is 0 - 1.
     */

    public void setLegendAlpha(double legendAlpha) {
        getAmGraph().legendAlpha = legendAlpha;
    }


    public String getLegendColor() {
        return getAmGraph().legendColor;
    }

    /**
     * ChartLegend marker color. Will use lineColor if not set.
     */

    public void setLegendColor(String legendColor) {
        getAmGraph().legendColor = legendColor;
    }


    public Object getLegendColorFunction() {
        return getAmGraph().legendColorFunction;
    }

    /**
     * It is called and the following attributes are passed: dataItem, formattedText, periodValues, periodPercentValues.
     * It should return getAmGraph(). hex color code which will be used for legend marker.
     */

    public void setLegendColorFunction(Object legendColorFunction) {
        getAmGraph().legendColorFunction = legendColorFunction;
    }


    public String getLegendPeriodValueText() {
        return getAmGraph().legendPeriodValueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data point.
     * The tags should be made out of two parts - the name of a field (value / open / close / high / low) and the value of
     * the period you want to be show - open / close / high / low / sum / average / count. For example: [[value.sum]] means
     * that sum of all data points of value field in the selected period will be displayed.
     */

    public void setLegendPeriodValueText(String legendPeriodValueText) {
        getAmGraph().legendPeriodValueText = legendPeriodValueText;
    }


    public String getLegendValueText() {
        return getAmGraph().legendValueText;
    }

    /**
     * ChartLegend value text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]]
     * You can also use custom fields from your dataProvider. If not set, uses ChartLegend's valueText.
     */

    public void setLegendValueText(String legendValueText) {
        getAmGraph().legendValueText = legendValueText;
    }


    public double getLineAlpha() {
        return getAmGraph().lineAlpha;
    }

    /**
     * Opacity of the line (or column border). Value range is 0 - 1.
     */

    public void setLineAlpha(double lineAlpha) {
        getAmGraph().lineAlpha = lineAlpha;
    }


    public String getLineColor() {
        return getAmGraph().lineColor;
    }

    /**
     * Color of the line (or column border). If you do not set any, the color from AmCoordinateChart.colors array will
     * be used for each subsequent getAmGraph().
     */

    public void setLineColor(String lineColor) {
        getAmGraph().lineColor = lineColor;
    }


    public String getLineColorField() {
        return getAmGraph().lineColorField;
    }

    /**
     * Name of the line color field in your dataProvider. This property adds a possibility to change graphs’ line color
     * on any data point to create highlighted sections of the getAmGraph(). Works only with AmSerialChart.
     */

    public void setLineColorField(String lineColorField) {
        getAmGraph().lineColorField = lineColorField;
    }


    public int getLineThickness() {
        return getAmGraph().lineThickness;
    }

    /**
     * Specifies thickness of the graph line (or column border).
     */

    public void setLineThickness(int lineThickness) {
        getAmGraph().lineThickness = lineThickness;
    }


    public String getLowField() {
        return getAmGraph().lowField;
    }

    /**
     * Name of the low field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setLowField(String lowField) {
        getAmGraph().lowField = lowField;
    }


    public String getMarkerType() {
        return getAmGraph().markerType;
    }

    /**
     * ChartLegend marker type. You can set legend marker (key) type for individual graphs. Possible values are: square,
     * circle, diamond, triangleUp, triangleDown, triangleLeft, triangleDown, bubble, line, none.
     */

    public void setMarkerType(String markerType) {
        getAmGraph().markerType = markerType;
    }


    public int getMaxBulletSize() {
        return getAmGraph().maxBulletSize;
    }

    /**
     * Specifies size of the bullet which value is the biggest (XY chart).
     */

    public void setMaxBulletSize(int maxBulletSize) {
        getAmGraph().maxBulletSize = maxBulletSize;
    }


    public int getMinDistance() {
        return getAmGraph().minDistance;
    }

    /**
     * It is useful if you have really lots of data points. Based on this property the graph will omit some of the
     * lines (if the distance between points is less that minDistance, in pixels). This will not affect the bullets or
     * indicator in anyway, so the user will not see any difference (unless you set minValue to a bigger value,
     * let say 5), but will increase performance as less lines will be drawn. By setting value to a bigger number
     * you can also make your lines look less jagged.
     */

    public void setMinDistance(int minDistance) {
        getAmGraph().minDistance = minDistance;
    }


    public int getNegativeBase() {
        return getAmGraph().negativeBase;
    }

    /**
     * If you use different colors for your negative values, a graph below zero line is filled with negativeColor.
     * With this property you can define a different base value at which colors should be changed to negative colors.
     */

    public void setNegativeBase(int negativeBase) {
        getAmGraph().negativeBase = negativeBase;
    }


    public double getNegativeFillAlphas() {
        return getAmGraph().negativeFillAlphas;
    }

    /**
     * Fill opacity of negative part of the getAmGraph(). Will use fillAlphas if not set.
     */

    public void setNegativeFillAlphas(double negativeFillAlphas) {
        getAmGraph().negativeFillAlphas = negativeFillAlphas;
    }


    public String getNegativeFillColors() {
        return getAmGraph().negativeFillColors;
    }

    /**
     * Fill color of negative part of the getAmGraph(). Will use fillColors if not set.
     */

    public void setNegativeFillColors(String negativeFillColors) {
        getAmGraph().negativeFillColors = negativeFillColors;
    }


    public double getNegativeLineAlpha() {
        return getAmGraph().negativeLineAlpha;
    }

    /**
     * Opacity of the negative portion of the line (or column border). Value range is 0 - 1.
     */

    public void setNegativeLineAlpha(double negativeLineAlpha) {
        getAmGraph().negativeLineAlpha = negativeLineAlpha;
    }


    public String getNegativeLineColor() {
        return getAmGraph().negativeLineColor;
    }

    /**
     * Color of the line (or column) when the values are negative. In case the graph type is candlestick or ohlc,
     * negativeLineColor is used when close value is less then open value.
     */

    public void setNegativeLineColor(String negativeLineColor) {
        getAmGraph().negativeLineColor = negativeLineColor;
    }


    public boolean isNewStack() {
        return getAmGraph().newStack;
    }

    /**
     * If you set it to true, column chart will begin new stack. This allows having Clustered and Stacked column/bar
     * chart.
     */

    public void setNewStack(boolean newStack) {
        getAmGraph().newStack = newStack;
    }


    public boolean isNoStepRisers() {
        return getAmGraph().noStepRisers;
    }

    /**
     * In case you want to have a step line graph without risers, you should set this to true.
     */

    public void setNoStepRisers(boolean noStepRisers) {
        getAmGraph().noStepRisers = noStepRisers;
    }


    public String getOpenField() {
        return getAmGraph().openField;
    }

    /**
     * Name of the open field (used by floating columns, candlesticks and ohlc) in your dataProvider.
     */

    public void setOpenField(String openField) {
        getAmGraph().openField = openField;
    }


    public Object getPattern() {
        return getAmGraph().pattern;
    }

    /**
     * Value of pattern should be object with url, width, height of an image, optionally it might have x, y, randomX
     * and randomY values. For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}.
     * If you want to have individual patterns for each column, define patterns in data provider and set
     * getAmGraph().patternField property. Check amcharts/patterns folder for some patterns. You can create your own
     * patterns and use them. Note, x, y, randomX and randomY properties won't work with IE8 and older. 3D bar/Pie
     * charts won't work properly with patterns.
     */

    public void setPattern(Object pattern) {
        getAmGraph().pattern = pattern;
    }


    public String getPatternField() {
        return getAmGraph().patternField;
    }

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values.
     * For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns
     * folder for some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY
     * properties won't work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */

    public void setPatternField(String patternField) {
        getAmGraph().patternField = patternField;
    }


    public int getPeriodSpan() {
        return getAmGraph().periodSpan;
    }

    /**
     * This property can be used by step graphs - you can set how many periods one horizontal line should span.
     */

    public void setPeriodSpan(int periodSpan) {
        getAmGraph().periodSpan = periodSpan;
    }


    public String getPointPosition() {
        return getAmGraph().pointPosition;
    }

    /**
     * Specifies where data points should be placed - on the beginning of the period (day, hour, etc) or in the middle
     * (only when parseDates property of categoryAxis is set to true). This setting affects Serial chart only.
     * Possible values are "start", "middle" and "end"
     */

    public void setPointPosition(String pointPosition) {
        getAmGraph().pointPosition = pointPosition;
    }


    public int getPrecision() {
        return getAmGraph().precision;
    }

    /**
     * Precision of values. Will use chart's precision if not set any.
     */

    public void setPrecision(int precision) {
        getAmGraph().precision = precision;
    }


    public boolean isProCandlesticks() {
        return getAmGraph().proCandlesticks;
    }

    /**
     * If this is set to true, candlesticks will be colored in a different manner - if current close is less than
     * current open, the candlestick will be empty, otherwise - filled with color. If previous close is less than
     * current close, the candlestick will use positive color, otherwise - negative color.
     */

    public void setProCandlesticks(boolean proCandlesticks) {
        getAmGraph().proCandlesticks = proCandlesticks;
    }


    public Object getSegmentData() {
        return getAmGraph().segmentData;
    }

    /**
     * Gantt chart only. Contains unmodified segment object from data provider.
     */

    public void setSegmentData(Object segmentData) {
        getAmGraph().segmentData = segmentData;
    }


    public boolean isShowAllValueLabels() {
        return getAmGraph().showAllValueLabels;
    }

    /**
     * If graph's type is column and labelText is set, graph hides labels which do not fit into the column's space or
     * go outside plot area. If you don't want these labels to be hidden, set this to true.
     */

    public void setShowAllValueLabels(boolean showAllValueLabels) {
        getAmGraph().showAllValueLabels = showAllValueLabels;
    }


    public boolean isShowBalloon() {
        return getAmGraph().showBalloon;
    }

    /**
     * Specifies whether the value balloon of this graph is shown when mouse is over data item or chart's indicator
     * is over some series.
     */

    public void setShowBalloon(boolean showBalloon) {
        getAmGraph().showBalloon = showBalloon;
    }


    public String getShowBalloonAt() {
        return getAmGraph().showBalloonAt;
    }

    /**
     * Specifies graphs value at which cursor is showed. This is only important for candlestick and ohlc charts, also
     * if column chart has "open" value. Possible values are: "open", "close", "high", "low". "top" and "bottom" values
     * will glue the balloon to top/bottom of the plot area.
     */

    public void setShowBalloonAt(String showBalloonAt) {
        getAmGraph().showBalloonAt = showBalloonAt;
    }


    public String getShowBulletsAt() {
        return getAmGraph().showBulletsAt;
    }

    /**
     * Works with candlestick graph type, you can set it to open, close, high, low. If you set it to high, the events
     * will be shown at the tip of the high line.
     */

    public void setShowBulletsAt(String showBulletsAt) {
        getAmGraph().showBulletsAt = showBulletsAt;
    }


    public boolean isShowHandOnHover() {
        return getAmGraph().showHandOnHover;
    }

    /**
     * If you want mouse pointer to change to hand when hovering the graph, set this property to true.
     */

    public void setShowHandOnHover(boolean showHandOnHover) {
        getAmGraph().showHandOnHover = showHandOnHover;
    }


    public boolean isShowOnAxis() {
        return getAmGraph().showOnAxis;
    }

    /**
     * It can only be used together with topRadius (when columns look like cylinders). If you set it to true, the
     * cylinder will be lowered down so that the center of it's bottom circle would be right on category axis.
     */

    public void setShowOnAxis(boolean showOnAxis) {
        getAmGraph().showOnAxis = showOnAxis;
    }


    public boolean isStackable() {
        return getAmGraph().stackable;
    }

    /**
     * If the value axis of this graph has stack types like "regular" or "100%" You can exclude this graph from stacking.
     */

    public void setStackable(boolean stackable) {
        getAmGraph().stackable = stackable;
    }


    public String getStepDirection() {
        return getAmGraph().stepDirection;
    }

    /**
     * Step graph only. Specifies to which direction step should be drawn.
     */

    public void setStepDirection(String stepDirection) {
        getAmGraph().stepDirection = stepDirection;
    }


    public boolean isSwitchable() {
        return getAmGraph().switchable;
    }

    /**
     * If you set it to false, the graph will not be hidden when user clicks on legend entry.
     */

    public void setSwitchable(boolean switchable) {
        getAmGraph().switchable = switchable;
    }


    public int getTabIndex() {
        return getAmGraph().tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on bullet/column (starting from first) when user
     * clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set using
     * accessibleLabel property of AmgetAmGraph(). Note, not all browsers and readers support getAmGraph().
     */

    public void setTabIndex(int tabIndex) {
        getAmGraph().tabIndex = tabIndex;
    }


    public String getTitle() {
        return getAmGraph().title;
    }

    /**
     * Graph title.
     */

    public void setTitle(String title) {
        getAmGraph().title = title;
    }


    public int getTopRadius() {
        return getAmGraph().topRadius;
    }

    /**
     * If you set this to 1, columns will become cylinders (must set depth3D and angle properties of a chart to >0
     * values in order this to be visible). you can make columns look like cones (set topRadius to 0) or even like
     * some glasses (set to bigger than 1). We strongly recommend setting grid opacity to 0 in order this to look good.
     */

    public void setTopRadius(int topRadius) {
        getAmGraph().topRadius = topRadius;
    }


    public String getType() {
        return getAmGraph().type;
    }

    /**
     * Type of the getAmGraph(). Possible values are: "line", "column", "step", "smoothedLine", "candlestick", "ohlc". XY and
     * Radar charts can only display "line" type graphs.
     */

    public void setType(String type) {
        getAmGraph().type = type;
    }


    public String getUrlField() {
        return getAmGraph().urlField;
    }

    /**
     * Name of the url field in your dataProvider.
     */

    public void setUrlField(String urlField) {
        getAmGraph().urlField = urlField;
    }


    public String getUrlTarget() {
        return getAmGraph().urlTarget;
    }

    /**
     * Target to open URLs in, i.e. _blank, _top, etc.
     */

    public void setUrlTarget(String urlTarget) {
        getAmGraph().urlTarget = urlTarget;
    }


    public boolean isUseLineColorForBulletBorder() {
        return getAmGraph().useLineColorForBulletBorder;
    }

    /**
     * If set to true, the bullet border will take the same color as graph line.
     */

    public void setUseLineColorForBulletBorder(boolean useLineColorForBulletBorder) {
        getAmGraph().useLineColorForBulletBorder = useLineColorForBulletBorder;
    }


    public boolean isUseNegativeColorIfDown() {
        return getAmGraph().useNegativeColorIfDown;
    }

    /**
     * If negativeLineColor and/or negativeFillColors are set and useNegativeColorIfDown is set to true
     * (default is false), the line, step and column graphs will use these colors for lines, bullets or
     * columns if previous value is bigger than current value. In case you set openField for the graph,
     * the graph will compare current value with openField value instead of comparing to previous value.
     */

    public void setUseNegativeColorIfDown(boolean useNegativeColorIfDown) {
        getAmGraph().useNegativeColorIfDown = useNegativeColorIfDown;
    }


    public AmValueAxis getValueAxis() {
        return getAmGraph().valueAxis;
    }

    /**
     * Specifies which value axis the graph will use. Will use the first value axis if not set. You can use reference
     * to the real AmValueAxis object or set value axis id.
     */

    public void setValueAxis(AmValueAxis valueAxis) {
        getAmGraph().valueAxis = valueAxis;
    }


    public String getValueField() {
        return getAmGraph().valueField;
    }

    /**
     * Name of the value field in your dataProvider.
     */

    public void setValueField(String valueField) {
        getAmGraph().valueField = valueField;
    }


    public boolean isVisibleInLegend() {
        return getAmGraph().visibleInLegend;
    }

    /**
     * Specifies whether this graph should be shown in the ChartLegend.
     */

    public void setVisibleInLegend(boolean visibleInLegend) {
        getAmGraph().visibleInLegend = visibleInLegend;
    }


    public AmValueAxis getxAxis() {
        return getAmGraph().xAxis;
    }

    /**
     * XY chart only. A horizontal value axis object to attach graph to.
     */

    public void setxAxis(AmValueAxis xAxis) {
        getAmGraph().xAxis = xAxis;
    }


    public String getxField() {
        return getAmGraph().xField;
    }

    /**
     * XY chart only. Name of the x field in your dataProvider.
     */

    public void setxField(String xField) {
        getAmGraph().xField = xField;
    }


    public AmValueAxis getyAxis() {
        return getAmGraph().yAxis;
    }

    /**
     * XY chart only. A vertical value axis object to attach graph to.
     */

    public void setyAxis(AmValueAxis yAxis) {
        getAmGraph().yAxis = yAxis;
    }


    public String getyField() {
        return getAmGraph().yField;
    }

    /**
     * XY chart only. Name of the y field in your dataProvider.
     */

    public void setyField(String yField) {
        getAmGraph().yField = yField;
    }

    /**
     * Hides graph's bullets.
     */
    public void hideBullets() {
        getAmGraph().hideBullets();
    }

    /**
     * Shows graph's bullets
     */
    public void showBullets() {
        getAmGraph().showBullets();
    }

    public AmGraph getAmGraph() {
        if (graph == null) {
            graph = new AmGraph();
        }
        return graph;
    }
}
