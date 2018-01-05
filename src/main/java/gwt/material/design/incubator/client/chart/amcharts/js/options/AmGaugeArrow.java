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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

//@formatter:off

/**
 * JSInterop util for {@link gwt.material.design.incubator.client.chart.amcharts.options.GaugeArrow}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GaugeArrow">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmGaugeArrow {

    @JsProperty
    public double alpha;

    @JsProperty
    public AmGaugeAxis axis;

    @JsProperty
    public int borderAlpha;

    @JsProperty
    public boolean clockWiseOnly;

    @JsProperty
    public String color;

    @JsProperty
    public String id;

    @JsProperty
    public Object innerRadius;

    @JsProperty
    public int nailAlpha;

    @JsProperty
    public int nailBorderAlpha;

    @JsProperty
    public int nailBorderThickness;

    @JsProperty
    public int nailRadius;

    @JsProperty
    public Object radius;

    @JsProperty
    public int startWidth;

    @JsProperty
    public int value;

    @JsMethod
    public native void setValue(int value);
}
