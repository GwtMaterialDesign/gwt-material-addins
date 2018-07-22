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
package gwt.material.design.incubator.client.chart.chartjs.base;

import com.google.gwt.dom.client.Document;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesign;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.incubator.client.chart.chartjs.ChartClientBundle;
import gwt.material.design.incubator.client.chart.chartjs.ChartDebugClientBundle;
import gwt.material.design.incubator.client.chart.chartjs.base.constants.ChartType;
import gwt.material.design.incubator.client.chart.chartjs.js.Chart;
import gwt.material.design.incubator.client.chart.chartjs.js.datasets.ChartDataSets;
import gwt.material.design.incubator.client.chart.chartjs.js.options.GlobalOptions;
import gwt.material.design.incubator.client.chart.chartjs.js.options.global.*;
import gwt.material.design.jquery.client.api.Event;
import gwt.material.design.jscore.client.api.core.Element;

import java.util.List;

public class AbstractChart<T extends ChartDataSets> extends MaterialWidget implements JsLoader, HasChartFeatures<T> {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesign.injectDebugJs(ChartDebugClientBundle.INSTANCE.chartDebugJs());
        } else {
            MaterialDesign.injectJs(ChartClientBundle.INSTANCE.chartJs());
        }
    }

    private Chart chart;
    private GlobalOptions globalOptions = GlobalOptions.create();

    public AbstractChart(ChartType type) {
        super(Document.get().createCanvasElement());
        globalOptions.type = type.getName();
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        chart = new Chart(getElement(), globalOptions);
    }

    @Override
    protected void onUnload() {
        super.onUnload();
        unload();
    }

    @Override
    public void unload() {
        chart.destroy();
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    public String[] getLabels() {
        return globalOptions.data.labels;
    }

    public void setLabels(String... labels) {
        globalOptions.data.labels = labels;
        update();
    }

    public void setDatasets(T[] datasets) {
        globalOptions.data.datasets = datasets;
        update();
    }

    public T[] getDatasets() {
        return (T[]) globalOptions.data.datasets;
    }

    public void setDatasets(List<T> datasets) {
        setDatasets((T[]) datasets.toArray());
    }

    @Override
    public void destroy() {
        chart.destroy();
    }

    @Override
    public void update() {
        if (chart != null) {
            chart.update(globalOptions);
        }
    }

    @Override
    public void reset() {
        chart.reset();
    }

    @Override
    public void render(GlobalOptions options) {
        chart.render(options);
    }

    @Override
    public void stop() {
        chart.stop();
    }

    @Override
    public void resize() {
        chart.resize();
    }

    @Override
    public String toBase64Image() {
        return chart.toBase64Image();
    }

    @Override
    public String generateLegend() {
        return chart.generateLegend();
    }

    @Override
    public Element getElementAtEvent(Event event) {
        return chart.getElementAtEvent(event);
    }

    @Override
    public List<Element> getElementsAtEvent(Event event) {
        return chart.getElementsAtEvent(event);
    }

    @Override
    public List<Element> getDatasetAtEvent(Event event) {
        return chart.getDatasetAtEvent(event);
    }

    @Override
    public Object getDatasetMeta(int index) {
        return chart.getDatasetMeta(index);
    }

    public GlobalOptions getGlobalOptions() {
        return globalOptions;
    }

    @Override
    public void setAnimationOptions(AnimationOptions animationOptions) {
        globalOptions.options.animation = animationOptions;
        update();
    }

    @Override
    public void setLayoutOptions(LayoutOptions layoutOptions) {
        globalOptions.options.layout = layoutOptions;
        update();
    }

    @Override
    public void setLegendOptions(LegendOptions legendOptions) {
        globalOptions.options.legend = legendOptions;
        update();
    }

    @Override
    public void setTooltipOptions(TooltipOptions tooltipOptions) {
        globalOptions.options.tooltip = tooltipOptions;
        update();
    }

    @Override
    public void setTitleOptions(TitleOptions titleOptions) {
        globalOptions.options.title = titleOptions;
        update();
    }

    @Override
    public void setElementOptions(ElementOptions elementOptions) {
        globalOptions.options.elements = elementOptions;
        update();
    }
}
