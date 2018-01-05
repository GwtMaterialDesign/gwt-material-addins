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

//@formatter:off

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JSInterop util for {@link gwt.material.design.incubator.client.chart.amcharts.options.GraphDataItem}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GraphDataItem">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmGraphDataItem {

    @JsProperty
    public double alpha;

    @JsProperty
    public String bullet;

    @JsProperty
    public int bulletSize;

    @JsProperty
    public String category;

    @JsProperty
    public String color;

    @JsProperty
    public String customBullet;

    @JsProperty
    public Object dataContext;

    @JsProperty
    public String description;

    @JsProperty
    public String[] fillColors;

    @JsProperty
    public Object percents;

    @JsProperty
    public AmSerialDataItem serialDataItem;

    @JsProperty
    public String url;

    @JsProperty
    public Object values;

    @JsProperty
    public int x;

    @JsProperty
    public int y;
}
