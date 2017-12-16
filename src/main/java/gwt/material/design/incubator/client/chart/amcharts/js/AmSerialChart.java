package gwt.material.design.incubator.client.chart.amcharts.js;

import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

//@formatter:off

/**
 *
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="">Official Documentation</a>
 */
//@formatter:on
@JsType(isNative = true, namespace = "AmCharts")
public class AmSerialChart extends AmRectangularChart {

    @JsProperty
    protected String balloonDateFormat;

    @JsProperty
    protected int bezierX;

    @JsProperty
    protected int bezierY;

    @JsProperty
    public String categoryAxis;

    @JsProperty
    public String categoryField;

    @JsProperty
    public int columnSpacing;

    @JsProperty
    public int columnSpacing3D;

    @JsProperty
    public double columnWidth;

    @JsProperty
    public String dataDateFormat;

    @JsProperty
    public Date endDate;

    @JsProperty
    public int endIndex;

    @JsProperty
    public int maxSelectedSeries;

    @JsProperty
    public int maxSelectedTime;

    @JsProperty
    public int minSelectedTime;

    @JsProperty
    public boolean mouseWheelScrollEnabled;

    @JsProperty
    public boolean mouseWheelZoomEnabled;

    @JsProperty
    public boolean rotate;

    @JsProperty
    public Date startDate;

    @JsProperty
    public int startIndex;

    @JsProperty
    public ChartScrollbar valueScrollbar;

    @JsProperty
    public boolean zoomOutOnDataUpdate;

    @JsMethod
    public native int getCategoryIndexByValue(Object value);

    @JsMethod
    public native void zoomOut();

    @JsMethod
    public native void zoomToCategoryValues(String start, String end);

    @JsMethod
    public native void zoomToDates(Date start, Date end);

    @JsMethod
    public native void zoomToIndexes(int start, int end);
}
