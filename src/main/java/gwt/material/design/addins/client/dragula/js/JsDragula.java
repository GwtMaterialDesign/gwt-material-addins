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
package gwt.material.design.addins.client.dragula.js;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.Functions;
import gwt.material.design.jquery.JQueryElement;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JsDragula extends JQueryElement {

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsDragula dragula(Element... elements);

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native JsDragula dragula(Element[] elements, JsDragulaOptions options);

    public native JQueryElement on(String events, Functions.Func2<Element, Element> handler);

    public native JQueryElement on(String events, Func4<Element, Element, Element, Element> handler);

    @FunctionalInterface
    @JsFunction
    public interface Func4<A, B, C, D> {
        void call(A param1, B param2, C param3, D param4);
    }
}
