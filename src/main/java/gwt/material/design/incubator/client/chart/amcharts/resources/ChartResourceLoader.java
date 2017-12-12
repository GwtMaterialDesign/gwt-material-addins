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
