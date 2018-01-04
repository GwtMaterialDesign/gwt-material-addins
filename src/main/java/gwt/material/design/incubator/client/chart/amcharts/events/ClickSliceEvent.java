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
import gwt.material.design.incubator.client.chart.amcharts.events.object.SliceEventData;
//@formatter:off

/**
 * Dispatched when user clicks on a slice. Event is an instance of original mouse event.
 *
 * @author kevzlou7979
 */
public class ClickSliceEvent extends GwtEvent<ClickSliceEvent.ClickSliceHandler> {

    public static final Type<ClickSliceHandler> TYPE = new Type<>();
    private SliceEventData data;

    public ClickSliceEvent(SliceEventData data) {
        this.data = data;
    }

    public static Type<ClickSliceHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, SliceEventData data) {
        source.fireEvent(new ClickSliceEvent(data));
    }

    @Override
    public Type<ClickSliceHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClickSliceHandler handler) {
        handler.onClickSliceEvent(this);
    }

    public SliceEventData getData() {
        return data;
    }

    public interface ClickSliceHandler extends EventHandler {
        void onClickSliceEvent(ClickSliceEvent event);
    }
}
