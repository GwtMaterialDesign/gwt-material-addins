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
 * Creates a trendline for {@link gwt.material.design.incubator.client.chart.amcharts.SerialChart} and
 * {@link gwt.material.design.incubator.client.chart.amcharts.XyChart} charts which indicates the trend of your data
 * or covers some different purposes. Multiple can be assigned.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/TrendLine">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class TrendLine {

    @JsProperty
    private String balloonText;

    @JsProperty
    private int dashLength;

    @JsProperty
    private String finalCategory;

    @JsProperty
    private Date finalDate;

    @JsProperty
    private Image finalImage;

    @JsProperty
    private int finalValue;

    @JsProperty
    private int finalXValue;

    @JsProperty
    private String id;

    @JsProperty
    private String initialCategory;

    @JsProperty
    private Date initialDate;

    @JsProperty
    private Image initialImage;

    @JsProperty
    private int initialValue;

    @JsProperty
    private int initialXValue;

    @JsProperty
    private boolean isProtected;

    @JsProperty
    private double lineAlpha;

    @JsProperty
    private String lineColor;

    @JsProperty
    private int lineThickness;

    @JsProperty
    private ValueAxis valueAxis;

    @JsProperty
    private ValueAxis valueAxisX;

    /**
     * When set, enables displaying a roll-over balloon.
     */
    @JsOverlay
    public final void setBalloonText(String balloonText) {
        this.balloonText = balloonText;
    }

    /**
     * Dash length. Default to 0
     */
    @JsOverlay
    public final void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    /**
     * String, equal to category value to which trend line should be drawn. It should be used if chart doesn't parse dates.
     */
    @JsOverlay
    public final void setFinalCategory(String finalCategory) {
        this.finalCategory = finalCategory;
    }

    /**
     * Date to which trend line should be drawn. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */
    @JsOverlay
    public final void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * Allows to add an image to the end of a trend line.
     */
    @JsOverlay
    public final void setFinalImage(Image finalImage) {
        this.finalImage = finalImage;
    }

    /**
     * Value at which trend line should end.
     */
    @JsOverlay
    public final void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }

    /**
     * Used by XY chart only. X value at which trend line should end.
     */
    @JsOverlay
    public final void setFinalXValue(int finalXValue) {
        this.finalXValue = finalXValue;
    }

    /**
     * Unique id of a Trend line. You don't need to set it, unless you want to.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    /**
     * String, equal to category value from which trend line should start. It should be used if chart doesn't parse dates.
     */
    @JsOverlay
    public final void setInitialCategory(String initialCategory) {
        this.initialCategory = initialCategory;
    }

    /**
     * Date from which trend line should start. It can be date string (using the same date format as chart.dataDateFormat)
     * or date object.
     */
    @JsOverlay
    public final void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * Allows to add an image to the beginning of a trend line.
     */
    @JsOverlay
    public final void setInitialImage(Image initialImage) {
        this.initialImage = initialImage;
    }

    /**
     * Value from which trend line should start.
     */
    @JsOverlay
    public final void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    /**
     * Used by XY chart only. X value from which trend line should start.
     */
    @JsOverlay
    public final void setInitialXValue(int initialXValue) {
        this.initialXValue = initialXValue;
    }

    /**
     * Used by Stock chart. If this property is set to true, this trend line won't be removed when clicked on eraser tool.
     * Default to false
     */
    @JsOverlay
    public final void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    /**
     * Line opacity. Default to 1
     */
    @JsOverlay
    public final void setLineAlpha(double lineAlpha) {
        this.lineAlpha = lineAlpha;
    }

    /**
     * Line color. Default to #00CC00
     */
    @JsOverlay
    public final void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Line thickness. Default to 1
     */
    @JsOverlay
    public final void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    /**
     * Value axis of the trend line. Will use first value axis of the chart if not set any. You can use a reference to
     * the value axis object or id of value axis.
     */
    @JsOverlay
    public final void setValueAxis(ValueAxis valueAxis) {
        this.valueAxis = valueAxis;
    }

    /**
     * Used by XY chart only. X axis of trend line. Will use first X axis of the chart if not set any. You can use a
     * reference to the value axis object or id of value axis.
     */
    @JsOverlay
    public final void setValueAxisX(ValueAxis valueAxisX) {
        this.valueAxisX = valueAxisX;
    }

    // TODO Events
}
