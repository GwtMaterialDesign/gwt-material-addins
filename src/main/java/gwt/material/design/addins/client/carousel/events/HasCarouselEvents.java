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
package gwt.material.design.addins.client.carousel.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasCarouselEvents extends HasHandlers {

    /**
     * Fires after slide change
     */
    HandlerRegistration addAfterChangeHandler(AfterChangeEvent.AfterChangeHandler handler);

    /**
     * Fires before slide change
     */
    HandlerRegistration addBeforeChangeHandler(BeforeChangeEvent.BeforeChangeHandler handler);

    /**
     * Fires when an edge is overscrolled in non-infinite mode.
     */
    HandlerRegistration addEdgeHandler(EdgeEvent.EdgeHandler handler);

    /**
     * Fires after image loads lazily
     */
    HandlerRegistration addLazyLoadedErrorHandler(LazyLoadedErrorEvent.LazyLoadedErrorHandler handler);

    /**
     * Fires after image loads lazily
     */
    HandlerRegistration addLazyLoadedHandler(LazyLoadedEvent.LazyLoadedHandler handler);

    /**
     * Every time Slick (re-)initializes callback
     */
    HandlerRegistration addReInitHandler(ReInitEvent.ReInitHandler handler);

    /**
     * Every time Slick recalculates position
     */
    HandlerRegistration addSetPositionHandler(SetPositionEvent.SetPositionHandler handler);

    /**
     * Fires after first initialization.
     */
    HandlerRegistration addInitHandler(InitEvent.InitHandler handler);

    /**
     * When slider is destroyed, or unslicked.
     */
    HandlerRegistration addDestroyHandler(DestroyEvent.DestroyHandler handler);

    /**
     * Fires after swipe/drag
     */
    HandlerRegistration addSwipeHandler(SwipeEvent.SwipeHandler handler);


}
