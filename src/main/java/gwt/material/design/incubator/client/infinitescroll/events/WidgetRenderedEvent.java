/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;
//@formatter:off

/**
 * Fired whenever the list of widget is rendered by batch
 * @author kevzlou7979
 */
public class WidgetRenderedEvent<T> extends GwtEvent<WidgetRenderedEvent.WidgetsRenderedHandler<T>> {

    private List<Widget> widgets;
    private static Type<WidgetsRenderedHandler<?>> TYPE;

    public WidgetRenderedEvent(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public static void fire(HasHandlers source, List<Widget> result) {
        source.fireEvent(new WidgetRenderedEvent(result));
    }

    @Override
    public final Type<WidgetsRenderedHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public static Type<WidgetsRenderedHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    @Override
    protected void dispatch(WidgetsRenderedHandler handler) {
        handler.onWidgetsRendered(this);
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public interface WidgetsRenderedHandler<T> extends EventHandler {
        void onWidgetsRendered(WidgetRenderedEvent<T> event);
    }
}
