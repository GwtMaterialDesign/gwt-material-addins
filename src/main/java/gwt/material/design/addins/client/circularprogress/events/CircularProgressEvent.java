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

public class CircularProgressEvent extends GwtEvent<CircularProgressEvent.CircularProgressHandler> {

    public interface CircularProgressHandler extends EventHandler {
        void onCircularProgress(CircularProgressEvent event);
    }

    public static final Type<CircularProgressHandler> TYPE = new Type<>();

    private final double progress;
    private final double step;

    public CircularProgressEvent(double progress, double step) {
        this.progress = progress;
        this.step = step;
    }

    public static void fire(HasHandlers source, double progress, double step) {
        source.fireEvent(new CircularProgressEvent(progress, step));
    }

    public double getProgress() {
        return progress;
    }

    public double getStep() {
        return step;
    }

    @Override
    public Type<CircularProgressHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CircularProgressHandler handler) {
        handler.onCircularProgress(this);
    }
}