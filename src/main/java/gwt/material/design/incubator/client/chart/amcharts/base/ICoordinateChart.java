/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

public interface ICoordinateChart {

    /**
     * Read-only. Array, holding processed chart's data.
     */
    void setChartData(Object... data);

    /**
     * Specifies the colors of the graphs if the lineColor of a graph is not set. If there are more graphs then colors
     * in this array, the chart picks a random color.
     */
    void setColors(String... colors);

    /**
     * The array of graphs belonging to this chart.
     */
    void setAmGraphs(AmGraph... graphs);

    /**
     * Specifies if grid should be drawn above the graphs or below. Will not work properly with 3D charts. Default
     * to false
     */
    void setGridAboveGraphs(boolean value);

    /**
     * Instead of adding guides to the axes, you can push all of them to this array. In case guide has category or date
     * defined, it will automatically will be assigned to the category axis. Otherwise to first value axis, unless you
     * specify a different valueAxis for the guide.
     */
    void setGuides(Guide... guides);

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once. Default to true
     */
    void setSequencedAnimation(boolean sequencedAnimation);

    /**
     * Duration of the animation, in seconds. Default to 0
     */
    void setStartDuration(double startDuration);

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "elastic"
     */
    void setStartEffect(String startEffect);

    /**
     * The initial opacity of the column/line. If you set startDuration to a value higher than 0, the columns/lines
     * will fade in from startAlpha. Value range is 0 - 1. Default to 1
     */
    void setStartAlpha(double startAlpha);

    /**
     * Target of url. Default to _self
     */
    void setUrlTarget(String urlTarget);

    /**
     * The array of value axes. Chart creates one value axis automatically, so if you need only one value axis,
     * you don't need to create it.
     */
    void setValueAxes(ValueAxis valueAxis);

    /**
     * Adds a graph to the chart.
     */
    void addGraph(AmGraph amGraph);

    /**
     * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change anything
     * or add more value axes, you don't need to add it.
     */
    void addValueAxis(ValueAxis valueAxis);

    /**
     * You can trigger the animation of the chart.
     */
    void animateAgain();

    /**
     * Returns graph by id.
     */
    AmGraph getGraphById(String id);

    /**
     * Returns value axis by id.
     */
    ValueAxis getValueAxisById(String id);

    /**
     * Hide the graph (if it is visible). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    void hideGraph(AmGraph amGraph);

    /**
     * Hide value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    void hideGraphsBalloon(AmGraph amGraph);

    /**
     * Highlight the graph. Usually this method is called from the Legend, when you roll-over the legend entry.
     */
    void highlightGraph(AmGraph amGraph);

    /**
     * Removes graph from the chart.
     */
    void removeGraph(AmGraph amGraph);

    /**
     * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
     */
    void removeValueAxis(ValueAxis valueAxis);

    /**
     * Show the graph (if it is hidden). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    void showGraph(AmGraph amGraph);

    /**
     * Show value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    void showGraphsBalloon(AmGraph amGraph);

    /**
     * UnhighlightGraph the graph. Usually this method is called from the Legend, when you roll-out the legend entry.
     */
    void unhighlightGraph(AmGraph amGraph);


    // TODO Events
    /**
     * Dispatched when user clicks on a graph.
     *//*
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> clickGraph;

    *//**
     * Dispatched when user clicks on the data item (column/bullet)
     *//*
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> clickGraphItem;

    *//**
     * chart:AmChart, event:MouseEvent}	Dispatched when user right-clicks on the data item (column/bullet)
     *//*
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rightClickGraphItem;

    *//**
     * Dispatched when user rolls-out of a graph.
     *//*
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> rollOutGraph;

    *//**
     * Dispatched when user rolls-out of the data item (column/bullet)
     *//*
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rollOutGraphItem;

    *//**
     * Dispatched when user rolls-over a graph.
     *//*
    @JsProperty
    public EventFunc4<String, AmGraph, AmChart, Event> rollOverGraph;

    *//**
     * Dispatched when user rolls-over data item (column/bullet)
     *//*
    @JsProperty
    public EventFunc6<String, AmGraph, GraphDataItem, Integer, AmChart, Event> rollOverGraphItem;*/
}
