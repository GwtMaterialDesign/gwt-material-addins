package gwt.material.design.incubator.client.chart.amcharts;

import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.amcharts.js.AmChartGenerator;
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
        AmChartGenerator.makeChart(getId(), jsonConfigs);
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
