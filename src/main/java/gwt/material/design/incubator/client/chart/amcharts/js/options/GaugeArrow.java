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
 * Creates an arrow for AmAngularGauge charts, multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeArrow">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeArrow {

    @JsProperty
    private double alpha;

    @JsProperty
    private GaugeAxis axis;

    @JsProperty
    private int borderAlpha;

    @JsProperty
    private boolean clockWiseOnly;

    @JsProperty
    private String color;

    @JsProperty
    private String id;

    @JsProperty
    private Object innerRadius;

    @JsProperty
    private int nailAlpha;

    @JsProperty
    private int nailBorderAlpha;

    @JsProperty
    private int nailBorderThickness;

    @JsProperty
    private int nailRadius;

    @JsProperty
    private Object radius;

    @JsProperty
    private int startWidth;

    @JsProperty
    private int value;

    /**
     * Opacity of an arrow. Default to 1
     */
    @JsOverlay
    public final void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Axis of the arrow. You can use reference to the axis or id of the axis. If you don't set any axis, the first
     * axis of a chart will be used.
     */
    @JsOverlay
    public final void setAxis(GaugeAxis axis) {
        this.axis = axis;
    }

    /**
     * Opacity of arrow border. Default to 1
     */
    @JsOverlay
    public final void setBorderAlpha(int borderAlpha) {
        this.borderAlpha = borderAlpha;
    }

    /**
     * In case you need the arrow to rotate only clock-wise, set this property to true. Default to false
     */
    @JsOverlay
    public final void setClockWiseOnly(boolean clockWiseOnly) {
        this.clockWiseOnly = clockWiseOnly;
    }

    /**
     * Color of an arrow. Default to #000000
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Unique id of an arrow.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * Inner radius of an arrow. Default to 0
     */
    @JsOverlay
    public final void setInnerRadius(Object innerRadius) {
        this.innerRadius = innerRadius;
    }

    /**
     * Opacity of a nail, holding the arrow. Default to 1
     */
    @JsOverlay
    public final void setNailAlpha(int nailAlpha) {
        this.nailAlpha = nailAlpha;
    }

    /**
     * Opacity of nail border. Default to 0
     */
    @JsOverlay
    public final void setNailBorderAlpha(int nailBorderAlpha) {
        this.nailBorderAlpha = nailBorderAlpha;
    }

    /**
     * Thickness of nail border. Default to 1
     */
    @JsOverlay
    public final void setNailBorderThickness(int nailBorderThickness) {
        this.nailBorderThickness = nailBorderThickness;
    }

    /**
     * Radius of a nail, holding the arrow. Default to 8
     */
    @JsOverlay
    public final void setNailRadius(int nailRadius) {
        this.nailRadius = nailRadius;
    }

    /**
     * Radius of an arrow. Default to 90%
     */
    @JsOverlay
    public final void setRadius(Object radius) {
        this.radius = radius;
    }

    /**
     * Default to 8
     */
    @JsOverlay
    public final void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    /**
     * Value to which the arrow should point at.
     */
    @JsMethod
    public native void setValue(int value);

    @JsOverlay
    public final double getAlpha() {
        return alpha;
    }

    @JsOverlay
    public final GaugeAxis getAxis() {
        return axis;
    }

    @JsOverlay
    public final int getBorderAlpha() {
        return borderAlpha;
    }

    @JsOverlay
    public final boolean isClockWiseOnly() {
        return clockWiseOnly;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    @JsOverlay
    public final String getId() {
        return id;
    }

    @JsOverlay
    public final Object getInnerRadius() {
        return innerRadius;
    }

    @JsOverlay
    public final int getNailAlpha() {
        return nailAlpha;
    }

    @JsOverlay
    public final int getNailBorderAlpha() {
        return nailBorderAlpha;
    }

    @JsOverlay
    public final int getNailBorderThickness() {
        return nailBorderThickness;
    }

    @JsOverlay
    public final int getNailRadius() {
        return nailRadius;
    }

    @JsOverlay
    public final Object getRadius() {
        return radius;
    }

    @JsOverlay
    public final int getStartWidth() {
        return startWidth;
    }

    @JsOverlay
    public final int getValue() {
        return value;
    }
}
