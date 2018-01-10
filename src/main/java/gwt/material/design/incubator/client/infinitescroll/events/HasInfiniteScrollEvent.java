package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasInfiniteScrollEvent {

    HandlerRegistration addLoadHandler(LoadEvent.LoadHandler handler);
}
