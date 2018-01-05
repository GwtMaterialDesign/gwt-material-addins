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

import gwt.material.design.incubator.client.chart.amcharts.events.object.Listener;
import gwt.material.design.incubator.client.chart.amcharts.js.AmBalloon;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * Base class for {@link AmValueAxis} and {@link AmCategoryAxis}. It can not be instantiated explicitly.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AxisBase">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmAxisBase {

    @JsProperty
    public boolean autoGridCount;

    @JsProperty
    public int autoRotateAngle;

    @JsProperty
    public int autoRotateCount;

    @JsProperty
    public double axisAlpha;

    @JsProperty
    public String axisColor;

    @JsProperty
    public int axisThickness;

    @JsProperty
    public int axisX;

    @JsProperty
    public int axisY;

    @JsProperty
    public AmBalloon balloon;

    @JsProperty
    public boolean boldLabels;

    @JsProperty
    public boolean boldPeriodBeginning;

    @JsProperty
    public boolean centerLabelOnFullPeriod;

    @JsProperty
    public boolean centerLabels;

    @JsProperty
    public boolean centerRotatedLabels;

    @JsProperty
    public String color;

    @JsProperty
    public int dashLength;

    @JsProperty
    public Object[] dateFormats;

    @JsProperty
    public double fillAlpha;

    @JsProperty
    public String fillColor;

    @JsProperty
    public int firstDayOfWeek;

    @JsProperty
    public int fontSize;

    @JsProperty
    public double gridAlpha;

    @JsProperty
    public String gridColor;

    @JsProperty
    public int gridCount;

    @JsProperty
    public int gridThickness;

    @JsProperty
    public AmGuide[] guides;

    @JsProperty
    public boolean ignoreAxisWidth;

    @JsProperty
    public boolean inside;

    @JsProperty
    public int labelFrequency;

    @JsProperty
    public int labelOffset;

    @JsProperty
    public int labelRotation;

    @JsProperty
    public boolean labelsEnabled;

    @JsProperty
    public Listener[] listeners;

    @JsProperty
    public boolean markPeriodChange;

    @JsProperty
    public int minHorizontalGap;

    @JsProperty
    public double minorGridAlpha;

    @JsProperty
    public boolean minorGridEnabled;

    @JsProperty
    public int minorTickLength;

    @JsProperty
    public int minVerticalGap;

    @JsProperty
    public int offset;

    @JsProperty
    public String position;

    @JsProperty
    public boolean showFirstLabel;

    @JsProperty
    public boolean showLastLabel;

    @JsProperty
    public int tickLength;

    @JsProperty
    public String title;

    @JsProperty
    public boolean titleBold;

    @JsProperty
    public String titleColor;

    @JsProperty
    public int titleFontSize;

    @JsProperty
    public int titleRotation;

    @JsMethod
    public native void addGuide(AmGuide guide);

    @JsMethod
    public native void removeGuide(AmGuide guide);
}
