/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2023 GwtMaterialDesign
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
package gwt.material.design.addins.client.sprout.js;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ReadyData {

    /**
     * The duration of the video in seconds.
     */
    @JsProperty
    public int duration;

    /**
     * The unique identifier for the current viewer.
     */
    @JsProperty
    public String viewerId;

    /**
     * The unique identifier for the current playback session.
     */
    @JsProperty
    public String sessionId;

    /**
     * The email address entered if the video requires an email address in ordered to be played.
     */
    @JsProperty
    public String email;

    /**
     * The first name entered if the video requires a name in ordered to be played.
     */
    @JsProperty
    public String vfname;

    /**
     * The last name entered if the video requires a name in ordered to be played.
     */
    @JsProperty
    public String vlname;
}
