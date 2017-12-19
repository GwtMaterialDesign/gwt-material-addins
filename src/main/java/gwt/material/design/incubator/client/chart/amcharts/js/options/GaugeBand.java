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
package gwt.material.design.incubator.client.chart.amcharts.js.options;

import jsinterop.annotations.*;

//@formatter:off

/**
 * Creates a band for a specified value range on the {@link GaugeAxis}. Multiple bands can be assigned to a single
 * {@link GaugeAxis}.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeBand">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeBand {

    @JsProperty
    private double alpha;

    @JsProperty
    private String balloonText;

    @JsProperty
    private String color;

    @JsProperty
    private int endValue;

    @JsProperty
    private int[] gradientRatio;

    @JsProperty
    private String id;

    @JsProperty
    private Object innerRadius;

    @JsProperty
    private Object radius;

    @JsProperty
    private int startValue;

    @JsProperty
    private String url;

    /**
     * Opacity of band fill. Will use axis.bandAlpha if not set any.
     */
    @JsOverlay
    public final void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * When rolled-over, band will display balloon if you set some text for this property.
     */
    @JsOverlay
    public final void setBalloonText(String balloonText) {
        this.balloonText = balloonText;
    }

    /**
     * Color of a band.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Example: [-0.2, 0, -0.2]. Will make bands to be filled with color gradients. Negative value means the color will
     * be darker than the original, and positive number means the color will be lighter.
     */
    @JsOverlay
    public final void setGradientRatio(int[] gradientRatio) {
        this.gradientRatio = gradientRatio;
    }

    /**
     * Unique id of a band.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * Inner radius of a band. If not set any, the band will end with the end of minor ticks. Set 0 if you want the band
     * to be drawn to the axis center.
     */
    @JsOverlay
    public final void setInnerRadius(Object innerRadius) {
        this.innerRadius = innerRadius;
    }

    /**
     * Band radius. If not set any, the band will start with the axis outline.
     */
    @JsOverlay
    public final void setRadius(Object radius) {
        this.radius = radius;
    }

    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    /**
     * Start value of a fill.
     */
    @JsMethod
    public native void setStartValue(int value);

    /**
     * End value of a fill.
     */
    @JsMethod
    public native void setEndValue(int value);
}
