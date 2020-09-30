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
package gwt.material.design.addins.client.iconmorph;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class IconMorphedEvent extends GwtEvent<IconMorphedEvent.IconMorphedHandler> {

    protected boolean morphed;

    public IconMorphedEvent(boolean morphed) {
        this.morphed = morphed;
    }

    public interface IconMorphedHandler extends EventHandler {
        void onIconMorphed(IconMorphedEvent event);
    }

    public static final Type<IconMorphedHandler> TYPE = new Type<>();

    public static void fire(HasHandlers source, boolean morphed) {
        source.fireEvent(new IconMorphedEvent(morphed));
    }

    @Override
    public Type<IconMorphedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(IconMorphedHandler handler) {
        handler.onIconMorphed(this);
    }

    public boolean isMorphed() {
        return morphed;
    }

    public void setMorphed(boolean morphed) {
        this.morphed = morphed;
    }
}
