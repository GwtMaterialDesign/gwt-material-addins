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
import gwt.material.design.incubator.client.daterange.js.JsDateRangePicker;

/**
 *  Triggered when the apply button is clicked, or when a predefined range is clicked
 *
 * @author kevzlou7979
 */
public class ApplyEvent extends GwtEvent<ApplyEvent.ApplyEventHandler> {

    public interface ApplyEventHandler extends EventHandler {
        void onApplyEvent(ApplyEvent event);
    }

    public static final Type<ApplyEventHandler> TYPE = new Type<>();

    private JsDateRangePicker dateRange;

    public ApplyEvent(JsDateRangePicker dateRange) {
        this.dateRange = dateRange;
    }

    public static Type<ApplyEventHandler> getType() {
        return TYPE;
    }

    public static void fire(HasHandlers source, JsDateRangePicker dateRange) {
        source.fireEvent(new ApplyEvent(dateRange));
    }

    public JsDateRangePicker getDateRange() {
        return dateRange;
    }

    @Override
    public Type<ApplyEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ApplyEvent.ApplyEventHandler handler) {
        handler.onApplyEvent(this);
    }
}
