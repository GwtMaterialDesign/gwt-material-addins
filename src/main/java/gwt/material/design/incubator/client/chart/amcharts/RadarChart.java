/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmRadarChart;

//@formatter:off

/**
 * Extension for {@link CoordinateChart} to create radar/polar charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRadarChart">Official Documentation</a>
 */
//@formatter:on
public class RadarChart extends CoordinateChart {

    protected AmRadarChart chart;

    public RadarChart() {
        super(ChartType.RADAR);
    }

    /**
     * Field in your data provider containing categories.
     */
    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }

    /**
     * Bottom margin of the chart. Default to 0
     */
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    /**
     * Left margin of the chart. Default to 0
     */
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    /**
     * Right margin of the chart. Default to 0
     */
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    /**
     * Top margin of the chart. Default to 0
     */
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    /**
     * Radius of a radar. Default to 35%
     */
    public void setRadius(Object radius) {
        getChart().radius = radius;
    }

    public AmRadarChart getChart() {
        if (chart == null) {
            chart = new AmRadarChart();
        }
        return chart;
    }
}
