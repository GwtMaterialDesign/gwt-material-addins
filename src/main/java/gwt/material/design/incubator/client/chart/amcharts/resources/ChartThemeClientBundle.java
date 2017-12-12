package gwt.material.design.incubator.client.chart.amcharts.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface ChartThemeClientBundle extends ClientBundle {

    ChartThemeClientBundle INSTANCE = GWT.create(ChartThemeClientBundle.class);

    @Source("js/themes/black.js")
    TextResource blackJs();

    @Source("js/themes/chalk.js")
    TextResource chalkJs();

    @Source("js/themes/dark.js")
    TextResource darkJs();

    @Source("js/themes/light.js")
    TextResource lightJs();

    @Source("js/themes/patterns.js")
    TextResource patternsJs();
}
