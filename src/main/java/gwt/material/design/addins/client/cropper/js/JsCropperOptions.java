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
package gwt.material.design.addins.client.cropper.js;

import gwt.material.design.addins.client.cropper.constants.Shape;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JsCopper JsInterop Options
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class JsCropperOptions {

    private JsCropperOptions() {}

    @JsOverlay
    public static final JsCropperOptions create() {
        JsCropperOptions options = new JsCropperOptions();

        JsCropperDimension viewPort = new JsCropperDimension();
        viewPort.height = 100;
        viewPort.width = 100;
        viewPort.type = Shape.SQUARE.getName();

        JsCropperDimension boundary = new JsCropperDimension();
        boundary.height = 200;
        boundary.width = 200;
        boundary.type = Shape.SQUARE.getName();

        options.viewport = viewPort;
        options.boundary = boundary;
        options.enableZoom = true;
        options.enableOrientation = true;
        options.mouseWheelZoom = true;
        options.showZoomer = true;

        return options;
    }

    /**
     * The outer container of the cropper.
     */
    @JsProperty
    public JsCropperDimension boundary;

    /**
     * The inner container of the cropper. The visible part of the image
     */
    @JsProperty
    public JsCropperDimension viewport;

    /**
     * A class of your choosing to add to the container to add custom styles to your cropper
     */
    @JsProperty
    public String customClass;

    /**
     * Enable or disable support for specifying a custom orientation when binding images.
     */
    @JsProperty
    public boolean enableOrientation;

    /**
     * Enable zooming functionality. If set to false - scrolling and pinching would not zoom.
     */
    @JsProperty
    public boolean enableZoom;

    /**
     * Restricts zoom so image cannot be smaller than viewport
     */
    @JsProperty
    public boolean enforceBoundary;

    /**
     * Enable or disable the ability to use the mouse wheel to zoom in and out on a cropper instance
     */
    @JsProperty
    public boolean mouseWheelZoom;

    /**
     * Hide or Show the zoom slider
     */
    @JsProperty
    public boolean showZoomer;
}
