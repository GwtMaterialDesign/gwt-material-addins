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
package gwt.material.design.addins.client.inputmask.base;

import com.google.gwt.i18n.client.DateTimeFormat;
import gwt.material.design.addins.client.inputmask.AbstractInputMask;

import java.util.Date;

public class DateInputParser<T extends AbstractInputMask<String>> {

    protected final T valuebox;

    public DateInputParser(T valuebox) {
        this.valuebox = valuebox;
    }

    public Date parseDate(String format) {
        if (validate(format)) {
            valuebox.clearStatusText();
            return DateTimeFormat.getFormat(format).parse(valuebox.getText());
        }
        return null;
    }

    public void setValue(String format, Date value) {
        if (value != null) {
            valuebox.setValue(DateTimeFormat.getFormat(format).format(value), true);
        } else {
            valuebox.clear();
        }
    }

    public boolean validate(String format) {
        if (valuebox.getText() != null && !valuebox.getText().isEmpty()
            && valuebox.getMask() != null && format != null) {
            format = format.toLowerCase();
            String dateString = valuebox.getValueWithMask();
            String month = dateString.substring(format.indexOf("m"), format.indexOf("m") + 2);
            String day = dateString.substring(format.indexOf("d"), format.indexOf("d") + 2);
            String year = dateString.substring(format.indexOf("y"), format.lastIndexOf("y") + 1);

            boolean validLeapYear = validateLeapYear(day, month, Integer.parseInt(year));
            if (!validLeapYear) {
                valuebox.setErrorText("Not a valid date");
            }

            boolean valid = validate(month, getMonthRegex(), getMothDoesNotMatchError())
                && validate(day, getDayRegex(), getDayDoesNotMatchError())
                && validate(year, getYearRegex(), getYearDoesNotMatchError())
                && validLeapYear;

            if (valid) {
                valuebox.clearStatusText();
            }

            return valid;
        }
        return false;
    }

    protected boolean validate(String type, String regex, String message) {
        valuebox.setErrorText(message);
        return type.matches(regex);
    }

    protected boolean validateLeapYear(String day, String month, int year) {
        if (day.equals("31") &&
            (month.equals("4") || month.equals("6") || month.equals("9") ||
                month.equals("11") || month.equals("04") || month.equals("06") ||
                month.equals("09"))) {
            return false;
        } else if (month.equals("2") || month.equals("02")) {
            if (year % 4 == 0) {
                return !day.equals("30") && !day.equals("31");
            } else {
                return !day.equals("29") && !day.equals("30") && !day.equals("31");
            }
        } else {
            return true;
        }
    }

    protected String getMonthRegex() {
        return "^(0?[1-9]|1[012])$";
    }

    protected String getDayRegex() {
        return "(0?[1-9]|[12][0-9]|3[01])";
    }

    protected String getYearRegex() {
        return "^\\d{4}$";
    }

    protected String getMothDoesNotMatchError() {
        return "Month does not match";
    }

    protected String getDayDoesNotMatchError() {
        return "Day does not match";
    }

    protected String getYearDoesNotMatchError() {
        return "Year does not match";
    }
}
