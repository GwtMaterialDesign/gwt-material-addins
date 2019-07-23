/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
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
package gwt.material.design.addins.client.dnd.event;

import com.google.gwt.dom.client.Element;
import gwt.material.design.jquery.client.api.Event;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Date;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class InteractCommonEvent extends Event {

    public InteractCommonEvent(String type) {
        super(type);
    }

    /**
     * The element that is being interacted with
     */
    @JsProperty
    public Element target;

    /**
     * The Interactable that is being interacted with
     */
    @JsProperty
    public Object interactable;

    /**
     * The Interaction that the event belongs to
     */
    @JsProperty
    public Object interaction;

    /**
     * Page x coordinate of the starting event
     */
    @JsProperty
    public float x0;

    /**
     * Page y coordinate of the starting event
     */
    @JsProperty
    public float y0;

    /**
     * Client x coordinate of the starting event
     */
    @JsProperty
    public float clientX0;

    /**
     * Client y coordinate of the starting event
     */
    @JsProperty
    public float clientY0;

    /**
     * Change in coordinates of the mouse/touch
     */
    @JsProperty
    public float dx;

    /**
     * Change in coordinates of the mouse/touch
     */
    @JsProperty
    public float dy;

    /**
     * The Velocity of the pointer
     */
    @JsProperty
    public float velocityX;

    /**
     * The Velocity of the pointer
     */
    @JsProperty
    public float velocityY;

    /**
     * The speed of the pointer
     */
    @JsProperty
    public double speed;

    /**
     * The time of creation of the event object
     */
    @JsProperty
    public Date timeStamp;
}
