/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.chart.amcharts.base;

import gwt.material.design.incubator.client.chart.amcharts.events.*;
//@formatter:off

/**
 * {@link gwt.material.design.incubator.client.chart.amcharts.CoordinateChart} lists of events
 *
 * @author kevzlou7979@gmail.com
 */
//@formatter:on
public interface HasCoordinateChartHandlers {

    /**
     * Dispatched when user clicks on a graph.
     */
    void addClickGraphHandler(ClickGraphEvent.ClickGraphHandler handler);

    /**
     * Dispatched when user clicks on the data item (column/bullet)
     */
    void addClickGraphItemHandler(ClickGraphItemEvent.ClickGraphItemHandler handler);

    /**
     * Dispatched when user right-clicks on the data item (column/bullet)
     */
    void addRightClickGraphItemHandler(RightClickGraphItemEvent.RightClickGraphItemHandler handler);

    /**
     * Dispatched when user rolls-out of a graph.
     */
    void addRollOutGraphHandler(RollOutGraphEvent.RollOutGraphHandler handler);

    /**
     * Dispatched when user rolls-out of the data item (column/bullet)
     */
    void addRollOutGraphItemHandler(RollOutGraphItemEvent.RollOutGraphItemHandler handler);

    /**
     * Dispatched when user rolls-over a graph.
     */
    void addRollOverGraphHandler(RollOverGraphEvent.RollOverGraphHandler handler);

    /**
     * Dispatched when user rolls-over data item (column/bullet)
     */
    void addRollOverGraphItemHandler(RollOverGraphItemEvent.RollOverGraphItemHandler handler);
}
