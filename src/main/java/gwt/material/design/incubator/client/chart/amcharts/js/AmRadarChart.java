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
package gwt.material.design.incubator.client.chart.amcharts.js;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Extension for {@link AmCoordinateChart} to create radar/polar charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRadarChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmRadarChart extends AmCoordinateChart {

    /**
     * Field in your data provider containing categories.
     */
    @JsProperty
    public String categoryField;

    /**
     * Bottom margin of the chart. Default to 0
     */
    @JsProperty
    public int marginBottom;

    /**
     * Left margin of the chart. Default to 0
     */
    @JsProperty
    public int marginLeft;

    /**
     * Right margin of the chart. Default to 0
     */
    @JsProperty
    public int marginRight;

    /**
     * Top margin of the chart. Default to 0
     */
    @JsProperty
    public int marginTop;

    /**
     * Radius of a radar. Default to 35%
     */
    @JsProperty
    public Object radius;

}
