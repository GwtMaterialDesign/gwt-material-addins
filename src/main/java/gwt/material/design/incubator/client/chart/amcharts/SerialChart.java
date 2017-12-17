package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.client.MaterialDesign;
import gwt.material.design.incubator.client.chart.amcharts.base.ISerialChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmSerialChart;
import gwt.material.design.incubator.client.chart.amcharts.js.options.ChartScrollbar;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartThemeClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartTypeClientBundle;

import java.util.Date;

public class SerialChart extends RectangularChartChart implements ISerialChart {

    static {
        MaterialDesign.injectJs(ChartTypeClientBundle.INSTANCE.serialJs());
        MaterialDesign.injectJs(ChartThemeClientBundle.INSTANCE.darkJs());
    }

    protected AmSerialChart chart;

    public SerialChart() {
        super();
        setType(ChartType.SERIAL);
    }

    @Override
    public AmSerialChart getChart() {
        if (chart == null) {
            chart = new AmSerialChart();
        }
        return chart;
    }

    @Override
    public void setBalloonDateFormat(String balloonDateFormat) {
        getChart().balloonDateFormat = balloonDateFormat;
    }

    @Override
    public void setBezierX(int bezierX) {
        getChart().bezierX = bezierX;
    }

    @Override
    public void setBezierY(int bezierY) {
        getChart().bezierY = bezierY;
    }

    @Override
    public void setCategoryAxis(String categoryAxis) {
        getChart().categoryAxis = categoryAxis;
    }

    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }

    @Override
    public void setColumnSpacing(int columnSpacing) {
        getChart().columnSpacing = columnSpacing;
    }

    @Override
    public void setColumnSpacing3D(int columnSpacing3D) {
        getChart().columnSpacing3D = columnSpacing3D;
    }

    @Override
    public void setColumnWidth(double columnWidth) {
        getChart().columnWidth = columnWidth;
    }

    @Override
    public void setDataDateFormat(String dataDateFormat) {
        getChart().dataDateFormat = dataDateFormat;
    }

    @Override
    public void setEndDate(Date endDate) {
        getChart().endDate = endDate;
    }

    @Override
    public void setEndIndex(int endIndex) {
        getChart().endIndex = endIndex;
    }

    @Override
    public void setMaxSelectedSeries(int maxSelectedSeries) {
        getChart().maxSelectedSeries = maxSelectedSeries;
    }

    @Override
    public void setMaxSelectedTime(int maxSelectedSeries) {
        getChart().maxSelectedTime = maxSelectedSeries;
    }

    @Override
    public void setMinSelectedTime(int minSelectedTime) {
        getChart().minSelectedTime = minSelectedTime;
    }

    @Override
    public void setMouseWheelScrollEnabled(boolean mouseWheelScrollEnabled) {
        getChart().mouseWheelScrollEnabled = mouseWheelScrollEnabled;
    }

    @Override
    public void setMouseWheelZoomEnabled(boolean mouseWheelZoomEnabled) {
        getChart().mouseWheelZoomEnabled = mouseWheelZoomEnabled;
    }

    @Override
    public void setRotate(boolean rotate) {
        getChart().rotate = rotate;
    }

    @Override
    public void setStartDate(Date startDate) {
        getChart().startDate = startDate;
    }

    @Override
    public void setStartIndex(int startIndex) {
        getChart().startIndex = startIndex;
    }

    @Override
    public void setValueScrollbar(ChartScrollbar valueScrollbar) {
        getChart().valueScrollbar = valueScrollbar;
    }

    @Override
    public void setZoomOutOnDataUpdate(boolean zoomOutOnDataUpdate) {
        getChart().zoomOutOnDataUpdate = zoomOutOnDataUpdate;
    }

    @Override
    public int getCategoryIndexByValue(Object value) {
        return getChart().getCategoryIndexByValue(value);
    }

    @Override
    public void zoomOut() {
        getChart().zoomOut();
    }

    @Override
    public void zoomToCategoryValues(String start, String end) {
        getChart().zoomToCategoryValues(start, end);
    }

    @Override
    public void zoomToDates(Date start, Date end) {
        getChart().zoomToDates(start, end);
    }

    @Override
    public void zoomToIndexes(int start, int end) {
        getChart().zoomToIndexes(start, end);
    }
}
