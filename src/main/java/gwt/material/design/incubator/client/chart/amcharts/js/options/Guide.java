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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

//@formatter:off

/**
 * Creates a horizontal/vertical guideline-/area for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart},
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} and
 * {@link gwt.material.design.incubator.client.chart.chartjs.RadarChart} charts, automatically
 * adapts it's settings from the axes if none has been specified.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/Guide">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Guide {

    @JsProperty
    private boolean above;

    @JsProperty
    private int angle;

    @JsProperty
    private String balloonColor;

    @JsProperty
    private String balloonText;

    @JsProperty
    private boolean boldLabel;

    @JsProperty
    private String category;

    @JsProperty
    private String color;

    @JsProperty
    private int dashLength;

    @JsProperty
    private Date date;

    @JsProperty
    private boolean expand;

    @JsProperty
    private double fillAlpha;

    @JsProperty
    private String fillColor;

    @JsProperty
    private int fontSize;

    @JsProperty
    private String id;

    @JsProperty
    private boolean inside;

    @JsProperty
    private String label;

    @JsProperty
    private int labelRotation;

    @JsProperty
    private double lineAlpha;

    @JsProperty
    private String lineColor;

    @JsProperty
    private int lineThickness;

    @JsProperty
    private String position;

    @JsProperty
    private int tickLength;

    @JsProperty
    private int toAngle;

    @JsProperty
    private String toCategory;

    @JsProperty
    private Date toDate;

    @JsProperty
    private int toValue;

    @JsProperty
    private int value;

    @JsProperty
    private ValueAxis valueAxis;

    @JsOverlay
    public final void setAbove(boolean above) {
        this.above = above;
    }

    @JsOverlay
    public final void setAngle(int angle) {
        this.angle = angle;
    }

    @JsOverlay
    public final void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    @JsOverlay
    public final void setBalloonText(String balloonText) {
        this.balloonText = balloonText;
    }

    @JsOverlay
    public final void setBoldLabel(boolean boldLabel) {
        this.boldLabel = boldLabel;
    }

    @JsOverlay
    public final void setCategory(String category) {
        this.category = category;
    }

    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    @JsOverlay
    public final void setDate(Date date) {
        this.date = date;
    }

    @JsOverlay
    public final void setExpand(boolean expand) {
        this.expand = expand;
    }

    @JsOverlay
    public final void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    @JsOverlay
    public final void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    @JsOverlay
    public final void setInside(boolean inside) {
        this.inside = inside;
    }

    @JsOverlay
    public final void setLabel(String label) {
        this.label = label;
    }

    @JsOverlay
    public final void setLabelRotation(int labelRotation) {
        this.labelRotation = labelRotation;
    }

    @JsOverlay
    public final void setLineAlpha(double lineAlpha) {
        this.lineAlpha = lineAlpha;
    }

    @JsOverlay
    public final void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    @JsOverlay
    public final void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    @JsOverlay
    public final void setPosition(String position) {
        this.position = position;
    }

    @JsOverlay
    public final void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    @JsOverlay
    public final void setToAngle(int toAngle) {
        this.toAngle = toAngle;
    }

    @JsOverlay
    public final void setToCategory(String toCategory) {
        this.toCategory = toCategory;
    }

    @JsOverlay
    public final void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @JsOverlay
    public final void setToValue(int toValue) {
        this.toValue = toValue;
    }

    @JsOverlay
    public final void setValue(int value) {
        this.value = value;
    }

    @JsOverlay
    public final void setValueAxis(ValueAxis valueAxis) {
        this.valueAxis = valueAxis;
    }
}
