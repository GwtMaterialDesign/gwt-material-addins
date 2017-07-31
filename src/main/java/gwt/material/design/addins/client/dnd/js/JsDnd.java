/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.dnd.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for dnd component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsDnd extends JQueryElement {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsDnd interact(Element target);

    @JsMethod
    public native JsDnd draggable(JsDragOptions options);

    @JsMethod
    public native JsDnd dropzone(JsDropOptions options);

    @JsMethod
    public native JsDnd ignoreFrom(String selector);

    @JsMethod
    public native JsDnd ignoreFrom(Element ignoreFrom);
}
