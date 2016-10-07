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
package gwt.material.design.addins.client.dnd.js;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Element Rect for dnd component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDragElementRect {

    @JsProperty
    public double top;

    @JsProperty
    public double left;

    @JsProperty
    public double bottom;

    @JsProperty
    public double right;

    @JsOverlay
    public static JsDragElementRect create() {
        return new JsDragElementRect();
    }

    @JsOverlay
    public static JsDragElementRect create(double top, double left, double bottom, double right) {
        JsDragElementRect rect = new JsDragElementRect();
        rect.top = top;
        rect.left = left;
        rect.bottom = bottom;
        rect.right = right;
        return rect;
    }
}
