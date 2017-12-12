package gwt.material.design.incubator.client.chart.amcharts.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface ChartPluginClientBundle extends ClientBundle {

    ChartPluginClientBundle INSTANCE = GWT.create(ChartPluginClientBundle.class);

    @Source("js/plugins/animate/animate.js")
    TextResource animateJs();

    @Source("js/plugins/dataloader/dataloader.js")
    TextResource dataLoaderJs();

    @Source("js/plugins/export/export.js")
    TextResource exportJs();

    @Source("js/plugins/responsive/responsive.js")
    TextResource responsiveJs();
}
