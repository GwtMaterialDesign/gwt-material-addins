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
import gwt.material.design.incubator.client.chart.amcharts.events.object.CursorZoomStartedData;
//@formatter:off

/**
 * Dispatched when user zooms to some period. start and end are indices or time stamp (when categoryAxis.parseDates is
 * true) of selection start/end.
 *
 * @author kevzlou7979
 */
public class CursorZoomStartedEvent extends GwtEvent<CursorZoomStartedEvent.CursorZoomStartedHandler> {

    public static final Type<CursorZoomStartedHandler> TYPE = new Type<>();
    private CursorZoomStartedData data;

    public CursorZoomStartedEvent(CursorZoomStartedData data) {
        this.data = data;
    }

    public static Type<CursorZoomStartedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CursorZoomStartedData data) {
        source.fireEvent(new CursorZoomStartedEvent(data));
    }

    @Override
    public Type<CursorZoomStartedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CursorZoomStartedHandler handler) {
        handler.onZoomedEvent(this);
    }

    public CursorZoomStartedData getData() {
        return data;
    }

    public interface CursorZoomStartedHandler extends EventHandler {
        void onZoomedEvent(CursorZoomStartedEvent event);
    }
}
