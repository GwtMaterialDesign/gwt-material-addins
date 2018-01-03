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

import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeArrow;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeAxis;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Extension for {@link AmChart} to create gauge charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmAngularGauge">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmAngularGauge extends AmChart {

    /**
     * Uses the whole space of the canvas to draw the gauge. Default to true
     */
    @JsProperty
    public boolean adjustSize;

    /**
     * Array of arrows.
     */
    @JsProperty
    public GaugeArrow[] arrows;

    /**
     * Array of axes.
     */
    @JsProperty
    public GaugeAxis axes;

    /**
     * In case you use gauge to create a clock, set this to true. Default to false
     */
    @JsProperty
    public boolean clockWiseOnly;

    /**
     * Gauge face opacity. Default to 0
     */
    @JsProperty
    public double faceAlpha;

    /**
     * Gauge face opacity. Default to 0
     */
    @JsProperty
    public double faceBorderAlpha;

    /**
     * Gauge face border color. Default to #555555
     */
    @JsProperty
    public String faceBorderColor;

    /**
     * Gauge face border width. Default to 1
     */
    @JsProperty
    public int faceBorderWidth;

    /**
     * Gauge face color, requires faceAlpha > 0. Default to #FAFAFA
     */
    @JsProperty
    public String faceColor;

    /**
     * Gauge face image-pattern.
     * Example: {"url":"../amcharts/patterns/black/pattern1.png", "width":4, "height":4}
     */
    @JsProperty
    public Object facePattern;

    /**
     * Gauge's horizontal position in pixel, origin is the center. Centered by default.
     */
    @JsProperty
    public int gaugeX;

    /**
     * Gauge's vertical position in pixel, origin is the center. Centered by default.
     */
    @JsProperty
    public int gaugeY;

    /**
     * Bottom spacing between chart and container. Default to 10
     */
    @JsProperty
    public int marginBottom;

    /**
     * Left-hand spacing between chart and container. Default to 10
     */
    @JsProperty
    public int marginLeft;

    /**
     * Right-hand spacing between chart and container. Default to 10
     */
    @JsProperty
    public int marginRight;

    /**
     * Top spacing between chart and container. Default to 10
     */
    @JsProperty
    public int marginTop;

    /**
     * Minimum radius of a gauge. Default to 10
     */
    @JsProperty
    public int minRadius;

    /**
     * Duration of arrow animation. Default to 1
     */
    @JsProperty
    public int startDuration;

    /**
     * Transition effect of the arrows, possible effects: easeOutSine, easeInSine, elastic, bounce. Default to "easeInSine"
     */
    @JsProperty
    public String startEffect;

    /**
     * Adds arrow to the chart.
     */
    @JsMethod
    public native void addArrow(GaugeArrow gaugeArrow);

    /**
     * Adds arrow to the chart.
     */
    @JsMethod
    public native void addAxis(GaugeAxis gaugeAxis);

    /**
     * Removes arrow from the chart.
     */
    @JsMethod
    public native void removeArrow(GaugeArrow gaugeArrow);

    /**
     * Removes axis from the chart.
     */
    @JsMethod
    public native void removeAxis(GaugeAxis gaugeAxis);
}
