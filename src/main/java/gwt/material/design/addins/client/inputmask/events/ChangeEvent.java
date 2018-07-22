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
package gwt.material.design.addins.client.inputmask.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ChangeEvent<T> extends GwtEvent<ChangeEvent.ChangeHandler> {

    public static final Type<ChangeEvent.ChangeHandler> TYPE = new Type<>();
    private T result;

    public ChangeEvent(T result) {
        this.result = result;
    }

    public static void fire(HasHandlers source, Object result) {
        source.fireEvent(new ChangeEvent(result));
    }

    @Override
    public Type<ChangeEvent.ChangeHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ChangeEvent.ChangeHandler handler) {
        handler.onChange(this);
    }

    public T getResult() {
        return result;
    }

    public interface ChangeHandler extends EventHandler {
        void onChange(ChangeEvent event);
    }
}