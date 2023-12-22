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
import gwt.material.design.addins.client.sprout.js.SwitchData;

public class SwitchVideoEvent extends GwtEvent<SwitchVideoEvent.SwitchVideoHandler> {

    public interface SwitchVideoHandler extends EventHandler {
        void onSwitchVideo(SwitchVideoEvent event);
    }

    private SwitchData data;
    public static final Type<SwitchVideoHandler> TYPE = new Type<>();

    public SwitchVideoEvent(SwitchData data) {
        this.data = data;
    }

    public static void fire(SwitchData data, HasHandlers source) {
        source.fireEvent(new SwitchVideoEvent(data));
    }

    @Override
    public Type<SwitchVideoHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SwitchVideoHandler handler) {
        handler.onSwitchVideo(this);
    }

    public SwitchData getData() {
        return data;
    }
}