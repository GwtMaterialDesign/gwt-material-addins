package gwt.material.design.incubator.client.chart.amcharts.js.options;

//@formatter:off

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

    /**
     * Opacity of the data item.
     */
    @JsProperty
    public double alpha;

    /**
     * Bullet type.
     */
    @JsProperty
    public String bullet;

    /**
     * Bullet size.
     */
    @JsProperty
    public int bulletSize;

    /**
     * Category value.
     */
    @JsProperty
    public String category;

    /**
     * Color of the data item.
     */
    @JsProperty
    public String color;

    /**
     * Custom bullet (path to file name).
     */
    @JsProperty
    public String customBullet;

    /**
     * Original object from data provider.
     */
    @JsProperty
    public Object dataContext;

    /**
     * Description.
     */
    @JsProperty
    public String description;

    /**
     * Array of colors of the data item, used by column and candlestick chart only.
     */
    @JsProperty
    public String[] fillColors;

    /**
     * Object which holds percents when recalculateToPercents is set to true.
     */
    @JsProperty
    public Object percents;

    /**
     * {@link SerialDataItem} of this graphDataItem
     */
    @JsProperty
    public SerialDataItem serialDataItem;

    /**
     * url
     */
    @JsProperty
    public String url;

    /**
     * Object which holds values of the data item (value, open, close, low, high).
     */
    @JsProperty
    public Object values;

    /**
     * x coordinate of the data item.
     */
    @JsProperty
    public int x;

    /**
     * y coordinate of the data item.
     */
    @JsProperty
    public int y;
}
