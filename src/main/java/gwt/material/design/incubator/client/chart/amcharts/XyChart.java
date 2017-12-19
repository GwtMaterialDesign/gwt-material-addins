package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IXyChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmXYChart;

//@formatter:off

/**
 * Extension for {@link RectangularChart} to create XY/bubble/scatter charts.
 * The charts support multiple axes with simple or logarithmic scales.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmXYChart">Official Documentation</a>
 */
//@formatter:on
public class XyChart extends RectangularChart implements IXyChart {

    protected AmXYChart chart;

    public XyChart() {
        super(ChartType.XY);
    }

    @Override
    public void setDataDateFormat(String dataDateFormat) {
        getChart().dataDateFormat = dataDateFormat;
    }

    @Override
    public void setHideXScrollbar(boolean hideXScrollbar) {
        getChart().hideXScrollbar = hideXScrollbar;
    }

    @Override
    public void setHideYScrollbar(boolean hideYScrollbar) {
        getChart().hideYScrollbar = hideYScrollbar;
    }

    @Override
    public void setMaxValue(int maxValue) {
        getChart().maxValue = maxValue;
    }

    @Override
    public void setMinValue(int minValue) {
        getChart().minValue = minValue;
    }

    @Override
    public void zoomOut() {
        getChart().zoomOut();
    }

    @Override
    public AmXYChart getChart() {
        if (chart == null) {
            chart = new AmXYChart();
        }
        return chart;
    }
}
