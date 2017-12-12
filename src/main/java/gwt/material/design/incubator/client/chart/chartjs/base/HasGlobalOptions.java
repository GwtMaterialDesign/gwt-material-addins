package gwt.material.design.incubator.client.chart.chartjs.base;

import gwt.material.design.incubator.client.chart.chartjs.js.options.global.*;

public interface HasGlobalOptions {

    void setAnimationOptions(AnimationOptions animationOptions);

    void setLayoutOptions(LayoutOptions layoutOptions);

    void setLegendOptions(LegendOptions legendOptions);

    void setTooltipOptions(TooltipOptions tooltipOptions);

    void setTitleOptions(TitleOptions titleOptions);

    void setElementOptions(ElementOptions elementOptions);
}
