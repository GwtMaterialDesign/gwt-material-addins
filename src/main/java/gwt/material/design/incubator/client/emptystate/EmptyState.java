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
package gwt.material.design.incubator.client.emptystate;

import com.google.gwt.resources.client.ImageResource;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.incubator.client.AddinsIncubator;
import gwt.material.design.incubator.client.base.constants.IncubatorCssName;

public class EmptyState extends MaterialPanel {

    static {
        if (AddinsIncubator.isDebug()) {
            MaterialDesignBase.injectCss(EmptyStateDebugClientBundle.INSTANCE.emptyStateDebugCss());
        } else {
            MaterialDesignBase.injectCss(EmptyStateClientBundle.INSTANCE.emptyStateCss());
        }
    }

    private MaterialImage image = new MaterialImage();
    private MaterialLabel lblTitle = new MaterialLabel();
    private MaterialLabel lblDescription = new MaterialLabel();

    public EmptyState() {
        super();
        setInitialClasses(IncubatorCssName.EMPTY_STATE);
    }

    @Override
    protected void onLoad() {
        super.onLoad();

        add(image);
        add(lblTitle);
        add(lblDescription);
    }

    @Override
    public String getTitle() {
        return lblTitle.getText();
    }

    @Override
    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public String getDescription() {
        return lblDescription.getText();
    }

    public void setDescription(String description) {
        lblDescription.setText(description);
    }

    public ImageResource getResource() {
        return image.getResource();
    }

    public void setResource(ImageResource resource) {
        image.setResource(resource);
    }

    public String getUrl() {
        return image.getUrl();
    }

    public void setUrl(String url) {
        image.setUrl(url);
    }

    public MaterialImage getImage() {
        return image;
    }
}
