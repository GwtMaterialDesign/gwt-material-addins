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
import gwt.material.design.client.base.*;
import gwt.material.design.client.base.mixin.FieldTypeMixin;
import gwt.material.design.client.constants.*;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.incubator.client.AddinsIncubator;

import java.util.Date;

public class DateOfBirthPicker extends AbstractValueWidget<Date> implements HasFieldTypes, HasIcon, HasReadOnly, HasPlaceholder {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(DateOfBirthPickerDebugClientBundle.INSTANCE.dobDebugCss());
        } else {
            MaterialDesignBase.injectCss(DateOfBirthPickerClientBundle.INSTANCE.dobCss());
        }
    }

    private MonthDataProvider dataProvider = new DefaultMonthDataProvider();
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

    protected void setupMonth() {
        month.addStyleName("dob-month");
        if (dataProvider.get().size() > 12) {
            setErrorText("Months must be equal to 12");
        } else {
            for (Integer index : dataProvider.get().keySet()) {
                month.addItem(dataProvider.get().get(index), index);
            }
        }
        month.setLabel("Birthdate");
        month.setGrid("s6");
    }

    protected void setupDay() {
        day.addStyleName("dob-day");
        day.setMask("00");
        day.setFloat(Style.Float.LEFT);
        day.setTextAlign(TextAlign.CENTER);
        day.setPlaceholder("DD");
        day.setGrid("s2");
    }

    protected void setupYear() {
        year.addStyleName("dob-year");
        year.setMask("0000");
        year.setFloat(Style.Float.LEFT);
        year.setTextAlign(TextAlign.CENTER);
        year.setPlaceholder("YYYY");
        year.setGrid("s4");
    }

    @Override
    public Date getValue() {
        Integer yearValue = year.getValue();
        Integer monthValue = month.getSingleValue();
        Integer dayValue = day.getValue();
        if (yearValue != null && monthValue != null && dayValue != null) {
            return new Date(yearValue - 1900, monthValue, dayValue);
        }
        return null;
    }

    @Override
    public void setValue(Date value) {
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
    public MaterialIcon getIcon() {
        return null;
    }

    @Override
    public void setIconType(IconType iconType) {

    }

    @Override
    public void setIconPosition(IconPosition position) {

    }

    @Override
    public void setIconSize(IconSize size) {

    }

    @Override
    public void setIconFontSize(double size, Style.Unit unit) {

    }

    @Override
    public void setIconColor(Color iconColor) {

    }

    @Override
    public Color getIconColor() {
        return null;
    }

    @Override
    public void setIconPrefix(boolean prefix) {

    }

    @Override
    public boolean isIconPrefix() {
        return false;
    }

    @Override
    public void setCustomIconType(String iconType) {

    }

    @Override
    public String getCustomIconType() {
        return null;
    }

    @Override
    public String getPlaceholder() {
        return null;
    }

    @Override
    public void setPlaceholder(String placeholder) {

    }

    @Override
    public void setReadOnly(boolean value) {

    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setToggleReadOnly(boolean toggle) {

    }

    @Override
    public boolean isToggleReadOnly() {
        return false;
    }

    public FieldTypeMixin<DateOfBirthPicker> getFieldTypeMixin() {
        if (fieldTypeMixin == null) {
            fieldTypeMixin = new FieldTypeMixin<>(this);
        }
        return fieldTypeMixin;
    }
}
