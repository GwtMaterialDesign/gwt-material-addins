package gwt.material.design.addins.client.fileuploader.events;

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


import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class TotalUploadProgressEvent extends GwtEvent<TotalUploadProgressEvent.TotalUploadProgressHandler> {

    public interface TotalUploadProgressHandler extends EventHandler {
        void onTotalUploadProgress(TotalUploadProgressEvent event);
    }

    public static final Type<TotalUploadProgressHandler> TYPE = new Type<>();

    private final double progress;

    public TotalUploadProgressEvent(double progress) {
        this.progress = progress;
    }

    public static void fire(HasHandlers source, double progress) {
        source.fireEvent(new TotalUploadProgressEvent(progress));
    }

    public double getProgress() {
        return progress;
    }

    @Override
    public Type<TotalUploadProgressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(TotalUploadProgressHandler handler) {
        handler.onTotalUploadProgress(this);
    }
}