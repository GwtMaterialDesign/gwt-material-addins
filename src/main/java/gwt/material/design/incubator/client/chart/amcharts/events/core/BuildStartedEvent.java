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
 * Fired just before the chart starts to build itself for the first time. Note: you might need to set processTimeout to
 * > 0 value in order to register this event properly.
 *
 * @author kevzlou7979
 */
public class BuildStartedEvent extends GwtEvent<BuildStartedEvent.BuildStartedHandler> {

    public static final Type<BuildStartedHandler> TYPE = new Type<>();
    private CoreData data;

    public BuildStartedEvent(CoreData data) {
        this.data = data;
    }

    public static Type<BuildStartedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, CoreData data) {
        source.fireEvent(new BuildStartedEvent(data));
    }

    @Override
    public Type<BuildStartedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BuildStartedEvent.BuildStartedHandler handler) {
        handler.onBuildStarted(this);
    }

    public CoreData getData() {
        return data;
    }

    public interface BuildStartedHandler extends EventHandler {
        void onBuildStarted(BuildStartedEvent event);
    }
}
