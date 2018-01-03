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
 * Extension for {@link AmSlicedChart} to create funnel/pyramid charts.
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmFunnelChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmFunnelChart extends AmSlicedChart {

    /**
     * The angle of the 3D part of the chart. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    @JsProperty
    public int angle;

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used. Default to "[[title]]: [[value]]\n[[description]]"
     */
    @JsProperty
    public String balloonText;

    /**
     * Width of a base (first slice) of a chart. "100%" means it will occupy all available space.
     */
    @JsProperty
    public int baseWidth;

    /**
     * The depth of funnel/pyramid. Set angle to >0 value in order this to work. Note, neckHeight/neckWidth will
     * become 0 if you set these properties to bigger than 0 values. Default to 0
     */
    @JsProperty
    public int depth3D;

    /**
     * Specifies where labels should be placed. Allowed values are left / center / right. If you set left or right,
     * you should increase left or right margin in order labels to be visible. Default to "center"
     */
    @JsProperty
    public String labelPosition;

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider.
     */
    @JsProperty
    public String labelText;

    /**
     * Height of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    @JsProperty
    public int neckHeight;

    /**
     * Width of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    @JsProperty
    public int neckWidth;

    /**
     * Specifies the distance by which slice should be pulled when user clicks on it.
     */
    @JsProperty
    public int pullDistance;

    /**
     * If rotate is set to true, the funnel will be rotated and will became a pyramid.
     */
    @JsProperty
    public boolean rotate;

    /**
     * Initial x coordinate of slices. They will animate to the final x position from this one.
     */
    @JsProperty
    public int startX;

    /**
     * Initial y coordinate of slices. They will animate to the final y position from this one.
     */
    @JsProperty
    public int startY;

    /**
     * By default, the height of a slice represents it's value. However you might want the area of a slice to represent
     * value - set this property to "area" then.
     */
    @JsProperty
    public String valueRepresents;
}
