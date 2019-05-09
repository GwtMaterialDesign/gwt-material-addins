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
package gwt.material.design.incubator.client.daterange.js;

import com.google.gwt.core.client.JsDate;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.Date;

/**
 * Available internal methods for {@link gwt.material.design.incubator.client.daterange.DateRangePicker}
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDateRangeMethod {

    @JsMethod
    public native void show(boolean fireEvent);

    @JsMethod
    public native void hide(boolean fireEvent);

    @JsMethod
    public native void toggle();

    @JsMethod
    public native void remove();

    @JsMethod
    public native void showCalendars();

    @JsMethod
    public native void hideCalendars();

    @JsMethod
    public native void clickPrev();

    @JsMethod
    public native void clickNext();

    @JsMethod
    public native void clickApply();

    @JsMethod
    public native void clickCancel();

    @JsMethod
    public native void setStartDate(JsDate date);

    @JsOverlay
    public final void setStartDate(Date date) {
        setStartDate(JsDate.create(date.getTime()));
    }

    @JsMethod
    public native void setEndDate(JsDate data);

    @JsOverlay
    public final void setEndDate(Date date) {
        setEndDate(JsDate.create(date.getTime()));
    }

    @JsMethod
    public native boolean isInvalidDate();

    @JsMethod
    public native boolean isCustomDate();

    @JsMethod
    public native void updateView();

    @JsMethod
    public native void updateMonthsInView();

    @JsMethod
    public native void updateCalendars();

    @JsMethod
    public native void renderCalendar(String side);

    @JsMethod
    public native void renderTimePicker(String side);

    @JsMethod
    public native void updateFormInputs();

    @JsMethod
    public native void move();

    @JsMethod
    public native void setDrops(String drops);
}
