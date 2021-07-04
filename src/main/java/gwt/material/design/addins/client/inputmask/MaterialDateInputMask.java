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
package gwt.material.design.addins.client.inputmask;

import com.google.gwt.event.logical.shared.InitializeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.inputmask.base.DateInputParser;
import gwt.material.design.addins.client.inputmask.events.*;
import gwt.material.design.client.base.*;
import gwt.material.design.client.constants.Autocomplete;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.events.PasteEvent;
import gwt.material.design.client.events.SensitivityChangedEvent;
import gwt.material.design.client.events.ToggleReadOnlyEvent;

import java.util.Date;

public class MaterialDateInputMask extends AbstractValueWidget<Date>
    implements HasFieldTypes, HasLabel, HasInputMaskHandlers, HasPlaceholder, HasReadOnly, HasActive, HasToggleReadOnlyHandler, HasAutocomplete, HasPasteHandlers, HasFieldSensitivity {

    private String format = "YYYY-mm-dd";
    private MaterialInputMask inputMask;
    private DateInputParser inputParser;

    public MaterialDateInputMask() {
        super(DOM.createDiv());

        inputMask = new MaterialInputMask();
        inputParser = new DateInputParser(inputMask);
        inputMask.setPlaceholder(format.toUpperCase());
        setMask(format);

        setValidateOnBlur(true);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(inputMask);
        inputMask.addValueChangeHandler(event -> {
            inputParser.validate(format);
            ValueChangeEvent.fire(this, getValue());
        });
    }

    public void setMask(String mask) {
        this.format = mask
            .replace("m", "M")
            .replace("Y", "y")
            .replace("D", "d");
        parseFormatToMask(mask);
    }

    protected void parseFormatToMask(String format) {
        String dateFormatMask = format.toLowerCase()
            .replace("m", "0")
            .replace("d", "0")
            .replace("y", "0");
        inputMask.setMask(dateFormatMask);
    }

    @Override
    public void setValue(Date value) {
        inputParser.setValue(format, value);
    }

    @Override
    public void setValue(Date value, boolean fireEvents) {
        inputParser.setValue(format, value);
    }

    @Override
    public void setValue(Date value, boolean fireEvents, boolean reload) {
        inputParser.setValue(format, value);
    }

    @Override
    public Date getValue() {
        return inputParser.parseDate(format);
    }

    @Override
    public FieldType getFieldType() {
        return inputMask.getFieldType();
    }

    @Override
    public void setLabelWidth(double percentWidth) {
        inputMask.setLabelWidth(percentWidth);
    }

    @Override
    public void setFieldWidth(double percentWidth) {
        inputMask.setFieldWidth(percentWidth);
    }

    public void setFieldType(FieldType fieldType) {
        inputMask.setFieldType(fieldType);
    }

    @Override
    public void setLabel(String label) {
        inputMask.setLabel(label);
    }

    @Override
    public String getLabel() {
        return inputMask.getLabel();
    }

    @Override
    public HandlerRegistration addCompleteHandler(CompleteEvent.CompleteHandler handler) {
        return inputMask.addCompleteHandler(handler);
    }

    @Override
    public HandlerRegistration addMaskChangeHandler(MaskChangeEvent.MaskChangeHandler handler) {
        return inputMask.addMaskChangeHandler(handler);
    }

    @Override
    public HandlerRegistration addInvalidHandler(InvalidEvent.InvalidHandler handler) {
        return inputMask.addInvalidHandler(handler);
    }

    @Override
    public HandlerRegistration addMaskKeyPressHandler(MaskKeyPressEvent.MaskKeyPressHandler handler) {
        return inputMask.addMaskKeyPressHandler(handler);
    }

    @Override
    public HandlerRegistration addInitializeHandler(InitializeHandler handler) {
        return inputMask.addInitializeHandler(handler);
    }

    @Override
    public void setActive(boolean active) {
        inputMask.setActive(active);
    }

    @Override
    public boolean isActive() {
        return inputMask.isActive();
    }

    @Override
    public void setAutocomplete(Autocomplete autocomplete) {
        inputMask.setAutocomplete(autocomplete);
    }

    @Override
    public Autocomplete getAutocomplete() {
        return inputMask.getAutocomplete();
    }

    @Override
    public void setSensitive(boolean sensitive) {
        inputMask.setSensitive(sensitive);
    }

    @Override
    public void setSensitive(boolean sensitive, boolean fireEvents) {
        inputMask.setSensitive(sensitive, fireEvents);
    }

    @Override
    public boolean isSensitive() {
        return inputMask.isSensitive();
    }

    @Override
    public HandlerRegistration addSensitivityChangedHandler(SensitivityChangedEvent.SensitivityChangedHandler handler) {
        return inputMask.addSensitivityChangedHandler(handler);
    }

    @Override
    public HandlerRegistration addPasteHandler(PasteEvent.PasteEventHandler handler) {
        return inputMask.addPasteHandler(handler);
    }

    @Override
    public String getPlaceholder() {
        return inputMask.getPlaceholder();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        inputMask.setPlaceholder(placeholder);
    }

    @Override
    public void setReadOnly(boolean value) {
        inputMask.setReadOnly(value);
    }

    @Override
    public boolean isReadOnly() {
        return inputMask.isReadOnly();
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {
        inputMask.setToggleReadOnly(toggle);
    }

    @Override
    public boolean isToggleReadOnly() {
        return inputMask.isToggleReadOnly();
    }

    @Override
    public HandlerRegistration addToggleReadOnlyHandler(ToggleReadOnlyEvent.ToggleReadOnlyHandler handler) {
        return inputMask.addToggleReadOnlyHandler(handler);
    }
}
