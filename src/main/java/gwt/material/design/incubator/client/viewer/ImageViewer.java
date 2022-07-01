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
package gwt.material.design.incubator.client.viewer;

import com.google.gwt.user.client.Element;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.incubator.client.viewer.js.JsImageViewer;
import gwt.material.design.incubator.client.viewer.js.ViewerMethod;
import gwt.material.design.incubator.client.viewer.js.ViewerOptions;

public class ImageViewer {

    static {
        MaterialDesignBase.injectCss(ImageViewerDebugClientBundle.INSTANCE.viewerCss());
        MaterialDesignBase.injectJs(ImageViewerDebugClientBundle.INSTANCE.viewerJs());
    }

    protected JsImageViewer viewer;
    protected ViewerOptions options = new ViewerOptions();
    protected ViewerMethod methods = new ViewerMethod();
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

    public ViewerMethod getMethods() {
        return methods;
    }

    public void setMethods(ViewerMethod methods) {
        this.methods = methods;
    }
}
