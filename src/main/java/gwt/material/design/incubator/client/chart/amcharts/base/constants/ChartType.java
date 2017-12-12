package gwt.material.design.incubator.client.chart.amcharts.base.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

/**
 * Type of the graph. Possible values are: "line", "column", "step", "smoothedLine", "candlestick", "ohlc".
 * XY and Radar charts can only display "line" type graphs.
 *
 * @author kevzlou7979@gmail.com
 */
public enum ChartType implements CssType {

    SERIAL("serial"),
    PIE("pie"),
    XY("xy"),
    RADAR("radar"),
    FUNNEL("funnel"),
    GAUGE("gauge"),
    GANTT("gantt");

    String name;

    ChartType(String name) {
        this.name = name;
    }

    public static ChartType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ChartType.class, SERIAL);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCssName() {
        return name;
    }
}
