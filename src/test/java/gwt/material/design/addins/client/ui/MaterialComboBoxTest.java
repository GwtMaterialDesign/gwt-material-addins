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

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.combobox.events.SelectItemEvent;
import gwt.material.design.addins.client.combobox.events.UnselectItemEvent;
import gwt.material.design.addins.client.combobox.js.JsComboBox;
import gwt.material.design.addins.client.ui.base.AbstractValueWidgetTest;
import gwt.material.design.addins.client.ui.base.dto.User;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.client.ui.html.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;


/**
 * Test case for combobox component
 *
 * @author kevzlou7979
 */
public class MaterialComboBoxTest extends AbstractValueWidgetTest<MaterialComboBox<User>> {

    @Override
    protected MaterialComboBox createWidget() {
        MaterialComboBox<String> comboBox = new MaterialComboBox<>();
        for (int i = 1; i <= 5; i++) {
            Option option = comboBox.addItem(String.valueOf(i), String.valueOf(i));
            assertNotNull(option);
        }
        return comboBox;
    }

    public void testEmptyOrNullValue() {
        // given
        MaterialComboBox<User> comboBox = getWidget();

        // when / then
        comboBox.clear();
        assertNotNull(comboBox.getValue());
        assertEquals(0, comboBox.getValue().size());
        assertNotNull(comboBox.getValues());
        assertEquals(0, comboBox.getValues().size());
        assertNotNull(comboBox.getSelectedValue());
        assertEquals(0, comboBox.getSelectedValue().size());
        assertNull(comboBox.getSingleValue());
    }

    @Override
    public void testColor() {
        super.testColor();

        // given
        MaterialComboBox<User> comboBox = getWidget();

        // when / then
        comboBox.setTextColor(Color.RED);
        assertEquals(Color.RED, comboBox.getTextColor());
    }

    public void testProperties() {
        // given
        MaterialComboBox<User> comboBox = getWidget();

        // when / then
        comboBox.setReadOnly(true);
        assertTrue(comboBox.isReadOnly());
        comboBox.setReadOnly(false);
        assertFalse(comboBox.isReadOnly());
        comboBox.setMultiple(true);
        assertTrue(comboBox.isMultiple());
        comboBox.setMultiple(false);
        assertFalse(comboBox.isMultiple());
        comboBox.setToggleReadOnly(true);
        assertTrue(comboBox.isToggleReadOnly());
        comboBox.setToggleReadOnly(false);
        assertFalse(comboBox.isToggleReadOnly());
        List<User> users = new ArrayList<>();
        users.add(new User());
        comboBox.addItems(users);
        comboBox.setHideSearch(true);
        assertTrue(comboBox.isHideSearch());
        comboBox.setLimit(10);
        assertEquals(10, comboBox.getLimit());
        comboBox.setLabel("label");
        assertEquals("label", comboBox.getLabel().getText());
        comboBox.setPlaceholder("placeholder");
        assertEquals("placeholder", comboBox.getPlaceholder());
        comboBox.setTags(true);
        assertTrue(comboBox.isTags());
        comboBox.setTags(false);
        assertFalse(comboBox.isTags());

        // given
        final String BODY_SELECTOR = "body";

        // when / then
        comboBox.setDropdownParent(BODY_SELECTOR);
        assertEquals($(BODY_SELECTOR).html(), comboBox.getDropdownParent().html());

        // given
        comboBox.setId("my-combo");
        final String SELF_SELECTOR = "#" + comboBox.getElement().getId();

        // when / then
        comboBox.setDropdownParent(SELF_SELECTOR);
        assertEquals($(SELF_SELECTOR).html(), comboBox.getDropdownParent().html());
    }

    public void testEvents() {
        // given
        MaterialComboBox comboBox = getWidget();

        // when / then
        comboBox.setEnabled(true);
        // Open Handler
        checkOpenHandler(comboBox);
        // Close Handler
        checkCloseHandler(comboBox);
        // Remove Item Handler
        final boolean[] isRemoveItemEvent = {false};
        comboBox.addRemoveItemHandler(event -> isRemoveItemEvent[0] = true);
        comboBox.fireEvent(new GwtEvent<UnselectItemEvent.UnselectComboHandler<?>>() {
            @Override
            public Type<UnselectItemEvent.UnselectComboHandler<?>> getAssociatedType() {
                return UnselectItemEvent.getType();
            }

            @Override
            protected void dispatch(UnselectItemEvent.UnselectComboHandler<?> eventHandler) {
                eventHandler.onUnselectItem(null);
            }
        });
        assertTrue(isRemoveItemEvent[0]);
        // Selection Handler
        final boolean[] isSelectionEvent = {false};
        comboBox.addSelectionHandler(event -> {
            isSelectionEvent[0] = true;
        });
        comboBox.fireEvent(new GwtEvent<SelectItemEvent.SelectComboHandler<?>>() {
            @Override
            public Type<SelectItemEvent.SelectComboHandler<?>> getAssociatedType() {
                return SelectItemEvent.getType();
            }

            @Override
            protected void dispatch(SelectItemEvent.SelectComboHandler<?> eventHandler) {
                eventHandler.onSelectItem(null);
            }
        });
        assertTrue(isSelectionEvent[0]);
        // Value Change Handler
        final boolean[] isValueChangeEvent = {false};
        comboBox.addValueChangeHandler(event -> {
            isValueChangeEvent[0] = true;
        });
        comboBox.fireEvent(new GwtEvent<ValueChangeHandler<?>>() {
            @Override
            public Type<ValueChangeHandler<?>> getAssociatedType() {
                return ValueChangeEvent.getType();
            }

            @Override
            protected void dispatch(ValueChangeHandler<?> eventHandler) {
                eventHandler.onValueChange(null);
            }
        });
        assertTrue(isValueChangeEvent[0]);
    }

    @Override
    public void testEnabled() {
        // given
        MaterialComboBox<User> comboBox = getWidget();

        // when / then
        super.checkEnabled(comboBox, comboBox.getListbox());
    }

    public void testAddItemOption() {
        // given
        MaterialComboBox<String> comboBox = new MaterialComboBox<>();
        RootPanel.get().add(comboBox);

        // when / then
        // Check Initial children
        assertEquals(0, comboBox.getValues().size());
        assertEquals(2, comboBox.getChildren().size());
        // Check simple String object
        for (int i = 1; i <= 5; i++) {
            comboBox.addItem("item" + i);
        }
        assertEquals(5, comboBox.getValues().size());
        final String VALUE = comboBox.getValues().get(0);
        final String SECOND_VALUE = comboBox.getValues().get(1);
        checkValueChangeEvent(comboBox, Collections.singletonList(VALUE), Collections.singletonList(SECOND_VALUE));

        // Check ListBox
        assertNotNull(comboBox.getWidget(0));
        assertTrue(comboBox.getWidget(0) instanceof MaterialWidget);
        assertEquals(comboBox.getListbox(), comboBox.getWidget(0));
        MaterialWidget listBox = comboBox.getListbox();
        assertEquals(5, listBox.getWidgetCount());
        for (Widget w : listBox) {
            assertNotNull(w);
            assertTrue(w instanceof Option);
        }
        // Check Label
        assertNotNull(comboBox.getWidget(1));
        assertTrue(comboBox.getWidget(1) instanceof Label);
        Label lblTitle = (Label) comboBox.getWidget(1);
        assertTrue(lblTitle.getElement().hasClassName(AddinsCssName.SELECT2LABEL));
    }

    public void testElements() {
        MaterialComboBox<User> comboBox = getWidget();

        assertNotNull(comboBox.getDropdownContainerElement());
        assertEquals(JsComboBox.$(comboBox.getElement()).find(".select2 .selection .select2-selection__rendered").html(), comboBox.getDropdownContainerElement().html());

        final boolean[] firedOpenHandler = {false};
        comboBox.addOpenHandler(openEvent -> {
            firedOpenHandler[0] = true;
            assertNotNull(comboBox.getDropdownResultElement());
        });
        comboBox.open();

        assertTrue(firedOpenHandler[0]);
    }
}
