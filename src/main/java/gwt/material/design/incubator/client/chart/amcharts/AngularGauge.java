package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.AbstractChart;
import gwt.material.design.incubator.client.chart.amcharts.base.IAngularGauge;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.AnimationEffect;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmAngularGauge;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeArrow;
import gwt.material.design.incubator.client.chart.amcharts.js.options.GaugeAxis;

public class AngularGauge extends AbstractChart implements IAngularGauge {

    protected AmAngularGauge angularGauge;

    public AngularGauge() {
        super(ChartType.GAUGE);
    }

    @Override
    public void setAdjustSize(boolean adjustSize) {
        getChart().adjustSize = adjustSize;
    }

    @Override
    public void setArrows(GaugeArrow... arrows) {
        getChart().arrows = arrows;
    }

    @Override
    public void setAxes(GaugeAxis axes) {
        getChart().axes = axes;
    }

    @Override
    public void setClockWiseOnly(boolean clockWiseOnly) {
        getChart().clockWiseOnly = clockWiseOnly;
    }

    @Override
    public void setFaceAlpha(double faceAlpha) {
        getChart().faceAlpha = faceAlpha;
    }

    @Override
    public void setFaceBorderAlpha(double faceBorderAlpha) {
        getChart().faceBorderAlpha = faceBorderAlpha;
    }

    @Override
    public void setFaceBorderColor(String faceBorderColor) {
        getChart().faceBorderColor = faceBorderColor;
    }

    @Override
    public void setFaceBorderWidth(int faceBorderWidth) {
        getChart().faceBorderWidth = faceBorderWidth;
    }

    @Override
    public void setFaceColor(String faceColor) {
        getChart().faceColor = faceColor;
    }

    @Override
    public void setFacePattern(Object facePattern) {
        getChart().facePattern = facePattern;
    }

    @Override
    public void setGaugeX(int gaugeX) {
        getChart().gaugeX = gaugeX;
    }

    @Override
    public void setGaugeY(int gaugeY) {
        getChart().gaugeY = gaugeY;
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
    public void setMinRadius(int minRadius) {
        getChart().minRadius = minRadius;
    }

    @Override
    public void setStartDuration(int startDuration) {
        getChart().startDuration = startDuration;
    }

    @Override
    public void setStartEffect(AnimationEffect startEffect) {
        getChart().startEffect = startEffect.getName();
    }

    @Override
    public void addArrow(GaugeArrow gaugeArrow) {
        getChart().addArrow(gaugeArrow);
    }

    @Override
    public void addAxis(GaugeAxis gaugeAxis) {
        getChart().addAxis(gaugeAxis);
    }

    @Override
    public void removeArrow(GaugeArrow gaugeArrow) {
        getChart().removeArrow(gaugeArrow);
    }

    @Override
    public void removeAxis(GaugeAxis gaugeAxis) {
        getChart().removeAxis(gaugeAxis);
    }

    @Override
    public AmAngularGauge getChart() {
        if (angularGauge == null) {
            angularGauge = new AmAngularGauge();
        }
        return angularGauge;
    }
}
