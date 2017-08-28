package gwt.material.design.addins.client.image;

import gwt.material.design.addins.client.MaterialAddins;
import gwt.material.design.addins.client.image.constants.Type;
import gwt.material.design.addins.client.image.js.JsCropper;
import gwt.material.design.addins.client.image.js.JsCropperOptions;
import gwt.material.design.addins.client.image.js.JsViewPort;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;

import static gwt.material.design.addins.client.image.js.JsCropper.$;

public class MaterialImageCropper extends MaterialImage {

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
    protected void onLoad() {
        super.onLoad();

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
    }

    protected JsCropperOptions getDefaultOptions() {
        JsCropperOptions options = new JsCropperOptions();

        JsViewPort viewPort = new JsViewPort();
        viewPort.height = 200;
        viewPort.width = 200;
        viewPort.type = "square";

        JsViewPort boundary = new JsViewPort();
        boundary.height = 400;
        boundary.width = 400;
        boundary.type = "square";

        options.viewport = viewPort;
        options.boundary = boundary;
        options.enableZoom = true;
        return options;
    }

    public void crop(Type type) {
        cropper.croppie("result", type.getName()).then((param1, param2) -> {
            String base64 = param1.toString();
            setValue(base64, true);
           return true;
        });
    }
}
