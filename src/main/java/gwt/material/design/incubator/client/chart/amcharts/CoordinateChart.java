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
import gwt.material.design.incubator.client.chart.amcharts.base.ICoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmCoordinateChart;
import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.Guide;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

public abstract class CoordinateChart extends AbstractChart implements ICoordinateChart {

    public CoordinateChart(ChartType chartType) {
        super(chartType);
    }

    @Override
    public void setChartData(Object... chartData) {
        getChart().chartData = chartData;
    }

    @Override
    public void setColors(String... colors) {
        getChart().colors = colors;
    }

    @Override
    public void setAmGraphs(AmGraph... graphs) {
        getChart().graphs = graphs;
    }

    @Override
    public void setGridAboveGraphs(boolean gridAboveGraphs) {
        getChart().gridAboveGraphs = gridAboveGraphs;
    }

    @Override
    public void setGuides(Guide... guides) {
        getChart().guides = guides;
    }

    @Override
    public void setSequencedAnimation(boolean sequencedAnimation) {
        getChart().sequencedAnimation = sequencedAnimation;
    }

    @Override
    public void setStartDuration(double startDuration) {
        getChart().startDuration = startDuration;
    }

    @Override
    public void setStartEffect(String startEffect) {
        getChart().startEffect = startEffect;
    }

    @Override
    public void setStartAlpha(double startAlpha) {
        getChart().startAlpha = startAlpha;
    }

    @Override
    public void setUrlTarget(String urlTarget) {
        getChart().urlTarget = urlTarget;
    }

    @Override
    public void setValueAxes(ValueAxis valueAxes) {
        getChart().valueAxes = valueAxes;
    }

    @Override
    public void addGraph(AmGraph amGraph) {
        getChart().addGraph(amGraph);
    }

    @Override
    public void addValueAxis(ValueAxis valueAxis) {
        getChart().addValueAxis(valueAxis);
    }

    @Override
    public void animateAgain() {
        getChart().animateAgain();
    }

    @Override
    public AmGraph getGraphById(String id) {
        return getChart().getGraphById(id);
    }

    @Override
    public ValueAxis getValueAxisById(String id) {
        return getChart().getValueAxisById(id);
    }

    @Override
    public void hideGraph(AmGraph amGraph) {
        getChart().hideGraph(amGraph);
    }

    @Override
    public void hideGraphsBalloon(AmGraph amGraph) {
        getChart().hideGraphsBalloon(amGraph);
    }

    @Override
    public void highlightGraph(AmGraph amGraph) {
        getChart().highlightGraph(amGraph);
    }

    @Override
    public void removeGraph(AmGraph amGraph) {
        getChart().removeGraph(amGraph);
    }

    @Override
    public void removeValueAxis(ValueAxis valueAxis) {
        getChart().removeValueAxis(valueAxis);
    }

    @Override
    public void showGraph(AmGraph amGraph) {
        getChart().showGraph(amGraph);
    }

    @Override
    public void showGraphsBalloon(AmGraph amGraph) {
        getChart().showGraphsBalloon(amGraph);
    }

    @Override
    public void unhighlightGraph(AmGraph amGraph) {
        getChart().unhighlightGraph(amGraph);
    }

    @Override
    public abstract AmCoordinateChart getChart();
}
