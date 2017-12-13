package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AxisBase {

    @JsProperty
    public boolean autoGridCount;

    @JsProperty
    public int autoRotateAngle;

    @JsProperty
    public int autoRotateCount;

    @JsProperty
    public double axisAlpha;

    @JsProperty
    public String axisColor;

    @JsProperty
    public int axisThickness;

    @JsProperty
    public int axisX;

    @JsProperty
    public int axisY;

    @JsProperty
    public AmBalloon balloon;

    @JsProperty
    public boolean boldLabels;

    @JsProperty
    public boolean boldPeriodBeginning;

    @JsProperty
    public boolean centerLabelOnFullPeriod;

    @JsProperty
    public boolean centerLabels;

    @JsProperty
    public boolean centerRotatedLabels;

    @JsProperty
    public String  color;

    @JsProperty
    public int dashLength;

    @JsProperty
    public Object[] dateFormats;

    @JsProperty
    public double fillAlpha;

    @JsProperty
    public String fillColor;

    @JsProperty
    public int firstDayOfWeek;

    @JsProperty
    public int fontSize;

    @JsProperty
    public double gridAlpha;

    @JsProperty
    public String gridColor;

    @JsProperty
    public int gridCount;

    @JsProperty
    public int gridThickness;

    @JsProperty
    public Guide[] guides;

    @JsProperty
    public boolean ignoreAxisWidth;

    @JsProperty
    public boolean inside;

    @JsProperty
    public int labelFrequency;

    @JsProperty
    public int labelOffset;

    @JsProperty
    public int labelRotation;

    @JsProperty
    public boolean labelsEnabled;

    @JsProperty
    public Object[] listeners;

    @JsProperty
    public boolean markPeriodChange;

    @JsProperty
    public int minHorizontalGap;

    @JsProperty
    public double minorGridAlpha;

    @JsProperty
    public boolean minorGridEnabled;

    @JsProperty
    public int minorTickLength;

    @JsProperty
    public int minVerticalGap;

    @JsProperty
    public int offset;

    @JsProperty
    public String position;

    @JsProperty
    public boolean showFirstLabel;

    @JsProperty
    public boolean showLastLabel;

    @JsProperty
    public int tickLength;

    @JsProperty
    public String title;

    @JsProperty
    public boolean titleBold;

    @JsProperty
    public String titleColor;

    @JsProperty
    public int titleFontSize;

    @JsProperty
    public int titleRotation;

    @JsMethod
    public native void addGuide(Guide guide);

    @JsMethod
    public native void removeGuide(Guide guide);

    // TODO Events
}
