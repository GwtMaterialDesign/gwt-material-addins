package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "AmCharts")
public class AmPieChart extends AmSlicedChart {

    @JsProperty
    public boolean adjustPrecision;

    @JsProperty
    public int angle;

    @JsProperty
    public Functions.Func balloonFunction;

    @JsProperty
    public String balloonText;

    @JsProperty
    public int depth3D;

    @JsProperty
    public String gradientType;

    @JsProperty
    public int innerRadius;

    @JsProperty
    public int labelRadius;

    @JsProperty
    public String labelRadiusField;

    @JsProperty
    public String labelText;

    @JsProperty
    public int minRadius;

    @JsProperty
    public Object pieX;

    @JsProperty
    public Object pieY;

    @JsProperty
    public Object radius;

    @JsProperty
    public Object startAngle;

    @JsProperty
    public Object startRadius;
}
