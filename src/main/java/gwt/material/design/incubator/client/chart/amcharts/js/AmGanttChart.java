package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.ValueAxis;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

//@formatter:off

/**
 * Extension for AmSerialChart to gantt charts. Gantt charts usually display multiple bars on one series where value
 * axis displays date/time and is horizontal.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmGanttChart">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmGanttChart extends AmSerialChart {

    /**
     * Lightness increase of each subsequent bar of one series. Value range is from -255 to 255.
     */
    @JsProperty
    public int brightnessStep;

    /**
     * Field of column width of a segments in your data provider.
     */
    @JsProperty
    public String columnWidthField;

    /**
     * Instead of specifying end date or end value in your data, you can specify duration of a segment.
     */
    @JsProperty
    public String durationField;

    /**
     * Field in your data provider which holds end date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    @JsProperty
    public String endDateField;

    /**
     * Field in your data provider which holds end value of a segment. If your data is date-based, you should use
     * endDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * endField and set number of periods instead of providing exact end date.
     */
    @JsProperty
    public String endField;

    /**
     * Graph of a Gantt chart. Gant chart actually creates multiple graphs (separate for each segment). Properties of
     * this graph are passed to each of the created graphs - this allows you to control the look of segments.
     */
    @JsProperty
    public AmGraph amGraph;

    /**
     * Data period. Used only value axis is date-based.
     */
    @JsProperty
    public String period;

    /**
     * Segments field in your data provider.
     */
    @JsProperty
    public String segmentsField;

    /**
     * Initial date of value axis. If you set this date (you can do it using time stamp, Date object or date string),
     * you can then set start/end/duration of segments using number of periods instead of providing exact dates.
     */
    @JsProperty
    public Date startDate;

    /**
     * Field in your data provider which holds start date of a segment. Dates in your data can be set by time stamp or
     * Date object or string (chart.dataDateFormat should define date format in latter case).
     */
    @JsProperty
    public String startDateField;

    /**
     * Field in your data provider which holds start value of a segment. If your data is date-based, you should use
     * startDateField instead, unless you specified chart.startDate and chart.period values. In this case you can use
     * startField and set number of periods instead of providing exact start date.
     */
    @JsProperty
    public String startField;

    /**
     * Value axis of Gantt chart. Set it's type to "date" if your data is date or time based.
     */
    @JsProperty
    public ValueAxis valueAxis;
}
