package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmValueAxis;
import gwt.material.design.jquery.client.api.Functions;

public class Graph extends ChartOptions {

    private AmGraph graph = new AmGraph();

    public String getAccessibleLabel() {
        return graph.accessibleLabel;
    }

    /**
     * Text which screen readers will read if user rolls-over the bullet/column or sets focus using tab key (this is
     * possible only if tabIndex property of AmGraph is set to some number). Text is added as aria-label tag. Note -
     * not all screen readers and browsers support graph.
     */

    public void setAccessibleLabel(String accessibleLabel) {
        graph.accessibleLabel = accessibleLabel;
    }


    public String getAlphaField() {
        return graph.alphaField;
    }

    /**
     * Name of the alpha field in your dataProvider.
     */

    public void setAlphaField(String alphaField) {
        graph.alphaField = alphaField;
    }


    public boolean isAnimationPlayed() {
        return graph.animationPlayed;
    }

    /**
     * If you set this to true before chart is drawn, the animation of this graph won't be played.
     */

    public void setAnimationPlayed(boolean animationPlayed) {
        graph.animationPlayed = animationPlayed;
    }


    public AmBalloon getBalloon() {
        return graph.balloon;
    }

    /**
     * Allows customizing graphs balloons individually (only when ChartCursor is used). Note: the balloon object is not
     * created automatically, you should create it before setting properties
     */

    public void setBalloon(Balloon balloon) {
        graph.balloon = balloon.getBalloon();
    }


    public String getBallonColor() {
        return graph.ballonColor;
    }

    /**
     * Value balloon color. Will use graph or data item color if not set.
     */

    public void setBallonColor(String ballonColor) {
        graph.ballonColor = ballonColor;
    }


    public Functions.Func getBalloonFunction() {
        return graph.balloonFunction;
    }

    /**
     * If you set some function, the graph will call it and pass GraphDataItem and AmGraph objects to it. This function
     * should return graph. a string which will be displayed in a balloon.
     */

    public void setBalloonFunction(Functions.Func balloonFunction) {
        graph.balloonFunction = balloonFunction;
    }


    public String getBalloonText() {
        return graph.balloonText;
    }

    /**
     * Balloon text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]] or any other
     * field name from your data provider. HTML tags can also be used.
     */

    public void setBalloonText(String balloonText) {
        graph.balloonText = balloonText;
    }


    public boolean isBehindColumns() {
        return graph.behindColumns;
    }

    /**
     * Specifies if the line graph should be placed behind column graphs
     */

    public void setBehindColumns(boolean behindColumns) {
        graph.behindColumns = behindColumns;
    }


    public String getBullet() {
        return graph.bullet;
    }

    /**
     * Type of the bullets. Possible values are: "none", "round", "square", "triangleUp", "triangleDown",
     * "triangleLeft", "triangleRight", "bubble", "diamond", "xError", "yError" and "custom".
     */

    public void setBullet(String bullet) {
        graph.bullet = bullet;
    }


    public int getBulletAlpha() {
        return graph.bulletAlpha;
    }

    /**
     * Opacity of bullets. Value range is 0 - 1.
     */

    public void setBulletAlpha(int bulletAlpha) {
        graph.bulletAlpha = bulletAlpha;
    }


    public AmValueAxis getBulletAxis() {
        return graph.bulletAxis;
    }

    /**
     * BulletAxis value is used when you are building error chart. Error chart is a regular serial or XY chart with
     * bullet type set to "xError" or "yError". The graph should know which axis should be used to determine the size
     * of this bullet - that's when bulletAxis should be set. Besides that, you should also set graph.errorField.
     * You can also use other bullet types with this feature too. For example, if you set bulletAxis for XY chart,
     * the size of a bullet will change as you zoom the chart.
     */

    public void setBulletAxis(AmValueAxis bulletAxis) {
        graph.bulletAxis = bulletAxis;
    }


    public int getBulletBorderAlpha() {
        return graph.bulletBorderAlpha;
    }

    /**
     * Bullet border opacity.
     */

    public void setBulletBorderAlpha(int bulletBorderAlpha) {
        graph.bulletBorderAlpha = bulletBorderAlpha;
    }


    public String getBulletBorderColor() {
        return graph.bulletBorderColor;
    }

    /**
     * Bullet border color. Will use lineColor if not set.
     */

    public void setBulletBorderColor(String bulletBorderColor) {
        graph.bulletBorderColor = bulletBorderColor;
    }


    public String getBulletBorderThickness() {
        return graph.bulletBorderThickness;
    }

    /**
     * Bullet border thickness.
     */

    public void setBulletBorderThickness(String bulletBorderThickness) {
        graph.bulletBorderThickness = bulletBorderThickness;
    }


    public String getBulletColor() {
        return graph.bulletColor;
    }

    /**
     * Bullet color. Will use lineColor if not set.
     */

    public void setBulletColor(String bulletColor) {
        graph.bulletColor = bulletColor;
    }


    public String getBulletField() {
        return graph.bulletField;
    }

    /**
     * Name of the bullet field in your dataProvider.
     */

    public void setBulletField(String bulletField) {
        graph.bulletField = bulletField;
    }


    public int getBulletHitAreaSize() {
        return graph.bulletHitAreaSize;
    }

    /**
     * Useful for touch devices - if you set it to 20 or so, the bullets of a graph will have invisible circle around
     * the actual bullet (bullets should still be enabled), which will be easier to touch (bullets usually are smaller
     * and hard to hit).
     */

    public void setBulletHitAreaSize(int bulletHitAreaSize) {
        graph.bulletHitAreaSize = bulletHitAreaSize;
    }


    public int getBulletOffset() {
        return graph.bulletOffset;
    }

    /**
     * Bullet offset. Distance from the actual data point to the bullet. Can be used to place custom bullets above
     * the columns.
     */

    public void setBulletOffset(int bulletOffset) {
        graph.bulletOffset = bulletOffset;
    }


    public int getBulletSize() {
        return graph.bulletSize;
    }

    /**
     * Bullet size.
     */

    public void setBulletSize(int bulletSize) {
        graph.bulletSize = bulletSize;
    }


    public String getBulletSizeField() {
        return graph.bulletSizeField;
    }

    /**
     * Name of the bullet size field in your dataProvider.
     */

    public void setBulletSizeField(String bulletSizeField) {
        graph.bulletSizeField = bulletSizeField;
    }


    public String getClassNameField() {
        return graph.classNameField;
    }

    /**
     * If this field is set and addClassNames is enabled, the chart will look for a class name string in data using
     * this setting and apply additional class names to elements of the particular data points, such as bullets.
     */

    public void setClassNameField(String classNameField) {
        graph.classNameField = classNameField;
    }


    public String getCloseField() {
        return graph.closeField;
    }

    /**
     * Name of the close field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setCloseField(String closeField) {
        graph.closeField = closeField;
    }


    public String getClustered() {
        return graph.clustered;
    }

    /**
     * In case you want to place this graph's columns in front of other columns, set this to false. In case "true",
     * the columns will be clustered next to each other.
     * NOTE: clustering works only for graphs of type "column".
     */

    public void setClustered(String clustered) {
        graph.clustered = clustered;
    }


    public String getColor() {
        return graph.color;
    }

    /**
     * Color of value labels. Will use chart's color if not set.
     */

    public void setColor(String color) {
        graph.color = color;
    }


    public String getColorField() {
        return graph.colorField;
    }

    /**
     * Name of the color field in your dataProvider.
     */

    public void setColorField(String colorField) {
        graph.colorField = colorField;
    }


    public String getColumnIndexField() {
        return graph.columnIndexField;
    }

    /**
     * You can use this property with non-stacked column graphs and specify order of columns of each category
     * (starting from 0). Important: this feature does not work in stacked columns scenarios as well as with graph
     * toggling enabled in legend.
     */

    public void setColumnIndexField(String columnIndexField) {
        graph.columnIndexField = columnIndexField;
    }


    public String getColumnWidth() {
        return graph.columnWidth;
    }

    /**
     * You can specify custom column width for each graph individually. Value range is 0 - 1 (we set relative width,
     * not pixel width here).
     */

    public void setColumnWidth(String columnWidth) {
        graph.columnWidth = columnWidth;
    }


    public boolean isConnect() {
        return graph.connect;
    }

    /**
     * Specifies whether to connect data points if data is missing. The default value is true. This feature does
     * not work with XY chart.
     */

    public void setConnect(boolean connect) {
        graph.connect = connect;
    }


    public int getCornerRadiusTop() {
        return graph.cornerRadiusTop;
    }

    /**
     * Corner radius of column. It can be set both in pixels or in percents. The chart's depth and angle styles must
     * be set to 0. The default value is 0. Note, cornerRadiusTop will be applied for all corners of the column,
     * JavaScript charts do not have a possibility to set separate corner radius for top and bottom. As we want all
     * the property names to be the same both on JS and Flex, we didn't change this too.
     */

    public void setCornerRadiusTop(int cornerRadiusTop) {
        graph.cornerRadiusTop = cornerRadiusTop;
    }


    public int getCursorBulletAlpha() {
        return graph.cursorBulletAlpha;
    }

    /**
     * If bulletsEnabled of ChartCurosor is true, a bullet on each graph follows the cursor. You can set opacity of
     * each graphs bullet. In case you want to disable these bullets for a certain graph, set opacity to 0.
     */

    public void setCursorBulletAlpha(int cursorBulletAlpha) {
        graph.cursorBulletAlpha = cursorBulletAlpha;
    }


    public String getCustomBullet() {
        return graph.customBullet;
    }

    /**
     * Path to the image of custom bullet.
     */

    public void setCustomBullet(String customBullet) {
        graph.customBullet = customBullet;
    }


    public String getCustomBulletField() {
        return graph.customBulletField;
    }

    /**
     * Name of the custom bullet field in your dataProvider.
     */

    public void setCustomBulletField(String customBulletField) {
        graph.customBulletField = customBulletField;
    }


    public String getCustomMarker() {
        return graph.customMarker;
    }

    /**
     * Path to the image for legend marker.
     */

    public void setCustomMarker(String customMarker) {
        graph.customMarker = customMarker;
    }


    public int getDashLength() {
        return graph.dashLength;
    }

    /**
     * Dash length. If you set it to a value greater than 0, the graph line (or columns border) will be dashed.
     */

    public void setDashLength(int dashLength) {
        graph.dashLength = dashLength;
    }


    public String getDashLengthField() {
        return graph.dashLengthField;
    }

    /**
     * Name of the dash length field in your dataProvider. This property adds a possibility to change graphs’ line
     * from solid to dashed on any data point. You can also make columns border dashed using this setting. Note,
     * this won't work with smoothedLineGraph.
     */

    public void setDashLengthField(String dashLengthField) {
        graph.dashLengthField = dashLengthField;
    }


    public String getDateFormat() {
        return graph.dateFormat;
    }

    /**
     * Used to format balloons if value axis is date-based.
     */

    public void setDateFormat(String dateFormat) {
        graph.dateFormat = dateFormat;
    }


    public String getDescriptionField() {
        return graph.descriptionField;
    }

    /**
     * Name of the description field in your dataProvider.
     */

    public void setDescriptionField(String descriptionField) {
        graph.descriptionField = descriptionField;
    }


    public String getErrorField() {
        return graph.errorField;
    }

    /**
     * Name of error value field in your data provider.
     */

    public void setErrorField(String errorField) {
        graph.errorField = errorField;
    }


    public int getFillAlphas() {
        return graph.fillAlphas;
    }

    /**
     * Opacity of fill. Plural form is used to keep the same property names as our Flex charts'. Flex charts can accept
     * array of numbers to generate gradients. Although you can set array here, only first value of this array will be
     * used.
     */

    public void setFillAlphas(int fillAlphas) {
        graph.fillAlphas = fillAlphas;
    }


    public String getFillColors() {
        return graph.fillColors;
    }

    /**
     * Fill color. Will use lineColor if not set. You can also set array of colors here.F
     */

    public void setFillColors(String fillColors) {
        graph.fillColors = fillColors;
    }


    public String getFillColorsField() {
        return graph.fillColorsField;
    }

    /**
     * Name of the fill colors field in your dataProvider. This property adds a possibility to change line graphs’
     * fill color on any data point to create highlighted sections of the graph. Works only with AmSerialChart.
     */

    public void setFillColorsField(String fillColorsField) {
        graph.fillColorsField = fillColorsField;
    }


    public AmValueAxis getFillToAxis() {
        return graph.fillToAxis;
    }

    /**
     * XY chart only. If you set this property to id or reference of your X or Y axis, and the fillAlphas is > 0,
     * the area between graph and axis will be filled with color, like in this demo.
     */

    public void setFillToAxis(AmValueAxis fillToAxis) {
        graph.fillToAxis = fillToAxis;
    }


    public AmGraph getFillToAmGraph() {
        return graph.fillToAmGraph;
    }

    /**
     * You can set another graph here and if fillAlpha is >0, the area from this graph to fillToGraph will be filled
     * (instead of filling the area to the X axis). This feature is not supported by smoothedLine graphs and Radar chart.
     */

    public void setFillToAmGraph(AmGraph fillToAmGraph) {
        graph.fillToAmGraph = fillToAmGraph;
    }


    public int getFixedColumnWidth() {
        return graph.fixedColumnWidth;
    }

    /**
     * Column width in pixels. If you set this property, columns will be of a fixed width and won't adjust to the
     * available space.
     */

    public void setFixedColumnWidth(int fixedColumnWidth) {
        graph.fixedColumnWidth = fixedColumnWidth;
    }


    public int getFontSize() {
        return graph.fontSize;
    }

    /**
     * Size of value labels text. Will use chart's fontSize if not set.
     */

    public void setFontSize(int fontSize) {
        graph.fontSize = fontSize;
    }


    public boolean isForceGap() {
        return graph.forceGap;
    }

    /**
     * If this is set `true`, the graph will always break the line if the distance in time between two adjacent data
     * points is bigger than `gapPeriod x minPeriod`, even if `connect` is set to `true`.
     */

    public void setForceGap(boolean forceGap) {
        graph.forceGap = forceGap;
    }


    public String getGapField() {
        return graph.gapField;
    }

    /**
     * Name of the gap field in your dataProvider. You can force graph to show gap at a desired data point using this
     * feature. This feature does not work with XY chart.
     */

    public void setGapField(String gapField) {
        graph.gapField = gapField;
    }


    public double getGapPeriod() {
        return graph.gapPeriod;
    }

    /**
     * Using this property you can specify when graph should display gap - if the time difference between data points
     * is bigger than duration of minPeriod * gapPeriod, and connect property of a graph is set to false, graph will
     * display gap.
     */

    public void setGapPeriod(double gapPeriod) {
        graph.gapPeriod = gapPeriod;
    }


    public String getGradientOrientation() {
        return graph.gradientOrientation;
    }

    /**
     * Orientation of the gradient fills (only for "column" graph type). Possible values are "vertical" and "horizontal".
     */

    public void setGradientOrientation(String gradientOrientation) {
        graph.gradientOrientation = gradientOrientation;
    }


    public boolean isHidden() {
        return graph.hidden;
    }

    /**
     * Specifies whether the graph is hidden. Do not use this to show/hide the graph, use hideGraph(graph) and
     * showGraph(graph) methods instead.
     */

    public void setHidden(boolean hidden) {
        graph.hidden = hidden;
    }


    public int getHideBulletsCount() {
        return graph.hideBulletsCount;
    }

    /**
     * If there are more data points than hideBulletsCount, the bullets will not be shown. 0 means the bullets will
     * always be visible.
     */

    public void setHideBulletsCount(int hideBulletsCount) {
        graph.hideBulletsCount = hideBulletsCount;
    }


    public String getHighField() {
        return graph.highField;
    }

    /**
     * Name of the high field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setHighField(String highField) {
        graph.highField = highField;
    }


    public String getId() {
        return graph.id;
    }

    /**
     * Unique id of a graph. It is not required to set one, unless you want to use this graph for as your scrollbar's
     * graph and need to indicate which graph should be used.
     */

    public void setId(String id) {
        graph.id = id;
    }


    public boolean isIncludeInMinMax() {
        return graph.includeInMinMax;
    }

    /**
     * Whether to include this graph when calculating min and max value of the axis.
     */

    public void setIncludeInMinMax(boolean includeInMinMax) {
        graph.includeInMinMax = includeInMinMax;
    }


    public String getLabelAnchor() {
        return graph.labelAnchor;
    }

    /**
     * Data label text anchor.
     */

    public void setLabelAnchor(String labelAnchor) {
        graph.labelAnchor = labelAnchor;
    }


    public String getLabelColorField() {
        return graph.labelColorField;
    }

    /**
     * Name of label color field in data provider.
     */

    public void setLabelColorField(String labelColorField) {
        graph.labelColorField = labelColorField;
    }


    public Functions.Func getLabelFunction() {
        return graph.labelFunction;
    }

    /**
     * You can use it to format labels of data items in any way you want. Graph will call this function and pass
     * reference to GraphDataItem and formatted text as attributes. This function should return graph. string which will
     * be displayed as label.
     */

    public void setLabelFunction(Functions.Func labelFunction) {
        graph.labelFunction = labelFunction;
    }


    public int getLabelOffset() {
        return graph.labelOffset;
    }

    /**
     * Offset of data label.
     */

    public void setLabelOffset(int labelOffset) {
        graph.labelOffset = labelOffset;
    }


    public String getLabelPosition() {
        return graph.labelPosition;
    }

    /**
     * Position of value label. Possible values are: "bottom", "top", "right", "left", "inside", "middle".
     * Sometimes position is changed by the chart, depending on a graph type, rotation, etc.
     */

    public void setLabelPosition(String labelPosition) {
        graph.labelPosition = labelPosition;
    }


    public int getLabelRotation() {
        return graph.labelRotation;
    }

    /**
     * Rotation of a data label.
     */

    public void setLabelRotation(int labelRotation) {
        graph.labelRotation = labelRotation;
    }


    public String getLabelText() {
        return graph.labelText;
    }

    /**
     * Value label text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]].
     */

    public void setLabelText(String labelText) {
        graph.labelText = labelText;
    }


    public double getLegendAlpha() {
        return graph.legendAlpha;
    }

    /**
     * ChartLegend marker opacity. Will use lineAlpha if not set. Value range is 0 - 1.
     */

    public void setLegendAlpha(double legendAlpha) {
        graph.legendAlpha = legendAlpha;
    }


    public String getLegendColor() {
        return graph.legendColor;
    }

    /**
     * ChartLegend marker color. Will use lineColor if not set.
     */

    public void setLegendColor(String legendColor) {
        graph.legendColor = legendColor;
    }


    public Object getLegendColorFunction() {
        return graph.legendColorFunction;
    }

    /**
     * It is called and the following attributes are passed: dataItem, formattedText, periodValues, periodPercentValues.
     * It should return graph. hex color code which will be used for legend marker.
     */

    public void setLegendColorFunction(Object legendColorFunction) {
        graph.legendColorFunction = legendColorFunction;
    }


    public String getLegendPeriodValueText() {
        return graph.legendPeriodValueText;
    }

    /**
     * The text which will be displayed in the value portion of the legend when user is not hovering above any data point.
     * The tags should be made out of two parts - the name of a field (value / open / close / high / low) and the value of
     * the period you want to be show - open / close / high / low / sum / average / count. For example: [[value.sum]] means
     * that sum of all data points of value field in the selected period will be displayed.
     */

    public void setLegendPeriodValueText(String legendPeriodValueText) {
        graph.legendPeriodValueText = legendPeriodValueText;
    }


    public String getLegendValueText() {
        return graph.legendValueText;
    }

    /**
     * ChartLegend value text. You can use tags like [[value]], [[description]], [[percents]], [[open]], [[category]]
     * You can also use custom fields from your dataProvider. If not set, uses ChartLegend's valueText.
     */

    public void setLegendValueText(String legendValueText) {
        graph.legendValueText = legendValueText;
    }


    public double getLineAlpha() {
        return graph.lineAlpha;
    }

    /**
     * Opacity of the line (or column border). Value range is 0 - 1.
     */

    public void setLineAlpha(double lineAlpha) {
        graph.lineAlpha = lineAlpha;
    }


    public String getLineColor() {
        return graph.lineColor;
    }

    /**
     * Color of the line (or column border). If you do not set any, the color from AmCoordinateChart.colors array will
     * be used for each subsequent graph.
     */

    public void setLineColor(String lineColor) {
        graph.lineColor = lineColor;
    }


    public String getLineColorField() {
        return graph.lineColorField;
    }

    /**
     * Name of the line color field in your dataProvider. This property adds a possibility to change graphs’ line color
     * on any data point to create highlighted sections of the graph. Works only with AmSerialChart.
     */

    public void setLineColorField(String lineColorField) {
        graph.lineColorField = lineColorField;
    }


    public int getLineThickness() {
        return graph.lineThickness;
    }

    /**
     * Specifies thickness of the graph line (or column border).
     */

    public void setLineThickness(int lineThickness) {
        graph.lineThickness = lineThickness;
    }


    public String getLowField() {
        return graph.lowField;
    }

    /**
     * Name of the low field (used by candlesticks and ohlc) in your dataProvider.
     */

    public void setLowField(String lowField) {
        graph.lowField = lowField;
    }


    public String getMarkerType() {
        return graph.markerType;
    }

    /**
     * ChartLegend marker type. You can set legend marker (key) type for individual graphs. Possible values are: square,
     * circle, diamond, triangleUp, triangleDown, triangleLeft, triangleDown, bubble, line, none.
     */

    public void setMarkerType(String markerType) {
        graph.markerType = markerType;
    }


    public int getMaxBulletSize() {
        return graph.maxBulletSize;
    }

    /**
     * Specifies size of the bullet which value is the biggest (XY chart).
     */

    public void setMaxBulletSize(int maxBulletSize) {
        graph.maxBulletSize = maxBulletSize;
    }


    public int getMinDistance() {
        return graph.minDistance;
    }

    /**
     * It is useful if you have really lots of data points. Based on this property the graph will omit some of the
     * lines (if the distance between points is less that minDistance, in pixels). This will not affect the bullets or
     * indicator in anyway, so the user will not see any difference (unless you set minValue to a bigger value,
     * let say 5), but will increase performance as less lines will be drawn. By setting value to a bigger number
     * you can also make your lines look less jagged.
     */

    public void setMinDistance(int minDistance) {
        graph.minDistance = minDistance;
    }


    public int getNegativeBase() {
        return graph.negativeBase;
    }

    /**
     * If you use different colors for your negative values, a graph below zero line is filled with negativeColor.
     * With this property you can define a different base value at which colors should be changed to negative colors.
     */

    public void setNegativeBase(int negativeBase) {
        graph.negativeBase = negativeBase;
    }


    public double getNegativeFillAlphas() {
        return graph.negativeFillAlphas;
    }

    /**
     * Fill opacity of negative part of the graph. Will use fillAlphas if not set.
     */

    public void setNegativeFillAlphas(double negativeFillAlphas) {
        graph.negativeFillAlphas = negativeFillAlphas;
    }


    public String getNegativeFillColors() {
        return graph.negativeFillColors;
    }

    /**
     * Fill color of negative part of the graph. Will use fillColors if not set.
     */

    public void setNegativeFillColors(String negativeFillColors) {
        graph.negativeFillColors = negativeFillColors;
    }


    public double getNegativeLineAlpha() {
        return graph.negativeLineAlpha;
    }

    /**
     * Opacity of the negative portion of the line (or column border). Value range is 0 - 1.
     */

    public void setNegativeLineAlpha(double negativeLineAlpha) {
        graph.negativeLineAlpha = negativeLineAlpha;
    }


    public String getNegativeLineColor() {
        return graph.negativeLineColor;
    }

    /**
     * Color of the line (or column) when the values are negative. In case the graph type is candlestick or ohlc,
     * negativeLineColor is used when close value is less then open value.
     */

    public void setNegativeLineColor(String negativeLineColor) {
        graph.negativeLineColor = negativeLineColor;
    }


    public boolean isNewStack() {
        return graph.newStack;
    }

    /**
     * If you set it to true, column chart will begin new stack. This allows having Clustered and Stacked column/bar
     * chart.
     */

    public void setNewStack(boolean newStack) {
        graph.newStack = newStack;
    }


    public boolean isNoStepRisers() {
        return graph.noStepRisers;
    }

    /**
     * In case you want to have a step line graph without risers, you should set this to true.
     */

    public void setNoStepRisers(boolean noStepRisers) {
        graph.noStepRisers = noStepRisers;
    }


    public String getOpenField() {
        return graph.openField;
    }

    /**
     * Name of the open field (used by floating columns, candlesticks and ohlc) in your dataProvider.
     */

    public void setOpenField(String openField) {
        graph.openField = openField;
    }


    public Object getPattern() {
        return graph.pattern;
    }

    /**
     * Value of pattern should be object with url, width, height of an image, optionally it might have x, y, randomX
     * and randomY values. For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}.
     * If you want to have individual patterns for each column, define patterns in data provider and set
     * graph.patternField property. Check amcharts/patterns folder for some patterns. You can create your own
     * patterns and use them. Note, x, y, randomX and randomY properties won't work with IE8 and older. 3D bar/Pie
     * charts won't work properly with patterns.
     */

    public void setPattern(Object pattern) {
        graph.pattern = pattern;
    }


    public String getPatternField() {
        return graph.patternField;
    }

    /**
     * Field name in your data provider which holds pattern information. Value of pattern should be object with url,
     * width, height of an image, optionally it might have x, y, randomX and randomY values.
     * For example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}. Check amcharts/patterns
     * folder for some patterns. You can create your own patterns and use them. Note, x, y, randomX and randomY
     * properties won't work with IE8 and older. 3D bar/Pie charts won't work properly with patterns.
     */

    public void setPatternField(String patternField) {
        graph.patternField = patternField;
    }


    public int getPeriodSpan() {
        return graph.periodSpan;
    }

    /**
     * This property can be used by step graphs - you can set how many periods one horizontal line should span.
     */

    public void setPeriodSpan(int periodSpan) {
        graph.periodSpan = periodSpan;
    }


    public String getPointPosition() {
        return graph.pointPosition;
    }

    /**
     * Specifies where data points should be placed - on the beginning of the period (day, hour, etc) or in the middle
     * (only when parseDates property of categoryAxis is set to true). This setting affects Serial chart only.
     * Possible values are "start", "middle" and "end"
     */

    public void setPointPosition(String pointPosition) {
        graph.pointPosition = pointPosition;
    }


    public int getPrecision() {
        return graph.precision;
    }

    /**
     * Precision of values. Will use chart's precision if not set any.
     */

    public void setPrecision(int precision) {
        graph.precision = precision;
    }


    public boolean isProCandlesticks() {
        return graph.proCandlesticks;
    }

    /**
     * If this is set to true, candlesticks will be colored in a different manner - if current close is less than
     * current open, the candlestick will be empty, otherwise - filled with color. If previous close is less than
     * current close, the candlestick will use positive color, otherwise - negative color.
     */

    public void setProCandlesticks(boolean proCandlesticks) {
        graph.proCandlesticks = proCandlesticks;
    }


    public Object getSegmentData() {
        return graph.segmentData;
    }

    /**
     * Gantt chart only. Contains unmodified segment object from data provider.
     */

    public void setSegmentData(Object segmentData) {
        graph.segmentData = segmentData;
    }


    public boolean isShowAllValueLabels() {
        return graph.showAllValueLabels;
    }

    /**
     * If graph's type is column and labelText is set, graph hides labels which do not fit into the column's space or
     * go outside plot area. If you don't want these labels to be hidden, set this to true.
     */

    public void setShowAllValueLabels(boolean showAllValueLabels) {
        graph.showAllValueLabels = showAllValueLabels;
    }


    public boolean isShowBalloon() {
        return graph.showBalloon;
    }

    /**
     * Specifies whether the value balloon of this graph is shown when mouse is over data item or chart's indicator
     * is over some series.
     */

    public void setShowBalloon(boolean showBalloon) {
        graph.showBalloon = showBalloon;
    }


    public String getShowBalloonAt() {
        return graph.showBalloonAt;
    }

    /**
     * Specifies graphs value at which cursor is showed. This is only important for candlestick and ohlc charts, also
     * if column chart has "open" value. Possible values are: "open", "close", "high", "low". "top" and "bottom" values
     * will glue the balloon to top/bottom of the plot area.
     */

    public void setShowBalloonAt(String showBalloonAt) {
        graph.showBalloonAt = showBalloonAt;
    }


    public String getShowBulletsAt() {
        return graph.showBulletsAt;
    }

    /**
     * Works with candlestick graph type, you can set it to open, close, high, low. If you set it to high, the events
     * will be shown at the tip of the high line.
     */

    public void setShowBulletsAt(String showBulletsAt) {
        graph.showBulletsAt = showBulletsAt;
    }


    public boolean isShowHandOnHover() {
        return graph.showHandOnHover;
    }

    /**
     * If you want mouse pointer to change to hand when hovering the graph, set this property to true.
     */

    public void setShowHandOnHover(boolean showHandOnHover) {
        graph.showHandOnHover = showHandOnHover;
    }


    public boolean isShowOnAxis() {
        return graph.showOnAxis;
    }

    /**
     * It can only be used together with topRadius (when columns look like cylinders). If you set it to true, the
     * cylinder will be lowered down so that the center of it's bottom circle would be right on category axis.
     */

    public void setShowOnAxis(boolean showOnAxis) {
        graph.showOnAxis = showOnAxis;
    }


    public boolean isStackable() {
        return graph.stackable;
    }

    /**
     * If the value axis of this graph has stack types like "regular" or "100%" You can exclude this graph from stacking.
     */

    public void setStackable(boolean stackable) {
        graph.stackable = stackable;
    }


    public String getStepDirection() {
        return graph.stepDirection;
    }

    /**
     * Step graph only. Specifies to which direction step should be drawn.
     */

    public void setStepDirection(String stepDirection) {
        graph.stepDirection = stepDirection;
    }


    public boolean isSwitchable() {
        return graph.switchable;
    }

    /**
     * If you set it to false, the graph will not be hidden when user clicks on legend entry.
     */

    public void setSwitchable(boolean switchable) {
        graph.switchable = switchable;
    }


    public int getTabIndex() {
        return graph.tabIndex;
    }

    /**
     * In case you set it to some number, the chart will set focus on bullet/column (starting from first) when user
     * clicks tab key. When a focus is set, screen readers like NVDA Screen reader will read label which is set using
     * accessibleLabel property of AmGraph. Note, not all browsers and readers support graph.
     */

    public void setTabIndex(int tabIndex) {
        graph.tabIndex = tabIndex;
    }


    public String getTitle() {
        return graph.title;
    }

    /**
     * Graph title.
     */

    public void setTitle(String title) {
        graph.title = title;
    }


    public int getTopRadius() {
        return graph.topRadius;
    }

    /**
     * If you set this to 1, columns will become cylinders (must set depth3D and angle properties of a chart to >0
     * values in order this to be visible). you can make columns look like cones (set topRadius to 0) or even like
     * some glasses (set to bigger than 1). We strongly recommend setting grid opacity to 0 in order this to look good.
     */

    public void setTopRadius(int topRadius) {
        graph.topRadius = topRadius;
    }


    public String getType() {
        return graph.type;
    }

    /**
     * Type of the graph. Possible values are: "line", "column", "step", "smoothedLine", "candlestick", "ohlc". XY and
     * Radar charts can only display "line" type graphs.
     */

    public void setType(String type) {
        graph.type = type;
    }


    public String getUrlField() {
        return graph.urlField;
    }

    /**
     * Name of the url field in your dataProvider.
     */

    public void setUrlField(String urlField) {
        graph.urlField = urlField;
    }


    public String getUrlTarget() {
        return graph.urlTarget;
    }

    /**
     * Target to open URLs in, i.e. _blank, _top, etc.
     */

    public void setUrlTarget(String urlTarget) {
        graph.urlTarget = urlTarget;
    }


    public boolean isUseLineColorForBulletBorder() {
        return graph.useLineColorForBulletBorder;
    }

    /**
     * If set to true, the bullet border will take the same color as graph line.
     */

    public void setUseLineColorForBulletBorder(boolean useLineColorForBulletBorder) {
        graph.useLineColorForBulletBorder = useLineColorForBulletBorder;
    }


    public boolean isUseNegativeColorIfDown() {
        return graph.useNegativeColorIfDown;
    }

    /**
     * If negativeLineColor and/or negativeFillColors are set and useNegativeColorIfDown is set to true
     * (default is false), the line, step and column graphs will use these colors for lines, bullets or
     * columns if previous value is bigger than current value. In case you set openField for the graph,
     * the graph will compare current value with openField value instead of comparing to previous value.
     */

    public void setUseNegativeColorIfDown(boolean useNegativeColorIfDown) {
        graph.useNegativeColorIfDown = useNegativeColorIfDown;
    }


    public AmValueAxis getValueAxis() {
        return graph.valueAxis;
    }

    /**
     * Specifies which value axis the graph will use. Will use the first value axis if not set. You can use reference
     * to the real AmValueAxis object or set value axis id.
     */

    public void setValueAxis(AmValueAxis valueAxis) {
        graph.valueAxis = valueAxis;
    }


    public String getValueField() {
        return graph.valueField;
    }

    /**
     * Name of the value field in your dataProvider.
     */

    public void setValueField(String valueField) {
        graph.valueField = valueField;
    }


    public boolean isVisibleInLegend() {
        return graph.visibleInLegend;
    }

    /**
     * Specifies whether this graph should be shown in the ChartLegend.
     */

    public void setVisibleInLegend(boolean visibleInLegend) {
        graph.visibleInLegend = visibleInLegend;
    }


    public AmValueAxis getxAxis() {
        return graph.xAxis;
    }

    /**
     * XY chart only. A horizontal value axis object to attach graph to.
     */

    public void setxAxis(AmValueAxis xAxis) {
        graph.xAxis = xAxis;
    }


    public String getxField() {
        return graph.xField;
    }

    /**
     * XY chart only. Name of the x field in your dataProvider.
     */

    public void setxField(String xField) {
        graph.xField = xField;
    }


    public AmValueAxis getyAxis() {
        return graph.yAxis;
    }

    /**
     * XY chart only. A vertical value axis object to attach graph to.
     */

    public void setyAxis(AmValueAxis yAxis) {
        graph.yAxis = yAxis;
    }


    public String getyField() {
        return graph.yField;
    }

    /**
     * XY chart only. Name of the y field in your dataProvider.
     */

    public void setyField(String yField) {
        graph.yField = yField;
    }

    public AmGraph getGraph() {
        return graph;
    }
}
