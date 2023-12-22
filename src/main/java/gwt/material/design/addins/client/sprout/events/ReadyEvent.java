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
import gwt.material.design.addins.client.sprout.js.ReadyData;

public class ReadyEvent extends GwtEvent<ReadyEvent.ReadyHandler> {

    public interface ReadyHandler extends EventHandler {
        void onReady(ReadyEvent event);
    }

    private ReadyData data;
    public static final Type<ReadyHandler> TYPE = new Type<>();

    public ReadyEvent(ReadyData data) {
        this.data = data;
    }

    public static void fire(ReadyData data, HasHandlers source) {
        source.fireEvent(new ReadyEvent(data));
    }

    @Override
    public Type<ReadyHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ReadyHandler handler) {
        handler.onReady(this);
    }

    public ReadyData getData() {
        return data;
    }
}