/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.addins.client.combobox.events;

import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.combobox.base.HasUnselectItemHandler;
import gwt.material.design.client.events.ClearEvent;
import gwt.material.design.client.events.ClearingEvent;
import gwt.material.design.client.events.ClosingEvent;
import gwt.material.design.client.events.OpeningEvent;

public interface HasComboBoxHandlers<T> extends HasOpenHandlers<T>, HasCloseHandlers<T>, HasUnselectItemHandler<T> {

    HandlerRegistration addOpeningHandler(OpeningEvent.OpeningHandler handler);
    HandlerRegistration addClosingHandler(ClosingEvent.ClosingHandler handler);
    HandlerRegistration addClearHandler(ClearEvent.ClearHandler handler);
    HandlerRegistration addClearingHandler(ClearingEvent.ClearingHandler handler);
}
