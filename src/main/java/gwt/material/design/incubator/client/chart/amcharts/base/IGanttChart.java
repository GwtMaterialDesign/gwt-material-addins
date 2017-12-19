package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.js.AmGraph;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;

import java.util.Date;

public interface IGanttChart {

    /**
     * Lightness increase of each subsequent bar of one series. Value range is from -255 to 255.
     */
    void setBrightnessStep(int brightnessStep);

    /**
     * Field of column width of a segments in your data provider.
     */
    void setColumnWidthField(String columnWidthField);

    /**
     * Instead of specifying end date or end value in your data, you can specify duration of a segment.
     */
    void setDurationField(String durationField);

    /**
     * Field in your data provider which holds end date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    void setEndDateField(String endDateField);

    /**
     * Field in your data provider which holds end value of a segment. If your data is date-based, you should use
     * endDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * endField and set number of periods instead of providing exact end date.
     */
    void setEndField(String endField);

    /**
     * Graph of a Gantt chart. Gant chart actually creates multiple graphs (separate for each segment). Properties of
     * this graph are passed to each of the created graphs - this allows you to control the look of segments.
     */
    void setGraph(AmGraph graph);

    /**
     * Data period. Used only value axis is date-based.
     */
    void setPeriod(String period);

    /**
     * Segments field in your data provider.
     */
    void setSegmentsField(String segmentsField);

    /**
     * Initial date of value axis. If you set this date (you can do it using time stamp, Date object or date string),
     * you can then set start/end/duration of segments using number of periods instead of providing exact dates.
     */
    void setStartDate(Date startDate);

    /**
     * Field in your data provider which holds start date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    void setStartDateField(String startDateField);

    /**
     * Field in your data provider which holds start value of a segment. If your data is date-based, you should use
     * startDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * startField and set number of periods instead of providing exact start date.
     */
    void setStartField(String startField);

    /**
     * Value axis of Gantt chart. Set it's type to "date" if your data is date or time based.
     */
    void setValueAxis(ValueAxis valueAxis);
}
