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
 * Slice is an item of AmPieChart's chartData Array and holds all the information about the slice. When working with a
 * pie chart, you do not create slices or change it's properties directly, instead you set array of data using dataProvider
 * property. Consider properties of a Slice read-only - change values in chart's data provider if you need to.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/Slice">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Slice {

    @JsProperty
    private double alpha;

    @JsProperty
    private String color;

    @JsProperty
    private Object dataContext;

    @JsProperty
    private String description;

    @JsProperty
    private boolean hidden;

    @JsProperty
    private int percents;

    @JsProperty
    private boolean pulled;

    @JsProperty
    private String title;

    @JsProperty
    private String url;

    @JsProperty
    private int value;

    @JsProperty
    private boolean visibleInLegend;

    /**
     * Opacity of a slice.
     */
    @JsOverlay
    public final void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Color of a slice.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Original object from data provider.
     */
    @JsOverlay
    public final void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }

    /**
     * Slice description.
     */
    @JsOverlay
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Specifies whether the slice is hidden
     */
    @JsOverlay
    public final void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Percent value of a slice.
     */
    @JsOverlay
    public final void setPercents(int percents) {
        this.percents = percents;
    }

    /**
     * Specifies whether the slice is pulled or not.
     */
    @JsOverlay
    public final void setPulled(boolean pulled) {
        this.pulled = pulled;
    }

    /**
     * Slice title
     */
    @JsOverlay
    public final void setTitle(String title) {
        this.title = title;
    }

    /**
     * Url of a slice
     */
    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    /**
     * Value of a slice
     */
    @JsOverlay
    public final void setValue(int value) {
        this.value = value;
    }

    /**
     * specifies whether this slice has a legend entry
     */
    @JsOverlay
    public final void setVisibleInLegend(boolean visibleInLegend) {
        this.visibleInLegend = visibleInLegend;
    }
}
