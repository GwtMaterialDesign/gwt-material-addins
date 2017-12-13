package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "AmCharts")
public class AmFunnelChart {

    @JsProperty
    public int angle;

    @JsProperty
    public String balloonText;

    @JsProperty
    public int baseWidth;

    @JsProperty
    public int depth3D;

    @JsProperty
    public String labelPosition;

    @JsProperty
    public String labelText;

    @JsProperty
    public int neckHeight;

    @JsProperty
    public int neckWidth;

    @JsProperty
    public int pullDistance;

    @JsProperty
    public boolean rotate;

    @JsProperty
    public int startX;

    @JsProperty
    public int startY;

    @JsProperty
    public String valueRepresents;
}
