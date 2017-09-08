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
 *
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
 */
//@formatter:on
public class MaterialImageCropper extends MaterialImage implements HasCropEvents {

    static {
        if (MaterialAddins.isDebug()) {
            MaterialDesignBase.injectCss(MaterialImageCropperDebugClientBundle.INSTANCE.imageCropperDebugCss());
            MaterialDesignBase.injectDebugJs(MaterialImageCropperDebugClientBundle.INSTANCE.imageCropperDebugJs());
        } else {
            MaterialDesignBase.injectCss(MaterialImageCropperClientBundle.INSTANCE.imageCropperCss());
            MaterialDesignBase.injectJs(MaterialImageCropperClientBundle.INSTANCE.imageCropperJs());
        }
    }

    private JsCropperOptions options;
    private JsCropper cropper;

    @Override
    protected void initialize() {
        if (options == null) {
            options = getDefaultOptions();
        }

        cropper = $(getElement()).croppie(options);
    }

    /**
     * Get the options of the cropper
     * Defaults to {@link #getDefaultOptions}
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

        reinitialize();
    }

    @Override
    public void reinitialize() {
        destroy();
        initialize();
    }

    /**
     * Get the default option for the Cropper
     */
    protected JsCropperOptions getDefaultOptions() {
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

    /**
     * Cropped the image with given URL and result type
     */
    public void crop(String url, Type type) {
        setUrl(url);
        reinitialize();
        bind(url, () -> crop(type));
    }

    /**
     * Bind an image the cropper. Returns a promise to be resolved when the image has been loaded and the cropper has been initialized.
     * @param url - URL to Image
     * @param callback - Callback when the Promise has been resolved.
     */
    public void bind(String url, Functions.Func callback) {
        cropper.croppie("bind", url).then((result, object) -> {
            callback.call();
            return true;
        });
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

    /**
     * Rotate the image by a specified degree amount. Only works with enableOrientation option enabled see {@link JsCropperOptions#enableOrientation}.
     * @param degrees - Valid values 90, 180, 270, -90, -180, -270
     */
    public void rotate(int degrees) {
        cropper.croppie("rotate", degrees);
    }

    /**
     * Set the zoom of a Cropper instance. The value passed in is still restricted to the min/max set by Cropper
     * @param value - a floating point to scale the image within the Cropper. Must be between a min and max value set by Cropper.
     */
    public void setZoom(int value) {
        cropper.croppie("setZoom", value);
    }

    @Override
    public HandlerRegistration addCropHandler(CropEvent.CropHandler handler) {
        return addHandler(handler, CropEvent.TYPE);
    }
}
