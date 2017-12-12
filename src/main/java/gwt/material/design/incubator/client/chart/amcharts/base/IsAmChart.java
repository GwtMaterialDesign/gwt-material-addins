package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartPlugin;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartTheme;
import gwt.material.design.incubator.client.chart.amcharts.base.constants.ChartType;

public interface IsAmChart {

    ChartType getType();

    void setType(ChartType type);

    ChartTheme getTheme();

    void setTheme(ChartTheme theme);

    void loadPlugin(ChartPlugin plugin);
}
