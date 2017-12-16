package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Extension for {@link AmSlicedChart} to create pie/donut charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmPieChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmPieChart extends AmSlicedChart {

    /**
     * Sometimes, because of a rounding, percent of a sum of all slices is not equal to 100%. If you set this to true,
     * when this case happens, number of decimals will be increased so that sum would become 100%. Default to false
     */
    @JsProperty
    public boolean adjustPrecision;

    /**
     * Pie lean angle (for 3D effect). Valid range is 0 - 90. Default to 0
     */
    @JsProperty
    public int angle;

    /**
     * If you set some function, the graph will call it and pass
     * {@link gwt.material.design.incubator.client.chart.amcharts.js.options.GraphDataItem} object to it. This function
     * should return a string which will be displayed in a balloon.
     */
    @JsProperty
    public Functions.Func balloonFunction;

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used.
     * Default to [[title]]: [[percents]]% ([[value]])\n[[description]]
     */
    @JsProperty
    public String balloonText;

    /**
     * Depth of the pie (for 3D effect). Default to 0
     */
    @JsProperty
    public int depth3D;

    /**
     * Type of gradient. Use gradientRatio to create gradients. Default to radial
     */
    @JsProperty
    public String gradientType;

    /**
     * Inner radius of the pie, in pixels or percents. Default to 0
     */
    @JsProperty
    public int innerRadius;

    /**
     * The distance between the label and the slice, in pixels. You can use negative values to put the label on
     * the slice. Default to 20
     */
    @JsProperty
    public int labelRadius;

    /**
     * Name of the field in dataProvider which specifies the length of a tick. Note, the chart will not try to arrange
     * labels automatically if this property is set.
     */
    @JsProperty
    public String labelRadiusField;

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. Default to [[title]]: [[percents]]%
     */
    @JsProperty
    public String labelText;

    /**
     * Minimum radius of the pie, in pixels. Default to 10
     */
    @JsProperty
    public int minRadius;

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    @JsProperty
    public Object pieX;

    /**
     * You can set fixed position of a pie center, in pixels or in percents.
     */
    @JsProperty
    public Object pieY;

    /**
     * Pull out radius, in pixels or percents. Default to 20%
     */
    @JsProperty
    public Object pullOutRadius;

    /**
     * Radius of a pie, in pixels or percents. By default, radius is calculated automatically.
     */
    @JsProperty
    public Object radius;

    /**
     * Angle of the first slice, in degrees. This will work properly only if "depth3D" is set to 0. If "depth3D" is
     * greater than 0, then there can be two angles only: 90 and 270. Value range is 0-360. Default to 90
     */
    @JsProperty
    public Object startAngle;

    /**
     * Radius of the positions from which the slices will fly in. Default to 500%
     */
    @JsProperty
    public Object startRadius;
}
