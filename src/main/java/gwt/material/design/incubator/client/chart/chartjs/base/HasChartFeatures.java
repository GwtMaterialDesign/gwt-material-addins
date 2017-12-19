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

import gwt.material.design.incubator.client.chart.chartjs.js.datasets.ChartDataSets;
import gwt.material.design.incubator.client.chart.chartjs.js.options.GlobalOptions;
import gwt.material.design.jquery.client.api.Event;
import gwt.material.design.jscore.client.api.core.Element;

import java.util.List;

public interface HasChartFeatures<T extends ChartDataSets> extends HasGlobalOptions {

    void setLabels(String... labels);

    void setDatasets(T[] datasets);

    /**
     * Use this to destroy any chart instances that are created. This will clean up any references stored to
     * the chart object within Chart.js, along with any associated event listeners attached by Chart.js.
     * This must be called before the canvas is reused for a new chart.
     */
    void destroy();

    /**
     * Triggers an update of the chart. This can be safely called after updating the data object.
     * This will update all scales, legends, and then re-render the chart.
     */
    void update();

    /**
     * Reset the chart to it's state before the initial animation. A new animation can then be triggered using update.
     */
    void reset();

    /**
     * Triggers a redraw of all chart elements. Note, this does not update elements for new data. Use .update() in that case.
     * See {@link #update(GlobalOptions)} for more details on the config object.
     */
    void render(GlobalOptions options);

    /**
     * Use this to stop any current animation loop. This will pause the chart during any current animation frame.
     * Call .render() to re-animate.
     */
    void stop();

    /**
     * Use this to manually resize the canvas element. This is run each time the canvas container is resized,
     * but you can call this method manually if you change the size of the canvas nodes container element.
     */
    void resize();

    /**
     * Will clear the chart canvas. Used extensively internally between animation frames, but you might find it useful.
     */
    void clear();

    /**
     * This returns a base 64 encoded string of the chart in it's current state.
     */
    String toBase64Image();

    /**
     * Returns an HTML string of a legend for that chart. The legend is generated from the legendCallback in the options.
     */
    String generateLegend();

    /**
     * Calling getElementAtEvent(event) on your Chart instance passing an argument of an event, or jQuery event,
     * will return the single element at the event position. If there are multiple items within range, only the first is returned.
     * The value returned from this method is an array with a single parameter. An array is used to keep a consistent API between
     * the get*AtEvent methods.
     */
    Element getElementAtEvent(Event event);

    /**
     * Looks for the element under the event point, then returns all elements at the same data index. This is used internally
     * for 'label' mode highlighting.Calling getElementsAtEvent(event) on your Chart instance passing an argument of an event,
     * or jQuery event, will return the point elements that are at that the same position of that event.
     * <p>
     * This functionality may be useful for implementing DOM based tooltips, or triggering custom behaviour in your application.
     */
    List<Element> getElementsAtEvent(Event event);

    /**
     * Looks for the element under the event point, then returns all elements from that dataset.
     * This is used internally for 'dataset' mode highlighting
     */
    List<Element> getDatasetAtEvent(Event event);

    /**
     * Looks for the dataset that matches the current index and returns that metadata.
     * This returned data has all of the metadata that is used to construct the chart.
     * The data property of the metadata will contain information about each point, rectangle, etc. depending on the chart type.
     */
    Object getDatasetMeta(int index);
}
