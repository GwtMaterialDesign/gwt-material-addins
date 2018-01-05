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
import gwt.material.design.incubator.client.chart.amcharts.events.object.CursorPanningData;
//@formatter:off

/**
 * Dispatched when user pans the chart (also when user pinch-zooms the chart). deltaX, deltaY, delta2X, delta2Y are
 * relative values. delta2X and delta2Y has values when pinching with two fingers.
 *
 * @author kevzlou7979
 */
public class CursorPanningEvent extends GwtEvent<CursorPanningEvent.CursorPanningHandler> {

    public static final Type<CursorPanningHandler> TYPE = new Type<>();
    private CursorPanningData data;

    public CursorPanningEvent(CursorPanningData data) {
        this.data = data;
    }

    public static Type<CursorPanningHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CursorPanningData data) {
        source.fireEvent(new CursorPanningEvent(data));
    }

    @Override
    public Type<CursorPanningHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CursorPanningHandler handler) {
        handler.onChartCursorPanning(this);
    }

    public CursorPanningData getData() {
        return data;
    }

    public interface CursorPanningHandler extends EventHandler {
        void onChartCursorPanning(CursorPanningEvent event);
    }
}
