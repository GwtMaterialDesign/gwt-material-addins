package gwt.material.design.incubator.client.chart.amcharts.base;

import com.google.gwt.event.shared.SimpleEventBus;
import gwt.material.design.client.base.JsLoader;

public abstract class ChartOptions extends SimpleEventBus implements JsLoader {

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
