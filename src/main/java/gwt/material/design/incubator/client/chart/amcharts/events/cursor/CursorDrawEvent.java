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
package gwt.material.design.incubator.client.chart.amcharts.events.cursor;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.DrawData;
//@formatter:off

/**
 * Dispatched when user draws a trend line with mouse.
 *
 * @author kevzlou7979
 */
public class CursorDrawEvent extends GwtEvent<CursorDrawEvent.CursorDrawHandler> {

    public static final Type<CursorDrawHandler> TYPE = new Type<>();
    private DrawData data;

    public CursorDrawEvent(DrawData data) {
        this.data = data;
    }

    public static Type<CursorDrawHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, DrawData data) {
        source.fireEvent(new CursorDrawEvent(data));
    }

    @Override
    public Type<CursorDrawHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CursorDrawHandler handler) {
        handler.onChartCursorChanged(this);
    }

    public DrawData getData() {
        return data;
    }

    public interface CursorDrawHandler extends EventHandler {
        void onChartCursorChanged(CursorDrawEvent event);
    }
}
