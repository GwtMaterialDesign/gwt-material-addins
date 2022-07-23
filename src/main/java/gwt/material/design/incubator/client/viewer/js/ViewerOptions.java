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
package gwt.material.design.incubator.client.viewer.js;

import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import java.util.Arrays;

/**
 * Options for Image Viewer
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class ViewerOptions {

    @JsProperty
    public Integer tapZoomFactor;

    @JsProperty
    public String className;

    @JsProperty
    public String container;

    @JsProperty
    public Functions.FuncRet2<Object, Boolean> filter;

    @JsProperty
    public Boolean fullScreen;

    @JsProperty
    public Arrays inheritedAttributes;

    @JsProperty
    public Integer initialViewIndex;

    @JsProperty
    public Boolean inline;

    @JsProperty
    public Integer interval;

    @JsProperty
    public Boolean keyboard;

    @JsProperty
    public Boolean focus;

    @JsProperty
    public Boolean loading;

    @JsProperty
    public Boolean loop;

    @JsProperty
    public Integer minWidth;

    @JsProperty
    public Integer minHeight;

    @JsProperty
    public Boolean movable;

    @JsProperty
    public Boolean rotatable;

    @JsProperty
    public Boolean scalable;

    @JsProperty
    public Boolean zoomable;

    @JsProperty
    public Boolean zoomOnTouch;

    @JsProperty
    public Boolean zoomOnWheel;

    @JsProperty
    public Boolean slideOnTouch;

    @JsProperty
    public Boolean toggleOnDblclick;

    @JsProperty
    public Boolean tooltip;

    @JsProperty
    public Boolean transition;

    @JsProperty
    public Integer zIndex;

    @JsProperty
    public Integer zIndexInline;

    @JsProperty
    public Integer zoomRatio;

    @JsProperty
    public Integer minZoomRatio;

    @JsProperty
    public Integer maxZoomRatio;

    @JsProperty
    public Functions.FuncRet2<Object, Object> url;

    @JsProperty
    public Functions.Func1 ready;

    @JsProperty
    public Functions.Func1 show;

    @JsProperty
    public Functions.Func1 shown;

    @JsProperty
    public Functions.Func1 hide;

    @JsProperty
    public Functions.Func1 hidden;

    @JsProperty
    public Functions.Func1 view;

    @JsProperty
    public Functions.Func1 viewed;

    @JsProperty
    public Functions.Func1 move;

    @JsProperty
    public Functions.Func1 moved;

    @JsProperty
    public Functions.Func1 rotate;

    @JsProperty
    public Functions.Func1 rotated;

    @JsProperty
    public Functions.Func1 scale;

    @JsProperty
    public Functions.Func1 scaled;

    @JsProperty
    public Functions.Func1 zoomed;

    @JsProperty
    public Functions.Func1 play;

    @JsProperty
    public Functions.Func1 stop;




























}
