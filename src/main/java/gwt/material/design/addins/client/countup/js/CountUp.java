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
package gwt.material.design.addins.client.countup.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for CountUp component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class CountUp {

    public CountUp(Element target, double startVal, double endVal) {
    }

    public CountUp(Element target, double startVal, double endVal, double decimals, double duration, JsCountUpOptions options) {
    }

    public native void start(Functions.Func callback);

    public native void pauseResume();

    public native void reset();
}
