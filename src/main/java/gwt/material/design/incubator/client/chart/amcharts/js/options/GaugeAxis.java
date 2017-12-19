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

import gwt.material.design.incubator.client.chart.amcharts.js.AmChart;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

//@formatter:off

/**
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GaugeAxis {

    @JsProperty
    private double axisAlpha;

    @JsProperty
    private String axisColor;

    @JsProperty
    private int axisThickness;

    @JsProperty
    private double bandAlpha;

    @JsProperty
    private int[] bandGradientRatio;

    @JsProperty
    private double bandOutlineAlpha;

    @JsProperty
    private String bandOutlineColor;

    @JsProperty
    private int bandOutlineThickness;

    @JsProperty
    private GaugeBand[] bands;

    @JsProperty
    private String bottomText;

    @JsProperty
    private boolean bottomTextBold;

    @JsProperty
    private String bottomTextColor;

    @JsProperty
    private int bottomTextFontSize;

    @JsProperty
    private int bottomTextYOffset;

    @JsProperty
    private Object centerX;

    @JsProperty
    private Object centerY;

    @JsProperty
    private String color;

    @JsProperty
    private int endAngle;

    @JsProperty
    private int endValue;

    @JsProperty
    private int fontSize;

    @JsProperty
    private int gridCount;

    @JsProperty
    private boolean gridInside;

    @JsProperty
    private int id;

    @JsProperty
    private boolean inside;

    @JsProperty
    private int labelFrequency;

    @JsProperty
    private Functions.Func labelFunction;

    @JsProperty
    private int labelOffset;

    @JsProperty
    private boolean labelsEnabled;

    @JsProperty
    private Object[] listeners;

    @JsProperty
    private int minorTickInterval;

    @JsProperty
    private int minorTickLength;

    @JsProperty
    private Object radius;

    @JsProperty
    private boolean showFirstLabel;

    @JsProperty
    private boolean showLastLabel;

    @JsProperty
    private int startAngle;

    @JsProperty
    private int startValue;

    @JsProperty
    private double tickAlpha;

    @JsProperty
    private String tickColor;

    @JsProperty
    private int tickLength;

    @JsProperty
    private int tickThickness;

    @JsProperty
    private String topText;

    @JsProperty
    private boolean topTextBold;

    @JsProperty
    private String topTextColor;

    @JsProperty
    private int topTextFontSize;

    @JsProperty
    private int topTextYOffset;

    @JsProperty
    private String unit;

    @JsProperty
    private String unitPosition;

    @JsProperty
    private boolean usePrefixes;

    @JsProperty
    private int valueInterval;

    @JsOverlay
    public final void setAxisAlpha(double axisAlpha) {
        this.axisAlpha = axisAlpha;
    }

    @JsOverlay
    public final void setAxisColor(String axisColor) {
        this.axisColor = axisColor;
    }

    @JsOverlay
    public final void setAxisThickness(int axisThickness) {
        this.axisThickness = axisThickness;
    }

    @JsOverlay
    public final void setBandAlpha(double bandAlpha) {
        this.bandAlpha = bandAlpha;
    }

    @JsOverlay
    public final void setBandGradientRatio(int[] bandGradientRatio) {
        this.bandGradientRatio = bandGradientRatio;
    }

    @JsOverlay
    public final void setBandOutlineAlpha(double bandOutlineAlpha) {
        this.bandOutlineAlpha = bandOutlineAlpha;
    }

    @JsOverlay
    public final void setBandOutlineColor(String bandOutlineColor) {
        this.bandOutlineColor = bandOutlineColor;
    }

    @JsOverlay
    public final void setBandOutlineThickness(int bandOutlineThickness) {
        this.bandOutlineThickness = bandOutlineThickness;
    }

    @JsOverlay
    public final void setBands(GaugeBand[] bands) {
        this.bands = bands;
    }

    @JsOverlay
    public final void setBottomTextBold(boolean bottomTextBold) {
        this.bottomTextBold = bottomTextBold;
    }

    @JsOverlay
    public final void setBottomTextColor(String bottomTextColor) {
        this.bottomTextColor = bottomTextColor;
    }

    @JsOverlay
    public final void setBottomTextFontSize(int bottomTextFontSize) {
        this.bottomTextFontSize = bottomTextFontSize;
    }

    @JsOverlay
    public final void setBottomTextYOffset(int bottomTextYOffset) {
        this.bottomTextYOffset = bottomTextYOffset;
    }

    @JsOverlay
    public final void setCenterX(Object centerX) {
        this.centerX = centerX;
    }

    @JsOverlay
    public final void setCenterY(Object centerY) {
        this.centerY = centerY;
    }

    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    @JsOverlay
    public final void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    @JsOverlay
    public final void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    @JsOverlay
    public final void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @JsOverlay
    public final void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    @JsOverlay
    public final void setGridInside(boolean gridInside) {
        this.gridInside = gridInside;
    }

    @JsOverlay
    public final void setId(int id) {
        this.id = id;
    }

    @JsOverlay
    public final void setInside(boolean inside) {
        this.inside = inside;
    }

    @JsOverlay
    public final void setLabelFrequency(int labelFrequency) {
        this.labelFrequency = labelFrequency;
    }

    @JsOverlay
    public final void setLabelFunction(Functions.Func labelFunction) {
        this.labelFunction = labelFunction;
    }

    @JsOverlay
    public final void setLabelOffset(int labelOffset) {
        this.labelOffset = labelOffset;
    }

    @JsOverlay
    public final void setLabelsEnabled(boolean labelsEnabled) {
        this.labelsEnabled = labelsEnabled;
    }

    @JsOverlay
    public final void setListeners(Object[] listeners) {
        this.listeners = listeners;
    }

    @JsOverlay
    public final void setMinorTickInterval(int minorTickInterval) {
        this.minorTickInterval = minorTickInterval;
    }

    @JsOverlay
    public final void setMinorTickLength(int minorTickLength) {
        this.minorTickLength = minorTickLength;
    }

    @JsOverlay
    public final void setRadius(Object radius) {
        this.radius = radius;
    }

    @JsOverlay
    public final void setShowFirstLabel(boolean showFirstLabel) {
        this.showFirstLabel = showFirstLabel;
    }

    @JsOverlay
    public final void setShowLastLabel(boolean showLastLabel) {
        this.showLastLabel = showLastLabel;
    }

    @JsOverlay
    public final void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    @JsOverlay
    public final void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    @JsOverlay
    public final void setTickAlpha(double tickAlpha) {
        this.tickAlpha = tickAlpha;
    }

    @JsOverlay
    public final void setTickColor(String tickColor) {
        this.tickColor = tickColor;
    }

    @JsOverlay
    public final void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    @JsOverlay
    public final void setTickThickness(int tickThickness) {
        this.tickThickness = tickThickness;
    }

    @JsOverlay
    public final void setTopTextBold(boolean topTextBold) {
        this.topTextBold = topTextBold;
    }

    @JsOverlay
    public final void setTopTextColor(String topTextColor) {
        this.topTextColor = topTextColor;
    }

    @JsOverlay
    public final void setTopTextFontSize(int topTextFontSize) {
        this.topTextFontSize = topTextFontSize;
    }

    @JsOverlay
    public final void setTopTextYOffset(int topTextYOffset) {
        this.topTextYOffset = topTextYOffset;
    }

    @JsOverlay
    public final void setUnit(String unit) {
        this.unit = unit;
    }

    @JsOverlay
    public final void setUnitPosition(String unitPosition) {
        this.unitPosition = unitPosition;
    }

    @JsOverlay
    public final void setUsePrefixes(boolean usePrefixes) {
        this.usePrefixes = usePrefixes;
    }

    @JsOverlay
    public final void setValueInterval(int valueInterval) {
        this.valueInterval = valueInterval;
    }

    @JsMethod
    public native void addListener(String type, Functions.Func handler);

    @JsMethod
    public native void removeListener(AmChart chart, String type, Functions.Func handler);

    @JsMethod
    public native void setBottomText(String text);

    @JsMethod
    public native void setTopText(String text);

    @JsMethod
    public native int value2angle(int value);

    // TODO Events
}
