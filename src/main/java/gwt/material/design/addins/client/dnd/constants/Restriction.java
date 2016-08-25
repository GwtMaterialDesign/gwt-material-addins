package gwt.material.design.addins.client.dnd.constants;

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


/**
 * Drags, resizes and gestures can be restricted to a certain area. By default,
 * restricting is relative to the pointer coordinates – the action coordinates,
 * not the element’s dimensions, will be kept within the restriction area.
 * @see <a href="http://interactjs.io/docs/restriction/#restrict">Documentation</a>
 * @author kevzlou7979
 */
public class Restriction {

    public enum Restrict {
        PARENT("parent"),
        SELF("self");

        String value;

        Restrict(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private Restrict restriction = Restrict.PARENT;
    private boolean endOnly = true;
    private double top = 0;
    private double left = 0;
    private double right = 1;
    private double bottom = 1;

    public Restriction() {}

    public Restriction(Restrict restriction, boolean endOnly, double top, double left, double bottom, double right) {
        this.restriction = restriction;
        this.endOnly = endOnly;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Restrict getRestriction() {
        return restriction;
    }

    /**
     * This constant value specifies the area that the action will be confined to.
     * 'self' – restrict to the target element’s rect
     * 'parent' – restrict to the rect of the element’s parentNode or
     * a CSS selector string – if one of the parents of the target element matches
     * this selector, it’s rect will be used as the restriction area.
     * @see <a href="http://interactjs.io/docs/restriction/#restriction">Documentation</a>
     */
    public void setRestriction(Restrict restriction) {
        this.restriction = restriction;
    }

    public boolean isEndOnly() {
        return endOnly;
    }

    /**
     * The endOnly option is used to restrict just before the end of a drag or resize.
     * Before the end event is fired, an extra <action>move event is restricted and fired.
     * If inertia is enabled and endOnly is set to true then the pointer will follow a curve
     * to the restricted coordinates.
     * @see <a href="http://interactjs.io/docs/restriction/#endonly">Documentation</a>
     */
    public void setEndOnly(boolean endOnly) {
        this.endOnly = endOnly;
    }

    public double getTop() {
        return top;
    }

    /**
     * Top restriction of the element being allowed to hang over the restriction edges.
     * @see <a href="http://interactjs.io/docs/restriction/#elementrect">Documentation</a>
     */
    public void setTop(double top) {
        this.top = top;
    }

    public double getRight() {
        return right;
    }

    /**
     * Right restriction of the element being allowed to hang over the restriction edges.
     * @see <a href="http://interactjs.io/docs/restriction/#elementrect">Documentation</a>
     */
    public void setRight(double right) {
        this.right = right;
    }

    public double getBottom() {
        return bottom;
    }

    /**
     * Bottom restriction of the element being allowed to hang over the restriction edges.
     * @see <a href="http://interactjs.io/docs/restriction/#elementrect">Documentation</a>
     */
    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getLeft() {
        return left;
    }

    /**
     * Left restriction of the element being allowed to hang over the restriction edges.
     * @see <a href="http://interactjs.io/docs/restriction/#elementrect">Documentation</a>
     */
    public void setLeft(double left) {
        this.left = left;
    }
}
