package gwt.material.design.incubator.client.chart.amcharts.base.constants;

import gwt.material.design.client.base.helper.EnumHelper;
import gwt.material.design.client.constants.CssType;

public enum ChartTheme implements CssType {

    NONE("none"),
    BLACK("black"),
    CHALK("chalk"),
    DARK("dark"),
    LIGHT("light"),
    PATTERNS("patterns");

    private final String name;

    ChartTheme(String name) {
        this.name = name;
    }

    public static ChartTheme fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, ChartTheme.class, NONE);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCssName() {
        return name;
    }
}
