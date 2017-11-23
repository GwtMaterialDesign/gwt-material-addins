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
package gwt.material.design.addins.client.combobox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.combobox.base.HasUnselectItemHandler;
import gwt.material.design.addins.client.combobox.events.ComboBoxEvents;
import gwt.material.design.addins.client.combobox.events.SelectItemEvent;
import gwt.material.design.addins.client.combobox.events.UnselectItemEvent;
import gwt.material.design.addins.client.combobox.js.JsComboBox;
import gwt.material.design.addins.client.combobox.js.JsComboBoxOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.base.mixin.ReadOnlyMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.client.ui.html.OptGroup;
import gwt.material.design.client.ui.html.Option;
import gwt.material.design.jquery.client.api.JQueryElement;

import java.util.*;

import static gwt.material.design.addins.client.combobox.js.JsComboBox.$;

//@formatter:off

/**
 * ComboBox component used on chat module
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 * xmlns:ma='urn:import:gwt.material.design.addins.client'
 * }
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code
 * <combobox:MaterialComboBox>
 *   <m:html.Option value="1" text="Sample 1"/>
 *   <m:html.Option value="2" text="Sample 2"/>
 *   <m:html.Option value="3" text="Sample 3"/>
 * </combobox:MaterialComboBox>
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @author Ben Dol
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#combobox">Material ComboBox</a>
 * @see <a href="https://github.com/select2/select2">Select2 4.0.3</a>
 */
//@formatter:on
public class MaterialComboBox<T> extends AbstractValueWidget<List<T>> implements JsLoader, HasPlaceholder,
        HasOpenHandlers<T>, HasCloseHandlers<T>, HasUnselectItemHandler<T>, HasReadOnly {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugJs());
            MaterialDesignBase.injectCss(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialComboBoxClientBundle.INSTANCE.select2Js());
            MaterialDesignBase.injectCss(MaterialComboBoxClientBundle.INSTANCE.select2Css());
        }
    }


    private int selectedIndex;
    private boolean suppressChangeEvent;
    protected List<T> values = new ArrayList<>();
    private Label label = new Label();
    private MaterialLabel errorLabel = new MaterialLabel();
    protected MaterialWidget listbox = new MaterialWidget(Document.get().createSelectElement());
    private KeyFactory<T, String> keyFactory = Object::toString;
    private JsComboBoxOptions options = JsComboBoxOptions.create();

    private ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin;
    private ReadOnlyMixin<MaterialComboBox, MaterialWidget> readOnlyMixin;

    public MaterialComboBox() {
        super(Document.get().createDivElement(), CssName.INPUT_FIELD, AddinsCssName.COMBOBOX);
    }

    @Override
    protected void onLoad() {
        label.setInitialClasses(AddinsCssName.SELECT2LABEL);
        super.add(listbox);
        super.add(label);
        errorLabel.setMarginTop(15);
        $(errorLabel.getElement()).insertAfter($(getElement()));
        listbox.setGwtDisplay(Style.Display.BLOCK);

        super.onLoad();

        load();

        registerHandler(addSelectionHandler(valueChangeEvent -> $(getElement()).find("input").val("")));
    }

    @Override
    public void load() {
        JsComboBox jsComboBox = $(listbox.getElement());
        jsComboBox.select2(options);

        jsComboBox.on(ComboBoxEvents.CHANGE, event -> {
            if (!suppressChangeEvent) {
                ValueChangeEvent.fire(this, getValue());
            }
            return true;
        });

        jsComboBox.on(ComboBoxEvents.SELECT, event -> {
            SelectItemEvent.fire(this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.UNSELECT, event -> {
            UnselectItemEvent.fire(this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.OPEN, (event1, o) -> {
            OpenEvent.fire(this, null);
            return true;
        });

        jsComboBox.on(ComboBoxEvents.CLOSE, (event1, o) -> {
            CloseEvent.fire(this, null);
            return true;
        });

        if (getTextColor() != null) {
            $(getElement()).find(".select2-selection__rendered").css("color", getTextColor().getCssName());
        }
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        JsComboBox jsComboBox = $(listbox.getElement());
        jsComboBox.off(ComboBoxEvents.CHANGE);
        jsComboBox.off(ComboBoxEvents.SELECT);
        jsComboBox.off(ComboBoxEvents.UNSELECT);
        jsComboBox.off(ComboBoxEvents.OPEN);
        jsComboBox.off(ComboBoxEvents.CLOSE);
        jsComboBox.select2("destroy");
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    @Override
    public void add(Widget child) {
        if (child instanceof OptGroup) {
            for (Widget w : ((OptGroup) child).getChildren()) {
                if (w instanceof Option) {
                    values.add((T) ((Option) w).getValue());
                }
            }
        } else if (child instanceof Option) {
            values.add((T) ((Option) child).getValue());
        }
        listbox.add(child);
    }

    /**
     * Add OptionGroup directly to combobox component
     *
     * @param group - Option Group component
     */
    public void addGroup(OptGroup group) {
        listbox.add(group);
    }

    /**
     * Add item directly to combobox component with existing OptGroup
     *
     * @param text     - The text you want to labeled on the option item
     * @param value    - The value you want to pass through in this option
     * @param optGroup - Add directly this option into the existing group
     */
    public void addItem(String text, T value, OptGroup optGroup) {
        if (!values.contains(value)) {
            values.add(value);
            optGroup.add(buildOption(text, value));
        }
    }

    /**
     * Add Value directly to combobox component
     *
     * @param text  - The text you want to labeled on the option item
     * @param value - The value you want to pass through in this option
     */
    public Option addItem(String text, T value) {
        if (!values.contains(value)) {
            Option option = buildOption(text, value);
            values.add(value);
            listbox.add(option);
            return option;
        }
        return null;
    }

    public Option addItem(T value) {
        return addItem(keyFactory.generateKey(value), value);
    }

    public void setItems(Collection<T> items) {
        clear();
        addItems(items);
    }

    public void addItems(Collection<T> items) {
        items.forEach(this::addItem);
    }

    /**
     * Build the Option Element with provided params
     */
    protected Option buildOption(String text, T value) {
        Option option = new Option();
        option.setText(text);
        option.setValue(keyFactory.generateKey(value));
        return option;
    }

    /**
     * Programmatically open the combobox component
     */
    public void open() {
        $(listbox.getElement()).select2("open");
    }

    /**
     * Programmatically close the combobox component
     */
    public void close() {
        $(listbox.getElement()).select2("close");
    }

    @Override
    public void clear() {
        final Iterator<Widget> it = iterator();
        while (it.hasNext()) {
            final Widget widget = it.next();
            if (widget != label && widget != errorLabel && widget != listbox) {
                it.remove();
            }
        }
        listbox.clear();
        values.clear();
    }

    /**
     * Sets the parent element of the dropdown
     */
    public void setDropdownParent(String dropdownParent) {
        options.dropdownParent = $(dropdownParent);
    }

    public JQueryElement getDropdownParent() {
        return options.dropdownParent;
    }

    /**
     * Set the upper label above the combobox
     */
    public void setLabel(String text) {
        label.setText(text);
    }

    @Override
    public String getPlaceholder() {
        return options.placeholder;
    }

    @Override
    public void setPlaceholder(String placeholder) {
        options.placeholder = placeholder;
    }

    @Override
    public void setEnabled(boolean enabled) {
        listbox.setEnabled(enabled);
    }

    @Override
    public boolean isEnabled() {
        return listbox.isEnabled();
    }

    /**
     * Check if allow clear option is enabled
     */
    public boolean isAllowClear() {
        return options.allowClear;
    }

    /**
     * Add a clear button on the right side of the combobox
     */
    public void setAllowClear(boolean allowClear) {
        options.allowClear = allowClear;
    }

    /**
     * Get the maximum number of items to be entered on multiple combobox
     */
    public int getLimit() {
        return options.maximumSelectionLength;
    }

    /**
     * Set the maximum number of items to be entered on multiple combobox
     */
    public void setLimit(int limit) {
        options.maximumSelectionLength = limit;
    }

    /**
     * Check whether the search box is enabled on combobox
     */
    public boolean isHideSearch() {
        return options.minimumResultsForSearch.equals("Infinity");
    }

    /**
     * Set the option to display the search box inside the combobox component
     */
    public void setHideSearch(boolean hideSearch) {
        if (hideSearch) {
            options.minimumResultsForSearch = "Infinity";
        }
    }

    /**
     * Check whether the multiple option is enabled
     */
    public boolean isMultiple() {
        if (listbox != null) {
            return listbox.getElement().hasAttribute("multiple");
        }
        return false;
    }


    /**
     * Sets multi-value select boxes.
     */
    public void setMultiple(boolean multiple) {
        if (multiple) {
            $(listbox.getElement()).attr("multiple", "multiple");
        } else {
            $(listbox.getElement()).removeAttr("multiple");
        }
    }


    public void setAcceptableValues(Collection<T> values) {
        setItems(values);
    }

    @Override
    public List<T> getValue() {
        if (!isMultiple()) {
            int index = getSelectedIndex();
            T value;
            if (index != -1) {

                // Check when the value is a custom tag
                if (isTags()) {
                    value = (T) $(listbox.getElement()).val();
                } else {
                    value = values.get(index);
                }

                return Collections.singletonList(value);
            }
        } else {
            return getSelectedValues();
        }
        return new ArrayList<>();
    }

    /**
     * Gets the value for currently selected item. If multiple items are
     * selected, this method will return the value of the first selected item.
     *
     * @return the value for selected item, or {@code null} if none is selected
     */
    public List<T> getSelectedValue() {
        return getValue();
    }

    /**
     * Only return a single value even if multi support is activate.
     */
    public T getSingleValue() {
        List<T> values = getSelectedValue();
        if (!values.isEmpty()) {
            return values.get(0);
        }
        return null;
    }

    @Override
    public void setValue(List<T> value) {
        setValue(value, false);
    }

    /**
     * Set the selected value using a single item, generally used
     * in single selection mode.
     */
    public void setSingleValue(T value) {
        setValue(Collections.singletonList(value));
    }

    @Override
    public void setValue(List<T> values, boolean fireEvents) {
        if (!isMultiple()) {
            if (!values.isEmpty()) {
                setSingleValue(values.get(0), fireEvents);
            }
        } else {
            setValues(values, fireEvents);
        }
    }

    /**
     * Set the selected value using a single item, generally used
     * in single selection mode.
     */
    public void setSingleValue(T value, boolean fireEvents) {
        int index = this.values.indexOf(value);
        if (index >= 0) {
            List<T> before = getValue();
            setSelectedIndex(index);

            if (fireEvents) {
                ValueChangeEvent.fireIfNotEqual(this, before, values);
            }
        }
    }

    /**
     * Set directly all the values that will be stored into
     * combobox and build options into it.
     */
    public void setValues(List<T> values) {
        setValues(values, true);
    }

    /**
     * Set directly all the values that will be stored into
     * combobox and build options into it.
     */
    public void setValues(List<T> values, boolean fireEvents) {
        String[] stringValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            stringValues[i] = keyFactory.generateKey(values.get(i));
        }
        suppressChangeEvent = !fireEvents;
        $(listbox.getElement()).val(stringValues).trigger("change", selectedIndex);
        suppressChangeEvent = false;
    }

    /**
     * Gets the index of the value pass in this method
     *
     * @param value - The Object you want to pass as value on combobox
     */
    public int getValueIndex(T value) {
        return values.indexOf(value);
    }

    /**
     * Sets the currently selected index.
     * <p>
     * After calling this method, only the specified item in the list will
     * remain selected. For a ListBox with multiple selection enabled.
     *
     * @param selectedIndex - the index of the item to be selected
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        if (values.size() > selectedIndex) {
            T value = values.get(selectedIndex);
            if (value != null) {
                $(listbox.getElement()).val(keyFactory.generateKey(value)).trigger("change.select2", selectedIndex);
            } 
        } else {
            GWT.log("Value index is not found.", new IndexOutOfBoundsException());
        }
    }

    /**
     * Gets the text for currently selected item. If multiple items are
     * selected, this method will return the text of the first selected item.
     *
     * @return the text for selected item, or {@code null} if none is selected
     */
    public int getSelectedIndex() {
        Object o = $(getElement()).find("option:selected").last().prop("index");
        if (o != null) {
            return Integer.parseInt(o.toString());
        }
        return -1;
    }

    /**
     * Get all the values sets on combobox
     */
    public List<T> getValues() {
        return values;
    }

    /**
     * Get the selected vales from multiple combobox
     */
    public List<T> getSelectedValues() {
        Object[] curVal = (Object[]) $(listbox.getElement()).val();

        List<T> selectedValues = new ArrayList<>();
        if (curVal == null || curVal.length < 1) {
            return selectedValues;
        }

        List<String> keyIndex = getValuesKeyIndex();
        for (Object val : curVal) {
            if (val instanceof String) {
                int selectedIndex = keyIndex.indexOf(val);
                if (selectedIndex != -1) {
                    selectedValues.add(values.get(selectedIndex));
                } else {
                    if (isTags() && val instanceof String) {
                        selectedValues.add((T) val);
                    }
                }
            }
        }
        return selectedValues;
    }

    protected List<String> getValuesKeyIndex() {
        List<String> keys = new ArrayList<>();
        for (T value : values) {
            keys.add(keyFactory.generateKey(value));
        }
        return keys;
    }

    /**
     * Use your own key factory for value keys.
     */
    public void setKeyFactory(KeyFactory<T, String> keyFactory) {
        this.keyFactory = keyFactory;
    }

    @Override
    public void setReadOnly(boolean value) {
        getReadOnlyMixin().setReadOnly(value);
    }

    @Override
    public boolean isReadOnly() {
        return getReadOnlyMixin().isReadOnly();
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {
        getReadOnlyMixin().setToggleReadOnly(toggle);
        registerHandler(addValueChangeHandler(valueChangeEvent -> {
            if (isToggleReadOnly()) {
                setReadOnly(true);
            }
        }));
    }

    @Override
    public boolean isToggleReadOnly() {
        return getReadOnlyMixin().isToggleReadOnly();
    }

    /**
     * Check whether the dropdown will be close or not when result is selected
     */
    public boolean isCloseOnSelect() {
        return options.closeOnSelect;
    }

    /**
     * Allow or Prevent the dropdown from closing when a result is selected (Default true)
     */
    public void setCloseOnSelect(boolean closeOnSelect) {
        options.closeOnSelect = closeOnSelect;
    }

    public MaterialWidget getListbox() {
        return listbox;
    }

    public Label getLabel() {
        return label;
    }

    public MaterialLabel getErrorLabel() {
        return errorLabel;
    }

    public boolean isTags() {
        return options.tags;
    }

    /**
     * Note: Tags will only support String as generic params starting 2.x.
     */
    public void setTags(boolean tags) {
        if (tags) GWT.log("Note: Tags will only support String as generic params.");
        options.tags = tags;
    }

    public HandlerRegistration addSelectionHandler(SelectItemEvent.SelectComboHandler<T> selectionHandler) {
        return addHandler(selectionHandler, SelectItemEvent.getType());
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<T> openHandler) {
        return addHandler(openHandler, OpenEvent.getType());
    }

    @Override
    public HandlerRegistration addCloseHandler(CloseHandler<T> closeHandler) {
        return addHandler(closeHandler, CloseEvent.getType());
    }

    @Override
    public HandlerRegistration addRemoveItemHandler(UnselectItemEvent.UnselectComboHandler<T> handler) {
        return addHandler(handler, UnselectItemEvent.getType());
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        if (errorMixin == null) {
            errorMixin = new ErrorMixin<>(this, errorLabel, this.asWidget());
        }
        return errorMixin;
    }

    public ReadOnlyMixin<MaterialComboBox, MaterialWidget> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, listbox);
        }
        return readOnlyMixin;
    }
}
