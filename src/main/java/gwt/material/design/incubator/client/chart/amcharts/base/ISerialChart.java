package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;

import java.util.Date;

public interface ISerialChart {

    /**
     * Date format of the graph balloon (if chart parses dates and you don't use chartCursor). Default to MMM DD, YYYY
     */
    void setBalloonDateFormat(String balloonDateFormat);

    /**
     * Horizontal tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    void setBezierX(int bezierX);

    /**
     * Vertical tension of bezier (used by smoothed line). If not defined, chart adjust tension by itself, taking in
     * to account if chart is rotated or not. Allowed values 1 - Infinity
     */
    void setBezierY(int bezierY);

    /**
     * Read-only. Chart creates category axis itself. If you want to change some properties, you should get this axis
     * from the chart and set properties to this object.
     */
    void setCategoryAxis(String categoryAxis);

    /**
     * Category field name tells the chart the name of the field in your dataProvider object which will be used for
     * category axis values.
     */
    void setCategoryField(String categoryField);

    /**
     * The gap in pixels between two columns of the same category. Default to 5
     */
    void setColumnSpacing(int columnSpacing);

    /**
     * Space between 3D stacked columns. Default to 0
     */
    void setColumnSpacing3D(int columnSpacing3D);

    /**
     * Relative width of columns. Value range is 0 - 1. Default to 0.8
     */
    void setColumnWidth(double columnWidth);

    /**
     * Even if your chart parses dates, you can pass them as strings in your data – all you need to do is to set data
     * date format and the chart will parse dates to date objects. Check this page for available formats.
     * Please note that two-digit years (YY) as well as literal month names (MMM) are NOT supported in this setting.
     */
    void setDataDateFormat(String dataDateFormat);

    /**
     * Read-only. If category axis parses dates endDate indicates date to which the chart is currently displayed.
     */
    void setEndDate(Date endDate);

    /**
     * Read-only. Category index to which the chart is currently displayed.
     */
    void setEndIndex(int endIndex);

    /**
     * Maximum number of series allowed to select.
     */
    void setMaxSelectedSeries(int maxSelectedSeries);

    /**
     * The longest time span allowed to select (in milliseconds) for example, 259200000 will limit selection to 3 days.
     * Works if equalSpacing is set to false (default).
     */
    void setMaxSelectedTime(int maxSelectedSeries);

    /**
     * The shortest time span allowed to select (in milliseconds) for example, 1000 will limit selection to 1 second.
     * Works if equalSpacing is set to false (default). Default to 0
     */
    void setMinSelectedTime(int minSelectedTime);

    /**
     * Specifies if scrolling of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will zoom-in/out. Default to false
     */
    void setMouseWheelScrollEnabled(boolean mouseWheelScrollEnabled);

    /**
     * Specifies if zooming of a chart with mouse wheel is enabled. If you press shift while rotating mouse wheel,
     * the chart will scroll. Default to false
     */
    void setMouseWheelZoomEnabled(boolean mouseWheelZoomEnabled);

    /**
     * If you set this to true, the chart will be rotated by 90 degrees (the columns will become bars). Default to false
     */
    void setRotate(boolean rotate);

    /**
     * Read-only. If category axis parses dates startDate indicates date from which the chart is currently displayed.
     */
    void setStartDate(Date startDate);

    /**
     * Read-only. Category index from which the chart is currently displayed.
     */
    void setStartIndex(int startIndex);

    /**
     * Value scrollbar, enables scrolling value axes.
     */
    void setValueScrollbar(ChartScrollbar valueScrollbar);

    /**
     * Specifies if chart should zoom-out when data is updated. Default to true
     */
    void setZoomOutOnDataUpdate(boolean zoomOutOnDataUpdate);

    /**
     * Returns index of the specified category value.
     */
    int getCategoryIndexByValue(Object value);

    /**
     * Zooms out, charts shows all available data.
     */
    void zoomOut();

    /**
     * Zooms the chart by the value of the category axis.
     */
    void zoomToCategoryValues(String start, String end);

    /**
     * Zooms the chart from one date to another.
     */
    void zoomToDates(Date start, Date end);

    /**
     * Zooms the chart by the index of the category.
     */
    void zoomToIndexes(int start, int end);

    // TODO Events
}
