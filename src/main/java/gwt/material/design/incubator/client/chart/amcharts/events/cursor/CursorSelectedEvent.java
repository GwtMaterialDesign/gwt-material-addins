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
import gwt.material.design.incubator.client.chart.amcharts.events.object.CursorSelectedData;
//@formatter:off

/**
 * Dispatched if selectWithoutZooming is set to true and when user selects some period. start and end are indices or
 * time stamp (when categoryAxis.parseDates is true) of selection start/end.
 *
 * @author kevzlou7979
 */
public class CursorSelectedEvent extends GwtEvent<CursorSelectedEvent.CursorSelectedHandler> {

    public static final Type<CursorSelectedHandler> TYPE = new Type<>();
    private CursorSelectedData data;

    public CursorSelectedEvent(CursorSelectedData data) {
        this.data = data;
    }

    public static Type<CursorSelectedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CursorSelectedData data) {
        source.fireEvent(new CursorSelectedEvent(data));
    }

    @Override
    public Type<CursorSelectedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CursorSelectedHandler handler) {
        handler.onChartCursorSelected(this);
    }

    public CursorSelectedData getData() {
        return data;
    }

    public interface CursorSelectedHandler extends EventHandler {
        void onChartCursorSelected(CursorSelectedEvent event);
    }
}
