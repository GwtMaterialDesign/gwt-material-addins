package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmCoordinateChart extends AmChart {

    @JsProperty
    public Object[] chartData;

    @JsProperty
    public String[] colors;

    @JsProperty
    public AmGraph[] amGraphs;

    @JsProperty
    public boolean gridAboveGraphs;

    @JsProperty
    public Guide[] guides;

    @JsProperty
    public boolean sequencedAnimation;

    @JsProperty
    public double startDuration;

    @JsProperty
    public String startEffect;

    @JsProperty
    public String startAlpha;

    @JsProperty
    public String urlTarget;

    @JsProperty
    public ValueAxis valueAxes;

    @JsMethod
    public native void addGraph(AmGraph amGraph);

    @JsMethod
    public native void addValueAxis(ValueAxis valueAxis);

    @JsMethod
    public native void animateAgain();

    @JsMethod
    public native AmGraph getGraphById(String id);

    @JsMethod
    public native ValueAxis getValueAxisById(String id);

    @JsMethod
    public native void hideGraph(AmGraph amGraph);

    @JsMethod
    public native void hideGraphsBalloon(AmGraph amGraph);

    @JsMethod
    public native void highlightGraph(AmGraph amGraph);

    @JsMethod
    public native void removeGraph(AmGraph amGraph);

    @JsMethod
    public native void removeValueAxis(ValueAxis valueAxis);

    @JsMethod
    public native void showGraph(AmGraph amGraph);

    @JsMethod
    public native void showGraphsBalloon(AmGraph amGraph);

    @JsMethod
    public native void unhighlightGraph(AmGraph amGraph);

    // TODO Events
}
