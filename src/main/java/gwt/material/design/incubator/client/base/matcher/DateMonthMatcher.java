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
package gwt.material.design.incubator.client.base.matcher;

import gwt.material.design.addins.client.combobox.js.options.Data;
import gwt.material.design.addins.client.combobox.js.options.Params;
import gwt.material.design.jquery.client.api.Functions;

public class DateMonthMatcher {

    public static Functions.FuncRet2<Params, Data> getDefaultMonthMatcher() {
        return (params, data) -> {
            // If there are no search terms, return all of the data
            if (params == null || params.term == null) {
                return data;
            }

            // Do not display the item if there is no 'text' property
            if (data.text == null) {
                return null;
            }

            // Will do an advance month searching using index
            Integer i = null;
            try {
                i = Integer.parseInt(params.term);
            } catch (NumberFormatException e) {
                // Do nothing
            }

            if (data.text.toLowerCase().contains(params.term.toLowerCase()) || (i != null && data.id == i - 1)) {
                return data;
            }
            return null;
        };
    }
}
