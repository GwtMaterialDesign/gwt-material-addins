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
public class AmGuide {

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
    private AmValueAxis valueAxis;

    @JsOverlay
    public final boolean isAbove() {
        return above;
    }

    /**
     * If you set it to true, the guide will be displayed above the graphs. Default to false
     */
    @JsOverlay
    public final void setAbove(boolean above) {
        this.above = above;
    }

    @JsOverlay
    public final int getAngle() {
        return angle;
    }

    /**
     * Radar chart only. Specifies angle at which guide should start. Affects only fills, not lines.
     */
    @JsOverlay
    public final void setAngle(int angle) {
        this.angle = angle;
    }

    @JsOverlay
    public final String getBalloonColor() {
        return balloonColor;
    }

    /**
     * Baloon fill color.
     */
    @JsOverlay
    public final void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    @JsOverlay
    public final String getBalloonText() {
        return balloonText;
    }

    /**
     * The text which will be displayed if the user rolls-over the guide.
     */
    @JsOverlay
    public final void setBalloonText(String balloonText) {
        this.balloonText = balloonText;
    }

    @JsOverlay
    public final boolean isBoldLabel() {
        return boldLabel;
    }

    /**
     * Specifies if label should be bold or not. Default to false
     */
    @JsOverlay
    public final void setBoldLabel(boolean boldLabel) {
        this.boldLabel = boldLabel;
    }

    @JsOverlay
    public final String getCategory() {
        return category;
    }

    /**
     * Category of the guide (in case the guide is for category axis).
     */
    @JsOverlay
    public final void setCategory(String category) {
        this.category = category;
    }

    @JsOverlay
    public final String getColor() {
        return color;
    }

    /**
     * Color of a guide label.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final int getDashLength() {
        return dashLength;
    }

    /**
     * Dash length.
     */
    @JsOverlay
    public final void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    @JsOverlay
    public final Date getDate() {
        return date;
    }

    /**
     * Date of the guide (in case the guide is for category axis and parseDates is set to true).
     */
    @JsOverlay
    public final void setDate(Date date) {
        this.date = date;
    }

    @JsOverlay
    public final boolean isExpand() {
        return expand;
    }

    /**
     * Works if a guide is added to CategoryAxis and this axis is non-date-based. If you set it to true, the guide will
     * start (or be placed, if it's not a fill) on the beginning of the category cell and will end at the end of toCategory cell.
     * Default to false
     */
    @JsOverlay
    public final void setExpand(boolean expand) {
        this.expand = expand;
    }

    @JsOverlay
    public final double getFillAlpha() {
        return fillAlpha;
    }

    /**
     * Fill opacity. Value range is 0 - 1.
     */
    @JsOverlay
    public final void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    @JsOverlay
    public final String getFillColor() {
        return fillColor;
    }

    /**
     * Fill color.
     */
    @JsOverlay
    public final void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @JsOverlay
    public final int getFontSize() {
        return fontSize;
    }

    /**
     * Font size of guide label.
     */
    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final String getId() {
        return id;
    }

    /**
     * Unique id of a AmGuide. You don't need to set it, unless you want to.
     */
    @JsOverlay
    public final void setId(String id) {
        this.id = id;
    }

    @JsOverlay
    public final boolean isInside() {
        return inside;
    }

    /**
     * Specifies whether label should be placed inside or outside plot area.
     */
    @JsOverlay
    public final void setInside(boolean inside) {
        this.inside = inside;
    }

    @JsOverlay
    public final String getLabel() {
        return label;
    }

    /**
     * The label which will be displayed near the guide.
     */
    @JsOverlay
    public final void setLabel(String label) {
        this.label = label;
    }

    @JsOverlay
    public final int getLabelRotation() {
        return labelRotation;
    }

    /**
     * Rotation angle of a guide label.
     */
    @JsOverlay
    public final void setLabelRotation(int labelRotation) {
        this.labelRotation = labelRotation;
    }

    @JsOverlay
    public final double getLineAlpha() {
        return lineAlpha;
    }

    /**
     * Line opacity.
     */
    @JsOverlay
    public final void setLineAlpha(double lineAlpha) {
        this.lineAlpha = lineAlpha;
    }

    @JsOverlay
    public final String getLineColor() {
        return lineColor;
    }

    /**
     * Line color.
     */
    @JsOverlay
    public final void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    @JsOverlay
    public final int getLineThickness() {
        return lineThickness;
    }

    /**
     * Line thickness.
     */
    @JsOverlay
    public final void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    @JsOverlay
    public final String getPosition() {
        return position;
    }

    /**
     * Position of guide label. Possible values are "left" or "right" for horizontal axis and "top" or "bottom" for vertical axis.
     */
    @JsOverlay
    public final void setPosition(String position) {
        this.position = position;
    }

    @JsOverlay
    public final int getTickLength() {
        return tickLength;
    }

    /**
     * Tick length.
     */
    @JsOverlay
    public final void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    @JsOverlay
    public final int getToAngle() {
        return toAngle;
    }

    /**
     * Radar chart only. Specifies angle at which guide should end. Affects only fills, not lines.
     */
    @JsOverlay
    public final void setToAngle(int toAngle) {
        this.toAngle = toAngle;
    }

    @JsOverlay
    public final String getToCategory() {
        return toCategory;
    }

    /**
     * "To" category of the guide (in case the guide is for category axis).
     */
    @JsOverlay
    public final void setToCategory(String toCategory) {
        this.toCategory = toCategory;
    }

    @JsOverlay
    public final Date getToDate() {
        return toDate;
    }

    /**
     * "To" date of the guide (in case the guide is for category axis and parseDates is set to true) If you have both
     * date and toDate, the space between these two dates can be filled with color.
     */
    @JsOverlay
    public final void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @JsOverlay
    public final int getToValue() {
        return toValue;
    }

    /**
     * "To" value of the guide (in case the guide is for value axis).
     */
    @JsOverlay
    public final void setToValue(int toValue) {
        this.toValue = toValue;
    }

    @JsOverlay
    public final int getValue() {
        return value;
    }

    /**
     * Value of the guide (in case the guide is for value axis).
     */
    @JsOverlay
    public final void setValue(int value) {
        this.value = value;
    }

    @JsOverlay
    public final AmValueAxis getValueAxis() {
        return valueAxis;
    }

    /**
     * Value axis of a guide. As you can add guides directly to the chart, you might need to specify which which value
     * axis should be used.
     */
    @JsOverlay
    public final void setValueAxis(AmValueAxis valueAxis) {
        this.valueAxis = valueAxis;
    }
}
