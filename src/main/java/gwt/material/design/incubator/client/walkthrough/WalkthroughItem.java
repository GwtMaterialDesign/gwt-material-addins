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
package gwt.material.design.incubator.client.walkthrough;

import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.incubator.client.base.IncubatorWidget;

/**
 * A predefined {@link Walkthrough} item which includes the setting of
 * {@link #setTitle(String)}, {@link #setDescription(String)} & {@link #setImageUrl(String)}
 *
 * @author kevzlou7979
 */
public class WalkthroughItem extends MaterialRow {

    private String imageUrl;
    private String title;
    private String description;
    private boolean animated;

    private MaterialImage image = new MaterialImage();
    private MaterialColumn content = new MaterialColumn();
    private MaterialLabel titleLabel = new MaterialLabel();
    private MaterialLabel descriptionLabel = new MaterialLabel();

    @Override
    protected void onLoad() {
        super.onLoad();

        IncubatorWidget.showWarning(this);
        image.setUrl(getImageUrl());
        add(image);

        content.setGrid("s12 m6 l12");
        content.setMarginTop(40);
        add(content);

        titleLabel.setText(getTitle());
        titleLabel.setFontSize("1.2em");
        content.add(titleLabel);

        descriptionLabel.setText(getDescription());
        descriptionLabel.setFontSize("0.8em");
        content.add(descriptionLabel);

        image.setOpacity(0);
        titleLabel.setOpacity(0);
        descriptionLabel.setOpacity(0);
    }

    public void animate() {
        if (!animated) {
            new MaterialAnimation().transition(Transition.FADEIN).delay(0).duration(600).animate(image, () -> {
                image.setOpacity(1);
                titleLabel.setOpacity(1);
                descriptionLabel.setOpacity(1);
                new MaterialAnimation().transition(Transition.SLIDEINRIGHT).animate(titleLabel);
                new MaterialAnimation().transition(Transition.SLIDEINRIGHT).animate(descriptionLabel);
            });

            animated = true;
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
