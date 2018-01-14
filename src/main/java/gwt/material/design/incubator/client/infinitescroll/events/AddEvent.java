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
//@formatter:off

/**
 * @author kevzlou7979
 */
public class AddEvent extends GwtEvent<AddEvent.AddHandler> {

    public static final Type<AddHandler> TYPE = new Type<>();

    public AddEvent() {}

    public static Type<AddHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new AddEvent());
    }

    @Override
    public Type<AddHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddHandler handler) {
        handler.onChartEnter(this);
    }

    public interface AddHandler extends EventHandler {
        void onChartEnter(AddEvent event);
    }
}
