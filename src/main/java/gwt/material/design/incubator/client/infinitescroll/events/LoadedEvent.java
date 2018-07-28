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
package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import java.util.List;
//@formatter:off

/**
 * @author kevzlou7979
 */
public class LoadedEvent<T> extends GwtEvent<LoadedEvent.LoadHandler<T>> {

    private List<T> data;
    private static Type<LoadHandler<?>> TYPE;

    public LoadedEvent(List<T> data) {
        this.data = data;
    }

    public static void fire(HasHandlers source, List<?> data) {
        source.fireEvent(new LoadedEvent(data));
    }

    @Override
    public final Type<LoadHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public static Type<LoadHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    @Override
    protected void dispatch(LoadHandler handler) {
        handler.onItemLoaded(this);
    }

    public List<T> getData() {
        return data;
    }

    public interface LoadHandler<T> extends EventHandler {
        void onItemLoaded(LoadedEvent<T> event);
    }
}
