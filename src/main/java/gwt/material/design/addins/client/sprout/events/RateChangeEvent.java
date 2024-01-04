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
package gwt.material.design.addins.client.sprout.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class RateChangeEvent extends GwtEvent<RateChangeEvent.RateChangeHandler> {

    public interface RateChangeHandler extends EventHandler {
        void onRateChange(RateChangeEvent event);
    }

    private float value;
    public static final Type<RateChangeHandler> TYPE = new Type<>();

    public RateChangeEvent(float value) {
        this.value = value;
    }

    public static void fire(float value, HasHandlers source) {
        source.fireEvent(new RateChangeEvent(value));
    }

    @Override
    public Type<RateChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RateChangeHandler handler) {
        handler.onRateChange(this);
    }

    public float getValue() {
        return value;
    }
}