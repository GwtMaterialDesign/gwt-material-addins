/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.infinitescroll.data.DataSource;
//@formatter:off

/**
 * Fired whenever we pulled all the data provided in datasource.
 *
 * @author kevzlou7979
 */
public class CompleteEvent extends GwtEvent<CompleteEvent.CompleteHandler> {

    public static final Type<CompleteHandler> TYPE = new Type<>();

    private int total;

    public CompleteEvent(int total) {
        this.total = total;
    }

    public static Type<CompleteHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, int total) {
        source.fireEvent(new CompleteEvent(total));
    }

    @Override
    public Type<CompleteHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CompleteHandler handler) {
        handler.onComplete(this);
    }

    public int getTotal() {
        return total;
    }

    public interface CompleteHandler extends EventHandler {
        void onComplete(CompleteEvent event);
    }
}
