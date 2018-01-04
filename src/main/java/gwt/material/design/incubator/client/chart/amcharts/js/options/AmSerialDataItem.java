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

//@formatter:off

/**
 * AmSerialDataItem holds all the information about each series. When working with a chart, you do not create AmSerialDataItem
 * objects or change it's properties directly. Consider properties of a AmSerialDataItem read-only - change values in chart's
 * data provider if you need to. When serial chart parses dataProvider, it generates "chartData" array. Objects of this array
 * are AmSerialDataItem objects.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/SerialDataItem">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class AmSerialDataItem {

    @JsProperty
    private Object axes;

    @JsProperty
    private String category;

    @JsProperty
    private Object dataContext;

    @JsProperty
    private int time;

    @JsProperty
    private int x;

    /**
     * You can access each {@link AmGraphDataItem} using this object. The data structure is: graphDataItem =
     * serialDataItem.axes[axisId].graphs[graphId].
     */
    @JsOverlay
    public final void setAxes(Object axes) {
        this.axes = axes;
    }

    /**
     * Category value. String if parseDates is false, Date if true.
     */
    @JsOverlay
    public final void setCategory(String category) {
        this.category = category;
    }

    /**
     * Reference to original data object, from dataProvider.
     */
    @JsOverlay
    public final void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }

    /**
     * Time stamp of a series date. Available only if parseDates property of {@link AmCategoryAxis} is set to true.
     */
    @JsOverlay
    public final void setTime(int time) {
        this.time = time;
    }

    /**
     * Coordinate (horizontal or vertical, depends on chart's rotate property) of the series.
     */
    @JsOverlay
    public final void setX(int x) {
        this.x = x;
    }

    @JsOverlay
    public final Object getAxes() {
        return axes;
    }

    @JsOverlay
    public final String getCategory() {
        return category;
    }

    @JsOverlay
    public final Object getDataContext() {
        return dataContext;
    }

    @JsOverlay
    public final int getTime() {
        return time;
    }

    @JsOverlay
    public final int getX() {
        return x;
    }
}
