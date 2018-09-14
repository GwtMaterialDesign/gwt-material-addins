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
package gwt.material.design.addins.client.circularprogress.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Fires when the circular progress is on queuing phase.
 *
 * @author kevzlou7979
 */
public class ProgressEvent extends GwtEvent<ProgressEvent.ProgressHandler> {

    public interface ProgressHandler extends EventHandler {
        void onProgress(ProgressEvent event);
    }

    public static final Type<ProgressHandler> TYPE = new Type<>();

    private final double progress;
    private final double value;

    public ProgressEvent(double progress, double value) {
        this.progress = progress;
        this.value = value;
    }

    public static void fire(HasHandlers source, double progress, double value) {
        source.fireEvent(new ProgressEvent(progress, value));
    }

    public double getProgress() {
        return progress;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Type<ProgressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ProgressHandler handler) {
        handler.onProgress(this);
    }
}