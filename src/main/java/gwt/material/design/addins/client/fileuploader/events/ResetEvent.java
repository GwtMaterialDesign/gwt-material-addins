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

public class ResetEvent extends GwtEvent<ResetEvent.ResetHandler> {

    private static Type<ResetHandler> TYPE;

    protected ResetEvent() {
    }

    public static void fire(HasFileUploadHandlers source) {
        if (TYPE != null) {
            ResetEvent event = new ResetEvent();
            source.fireEvent(event);
        }
    }

    public static Type<ResetHandler> getType() {
        return TYPE != null ? TYPE : (TYPE = new Type<>());
    }

    @Override
    public final Type<ResetHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ResetHandler handler) {
        handler.onReset(this);
    }

    public interface ResetHandler extends EventHandler {
        void onReset(ResetEvent event);
    }
}
