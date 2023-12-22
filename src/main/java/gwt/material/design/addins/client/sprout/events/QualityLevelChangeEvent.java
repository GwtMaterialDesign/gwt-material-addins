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

public class QualityLevelChangeEvent extends GwtEvent<QualityLevelChangeEvent.QualityLevelChangeHandler> {

    public interface QualityLevelChangeHandler extends EventHandler {
        void onQualityLevelChange(QualityLevelChangeEvent event);
    }

    private int value;
    public static final Type<QualityLevelChangeHandler> TYPE = new Type<>();

    public QualityLevelChangeEvent(int value) {
        this.value = value;
    }

    public static void fire(int value, HasHandlers source) {
        source.fireEvent(new QualityLevelChangeEvent(value));
    }

    @Override
    public Type<QualityLevelChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(QualityLevelChangeHandler handler) {
        handler.onQualityLevelChange(this);
    }

    public int getValue() {
        return value;
    }
}