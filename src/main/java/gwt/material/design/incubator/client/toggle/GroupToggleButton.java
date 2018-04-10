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
package gwt.material.design.incubator.client.toggle;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasError;
import gwt.material.design.client.base.mixin.ErrorMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.html.Div;
import gwt.material.design.client.ui.html.Label;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@formatter:off

/**
 * Group Toggle Button - 3 Buttons that grouped together to form
 * a toggling feature.
 * <p>
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code
 *      GroupToggleButton button = new GroupToggleButton();
 *      button.addSelectionHandler(e -> {
 *          // Do something here
 *      });
 * }
 * </pre>
 *
 * <p><i>
 *     Note: This component is under the incubation process and subject to change.
 * </i></p>
 *
 * @author kevzlou7979
 */
//@formatter:on
public class GroupToggleButton<T> extends AbstractValueWidget<List<T>>
        implements HasSelectionHandlers<Integer>, HasError {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(GroupToggleButtonDebugClientBundle.INSTANCE.groupToggleDebugCss());
        } else {
            MaterialDesignBase.injectCss(GroupToggleButtonClientBundle.INSTANCE.groupToggleButtonCss());
        }
    }

    private boolean multiple;
    private Div wrapper = new Div();
    private List<ToggleButton> items = new ArrayList<>();
    private List<T> values = new ArrayList<>();
    private Label label = new Label();
    private MaterialLabel errorLabel = new MaterialLabel();
    private ErrorMixin<AbstractValueWidget, MaterialLabel> errorMixin;

    public GroupToggleButton() {
        super(Document.get().createDivElement(), IncubatorCssName.GROUP_TOGGLE_BUTTON, CssName.INPUT_FIELD);
        wrapper.setStyleName(IncubatorCssName.WRAPPER);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        registerHandler(addSelectionHandler(selectionEvent -> {
            ValueChangeEvent.fire(GroupToggleButton.this, getValue());
        }));
        add(label);
        add(wrapper);
        add(errorLabel);
    }

    public ToggleButton addItem(String text) {
        return addItem(text, null);
    }

    public ToggleButton addItem(String text, T value) {
        ToggleButton button = new ToggleButton(text);
        button.setGroupParent(this);
        button.addClickHandler(clickEvent -> {
            if (!isMultiple()) {
                clearAll();
            }
            button.toggle();
            fireSelectionEvent(button);
        });
        wrapper.add(button);
        items.add(button);
        values.add(value);
        return button;
    }

    public void addItem(T value) {
        addItem(String.valueOf(value), value);
    }

    public T getValue(int index) {
        return values.get(index);
    }

    public void setLabel(String text) {
        label.setText(text);
    }

    public void toggle(int index) {
        items.get(index).toggle();
    }

    public void setActive(int index) {
        setActive(index, true);
    }


    public void setActive(int index, boolean active) {
        items.get(index).setToggle(active);
    }

    public void setActiveIndexes(boolean active, Integer... indexes) {
        for (Integer index : indexes) {
            setActive(index, active);
        }
    }

    public List<Integer> getSelectedIndexes() {
        List<Integer> indexes = new ArrayList<>();
        for (ToggleButton mButton : items) {
            if (mButton.isToggle()) {
                indexes.add(items.indexOf(mButton));
            }
        }
        return indexes;
    }

    public List<T> getValue() {
        List<T> items = new ArrayList<>();
        for (Integer i : getSelectedIndexes()) {
            items.add(values.get(i));
        }
        return items;
    }

    public T getSingleValue() {

        if (getSelectedIndexes().size() == 0) {
            return null;
        }

        return values.get(getSelectedIndexes().get(0));
    }

    public void selectAll() {
        for (ToggleButton mButton : items) {
            mButton.setToggle(true);
        }
    }

    public void clearAll() {
        for (ToggleButton mButton : items) {
            mButton.setToggle(false);
        }
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public void fireSelectionEvent(ToggleButton toggleButton) {
        SelectionEvent.fire(this, items.indexOf(toggleButton));
    }

    public ToggleButton get(int index) {
        return items.get(index);
    }

    @Override
    public void setError(String error) {
        getErrorMixin().setError(error);
    }

    @Override
    public void setSuccess(String success) {
        getErrorMixin().setSuccess(success);
    }

    @Override
    public void setHelperText(String helperText) {
        getErrorMixin().setHelperText(helperText);
    }

    @Override
    public void clearErrorOrSuccess() {
        getErrorMixin().clearErrorOrSuccess();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        items.forEach(widgets -> widgets.setEnabled(enabled));
    }

    public List<T> getOptions() {
        return values;
    }

    public List<ToggleButton> getItems() {
        return items;
    }

    @Override
    public void reset() {
        super.reset();

        clearAll();
    }

    public Div getWrapper() {
        return wrapper;
    }

    public List<T> getValues() {
        return values;
    }

    public Label getLabel() {
        return label;
    }

    public MaterialLabel getErrorLabel() {
        return errorLabel;
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<Integer> selectionHandler) {
        return addHandler(selectionHandler, SelectionEvent.getType());
    }

    @Override
    public ErrorMixin<AbstractValueWidget, MaterialLabel> getErrorMixin() {
        if (errorMixin == null) {
            errorMixin = new ErrorMixin(this, errorLabel, wrapper);
        }
        return errorMixin;
    }
}
