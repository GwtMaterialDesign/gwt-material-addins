/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2022 GwtMaterialDesign
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
package gwt.material.design.incubator.client.viewer.js;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ViewerMethod {

    @JsMethod
    public native void show(boolean fireEvent);

    @JsMethod
    public native void hide(boolean fireEvent);

    @JsMethod
    public native void view(Integer index);

    @JsMethod
    public native void prev(boolean fireEvent);

    @JsMethod
    public native void next(boolean fireEvent);

    @JsMethod
    public native void move(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void moveTo(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void rotate(Integer degree);

    @JsMethod
    public native void rotateTo(Integer degree);

    @JsMethod
    public native void rotateTo(Integer scaleX, Integer scaleY);

    @JsMethod
    public native void scaleX(Integer scaleX);

    @JsMethod
    public native void scaleY(Integer scaleX);

    @JsMethod
    public native void zoom(Integer ratio, boolean hasToolTip);

    @JsMethod
    public native void zoomTo(Integer ratio, boolean hasToolTip);

    @JsMethod
    public native void play(boolean fullScreen);

    @JsMethod
    public native void stop();

    @JsMethod
    public native void full();

    @JsMethod
    public native void exit();

    @JsMethod
    public native void tooltip();

    @JsMethod
    public native void toggle();

    @JsMethod
    public native void reset();

    @JsMethod
    public native void update();

    @JsMethod
    public native void destroy();

}
