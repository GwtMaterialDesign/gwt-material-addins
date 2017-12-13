package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeAxis {

    @JsProperty
    public double axisAlpha;

    @JsProperty
    public String axisColor;

    @JsProperty
    public int axisThickness;

    @JsProperty
    public double bandAlpha;

    @JsProperty
    public int[] bandGradientRatio;

    @JsProperty
    public double bandOutlineAlpha;

    @JsProperty
    public String bandOutlineColor;

    @JsProperty
    public int bandOutlineThickness;

    @JsProperty
    public GaugeBand[] bands;

    @JsProperty
    public String bottomText;

    @JsProperty
    public boolean bottomTextBold;

    @JsProperty
    public String bottomTextColor;

    @JsProperty
    public int bottomTextFontSize;

    @JsProperty
    public int bottomTextYOffset;

    @JsProperty
    public Object centerX;

    @JsProperty
    public Object centerY;

    @JsProperty
    public String color;

    @JsProperty
    public int endAngle;

    @JsProperty
    public int endValue;

    @JsProperty
    public int fontSize;

    @JsProperty
    public int gridCount;

    @JsProperty
    public boolean gridInside;

    @JsProperty
    public int id;

    @JsProperty
    public boolean inside;

    @JsProperty
    public int labelFrequency;

    @JsProperty
    public Functions.Func labelFunction;

    @JsProperty
    public int labelOffset;

    @JsProperty
    public boolean labelsEnabled;

    @JsProperty
    public Object[] listeners;

    @JsProperty
    public int minorTickInterval;

    @JsProperty
    public int minorTickLength;

    @JsProperty
    public Object radius;

    @JsProperty
    public boolean showFirstLabel;

    @JsProperty
    public boolean showLastLabel;

    @JsProperty
    public int startAngle;

    @JsProperty
    public int startValue;

    @JsProperty
    public double tickAlpha;

    @JsProperty
    public String tickColor;

    @JsProperty
    public int tickLength;

    @JsProperty
    public int tickThickness;

    @JsProperty
    public String topText;

    @JsProperty
    public boolean topTextBold;

    @JsProperty
    public String topTextColor;

    @JsProperty
    public int topTextFontSize;

    @JsProperty
    public int topTextYOffset;

    @JsProperty
    public String unit;

    @JsProperty
    public String unitPosition;

    @JsProperty
    public boolean usePrefixes;

    @JsProperty
    public int valueInterval;

    @JsMethod
    public native void addListener(String type, Functions.Func handler);

    @JsMethod
    public native void removeListener(AmChart chart, String type, Functions.Func handler);

    @JsMethod
    public native void setBottomText(String text);

    @JsMethod
    public native void setTopText(String text);

    @JsMethod
    public native int value2angle(int value);

    // TODO Events
}
