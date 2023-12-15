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
import com.google.gwt.i18n.client.DateTimeFormat;
import gwt.material.design.addins.client.AbstractAddinsValueWidget;
import gwt.material.design.addins.client.base.dependency.DependencyResource;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.inputmask.MaterialIntegerInputMask;
import gwt.material.design.client.base.HasFieldTypes;
import gwt.material.design.client.base.HasReadOnly;
import gwt.material.design.client.base.mixin.FieldTypeMixin;
import gwt.material.design.client.base.mixin.ToggleStyleMixin;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.constants.StatusDisplayType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.incubator.client.base.matcher.DateMonthMatcher;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateOfBirthPicker extends AbstractAddinsValueWidget<Date> implements HasFieldTypes, HasReadOnly {

    private boolean showFieldLabels;
    private Date value;
    private DobLocaleDateProvider dataProvider = new DefaultDobLocaleDateProvider();
    private MaterialComboBox<Integer> month = new MaterialComboBox();
    private MaterialIntegerInputMask day = new MaterialIntegerInputMask();
    private MaterialIntegerInputMask year = new MaterialIntegerInputMask();

    private FieldTypeMixin<DateOfBirthPicker> fieldTypeMixin;
    private ToggleStyleMixin<DateOfBirthPicker> toggleStyleMixin;

    public DateOfBirthPicker() {
        super(Document.get().createDivElement(), CssName.ROW);

        setupLayout();
        setupHandlers();
        addStyleName("dob-container");
    }

    protected void setupLayout() {
        // Month
        month.addStyleName("dob-month");
        month.setGrid("s12 m5");
        month.setCloseOnSelect(true);

        // Day
        day.addStyleName("dob-day");
        day.setMask("00");
        day.setFloat(Style.Float.LEFT);
        day.setTextAlign(TextAlign.CENTER);
        day.setPlaceholder("DD");
        day.setGrid("s4 m3");

        // Year
        year.addStyleName("dob-year");
        year.setMask("0000");
        year.setFloat(Style.Float.LEFT);
        year.setTextAlign(TextAlign.CENTER);
        year.setPlaceholder("YYYY");
        year.setGrid("s8 m4");
    }

    protected void setupHandlers() {
        // Month
        if (dataProvider.get().size() > 12) {
            setErrorText(dataProvider.getInvalidMonthMessage());
        } else {
            month.clear();
            for (Integer index : dataProvider.get().keySet()) {
                month.addItem(dataProvider.get().get(index), index);
            }
        }
        month.setMatcher(DateMonthMatcher.getDefaultMonthMatcher());

        month.addValueChangeHandler(event -> {
            Date test = value;
            if (validateDate(true)) {
                value.setMonth(month.getSingleValue());
            }
        });

        if (dataProvider.getMonthLabel() != null && !dataProvider.getMonthLabel().isEmpty()) {
            month.setLabel(dataProvider.getMonthLabel());
        }

        // Day
        day.addValueChangeHandler(event -> {
            if (validateDate(true)) {
                value.setDate(day.getValue());
            }
        });

        if (dataProvider.getDayLabel() != null && !dataProvider.getDayLabel().isEmpty()) {
            day.setLabel(dataProvider.getDayLabel());
        }

        // Year
        year.addValueChangeHandler(event -> {
            if (validateDate(true)) {
                value.setYear(year.getValue() - 1900);
            }
        });

        if (dataProvider.getYearLabel() != null && !dataProvider.getYearLabel().isEmpty()) {
            year.setLabel(dataProvider.getYearLabel());
        }
    }

    @Override
    protected void internalLoad() {
        add(month);
        add(day);
        add(year);

        if (!showFieldLabels) {
            if (month != null) {
                month.getLabelWidget().removeFromParent();
            }

            if (day != null) {
                day.getLabelWidget().removeFromParent();
            }

            if (year != null) {
                year.getLabelWidget().removeFromParent();
            }
        }

        getToggleStyleMixin().setOn(!showFieldLabels);
    }

    public void reload() {
        setupHandlers();
    }

    @Override
    public void reset() {
        super.reset();

        month.reset();
        day.reset();
        year.reset();
        value = null;
    }

    protected boolean validateDate(boolean showErrors) {
        boolean valid = true;
        Integer monthValue = month.getSingleValue();
        Integer yearValue = year.getText() != null && !year.getText().isEmpty() ? Integer.parseInt(year.getText()) : null;
        Integer dayValue = day.getText() != null && !day.getText().isEmpty() ? Integer.parseInt(day.getText()) : null;

        if (!(monthValue != null && monthValue >= 0 && monthValue < 12)) {
            valid = false;
            if (showErrors) month.setErrorText(dataProvider.getInvalidMonthMessage());
        } else {
            if (showErrors) month.clearErrorText();
        }

        if (!(yearValue != null && yearValue >= 1900)) {
            valid = false;
            if (showErrors) year.setErrorText(dataProvider.getInvalidYearLabel());
        } else {
            if (showErrors) year.clearErrorText();
        }

        if (!(dayValue != null && dayValue > 0 && dayValue <= 31)) {
            valid = false;
            if (showErrors) day.setErrorText(dataProvider.getInvalidDayMessage());
        } else {
            if (showErrors) day.clearErrorText();
        }

        if (!validateLeapYear(monthValue, dayValue, yearValue)) {
            valid = false;
            if (showErrors) day.setErrorText("Invalid Date");
        } else {
            if (showErrors) day.clearErrorText();
        }
        return valid;
    }

    @Override
    public boolean validate() {
        return super.validate() && validateDate(false);
    }

    public boolean validateLeapYear(Integer month, Integer day, Integer year) {
        if (month != null && day != null && year != null) {
            String dateToValidate = month + 1 + "/" + day + "/" + year;
            if (dateToValidate == null) {
                return false;
            }
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            try {
                Date date = sdf.parse(dateToValidate);
                if (date.getMonth() != month) {
                    return false;
                }
                value = date;
            } catch (Exception e) {

                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Date getValue() {
        return value;
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);

        this.value = value;
        year.setValue(value.getYear() + 1900);
        day.setValue(value.getDate());
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

    public DobLocaleDateProvider getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(DobLocaleDateProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public boolean isShowFieldLabels() {
        return showFieldLabels;
    }

    public void setShowFieldLabels(boolean showFieldLabels) {
        this.showFieldLabels = showFieldLabels;
    }

    public MaterialComboBox<Integer> getMonth() {
        return month;
    }

    public MaterialIntegerInputMask getDay() {
        return day;
    }

    public MaterialIntegerInputMask getYear() {
        return year;
    }

    public FieldTypeMixin<DateOfBirthPicker> getFieldTypeMixin() {
        if (fieldTypeMixin == null) {
            fieldTypeMixin = new FieldTypeMixin<>(this);
        }
        return fieldTypeMixin;
    }

    public ToggleStyleMixin<DateOfBirthPicker> getToggleStyleMixin() {
        if (toggleStyleMixin == null) {
            toggleStyleMixin = new ToggleStyleMixin<>(this, "no-labels");
        }
        return toggleStyleMixin;
    }

    @Override
    public List<DependencyResource> getCssDependencies() {
        return Collections.singletonList(new DependencyResource(DateOfBirthPickerClientBundle.INSTANCE.dobCss(), DateOfBirthPickerDebugClientBundle.INSTANCE.dobDebugCss()));
    }
}
