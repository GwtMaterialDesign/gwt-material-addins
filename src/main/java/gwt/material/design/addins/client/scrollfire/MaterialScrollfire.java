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
package gwt.material.design.addins.client.scrollfire;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.scrollfire.js.JsScrollfire;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.jquery.client.api.Functions;

import static gwt.material.design.jquery.client.api.JQuery.$;

//@formatter:off

/**
 * Material Scrollfire - executes callback functions depending on how far into the page you've scrolled.
 * <p>
 * <h3>Java Usage:</h3>
 * <p>
 * <pre>
 * {@code
 * // CAN BE CALLED AS A HELPER STATIC CONTEXT
 * MaterialScrollfire.apply(Element e, Runnable runnableCallback);
 *
 * // INSTANTIATE THE PUSHPIN COMPONENT
 * MaterialScrollfire scrollfire = new MaterialScrollfire();
 * scrollfire.setElement(element);
 * scrollfire.setCompleteCallback(callback);
 * scrollfire.setOffset(offset);
 * scrollfire.apply();
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#scrollfire">Material Scrollfire</a>
 */
//@formatter:on
public class MaterialScrollfire {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectDebugJs(MaterialScrollfireDebugClientBundle.INSTANCE.scrollfireDebugJs());
        } else {
            MaterialDesignBase.injectJs(MaterialScrollfireClientBundle.INSTANCE.scrollfireJs());
        }
    }

    private int offset = 100;
    private Element element;
    private Functions.Func callback;

    public MaterialScrollfire() {
    }

    public MaterialScrollfire(Element element) {
        setElement(element);
    }

    /**
     * Executes callback method depending on how far into the page you've scrolled
     */
    public void apply() {
        if (element != null) {
            String uid = DOM.createUniqueId();
            element.setId(uid);
            JsScrollfire.apply("#" + uid, offset, callback::call);
        } else {
            GWT.log("You must set the element before applying the scrollfire", new IllegalStateException());
        }
    }

    /**
     * Executes callback method depending on how far into the page you've scrolled
     *
     * @param element  Target element that is being tracked
     * @param callback The method to be called when the scrollfire is applied
     */
    public static void apply(Element element, Functions.Func callback) {
        apply(element, 100, callback);
    }

    /**
     * Executes callback method depending on how far into the page you've scrolled
     *
     * @param element  Target element that is being tracked
     * @param offset   If this is 0, the callback will be fired when the selector element is at the very bottom of the user's window.
     * @param callback The method to be called when the scrollfire is applied
     */
    public static void apply(Element element, int offset, Functions.Func callback) {
        MaterialScrollfire scrollfire = new MaterialScrollfire();
        scrollfire.setElement(element);
        scrollfire.setCallback(callback);
        scrollfire.setOffset(offset);
        scrollfire.apply();
    }

    /**
     * Executes callback method depending on how far into the page you've scrolled
     */
    public static void apply(String selector, Functions.Func callback) {
        apply($(selector).asElement(), 100, callback);
    }

    /**
     * Get the target element that is being tracked.
     */
    public Element getElement() {
        return element;
    }

    /**
     * Set the target element that is being tracked.
     */
    public void setElement(Element element) {
        this.element = element;
    }

    /**
     * Get the offset value
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Set the offset value
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Get the method to be called when the scrollfire is applied
     */
    public Functions.Func getCallback() {
        return callback;
    }

    /**
     * Set the method to be called when the scrollfire is applied
     */
    public void setCallback(Functions.Func callback) {
        this.callback = callback;
    }
}
