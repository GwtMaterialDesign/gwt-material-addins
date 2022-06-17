package gwt.material.design.incubator.client.viewer;

import com.google.gwt.user.client.Element;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.incubator.client.viewer.js.JsImageViewer;
import gwt.material.design.incubator.client.viewer.js.ViewerOptions;

public class ImageViewer {

    static {
        MaterialDesignBase.injectCss(ImageViewerDebugClientBundle.INSTANCE.viewerCss());
        MaterialDesignBase.injectJs(ImageViewerDebugClientBundle.INSTANCE.viewerJs());
    }

    protected JsImageViewer viewer;
    protected ViewerOptions options = new ViewerOptions();
    protected MaterialImage image = new MaterialImage();

    public ImageViewer() {
    }

    public void load(Element element) {
        viewer = new JsImageViewer(element, options);
    }

    public void destroy() {
        viewer.destroy();
    }

    public void update() {
        viewer.update();
    }

    public ViewerOptions getOptions() {
        return options;
    }

    public void setOptions(ViewerOptions options) {
        this.options = options;
    }
}
