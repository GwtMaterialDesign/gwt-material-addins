/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.incubator.client.chart.amcharts.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;

public class ChartResourceLoader {

    public static void loadChartTypeResource(ChartType type) {
        switch (type) {
            case SERIAL:
                injectJs(ChartTypeClientBundle.INSTANCE.serialJs());
                break;
            case GAUGE:
                injectJs(ChartTypeClientBundle.INSTANCE.gaugeJs());
                break;
            case GANTT:
                injectJs(ChartTypeClientBundle.INSTANCE.ganttJs());
                break;
            case FUNNEL:
                injectJs(ChartTypeClientBundle.INSTANCE.funnelJs());
                break;
            case PIE:
                injectJs(ChartTypeClientBundle.INSTANCE.pieJs());
                break;
            case RADAR:
                injectJs(ChartTypeClientBundle.INSTANCE.radarJs());
                break;
            default:
                GWT.log("Please specify a chart type", new IllegalStateException());
                break;
        }
    }

    public static void loadPluginResource(ChartPlugin plugin) {
        switch (plugin) {
            case DATA_LOADER:
                injectJs(ChartPluginClientBundle.INSTANCE.dataLoaderJs());
                break;
            case RESPONSIVE:
                injectJs(ChartPluginClientBundle.INSTANCE.responsiveJs());
                break;
            case ANIMATION:
                injectJs(ChartPluginClientBundle.INSTANCE.animateJs());
                break;
            case EXPORT:
                injectJs(ChartPluginClientBundle.INSTANCE.exportJs());
                break;
            default:
                GWT.log("Please specify a chart plugin", new IllegalStateException());
                break;
        }
    }

    public static void loadTheme(ChartTheme theme) {
        switch (theme) {
            case LIGHT:
                injectJs(ChartThemeClientBundle.INSTANCE.lightJs());
                break;
            case BLACK:
                injectJs(ChartThemeClientBundle.INSTANCE.blackJs());
                break;
            case DARK:
                injectJs(ChartThemeClientBundle.INSTANCE.darkJs());
                break;
            case CHALK:
                injectJs(ChartThemeClientBundle.INSTANCE.chalkJs());
                break;
            case PATTERNS:
                injectJs(ChartThemeClientBundle.INSTANCE.patternsJs());
                break;
            default:
                break;
        }
    }

    protected static void injectJs(TextResource resource) {
        MaterialDesign.injectJs(resource);
    }
}
