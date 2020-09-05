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
 * Fires after image loads lazily
 *
 * @author kevzlou7979
 */
public class LazyLoadedErrorEvent extends GwtEvent<LazyLoadedErrorEvent.LazyLoadedErrorHandler> {

    public interface LazyLoadedErrorHandler extends EventHandler {
        void onLazyLoadedError(LazyLoadedErrorEvent event);
    }

    private Object image;
    private Object imageSource;

    public static final Type<LazyLoadedErrorHandler> TYPE = new Type<>();

    public static Type<LazyLoadedErrorHandler> getType() {
        return TYPE;
    }

    public LazyLoadedErrorEvent(Object image, Object imageSource) {
        this.image = image;
        this.imageSource = imageSource;
    }

    public static void fire(HasHandlers source, Object image, Object imageSource) {
        source.fireEvent(new LazyLoadedErrorEvent(image, imageSource));
    }

    @Override
    public Type<LazyLoadedErrorHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LazyLoadedErrorEvent.LazyLoadedErrorHandler handler) {
        handler.onLazyLoadedError(this);
    }

    public Object getImage() {
        return image;
    }

    public Object getImageSource() {
        return imageSource;
    }
}
