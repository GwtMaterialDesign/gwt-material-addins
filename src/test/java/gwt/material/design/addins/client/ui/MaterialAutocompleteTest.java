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
package gwt.material.design.addins.client.ui;

import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.SuggestBox;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.ui.base.AbstractValueWidgetTest;
import gwt.material.design.addins.client.ui.base.dto.User;
import gwt.material.design.addins.client.ui.base.dto.UserOracle;

import java.util.ArrayList;
import java.util.List;

/**
 * Test case for autocomplete component
 *
 * @author kevzlou7979
 */
public class MaterialAutocompleteTest extends AbstractValueWidgetTest<MaterialAutoComplete> {

    final static int LIMIT = 2;

    @Override
    protected MaterialAutoComplete createWidget() {
        return constructAndAttach();
    }

    public static MaterialAutoComplete constructAndAttach() {
        MaterialAutoComplete autocomplete = new MaterialAutoComplete();
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        autocomplete.setSuggestions(oracle);
        List<String> itemValues = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            itemValues.add("Item " + i);
        }
        autocomplete.setItemValues(itemValues);
        assertEquals(autocomplete.getItemValues().size(), 3);

        return autocomplete;
    }

    public void testLimit() {
        // given
        MaterialAutoComplete autocomplete = getWidget();

        // when / then
        autocomplete.setLimit(LIMIT);
        assertEquals(LIMIT, autocomplete.getLimit());

        // when / then
        autocomplete.setAutoSuggestLimit(LIMIT);
        assertEquals(LIMIT, autocomplete.getSuggestBox().getLimit());
    }

    public void testValue() {
        // given
        MaterialAutoComplete autocomplete = getWidget();
        List<String> itemValues = autocomplete.getItemValues();

        List<String> value = new ArrayList<>();
        value.add(itemValues.get(0));

        List<String> secondValue = new ArrayList<>();
        secondValue.add(itemValues.get(1));

        assertNotSame(secondValue, value);

        final boolean[] isValueChanged = {false};
        autocomplete.addValueChangeHandler(event -> isValueChanged[0] = true);

        autocomplete.setItemValues(value);
        assertFalse(isValueChanged[0]);

        autocomplete.setItemValues(secondValue, true);
        assertTrue(isValueChanged[0]);

        autocomplete.clear();
        assertEquals(0, autocomplete.getItemValues().size());
        autocomplete.setLimit(2);
        assertEquals(2, autocomplete.getLimit());
    }

    public void testPlaceholder() {
        MaterialAutoComplete autocomplete = getWidget();
        autocomplete.setPlaceholder("test");
        assertEquals("test", autocomplete.getPlaceholder());
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User("User " + i));
        }
        return users;
    }

    @Override
    public void testTabIndex() {
        MaterialAutoComplete autoComplete = getWidget();
        SuggestBox widget = autoComplete.getSuggestBox();

        final int INITIAL_TAB_INDEX = 0;
        final int FINAL_TAB_INDEX = 1;

        // when / then
        widget.setTabIndex(INITIAL_TAB_INDEX);
        assertEquals(INITIAL_TAB_INDEX, widget.getTabIndex());
        assertEquals(String.valueOf(INITIAL_TAB_INDEX), widget.getElement().getPropertyString("tabIndex"));

        // when / then
        widget.setTabIndex(FINAL_TAB_INDEX);
        assertEquals(FINAL_TAB_INDEX, widget.getTabIndex());
        assertEquals(String.valueOf(FINAL_TAB_INDEX), widget.getElement().getPropertyString("tabIndex"));
    }

    @Override
    public void testKeyEvents() {
        MaterialAutoComplete autoComplete = getWidget();
        super.checkKeyEvents(autoComplete.getItemBox());
    }

    @Override
    public void testFocusAndBlurEvents() {
        MaterialAutoComplete autoComplete = getWidget();
        super.checkFocusAndBlurEvents(autoComplete.getItemBox());
    }
}
