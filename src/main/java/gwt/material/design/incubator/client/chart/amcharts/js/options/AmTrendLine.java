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
public class AmTrendLine {

    @JsProperty
    public String balloonText;

    @JsProperty
    public int dashLength;

    @JsProperty
    public String finalCategory;

    @JsProperty
    public Date finalDate;

    @JsProperty
    public Image finalImage;

    @JsProperty
    public int finalValue;

    @JsProperty
    public int finalXValue;

    @JsProperty
    public String id;

    @JsProperty
    public String initialCategory;

    @JsProperty
    public Date initialDate;

    @JsProperty
    public Image initialImage;

    @JsProperty
    public int initialValue;

    @JsProperty
    public int initialXValue;

    @JsProperty
    public boolean isProtected;

    @JsProperty
    public double lineAlpha;

    @JsProperty
    public String lineColor;

    @JsProperty
    public int lineThickness;

    @JsProperty
    public AmValueAxis valueAxis;

    @JsProperty
    public AmValueAxis valueAxisX;
}
