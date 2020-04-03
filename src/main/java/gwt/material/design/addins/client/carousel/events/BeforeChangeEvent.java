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
 * Before slide change callback
 *
 * @author kevzlou7979
 */
public class BeforeChangeEvent extends GwtEvent<BeforeChangeEvent.BeforeChangeHandler> {

    public interface BeforeChangeHandler extends EventHandler {
        void onBeforeChange(BeforeChangeEvent event);
    }

    private int currentSlide;
    private int nextSlide;

    public static final Type<BeforeChangeHandler> TYPE = new Type<>();

    public static Type<BeforeChangeHandler> getType() {
        return TYPE;
    }

    public BeforeChangeEvent(int currentSlide, int nextSlide) {
        this.currentSlide = currentSlide;
        this.nextSlide = nextSlide;
    }

    public static void fire(HasHandlers source, int currentSlide, int nextSlide) {
        source.fireEvent(new BeforeChangeEvent(currentSlide, nextSlide));
    }

    @Override
    public Type<BeforeChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(BeforeChangeEvent.BeforeChangeHandler handler) {
        handler.onBeforeChange(this);
    }

    public int getCurrentSlide() {
        return currentSlide;
    }

    public void setCurrentSlide(int currentSlide) {
        this.currentSlide = currentSlide;
    }

    public int getNextSlide() {
        return nextSlide;
    }

    public void setNextSlide(int nextSlide) {
        this.nextSlide = nextSlide;
    }
}
