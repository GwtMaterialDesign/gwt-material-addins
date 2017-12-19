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
package gwt.material.design.incubator.client.chart.amcharts;

import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmCharts;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartClientBundle;
import gwt.material.design.incubator.client.chart.amcharts.resources.ChartResourceLoader;


public class ChartJsonLoader extends MaterialWidget {

    static {
        MaterialDesign.injectDebugJs(ChartClientBundle.INSTANCE.amChartJs());
    }

    public ChartJsonLoader() {
        super(Document.get().createDivElement());
        setId(DOM.createUniqueId());
    }

    public void load(JSONValue jsonConfigs) {
        loadPlugin(ChartPlugin.DATA_LOADER);
        AmCharts.makeChart(getId(), jsonConfigs);
    }

    public void setType(ChartType type) {
        ChartResourceLoader.loadChartTypeResource(type);
    }

    public void setTheme(ChartTheme theme) {
        ChartResourceLoader.loadTheme(theme);
    }

    public void loadPlugin(ChartPlugin plugin) {
        ChartResourceLoader.loadPluginResource(plugin);
    }
}
