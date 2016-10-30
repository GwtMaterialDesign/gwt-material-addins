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
 * Options for dnd component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDragRestrictions {

    @JsProperty
    public String restriction;

    @JsProperty
    public boolean endOnly;

    @JsProperty
    public JsDragElementRect elementRect;

    @JsOverlay
    public static JsDragRestrictions create() {
        return create(null, false, new JsDragElementRect());
    }

    @JsOverlay
    public static JsDragRestrictions create(String restriction) {
        return create(restriction, false, new JsDragElementRect());
    }

    @JsOverlay
    public static JsDragRestrictions create(boolean endOnly) {
        return create(null, endOnly, new JsDragElementRect());
    }

    @JsOverlay
    public static JsDragRestrictions create(JsDragElementRect elementRect) {
        return create(null, false, elementRect);
    }

    @JsOverlay
    public static JsDragRestrictions create(String restriction, boolean endOnly, JsDragElementRect elementRect) {
        JsDragRestrictions restrict = new JsDragRestrictions();
        restrict.restriction = restriction;
        restrict.endOnly = endOnly;
        restrict.elementRect = elementRect;
        return restrict;
    }
}
