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
package gwt.material.design.incubator.client.daterange.events;

public interface DateRangeEvents {

    String OPEN = "show.daterangepicker";
    String CLOSE = "hide.daterangepicker";
    String OPEN_CALENDAR = "showCalendar.daterangepicker";
    String CLOSE_CALENDAR = "hideCalendar.daterangepicker";
    String APPLY = "apply.daterangepicker";
    String CANCEL = "cancel.daterangepicker";
    String SELECT = "selectDate.daterangepicker";
    String UPDATE_CALENDAR = "updateCalendar.daterangepicker";
    String NEXT = "next.daterangepicker";
    String PREV = "prev.daterangepicker";
    String TIME_CHANGED = "timeChanged.daterangepicker";
}
