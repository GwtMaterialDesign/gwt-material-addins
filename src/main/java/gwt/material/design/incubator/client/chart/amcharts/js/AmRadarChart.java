package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Extension for {@link AmCoordinateChart} to create radar/polar charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRadarChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmRadarChart extends AmCoordinateChart {

    /**
     * Field in your data provider containing categories.
     */
    @JsProperty
    public String categoryField;

    /**
     * Bottom margin of the chart. Default to 0
     */
    @JsProperty
    public int marginBottom;

    /**
     * Left margin of the chart. Default to 0
     */
    @JsProperty
    public int marginLeft;

    /**
     * Right margin of the chart. Default to 0
     */
    @JsProperty
    public int marginRight;

    /**
     * Top margin of the chart. Default to 0
     */
    @JsProperty
    public int marginTop;

    /**
     * Radius of a radar. Default to 35%
     */
    @JsProperty
    public Object radius;

}
