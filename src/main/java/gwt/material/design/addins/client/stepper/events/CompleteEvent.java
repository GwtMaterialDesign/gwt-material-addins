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
package gwt.material.design.addins.client.stepper.events;


import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class CompleteEvent extends GwtEvent<CompleteEvent.CompleteHandler> {

    private int lastStep;

    public interface CompleteHandler extends EventHandler {
        void onComplete(CompleteEvent event);
    }

    public static final Type<CompleteHandler> TYPE = new Type<>();

    public CompleteEvent(int lastStep) {
        this.lastStep = lastStep;
    }

    public static void fire(HasHandlers source, int lastStep) {
        source.fireEvent(new CompleteEvent(lastStep));
    }

    @Override
    public Type<CompleteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CompleteHandler handler) {
        handler.onComplete(this);
    }

    public int getLastStep() {
        return lastStep;
    }

    public void setLastStep(int lastStep) {
        this.lastStep = lastStep;
    }
}
