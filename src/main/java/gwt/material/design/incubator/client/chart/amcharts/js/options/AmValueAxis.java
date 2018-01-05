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

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

//@formatter:off

/**
 * JSInterop util for {@link gwt.material.design.incubator.client.chart.amcharts.options.ValueAxis}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/ValueAxis">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmValueAxis extends AmAxisBase {

    @JsProperty
    public boolean autoWrap;

    @JsProperty
    public int axisFrequency;

    @JsProperty
    public int axisTitleOffset;

    @JsProperty
    public Object balloonTextFunction;

    @JsProperty
    public int baseCoord;

    @JsProperty
    public int baseValue;

    @JsProperty
    public String duration;

    @JsProperty
    public Object durationUnits;

    @JsProperty
    public String gridType;

    @JsProperty
    public String id;

    @JsProperty
    public boolean includeAllValues;

    @JsProperty
    public boolean includeGuidesInMinMax;

    @JsProperty
    public boolean includeHidden;

    @JsProperty
    public boolean integersOnly;

    @JsProperty
    public Functions.Func labelFunction;

    @JsProperty
    public boolean logarithmic;

    @JsProperty
    public int max;

    @JsProperty
    public int maximum;

    @JsProperty
    public Date maximumDate;

    @JsProperty
    public int min;

    @JsProperty
    public int minimum;

    @JsProperty
    public Date minimumDate;

    @JsProperty
    public int minMaxMultiplier;

    @JsProperty
    public String minPeriod;

    @JsProperty
    public String pointPosition;

    @JsProperty
    public int precision;

    @JsProperty
    public boolean radarCategoriesEnabled;

    @JsProperty
    public boolean recalculateToPercents;

    @JsProperty
    public boolean reversed;

    @JsProperty
    public String stackType;

    @JsProperty
    public int step;

    @JsProperty
    public boolean strictMinMax;

    @JsProperty
    public int synchronizationMultiplier;

    @JsProperty
    public AmValueAxis synchronizeWith;

    @JsProperty
    public String totalText;

    @JsProperty
    public String totalTextColor;

    @JsProperty
    public int totalTextOffset;

    @JsProperty
    public int treatZeroAs;

    @JsProperty
    public String type;

    @JsProperty
    public String unit;

    @JsProperty
    public String unitPosition;

    @JsProperty
    public boolean usePrefixes;

    @JsProperty
    public boolean useScientificNotation;

    @JsProperty
    public double zeroGridAlpha;

    /**
     * One value axis can be synchronized with another value axis. You should set synchronizationMultiplyer in order
     * for this to work.
     */
    @JsMethod
    public native void synchronizeWithAxis(AmValueAxis axis);

    /**
     * Adds event listener to the object.
     */
    @JsMethod
    public native void addListener(String type, Functions.Func1<Object> handler);

    /**
     * Returns value of the coordinate.
     */
    @JsMethod
    public native void coordinateToValue(int x, int y);

    /**
     * Returns coordinate of the value in pixels.
     */
    @JsMethod
    public native int[] getCoordinate(int value);

    /**
     * Removes event listener from the object
     */
    @JsMethod
    public native void removeListener(Object object, String type, Functions.Func1<Object> handler);

    /**
     * Zooms out the value axis to full scale.
     */
    @JsMethod
    public native void zoomOut();

    /**
     * Zooms-in the axis to the provided values.
     */
    @JsMethod
    public native void zoomToValues(int startValue, int endValue);
}
