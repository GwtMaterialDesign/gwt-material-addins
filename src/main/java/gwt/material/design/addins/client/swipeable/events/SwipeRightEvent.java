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
/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package gwt.material.design.addins.client.swipeable.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.swipeable.base.HasSwipeableHandler;

/**
 * Represents a swipe right event.
 *
 * @param <T> the type being swiped to right
 * @author kevzlou7979
 */
public class SwipeRightEvent<T> extends GwtEvent<SwipeRightEvent.SwipeRightHandler<T>> {

    private static Type<SwipeRightHandler<?>> TYPE;

    public interface SwipeRightHandler<T> extends EventHandler {
        void onSwipeRight(SwipeRightEvent<T> event);
    }

    public static <T> void fire(HasSwipeableHandler<T> source, T target) {
        if (TYPE != null) {
            SwipeRightEvent<T> event = new SwipeRightEvent<T>(target);
            source.fireEvent(event);
        }
    }

    public static Type<SwipeRightHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    private final T target;

    protected SwipeRightEvent(T target) {
        this.target = target;
    }

    @Override
    public final Type<SwipeRightHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    @Override
    protected void dispatch(SwipeRightHandler<T> handler) {
        handler.onSwipeRight(this);
    }
}
