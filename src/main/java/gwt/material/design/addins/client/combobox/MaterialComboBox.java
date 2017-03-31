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
package gwt.material.design.addins.client.combobox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.base.constants.AddinsCssName;
import gwt.material.design.addins.client.combobox.base.HasRemoveItemHandler;
import gwt.material.design.addins.client.combobox.events.ComboBoxEvents;
import gwt.material.design.addins.client.combobox.events.RemoveItemEvent;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#combobox">Material ComboBox</a>
 */
//@formatter:on
public class MaterialComboBox<T> extends AbstractValueWidget<T> implements HasPlaceholder, HasConstrainedValue<T>,
        HasSelectionHandlers<T>, HasOpenHandlers<T>, HasCloseHandlers<T>, HasRemoveItemHandler<T>, HasReadOnly {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugJs());
            MaterialDesignBase.injectCss(MaterialComboBoxDebugClientBundle.INSTANCE.select2DebugCss());
        } else {
            MaterialDesignBase.injectJs(MaterialComboBoxClientBundle.INSTANCE.select2Js());
            MaterialDesignBase.injectCss(MaterialComboBoxClientBundle.INSTANCE.select2Css());
        }
    }

    private String placeholder;
    private boolean allowClear;
    private boolean multiple;
    private boolean initialized;
    private boolean hideSearch;
    private int limit;
    private boolean closeOnSelect = true;
    private String dropdownParent = "body";

    private int selectedIndex;
    private String uid = DOM.createUniqueId();

    protected List<T> values = new ArrayList<>();

    private Label label = new Label();
    private MaterialLabel lblError = new MaterialLabel();
    protected MaterialWidget listbox = new MaterialWidget(Document.get().createSelectElement());
    private HandlerRegistration valueChangeHandler;

    private final ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin = new ErrorMixin<>(
            this, lblError, this.asWidget());
    private ReadOnlyMixin<MaterialComboBox, MaterialWidget> readOnlyMixin;

    // By default the key is generated using toString
    private KeyFactory<T, String> keyFactory = Object::toString;

    public MaterialComboBox() {
        super(Document.get().createDivElement(), CssName.INPUT_FIELD, AddinsCssName.COMBOBOX);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        if (!initialized) {
            label.setInitialClasses(AddinsCssName.SELECT2LABEL);
            super.add(listbox);
            super.add(label);
            lblError.setLayoutPosition(Style.Position.ABSOLUTE);
            lblError.setMarginTop(15);
            super.add(lblError);
            setId(uid);

            listbox.setGwtDisplay(Style.Display.BLOCK);
            initialized = true;
        }

        initialize();
    }

    public void initialize() {
        JsComboBoxOptions options = new JsComboBoxOptions();
        options.allowClear = allowClear;
        options.placeholder = placeholder;
        options.maximumSelectionLength = limit;
        options.closeOnSelect = closeOnSelect;
        options.dropdownParent = $(dropdownParent);
        
        if (isHideSearch()) {
            options.minimumResultsForSearch = "Infinity";
        }

        JsComboBox jsComboBox = $(listbox.getElement());
        jsComboBox.select2(options);

        jsComboBox.on(ComboBoxEvents.CHANGE, event -> {
            ValueChangeEvent.fire(MaterialComboBox.this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.SELECT, event -> {
            SelectionEvent.fire(MaterialComboBox.this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.UNSELECT, event -> {
            RemoveItemEvent.fire(this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.OPEN, (event1, o) -> {
            OpenEvent.fire(MaterialComboBox.this, getValue());
            return true;
        });

        jsComboBox.on(ComboBoxEvents.CLOSE, (event1, o) -> {
            CloseEvent.fire(MaterialComboBox.this, getValue());
            return true;
        });
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        // Perform tear down on select2
        JsComboBox jsComboBox = $(listbox.getElement());
        jsComboBox.off(ComboBoxEvents.CHANGE);
        jsComboBox.off(ComboBoxEvents.SELECT);
        jsComboBox.off(ComboBoxEvents.UNSELECT);
        jsComboBox.off(ComboBoxEvents.OPEN);
        jsComboBox.off(ComboBoxEvents.CLOSE);
        jsComboBox.select2("destroy");

        if (valueChangeHandler != null) {
            valueChangeHandler.removeHandler();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
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
     * Sets the parent element of the dropdown
     * @param dropdownParent
     */
    public void setDropdownParent(String dropdownParent) {
		this.dropdownParent = dropdownParent;
	}
    
    public String getDropdownParent() {
		return dropdownParent;
	}
    
    /**
     * Sets multi-value select boxes.
     */
    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
        if (multiple) {
            $(listbox.getElement()).attr("multiple", "multiple");
        } else {
            $(listbox.getElement()).removeAttr("multiple");
        }
    }

    /**
     * Set the upper label above the combobox
     */
    public void setLabel(String text) {
        label.setText(text);
    }

    @Override
    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
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
        return allowClear;
    }

    /**
     * Add a clear button on the right side of the combobox
     */
    public void setAllowClear(boolean allowClear) {
        this.allowClear = allowClear;
    }

    /**
     * Get the maximum number of items to be entered on multiple combobox
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Set the maximum number of items to be entered on multiple combobox
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Check whether the search box is enabled on combobox
     */
    public boolean isHideSearch() {
        return hideSearch;
    }

    /**
     * Set the option to display the search box inside the combobox component
     */
    public void setHideSearch(boolean hideSearch) {
        this.hideSearch = hideSearch;
    }

    /**
     * Check whether the multiple option is enabled
     */
    public boolean isMultiple() {
        return multiple;
    }

    @Override
    public void setAcceptableValues(Collection<T> values) {
        clear();
        for (T value : values) {
            addItem(value);
        }
    }

    @Override
    public T getValue() {
        int index = getSelectedIndex();
        if(index != -1) {
            return values.get(index);
        }
        return null;
    }

    /**
     * Gets the value for currently selected item. If multiple items are
     * selected, this method will return the value of the first selected item.
     *
     * @return the value for selected item, or {@code null} if none is selected
     */
    public T getSelectedValue() {
        return getValue();
    }

    @Override
    public void setValue(T value) {
        setValue(value, true);
    }

    @Override
    public void setValue(T value, boolean fireEvents) {
        int index = values.indexOf(value);
        if (index >= 0) {
            T before = getValue();
            setSelectedIndex(index);

            if (fireEvents) {
                ValueChangeEvent.fireIfNotEqual(this, before, value);
            }
        }
    }

    /**
     * Set directly all the values that will be stored into
     * combobox and build options into it.
     */
    public void setValues(List<T> values) {
        String[] stringValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            stringValues[i] = keyFactory.generateKey(values.get(i));
        }
        $(listbox.getElement()).val(stringValues).trigger("change", selectedIndex);
    }

    public Option addItem(T value) {
        return addItem(keyFactory.generateKey(value), value);
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
        }
        return null;
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
     * Sets the currently selected index.
     * <p>
     * After calling this method, only the specified item in the list will
     * remain selected. For a ListBox with multiple selection enabled.
     *
     * @param selectedIndex - the index of the item to be selected
     */
    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        T value = values.get(selectedIndex);
        if (value != null) {
            $(listbox.getElement()).val(keyFactory.generateKey(value)).trigger("change.select2", selectedIndex);
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
        Object o = $("#" + uid).find("option:selected").last().prop("index");
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
        if(curVal == null || curVal.length < 1) {
            return selectedValues;
        }

        List<String> keyIndex = getValuesKeyIndex();
        for (Object val : curVal) {
            if(val instanceof String) {
                int selectedIndex = keyIndex.indexOf(val);
                if (selectedIndex != -1) {
                    selectedValues.add(values.get(selectedIndex));
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
            if (widget != label && widget != lblError && widget != listbox) {
                it.remove();
            }
        }
        listbox.clear();
        values.clear();
    }

    /**
     * Use your own key factory for value keys.
     */
    public void setKeyFactory(KeyFactory<T, String> keyFactory) {
        this.keyFactory = keyFactory;
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<T> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
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
    public HandlerRegistration addRemoveItemHandler(RemoveItemEvent.RemoveItemHandler<T> handler) {
        return addHandler(handler, RemoveItemEvent.getType());
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        return errorMixin;
    }

    public ReadOnlyMixin<MaterialComboBox, MaterialWidget> getReadOnlyMixin() {
        if (readOnlyMixin == null) {
            readOnlyMixin = new ReadOnlyMixin<>(this, listbox);
        }
        return readOnlyMixin;
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
        valueChangeHandler = addValueChangeHandler(valueChangeEvent -> {
            if (isToggleReadOnly()) {
                setReadOnly(true);
            }
        });
    }

    @Override
    public boolean isToggleReadOnly() {
        return getReadOnlyMixin().isToggleReadOnly();
    }

    /**
     * Check whether the dropdown will be close or not when result is selected
     */
    public boolean isCloseOnSelect() {
        return closeOnSelect;
    }

    /**
     * Allow or Prevent the dropdown from closing when a result is selected (Default true)
     */
    public void setCloseOnSelect(boolean closeOnSelect) {
        this.closeOnSelect = closeOnSelect;
    }

    public MaterialWidget getListbox() {
        return listbox;
    }

    public Label getLabel() {
        return label;
    }
}