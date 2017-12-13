package gwt.material.design.incubator.client.chart.amcharts.js;

import com.google.gwt.json.client.JSONValue;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Label;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Title;
import gwt.material.design.incubator.client.chart.amcharts.js.plugins.DataLoader;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmChart {

    @JsProperty
    public boolean accessible;

    @JsProperty
    public String accessibleDescription;

    @JsProperty
    public String accessibleTitle;

    @JsProperty
    public boolean addClassNames;

    @JsProperty
    public Label[] allLabels;

    @JsProperty
    public boolean autoDisplay;

    @JsProperty
    public boolean autoResize;

    @JsProperty
    public boolean autoTransform;

    @JsProperty
    public double backgroundAlpha;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public AmBalloon balloon;

    @JsProperty
    public double borderAlpha;

    @JsProperty
    public String borderColor;

    @JsProperty
    public String classNamePrefix;

    @JsProperty
    public String color;

    @JsProperty
    public String creditsPosition;

    @JsProperty
    public DataLoader dataLoader;

    @JsProperty
    public Object dataProvider;

    @JsProperty
    public String decimalSeparator;

    @JsProperty
    public Object defs;

    @JsProperty
    public String fontFamily;

    @JsProperty
    public int fontSize;

    @JsProperty
    public boolean handDrawn;

    @JsProperty
    public int handDrawScatter;

    @JsProperty
    public int handDrawThickness;

    @JsProperty
    public int hideBalloonTime;

    @JsProperty
    public String language;

    @JsProperty
    public AmLegend legend;

    @JsProperty
    public String legendDiv;

    @JsProperty
    public Object[] listeners;

    @JsProperty
    public boolean panEventsEnabled;

    @JsProperty
    public String path;

    @JsProperty
    public String pathToImages;

    @JsProperty
    public int percentPrecision;

    @JsProperty
    public int precision;

    @JsProperty
    public Object[] prefixesOfBigNumbers;

    @JsProperty
    public Object[] prefixesOfSmallNumbers;

    @JsProperty
    public int processCount;

    @JsProperty
    public int processTimeout;

    @JsProperty
    public Object responsive;

    @JsProperty
    public boolean svgIcons;

    @JsProperty
    public boolean tapToActivate;

    @JsProperty
    public String theme;

    @JsProperty
    public String thousandsSeparator;

    @JsProperty
    public Title[] titles;

    @JsProperty
    public int touchClickDuration;

    @JsProperty
    public String type;

    @JsProperty
    public boolean usePrefixes;

    @JsProperty
    public String version;

    @JsMethod
    public native void addLabel(int x, int y, String text, String align, int size, String color, int rotation, double alpha, boolean bold, String url);

    @JsMethod
    public native void addLegend(AmLegend legend, String targetElementId);

    @JsMethod
    public native void addTitle(String text, int size, String color, double alpha, boolean bold);

    @JsMethod
    public native void clear();

    @JsMethod
    public native void clearLabels();

    @JsMethod
    public native void invalidateSize();

    @JsMethod
    public native void makeChart(String containerId, JSONValue config, int delay);

    @JsMethod
    public native void validateData();

    @JsMethod
    public native void  validateNow(Object validateData, boolean skipEvents);

    @JsMethod
    public native void write(String elementId);

    // TODO Events
}
