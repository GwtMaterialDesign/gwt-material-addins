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

import com.google.gwt.i18n.client.DateTimeFormat;

import java.util.Date;

public class MaterialDateInputMask extends MaterialInputMask<Date> {

    private String format = "mm/dd/yyyy";

    public MaterialDateInputMask() {
        super();

        setFormat(format);
    }

    @Override
    public Date getValue() {
        if (getText() != null && !getText().isEmpty()) {
            if (getMask() != null && !getMask().isEmpty()) {
                if (validate()) {
                    return DateTimeFormat.getFormat(getFormat()).parse(getText());
                }
            }
        }
        return null;
    }

    @Override
    public boolean validate() {
        boolean valid = true;

        //TODO Validation of dates / months/ year

        return valid;
    }

    protected void parseFormatToMask(String format) {
        String dateFormatMask = format.toLowerCase()
                .replace("m", "0")
                .replace("d", "0")
                .replace("y", "0");
        setMask(dateFormatMask);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        parseFormatToMask(format);
    }
}
