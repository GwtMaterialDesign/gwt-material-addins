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
package gwt.material.design.incubator.client.chart.chartjs.js.datasets;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ScatterDataSets extends ChartDataSets {

    @JsProperty
    public String label;

    @JsProperty
    public String xAxisID;

    @JsProperty
    public String yAxisID;

    @JsProperty
    public String backgroundColor;

    @JsProperty
    public String borderColor;

    @JsProperty
    public int borderWidth;

    @JsProperty
    public int[] borderDash;

    @JsProperty
    public int borderDashOffset;

    @JsProperty
    public String borderCapStyle;

    @JsProperty
    public String borderJoinStyle;

    @JsProperty
    public String cubicInterpolationMode;

    @JsProperty
    public String fill;

    @JsProperty
    public int lineTension;

    @JsProperty
    public String pointBackgroundColor;

    @JsProperty
    public String pointBorderColor;

    @JsProperty
    public int pointHoverBorderWidth;

    @JsProperty
    public int pointHoverRadius;

    @JsProperty
    public boolean showLine;

    @JsProperty
    public boolean spanGaps;

    @JsProperty
    public String steppedLine;

    @JsProperty
    public Object[] data;
}
