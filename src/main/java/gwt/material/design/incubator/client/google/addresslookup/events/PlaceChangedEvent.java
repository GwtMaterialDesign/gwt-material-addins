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
package gwt.material.design.incubator.client.google.addresslookup.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * This event is fired when a PlaceResult is made available for a Place the user has selected.
 * If the user enters the name of a Place that was not suggested by the control and presses the Enter key, or if a
 * Place Details request fails, the PlaceResult contains the user input in the name property, with no other
 * properties defined.
 *
 * @author kevzlou7979
 */
public class PlaceChangedEvent extends GwtEvent<PlaceChangedEvent.PlaceChangedHandler> {

    public interface PlaceChangedHandler extends EventHandler {
        void onPlaceChanged(PlaceChangedEvent event);
    }

    public static final Type<PlaceChangedHandler> TYPE = new Type<>();

    public static Type<PlaceChangedHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source) {
        source.fireEvent(new PlaceChangedEvent());
    }

    @Override
    public Type<PlaceChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(PlaceChangedHandler handler) {
        handler.onPlaceChanged(this);
    }
}