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
package gwt.material.design.addins.client.fileuploader.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import gwt.material.design.addins.client.fileuploader.base.HasFileUploadHandlers;

public class ThumbnailEvent<T> extends GwtEvent<ThumbnailEvent.ThumbnailHandler<T>> {

    private final T target;
    private String dataUrl;

    protected ThumbnailEvent(T target, String dataUrl) {
        this.target = target;
        this.dataUrl = dataUrl;
    }

    @Override
    public final Type<ThumbnailHandler<T>> getAssociatedType() {
        return (Type) TYPE;
    }

    public T getTarget() {
        return target;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    @Override
    protected void dispatch(ThumbnailHandler<T> handler) {
        handler.onThumbnail(this);
    }

    private static Type<ThumbnailHandler<?>> TYPE;

    public interface ThumbnailHandler<T> extends EventHandler {
        void onThumbnail(ThumbnailEvent<T> event);
    }

    public static <T> void fire(HasFileUploadHandlers<T> source, T target, String dataUrl) {
        if (TYPE != null) {
            ThumbnailEvent<T> event = new ThumbnailEvent<T>(target, dataUrl);
            source.fireEvent(event);
        }
    }

    public static Type<ThumbnailHandler<?>> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }
}
