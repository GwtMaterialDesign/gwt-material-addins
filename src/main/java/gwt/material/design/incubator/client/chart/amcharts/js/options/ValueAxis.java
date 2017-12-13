package gwt.material.design.incubator.client.chart.amcharts.js.options;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ValueAxis {

    @JsProperty
    public boolean autoWrap;

    @JsProperty
    public int axisFrequency;

    @JsProperty
    public int axisTitleOffset;

    @JsProperty
    public Object balloonTextFunction;

    @JsProperty
    public int baseCoord;

    @JsProperty
    public int baseValue;

    @JsProperty
    public String duration;

    @JsProperty
    public Object durationUnits;

    @JsProperty
    public String gridType;

    @JsProperty
    public String id;

    @JsProperty
    public boolean includeAllValues;

    @JsProperty
    public boolean includeGuidesInMinMax;

    @JsProperty
    public boolean includeHidden;

    @JsProperty
    public boolean integersOnly;

    @JsProperty
    public Functions.Func labelFunction;

    @JsProperty
    public boolean logarithmic;

    @JsProperty
    public int max;

    @JsProperty
    public int maximum;

    @JsProperty
    public Date maximumDate;

    @JsProperty
    public int min;

    @JsProperty
    public int minimum;

    @JsProperty
    public Date minimumDate;

    @JsProperty
    public int minMaxMultiplier;

    @JsProperty
    public String minPeriod;

    @JsProperty
    public String pointPosition;

    @JsProperty
    public String position;

    @JsProperty
    public int precision;

    @JsProperty
    public boolean radarCategoriesEnabled;

    @JsProperty
    public boolean recalculateToPercents;

    @JsProperty
    public boolean reversed;

    @JsProperty
    public String stackType;

    @JsProperty
    public int step;

    @JsProperty
    public boolean strictMinMax;

    @JsProperty
    public int synchronizationMultiplier;

    @JsProperty
    public ValueAxis synchronizeWith;

    @JsProperty
    public String totalText;

    @JsProperty
    public String totalTextColor;

    @JsProperty
    public int totalTextOffset;

    @JsProperty
    public int treatZeroAs;

    @JsProperty
    public String type;

    @JsProperty
    public String  unit;

    @JsProperty
    public String unitPosition;

    @JsProperty
    public boolean usePrefixes;

    @JsProperty
    public boolean useScientificNotation;

    @JsProperty
    public int zeroGridAlpha;

    @JsMethod
    public native void  addListener(String type, Functions.Func handler);

    @JsMethod
    public native void coordinateToValue(int x, int y);

    @JsMethod
    public native int[] getCoordinate(int value);

    @JsMethod
    public native void removeListener(Object object, String type, Functions.Func handler);

    @JsMethod
    public native void synchronizeWithAxis(ValueAxis axis);

    @JsMethod
    public native void zoomOut();

    @JsMethod
    public native void zoomToValues(int startValue, int endValue);

    //TODO Events
}
