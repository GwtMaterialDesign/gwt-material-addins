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
package gwt.material.design.addins.client.moment.option;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class RelativeTime {

    @JsProperty
    public Object future;

    @JsProperty
    public Object past;

    @JsProperty
    public Object s;

    @JsProperty
    public Object ss;

    @JsProperty
    public Object m;

    @JsProperty
    public Object mm;

    @JsProperty
    public Object h;

    @JsProperty
    public Object hh;

    @JsProperty
    public Object d;

    @JsProperty
    public Object dd;

    @JsProperty
    public Object w;

    @JsProperty
    public Object ww;

    @JsProperty
    public Object M;

    @JsProperty
    public Object MM;

    @JsProperty
    public Object y;

    @JsProperty
    public Object yy;
}

