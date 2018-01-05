/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.incubator.client.chart.amcharts.events.coordinate;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.CoordinateGraphData;
//@formatter:off

/**
 * Dispatched when user rolls-out of a graph.
 *
 * @author kevzlou7979
 */
public class RollOutGraphEvent extends GwtEvent<RollOutGraphEvent.RollOutGraphHandler> {

    public static final Type<RollOutGraphHandler> TYPE = new Type<>();
    private CoordinateGraphData data;

    public RollOutGraphEvent(CoordinateGraphData data) {
        this.data = data;
    }

    public static Type<RollOutGraphHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoordinateGraphData data) {
        source.fireEvent(new RollOutGraphEvent(data));
    }

    @Override
    public Type<RollOutGraphHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RollOutGraphEvent.RollOutGraphHandler handler) {
        handler.onRollOutGraph(this);
    }

    public CoordinateGraphData getData() {
        return data;
    }

    public interface RollOutGraphHandler extends EventHandler {
        void onRollOutGraph(RollOutGraphEvent event);
    }
}
