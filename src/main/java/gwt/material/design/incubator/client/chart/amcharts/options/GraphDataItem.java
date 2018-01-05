package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGraphDataItem;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmSerialDataItem;

/**
 * AmGraphDataItem holds all the information about the graph's data item. When working with a chart, you do not create
 * AmGraphDataItem objects or change it's properties directly. AmGraphDataItem is passed to you by events when user interacts
 * with data item on the chart. The list of properties below will help you to extract data item's value/coordinate/etc.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/GraphDataItem">Official Documentation</a>
 */
//@formatter:on
public class GraphDataItem extends ChartOptions {

    private AmGraphDataItem dataItem;

    public AmSerialDataItem getSerialDataItem() {
        return getAmGraphDataItem().serialDataItem;
    }

    public void setSerialDataItem(SerialDataItem serialDataItem) {
        getAmGraphDataItem().serialDataItem = serialDataItem.getAmSerialDataItem();
    }

    public double getAlpha() {
        return getAmGraphDataItem().alpha;
    }

    /**
     * Opacity of the data item.
     */
    public void setAlpha(double alpha) {
        getAmGraphDataItem().alpha = alpha;
    }

    public String getBullet() {
        return getAmGraphDataItem().bullet;
    }

    /**
     * Bullet type.
     */
    public void setBullet(String bullet) {
        getAmGraphDataItem().bullet = bullet;
    }

    public int getBulletSize() {
        return getAmGraphDataItem().bulletSize;
    }

    /**
     * Bullet size.
     */
    public void setBulletSize(int bulletSize) {
        getAmGraphDataItem().bulletSize = bulletSize;
    }

    public String getCategory() {
        return getAmGraphDataItem().category;
    }

    /**
     * Category value.
     */
    public void setCategory(String category) {
        getAmGraphDataItem().category = category;
    }

    public String getColor() {
        return getAmGraphDataItem().color;
    }

    /**
     * Color of the data item.
     */
    public void setColor(String color) {
        getAmGraphDataItem().color = color;
    }

    public String getCustomBullet() {
        return getAmGraphDataItem().customBullet;
    }

    /**
     * Custom bullet (path to file name).
     */
    public void setCustomBullet(String customBullet) {
        getAmGraphDataItem().customBullet = customBullet;
    }

    public Object getDataContext() {
        return getAmGraphDataItem().dataContext;
    }

    /**
     * Original object from data provider.
     */
    public void setDataContext(Object dataContext) {
        getAmGraphDataItem().dataContext = dataContext;
    }

    public String getDescription() {
        return getAmGraphDataItem().description;
    }

    /**
     * Description.
     */
    public void setDescription(String description) {
        getAmGraphDataItem().description = description;
    }

    public String[] getFillColors() {
        return getAmGraphDataItem().fillColors;
    }

    /**
     * Array of colors of the data item, used by column and candlestick chart only.
     */
    public void setFillColors(String[] fillColors) {
        getAmGraphDataItem().fillColors = fillColors;
    }

    public Object getPercents() {
        return getAmGraphDataItem().percents;
    }

    /**
     * Object which holds percents when recalculateToPercents is set to true.
     */
    public void setPercents(Object percents) {
        getAmGraphDataItem().percents = percents;
    }

    public String getUrl() {
        return getAmGraphDataItem().url;
    }

    /**
     * url
     */
    public void setUrl(String url) {
        getAmGraphDataItem().url = url;
    }

    public Object getValues() {
        return getAmGraphDataItem().values;
    }

    /**
     * Object which holds values of the data item (value, open, close, low, high).
     */
    public void setValues(Object values) {
        getAmGraphDataItem().values = values;
    }

    public int getX() {
        return getAmGraphDataItem().x;
    }

    /**
     * x coordinate of the data item.
     */
    public void setX(int x) {
        getAmGraphDataItem().x = x;
    }

    public int getY() {
        return getAmGraphDataItem().y;
    }

    /**
     * y coordinate of the data item.
     */
    public void setY(int y) {
        getAmGraphDataItem().y = y;
    }

    public AmGraphDataItem getAmGraphDataItem() {
        if (dataItem == null) {
            dataItem = new AmGraphDataItem();
        }
        return dataItem;
    }
}
