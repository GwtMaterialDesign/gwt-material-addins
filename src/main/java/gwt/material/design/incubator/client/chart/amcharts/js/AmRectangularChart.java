package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmRectangularChart extends AmCoordinateChart {

    @JsProperty
    public int angle;

    @JsProperty
    public int autoMarginOffset;

    @JsProperty
    public boolean autoMargins;

    @JsProperty
    public int marginRight;


    @JsProperty
    public int marginTop;

}
