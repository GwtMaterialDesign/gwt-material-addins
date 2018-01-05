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
import gwt.material.design.incubator.client.chart.amcharts.events.object.CoordinateGraphItemData;
//@formatter:off

/**
 * Dispatched when user right-clicks on the data item (column/bullet)
 *
 * @author kevzlou7979
 */
public class RightClickGraphItemEvent extends GwtEvent<RightClickGraphItemEvent.RightClickGraphItemHandler> {

    public static final Type<RightClickGraphItemHandler> TYPE = new Type<>();
    private CoordinateGraphItemData data;

    public RightClickGraphItemEvent(CoordinateGraphItemData data) {
        this.data = data;
    }

    public static Type<RightClickGraphItemHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoordinateGraphItemData data) {
        source.fireEvent(new RightClickGraphItemEvent(data));
    }

    @Override
    public Type<RightClickGraphItemHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RightClickGraphItemEvent.RightClickGraphItemHandler handler) {
        handler.onRightClickGraphItem(this);
    }

    public CoordinateGraphItemData getData() {
        return data;
    }

    public interface RightClickGraphItemHandler extends EventHandler {
        void onRightClickGraphItem(RightClickGraphItemEvent event);
    }
}
