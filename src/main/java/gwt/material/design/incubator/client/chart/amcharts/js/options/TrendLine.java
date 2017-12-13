package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class TrendLine {

    @JsProperty
    public String balloonText;

    @JsProperty
    public int dashLength;

    @JsProperty
    public String finalCategory;

    @JsProperty
    public Date finalDate;

    @JsProperty
    public Image finalImage;

    @JsProperty
    public int finalValue;

    @JsProperty
    public int finalXValue;

    @JsProperty
    public String id;

    @JsProperty
    public String initialCategory;

    @JsProperty
    public Date initialDate;

    @JsProperty
    public Image initialImage;

    @JsProperty
    public int initialValue;

    @JsProperty
    public int initialXValue;

    @JsProperty
    public boolean isProtected;

    @JsProperty
    public double lineAlpha;

    @JsProperty
    public String lineColor;

    @JsProperty
    public int lineThickness;

    @JsProperty
    public ValueAxis valueAxis;

    @JsProperty
    public ValueAxis valueAxisX;

    // TODO Events
}
