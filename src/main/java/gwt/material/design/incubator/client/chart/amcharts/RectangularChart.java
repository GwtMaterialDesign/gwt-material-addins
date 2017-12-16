package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IsRectangular;
import gwt.material.design.incubator.client.chart.amcharts.js.AmRectangularChart;

public abstract class RectangularChart extends CoordinateChart implements IsRectangular {

    public RectangularChart() {
        super();
    }

    @Override
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    @Override
    public void setAutoMarginOffset(int autoMarginOffset) {
        getChart().autoMarginOffset = autoMarginOffset;
    }

    @Override
    public void setAutoMargins(boolean autoMargins) {
        getChart().autoMargins = autoMargins;
    }

    @Override
    public void setMarginRight(int marginRight) {
        getChart().marginRight = marginRight;
    }

    @Override
    public void setMarginTop(int marginTop) {
        getChart().marginTop = marginTop;
    }

    public abstract AmRectangularChart getChart();
}
