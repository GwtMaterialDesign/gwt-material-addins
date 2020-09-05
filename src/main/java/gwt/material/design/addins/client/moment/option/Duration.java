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
package gwt.material.design.addins.client.moment.option;

import com.google.gwt.core.client.JavaScriptObject;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Duration {

    @JsProperty
    public int hour;

    @JsProperty
    public int minute;

    @JsProperty
    public int seconds;

    @JsProperty
    public int milliseconds;

    // Clone

    @JsMethod
    public native Duration clone();

    // Humanize 

    @JsMethod
    public native String humanize();

    @JsMethod
    public native String humanize(boolean suffix);

    // Milliseconds 

    @JsMethod
    public native int milliseconds();

    @JsMethod
    public native int asMilliseconds();

    // Seconds 

    @JsMethod
    public native int seconds();

    @JsMethod
    public native int asSeconds();

    // Minutes 

    @JsMethod
    public native int minutes();

    @JsMethod
    public native int asMinutes();

    // Hours 

    @JsMethod
    public native int hours();

    @JsMethod
    public native int asHours();

    // Days 

    @JsMethod
    public native int days();

    @JsMethod
    public native int asDays();

    // Weeks 

    @JsMethod
    public native int weeks();

    @JsMethod
    public native int asWeeks();

    // Months 

    @JsMethod
    public native int months();

    @JsMethod
    public native int asMonths();

    // Years 

    @JsMethod
    public native int years();

    @JsMethod
    public native int asYears();

    // Add Time 

    @JsMethod
    public native Duration add(int amount, String key);

    @JsMethod
    public native Duration add(int amount);

    @JsMethod
    public native Duration add(Duration duration);

    @JsMethod
    public native Duration add(JavaScriptObject object);

    // Subtract Time 

    @JsMethod
    public native Duration substract(int amount, String key);

    @JsMethod
    public native Duration substract(int amount);

    @JsMethod
    public native Duration substract(Duration duration);

    @JsMethod
    public native Duration substract(JavaScriptObject object);

    // As Unit of Time 

    @JsMethod
    public native Duration as(String unit);

    // Get Unit of Time 

    @JsMethod
    public native Duration get(String unit);

    // As JSON 

    @JsMethod
    public native String toJSON();

    // As ISO 8601 String 

    @JsMethod
    public native String toISOString();

    // Locale 

    @JsMethod
    public native Duration locale();

    @JsMethod
    public native Duration locale(String s);
}
