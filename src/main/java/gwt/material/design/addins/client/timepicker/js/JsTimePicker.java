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
package gwt.material.design.addins.client.timepicker.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Time Picker component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true)
public class JsTimePicker extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsTimePicker $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsTimePicker $(Element element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsTimePicker $(String selector);

    @JsMethod
    public native JQueryElement lolliclock(JsTimePickerOptions options);

    @JsMethod
    public native JQueryElement lolliclock(String action);

    @JsMethod
    public native JQueryElement lolliclock(String action, Object... vars);
}
