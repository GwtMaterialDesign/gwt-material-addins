package gwt.material.design.incubator.client.chart.amcharts.options;

import gwt.material.design.incubator.client.chart.amcharts.base.ChartOptions;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmCategoryAxis;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmGraphDataItem;
import gwt.material.design.incubator.client.chart.amcharts.js.options.AmSerialDataItem;

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
public class SerialDataItem extends ChartOptions {

    private AmSerialDataItem serialDataItem;

    public final Object getAxes() {
        return getAmSerialDataItem().axes;
    }

    /**
     * You can access each {@link AmGraphDataItem} using this object. The data structure is: graphDataItem =
     * serialDataItem.axes[axisId].graphs[graphId].
     */
    public final void setAxes(Object axes) {
        getAmSerialDataItem().axes = axes;
    }

    public final String getCategory() {
        return getAmSerialDataItem().category;
    }

    /**
     * Category value. String if parseDates is false, Date if true.
     */
    public final void setCategory(String category) {
        getAmSerialDataItem().category = category;
    }

    public final Object getDataContext() {
        return getAmSerialDataItem().dataContext;
    }

    /**
     * Reference to original data object, from dataProvider.
     */
    public final void setDataContext(Object dataContext) {
        getAmSerialDataItem().dataContext = dataContext;
    }

    public final int getTime() {
        return getAmSerialDataItem().time;
    }

    /**
     * Time stamp of a series date. Available only if parseDates property of {@link AmCategoryAxis} is set to true.
     */
    public final void setTime(int time) {
        getAmSerialDataItem().time = time;
    }

    public final int getX() {
        return getAmSerialDataItem().x;
    }

    /**
     * Coordinate (horizontal or vertical, depends on chart's rotate property) of the series.
     */
    public final void setX(int x) {
        getAmSerialDataItem().x = x;
    }

    public AmSerialDataItem getAmSerialDataItem() {
        if (serialDataItem == null) {
            serialDataItem = new AmSerialDataItem();
        }
        return serialDataItem;
    }
}
