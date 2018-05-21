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
package gwt.material.design.incubator.client.google.addresslookup.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasAddressLookupHandlers {

    /**
     * This event is fired when a PlaceResult is made available for a Place the user has selected.
     * If the user enters the name of a Place that was not suggested by the control and presses the Enter key, or if a
     * Place Details request fails, the PlaceResult contains the user input in the name property, with no other
     * properties defined.
     */
    HandlerRegistration addPlaceChangedHandler(PlaceChangedEvent.PlaceChangedHandler handler);
}
