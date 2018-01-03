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
public class XyChart extends RectangularChart {

    protected AmXYChart chart;

    public XyChart() {
        super(ChartType.XY);
    }

    /**
     * In case you have date-based value axis in your XY chart, you can specify your corresponding values as strings.
     * In that case you will need to set this setting to whatever format your are using for date/time.
     * <p>
     * <p>
     * Check this page for available formats.
     * <p>
     * Please note that two-digit years (YY) as well as literal month names (MMM) are NOT supported in this setting.
     */
    public void setDataDateFormat(String dataDateFormat) {
        getChart().dataDateFormat = dataDateFormat;
    }

    /**
     * Specifies if Scrollbar of X axis (horizontal) should be hidden. Default to false
     */
    public void setHideXScrollbar(boolean hideXScrollbar) {
        getChart().hideXScrollbar = hideXScrollbar;
    }

    /**
     * Specifies if Scrollbar of Y axis (vertical) should be hidden. Default false
     */
    public void setHideYScrollbar(boolean hideYScrollbar) {
        getChart().hideYScrollbar = hideYScrollbar;
    }

    /**
     * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
     * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
     * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
     * Note, if you use these two settings, you might also want to set minBulletSize to 0.
     */
    public void setMaxValue(int maxValue) {
        getChart().maxValue = maxValue;
    }

    /**
     * These can be used to adjust size/scale of bubbles. If these properties are not set, the bubble with smallest
     * value will be of minBulletSize and bubble with biggest value will be of maxBulletSize. However, you might want
     * bubble size to change relative to 0 or some other value. In this case you can use minValue and maxValue properties.
     * Note, if you use these two settings, you might also want to set minBulletSize to 0.
     */
    public void setMinValue(int minValue) {
        getChart().minValue = minValue;
    }

    /**
     * Zooms out, charts shows all available data.
     */
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
