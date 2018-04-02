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

public class InvalidEvent<T> extends GwtEvent<InvalidEvent.InvalidHandler> {

    public static final Type<InvalidEvent.InvalidHandler> TYPE = new Type<>();
    private T result;
    private String error;

    public InvalidEvent(T result, String error) {
        this.result = result;
        this.error = error;
    }

    public static void fire(HasHandlers source, Object result, String error) {
        source.fireEvent(new InvalidEvent(result, error));
    }

    @Override
    public Type<InvalidEvent.InvalidHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(InvalidEvent.InvalidHandler handler) {
        handler.onInvalid(this);
    }

    public T getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public interface InvalidHandler extends EventHandler {
        void onInvalid(InvalidEvent event);
    }
}