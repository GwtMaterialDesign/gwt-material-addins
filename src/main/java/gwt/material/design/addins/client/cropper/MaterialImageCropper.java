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
package gwt.material.design.addins.client.cropper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.cropper.constants.Shape;
import gwt.material.design.addins.client.cropper.constants.Type;
import gwt.material.design.addins.client.cropper.events.CropEvent;
import gwt.material.design.addins.client.cropper.events.HasCropEvents;
import gwt.material.design.addins.client.cropper.js.JsCropper;
import gwt.material.design.addins.client.cropper.js.JsCropperDimension;
import gwt.material.design.addins.client.cropper.js.JsCropperOptions;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.JsLoader;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.jquery.client.api.Functions;

import static gwt.material.design.addins.client.cropper.js.JsCropper.$;

//@formatter:off

/**
 * A simple Image Cropping addin component.
 * <h3>XML Namespace Declaration</h3>
 * <pre>
 * {@code xmlns:ma='urn:import:gwt.material.design.addins.client'}
 * </pre>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <pre>
 * {@code <ma:cropper.MaterialImageCropper ui:field="cropper" url="some.png" />}
 *
 * <h3>Java Usage:</h3>
 * <pre>
 * {@code cropper.addCropHandler(event -> MaterialToast.fireToast(event.getResult()));
 *   cropper.crop();
 * }
 * </pre>
 *
 * @author kevzlou7979
 * @see <a href="http://gwtmaterialdesign.github.io/gwt-material-demo/#imageCropper">Material Image Cropper</a>
 * @see <a href="https://github.com/Foliotek/Croppie">Croppie 2.5.0</a>
 */
//@formatter:on
public class MaterialImageCropper extends MaterialImage implements JsLoader, HasCropEvents {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialImageCropperDebugClientBundle.INSTANCE.imageCropperDebugCss());
            MaterialDesignBase.injectDebugJs(MaterialImageCropperDebugClientBundle.INSTANCE.imageCropperDebugJs());
        } else {
            MaterialDesignBase.injectCss(MaterialImageCropperClientBundle.INSTANCE.imageCropperCss());
            MaterialDesignBase.injectJs(MaterialImageCropperClientBundle.INSTANCE.imageCropperJs());
        }
    }

    private JsCropperOptions options = JsCropperOptions.create();
    private JsCropper cropper;

    /**
     * Get the options of the cropper
     *
     * @return
     */
    public JsCropperOptions getOptions() {
        return options;
    }

    /**
     * Set the options of the cropper
     * See {@link JsCropperOptions} for more details.
     */
    public void setOptions(JsCropperOptions options) {
        this.options = options;
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        load();
    }

    @Override
    public void load() {
        cropper = $(getElement()).croppie(options);
    }

    @Override
    protected void onUnload() {
        super.onUnload();

        unload();
    }

    @Override
    public void unload() {
        destroy();
    }

    /**
     * Destroy the cropper instance and remove it from the DOM
     */
    public void destroy() {
        if (cropper != null) {
            cropper.croppie("destroy");
        } else {
            GWT.log("Image Cropper component is not attached");
        }
    }

    @Override
    public void reload() {
        unload();
        load();
    }

    /**
     * Cropped the image with given URL and result type
     */
    public void crop(String url, Type type) {
        setUrl(url);
        bind(url, () -> crop(type));
    }

    /**
     * Bind an image the cropper. Returns a promise to be resolved when the image has been loaded and the cropper has been initialized.
     *
     * @param url      - URL to Image
     * @param callback - Callback when the Promise has been resolved.
     */
    public void bind(String url, Functions.Func callback) {
        cropper.croppie("bind", url).then((result, object) -> {
            callback.call();
            return true;
        });
    }

    /**
     * Rotate the image by a specified degree amount. Only works with enableOrientation option enabled see {@link JsCropperOptions#enableOrientation}.
     *
     * @param degrees - Valid values 90, 180, 270, -90, -180, -270
     */
    public void rotate(int degrees) {
        cropper.croppie("rotate", degrees);
    }

    /**
     * Set the zoom of a Cropper instance. The value passed in is still restricted to the min/max set by Cropper
     *
     * @param value - a floating point to scale the image within the Cropper. Must be between a min and max value set by Cropper.
     */
    public void setZoom(int value) {
        cropper.croppie("setZoom", value);
    }

    /**
     * Cropped the image with {@link Type#BASE64} as the default result type.
     */
    public void crop() {
        crop(Type.BASE64);
    }

    /**
     * Cropped the image with give result type.
     * Make sure you are registering the cropevent which returns
     * the Result Cropped Data.
     */
    public void crop(Type type) {
        cropper.croppie("result", type.getName()).then((result) -> {
            CropEvent.fire(this, result.toString());
            return true;
        });
    }

    public JsCropperDimension getBoundary() {
        return options.boundary;
    }

    /**
     * The outer container of the cropper.
     */
    public void setBoundary(JsCropperDimension boundary) {
        options.boundary = boundary;
    }

    public JsCropperDimension getViewPort() {
        return options.viewport;
    }

    /**
     * The inner container of the cropper. The visible part of the image
     */
    public void setViewport(JsCropperDimension viewport) {
        options.viewport = viewport;
    }

    public String getCustomClass() {
        return options.customClass;
    }

    /**
     * A class of your choosing to add to the container to add custom styles to your cropper
     */
    public void setCustomClass(String customClass) {
        options.customClass = customClass;
    }

    public boolean isEnableOrientation() {
        return options.enableOrientation;
    }

    /**
     * Enable or disable support for specifying a custom orientation when binding images.
     */
    public void setEnableOrientation(boolean enableOrientation) {
        options.enableOrientation = enableOrientation;
    }

    public boolean isEnableZoom() {
        return options.enableZoom;
    }

    /**
     * Enable zooming functionality. If set to false - scrolling and pinching would not zoom.
     */
    public void setEnableZoom(boolean enableZoom) {
        options.enableZoom = enableZoom;
    }

    public boolean isEnableResize() {
        return options.enableResize;
    }

    /**
     * Provides the ability to resize your viewport target
     */
    public void setEnableResize(boolean enableResize) {
        options.enableResize = enableResize;
    }

    public boolean isEnforceBoundary() {
        return options.enforceBoundary;
    }

    /**
     * Restricts zoom so image cannot be smaller than viewport
     */
    public void setEnforceBoundary(boolean enforceBoundary) {
        options.enforceBoundary = enforceBoundary;
    }

    public boolean isMouseWheelZoom() {
        return options.mouseWheelZoom;
    }

    /**
     * Enable or disable the ability to use the mouse wheel to zoom in and out on a cropper instance
     */
    public void setMouseWheelZoom(boolean mouseWheelZoom) {
        options.mouseWheelZoom = mouseWheelZoom;
    }

    public boolean isShowZoomer() {
        return options.showZoomer;
    }

    public Shape getShape() {
        return getViewPort().type != null ? Shape.fromStyleName(options.viewport.type) : null;
    }

    public void setShape(Shape shape) {
        getViewPort().type = shape.getCssName();
    }

    /**
     * Hide or Show the zoom slider
     */
    public void setShowZoomer(boolean showZoomer) {
        options.showZoomer = showZoomer;
    }

    @Override
    public HandlerRegistration addCropHandler(CropEvent.CropHandler handler) {
        return addHandler(handler, CropEvent.TYPE);
    }
}
