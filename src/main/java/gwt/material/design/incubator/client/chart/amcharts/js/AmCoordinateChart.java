package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.ext.EventFunc4;
import gwt.material.design.incubator.client.chart.amcharts.js.ext.EventFunc6;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GraphDataItem;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;
import gwt.material.design.jquery.client.api.Event;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Base class of {@link AmRectangularChart} and {@link AmRadarChart}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class AmCoordinateChart extends AmChart {

    /**
     * Read-only. Array, holding processed chart's data.
     */
    @JsProperty
    public Object[] chartData;

    /**
     * Specifies the colors of the graphs if the lineColor of a graph is not set. If there are more graphs then colors
     * in this array, the chart picks a random color.
     */
    @JsProperty
    public String[] colors;

    /**
     * The array of graphs belonging to this chart.
     */
    @JsProperty
    public AmGraph[] amGraphs;

    /**
     * Specifies if grid should be drawn above the graphs or below. Will not work properly with 3D charts. Default
     * to false
     */
    @JsProperty
    public boolean gridAboveGraphs;

    /**
     * Instead of adding guides to the axes, you can push all of them to this array. In case guide has category or date
     * defined, it will automatically will be assigned to the category axis. Otherwise to first value axis, unless you
     * specify a different valueAxis for the guide.
     */
    @JsProperty
    public Guide[] guides;

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once. Default to true
     */
    @JsProperty
    public boolean sequencedAnimation;

    /**
     * The initial opacity of the column/line. If you set startDuration to a value higher than 0, the columns/lines
     * will fade in from startAlpha. Value range is 0 - 1. Default to 1
     */
    @JsProperty
    public double startDuration;

    /**
     * Duration of the animation, in seconds. Default to 0
     */
    @JsProperty
    public String startEffect;

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "elastic"
     */
    @JsProperty
    public String startAlpha;

    /**
     * Target of url. Default to _self
     */
    @JsProperty
    public String urlTarget;

    /**
     * The array of value axes. Chart creates one value axis automatically, so if you need only one value axis,
     * you don't need to create it.
     */
    @JsProperty
    public ValueAxis valueAxes;

    /**
     * Adds a graph to the chart.
     */
    @JsMethod
    public native void addGraph(AmGraph amGraph);

    /**
     * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change anything
     * or add more value axes, you don't need to add it.
     */
    @JsMethod
    public native void addValueAxis(ValueAxis valueAxis);

    /**
     * You can trigger the animation of the chart.
     */
    @JsMethod
    public native void animateAgain();

    /**
     * Returns graph by id.
     */
    @JsMethod
    public native AmGraph getGraphById(String id);

    /**
     * Returns value axis by id.
     */
    @JsMethod
    public native ValueAxis getValueAxisById(String id);

    /**
     * Hide the graph (if it is visible). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    @JsMethod
    public native void hideGraph(AmGraph amGraph);

    /**
     * Hide value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    @JsMethod
    public native void hideGraphsBalloon(AmGraph amGraph);

    /**
     * Highlight the graph. Usually this method is called from the Legend, when you roll-over the legend entry.
     */
    @JsMethod
    public native void highlightGraph(AmGraph amGraph);

    /**
     * Removes graph from the chart.
     */
    @JsMethod
    public native void removeGraph(AmGraph amGraph);

    /**
     * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
     */
    @JsMethod
    public native void removeValueAxis(ValueAxis valueAxis);

    /**
     * Show the graph (if it is hidden). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    @JsMethod
    public native void showGraph(AmGraph amGraph);

    /**
     * Show value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    @JsMethod
    public native void showGraphsBalloon(AmGraph amGraph);

    /**
     * UnhighlightGraph the graph. Usually this method is called from the Legend, when you roll-out the legend entry.
     */
    @JsMethod
    public native void unhighlightGraph(AmGraph amGraph);

    /**
     * Dispatched when user clicks on a graph.
     */
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> clickGraph;

    /**
     * Dispatched when user clicks on the data item (column/bullet)
     */
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> clickGraphItem;

    /**
     * chart:AmChart, event:MouseEvent}	Dispatched when user right-clicks on the data item (column/bullet)
     */
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rightClickGraphItem;

    /**
     * Dispatched when user rolls-out of a graph.
     */
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> rollOutGraph;

    /**
     * Dispatched when user rolls-out of the data item (column/bullet)
     */
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rollOutGraphItem;

    /**
     * Dispatched when user rolls-over a graph.
     */
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> rollOverGraph;

    /**
     * Dispatched when user rolls-over data item (column/bullet)
     */
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rollOverGraphItem;
}
