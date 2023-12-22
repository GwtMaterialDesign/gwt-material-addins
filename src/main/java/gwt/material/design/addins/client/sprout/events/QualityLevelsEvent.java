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

public class QualityLevelsEvent extends GwtEvent<QualityLevelsEvent.QualityLevelsHandler> {

    public interface QualityLevelsHandler extends EventHandler {
        void onQualityLevels(QualityLevelsEvent event);
    }

    public static final Type<QualityLevelsHandler> TYPE = new Type<>();

    public static void fire(HasHandlers source) {
        source.fireEvent(new QualityLevelsEvent());
    }

    @Override
    public Type<QualityLevelsHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(QualityLevelsHandler handler) {
        handler.onQualityLevels(this);
    }
}