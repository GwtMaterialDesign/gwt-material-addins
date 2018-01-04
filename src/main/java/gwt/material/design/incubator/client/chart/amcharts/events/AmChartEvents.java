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
package gwt.material.design.incubator.client.chart.amcharts.events;

public interface AmChartEvents {

    // Core Chart
    String ANIMATION_FINISHED = "animationFinished";
    String BUILD_STARTED = "buildStarted";
    String DATA_UPDATED = "dataUpdated";
    String DRAWN = "drawn";
    String INIT = "init";
    String RENDERED = "rendered";

    // Coordinate Chart
    String CLICK_GRAPH = "clickGraph";
    String CLICK_GRAPH_ITEM = "clickGraphItem";
    String RIGHT_CLICK_GRAPH_ITEM = "rightClickGraphItem";
    String ROLL_OUT_GRAPH = "rollOutGraph";
    String ROLL_OUT_GRAPH_ITEM = "rollOutGraphItem";
    String ROLL_OVER_GRAPH = "rollOverGraph";
    String ROLL_OVER_GRAPH_ITEM = "rollOverGraphItem";

    // Pie Chart
    String CLICK_SLICE = "clickSlice";
    String PULL_IN_SLICE = "pullInSlice";
    String PULL_OUT_SLICE = "pullOutSlice";
    String RIGHT_CLICK_SLICE = "rightClickSlice";
    String ROLL_OUT_SLICE = "rollOutSlice";
    String ROLL_OVER_SLICE = "rollOverSlice";

    // Serial Chart
    String CHANGED = "changed";
    String ZOOMED = "zoomed";

    // Legend
    String CLICK_LABEL = "clickLabel";
    String CLICK_MARKER = "clickMarker";
    String HIDE_ITEM = "hideItem";
    String ROLL_OUT_ITEM = "rollOutItem";
    String ROLL_OVER_ITEM = "rollOverItem";
    String ROLL_OVER_MARKER = "rollOverMarker";
    String SHOW_ITEM = "showItem";

    // Guide
    String CLICK_GUIDE = "clickGuide";
    String CLICK_ITEM = "clickItem";
    String ROLL_OUT_GUIDE = "rollOutGuide";
    String ROLL_OVER_GUIDE = "rollOverGuide";
}
