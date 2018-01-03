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
package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

/**
 * Base class of {@link RectangularChart} and {@link RadarChart}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmCoordinateChart">Official Documentation</a>
 */
//@formatter:on
public abstract class CoordinateChart extends AbstractChart {

    public CoordinateChart(ChartType chartType) {
        super(chartType);
    }

    /**
     * Read-only. Array, holding processed chart's data.
     */
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    /**
     * Specifies the colors of the graphs if the lineColor of a graph is not set. If there are more graphs then colors
     * in this array, the chart picks a random color.
     */
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    /**
     * The array of graphs belonging to this chart.
     */
    public void setAmGraphs(AmGraph... graphs) {
        getChart().graphs = graphs;
    }

    /**
     * Specifies if grid should be drawn above the graphs or below. Will not work properly with 3D charts. Default
     * to false
     */
    public void setGridAboveGraphs(boolean gridAboveGraphs) {
        getChart().gridAboveGraphs = gridAboveGraphs;
    }

    /**
     * Instead of adding guides to the axes, you can push all of them to this array. In case guide has category or date
     * defined, it will automatically will be assigned to the category axis. Otherwise to first value axis, unless you
     * specify a different valueAxis for the guide.
     */
    public void setGuides(Guide... guides) {
        getChart().guides = guides;
    }

    /**
     * Specifies whether the animation should be sequenced or all objects should appear at once. Default to true
     */
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    /**
     * Duration of the animation, in seconds. Default to 0
     */
    public void setStartDuration(double startDuration) {
        getChart().startDuration = startDuration;
    }

    /**
     * Animation effect. Possible values are: easeOutSine, easeInSine, elastic, bounce. Default to "elastic"
     */
    public void setStartEffect(String startEffect) {
        getChart().startEffect = startEffect;
    }

    /**
     * The initial opacity of the column/line. If you set startDuration to a value higher than 0, the columns/lines
     * will fade in from startAlpha. Value range is 0 - 1. Default to 1
     */
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    /**
     * Target of url. Default to _self
     */
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    /**
     * The array of value axes. Chart creates one value axis automatically, so if you need only one value axis,
     * you don't need to create it.
     */
    public void setValueAxes(ValueAxis valueAxes) {
        getChart().valueAxes = valueAxes;
    }

    /**
     * Adds a graph to the chart.
     */
    public void addGraph(AmGraph amGraph) {
        getChart().addGraph(amGraph);
    }

    /**
     * Adds value axis to the chart. One value axis is created automatically, so if you don't want to change anything
     * or add more value axes, you don't need to add it.
     */
    public void addValueAxis(ValueAxis valueAxis) {
        getChart().addValueAxis(valueAxis);
    }

    /**
     * You can trigger the animation of the chart.
     */
    public void animateAgain() {
        getChart().animateAgain();
    }

    /**
     * Returns graph by id.
     */
    public AmGraph getGraphById(String id) {
        return getChart().getGraphById(id);
    }

    /**
     * Returns value axis by id.
     */
    public ValueAxis getValueAxisById(String id) {
        return getChart().getValueAxisById(id);
    }

    /**
     * Hide the graph (if it is visible). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    public void hideGraph(AmGraph amGraph) {
        getChart().hideGraph(amGraph);
    }

    /**
     * Hide value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    public void hideGraphsBalloon(AmGraph amGraph) {
        getChart().hideGraphsBalloon(amGraph);
    }

    /**
     * Highlight the graph. Usually this method is called from the Legend, when you roll-over the legend entry.
     */
    public void highlightGraph(AmGraph amGraph) {
        getChart().highlightGraph(amGraph);
    }

    /**
     * Removes graph from the chart.
     */
    public void removeGraph(AmGraph amGraph) {
        getChart().removeGraph(amGraph);
    }

    /**
     * Removes value axis from the chart. When you remove value axis, all graphs assigned to this axis are also removed.
     */
    public void removeValueAxis(ValueAxis valueAxis) {
        getChart().removeValueAxis(valueAxis);
    }

    /**
     * Show the graph (if it is hidden). Usually this method is called from the Legend, when you click on the legend
     * marker.
     */
    public void showGraph(AmGraph amGraph) {
        getChart().showGraph(amGraph);
    }

    /**
     * Show value balloon of a graph. Usually this method is called from the Legend, when you click on the legend text.
     */
    public void showGraphsBalloon(AmGraph amGraph) {
        getChart().showGraphsBalloon(amGraph);
    }

    /**
     * UnhighlightGraph the graph. Usually this method is called from the Legend, when you roll-out the legend entry.
     */
    public void unhighlightGraph(AmGraph amGraph) {
        getChart().unhighlightGraph(amGraph);
    }

    @Override
    public abstract AmCoordinateChart getChart();

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
