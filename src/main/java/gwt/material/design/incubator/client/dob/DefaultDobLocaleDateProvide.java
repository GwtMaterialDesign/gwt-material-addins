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
package gwt.material.design.incubator.client.dob;

import java.util.HashMap;
import java.util.Map;

public class DefaultDobLocaleDateProvide implements DobLocaleDateProvide {
    @Override
    public Map<Integer, String> get() {
        Map<Integer, String> months = new HashMap<>();
        months.put(0, "January");
        months.put(1, "February");
        months.put(2, "March");
        months.put(3, "April");
        months.put(4, "May");
        months.put(5, "June");
        months.put(6, "July");
        months.put(7, "August");
        months.put(8, "September");
        months.put(9, "October");
        months.put(10, "November");
        months.put(11, "December");
        return months;
    }

    @Override
    public String getMonthLabel() {
        return "Month";
    }

    @Override
    public String getDayLabel() {
        return "Day";
    }

    @Override
    public String getYearLabel() {
        return "Year";
    }

    @Override
    public String getInvalidMonthMessage() {
        return "Invalid Month value";
    }

    @Override
    public String getInvalidDayMessage() {
        return "Invalid Day value";
    }

    @Override
    public String getInvalidYearLabel() {
        return "Invalid Year value";
    }
}
