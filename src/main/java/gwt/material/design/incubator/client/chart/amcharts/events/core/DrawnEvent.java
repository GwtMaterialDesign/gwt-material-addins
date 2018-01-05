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
package gwt.material.design.incubator.client.chart.amcharts.events.core;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.chart.amcharts.events.object.CoreData;
//@formatter:off

/**
 * Fired every time chart is drawn or re-drawn - graph toggle, chart area resize, etc.
 * <p>
 * Please note, that this event will not fire on zoom. Use "zoomed" event instead to catch those events.
 *
 * @author kevzlou7979
 */
public class DrawnEvent extends GwtEvent<DrawnEvent.DrawnHandler> {

    public static final Type<DrawnHandler> TYPE = new Type<>();
    private CoreData data;

    public DrawnEvent(CoreData data) {
        this.data = data;
    }

    public static Type<DrawnHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoreData data) {
        source.fireEvent(new DrawnEvent(data));
    }

    @Override
    public Type<DrawnHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DrawnEvent.DrawnHandler handler) {
        handler.onDrawn(this);
    }

    public CoreData getData() {
        return data;
    }

    public interface DrawnHandler extends EventHandler {
        void onDrawn(DrawnEvent event);
    }
}
