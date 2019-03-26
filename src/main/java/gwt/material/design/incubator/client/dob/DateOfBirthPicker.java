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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.inputmask.MaterialIntegerInputMask;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.HasFieldTypes;
import gwt.material.design.client.base.HasReadOnly;
import gwt.material.design.client.base.mixin.FieldTypeMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.constants.StatusDisplayType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.matcher.DateMonthMatcher;

import java.util.Date;

public class DateOfBirthPicker extends AbstractValueWidget<Date> implements HasFieldTypes, HasReadOnly {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(DateOfBirthPickerDebugClientBundle.INSTANCE.dobDebugCss());
        } else {
            MaterialDesignBase.injectCss(DateOfBirthPickerClientBundle.INSTANCE.dobCss());
        }
    }

    private Date value;
    private DobLocaleDateProvide dataProvider = new DefaultDobLocaleDateProvide();
    private MaterialComboBox<Integer> month = new MaterialComboBox();
    private MaterialIntegerInputMask day = new MaterialIntegerInputMask();
    private MaterialIntegerInputMask year = new MaterialIntegerInputMask();

    private FieldTypeMixin<DateOfBirthPicker> fieldTypeMixin;

    public DateOfBirthPicker() {
        super(Document.get().createDivElement(), CssName.ROW);

        setupMonth();
        setupDay();
        setupYear();
        addStyleName("dob-container");
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(month);
        add(day);
        add(year);
    }

    public void reload() {
        setupMonth();
        setupDay();
        setupYear();
    }

    protected void setupMonth() {
        month.addStyleName("dob-month");
        if (dataProvider.get().size() > 12) {
            setErrorText(dataProvider.getInvalidMonthMessage());
        } else {
            month.clear();
            for (Integer index : dataProvider.get().keySet()) {
                month.addItem(dataProvider.get().get(index), index);
            }
        }
        month.setMatcher(DateMonthMatcher.getDefaultMonthMatcher());
        month.setLabel(dataProvider.getMonthLabel());
        month.setGrid("s12 m5");
        month.addValueChangeHandler(event -> {
            if (validateDate()) {
                value.setMonth(month.getSingleValue());
            }
        });
    }

    protected void setupDay() {
        day.setLabel(dataProvider.getDayLabel());
        day.addStyleName("dob-day");
        day.setMask("00");
        day.setFloat(Style.Float.LEFT);
        day.setTextAlign(TextAlign.CENTER);
        day.setPlaceholder("DD");
        day.setGrid("s4 m3");
        day.addValueChangeHandler(event -> {
            if (validateDate()) {
                value.setDate(day.getValue());
            }
        });
    }

    protected void setupYear() {
        year.setLabel(dataProvider.getYearLabel());
        year.addStyleName("dob-year");
        year.setMask("0000");
        year.setFloat(Style.Float.LEFT);
        year.setTextAlign(TextAlign.CENTER);
        year.setPlaceholder("YYYY");
        year.setGrid("s8 m4");
        year.addValueChangeHandler(event -> {
            if (validateDate()) {
                value.setYear(year.getValue() - 1900);
            }
        });
    }

    protected boolean validateDate() {
        boolean valid = true;
        if (!(month.getSingleValue() != null && month.getSingleValue() > 0 && month.getSingleValue() < 12)) {
            valid = false;
            month.setErrorText(dataProvider.getInvalidMonthMessage());
        } else {
            month.clearErrorText();
        }

        if (!(year.getValue() != null && year.getValue() >= 1900)) {
            valid = false;
            year.setErrorText(dataProvider.getInvalidYearLabel());
        } else {
            year.clearErrorText();
        }

        if (!(day.getValue() != null && day.getValue() > 0 && day.getValue() <= 31)) {
            valid = false;
            day.setErrorText(dataProvider.getInvalidDayMessage());
        } else {
            day.clearErrorText();
        }
        return valid;
    }

    @Override
    public Date getValue() {
        //TODO: Date value builder - compare to expected month value
        //TODO: Input mask 1900 - current date - 100
        return value;
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);

        this.value = value;
        year.setValue(value.getYear() + 1900);
        day.setValue(value.getDay());
        month.setSingleValue(value.getMonth());
    }

    @Override
    public void setFieldType(FieldType type) {
        month.setFieldType(type);
        day.setFieldType(type);
        year.setFieldType(type);
    }

    @Override
    public FieldType getFieldType() {
        return getFieldTypeMixin().getFieldType();
    }

    @Override
    public void setLabelWidth(double percentWidth) {
        getFieldTypeMixin().setLabelWidth(percentWidth);
    }

    @Override
    public void setFieldWidth(double percentWidth) {
        getFieldTypeMixin().setLabelWidth(percentWidth);
    }

    @Override
    public void setReadOnly(boolean value) {
        month.setReadOnly(value);
        year.setReadOnly(value);
        day.setReadOnly(value);
    }

    @Override
    public boolean isReadOnly() {
        return month.isReadOnly() && year.isReadOnly() && day.isReadOnly();
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {
        month.setToggleReadOnly(toggle);
        year.setToggleReadOnly(toggle);
        day.setToggleReadOnly(toggle);
    }

    @Override
    public boolean isToggleReadOnly() {
        return month.isToggleReadOnly() && year.isToggleReadOnly() && day.isToggleReadOnly();
    }

    @Override
    public void setStatusDisplayType(StatusDisplayType displayType) {
        super.setStatusDisplayType(displayType);
        month.setStatusDisplayType(displayType);
        year.setStatusDisplayType(displayType);
        day.setStatusDisplayType(displayType);
    }

    @Override
    public void setErrorText(String errorText) {
        month.setErrorText(errorText);
        day.setErrorText(errorText);
        year.setErrorText(errorText);
    }

    @Override
    public void setSuccessText(String successText) {
        month.setErrorText(successText);
        day.setErrorText(successText);
        year.setErrorText(successText);
    }

    @Override
    public void setHelperText(String helperText) {
        month.setErrorText(helperText);
        day.setErrorText(helperText);
        year.setErrorText(helperText);
    }

    @Override
    public StatusDisplayType getStatusDisplayType() {
        return month.getStatusDisplayType();
    }

    public DobLocaleDateProvide getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(DobLocaleDateProvide dataProvider) {
        this.dataProvider = dataProvider;
    }

    public FieldTypeMixin<DateOfBirthPicker> getFieldTypeMixin() {
        if (fieldTypeMixin == null) {
            fieldTypeMixin = new FieldTypeMixin<>(this);
        }
        return fieldTypeMixin;
    }
}
