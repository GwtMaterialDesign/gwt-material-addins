package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.IFunnelChart;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmFunnelChart;

public class FunnelChart extends SliceChart implements IFunnelChart {

    protected AmFunnelChart chart;

    public FunnelChart() {
        super(ChartType.FUNNEL);
    }

    @Override
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    @Override
    public void setBalloonText(String balloonText) {
        getChart().balloonText = balloonText;
    }

    @Override
    public void setBaseWidth(int baseWidth) {
        getChart().baseWidth = baseWidth;
    }

    @Override
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    @Override
    public void setLabelPosition(String labelPosition) {
        getChart().labelPosition = labelPosition;
    }

    @Override
    public void setLabelText(String labelText) {
        getChart().labelText = labelText;
    }

    @Override
    public void setNeckHeight(int neckHeight) {
        getChart().neckHeight = neckHeight;
    }

    @Override
    public void setNeckWidth(int neckWidth) {
        getChart().neckWidth = neckWidth;
    }

    @Override
    public void setPullDistance(int pullDistance) {
        getChart().pullDistance = pullDistance;
    }

    @Override
    public void setRotate(boolean rotate) {
        getChart().rotate = rotate;
    }

    @Override
    public void setStartX(int startX) {
        getChart().startX = startX;
    }

    @Override
    public void setStartY(int startY) {
        getChart().startY = startY;
    }

    @Override
    public void setValueRepresents(String valueRepresents) {
        getChart().valueRepresents = valueRepresents;
    }

    @Override
    public AmFunnelChart getChart() {
        if (chart == null) {
            chart = new AmFunnelChart();
        }
        return chart;
    }
}
