package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 *
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmRadarChart extends AmCoordinateChart {

    @JsProperty
    public String categoryField;

    @JsProperty
    public int marginBottom;

    @JsProperty
    public int marginLeft;

    @JsProperty
    public int marginRight;

    @JsProperty
    public int marginTop;

    @JsProperty
    public Object radius;

}
