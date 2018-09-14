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

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Swipe Event for Carousel component
 *
 * @author kevzlou7979
 */
public class SwipeEvent extends GwtEvent<SwipeEvent.SwipeHandler> {

    public interface SwipeHandler extends EventHandler {
        void onSwipe(SwipeEvent event);
    }

    private String direction;

    public static final Type<SwipeHandler> TYPE = new Type<>();

    public static Type<SwipeHandler> getType() {
        return TYPE;
    }

    public SwipeEvent(String direction) {
        this.direction = direction;
    }

    public static void fire(HasHandlers source, String direction) {
        source.fireEvent(new SwipeEvent(direction));
    }

    @Override
    public Type<SwipeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SwipeEvent.SwipeHandler handler) {
        handler.onSwipe(this);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
