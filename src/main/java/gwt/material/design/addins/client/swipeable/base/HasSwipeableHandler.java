/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.swipeable.base;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.addins.client.swipeable.events.*;

/**
 * @author kevzlou7979
 */
public interface HasSwipeableHandler<T> extends HasHandlers {

    /**
     * Add swipe left handler.
     */
    HandlerRegistration addSwipeLeftHandler(SwipeLeftEvent.SwipeLeftHandler<T> handler);

    /**
     * Add swipe right handler.
     */
    HandlerRegistration addSwipeRightHandler(SwipeRightEvent.SwipeRightHandler<T> handler);

    /**
     * Add on start swipe left handler.
     */
    HandlerRegistration addOnStartSwipeLeftHandler(OnStartSwipeLeftEvent.OnStartSwipeLeftHandler<T> handler);

    /**
     * Add on start swipe right handler.
     */
    HandlerRegistration addOnStartSwipeRightHandler(OnStartSwipeRightEvent.OnStartSwipeRightHandler<T> handler);

    /**
     *  Add on end swipe left handler.
     */
    HandlerRegistration addOnEndSwipeLeftHandler(OnEndSwipeLeftEvent.OnEndSwipeLeftHandler<T> handler);

    /**
     *  Add on end swipe right handler.
     */
    HandlerRegistration addOnEndSwipeRightHandler(OnEndSwipeRightEvent.OnEndSwipeRightHandler<T> handler);

}
