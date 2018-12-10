/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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
package gwt.material.design.incubator.client.daterange.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import gwt.material.design.incubator.client.daterange.js.JsDateRange;

/**
 *  Triggered when the Next button is pressed to proceed to the next calendar
 *
 * @author kevzlou7979
 */
public class NextEvent extends GwtEvent<NextEvent.NextEventHandler> {

    public interface NextEventHandler extends EventHandler {
        void onNextEvent(NextEvent event);
    }

    public static final Type<NextEventHandler> TYPE = new Type<>();

    private JsDateRange dateRange;

    public NextEvent(JsDateRange dateRange) {
        this.dateRange = dateRange;
    }

    public static Type<NextEventHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, JsDateRange dateRange) {
        source.fireEvent(new NextEvent(dateRange));
    }

    public JsDateRange getDateRange() {
        return dateRange;
    }

    @Override
    public Type<NextEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(NextEvent.NextEventHandler handler) {
        handler.onNextEvent(this);
    }
}
