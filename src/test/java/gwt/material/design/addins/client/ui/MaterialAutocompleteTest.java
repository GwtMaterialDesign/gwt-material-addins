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

import com.google.gwt.user.client.ui.SuggestBox;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.autocomplete.constants.AutocompleteType;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
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
        setupUserAsValues(autocomplete);
        return autocomplete;
    }

    protected static void setupUserAsValues(MaterialAutoComplete autoComplete) {
        // given
        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        autoComplete.setSuggestions(oracle);
        List<String> itemValues = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            itemValues.add("Item " + i);
        }

        // when / then
        autoComplete.setItemValues(itemValues);
        assertEquals(autoComplete.getItemValues().size(), 3);
    }

    public void testLimit() {
        // UiBinder
        // given
        MaterialAutoComplete autocomplete = getWidget(false);

        // when / then
        checkLimit(autocomplete);

        // Standard
        // given
        attachWidget();

        // when / then
        checkLimit(autocomplete);
    }

    protected void checkLimit(MaterialAutoComplete autocomplete) {
        // when / then
        autocomplete.setLimit(LIMIT);
        assertEquals(LIMIT, autocomplete.getLimit());
        autocomplete.setAutoSuggestLimit(LIMIT);
        assertEquals(LIMIT, autocomplete.getSuggestBox().getLimit());
    }

    public void testValue() {
        // UiBinder given
        MaterialAutoComplete autocomplete = getWidget(false);
        List<String> itemValues = autocomplete.getItemValues();

        // when / then
        checkValue(autocomplete, itemValues);

        // Standard
        // given
        attachWidget();

        // when / then
        checkValue(autocomplete, itemValues);
    }

    protected void checkValue(MaterialAutoComplete autocomplete, List<String> itemValues) {
        // when / then
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

    public void testTypeText() {
        MaterialAutoComplete autoComplete = new MaterialAutoComplete();
        setupUserAsValues(autoComplete);

        checkTypeText(autoComplete);
    }

    protected void checkTypeText(MaterialAutoComplete autoComplete) {
        final String SELECTED = autoComplete.getItemValues().get(0);
        autoComplete.setType(AutocompleteType.TEXT);
        assertEquals(AutocompleteType.TEXT, autoComplete.getType());
        assertTrue(autoComplete.getElement().hasClassName("autocomplete-text"));

        final boolean[] firedValueChangeEvent = {false};
        autoComplete.addValueChangeHandler(valueChangeEvent -> {
            firedValueChangeEvent[0] = true;

            assertEquals(SELECTED, autoComplete.getItemBox().getText());
        });

        List<String> selectedValue = new ArrayList<>();
        selectedValue.add(autoComplete.getItemValues().get(0));
        autoComplete.setItemValues(selectedValue, true);

        assertTrue(firedValueChangeEvent[0]);
    }

    public void testPlaceholder() {
        // UiBinder
        // given
        MaterialAutoComplete autocomplete = getWidget(false);

        // when / then
        checkPlaceholder(autocomplete);

        // Standard
        // given
        attachWidget();

        // when / then
        checkPlaceholder(autocomplete);
    }

    protected static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new User("User " + i));
        }
        return users;
    }

    @Override
    public void testTabIndex() {
        // UiBinder
        // given
        MaterialAutoComplete autoComplete = getWidget(false);
        SuggestBox widget = autoComplete.getSuggestBox();

        // when / then
        checkTabIndex(widget);

        // Standard
        // given
        attachWidget();

        // when / then
        checkTabIndex(widget);
    }

    protected void checkTabIndex(SuggestBox widget) {
        final int INITIAL_TAB_INDEX = 0;
        final int FINAL_TAB_INDEX = 1;

        // when / then
        widget.setTabIndex(INITIAL_TAB_INDEX);
        assertEquals(INITIAL_TAB_INDEX, widget.getTabIndex());
        assertEquals(String.valueOf(INITIAL_TAB_INDEX), widget.getElement().getPropertyString("tabIndex"));
        widget.setTabIndex(FINAL_TAB_INDEX);
        assertEquals(FINAL_TAB_INDEX, widget.getTabIndex());
        assertEquals(String.valueOf(FINAL_TAB_INDEX), widget.getElement().getPropertyString("tabIndex"));
    }

    @Override
    public void testKeyEvents() {
        // UiBinder
        // given
        MaterialAutoComplete autoComplete = getWidget(false);

        // when / then
        checkKeyEvents(autoComplete.getItemBox());

        // Standard
        // given
        attachWidget();

        // when / then
        checkKeyEvents(autoComplete.getItemBox());
    }

    @Override
    public void testFocusAndBlurEvents() {
        // UiBinder
        // given
        MaterialAutoComplete autoComplete = getWidget(false);

        // when / then
        checkFocusAndBlurEvents(autoComplete.getItemBox());

        // Standard
        // given
        attachWidget();

        // when / then
        checkFocusAndBlurEvents(autoComplete.getItemBox());
    }
}
