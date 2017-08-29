package gwt.material.design.addins.client.cropper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.cropper.constants.Type;
import gwt.material.design.addins.client.cropper.events.CropEvent;
import gwt.material.design.addins.client.cropper.events.HasCropEvents;
import gwt.material.design.addins.client.cropper.js.JsCropper;
import gwt.material.design.addins.client.cropper.js.JsCropperOptions;
import gwt.material.design.addins.client.cropper.js.JsViewPort;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.jquery.client.api.Functions;

import static gwt.material.design.addins.client.cropper.js.JsCropper.$;

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

    public JsCropperOptions getOptions() {
        return options;
    }

    public void setOptions(JsCropperOptions options) {
        this.options = options;

        reinitialize();
    }

    @Override
    public void reinitialize() {
        destroy();
        initialize();
    }

    protected JsCropperOptions getDefaultOptions() {
        JsCropperOptions options = new JsCropperOptions();

        JsViewPort viewPort = new JsViewPort();
        viewPort.height = 100;
        viewPort.width = 100;
        viewPort.type = "square";

        JsViewPort boundary = new JsViewPort();
        boundary.height = 640;
        boundary.width = 360;
        boundary.type = "square";

        options.viewport = viewPort;
        options.boundary = boundary;
        options.enableZoom = true;
        return options;
    }

    public void crop(String url, Type type) {
        setUrl(url);
        reinitialize();
        cropper.croppie("bind", url).then((result, object) -> {
            crop(type);
            return false;
        });
    }

    public void crop(Type type) {
        cropper.croppie("result", type.getName()).then((param1, param2) -> {
            String result = param1.toString();
            CropEvent.fire(this, result);
           return true;
        });
    }

    public void destroy() {
        if (cropper != null) {
            cropper.croppie("destroy");
        } else {
            GWT.log("Image Cropper component is not attached");
        }
    }

    @Override
    public HandlerRegistration addCropHandler(CropEvent.CropHandler handler) {
        return addHandler(handler, CropEvent.TYPE);
    }
}
