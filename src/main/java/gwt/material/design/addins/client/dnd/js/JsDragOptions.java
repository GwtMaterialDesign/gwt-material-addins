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

import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.client.constants.Axis;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Options for dnd component.
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsDragOptions {

    @JsProperty
    public boolean inertia;

    @JsProperty
    public String axis;

    @JsProperty
    public JsDragRestrictions restrict;

    @JsOverlay
    public static JsDragOptions create() {
        return create(true, null, new Restriction());
    }

    @JsOverlay
    public static JsDragOptions create(Restriction restriction) {
        return create(true, null, restriction);
    }

    @JsOverlay
    public static JsDragOptions create(boolean inertia) {
        return create(inertia, null, new Restriction());
    }

    @JsOverlay
    public static JsDragOptions create(Axis axis) {
        return create(true, axis, new Restriction());
    }

    @JsOverlay
    public static JsDragOptions create(boolean inertia, Axis axis, Restriction restriction) {
        JsDragOptions options = new JsDragOptions();
        options.inertia = inertia;
        if (axis != null) {
            if (axis.equals(Axis.HORIZONTAL)) {
                options.axis = "x";
            } else {
                options.axis = "y";
            }
        }

        // Restrict Options
        JsDragRestrictions restrict = new JsDragRestrictions();
        if (restriction != null) {
            restrict.restriction = restriction.getRestriction();
            restrict.endOnly = restriction.isEndOnly();

            // Element Rec Options
            JsDragElementRect elementRect = new JsDragElementRect();
            elementRect.top = restriction.getTop();
            elementRect.left = restriction.getLeft();
            elementRect.bottom = restriction.getBottom();
            elementRect.right = restriction.getRight();
            restrict.elementRect = elementRect;
        }
        options.restrict = restrict;

        return options;
    }
}
