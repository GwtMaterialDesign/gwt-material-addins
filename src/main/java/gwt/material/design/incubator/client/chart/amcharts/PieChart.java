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

import gwt.material.design.incubator.client.chart.amcharts.base.IPieChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmPieChart;
import gwt.material.design.jquery.client.api.Functions;

//@formatter:off

/**
 * Extension for {@link SliceChart} to create pie/donut charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmPieChart">Official Documentation</a>
 */
//@formatter:on
public class PieChart extends SliceChart implements IPieChart {

    protected AmPieChart chart;

    public PieChart() {
        super(ChartType.PIE);
    }

    @Override
    public void setAdjustPrecision(boolean adjustPrecision) {
        getChart().adjustPrecision = adjustPrecision;
    }

    @Override
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    @Override
    public void setBalloonFunction(Functions.Func balloonFunction) {
        getChart().balloonFunction = balloonFunction;
    }

    @Override
    public void setBalloonText(String balloonText) {
        getChart().balloonText = balloonText;
    }

    @Override
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    @Override
    public void setGradientType(String gradientType) {
        getChart().gradientType = gradientType;
    }

    @Override
    public void setInnerRadius(int innerRadius) {
        getChart().innerRadius = innerRadius;
    }

    @Override
    public void setLabelRadius(int labelRadius) {
        getChart().labelRadius = labelRadius;
    }

    @Override
    public void setLabelRadiusField(String labelRadiusField) {
        getChart().labelRadiusField = labelRadiusField;
    }

    @Override
    public void setLabelText(String labelText) {
        getChart().labelText = labelText;
    }

    @Override
    public void setMinRadius(int minRadius) {
        getChart().minRadius = minRadius;
    }

    @Override
    public void setPieX(Object pieX) {
        getChart().pieX = pieX;
    }

    @Override
    public void setPieY(Object pieY) {
        getChart().pieY = pieY;
    }

    @Override
    public void setPullOutRadius(Object pullOutRadius) {
        getChart().pullOutRadius = pullOutRadius;
    }

    @Override
    public void setRadius(Object radius) {
        getChart().radius = radius;
    }

    @Override
    public void setStartAngle(Object startAngle) {
        getChart().startAngle = startAngle;
    }

    @Override
    public void setStartRadius(Object startRadius) {
        getChart().startRadius = startRadius;
    }

    @Override
    public AmPieChart getChart() {
        if (chart == null) {
            chart = new AmPieChart();
        }
        return chart;
    }
}
