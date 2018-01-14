/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.js;

import gwt.material.design.jscore.client.api.core.Element;
import jsinterop.annotations.JsProperty;

/**
 * Pin Settings set in {@link Scene#setPin(Element, PinSettings)}
 *
 * @author kevzlou7979@gmail.com
 * @see <a href="http://scrollmagic.io/docs/ScrollMagic.Scene.html#setPin">Official Documentation</a>
 */
public class PinSettings {

    /**
     * If true following elements will be "pushed" down for the duration of the pin, if false the pinned element will
     * just scroll past them. Ignored, when duration is 0. Default to true
     */
    @JsProperty
    public boolean pushFollowers;

    /**
     * Classname of the pin spacer element, which is used to replace the element. Default to "scrollmagic-pin-spacer"
     */
    @JsProperty
    public String spacerClass;
}
