package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IRadar;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmRadarChart;

//@formatter:off

/**
 * Extension for {@link CoordinateChart} to create radar/polar charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmRadarChart">Official Documentation</a>
 */
//@formatter:on
public class RadarChart extends CoordinateChart implements IRadar {

    protected AmRadarChart chart;

    public RadarChart() {
        super(ChartType.RADAR);
    }

    @Override
    public void setCategoryField(String categoryField) {
        getChart().categoryField = categoryField;
    }

    @Override
    public void setMarginBottom(int marginBottom) {
        getChart().marginBottom = marginBottom;
    }

    @Override
    public void setMarginLeft(int marginLeft) {
        getChart().marginLeft = marginLeft;
    }

    @Override
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    @Override
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    @Override
    public void setRadius(Object radius) {
        getChart().radius = radius;
    }

    @Override
    public AmRadarChart getChart() {
        if (chart == null) {
            chart = new AmRadarChart();
        }
        return chart;
    }
}
