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
package gwt.material.design.incubator.client.chart.amcharts.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.AxisItemEventData;
//@formatter:off

/**
 * Fired if user clicks on axis label.
 *
 * @author kevzlou7979
 */
public class ClickItemEvent extends GwtEvent<ClickItemEvent.ClickItemHandler> {

    public static final Type<ClickItemHandler> TYPE = new Type<>();
    private AxisItemEventData data;

    public ClickItemEvent(AxisItemEventData data) {
        this.data = data;
    }

    public static Type<ClickItemHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, AxisItemEventData data) {
        source.fireEvent(new ClickItemEvent(data));
    }

    @Override
    public Type<ClickItemHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClickItemEvent.ClickItemHandler handler) {
        handler.onClickItem(this);
    }

    public AxisItemEventData getData() {
        return data;
    }

    public interface ClickItemHandler extends EventHandler {
        void onClickItem(ClickItemEvent event);
    }
}
