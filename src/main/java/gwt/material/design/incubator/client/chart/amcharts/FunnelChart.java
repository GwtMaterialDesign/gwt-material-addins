/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.incubator.client.chart.amcharts;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmFunnelChart;

/**
 * Extension for {@link SliceChart} to create funnel/pyramid charts.
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="https://docs.amcharts.com/3/javascriptcharts/AmFunnelChart">Official Documentation</a>
 */
//@formatter:on
public class FunnelChart extends SliceChart {

    protected AmFunnelChart chart;

    public FunnelChart() {
        super(ChartType.FUNNEL);
    }

    /**
     * The angle of the 3D part of the chart. This creates a 3D effect (if the "depth3D" is > 0). Default to 0
     */
    public void setAngle(int angle) {
        getChart().angle = angle;
    }

    /**
     * Balloon text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider. HTML tags can also be used. Default to "[[title]]: [[value]]\n[[description]]"
     */
    public void setBalloonText(String balloonText) {
        getChart().balloonText = balloonText;
    }

    /**
     * Width of a base (first slice) of a chart. "100%" means it will occupy all available space.
     */
    public void setBaseWidth(int baseWidth) {
        getChart().baseWidth = baseWidth;
    }

    /**
     * The depth of funnel/pyramid. Set angle to >0 value in order this to work. Note, neckHeight/neckWidth will
     * become 0 if you set these properties to bigger than 0 values. Default to 0
     */
    public void setDepth3D(int depth3D) {
        getChart().depth3D = depth3D;
    }

    /**
     * Specifies where labels should be placed. Allowed values are left / center / right. If you set left or right,
     * you should increase left or right margin in order labels to be visible. Default to "center"
     */
    public void setLabelPosition(String labelPosition) {
        getChart().labelPosition = labelPosition;
    }

    /**
     * Label text. The following tags can be used: [[value]], [[title]], [[percents]], [[description]] or any other
     * field name from your data provider.
     */
    public void setLabelText(String labelText) {
        getChart().labelText = labelText;
    }

    /**
     * Height of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    public void setNeckHeight(int neckHeight) {
        getChart().neckHeight = neckHeight;
    }

    /**
     * Width of a funnel neck. If default value, zero is used, the funnel won't have neck at all, which will make it
     * look like pyramid.
     */
    public void setNeckWidth(int neckWidth) {
        getChart().neckWidth = neckWidth;
    }

    /**
     * Specifies the distance by which slice should be pulled when user clicks on it.
     */
    public void setPullDistance(int pullDistance) {
        getChart().pullDistance = pullDistance;
    }

    /**
     * If rotate is set to true, the funnel will be rotated and will became a pyramid.
     */
    public void setRotate(boolean rotate) {
        getChart().rotate = rotate;
    }

    /**
     * Initial x coordinate of slices. They will animate to the final x position from this one.
     */
    public void setStartX(int startX) {
        getChart().startX = startX;
    }

    /**
     * Initial y coordinate of slices. They will animate to the final y position from this one.
     */
    public void setStartY(int startY) {
        getChart().startY = startY;
    }

    /**
     * By default, the height of a slice represents it's value. However you might want the area of a slice to represent
     * value - set this property to "area" then.
     */
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
