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
import gwt.material.design.incubator.client.chart.amcharts.events.object.AxisGuideEventData;
//@formatter:off

/**
 * Dispatched when user clicks on a guide.
 *
 * @author kevzlou7979
 */
public class ClickGuideEvent extends GwtEvent<ClickGuideEvent.ClickGuideHandler> {

    public static final Type<ClickGuideHandler> TYPE = new Type<>();
    private AxisGuideEventData data;

    public ClickGuideEvent(AxisGuideEventData data) {
        this.data = data;
    }

    public static Type<ClickGuideHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, AxisGuideEventData data) {
        source.fireEvent(new ClickGuideEvent(data));
    }

    @Override
    public Type<ClickGuideHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClickGuideEvent.ClickGuideHandler handler) {
        handler.onClickGuide(this);
    }

    public AxisGuideEventData getData() {
        return data;
    }

    public interface ClickGuideHandler extends EventHandler {
        void onClickGuide(ClickGuideEvent event);
    }
}
