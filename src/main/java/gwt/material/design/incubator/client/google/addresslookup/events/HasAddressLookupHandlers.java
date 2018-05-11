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
