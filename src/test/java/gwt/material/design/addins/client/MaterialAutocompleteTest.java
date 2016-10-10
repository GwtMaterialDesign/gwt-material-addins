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
package gwt.material.design.addins.client;

import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.base.MaterialAddinsTest;
import gwt.material.design.addins.client.dto.User;
import gwt.material.design.addins.client.dto.UserOracle;
import gwt.material.design.client.base.MaterialWidget;

import java.util.ArrayList;
import java.util.List;

public class MaterialAutocompleteTest extends MaterialAddinsTest {

    public void init() {
        MaterialAutoComplete autoComplete = new MaterialAutoComplete();
        checkWidget(autoComplete);
        checkPlaceholder(autoComplete);
        checkValue(autoComplete);
    }

    @Override
    protected <T extends MaterialWidget> void checkInteractionEvents(T widget, boolean enabled) {
        // TODO Specific tests for interaction events
    }

    public <T extends MaterialAutoComplete> void checkValue(T widget) {
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        widget.setSuggestions(oracle);
        List<String> itemValues = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            itemValues.add("Item " + i);
        }
        widget.setItemValues(itemValues);
        assertEquals(widget.getItemValues().size(), 3);
        widget.clear();
        assertEquals(widget.getItemValues().size(), 0);
        widget.setLimit(2);
        assertEquals(widget.getLimit(), 2);
    }

    public <T extends MaterialAutoComplete> void checkPlaceholder(T widget) {
        widget.setPlaceholder("test");
        assertEquals(widget.getPlaceholder(), "test");
    }

    protected List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User("User " + i));
        }
        return users;
    }
}
