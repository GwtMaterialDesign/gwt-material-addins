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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * GraphDataItem holds all the information about the graph's data item. When working with a chart, you do not create
 * GraphDataItem objects or change it's properties directly. GraphDataItem is passed to you by events when user interacts
 * with data item on the chart. The list of properties below will help you to extract data item's value/coordinate/etc.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GraphDataItem">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class GraphDataItem {

    @JsProperty
    private double alpha;

    @JsProperty
    private String bullet;

    @JsProperty
    private int bulletSize;

    @JsProperty
    private String category;

    @JsProperty
    private String color;

    @JsProperty
    private String customBullet;

    @JsProperty
    private Object dataContext;

    @JsProperty
    private String description;

    @JsProperty
    private String[] fillColors;

    @JsProperty
    private Object percents;

    @JsProperty
    private SerialDataItem serialDataItem;

    @JsProperty
    private String url;

    @JsProperty
    private Object values;

    @JsProperty
    private int x;

    @JsProperty
    private int y;

    /**
     * Opacity of the data item.
     */
    @JsOverlay
    public final void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    /**
     * Bullet type.
     */
    @JsOverlay
    public final void setBullet(String bullet) {
        this.bullet = bullet;
    }

    /**
     * Bullet size.
     */
    @JsOverlay
    public final void setBulletSize(int bulletSize) {
        this.bulletSize = bulletSize;
    }

    /**
     * Category value.
     */
    @JsOverlay
    public final void setCategory(String category) {
        this.category = category;
    }

    /**
     * Color of the data item.
     */
    @JsOverlay
    public final void setColor(String color) {
        this.color = color;
    }

    /**
     * Custom bullet (path to file name).
     */
    @JsOverlay
    public final void setCustomBullet(String customBullet) {
        this.customBullet = customBullet;
    }

    /**
     * Original object from data provider.
     */
    @JsOverlay
    public final void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }

    /**
     * Description.
     */
    @JsOverlay
    public final void setDescription(String description) {
        this.description = description;
    }

    /**
     * Array of colors of the data item, used by column and candlestick chart only.
     */
    @JsOverlay
    public final void setFillColors(String[] fillColors) {
        this.fillColors = fillColors;
    }

    /**
     * Object which holds percents when recalculateToPercents is set to true.
     */
    @JsOverlay
    public final void setPercents(Object percents) {
        this.percents = percents;
    }

    /**
     * {@link SerialDataItem} of this graphDataItem
     */
    @JsOverlay
    public final void setSerialDataItem(SerialDataItem serialDataItem) {
        this.serialDataItem = serialDataItem;
    }

    /**
     * url
     */
    @JsOverlay
    public final void setUrl(String url) {
        this.url = url;
    }

    /**
     * Object which holds values of the data item (value, open, close, low, high).
     */
    @JsOverlay
    public final void setValues(Object values) {
        this.values = values;
    }

    /**
     * x coordinate of the data item.
     */
    @JsOverlay
    public final void setX(int x) {
        this.x = x;
    }

    /**
     * y coordinate of the data item.
     */
    @JsOverlay
    public final void setY(int y) {
        this.y = y;
    }
}
